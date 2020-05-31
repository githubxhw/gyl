package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.ICgdhd_zhubDao;
import cn.cuit.gyl.dao.business.ICgdhd_zibDao;
import cn.cuit.gyl.dao.business.cgdddao;
import cn.cuit.gyl.dao.business.cgddzhidao;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.ICgdhdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("cgdhdServiceImpl")
public class CgdhdServiceImpl implements ICgdhdService {

    @Autowired
    @Qualifier("cgdddao")
    private cgdddao iCgdd_zhubDao = null;

    @Autowired
    @Qualifier("cgddzhidao")
    private cgddzhidao iCgdd_zibDao = null;

    @Autowired
    @Qualifier("iCgdhd_zhubDao")
    private ICgdhd_zhubDao iCgdhd_zhubDao = null;

    @Autowired
    @Qualifier("iCgdhd_zibDao")
    private ICgdhd_zibDao iCgdhd_zibDao = null;

    @Override
    public PageInfo saveZhubAndZib(Cgdhd_zhub cgdhd_zhub) throws Exception {
        //先遍历子表进行是否应该添加
        /**
         * 源头单据号
         * cgdd:采购订单
         * 1，代表cgdd单据号有问题
         *      1.1没有此cgdd单据号
         *      1.2该cgdd单据号的主表：发货状态 已经关闭（结束）1
         * 2，代表cgdd子表行号有问题
         *      2.1没有此行号
         *      2.2有该行号但是该商品的发货状态已经是结束 1
         *      2.3有行号，发货状态未结束0，但是商品编码不对应(其实应该验证商品的所有信息，为了简便省略了那些属性)
         *      2.4有行号，发货状态未结束0，商品编码对应，但是应发数量不对
         *      2.5有行号，发货状态未结束0，商品编码对应，但是应发数量对，但是发货数量超过了应发数量
         * 3，来源
         * 来源订单号
         * 来源行号
         */
        PageInfo pageInfo = new PageInfo();
        Long ljdhsl = 0L; //采购订单 累计发到货数量
        //获取子表s
        List<Cgdhd_zib> cgdhd_zibs = cgdhd_zhub.getCgdhd_zibs();
        int addFlag = 1; //1代表可以添加，0代表不可以添加
        if(cgdhd_zibs != null){
            for (Cgdhd_zib cgdhd_zib : cgdhd_zibs) {
                //有编号的商品
                if (cgdhd_zib.getSpbm() != null || "".equals(cgdhd_zib.getSpbm())) {
                    //采购订单判断
                    String ytdjh = cgdhd_zib.getYtdjh();//源头订单号
                    Integer ythh = cgdhd_zib.getYthh();//源头行号
                    Integer hh = cgdhd_zib.getHh();
                    //采购订单主表查询
                    Cgddzhub byDdh = iCgdd_zhubDao.findByDjh(ytdjh);
                    if(byDdh == null){
                        addFlag = 0;
                        //1.1没有此cgdd单据号
                        pageInfo.setResFlag("0");
                        pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"采购订单中没有"+ytdjh+"的单据号!");
                        break;
                    }else {
                        if(byDdh.getDhbz() == 1){//1.2该cgdd单据号的主表：到货状态 已经关闭（结束）1
                            addFlag = 0;
                            pageInfo.setResFlag("0");
                            pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"的采购订单（主表）中到货单状态已经结束!");
                            break;
                        }else {
                            //采购订单子表查询
                            Cgddzhib byZhubIdAndHh = iCgdd_zibDao.findByZIdAndHh(byDdh.getCgddzhubid(), ythh.longValue());
                            if(byZhubIdAndHh == null){ //没有此行号 2.1没有此行号
                                addFlag = 0;
                                pageInfo.setResFlag("0");
                                pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"的采购订单中没有行号为"+ythh+"的商品!");
                                break;
                            }else {
                                if(byZhubIdAndHh.getSfdhgb() == 1){//2.2有该行号但是该商品的到货状态已经是结束 1
                                    addFlag = 0;
                                    pageInfo.setResFlag("0");
                                    pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"订单号为"+ytdjh+"且行号为"+ythh+"的采购订单（子表）中的到货单状态已经结束!");
                                    break;
                                }else {
                                    //商品编码
                                    String spbm1 = byZhubIdAndHh.getSpbm();
                                    String spbm2 = cgdhd_zib.getSpbm();
                                    if(!spbm1.equals(spbm2)){ //2.3有行号，到货状态未结束0，但是商品编码不对应(其实应该验证商品的所有信息，为了简便省略了那些属性)
                                        addFlag = 0;
                                        pageInfo.setResFlag("0");
                                        pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"对应的到货编码不对!");
                                        break;
                                    }else {
                                        //应到数量
                                        Long count = byZhubIdAndHh.getSl();
                                        Long ydsl = cgdhd_zib.getYdsl();
                                        if(count > ydsl){
                                            addFlag = 0;
                                            pageInfo.setResFlag("0");
                                            pageInfo.add("当采购到货单行号为"+hh+"的时候:"+"当前到货数量大于了总采购数量!");
                                            break;
                                        }else {//该到货单子表通过考核
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(addFlag == 1){ //检查了所有子表合理 /*开始添加子表*/
                //添加主表
                iCgdhd_zhubDao.save(cgdhd_zhub);
                //根据单据号ddh查询出主表信息,得到主表id
                Cgdhd_zhub cgdhd_zhub1 = iCgdhd_zhubDao.findByDdh(cgdhd_zhub.getDdh());
                Integer cgdhd_zhub_id = cgdhd_zhub1.getCgdhd_zhub_id();
                if (cgdhd_zibs != null) {
                    for (Cgdhd_zib cgdhd_zib : cgdhd_zibs) {
                        if (cgdhd_zib.getSpbm() != null || "".equals(cgdhd_zib.getSpbm())) {
                            String ytdjh = cgdhd_zib.getYtdjh();//源头订单号
                            Integer ythh = cgdhd_zib.getYthh();//源头行号
                            //主表
                            Cgddzhub byDdh = iCgdd_zhubDao.findByDjh(ytdjh);
                            //子表
                            Cgddzhib byZhubIdAndHh = iCgdd_zibDao.findByZIdAndHh(byDdh.getCgddzhubid(), ythh.longValue());
                            //获取累计到货数量
                            Long ljdhsl1 = byZhubIdAndHh.getLjdhsl();
                            cgdhd_zib.setLjdhsl(ljdhsl1); //设置累计到货数量
                            cgdhd_zib.setCgdhd_zhub_id(cgdhd_zhub_id); //设置采购到货单主表id(外键)
                            iCgdhd_zibDao.save(cgdhd_zib);
                        }
                    }
                }
                pageInfo.setResFlag("1");
            }
        }else {
            //添加主表
            iCgdhd_zhubDao.save(cgdhd_zhub);
            pageInfo.setResFlag("1");
        }
        return pageInfo;
    }


    @Override
    public List<Cgdhd_zhub> findByCgdhd_zhub(Cgdhd_zhub cgdhd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgdhd_zhub> handler = new DomainAttrValueConverterUtils<>(cgdhd_zhub);
        Cgdhd_zhub x = handler.handler(null, "sfsp","spsftg","sfth", "sfrkjs","status");
        List<Cgdhd_zhub> cgdhd_zhubs = iCgdhd_zhubDao.findByZhub(x);
        return cgdhd_zhubs;
    }

    @Override
    public Cgdhd_zhub findCgdhd_zhubById(Integer cgdhd_zhub_id) throws Exception {
        Cgdhd_zhub cgdhd_zhub = iCgdhd_zhubDao.findById(cgdhd_zhub_id);
        return cgdhd_zhub;
    }

    @Override
    public void updateCgdhd_zhubById(Cgdhd_zhub cgdhd_zhub) throws Exception {
        if(cgdhd_zhub.getStatus() == 1){
            throw new MyException("已经结束，不能修改！");
        }
        iCgdhd_zhubDao.updateById(cgdhd_zhub);
    }

    @Override
    public void deleteCgdhd_ZhubById(Integer cgdhd_zhub_id) throws Exception {
        iCgdhd_zhubDao.deleteById(cgdhd_zhub_id);
    }

    @Override
    public void saveCgdhd_zhub(Cgdhd_zhub cgdhd_zhub) throws Exception {
        iCgdhd_zhubDao.save(cgdhd_zhub);
    }

    @Override
    public void deleteCgdhd_ZhubByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer:integers) {
            iCgdhd_zhubDao.deleteById(integer);
        }
    }

    @Override
    public List<Cgdhd_zib> findCgdhd_zibByZhubId(Integer cgdhd_zhub_id) throws Exception {
        List<Cgdhd_zib> cgdhd_zibs = iCgdhd_zibDao.findByZhubId(cgdhd_zhub_id);
        return cgdhd_zibs;
    }

    @Override
    public Cgdhd_zib findCgdhd_zibById(Integer cgdhd_zib_id) throws Exception {
        Cgdhd_zib cgdhd_zib = iCgdhd_zibDao.findById(cgdhd_zib_id);
        return cgdhd_zib;
    }

    @Override
    public void updateCgdhd_zibById(Cgdhd_zib cgdhd_zib) throws Exception {
        Integer status = cgdhd_zib.getStatus();
        //1,判断cgdhd_zib里面的status
        if(status == 0){
            //未结束 直接修改信息
            iCgdhd_zibDao.updateById(cgdhd_zib);
        }else {
            /* 结束
             * 1, 修改当前到货单子表（累计到货数量以及 status-->页面提交设置的）
             * 2, 修改所有的到货单子表（累计到货数量）
             * 3, 修改到货单主表（判断） （status）
             * 4, 修改采购订单子表（累计发货数量以及status）
             * 5, 修改采购订单主表（判断） （dhbz）
             * */
            //1.0 计算 累计到货数量 = 原来的累计到货数量 + 实到数量
            Long ljdhsl = cgdhd_zib.getLjdhsl() + cgdhd_zib.getSdsl();
            //1.1 得到 源头单据号 和 源头行号
            String ytdjh = cgdhd_zib.getYtdjh();
            Integer ythh = cgdhd_zib.getYthh();

            //1.2 修改自己当前子表的属性：累计到货数量ljdhsl
            cgdhd_zib.setLjdhsl(ljdhsl);
            iCgdhd_zibDao.updateById(cgdhd_zib);

            //1.3 修改自己主表的属性 status状态 ，方法 根据主表id查询所有的子表信息，若所有子表status属性都为 1 即结束，则设置主表status为1；否则不修改 0
            List<Cgdhd_zib> cgdhd_zibs1 = iCgdhd_zibDao.findByZhubId(cgdhd_zib.getCgdhd_zhub_id());
            int flag1 = 0;
            for (Cgdhd_zib cgdhd_zib1:cgdhd_zibs1) {
                Integer status1 = cgdhd_zib1.getStatus();
                if(status1 == 1){
                    flag1++;
                }
            }
            if(flag1 == cgdhd_zibs1.size()){
                //status全为1 修改主表status
                Cgdhd_zhub cgdhd_zhub1 = iCgdhd_zhubDao.findById(cgdhd_zib.getCgdhd_zhub_id());
                cgdhd_zhub1.setStatus(1);
                //更新主表status
                iCgdhd_zhubDao.updateById(cgdhd_zhub1);
            }else {
                //status全为0
            }

            //1.4 修改所有“源头单据号” 和 “源头行号”相同的发货子单 属性：累计到货数量ljdhsl
            List<Cgdhd_zib> cgdhd_zibs2 = iCgdhd_zibDao.findByYtdjhAndYthh(ytdjh,ythh);
            for (Cgdhd_zib cgdhd_zib2:cgdhd_zibs2) {
                if(cgdhd_zib2.getCgdhd_zib_id() != cgdhd_zib.getCgdhd_zib_id()){
                    cgdhd_zib2.setLjdhsl(ljdhsl);
                    iCgdhd_zibDao.updateById(cgdhd_zib2);
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
            cgdd_zib1.setLjdhsl(ljdhsl);
            //数量 = 累计到货数量
            if(cgdd_zib1.getSl() == cgdd_zib1.getLjdhsl()){
                //设置子表 是否到货结束 --》1
                cgdd_zib1.setSfdhgb(1);
            }
            iCgdd_zibDao.updateCgddzhib(cgdd_zib1);
            //1.52 修改采购订单主表的属性 “是否到货结束”
            //根据cgdd_zhub_id获取所有的子表，遍历，判断所有子表中属性 “是否到货结束” , 若全部结束，则修改主表
            List<Cgddzhib> cgdd_zibs2 = iCgdd_zibDao.findByzid(cgdd_zhub_id.longValue());
            int flag2 = 0;
            for (Cgddzhib cgdd_zib2:cgdd_zibs2) {
                if(cgdd_zib2.getSfdhgb() == 1){
                    flag2++;
                }
            }
            if(flag2 == cgdd_zibs2.size()){
                //修改主表属性 “是否到货结束”
                cgdd_zhub.setDhbz(1);
                iCgdd_zhubDao.updateCgddzhub(cgdd_zhub);
            }else {
            }
        }
    }

    @Override
    public void deleteCgdhd_ZibById(Integer cgdhd_zib_id) throws Exception {
        iCgdhd_zibDao.deleteById(cgdhd_zib_id);
    }

    @Override
    public void deleteCgdhd_ZibByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer:integers) {
            if(integer != null){
                iCgdhd_zibDao.deleteById(integer);
            }
        }
    }

    @Override
    public Integer getZib_hh(Integer cgdhd_zhub_id) throws Exception {
        Integer hh = iCgdhd_zibDao.findMaxHhByZhubId(cgdhd_zhub_id);
        if(hh == null){
            return 1;
        }
        return hh+1;
    }

    @Override
    public void saveCgdhd_zib(Cgdhd_zib cgdhd_zib) throws Exception {
        iCgdhd_zibDao.save(cgdhd_zib);
    }

    @Override
    public List<Cgdhd_zhub> findAllAndSfspIsZero(Cgdhd_zhub cgdhd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgdhd_zhub> handler = new DomainAttrValueConverterUtils<>(cgdhd_zhub);
        Cgdhd_zhub x = handler.handler(null, "sfsp","spsftg","sfth","sfrkjs","status");
        List<Cgdhd_zhub> cgdhd_zhubs = iCgdhd_zhubDao.findAllAndSfspIsZero(x);
        return cgdhd_zhubs;
    }

    @Override
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception {
        Cgdhd_zhub cgdhd_zhub = iCgdhd_zhubDao.findByDdh(ddh);
        if(cgdhd_zhub.getSfsp() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            cgdhd_zhub.setSfsp(1);
            cgdhd_zhub.setSpsftg(0);
            cgdhd_zhub.setSpr(spr);
            cgdhd_zhub.setSpsj(sprq);
            iCgdhd_zhubDao.updateById(cgdhd_zhub);
        }
    }

    @Override
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception {
        Cgdhd_zhub cgdhd_zhub = iCgdhd_zhubDao.findByDdh(ddh);
        if(cgdhd_zhub.getSfsp() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            cgdhd_zhub.setSfsp(1);
            cgdhd_zhub.setSpsftg(1);
            cgdhd_zhub.setSpr(spr);
            cgdhd_zhub.setSpsj(sprq);
            iCgdhd_zhubDao.updateById(cgdhd_zhub);
        }
    }

    @Override
    public void updateZibStatusByIds(String ids,String xgr, Date xgsj) throws Exception {
        List<Cgdhd_zib> cgdhd_zibs = new ArrayList<>();
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        int statusFlag = 0;
        for (Integer integer:integers) {
            if(integer != null){
                Cgdhd_zib cgdhd_zib = iCgdhd_zibDao.findById(integer);
                if(cgdhd_zib != null){
                    if(cgdhd_zib.getStatus() == 1){
                        statusFlag++;
                    }
                    cgdhd_zibs.add(cgdhd_zib);
                }
            }
        }
        if(statusFlag > 0){
            throw new MyException("不能重复发货!");
        }else {
            //到货
            int flag = 0;
            for (Integer integer:integers) {
                if(integer != null){
                    flag++;
                    Cgdhd_zib cgdhd_zib = iCgdhd_zibDao.findById(integer);
                    cgdhd_zib.setStatus(1);
                    this.updateCgdhd_zibById(cgdhd_zib);
                    if(flag == 1){
                        Integer cgdhd_zhub_id = cgdhd_zib.getCgdhd_zhub_id();
                        Cgdhd_zhub cgdhd_zhub = iCgdhd_zhubDao.findById(cgdhd_zhub_id);
                        cgdhd_zhub.setXgr(xgr);
                        cgdhd_zhub.setXgsj(xgsj);
                        iCgdhd_zhubDao.updateById(cgdhd_zhub);
                    }
                }
            }
        }
    }
}

