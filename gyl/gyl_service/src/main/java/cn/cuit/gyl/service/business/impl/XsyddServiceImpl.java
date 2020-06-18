package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IXsydd_zhubDao;
import cn.cuit.gyl.dao.business.IXsydd_zibDao;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.IXsyddService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("xsyddServiceImpl")
public class XsyddServiceImpl implements IXsyddService {

    @Autowired
    @Qualifier("iXsydd_zhubDao")
    IXsydd_zhubDao iXsydd_zhubDao = null;

    @Autowired
    @Qualifier("iXsydd_zibDao")
    IXsydd_zibDao iXsydd_zibDao = null;

    @Override
    public List<Xsydd_zhub> findXsydd_zhub(Xsydd_zhub xsydd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsydd_zhub> handler = new DomainAttrValueConverterUtils<>(xsydd_zhub);
        Xsydd_zhub x = handler.handler(null, "sfsp","spsftg","status");
        List<Xsydd_zhub> xsydd_zhubs = iXsydd_zhubDao.findByXsydd_zhub(x);
        return xsydd_zhubs;
    }

    @Override
    public List<Xsydd_zib> findXsydd_zibByZhubId(Integer xsydd_zhub_id) throws Exception {
        List<Xsydd_zib> xsydd_zibs = iXsydd_zibDao.findXsydd_zibByZhubId(xsydd_zhub_id);
        return xsydd_zibs;
    }

    @Override
    public void saveZhub(Xsydd_zhub xsydd_zhub) throws Exception {
        iXsydd_zhubDao.save(xsydd_zhub);
    }

    @Override
    public void deleteZhubById(Integer xsydd_zhub_id) throws Exception {
        iXsydd_zhubDao.deleteById(xsydd_zhub_id);
    }

    @Override
    public void deleteZhubByIds(String ids) throws Exception {
        int count = (ids.length()+1)/2;
        Integer[] IDS = new Integer[count];
        String[] str = ids.split(",");
        for (int i = 0; i < str.length; i++) {
            IDS[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < IDS.length; i++) {
            iXsydd_zhubDao.deleteById(IDS[i]);
        }
    }

    @Override
    public Xsydd_zhub findXsydd_zhubById(Integer xsydd_zhub_id) throws Exception {
        Xsydd_zhub xsydd_zhub = iXsydd_zhubDao.findById(xsydd_zhub_id);
        return xsydd_zhub;
    }


    @Override
    public void updateXsydd_zhubById(Xsydd_zhub xsydd_zhub) throws Exception {
        //1,根据主表id更新信息
        iXsydd_zhubDao.updateById(xsydd_zhub);
        return;
    }

    @Override
    public Long getZib_hhByZhub_id(Integer zhub_id) throws Exception {
        Long hh = iXsydd_zibDao.findMaxOfhh(zhub_id);
        if(hh == null){
            return 1L;
        }
        return hh+1;
    }

    @Override
    public void saveZib(Xsydd_zib xsydd_zib) throws Exception {
        iXsydd_zibDao.save(xsydd_zib);
        return;
    }

    @Override
    public void deleteZibById(Integer xsydd_zib_id) throws Exception {
        iXsydd_zibDao.deleteById(xsydd_zib_id);
        return;
    }

    @Override
    public void deleteZibByIds(String ids) throws Exception{
        Integer[] IDS = StringToIntegerUtils.converter(ids, ",");
        for (int i = 0; i < IDS.length; i++) {
            iXsydd_zibDao.deleteById(IDS[i]);
        }
    }

    @Override
    public Xsydd_zib findXsydd_zibById(Integer xsydd_zib_id) throws Exception {
        Xsydd_zib xsydd_zib = iXsydd_zibDao.findById(xsydd_zib_id);
        return xsydd_zib;
    }

    @Override
    public void updateXsydd_zibById(Xsydd_zib xsydd_zib) throws Exception {
        iXsydd_zibDao.updateById(xsydd_zib);
    }

    @Override
    public void saveZhubAndZib(Xsydd_zhub xsydd_zhub) throws Exception {
        //1,先添加主表
        iXsydd_zhubDao.save(xsydd_zhub);
        //2,根据单据号ddh查询出主表信息,得到主表id
        Xsydd_zhub xsydd_zhub1 = iXsydd_zhubDao.findByDdh(xsydd_zhub.getDdh());
        Integer xsydd_zhub_id = xsydd_zhub1.getXsydd_zhub_id();
        //3,根据id添加子表
        List<Xsydd_zib> xsydd_zibs = xsydd_zhub.getXsydd_zibs();
        if(xsydd_zibs != null){
            for (Xsydd_zib xsydd_zib:xsydd_zibs) {
                //商品编号不为null
                if(xsydd_zib.getSpbh() != null){
                    xsydd_zib.setXsydd_zhub_id(xsydd_zhub_id);
                    iXsydd_zibDao.save(xsydd_zib);
                }
            }
        }
    }

    @Override
    public List<Xsydd_zhub> findByAllAndSfspIsZero(Xsydd_zhub xsydd_zhub) throws Exception {
        DomainAttrValueConverterUtils<Xsydd_zhub> handler = new DomainAttrValueConverterUtils<>(xsydd_zhub);
        Xsydd_zhub x = handler.handler(null,"sfsp","spsftg","status");
        List<Xsydd_zhub> xsydd_zhubs = iXsydd_zhubDao.findByAllAndSfspIsZero(x);
        return xsydd_zhubs;
    }

    @Override
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception {
        Xsydd_zhub xsydd_zhub = iXsydd_zhubDao.findByDdh(ddh);
        if(xsydd_zhub.getSfsp() == 0){
            //还没审批，则修改
            xsydd_zhub.setSfsp(1);
            xsydd_zhub.setSpsftg(0);
            xsydd_zhub.setSpr(spr);
            xsydd_zhub.setSprq(sprq);
            iXsydd_zhubDao.updateById(xsydd_zhub);
        }else {
            //已经审批
            throw new MyException("已经审批！");
        }
    }

    @Override
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception {
        Xsydd_zhub xsydd_zhub = iXsydd_zhubDao.findByDdh(ddh);
        if(xsydd_zhub.getSfsp() == 0){
            //还没审批，则修改
            xsydd_zhub.setSfsp(1);
            xsydd_zhub.setSpsftg(1);
            xsydd_zhub.setSpr(spr);
            xsydd_zhub.setSprq(sprq);
            iXsydd_zhubDao.updateById(xsydd_zhub);
        }else {
            //已经审批
            throw new MyException("已经审批！");
        }
    }
}
