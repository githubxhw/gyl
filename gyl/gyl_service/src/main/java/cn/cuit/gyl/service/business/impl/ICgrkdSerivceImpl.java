package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.*;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.ICgrkdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("ICgrkdSerivceImpl")
public class ICgrkdSerivceImpl implements ICgrkdService {

    @Autowired
    private ICgrkd_zhubDao iCgrkd_zhubDao;

    @Autowired
    private ICgrkd_zibDao iCgrkd_zibDao;

    @Autowired
    @Qualifier("cgdddao")
    private cgdddao iCgdd_zhubDao;

    @Autowired
    @Qualifier("cgddzhidao")
    private cgddzhidao iCgdd_zibDao;

    @Autowired
    @Qualifier("iCgdhd_zhubDao")
    private ICgdhd_zhubDao iCgdhd_zhubDao;

    @Autowired
    @Qualifier("iCgdhd_zibDao")
    private ICgdhd_zibDao iCgdhd_zibDao;

    @Override
    public PageInfo saveZhubAndZib(Cgrkd_zhub cgrkd_zhub) throws Exception {
        PageInfo pageInfo = new PageInfo();
        Long ljrksl = 0L; //采购订单 累计发到货数量
        //获取子表s
        List<Cgrkd_zib> cgrkd_zibs = cgrkd_zhub.getCgrkd_zibs();
        int addFlag = 1; //1代表可以添加，0代表不可以添加
        if(cgrkd_zibs != null){
            for (Cgrkd_zib cgrkd_zib : cgrkd_zibs) {
                //有编号的商品
                if (cgrkd_zib.getSpbm() != null || "".equals(cgrkd_zib.getSpbm())) {
                    //采购订单验证
                    String ytdjh = cgrkd_zib.getYtdjh();//源头订单号
                    Integer ythh = cgrkd_zib.getYthh();//源头行号
                    Integer hh = cgrkd_zib.getHh();
                    //采购订单主表查询
                    Cgddzhub byDdh = iCgdd_zhubDao.findByDjh(ytdjh);
                    if(byDdh == null){
                        addFlag = 0;
                        //1.1没有此cgdd单据号
                        pageInfo.setResFlag("0");
                        pageInfo.add("当采购入库单行号为"+hh+"的时候:"+"采购订单中没有"+ytdjh+"的单据号!");
                        break;
                    }else {
                        if(byDdh.getRkbz() == 1){//1.2该cgdd单据号的主表：到货状态 已经关闭（结束）1
                            addFlag = 0;
                            pageInfo.setResFlag("0");
                            pageInfo.add("当采购入库单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"的采购订单（主表）中到货单状态已经结束!");
                            break;
                        }else {
                            //采购订单子表查询
                            Cgddzhib byZhubIdAndHh1 = iCgdd_zibDao.findByZIdAndHh(byDdh.getCgddzhubid(), ythh.longValue());
                            if(byZhubIdAndHh1 == null){ //没有此行号 2.1没有此行号
                                addFlag = 0;
                                pageInfo.setResFlag("0");
                                pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"的采购订单中没有行号为"+ythh+"的商品!");
                                break;
                            }else {
                                if(byZhubIdAndHh1.getSfrkgb() == 1){//2.2有该行号但是该商品的到货状态已经是结束 1
                                    addFlag = 0;
                                    pageInfo.setResFlag("0");
                                    pageInfo.add("当采购入库单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"且行号为"+ythh+"的采购订单（子表）中的到货单状态已经结束!");
                                    break;
                                }else {
                                    //商品编码
                                    String spbm1 = byZhubIdAndHh1.getSpbm();
                                    String spbm2 = cgrkd_zib.getSpbm();
                                    if(!spbm1.equals(spbm2)){ //2.3有行号，到货状态未结束0，但是商品编码不对应(其实应该验证商品的所有信息，为了简便省略了那些属性)
                                        addFlag = 0;
                                        pageInfo.setResFlag("0");
                                        pageInfo.add("当采购入库单行号为"+hh+"的时候:"+"对应的到货编码不对!");
                                        break;
                                    }else {


                                        //到货单子表验证
                                        String lydjh = cgrkd_zib.getLydjh();//来源单据号
                                        Integer lyhh = cgrkd_zib.getLyhh();//来源行号
                                        //来源单据号验证
                                        Cgdhd_zhub byDdh1= iCgdhd_zhubDao.findByDdh(lydjh);
                                        if(byDdh1 == null){
                                            addFlag = 0;
                                            //1.1没有此cgdd单据号
                                            pageInfo.setResFlag("0");
                                            pageInfo.add("当采购入库单行号为"+hh+"的时候:"+"采购到货单中没有"+lydjh+"的单据号!");
                                            break;
                                        }else {
                                            if (byDdh1.getSfrkjs() == 1) {//1.2该cgdd单据号的主表：到货状态 已经关闭（结束）1
                                                addFlag = 0;
                                                pageInfo.setResFlag("0");
                                                pageInfo.add("当采购入库单行号为" + hh + "的时候:" + "订单号为" + lydjh + "的采购到货单（主表）中到货单状态已经结束!");
                                                break;
                                            } else {
                                                //采购订单子表查询
                                                Cgdhd_zib byZhubIdAndHh2 = iCgdhd_zibDao.findByzhubIdAndHh(byDdh1.getCgdhd_zhub_id(), lyhh);
                                                if (byZhubIdAndHh2 == null) { //没有此行号 2.1没有此行号
                                                    addFlag = 0;
                                                    pageInfo.setResFlag("0");
                                                    pageInfo.add("当采入库单行号为" + hh + "的时候:" + "订单号为" + lydjh + "的采购到货中没有行号为" + lyhh + "的商品!");
                                                    break;
                                                } else {
                                                    if (byZhubIdAndHh2.getSfrkjs() == 1) {//2.2有该行号但是该商品的到货状态已经是结束 1
                                                        addFlag = 0;
                                                        pageInfo.setResFlag("0");
                                                        pageInfo.add("当采购入库单行号为" + hh + "的时候:" + "订单号为" + lydjh + "且行号为" + lyhh + "的采购到货（子表）中的到货单状态已经结束!");
                                                        break;
                                                    } else {
                                                        //商品编码
                                                        String spbm3 = byZhubIdAndHh2.getSpbm();
                                                        String spbm4 = cgrkd_zib.getSpbm();
                                                        if (!spbm3.equals(spbm4)) { //2.3有行号，到货状态未结束0，但是商品编码不对应(其实应该验证商品的所有信息，为了简便省略了那些属性)
                                                            addFlag = 0;
                                                            pageInfo.setResFlag("0");
                                                            pageInfo.add("当采购入库单行号为" + hh + "的时候:" + "对应的到货编码不对!");
                                                            break;
                                                        } else {
                                                            //应到数量
                                                            Long count = byZhubIdAndHh1.getSl();
                                                            int ydsl = cgrkd_zib.getYdsl();
                                                            if (count > ydsl) {
                                                                addFlag = 0;
                                                                pageInfo.setResFlag("0");
                                                                pageInfo.add("当采入库货单行号为" + hh + "的时候:" + "当前到货数量大于了总采购数量!");
                                                                break;
                                                            } else {//该到货单子表通过考核

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
            if(true){ //检查了所有子表合理 /*开始添加子表*/
                //添加主表
                iCgrkd_zhubDao.save(cgrkd_zhub);
                //根据单据号ddh查询出主表信息,得到主表id
                Cgrkd_zhub cgrkd_zhub1 = iCgrkd_zhubDao.findByDdh(cgrkd_zhub.getDjh());
                Integer cgrkd_zhub_id = cgrkd_zhub1.getCgrkd_zhub_id();
                    for (Cgrkd_zib cgrkd_zib : cgrkd_zibs) {
                        if (cgrkd_zib.getSpbm() != null || "".equals(cgrkd_zib.getSpbm())) {
                            String ytdjh = cgrkd_zib.getYtdjh();//源头订单号
                            Integer ythh = cgrkd_zib.getYthh();//源头行号
                            //主表
                            Cgddzhub byDdh = iCgdd_zhubDao.findByDjh(ytdjh);
                            //子表
                            Cgddzhib byZhubIdAndHh = iCgdd_zibDao.findByZIdAndHh(byDdh.getCgddzhubid(), ythh.longValue());
                            //获取累计到货数量
                            Long ljrksl1 = byZhubIdAndHh.getLjrksl();
                            cgrkd_zib.setLjrksl(ljrksl1.intValue()); //设置累计到货数量
                            cgrkd_zib.setCgrkdzhubid(cgrkd_zhub_id); //设置采购到货单主表id(外键)
                            iCgrkd_zibDao.save(cgrkd_zib);
                        }
                    }
                pageInfo.setResFlag("1");
            }
        }else {
            //添加主表
            iCgrkd_zhubDao.save(cgrkd_zhub);
            pageInfo.setResFlag("1");
        }
        return pageInfo;
    }

    @Override
    public List<Cgrkd_zhub> findByCgrkd_zhub(Cgrkd_zhub cgrkd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgrkd_zhub> handler = new DomainAttrValueConverterUtils<>(cgrkd_zhub);
        Cgrkd_zhub x = handler.handler(null, "sfsh","shsftg","sfth","status");
        List<Cgrkd_zhub>  cgrkd_zhubs = iCgrkd_zhubDao.findByZhub(x);
        return cgrkd_zhubs;
    }


    @Override
    public Cgrkd_zhub findCgrkd_zhubById(Integer cgrkd_zhub_id) throws Exception {
        Cgrkd_zhub cgrkd_zhub = iCgrkd_zhubDao.findById(cgrkd_zhub_id);
        return cgrkd_zhub;
    }

    @Override
    public void updateCgrkd_zhubById(Cgrkd_zhub cgrkd_zhub) throws Exception {
        if(cgrkd_zhub.getStatus() == 1){
            throw new MyException("已经结束，不能修改！");
        }
        iCgrkd_zhubDao.updateById(cgrkd_zhub);
    }

    @Override
    public void deleteCgrkd_ZhubById(Integer cgrkd_zhub_id) throws Exception {
        iCgrkd_zhubDao.deleteById(cgrkd_zhub_id);
    }

    @Override
    public void saveCgrkd_zhub(Cgrkd_zhub cgrkd_zhub) throws Exception {
        iCgrkd_zhubDao.save(cgrkd_zhub);
    }

    @Override
    public void deleteCgrkd_ZhubByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer:integers) {
            iCgrkd_zhubDao.deleteById(integer);
        }
    }

    @Override
    public List<Cgrkd_zib> findCgrkd_zibByZhubId(Integer cgrkd_zhub_id) throws Exception {
        List<Cgrkd_zib> cgrkd_zibs = iCgrkd_zibDao.findByZhubId(cgrkd_zhub_id);
        return cgrkd_zibs;
    }

    @Override
    public Cgrkd_zib findCgrkd_zibById(Integer cgrkd_zib_id) throws Exception {
        Cgrkd_zib cgrkd_zib = iCgrkd_zibDao.findById(cgrkd_zib_id);
        return cgrkd_zib;
    }

    @Override
    public void updateCgrkd_zibById(Cgrkd_zib cgrkd_zib) throws Exception {

        Integer status = cgrkd_zib.getStatus();
        //1,判断cgrkd_zib里面的status
        if(status == 0){
            //未结束 直接修改信息
            iCgrkd_zibDao.updateById(cgrkd_zib);
        }else {
             /*结束
             * 1, 修改当前到货单子表（累计到货数量以及 status-->页面提交设置的）
             * 2, 修改所有的到货单子表（累计到货数量）
             * 3, 修改到货单主表（判断） （status）
             * 4, 修改采购订单子表（累计发货数量以及status）
             * 5, 修改采购订单主表（判断） （rkbz）
             * */
            //1.0 计算 累计到货数量 = 原来的累计到货数量 + 实到数量
            Long ljrksl = cgrkd_zib.getLjrksl().longValue() + cgrkd_zib.getSdsl();


            //1.1 修改自己当前子表的属性：累计到货数量ljrksl
            cgrkd_zib.setLjrksl(ljrksl.intValue());
            iCgrkd_zibDao.updateById(cgrkd_zib);

            //1.2 修改自己主表的属性 status状态 ，方法 根据主表id查询所有的子表信息，若所有子表status属性都为 1 即结束，则设置主表status为1；否则不修改 0
            List<Cgrkd_zib> cgrkd_zibs1 = iCgrkd_zibDao.findByZhubId(cgrkd_zib.getCgrkdzhubid());
            int flag1 = 0;
            for (Cgrkd_zib cgrkd_zib1:cgrkd_zibs1) {
                Integer status1 = cgrkd_zib1.getStatus();
                if(status1 == 1){
                    flag1++;
                }
            }
            if(flag1 == cgrkd_zibs1.size()){
                //status全为1 修改主表status
                Cgrkd_zhub cgrkd_zhub1 = iCgrkd_zhubDao.findById(cgrkd_zib.getCgrkdzhubid());
                cgrkd_zhub1.setStatus(1);
                //更新主表status
                iCgrkd_zhubDao.updateById(cgrkd_zhub1);
            }else {
                //status全为0
            }

            //1.3 得到 源头单据号 和 源头行号
            String ytdjh = cgrkd_zib.getYtdjh();
            Integer ythh = cgrkd_zib.getYthh();
            String lydjh = cgrkd_zib.getLydjh();
            Integer lyhh = cgrkd_zib.getLyhh();



            //1.4 修改所有“源头单据号” 和 “源头行号”相同的到货子单 属性：累计到货数量ljrksl
            List<Cgrkd_zib> cgrkd_zibs2 = iCgrkd_zibDao.findByYtdjhAndYthh(ytdjh,ythh);
            for (Cgrkd_zib cgrkd_zib2:cgrkd_zibs2) {
                if(cgrkd_zib2.getCgrkd_zib_id() != cgrkd_zib.getCgrkd_zib_id()){
                    cgrkd_zib2.setLjrksl(ljrksl.intValue());
                    iCgrkd_zibDao.updateById(cgrkd_zib2);
                }
            }
            //1.5 回写操作 根据 “源头单据号” 和 “源头行号” 查询出 销售订单
            //1.51 修改采购订单子表的属性 “累计到货数量” 以及 “是否到货结束”
            //主表
            Cgddzhub cgdd_zhub = iCgdd_zhubDao.findByDjh(ytdjh);
            //主表id
            Integer cgdd_zhub_id = cgdd_zhub.getCgddzhubid().intValue();
            //子表
            Cgddzhib cgdd_zib1 = iCgdd_zibDao.findByZIdAndHh(cgdd_zhub_id,ythh.longValue());
            //数量 = 累计入库数量
            if(cgdd_zib1.getSl() == ljrksl){
                //设置子表 是否到货结束 --》1
                cgdd_zib1.setSfrkgb(1);
                cgdd_zib1.setLjrksl(ljrksl);
                iCgdd_zibDao.updateCgddzhib(cgdd_zib1);
            }

            //1.52 修改采购订单主表的属性 “是否到货结束”
            //根据cgdd_zhub_id获取所有的子表，遍历，判断所有子表中属性 “是否到货结束” , 若全部结束，则修改主表
            List<Cgddzhib> cgdd_zibs2 = iCgdd_zibDao.findByzid(cgdd_zhub_id.longValue());
            int flag2 = 0;
            for (Cgddzhib cgdd_zib2:cgdd_zibs2) {
                if(cgdd_zib2.getSfrkgb() == 1){
                    flag2++;
                }
            }
            if(flag2 == cgdd_zibs2.size()){
                //修改订单主表属性 “是否到货结束”
                cgdd_zhub.setRkbz(1);
                iCgdd_zhubDao.updateCgddzhub(cgdd_zhub);

            }


            iCgdd_zibDao.updateCgddzhib(cgdd_zib1);

            Cgdhd_zhub cgdhd_zhub = iCgdhd_zhubDao.findByDdh(lydjh);

            Cgdhd_zib cgdhd_zib = iCgdhd_zibDao.findByzhubIdAndHh(cgdhd_zhub.getCgdhd_zhub_id(), lyhh);
            //数量 = 累计入库数量
            if(cgdhd_zib.getYdsl() == ljrksl){
                //设置子表 是否到货结束 --》1
                cgdhd_zib.setSfrkjs(1);
                iCgdhd_zibDao.updateById(cgdhd_zib);
            }

            List<Cgdhd_zib> cgdhd_zibs = iCgdhd_zibDao.findByZhubId(cgdhd_zhub.getCgdhd_zhub_id());
            int flag3 = 0;
            for (Cgdhd_zib cgdhd_zib2:cgdhd_zibs) {
                if(cgdhd_zib2.getSfrkjs() == 1){
                    flag2++;
                }
            }
            if(flag2 == cgdhd_zibs.size()){
                //修改到货单主表属性 “是否到货结束”
                cgdhd_zhub.setSfrkjs(1);
                iCgdhd_zhubDao.updateById(cgdhd_zhub);
            }
        }
    }

    @Override
    public void deleteCgrkd_ZibById(Integer cgrkd_zib_id) throws Exception {
        iCgrkd_zibDao.deleteById(cgrkd_zib_id);
    }

    @Override
    public void deleteCgrkd_ZibByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer id:integers) {
            if(id != null){
                iCgrkd_zibDao.deleteById(id);
            }
        }
    }

    @Override
    public Integer getZib_hh(Integer cgrkd_zhub_id) throws Exception {
        Integer hh = iCgrkd_zibDao.findMaxHhByZhubId(cgrkd_zhub_id);
        if(hh == null){
            return 1;
        }
        return hh+1;
    }

    @Override
    public void saveCgrkd_zib(Cgrkd_zib cgrkd_zib) throws Exception {
        iCgrkd_zibDao.save(cgrkd_zib);
    }

    @Override
    public List<Cgrkd_zhub> findAllAndSfshIsZero(Cgrkd_zhub cgrkd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgrkd_zhub> handler = new DomainAttrValueConverterUtils<>(cgrkd_zhub);
        Cgrkd_zhub x = handler.handler(null, "sfsh","shsftg","sfth","status");
        System.out.println(x);
        List<Cgrkd_zhub> cgrkd_zhubs = iCgrkd_zhubDao.findAllAndSfshIsZero(x);
        return cgrkd_zhubs;
    }

    @Override
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception {
        Cgrkd_zhub cgrkd_zhub = iCgrkd_zhubDao.findByDdh(ddh);
        if(cgrkd_zhub.getSfsh() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            cgrkd_zhub.setSfsh(1);
            cgrkd_zhub.setShsftg(0);
            cgrkd_zhub.setSpr(spr);
            cgrkd_zhub.setShrq(sprq);
            iCgrkd_zhubDao.updateById(cgrkd_zhub);
        }
    }

    @Override
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception {
        Cgrkd_zhub cgrkd_zhub = iCgrkd_zhubDao.findByDdh(ddh);
        if(cgrkd_zhub.getSfsh() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            cgrkd_zhub.setSfsh(1);
            cgrkd_zhub.setShsftg(1);
            cgrkd_zhub.setSpr(spr);
            cgrkd_zhub.setShrq(sprq);
            iCgrkd_zhubDao.updateById(cgrkd_zhub);
        }
    }

    @Override
    public void updateZibStatusByIds(String ids, String xgr, Date xgsj) throws Exception {
        List<Cgrkd_zib> cgrkd_zibs = new ArrayList<>();
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        int statusFlag = 0;
        for (Integer id:integers) {
            if(id != null){
                Cgrkd_zib cgrkd_zib = iCgrkd_zibDao.findById(id);
                if(cgrkd_zib != null){
                    if(cgrkd_zib.getStatus() == 1){
                        statusFlag++;
                    }
                    cgrkd_zibs.add(cgrkd_zib);
                }
            }
        }
        if(statusFlag > 0){
            throw new MyException("不能重复入库!");
        }else {
            //入库
            int flag = 0;
            for (Integer id:integers) {
                if(id != null){
                    flag++;
                    Cgrkd_zib cgrkd_zib = iCgrkd_zibDao.findById(id);
                    cgrkd_zib.setStatus(1);
                    this.updateCgrkd_zibById(cgrkd_zib);
                    if(flag == 1){
                        Integer cgrkd_zhub_id = cgrkd_zib.getCgrkdzhubid();
                        Cgrkd_zhub cgrkd_zhub = iCgrkd_zhubDao.findById(cgrkd_zhub_id);
                        cgrkd_zhub.setXgr(xgr);
                        cgrkd_zhub.setXgrq(xgsj);
                        iCgrkd_zhubDao.updateById(cgrkd_zhub);
                    }
                }
            }
        }
    }
}
