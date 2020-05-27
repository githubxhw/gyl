package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.*;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.IXsckdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("xsckdServiceImpl")
public class XsckdServiceImpl implements IXsckdService {

    @Autowired
    @Qualifier("iXsckd_zhubDao")
    private IXsckd_zhubDao iXsckd_zhubDao = null;

    @Autowired
    @Qualifier("iXsckd_zibDao")
    private IXsckd_zibDao iXsckd_zibDao = null;

    @Autowired
    @Qualifier("iXsdd_zhubDao")
    private IXsdd_zhubDao iXsdd_zhubDao = null;

    @Autowired
    @Qualifier("iXsdd_zibDao")
    private IXsdd_zibDao iXsdd_zibDao = null;

    @Autowired
    @Qualifier("iXsfhd_zhubDao")
    private IXsfhd_zhubDao iXsfhd_zhubDao = null;

    @Autowired
    @Qualifier("iXsfhd_zibDao")
    private IXsfhd_zibDao iXsfhd_zibDao = null;

    @Override
    public List<Xsckd_zhub> findZhubByMany(Xsckd_zhub xsckd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsckd_zhub> handler = new DomainAttrValueConverterUtils<>(xsckd_zhub);
        Xsckd_zhub x = handler.handler(null, "sfsh", "shsftg", "sfth", "status");
        List<Xsckd_zhub> xsckd_zhubs = iXsckd_zhubDao.findByMany(x);
        return xsckd_zhubs;
    }

    @Override
    public List<Xsckd_zib> findZibsByZhubId(Integer xsckd_zhub_id) throws Exception {
        List<Xsckd_zib> xsckd_zibs = iXsckd_zibDao.findByZhubId(xsckd_zhub_id);
        return xsckd_zibs;
    }

    @Override
    public PageInfo saveZhubAndZib(Xsckd_zhub xsckd_zhub) throws Exception {
        /**验证是否添加
         * 遍历所有子表
         * (1)对应源头订单:销售订单
         *  1，根据源头订单号查询销售订单主表
         *      1.1 没有此销售订单主表
         *      1.2 有此表，但是属性status已经结束 1 ------>错误，不要
         *      1.3 有此表，属性status没有结束 0，但是属性ckbz出库结束标志已经结束 1
         *  2，根据销售订单主表id和行号查询出对应的子表
         *      2.1 没有此销售订单子表
         *      2.2 有此表，但是属性status已经结束 1 ------>错误，不要
         *      2.3 有此表，属性status没有结束 0，但是属性sfckgb是否出库结束 1
         *      2.4 有此表，属性status没有结束 0，属性sfckgb是否出库未结束 0，但是商品编码不对
         *
         * (2)对应来源订单:销售发货单
         *  1，根据来源订单号查询对应的销售发货单主表
         *      1.1 没有此销售发货单主表
         *      1.2 有此表，但是sfckjs出库结束 1
         *  2，根据销售发货单主表id和来源行号查询出对应的发货单子表
         *      2.1 没有此销售发货单子表
         *      2.2 有此表，但是sfckjs已经结束 1
         *      2.3 有此表，sfckjs未结束 0，但是商品编码不对
         *      2.4 有此表，sfckjs未结束 0，商品编码对，但是(销售出库单xsckd_zib中的yfsl应发数量) != (销售发货单中的sfsl实发数量)
         *
         */
        PageInfo pageInfo = new PageInfo();//返回到页面的信息
        pageInfo.setResFlag("1");

        List<Xsckd_zib> xsckd_zibs = xsckd_zhub.getXsckd_zibs();
        if (xsckd_zibs == null) { //没有子表，直接添加即可
            iXsckd_zhubDao.save(xsckd_zhub);
            pageInfo.setResFlag("1");
        } else { //有子表,验证是否添加
            for (Xsckd_zib xsckd_zib : xsckd_zibs) {
                if (xsckd_zib.getSpbm() != null && !"".equals(xsckd_zib.getSpbm())) {
                    Integer hh = xsckd_zib.getHh();
                    String ytdjh = xsckd_zib.getYtdjh();//源头单据号
                    Integer ythh = xsckd_zib.getYthh();//源头行号

                    //(1)对应源头订单:销售订单
                    //1，根据源头订单号查询销售订单主表
                    Xsdd_zhub byDdh = iXsdd_zhubDao.findByDdh(ytdjh);
                    if (byDdh == null) { //1.1 没有此销售订单主表
                        pageInfo.setResFlag("0");
                        pageInfo.add("行号为" + hh + "时：在销售订单中没有对应的销售订单-主表！");
                        break;
                    } else {
                        if (byDdh.getStatus() == 1) {//1.2 有此表，但是属性status已经结束 1
                            pageInfo.setResFlag("0");
                            pageInfo.add("行号为" + hh + "时：对应的销售订单（主表）的单据状态已经结束！");
                            break;
                        } else {
                            if (byDdh.getCkbz() == 1) {//1.3 有此表，属性status没有结束 0，但是属性ckbz出库结束标志已经结束 1
                                pageInfo.setResFlag("0");
                                pageInfo.add("行号为" + hh + "时：对应的销售订单（主表）的出库（状态）已经结束！");
                                break;
                            } else { //2，根据销售订单主表id和行号查询出对应的子表
                                Integer xsdd_zhub_id = byDdh.getXsdd_zhub_id(); //销售订单主表id
                                Xsdd_zib byZhubIdAndHh = iXsdd_zibDao.findByZhubIdAndHh(xsdd_zhub_id, ythh); //销售订单子表

                                if (byZhubIdAndHh == null) {//2.1 没有此销售订单子表
                                    pageInfo.setResFlag("0");
                                    pageInfo.add("行号为" + hh + "时：在销售订单中没有对应的销售订单-子表！");
                                    break;
                                } else {
                                    if (byZhubIdAndHh.getStatus() == 1) {//2.2 有此表，但是属性status已经结束 1
                                        pageInfo.setResFlag("0");
                                        pageInfo.add("行号为" + hh + "时：对应的销售订单（子表）的单据状态已经结束！");
                                        break;
                                    } else {
                                        if (byZhubIdAndHh.getSfckgb() == 1) { //2.3 有此表，属性status没有结束 0，但是属性sfckgb是否出库结束 1
                                            pageInfo.setResFlag("0");
                                            pageInfo.add("行号为" + hh + "时：对应的销售订单（子表）的出库（状态）已经结束！");
                                            break;
                                        } else {
                                            if (!byZhubIdAndHh.getSpbm().equals(xsckd_zib.getSpbm())) {//2.4 有此表，属性status没有结束 0，属性sfckgb是否出库未结束 0，但是商品编码不对
                                                pageInfo.setResFlag("0");
                                                pageInfo.add("行号为" + hh + "时：对应的销售订单（子表）的商品编码有错！");
                                                break;
                                            } else {
                                                //(2)对应来源订单:销售发货单
                                                String lydjh = xsckd_zib.getLydjh();//来源单据号-》销售发货单的单据号
                                                Integer lyhh = xsckd_zib.getLyhh();//来源行号-》销售发货单的行号

                                                //1，根据来源订单号查询对应的销售发货单主表
                                                Xsfhd_zhub byDdh1 = iXsfhd_zhubDao.findByDdh(lydjh);
                                                if (byDdh1 == null) {
                                                    pageInfo.setResFlag("0");
                                                    pageInfo.add("行号为" + hh + "时：在发货单中没有对应的发货单-主表！");
                                                    break;
                                                } else {
                                                    if (byDdh1.getSfckjs() == 1) {//1.2 有此表，但是sfckjs出库结束 1
                                                        pageInfo.setResFlag("0");
                                                        pageInfo.add("行号为" + hh + "时：对应的发货单（主表）的出库（状态）已经结束！");
                                                        break;
                                                    } else {
                                                        //2，根据销售发货单主表id和来源行号查询出对应的发货单子表
                                                        Integer xsfhd_zhub_id = byDdh1.getXsfhd_zhub_id();//销售发货单主表id
                                                        Xsfhd_zib xsfhd_zib = iXsfhd_zibDao.findByZhubIdAndHh(xsfhd_zhub_id, lyhh);
                                                        if (xsfhd_zib == null) {//2.1 没有此销售订单子表
                                                            pageInfo.setResFlag("0");
                                                            pageInfo.add("行号为" + hh + "时：在发货单中没有对应的发货单-子表！");
                                                            break;
                                                        } else {
                                                            if (xsfhd_zib.getSfckjs() == 1) {//2.2 有此表，但是sfckjs已经结束 1
                                                                pageInfo.setResFlag("0");
                                                                pageInfo.add("行号为" + hh + "时：对应的发货单（子表）的出库（状态）已经结束！");
                                                                break;
                                                            } else {
                                                                if (!xsfhd_zib.getSpbm().equals(xsckd_zib.getSpbm())) {//2.3 有此表，sfckjs未结束 0，但是商品编码不对
                                                                    pageInfo.setResFlag("0");
                                                                    pageInfo.add("行号为" + hh + "时：对应的发货单（子表）的商品编码有错！");
                                                                    break;
                                                                } else {
                                                                    if (xsfhd_zib.getSfsl() != xsckd_zib.getYfsl()) {//2.4 有此表，sfckjs未结束 0，商品编码对，但是(销售出库单xsckd_zib中的yfsl应发数量) != (销售发货单中的sfsl实发数量)
                                                                        pageInfo.setResFlag("0");
                                                                        pageInfo.add("行号为" + hh + "时：销售出库单的应发数量不等于对应的发货单的实发数量！");
                                                                        break;
                                                                    } else {//合理
                                                                        // System.out.println("合理+1");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            String resFlag = pageInfo.getResFlag();
            if ("1".equals(resFlag)) {//合理，就添加
                //先添加主表
                iXsckd_zhubDao.save(xsckd_zhub);
                Xsckd_zhub xsckd_zhub1 = iXsckd_zhubDao.findByDjh(xsckd_zhub.getDjh());//根据单据号查询主表信息
                Integer xsckd_zhub_id = xsckd_zhub1.getXsckd_zhub_id();//出库单id

                //然后添加子表s
                for (Xsckd_zib xsckd_zib : xsckd_zibs) {
                    if (xsckd_zib.getSpbm() != null && !"".equals(xsckd_zib.getSpbm())) {
                        //查询（销售发货单子表）中（累计出库数量）
                        Xsfhd_zhub byDdh1 = iXsfhd_zhubDao.findByDdh(xsckd_zib.getLydjh());
                        Xsfhd_zib byZhubIdAndHh1 = iXsfhd_zibDao.findByZhubIdAndHh(byDdh1.getXsfhd_zhub_id(), xsckd_zib.getLyhh());
                        Long ljcksl1 = byZhubIdAndHh1.getLjcksl();
                        xsckd_zib.setXsckd_zhub_id(xsckd_zhub_id);//设置外键
                        xsckd_zib.setLjcksl(ljcksl1);//设置累计出库数量
                        iXsckd_zibDao.save(xsckd_zib);
                    }
                }
            }
        }
        return pageInfo;
    }

    @Override
    public List<Xsckd_zhub> findAllAndNotSh(Xsckd_zhub xsckd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsckd_zhub> handler = new DomainAttrValueConverterUtils<>(xsckd_zhub);
        Xsckd_zhub x = handler.handler(null, "sfsh", "shsftg", "sfth", "status");
        List<Xsckd_zhub> xsckd_zhubs = iXsckd_zhubDao.findAllAndNotSh(x);
        return xsckd_zhubs;
    }

    @Override
    public Xsckd_zhub findXsckd_zhubById(Integer xsckd_zhub_id) throws Exception {
        Xsckd_zhub xsckd_zhub = iXsckd_zhubDao.findById(xsckd_zhub_id);
        return xsckd_zhub;
    }

    @Override
    public void updateXsckd_zhubById(Xsckd_zhub xsckd_zhub) throws Exception {
        iXsckd_zhubDao.updateById(xsckd_zhub);
    }

    @Override
    public void deleteXsckd_zhubById(Integer xsckd_zhub_id) throws Exception {
        iXsckd_zhubDao.deleteById(xsckd_zhub_id);
    }

    @Override
    public void deleteXsckd_ZhubByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer id : integers) {
            if (id != null) {
                iXsckd_zhubDao.deleteById(id);
            }
        }
    }

    @Override
    public Xsckd_zib findXsckd_zibById(Integer xsckd_zib_id) throws Exception {
        Xsckd_zib xsckd_zib = iXsckd_zibDao.findById(xsckd_zib_id);
        return xsckd_zib;
    }

    @Override
    public void updateXsckd_zibById(Xsckd_zib xsckd_zib) throws Exception {
        iXsckd_zibDao.updateById(xsckd_zib);
        return;
    }

    @Override
    public void deleteXsckd_ZibById(Integer xsckd_zib_id) throws Exception {
        iXsckd_zibDao.deleteById(xsckd_zib_id);
    }

    @Override
    public void deleteXsckd_ZibByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer : integers) {
            if (integer != null) {
                iXsckd_zibDao.deleteById(integer);
            }
        }
    }

    @Override
    public Integer getZibHhByZhubId(Integer xsckd_zhub_id) throws Exception {
        Integer maxHh = iXsckd_zibDao.findMaxHhByZhubId(xsckd_zhub_id);
        if (maxHh == null) {
            return 1;
        }
        return maxHh + 1;
    }

    @Override
    public void saveXsckd_zib(Xsckd_zib xsckd_zib) throws Exception {
        iXsckd_zibDao.save(xsckd_zib);
    }

    @Override
    public void spForbidden(String djh, String spr, Date shrq) throws Exception {
        Xsckd_zhub byDjh = iXsckd_zhubDao.findByDjh(djh);
        if (byDjh.getSfsh() == 1) {
            throw new MyException("已经审批!");
        } else {
            byDjh.setSfsh(1);
            byDjh.setSpr(spr);
            byDjh.setShrq(shrq);
            byDjh.setShsftg(0);
            iXsckd_zhubDao.updateById(byDjh);
        }
    }

    @Override
    public void spAdopt(String djh, String spr, Date shrq) throws Exception {
        Xsckd_zhub byDjh = iXsckd_zhubDao.findByDjh(djh);
        if (byDjh.getSfsh() == 1) {
            throw new MyException("已经审批!");
        } else {
            byDjh.setSfsh(1);
            byDjh.setSpr(spr);
            byDjh.setShrq(shrq);
            byDjh.setShsftg(1);
            iXsckd_zhubDao.updateById(byDjh);
        }
    }

    @Override
    public void updateZibStatusByIds(String ids, String xgr, Date xgrq) throws Exception {
        //1，根据ids查询出所有的子表s
        Integer[] xsckd_zib_ids = StringToIntegerUtils.converter(ids, ",");//获取子表的所有ids
        //2，修改销售出库子单 ，对应销售发货单，对应销售订单
        for (Integer id : xsckd_zib_ids) {
            if (id != null) {
                Xsckd_zib xsckd_zib = iXsckd_zibDao.findById(id);
                if (xsckd_zib == null) {
                    System.out.println("根据id=" + id + "查询销售出库子单为NULL!");
                    throw new MyException("根据id=" + id + "查询销售出库子单为NULL!");
                } else {
                    if (xsckd_zib.getStatus() == 1) {
                        System.out.println("其中至少一个子表的状态以及结束1，不能重复出库!");
                        throw new MyException("其中至少一个子表的状态以及结束1，不能重复出库!");
                    } else {
                        String lydjh = xsckd_zib.getLydjh();//【销售发货单】订单号
                        Integer lyhh = xsckd_zib.getLyhh();//【销售发货单】行号
                        Xsfhd_zhub byDdh = iXsfhd_zhubDao.findByDdh(lydjh);//【销售发货单】主表
                        Xsfhd_zib byZhubIdAndHh = iXsfhd_zibDao.findByZhubIdAndHh(byDdh.getXsfhd_zhub_id(), lyhh);//【销售发货单】子表

                        xsckd_zib.setStatus(1);//单据状态结束 1
                        iXsckd_zibDao.updateById(xsckd_zib);//先修改状态

                        Long sfsl = xsckd_zib.getSfsl();//【销售出库单子表】实际出库数量
                        Long ljcksl = byZhubIdAndHh.getLjcksl();//【销售发货单子表】的累计出库数量

                        if ((sfsl + ljcksl) > byZhubIdAndHh.getSfsl()) { //若累计出库数量 > 【销售发货单子表】的实发发货数量
                            System.out.println("此出库单出库后，累计的出库数量已经大于了对应的发货子单的实发发货数量。");
                            throw new MyException("此出库单出库后，累计的出库数量已经大于了对应的发货子单的实发发货数量。");
                        } else if ((sfsl + ljcksl) == byZhubIdAndHh.getSfsl()) { //若累计出库数量 = 【销售发货单子表】的实发发货数量
                            //（1）修改【销售发货单】
                            byZhubIdAndHh.setLjcksl(sfsl + ljcksl);//修改【销售发货单子表】的累计出库数量
                            byZhubIdAndHh.setSfckjs(1);//修改【销售发货单子表】的出库是否结束 1
                            iXsfhd_zibDao.updateById(byZhubIdAndHh);

                            List<Xsfhd_zib> xsfhd_zibs = iXsfhd_zibDao.findByZhubId(byDdh.getXsfhd_zhub_id());//判断是否修改主表属性“是否出库结束”
                            int flag1 = 1;
                            for (Xsfhd_zib xsfhd_zib : xsfhd_zibs) {
                                if (xsfhd_zib.getSfckjs() == 0) {
                                    flag1 = 0;
                                    break;
                                }
                            }
                            if (flag1 == 1) {
                                byDdh.setSfckjs(1);
                            } else {
                                byDdh.setSfckjs(0);
                            }
                            iXsfhd_zhubDao.updateById(byDdh);

                            //修改在 所有销售出库单中 来源订单号lydjh = 此发货单，来源行号lyhh = 此发货单的 累计出库数量
                            List<Xsckd_zib> xsckd_zibs = iXsckd_zibDao.findByLydjhAndLyhh(lydjh, lyhh);
                            for (Xsckd_zib xsckd_zib1 : xsckd_zibs) {
                                if (xsckd_zib1 != null) {
                                    xsckd_zib1.setLjcksl(sfsl + ljcksl);
                                    iXsckd_zibDao.updateById(xsckd_zib1);//修改【销售出库单子表】的累计出库数量
                                }
                            }

                            //（2）修改【销售订单】
                            String ytdjh = xsckd_zib.getYtdjh();//销售订单单据号
                            Integer ythh = xsckd_zib.getYthh();//销售订单行号
                            Xsdd_zhub byDdh1 = iXsdd_zhubDao.findByDdh(ytdjh);//销售订单主表
                            Xsdd_zib byZhubIdAndHh1 = iXsdd_zibDao.findByZhubIdAndHh(byDdh1.getXsdd_zhub_id(), ythh);//销售订单子表
                            byZhubIdAndHh1.setLjcksl(byZhubIdAndHh1.getLjcksl() + sfsl);//修改累计出库数量
                            byZhubIdAndHh1.setYfwcksl(byZhubIdAndHh1.getCount() - byZhubIdAndHh1.getLjcksl());//修改应发未出库数量
                            if (byZhubIdAndHh1.getLjcksl() == byZhubIdAndHh1.getCount()) {//若出库完毕
                                byZhubIdAndHh1.setSfckgb(1);
                                //判断 是否修改销售订单主表的属性 “出库结束标志” ：主表的所有子表的“出库结束标志”为结束 1 才能修改
                                List<Xsdd_zib> xsdd_zibs = iXsdd_zibDao.findByZhubId(byDdh1.getXsdd_zhub_id());
                                int flag = 1;
                                for (Xsdd_zib xsdd_zib : xsdd_zibs) {
                                    if(byZhubIdAndHh1.getXsdd_zib_id() != xsdd_zib.getXsdd_zib_id()){
                                        if (xsdd_zib.getSfckgb() == 0) { //没有全部结束
                                            flag = 0;
                                            break;
                                        }
                                    }
                                }
                                if (flag == 1) {
                                    byDdh1.setCkbz(1);
                                } else {
                                    byDdh1.setCkbz(0);
                                }
                            }
                            iXsdd_zhubDao.updateById(byDdh1);
                            iXsdd_zibDao.updateById(byZhubIdAndHh1);
                        } else {//若累计出库数量 < 【销售发货单子表】的实发发货数量
                            //（1）修改【销售发货单】
                            byZhubIdAndHh.setLjcksl(sfsl + ljcksl);//修改【销售发货单子表】的累计出库数量
                            iXsfhd_zibDao.updateById(byZhubIdAndHh);

                            //修改在 所有销售出库单中 来源订单号lydjh = 此发货单，来源行号lyhh = 此发货单的 累计出库数量
                            List<Xsckd_zib> xsckd_zibs = iXsckd_zibDao.findByLydjhAndLyhh(lydjh, lyhh);
                            for (Xsckd_zib xsckd_zib1 : xsckd_zibs) {
                                xsckd_zib1.setLjcksl(sfsl + ljcksl);
                                iXsckd_zibDao.updateById(xsckd_zib1);//修改【销售出库单子表】的累计出库数量
                            }

                            //（2）修改【销售订单】
                            String ytdjh = xsckd_zib.getYtdjh();//销售订单单据号
                            Integer ythh = xsckd_zib.getYthh();//销售订单行号
                            Xsdd_zhub byDdh1 = iXsdd_zhubDao.findByDdh(ytdjh);//销售订单主表
                            Xsdd_zib byZhubIdAndHh1 = iXsdd_zibDao.findByZhubIdAndHh(byDdh1.getXsdd_zhub_id(), ythh);//销售订单子表
                            byZhubIdAndHh1.setLjcksl(byZhubIdAndHh1.getLjcksl() + sfsl);//修改累计出库数量
                            byZhubIdAndHh1.setYfwcksl(byZhubIdAndHh1.getCount() - byZhubIdAndHh1.getLjcksl());//修改应发未出库数量
                            iXsdd_zibDao.updateById(byZhubIdAndHh1);
                        }
                    }
                }
            }
        }
        //3,修改销售出库单主表
        for (Integer id : xsckd_zib_ids) {
            if (id != null) {
                Xsckd_zib xsckd_zib = iXsckd_zibDao.findById(id);
                if (xsckd_zib != null) {
                    Xsckd_zhub byId = iXsckd_zhubDao.findById(xsckd_zib.getXsckd_zhub_id());
                    byId.setXgr(xgr);//修改人
                    byId.setXgrq(xgrq);//日期
                    List<Xsckd_zib> xsckd_zibs = iXsckd_zibDao.findByZhubId(byId.getXsckd_zhub_id());//该出库订单主表下面的所有子表
                    int flag = 1;
                    for (Xsckd_zib xsckd_zib1 : xsckd_zibs) {
                        if (xsckd_zib1.getStatus() == 0) {
                            flag = 0;
                            break;
                        }
                    }
                    if (flag == 1) {
                        byId.setStatus(1);
                    } else {
                        byId.setStatus(0);
                    }
                    iXsckd_zhubDao.updateById(byId);
                    break;
                }
            }
        }
        return;
    }
}













