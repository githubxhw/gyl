package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.*;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.IXskpdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("xskpdServiceImpl")
public class XskpdServiceImpl implements IXskpdService {

    @Autowired
    @Qualifier("iXskpd_zhubDao")
    private IXskpd_zhubDao iXskpd_zhubDao = null;

    @Autowired
    @Qualifier("iXskpd_zibDao")
    private IXskpd_zibDao iXskpd_zibDao = null;

    @Autowired
    @Qualifier("iXsfhd_zhubDao")
    private IXsfhd_zhubDao iXsfhd_zhubDao = null;

    @Autowired
    @Qualifier("iXsfhd_zibDao")
    private IXsfhd_zibDao iXsfhd_zibDao = null;

    @Autowired
    @Qualifier("iXsdd_zhubDao")
    private IXsdd_zhubDao iXsdd_zhubDao = null;

    @Autowired
    @Qualifier("iXsdd_zibDao")
    private IXsdd_zibDao iXsdd_zibDao = null;


    @Override
    public List<Xskpd_zhub> findZhubByMany(Xskpd_zhub xskpd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xskpd_zhub> handler = new DomainAttrValueConverterUtils<>(xskpd_zhub);
        Xskpd_zhub x = handler.handler(null, "sfsp","spsftg", "ysksfjs","status");
        List<Xskpd_zhub> xskpd_zhubs = iXskpd_zhubDao.findByMany(x);
        return xskpd_zhubs;
    }

    @Override
    public List<Xskpd_zib> findZibsByZhubId(Integer xskpd_zhub_id) throws Exception {
        List<Xskpd_zib> xskpd_zibs = iXskpd_zibDao.findByZhubId(xskpd_zhub_id);
        return xskpd_zibs;
    }

    @Override
    public PageInfo saveZhubAndZib(Xskpd_zhub xskpd_zhub) throws Exception {
        /**验证是否添加
         * 遍历所有子表
         * (1)对应源头订单:销售订单
         *  1，根据源头订单号查询销售订单主表
         *      1.1 没有此销售订单主表
         *      1.2 有此表，属性status没有结束 0，但是属性ckbz出库结束标志已经结束 1
         *  2，根据销售订单主表id和行号查询出对应的子表
         *      2.1 没有此销售订单子表
         *      2.2 有此表，属性status没有结束 0，但是属性sfkpgb是否出库结束 1
         *      2.3 有此表，属性status没有结束 0，属性sfkpgb是否出库未结束 0，但是商品编码不对
         *
         * (2)对应来源订单:销售发货单
         *  1，根据来源订单号查询对应的销售发货单主表
         *      1.1 没有此销售发货单主表
         *      1.2 有此表，但是sfkpjs是否开票结束 1
         *  2，根据销售开票单主表id和来源行号查询出对应的发货单子表
         *      2.1 没有此销售发货单子表
         *      2.2 有此表，但是sfkpjs开票结束 1
         *      2.3 有此表，sfkpjs未结束 0，但是商品编码不对
         *      2.4 有此表，sfkpjs未结束 0，商品编码对，但是(销售开票单xskpd_zib中的count数量) != (销售发货单中的sfsl实发数量)
         *
         */
        PageInfo pageInfo = new PageInfo();//返回到页面的信息
        pageInfo.setResFlag("1");

        List<Xskpd_zib> xskpd_zibs = xskpd_zhub.getXskpd_zibs();//获取销售开票子表s
        //若没有子表，则直接添加
        if(xskpd_zibs == null){
            iXskpd_zhubDao.save(xskpd_zhub);
        }else {//有子表，需要判断是否可以添加
            for (Xskpd_zib xskpd_zib:xskpd_zibs) {
                if(xskpd_zib.getSpbm() != null && !"".equals(xskpd_zib.getSpbm())){
                    Integer hh = xskpd_zib.getHh();
                    String ytdjh = xskpd_zib.getYtdjh();//源头订单号【销售订单】
                    Integer ythh = xskpd_zib.getYthh();//源头行号【销售订单】

                    //(1)对应源头订单:销售订单
                    //1，根据源头订单号查询销售订单主表
                    Xsdd_zhub byDdh = iXsdd_zhubDao.findByDdh(ytdjh);
                    if(byDdh == null){//1.1 没有此销售订单主表
                        pageInfo.setResFlag("0");
                        pageInfo.add("行号为" + hh + "时：在销售订单中没有对应的销售订单-主表！");
                        break;
                    }else {
                        if(byDdh.getKpbz() == 1){//1.2 有此表，属性status没有结束 0，但是属性Kpbz开票结束标志已经结束 1
                            pageInfo.setResFlag("0");
                            pageInfo.add("行号为" + hh + "时：对应的销售订单（主表）的开票（状态）已经结束！");
                            break;
                        }else {
                            //2，根据销售订单主表id和行号查询出对应的子表
                            Xsdd_zib byZhubIdAndHh = iXsdd_zibDao.findByZhubIdAndHh(byDdh.getXsdd_zhub_id(), ythh);
                            if(byZhubIdAndHh == null){//2.1 没有此销售订单子表
                                pageInfo.setResFlag("0");
                                pageInfo.add("行号为" + hh + "时：在销售订单中没有对应的销售订单-子表！");
                                break;
                            }else {
                                if(byZhubIdAndHh.getSfkpgb() == 1){//2.2 有此表，但是sfkpjs开票结束 1
                                    pageInfo.setResFlag("0");
                                    pageInfo.add("行号为" + hh + "时：对应的销售订单（子表）的开票（状态）已经结束！");
                                    break;
                                }else {
                                    if(!byZhubIdAndHh.getSpbm().equals(xskpd_zib.getSpbm())){//2.3 有此表，属性status没有结束 0，属性sfkpgb是否开票未结束 0，但是商品编码不对
                                        pageInfo.setResFlag("0");
                                        pageInfo.add("行号为" + hh + "时：对应的销售订单（子表）的商品编码有错！");
                                        break;
                                    }else {
                                        String lydjh = xskpd_zib.getLydjh();//来源单据号【销售发货单】
                                        Integer lyhh = xskpd_zib.getLyhh();//来源行号【销售发货单】

                                        //(2)对应来源订单:销售发货单
                                        //1，根据来源订单号查询对应的销售发货单主表
                                        Xsfhd_zhub byDdh1 = iXsfhd_zhubDao.findByDdh(lydjh);
                                        if(byDdh1 == null){//1.1 没有此销售发货单主表
                                            pageInfo.setResFlag("0");
                                            pageInfo.add("行号为" + hh + "时：在发货单中没有对应的发货单-主表！");
                                            break;
                                        }else {
                                            if(byDdh1.getSfkpjs() == 1){//1.2 有此表，但是sfkpjs是否开票结束 1
                                                pageInfo.setResFlag("0");
                                                pageInfo.add("行号为" + hh + "时：对应的发货单（主表）的开票（状态）已经结束！");
                                                break;
                                            }else {
                                                //2，根据销售开票单主表id和来源行号查询出对应的发货单子表
                                                Xsfhd_zib byZhubIdAndHh1 = iXsfhd_zibDao.findByZhubIdAndHh(byDdh1.getXsfhd_zhub_id(), lyhh);
                                                if(byZhubIdAndHh1 == null){//2.1 没有此销售发货单子表
                                                    pageInfo.setResFlag("0");
                                                    pageInfo.add("行号为" + hh + "时：在发货单中没有对应的发货单-子表！");
                                                    break;
                                                }else {
                                                    if(byZhubIdAndHh1.getSfkpjs() == 1){//2.2 有此表，但是sfkpjs开票结束 1
                                                        pageInfo.setResFlag("0");
                                                        pageInfo.add("行号为" + hh + "时：对应的发货单（子表）的开票（状态）已经结束！");
                                                        break;
                                                    }else {
                                                        if(!byZhubIdAndHh1.getSpbm().equals(xskpd_zib.getSpbm())){//2.3 有此表，sfkpjs未结束 0，但是商品编码不对
                                                            pageInfo.setResFlag("0");
                                                            pageInfo.add("行号为" + hh + "时：对应的发货单（子表）的商品编码有错！");
                                                            break;
                                                        }else {
                                                            if(byZhubIdAndHh1.getSfsl() < xskpd_zib.getCount()){//2.4 有此表，sfkpjs未结束 0，商品编码对，但是(销售开票单xskpd_zib中的count数量) > (销售发货单中的sfsl实发数量)
                                                                pageInfo.setResFlag("0");
                                                                pageInfo.add("行号为" + hh + "时：销售开票单的开票数量不能大于对应的发货单的实发数量！");
                                                                break;
                                                            }else {//合理
                                                                //System.out.println("合理+1");
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
                iXskpd_zhubDao.save(xskpd_zhub);
                Xskpd_zhub xskpd_zhub1 = iXskpd_zhubDao.findByFph(xskpd_zhub.getFph());//根据发票号查询主表
                Integer xskpd_zhub_id = xskpd_zhub1.getXskpd_zhub_id();//主表id

                for (Xskpd_zib xskpd_zib:xskpd_zibs) {
                    if(xskpd_zib.getSpbm() != null && !"".equals(xskpd_zib.getSpbm())){
                        //查询（销售发货单子表）中（累计开票数量）
                        Xsfhd_zhub byDdh = iXsfhd_zhubDao.findByDdh(xskpd_zib.getLydjh());
                        Xsfhd_zib byZhubIdAndHh = iXsfhd_zibDao.findByZhubIdAndHh(byDdh.getXsfhd_zhub_id(), xskpd_zib.getHh());
                        xskpd_zib.setLjkpsl(byZhubIdAndHh.getLjkpsl());//设置累计开票数量
                        xskpd_zib.setXskpd_zhub_id(xskpd_zhub_id);//设置主表id
                        iXskpd_zibDao.save(xskpd_zib);
                    }
                }
            }
        }
        return pageInfo;
    }

    @Override
    public Xskpd_zhub findZhubById(Integer xskpd_zhub_id) throws Exception {
        Xskpd_zhub xskpd_zhub = iXskpd_zhubDao.findById(xskpd_zhub_id);
        return xskpd_zhub;
    }

    @Override
    public void updateZhubById(Xskpd_zhub xskpd_zhub) throws Exception {
        iXskpd_zhubDao.updateById(xskpd_zhub);
    }

    @Override
    public void deleteZhubById(Integer xskpd_zhub_id) throws Exception {
        iXskpd_zhubDao.deleteById(xskpd_zhub_id);
    }

    @Override
    public void deleteZhubsByIds(String ids) throws Exception {
        Integer[] IDS = StringToIntegerUtils.converter(ids, ",");
        for (Integer id:IDS) {
            if(id != null){
                iXskpd_zhubDao.deleteById(id);
            }
        }
    }

    @Override
    public void updateZibById(Xskpd_zib xskpd_zib) throws Exception {
        iXskpd_zibDao.updateById(xskpd_zib);
    }

    @Override
    public Xskpd_zib findZibById(Integer xskpd_zib_id) throws Exception {
        Xskpd_zib xskpd_zib = iXskpd_zibDao.findById(xskpd_zib_id);
        return xskpd_zib;
    }

    @Override
    public Integer getZibHhByZhubId(Integer xskpd_zhub_id) throws Exception {
        Integer maxHh = iXskpd_zibDao.findMaxHhByZhubId(xskpd_zhub_id);
        if(maxHh == null){
            return 1;
        }
        return maxHh+1;
    }

    @Override
    public void saveZib(Xskpd_zib xskpd_zib) throws Exception {
        iXskpd_zibDao.save(xskpd_zib);
    }

    @Override
    public void deleteZibById(Integer xskpd_zib_id) throws Exception {
        iXskpd_zibDao.deleteById(xskpd_zib_id);
    }

    @Override
    public void deleteZibsByIds(String ids) throws Exception {
        Integer[] IDS = StringToIntegerUtils.converter(ids, ",");
        for (Integer id:IDS) {
            if(id != null){
                iXskpd_zibDao.deleteById(id);
            }
        }
    }

    @Override
    public void spForbidden(String fph, String spr, Date sprq) throws Exception {
        Xskpd_zhub byFph = iXskpd_zhubDao.findByFph(fph);
        if(byFph.getSfsp() == 1){
            System.out.println("该发票已经审批!");
            throw new MyException("该发票已经审批!");
        }else {
            byFph.setSfsp(1);
            byFph.setSpsftg(0);
            byFph.setSpr(spr);
            byFph.setSprq(sprq);
            iXskpd_zhubDao.updateById(byFph);
        }
    }

    @Override
    public void spAdopt(String fph, String spr, Date sprq) throws Exception {
        Xskpd_zhub byFph = iXskpd_zhubDao.findByFph(fph);
        if(byFph.getSfsp() == 1){
            System.out.println("该发票已经审批!");
            throw new MyException("该发票已经审批!");
        }else {
            byFph.setSfsp(1);
            byFph.setSpsftg(1);
            byFph.setSpr(spr);
            byFph.setSprq(sprq);
            iXskpd_zhubDao.updateById(byFph);
        }
    }

    @Override
    public void updateZibStatusByIds(String ids, String xgr, Date xgrq) throws Exception {
        //1
        Integer[] IDS = StringToIntegerUtils.converter(ids, ",");
        //2 修改子表
        for (Integer id:IDS) {
            if(id != null){
                Xskpd_zib xskpd_zib = iXskpd_zibDao.findById(id);
                if(xskpd_zib == null){
                    System.out.println("根据id=" + id + "查询销售出库子单为NULL!");
                    throw new MyException("根据id=" + id + "查询销售出库子单为NULL!");
                }else {
                    if(xskpd_zib.getStatus() == 1){
                        System.out.println("其中至少一个子表的状态以及结束1，不能重复确认开票!");
                        throw new MyException("其中至少一个子表的状态以及结束1，不能重复确认开票!");
                    }else {
                        String lydjh = xskpd_zib.getLydjh();//销售发货单订单号
                        Integer lyhh = xskpd_zib.getLyhh();//销售发货单行号
                        Xsfhd_zhub byDdh = iXsfhd_zhubDao.findByDdh(lydjh);//销售发货单主表
                        Xsfhd_zib byZhubIdAndHh = iXsfhd_zibDao.findByZhubIdAndHh(byDdh.getXsfhd_zhub_id(), lyhh);//销售发货单子表

                        xskpd_zib.setStatus(1);//单据状态结束 1
                        iXskpd_zibDao.updateById(xskpd_zib);//先修改状态

                        Long count = xskpd_zib.getCount();//【销售开票单】实际开票数量
                        Long ljkpsl = byZhubIdAndHh.getLjkpsl();//【销售发货单子表】的累计开票数量
                        Long afterLjkpsl = count+ljkpsl;

                        if(afterLjkpsl > byZhubIdAndHh.getSfsl()){//若累计开票数量 > 【销售发货单子表】的实发发货数量
                            System.out.println("此开票单开票后，累计的开票数量已经大于了对应的发货子单的实发发货数量。");
                            throw new MyException("此开票单开票后，累计的开票数量已经大于了对应的发货子单的实发发货数量。");
                        }else if(afterLjkpsl == byZhubIdAndHh.getSfsl()) {//若累计开票数量 = 【销售发货单子表】的实发发货数量
                            /**
                             * 1，先修改对应的【销售发货单】
                             * 2，再修改所有 来源单据号和来源行号 是该【销售发货单】的销售开票单
                             * 3，再修改对应的【销售订单】
                             */
                            //1，先修改对应的【销售发货单】
                            byZhubIdAndHh.setLjkpsl(afterLjkpsl);//修改【销售发货单子表】的累计开票数量
                            byZhubIdAndHh.setSfkpjs(1);//修改【销售发货单子表】的开票是否结束 1
                            iXsfhd_zibDao.updateById(byZhubIdAndHh);

                            List<Xsfhd_zib> xsfhd_zibs = iXsfhd_zibDao.findByZhubId(byZhubIdAndHh.getXsfhd_zhub_id());//判断是否修改主表属性“是否开票结束”
                            int flag = 1;
                            for (Xsfhd_zib xsfhd_zib:xsfhd_zibs) {
                                if(xsfhd_zib.getStatus() == 0){
                                    flag = 0;
                                    break;
                                }
                            }
                            if(flag == 1){//销售发货单主表的属性：是否开票结束为结束 1
                                byDdh.setSfkpjs(1);
                            }else {
                                byDdh.setSfkpjs(0);
                            }
                            iXsfhd_zhubDao.updateById(byDdh);

                            //2，再修改所有 来源单据号和来源行号 是该【销售发货单】的销售开票单
                            List<Xskpd_zib> xskpd_zibs = iXskpd_zibDao.findByLydjhAndLyhh(lydjh,lyhh);
                            for (Xskpd_zib xskpd_zib1:xskpd_zibs) {
                                if(xskpd_zib1 != null){
                                    xskpd_zib1.setLjkpsl(afterLjkpsl);
                                    iXskpd_zibDao.updateById(xskpd_zib1);
                                }
                            }

                            //3，再修改对应的【销售订单】
                            String ytdjh = xskpd_zib.getYtdjh();//源头单据号：销售订单主表单据号djh
                            Integer ythh = xskpd_zib.getYthh();//源头行号：销售订单子表行号hh
                            Xsdd_zhub byDdh1 = iXsdd_zhubDao.findByDdh(ytdjh);//【销售订单主表】
                            Xsdd_zib byZhubIdAndHh1 = iXsdd_zibDao.findByZhubIdAndHh(byDdh1.getXsdd_zhub_id(), ythh);//【销售订单子表】

                            byZhubIdAndHh1.setLjkpsl(byZhubIdAndHh1.getLjkpsl()+count);//设置累计开票数量
                            if(byZhubIdAndHh1.getLjkpsl() == byZhubIdAndHh1.getCount()){//行 开票完毕
                                byZhubIdAndHh1.setSfkpgb(1);
                                //由于修改了 子表行的开票结束标志，所以需要判断主表的开票标志
                                List<Xsdd_zib> byZhubId = iXsdd_zibDao.findByZhubId(byDdh1.getXsdd_zhub_id());
                                int flag1 = 1;
                                //遍历所有该主表下的子表（除了当前的byZhubIdAndHh1）
                                for (Xsdd_zib xsdd_zib:byZhubId) {
                                    if(xsdd_zib.getXsdd_zib_id() != byZhubIdAndHh1.getXsdd_zib_id()){
                                        if(xsdd_zib.getSfkpgb() == 0){
                                            flag = 0;
                                            break;
                                        }
                                    }
                                }
                                if(flag1 == 1){
                                    byDdh1.setKpbz(1);
                                }else {
                                    byDdh1.setKpbz(0);
                                }
                            }
                            iXsdd_zibDao.updateById(byZhubIdAndHh1);//修改销售订单子表
                            iXsdd_zhubDao.updateById(byDdh1);//修改销售订单主表

                        }else {//若累计开票数量 < 【销售发货单子表】的实发发货数量
                            /**
                             * 上面一样
                             */
                            //1，先修改对应的【销售发货单】
                            byZhubIdAndHh.setLjkpsl(afterLjkpsl);//修改【销售发货单子表】的累计开票数量
                            iXsfhd_zibDao.updateById(byZhubIdAndHh);

                            //2，再修改所有 来源单据号和来源行号 是该【销售发货单】的销售开票单
                            List<Xskpd_zib> xskpd_zibs = iXskpd_zibDao.findByLydjhAndLyhh(lydjh,lyhh);
                            for (Xskpd_zib xskpd_zib1:xskpd_zibs) {
                                if(xskpd_zib1 != null){
                                    xskpd_zib1.setLjkpsl(afterLjkpsl);
                                    iXskpd_zibDao.updateById(xskpd_zib1);
                                }
                            }

                            //3，再修改对应的【销售订单】
                            String ytdjh = xskpd_zib.getYtdjh();//源头单据号：销售订单主表单据号djh
                            Integer ythh = xskpd_zib.getYthh();//源头行号：销售订单子表行号hh
                            Xsdd_zhub byDdh1 = iXsdd_zhubDao.findByDdh(ytdjh);//【销售订单主表】
                            Xsdd_zib byZhubIdAndHh1 = iXsdd_zibDao.findByZhubIdAndHh(byDdh1.getXsdd_zhub_id(), ythh);//【销售订单子表】
                            byZhubIdAndHh1.setLjkpsl(byZhubIdAndHh1.getLjkpsl()+count);//设置累计开票数量
                            iXsdd_zibDao.updateById(byZhubIdAndHh1);//修改销售订单子表
                        }
                    }
                }
            }
        }
        //3 修改主表
        for (Integer id:IDS) {
            if(id!=null){
                Xskpd_zib byId = iXskpd_zibDao.findById(id);
                if(byId != null){
                    Xskpd_zhub byId1 = iXskpd_zhubDao.findById(byId.getXskpd_zhub_id());
                    byId1.setXgr(xgr);
                    byId1.setXgrq(xgrq);
                    int flag2 = 1;
                    List<Xskpd_zib> byZhubId = iXskpd_zibDao.findByZhubId(byId1.getXskpd_zhub_id());
                    for (Xskpd_zib x:byZhubId) {
                        if(x.getStatus() == 0){
                            flag2 = 0;
                            break;
                        }
                    }
                    if(flag2 == 1){
                        byId1.setStatus(1);
                    }else {
                        byId1.setStatus(0);
                    }
                    iXskpd_zhubDao.updateById(byId1);
                    break;
                }
            }
        }
    }


}
