package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.PanDDao;
import cn.cuit.gyl.dao.business.PanDZiDao;
import cn.cuit.gyl.dao.database.IProductDao;
import cn.cuit.gyl.dao.database.IStoreDao;
import cn.cuit.gyl.domain.business.PanDian;
import cn.cuit.gyl.domain.business.PanDianZi;
import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.database.Store;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.PanDianService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.StringConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("PanDianService")
public class PanDianServiceImpl implements PanDianService {
    @Autowired
    @Qualifier("PanDDao")
    PanDDao panDDao;

    @Autowired
    @Qualifier("PanDZiDao")
    PanDZiDao panDZiDao;

    @Autowired
    @Qualifier("iStoreDao")
    IStoreDao iStoreDao;

    @Autowired
    @Qualifier("iProductDao")
    IProductDao iProductDao;


    public List<PanDian> findByCondition(PanDian panDian) throws Exception{
        DomainAttrValueConverterUtils<PanDian> handler=new DomainAttrValueConverterUtils<>(panDian);
        PanDian status = handler.handler(null, "status");
        List<PanDian> byCondition = panDDao.findByCondition(status);
        return byCondition;
    }

    @Override
    public List<PanDianZi> findZiByZid(Long zid) throws Exception {
        List<PanDianZi> byZid = panDZiDao.findByZid(zid);
        return byZid;
    }

    @Override
    public void Save(PanDian panDian) throws Exception {
        if (panDian.getCk()!=null){
            Store byCkbm = iStoreDao.findByCkbm(panDian.getCk());
            if (byCkbm == null){
                throw new MyException("仓库不存在");
            }
        }
        panDDao.Add(panDian);
        if (panDian.getPanDianZis()!=null){
            List<PanDianZi> panDianZis = panDian.getPanDianZis();
            for (PanDianZi x:panDianZis){
                PanDian panDian1 = panDDao.FindByDjh(panDian.getDjh());
                x.setZid(panDian1.getId());
                if (x.getChbm()!= null){
                    Product byPnum = iProductDao.findByPnum(x.getChbm());
                    if (byPnum == null){
                        throw new MyException("该存货不存在");
                    }
                    if (panDian.getCk()!=null){
                        Store byCkbm = iStoreDao.findByCkbm(panDian.getCk());
                        Integer id = byCkbm.getId();
                        Store_Product byStoreIdAndpNum = iStoreDao.findByStoreIdAndpNum(id, x.getChbm());
                        if (byStoreIdAndpNum == null){
                            throw new MyException("该存货不在这个仓库");
                        }
                        x.setZmsl(byStoreIdAndpNum.getStockNumber());
                        panDZiDao.Add(x);
                    }

                }

            }

        }

    }

    @Override
    public Long getHh(Long zid) throws Exception {
        List<PanDianZi> byZid = panDZiDao.findByZid(zid);
        Long x = Long.valueOf(0);
        if (byZid!=null){
            for (PanDianZi a:byZid){
                if (a.getHh()!=null){
                    if (a.getHh()>=x){
                        x = a.getHh()+1;
                    }
                }
            }
        }
        return x;
    }

    @Override
    public void SaveZi(PanDianZi x) throws Exception {
        if (x.getZid()!=null){
            Long zid = x.getZid();
            PanDian panDian = panDDao.FindById(zid);
            if (x.getChbm()!=null) {
                Product byPnum = iProductDao.findByPnum(x.getChbm());
                if (byPnum == null){
                    throw new MyException("该存货不存在");
                }
                if (panDian.getCk()!=null){
                    Store byCkbm = iStoreDao.findByCkbm(panDian.getCk());
                    Integer id = byCkbm.getId();
                    Store_Product byStoreIdAndpNum = iStoreDao.findByStoreIdAndpNum(id, x.getChbm());
                    if (byStoreIdAndpNum == null){
                        throw new MyException("该存货不在这个仓库");
                    }
                    x.setZmsl(byStoreIdAndpNum.getStockNumber());
                    panDZiDao.Add(x);
                }
            }
        }
        else {
            throw new MyException("主id为空");
        }
    }

    @Override
    public PanDian findZhuById(Long id) throws Exception {
        PanDian panDian = panDDao.FindById(id);
        return panDian;
    }

    @Override
    public PanDianZi findZiById(Long id) throws Exception {
        PanDianZi panDianZi = panDZiDao.FindById(id);
        return panDianZi;
    }

    @Override
    public void UpdateZhuB(PanDian panDian) throws Exception {
        if (panDian.getCk()!=null){
            Store byCkbm = iStoreDao.findByCkbm(panDian.getCk());
            if (byCkbm == null){
                throw new MyException("仓库不存在");
            }
            panDDao.Update(panDian);
        }else {
            throw new MyException("仓库为空");
        }

    }

    @Override
    public void DeleteZhuB(Long id) throws Exception {
        panDZiDao.DeleteByZid(id);
        panDDao.DeleteById(id);
    }

    @Override
    public void DeleteZhuBs(String ids) throws Exception {
        Long[] Zids = StringConverterUtils.convertToLong(ids,",");
        for (Long a:Zids){
            panDZiDao.DeleteByZid(a);
            panDDao.DeleteById(a);
        }

    }

    @Override
    public void UpdateZib(PanDianZi panDianZi, String xgr, Date xgrq) throws Exception {
        Long zid = panDianZi.getZid();
        PanDian panDian = panDDao.FindById(zid);
        if (panDianZi.getChbm()!=null){
            Product byPnum = iProductDao.findByPnum(panDianZi.getChbm());
            if (byPnum == null){
                throw new MyException("该存货不存在");
            }
            if (panDian.getCk()!=null){
                Store byCkbm = iStoreDao.findByCkbm(panDian.getCk());
                Integer id = byCkbm.getId();
                Store_Product byStoreIdAndpNum = iStoreDao.findByStoreIdAndpNum(id, panDianZi.getChbm());
                if (byStoreIdAndpNum == null){
                    throw new MyException("该存货不在这个仓库");
                }
                if (panDianZi.getZmsl() == null){
                    throw new MyException("账面数量为空");
                }
                byStoreIdAndpNum.setStockNumber(panDianZi.getZmsl());
                if (panDianZi.getPdsl() != null){
                    panDianZi.setCysl(panDianZi.getZmsl() - panDianZi.getPdsl());
                    panDianZi.setSslv((double) (panDianZi.getCysl()/panDianZi.getZmsl()));
                }
                panDZiDao.Update(panDianZi);
                panDian.setXgr(xgr);
                panDian.setXgrq(xgrq);
                panDDao.Update(panDian);
            }

        }else {
            throw new MyException("存货编码为空");
        }
    }

    @Override
    public void DeleteZib(Long id) throws Exception {
        panDZiDao.DeleteById(id);
    }
    @Override
    public void DeleteZiBs(String ids) throws Exception {
        Long[] Zids = StringConverterUtils.convertToLong(ids,",");
        for (Long a:Zids){
            panDZiDao.DeleteById(a);
        }

    }

    @Override
    public void spNo(String djh, String spr, Date sprq) throws Exception {
        PanDian panDian = panDDao.FindByDjh(djh);
        if (panDian.getZdr()!=null&&panDian.getZdr().equals(spr)){
            throw new MyException("制单人不能与审批人一样");
        }
        panDian.setStatus(0);
        panDian.setSpr(spr);
        panDian.setSprq(sprq);
        panDDao.Update(panDian);
    }

    @Override
    public void spOk(String djh, String spr, Date sprq) throws Exception {
        PanDian panDian = panDDao.FindByDjh(djh);
        if (panDian.getZdr()!=null&&panDian.getZdr().equals(spr)){
            throw new MyException("制单人不能与审批人一样");
        }
        panDian.setStatus(1);
        panDian.setSpr(spr);
        panDian.setSprq(sprq);
        panDDao.Update(panDian);
    }

    @Override
    public void PanD(PanDianZi panDianZi, String pdr, Date pdrq) throws Exception {
        panDianZi.setCysl(panDianZi.getZmsl()-panDianZi.getPdsl());//生产差异数量
        panDianZi.setSslv(((double)panDianZi.getCysl()/(double)panDianZi.getZmsl()));//计算损失率
        panDZiDao.Update(panDianZi);
        Long zid = panDianZi.getZid();
        PanDian panDian = panDDao.FindById(zid);
        panDian.setPdr(pdr);
        panDian.setPdrq(pdrq);
        panDDao.Update(panDian);
    }

    @Override
    public void TiaoZ(PanDianZi panDianZi, String tzr, Date tzrq) throws Exception {
        if (panDianZi.getTzsl()!=null&&panDianZi.getPdsl()!=null){
            panDianZi.setCysl(panDianZi.getZmsl()-panDianZi.getPdsl());//生成差异数量
            panDianZi.setSslv(((double)panDianZi.getCysl()/(double)panDianZi.getZmsl()));//计算损失率
            PanDian panDian1 = panDDao.FindById(panDianZi.getZid());//得到主表的信息
            Store byCkbm = iStoreDao.findByCkbm(panDian1.getCk());//得到仓库的编码
            Store_Product byStoreIdAndpNum = iStoreDao.findByStoreIdAndpNum(byCkbm.getId(), panDianZi.getChbm());//得到仓库与存货的联系的表
//            System.out.println("sslv=="+panDianZi.getSslv());
            if (panDianZi.getSslv()>0){//判断是增加还是减少系统的数量
                byStoreIdAndpNum.setStockNumber(panDianZi.getZmsl()-panDianZi.getTzsl());
            }else {
                byStoreIdAndpNum.setStockNumber(panDianZi.getZmsl()+panDianZi.getTzsl());
            }//修改系统的数量

            if (!byStoreIdAndpNum.getStockNumber().equals(panDianZi.getPdsl())){
                System.out.println(byStoreIdAndpNum.getStockNumber()+"-----"+panDianZi.getPdsl());
                throw new MyException("调整后的数量与盘点数量不相等");
            }
            iStoreDao.updateStockNumberByStoreIdAndPnum(byStoreIdAndpNum);
//            System.out.println("Number"+byStoreIdAndpNum.getStockNumber());
            panDianZi.setZmsl(byStoreIdAndpNum.getStockNumber());//修改账面数量
            panDZiDao.Update(panDianZi);
            Long zid = panDianZi.getZid();
            PanDian panDian = panDDao.FindById(zid);
            panDian.setTzr(tzr);
            panDian.setTzrq(tzrq);
            panDDao.Update(panDian);
        }else {
            throw new MyException("盘点数量或调整数量为空");
        }

    }
}
