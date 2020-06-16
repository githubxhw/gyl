package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IEarlyWarning_XsckDao;
import cn.cuit.gyl.dao.business.IXsdd_zhubDao;
import cn.cuit.gyl.dao.business.IXsdd_zibDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.domain.business.Xsdd_zhub;
import cn.cuit.gyl.domain.business.Xsdd_zib;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.IXsddService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("xsddServiceImpl")
public class XsddServiceImpl implements IXsddService {

    @Autowired
    @Qualifier("iXsdd_zhubDao")
    IXsdd_zhubDao iXsdd_zhubDao = null;

    @Autowired
    @Qualifier("iXsdd_zibDao")
    IXsdd_zibDao iXsdd_zibDao = null;

    @Autowired
    @Qualifier("iEarlyWarning_XsckDao")
    IEarlyWarning_XsckDao iEarlyWarning_xsckDao = null;

    @Override
    public void saveZhubAndZib(Xsdd_zhub xsdd_zhub) throws Exception {
        //1,先添加主表
        iXsdd_zhubDao.save(xsdd_zhub);
        //2,根据单据号ddh查询出主表信息,得到主表id
        Xsdd_zhub xsdd_zhub1 = iXsdd_zhubDao.findByDdh(xsdd_zhub.getDdh());
        Integer xsdd_zhub_id = xsdd_zhub1.getXsdd_zhub_id();
        //3,根据id添加子表
        List<Xsdd_zib> xsdd_zibs = xsdd_zhub.getXsdd_zibs();
        if(xsdd_zibs != null){
            for (Xsdd_zib xsdd_zib:xsdd_zibs) {
                if(xsdd_zib.getSpbm() != null){
                    //计算 应发未出库数量 = 数量（Count） - 累计出库数量（Ljcksl）
                    xsdd_zib.setYfwcksl(xsdd_zib.getCount()-xsdd_zib.getLjcksl());
                    xsdd_zib.setXsdd_zhub_id(xsdd_zhub_id);
                    iXsdd_zibDao.save(xsdd_zib);
                }
            }
        }
    }

    @Override
    public List<Xsdd_zhub> findByXsdd_zhub(Xsdd_zhub xsdd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsdd_zhub> handler = new DomainAttrValueConverterUtils<>(xsdd_zhub);
        Xsdd_zhub x = handler.handler(null,"sfsp","spsftg","thbz","fhbz","ckbz","kpbz","ysbz","status");
        //System.out.println(x);
        List<Xsdd_zhub> xsdd_zhubs = iXsdd_zhubDao.findByAll(x);
        return xsdd_zhubs;
    }

    @Override
    public Xsdd_zhub findXsdd_zhubById(Integer xsdd_zhub_id) throws Exception {
        Xsdd_zhub xsdd_zhub = iXsdd_zhubDao.findById(xsdd_zhub_id);
        return xsdd_zhub;
    }

    @Override
    public void updateXsdd_zhubById(Xsdd_zhub xsdd_zhub) throws Exception {
        //判断标志是否关闭，若所有status已经关闭,则不能修改;若没有关闭,则可以修改;
        if(xsdd_zhub.getStatus() == 0){
            iXsdd_zhubDao.updateById(xsdd_zhub);
        }else {
            throw new MyException("status已经关闭!");
        }
    }

    @Override
    public void deleteXsdd_ZhubById(Integer xsdd_zhub_id) throws Exception {
        iXsdd_zhubDao.deleteById(xsdd_zhub_id);
        return;
    }

    @Override
    public void deleteXsdd_ZhubByIds(String ids) throws Exception {
        Integer[] IDS = StringToIntegerUtils.converter(ids, ",");
        for (int i = 0; i < IDS.length; i++) {
            iXsdd_zhubDao.deleteById(IDS[i]);
        }
    }

    @Override
    public void saveXsdd_zhub(Xsdd_zhub xsdd_zhub) throws Exception {
        iXsdd_zhubDao.save(xsdd_zhub);
    }

    @Override
    public List<Xsdd_zib> findXsdd_zibByZhubId(Integer xsdd_zhub_id) throws Exception {
        List<Xsdd_zib> xsdd_zibs = iXsdd_zibDao.findByZhubId(xsdd_zhub_id);
        return xsdd_zibs;
    }

    @Override
    public Xsdd_zib findXsdd_zibById(Integer xsdd_zib_id) throws Exception {
        Xsdd_zib xsdd_zib = iXsdd_zibDao.findById(xsdd_zib_id);
        return xsdd_zib;
    }

    @Override
    public void updateXsdd_zibById(Xsdd_zib xsdd_zib) throws Exception {
        //若status是关闭状态，则不能修改
        if(xsdd_zib.getStatus() == 0){
            iXsdd_zibDao.updateById(xsdd_zib);
        }else {
            throw new MyException("status已经关闭!");
        }
    }

    @Override
    public void deleteXsdd_ZibById(Integer xsdd_zib_id) throws Exception {
        iXsdd_zibDao.deleteById(xsdd_zib_id);
    }

    @Override
    public Long getZib_hhByZhub_id(Integer xsdd_zhub_id) throws Exception {
        Long hh = iXsdd_zibDao.findMaxHhByZhubId(xsdd_zhub_id);
        if(hh == null){
            return 1L;
        }
        return hh+1;
    }

    @Override
    public void saveXsdd_zib(Xsdd_zib xsdd_zib) throws Exception {
        //System.out.println(xsdd_zib);
        if(xsdd_zib.getSpbm() != null){
            //计算 应发未出库数量 = 数量（Count） - 累计出库数量（Ljcksl）
            xsdd_zib.setYfwcksl(xsdd_zib.getCount()-xsdd_zib.getLjcksl());
            System.out.println(xsdd_zib);
            iXsdd_zibDao.save(xsdd_zib);
        }
    }

    @Override
    public void deleteXsdd_ZibByIds(String ids) throws Exception {
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        for (Integer integer:integers) {
            iXsdd_zibDao.deleteById(integer);
        }
    }

    @Override
    public List<Xsdd_zhub> findByAllAndSfspIsZero(Xsdd_zhub xsdd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsdd_zhub> handler = new DomainAttrValueConverterUtils<>(xsdd_zhub);
        Xsdd_zhub x = handler.handler(null,"sfsp","spsftg","thbz","fhbz","ckbz","kpbz","ysbz","status");
        List<Xsdd_zhub> xsdd_zhubs = iXsdd_zhubDao.findByAllAndSfspIsZero(x);
        return xsdd_zhubs;
    }

    @Override
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception {
        Xsdd_zhub xsdd_zhub = iXsdd_zhubDao.findByDdh(ddh);
        if(xsdd_zhub.getSfsp() == 0){
            //还没审批，则修改
            xsdd_zhub.setSfsp(1);
            xsdd_zhub.setSpsftg(0);
            xsdd_zhub.setSpr(spr);
            xsdd_zhub.setSprq(sprq);
            iXsdd_zhubDao.updateById(xsdd_zhub);
        }else {
            //已经审批
            throw new MyException("已经审批！");
        }
    }

    @Override
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception {
        Xsdd_zhub xsdd_zhub = iXsdd_zhubDao.findByDdh(ddh);
        if(xsdd_zhub.getSfsp() == 0){
            //还没审批，则修改
            xsdd_zhub.setSfsp(1);
            xsdd_zhub.setSpsftg(1);
            xsdd_zhub.setSpr(spr);
            xsdd_zhub.setSprq(sprq);
            iXsdd_zhubDao.updateById(xsdd_zhub);

            String ddh1 = xsdd_zhub.getDdh();
            //生成销售出库预警表
            List<Xsdd_zib> xsdd_zibs = iXsdd_zibDao.findByZhubId(xsdd_zhub.getXsdd_zhub_id());
            if(xsdd_zibs!=null){
                for (Xsdd_zib x : xsdd_zibs){
                    EarlyWarning_Xsck earlyWarning_xsck = new EarlyWarning_Xsck();
                    earlyWarning_xsck.setDdh(ddh1);//销售订单号
                    earlyWarning_xsck.setHh(x.getHh());//行号
                    earlyWarning_xsck.setProductNum(x.getSpbm());//商品编码
                    earlyWarning_xsck.setProductName(x.getSpmc());//商品名称
                    earlyWarning_xsck.setYqfhrq(x.getYqshrq());//要求发货日期
                    earlyWarning_xsck.setCheckDays(3);//需要修改，从数据库中查询数据 预警的天数：在要求发货日期的前checkDays内开始预警
                    earlyWarning_xsck.setInvalidDays(2);//需要修改，从数据库中查询数据 预警失效天数：意思是如果要求发货日期到仍然没有发货，那么依然需要预警（即status状态为1），连续预警invalidDays后就不在预警了（即修改staus为0）；\r\n说明，没有值情况下默认不预警。
                    earlyWarning_xsck.setStatus(1);//预警状态 是否需要预警 1是 0否
                    //添加一条数据
                    iEarlyWarning_xsckDao.saveEWXNotHasId(earlyWarning_xsck);
                }
            }
        }else {
            //已经审批
            throw new MyException("已经审批！");
        }
    }
}
