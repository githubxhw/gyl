package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.CgygDao;
import cn.cuit.gyl.dao.business.CgygzibDao;
import cn.cuit.gyl.dao.database.GysDao;
import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.Cgddzhub;
import cn.cuit.gyl.domain.business.Cgygdzhib;
import cn.cuit.gyl.domain.business.Cgygdzhub;
import cn.cuit.gyl.domain.database.gys;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.CgygdService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.StringConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CgYgdServiceImpl implements CgygdService {
    @Autowired
    @Qualifier("cgdddao")
    private cn.cuit.gyl.dao.business.cgdddao cgdddao;
    @Autowired
    @Qualifier("cgddzhidao")
    private cn.cuit.gyl.dao.business.cgddzhidao cgddzhidao;

    @Autowired
    @Qualifier("CgygDao")
    private CgygDao cgygDao;
    @Autowired
    @Qualifier("CgygzibDao")
    private CgygzibDao cgygzibDao;

    @Autowired
    @Qualifier("GysDao")
    GysDao gysDao;

    public List<Cgygdzhub> findByCondition(Cgygdzhub a) throws Exception{
        DomainAttrValueConverterUtils<Cgygdzhub> handler = new DomainAttrValueConverterUtils<>(a);
        Cgygdzhub x = handler.handler(null,"issp","spsftg","status");
        List<Cgygdzhub> byCondition = cgygDao.findByCondition(x);
        return byCondition;
    }

    @Override
    public List<Cgygdzhib> findCgYgZibByZid(Long zid) throws Exception {
        List<Cgygdzhib> byZid = cgygzibDao.findByZid(zid);
        return byZid;
    }

    @Override
    public void SaveCgYgZhuAndZiD(Cgygdzhub a) throws Exception {
        DomainAttrValueConverterUtils<Cgygdzhub> handler = new DomainAttrValueConverterUtils<>(a);
        a = handler.handler(null,"issp","spsftg","status");
        cgygDao.SaveCgYgd(a);
        List<Cgygdzhib> cgqgdzhibs = a.getCgqgdzhibs();
        Cgygdzhub byDjh = cgygDao.findByDjh(a.getDjh());
        if (cgqgdzhibs!=null){
            for (Cgygdzhib x:cgqgdzhibs){
                if (x.getHh() !=null){
                    x.setZid(byDjh.getCgqgdzhubid());
                    cgygzibDao.addCgYgdZib(x);
                }

            }
        }

    }

    @Override
    public Long getHh(Long zid) throws Exception {
        List<Cgygdzhib> byZid = cgygzibDao.findByZid(zid);
        Long x = Long.valueOf(0);

        if(byZid != null){
            for (Cgygdzhib a:byZid ){
                if(a.getHh()>=x){
                    x = a.getHh();
                }
            }
            x = x+1;
        }
        return x;
    }

    @Override
    public void SaveZib(Cgygdzhib a) throws Exception {
        cgygzibDao.addCgYgdZib(a);
    }

    @Override
    public Cgygdzhub findById(Long id) throws Exception {
        Cgygdzhub byId = cgygDao.findById(id);
        return byId;
    }

    @Override
    public void UpdateZhuB(Cgygdzhub a) throws Exception {
        cgygDao.updateCgtgdzhub(a);
    }

    @Override
    public void DeleteZhuB(Long id) throws Exception {
        cgygDao.deleteCgYgdZhuB(id);
        cgygzibDao.deleteCgYgdZib(id);


    }

    @Override
    public void DeleteZhuBs(String ids) throws Exception {
        Long[] zids = StringConverterUtils.convertToLong(ids,",");
        if (zids!=null){
            for (Long x:zids){
                cgygDao.deleteCgYgdZhuB(x);
                cgygzibDao.deleteCgYgdZibById(x);
            }
        }

    }

    @Override
    public Cgygdzhib findCgYgZibById(Long id) throws Exception {
        Cgygdzhib byId = cgygzibDao.findById(id);
        return byId;
    }

    @Override
    public void UpdateZiB(Cgygdzhib a) throws Exception {
        cgygzibDao.updateCgYgdZib(a);
    }

    @Override
    public void DeleteZhiB(Long id) throws Exception {
        cgygzibDao.deleteCgYgdZibById(id);
    }

    @Override
    public void DeleteZhiBs(String ids) throws Exception {
        Long[] zids = StringConverterUtils.convertToLong(ids,",");
        if (zids!=null){
            for (Long x:zids){
                cgygzibDao.deleteCgYgdZibById(x);
            }
        }

    }

    @Override
    public void spOk(String djh, String spr, Date sprq) throws Exception {
        Cgygdzhub byDjh1 = cgygDao.findByDjh(djh);

        if (byDjh1.getZdr()!=null&&byDjh1.getZdr().equals(spr) ){
            throw new MyException("制单人不能和审批人一样");
        }else {
            if((byDjh1.getSpsftg()!=null&&byDjh1.getSpsftg() == 0)||byDjh1.getSpsftg() == null){
                byDjh1.setSpr(spr);
                byDjh1.setSpsftg(1);
                byDjh1.setSprq(sprq);
                byDjh1.setIssp(1);
                cgygDao.updateCgtgdzhub(byDjh1);
                YgBeDd(byDjh1);
            }else {
                throw  new MyException("已经审批合格了");
            }
        }

    }

    @Override
    public void spNo(String djh, String spr, Date sprq) throws Exception {
        Cgygdzhub byDjh = cgygDao.findByDjh(djh);
        if (byDjh.getZdr()!=null&&byDjh.getZdr().equals(spr)){
            throw  new MyException("制单人不能和审批人一样");
        }else {
            if((byDjh.getSpsftg()!=null&&byDjh.getSpsftg() == 0)||byDjh.getSpsftg() == null){
                byDjh.setSpr(spr);
                byDjh.setSpsftg(0);
                byDjh.setSprq(sprq);
                byDjh.setIssp(1);
                cgygDao.updateCgtgdzhub(byDjh);
            }else {
                throw new MyException("已经审批合格了");
            }
        }

    }

    @Override
    public void YgBeDd(Cgygdzhub a) throws Exception {
        Cgddzhub x = new Cgddzhub();
        x.setGs(a.getGs());
        x.setDjh(a.getDjh());
        x.setGys(a.getQggys());
        x.setCgbm(a.getCgbm());
        x.setCgr(a.getCgr());
        x.setDdrq(a.getQgrq());
        x.setStatus(a.getStatus());
        x.setBz(a.getBz());
        x.setZdsl(a.getZdsl());
        x.setZdr(a.getZdr());
        x.setZdrq(a.getZdrq());
        x.setDjzt(0);
        x.setIsth(0);
        x.setDhbz(0);
        x.setRkbz(0);
        x.setKpbz(0);
        x.setYsbz(0);
        x.setIssp(0);
        cgdddao.addCgddzhub(x);
        Cgddzhub byDjh = cgdddao.findByDjh(x.getDjh());
        Long cgddzhubid = byDjh.getCgddzhubid();
        List<Cgygdzhib> byZid = cgygzibDao.findByZid(a.getCgqgdzhubid());
        if(byZid !=null){
            for (Cgygdzhib d:byZid){
                Cgddzhib u = new Cgddzhib();
                u.setLydj(x.getDjh());
                u.setHh(d.getHh());
                u.setZid(cgddzhubid);
                u.setSpbm(d.getSpbm());
                u.setSpmc(d.getSpmc());
                u.setGg(d.getGg());
                u.setDw(d.getDw());
                u.setXh(d.getXh());
                u.setSl(d.getSl());
                u.setHsdj(d.getHsdj());
                u.setWsdj(d.getWsdj());
                u.setShuilv(d.getShuilv());
                u.setHsje(d.getHsje());
                u.setWsje(d.getWsje());
                u.setSe(d.getSe());
                u.setHgb(0);
                u.setLydj(x.getDjh());
                u.setHstatus(u.getHstatus());
                u.setSfdhgb(0);
                u.setSffkgb(0);
                u.setSfkpgb(0);
                u.setSfrkgb(0);
                cgddzhidao.addCgddzhib(u);
            }
        }

    }
    @Override
    public gys FindByGName(String name) throws Exception {
        gys byName = gysDao.findByName(name);
        return byName;
    }

}
