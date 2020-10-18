package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.*;
import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.ICgfpService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.StringToIntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("cgfpServiceImpl")
public class CgfpServiceImpl implements ICgfpService {

    @Autowired
    @Qualifier("iCgfp_zhubDao")
    ICgfp_zhubDao iCgfp_zhubDao=null;

    @Autowired
    @Qualifier("iCgfp_zibDao")
    ICgfp_zibDao iCgfp_zibDao=null;

    @Autowired
    @Qualifier("cgdddao")
    cgdddao cgdd_zhubDao=null;

    @Autowired
    @Qualifier("cgddzhidao")
    cgddzhidao cgdd_zibDao=null;

    @Autowired
    @Qualifier("iCgdhd_zibDao")
    ICgdhd_zibDao cgdhg_zibDao=null;

    @Autowired
    @Qualifier("CgygzibDao")
    CgygzibDao cgygd_zibDao=null;

    @Override
    public void saveZhubAndZib(Cgfp_zhub cgfp_zhub) throws Exception {
        //保存主表
        iCgfp_zhubDao.save(cgfp_zhub);
        //用发票号获取主表id
        Cgfp_zhub cgfp_zhub1 = iCgfp_zhubDao.findByFph(cgfp_zhub.getFph());
        Integer cgfp_zhub_id=cgfp_zhub1.getCgfp_zhub_id();
        List<Cgfp_zib> cgfp_zibs=cgfp_zhub.getCgfp_zibs();
        if(cgfp_zibs!=null){
            for (Cgfp_zib cgfp_zib : cgfp_zibs) {
                if(cgfp_zib.getHh()!=null){
                    cgfp_zib.setCgfp_zhub_id(cgfp_zhub_id);
                    cgfp_zib.setBz(cgfp_zhub1.getBz());
                    iCgfp_zibDao.save(cgfp_zib);
                }
            }
        }

    }

    @Override
    public List<Cgfp_zhub> findByCgfp_zhub(Cgfp_zhub cgfp_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgfp_zhub> handler = new DomainAttrValueConverterUtils<>(cgfp_zhub);
        //若前端是否已付应传未进行选择，则把默认值-1转为null
        Cgfp_zhub c1=handler.handler(null,"sfsp","spsftg","isycyf","status");
        List<Cgfp_zhub> Cgfp_zhubs=iCgfp_zhubDao.findByAll(c1);
//        for (Cgfp_zhub cgfp_zhubs : Cgfp_zhubs) {
//            System.out.println(cgfp_zhubs);
//        }
        return Cgfp_zhubs;
    }

    @Override
    public Cgfp_zhub findCgfp_zhubById(Integer cgfp_zhub_id) throws Exception {
        Cgfp_zhub cgfp_zhub = iCgfp_zhubDao.findById(cgfp_zhub_id);
        return cgfp_zhub;
    }

    @Override
    public void updateCgfp_zhubById(Cgfp_zhub cgfp_zhub) throws Exception {
        iCgfp_zhubDao.updateById(cgfp_zhub);
    }

    @Override
    public void deleteCgfp_ZhubById(Integer cgfp_zhub_id) throws Exception {
        iCgfp_zhubDao.deleteById(cgfp_zhub_id);

    }

    @Override
    public void deleteCgfp_ZhubByIds(String ids) throws Exception {
        Integer[] ids1= StringToIntegerUtils.converter(ids,",");
        for (Integer id : ids1) {
            iCgfp_zhubDao.deleteById(id);
        }
    }

    @Override
    public void saveCgfp_zhub(Cgfp_zhub cgfp_zhub) throws Exception {
        iCgfp_zhubDao.save(cgfp_zhub);
    }

    @Override
    public List<Cgfp_zib> findCgfp_zibByZhubId(Integer cgfp_zhub_id) throws Exception {
        List<Cgfp_zib> cgfp_zibs=iCgfp_zibDao.findByZhubId(cgfp_zhub_id);
        return cgfp_zibs;
    }

    @Override
    public Cgfp_zib findCgfp_zibById(Integer cgfp_zib_id) throws Exception {
        Cgfp_zib cgfp_zib=iCgfp_zibDao.findById(cgfp_zib_id);
        return cgfp_zib;
    }

    @Override
    public void updateCgfp_zibById(Cgfp_zib cgfp_zib) throws Exception {
        iCgfp_zibDao.updateById(cgfp_zib);
    }

    @Override
    public void deleteCgfp_ZibById(Integer cgfp_zib_id) throws Exception {
        iCgfp_zibDao.deleteById(cgfp_zib_id);
    }

    @Override
    public Long getZib_hhByZhub_id(Integer cgfp_zhub_id) throws Exception {
        Long hh =iCgfp_zibDao.findMaxHhByZhubId(cgfp_zhub_id);
        if(hh==null){
            return 1L;
        }
        return hh+1;
    }

    @Override
    public void saveCgfp_zib(Cgfp_zib cgfp_zib) throws Exception {
        iCgfp_zibDao.save(cgfp_zib);
    }

    @Override
    public void deleteCgfp_ZibByIds(String ids) throws Exception {
        Integer[] ids1=StringToIntegerUtils.converter(ids,",");
        for (Integer id : ids1) {
            iCgfp_zibDao.deleteById(id);
        }
    }

    @Override
    public List<Cgfp_zhub> findAllAndSfshIsZero(Cgfp_zhub cgfp_zhub) throws Exception {
        DomainAttrValueConverterUtils<Cgfp_zhub> handler = new DomainAttrValueConverterUtils<>(cgfp_zhub);
        Cgfp_zhub x = handler.handler(null, "sfsp","spsftg","isycyf","status");
        System.out.println(x);
        List<Cgfp_zhub> cgfp_zhubs = iCgfp_zhubDao.findAllAndSfshIsZero(x);
        return cgfp_zhubs;
    }

    @Override
    public void spForbidden(String fph, String spr, Date sprq) throws Exception {
        Cgfp_zhub cgfp_zhub = iCgfp_zhubDao.findByFph(fph);
        if(cgfp_zhub.getSfsp() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            cgfp_zhub.setSfsp(1);
            cgfp_zhub.setSpsftg(0);
            cgfp_zhub.setSpr(spr);
            cgfp_zhub.setSprq(sprq);
            iCgfp_zhubDao.updateById(cgfp_zhub);
        }
    }

    @Override
    public void spAdopt(String fph, String spr, Date sprq) throws Exception {
        Cgfp_zhub cgfp_zhub = iCgfp_zhubDao.findByFph(fph);
        if(cgfp_zhub.getSfsp() == 1){
            throw new MyException("已经审批!不能再审批!");
        }else {
            cgfp_zhub.setSfsp(1);
            cgfp_zhub.setSpsftg(1);
            cgfp_zhub.setSpr(spr);
            cgfp_zhub.setSprq(sprq);
            iCgfp_zhubDao.updateById(cgfp_zhub);
        }
    }

    @Override
    public void updateZibStatusByIds(String ids, String xgr, Date xgsj) throws Exception {
        List<Cgfp_zib> cgfp_zibs = new ArrayList<>();
        Integer[] integers = StringToIntegerUtils.converter(ids, ",");
        int statusFlag = 0;
        for (Integer id : integers) {
            if (id != null) {
                Cgfp_zib cgfp_zib = iCgfp_zibDao.findById(id);
                if (cgfp_zib != null) {
                    if (cgfp_zib.getStatus() == 1) {
                        statusFlag++;
                    }
                    cgfp_zibs.add(cgfp_zib);
                }
            }
        }
        if (statusFlag > 0) {
            throw new MyException("不能重复入库!");
        } else {
            //入库
            int flag = 0;
            for (Integer id : integers) {
                if (id != null) {
                    flag++;
                    Cgfp_zib cgfp_zib = iCgfp_zibDao.findById(id);
                    cgfp_zib.setStatus(1);
                    this.updateCgfp_zibById(cgfp_zib);
                    if (flag > 0) {
                        Integer cgfp_zhub_id = cgfp_zib.getCgfp_zhub_id();
                        Cgfp_zhub cgfp_zhub = iCgfp_zhubDao.findById(cgfp_zhub_id);
                        if(flag(cgfp_zhub_id)){
                            cgfp_zhub.setStatus(1);
                        }
                        cgfp_zhub.setXgr(xgr);
                        cgfp_zhub.setXgrq(xgsj);
                        iCgfp_zhubDao.updateById(cgfp_zhub);
                    }
                }
            }
        }


    }
    private boolean flag(Integer cgfp_zhub_id) throws Exception {
        List<Cgfp_zib> cgfp_zibs = iCgfp_zibDao.findByZhubId(cgfp_zhub_id);
        int flag=0;
        for (Cgfp_zib cgfp_zib : cgfp_zibs) {
            if(cgfp_zib.getStatus()==1){
                flag++;
            }
        }
        if(flag==cgfp_zibs.size()){
            return true;
        }

        return false;
    }

    @Override
    public List<Cgddzhub> getAllOfCgddZhub() {
        List<Cgddzhub> cgdd_zhubs = cgdd_zhubDao.findAllDd();
        return cgdd_zhubs;
    }

    @Override
    public List<Cgddzhib> getAllOfCgddZib() {
        List<Cgddzhib> cgdd_zibs=cgdd_zibDao.findAllOfZib();
        return cgdd_zibs;
    }

    @Override
    public List<Cgdhd_zib> getAllOfCgdhdZib() {
        List<Cgdhd_zib> cgdhd_zibs=cgdhg_zibDao.getAllOfZib();
        return cgdhd_zibs;
    }

    @Override
    public List<Cgygdzhib> getAllOfCgygdZib() {
        List<Cgygdzhib> cgygd_zibs=cgygd_zibDao.getAllOfZib();
        return cgygd_zibs;
    }



}
