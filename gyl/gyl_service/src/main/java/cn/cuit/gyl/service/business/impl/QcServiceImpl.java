package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IQc_zhubDao;
import cn.cuit.gyl.dao.business.IQc_zibDao;
import cn.cuit.gyl.dao.database.IProductDao;
import cn.cuit.gyl.dao.database.IStoreDao;
import cn.cuit.gyl.domain.business.Qc_zhub;
import cn.cuit.gyl.domain.business.Qc_zib;
import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.database.Store;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.IQcService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("qcServiceImpl")
public class QcServiceImpl implements IQcService {

    @Autowired
    @Qualifier("iStoreDao")
    private IStoreDao iStoreDao = null;

    @Autowired
    @Qualifier("iQc_zhubDao")
    private IQc_zhubDao iQc_zhubDao = null;

    @Autowired
    @Qualifier("iQc_zibDao")
    private IQc_zibDao iQc_zibDao = null;

    @Autowired
    @Qualifier("iProductDao")
    private IProductDao iProductDao = null;

    @Override
    public List<Qc_zhub> findZhubByMany(Qc_zhub qc_zhub) throws Exception {
        DomainAttrValueConverterUtils<Qc_zhub> handler = new DomainAttrValueConverterUtils<>(qc_zhub);
        Qc_zhub qc_zhub1 = handler.handler(null, "sfsp","spsftg","status");
        List<Qc_zhub> qc_zhubs = iQc_zhubDao.findByMany(qc_zhub1);
        return qc_zhubs;
    }

    @Override
    public List<Qc_zib> findZibsByZhubId(Long qc_zhub_id) throws Exception {
        List<Qc_zib> qc_zibs = iQc_zibDao.findByZhubId(qc_zhub_id);
        return qc_zibs;
    }

    @Override
    public PageInfo saveZhubAndZib(Qc_zhub qc_zhub) throws Exception {
        PageInfo pageInfo = new PageInfo();//返回提示信息
        pageInfo.setResFlag("1");//默认可以添加

        //验证输入信息准确性：在此主要先验证子表信息
        //验证子表
        List<Qc_zib> qc_zibs = qc_zhub.getQc_zibs();
        if(qc_zibs != null){
            Iterator<Qc_zib> iterator = qc_zibs.iterator();
            while (iterator.hasNext()){
                Qc_zib next = iterator.next();
                if(next.getChbm()!=null && !"".equals(next.getChbm())){
                    Product product = iProductDao.findByPnum(next.getChbm());
                    if(product == null){
                        pageInfo.add("行号为"+next.getHh()+"的列出错：没有此编码！");
                        pageInfo.setResFlag("0");
                        break;
                    }else {
                        //验证许多信息：此处暂时先忽略
                        //验证成功了
                    }
                }else {
                    iterator.remove();//删除这条子表信息
                }
            }
            if("1".equals(pageInfo.getResFlag())) {//暂时可以认为能添加
                //去除商品编码为null的子表后qc_zibs
                //判断 是否存在两行以上的子表 他们的商品编码和仓库编码一样(一样就不能添加)
                List<String> chbm_ckbmList  = new ArrayList<>();
                if(qc_zibs.size() > 2) {//多于2个
                    for (Qc_zib z:qc_zibs) {
                        chbm_ckbmList.add(z.getChbm()+"_"+qc_zhub.getCkbm());
                    }
                    HashSet<String> chbm_ckbmHashSet = new HashSet<>(chbm_ckbmList);
                    if(chbm_ckbmHashSet.size() == chbm_ckbmList.size()){//相等：证明没有重复
                        //真正可以添加了
                        iQc_zhubDao.save(qc_zhub);
                        Qc_zhub qcZhub = iQc_zhubDao.findByDjh(qc_zhub.getDjh());
                        Long zhub_id = qcZhub.getQc_zhub_id();
                        for (Qc_zib qc_zib:qc_zibs) {
                            qc_zib.setQc_zhub_id(zhub_id);
                            iQc_zibDao.save(qc_zib);
                        }
                    }else {//有重复：不能添加，报错
                        pageInfo.setResFlag("0");
                        pageInfo.add("列中有两条以上数据的存货编码和仓库编码都相同，请仔细检查！");
                    }
                }else {//小于2个：1或0个，可以直接添加，不影响
                    iQc_zhubDao.save(qc_zhub);
                    Qc_zhub qcZhub = iQc_zhubDao.findByDjh(qc_zhub.getDjh());
                    Long zhub_id = qcZhub.getQc_zhub_id();
                    if(qc_zibs.size() > 0){
                        for (Qc_zib qc_zib:qc_zibs) {
                            qc_zib.setQc_zhub_id(zhub_id);
                            iQc_zibDao.save(qc_zib);
                        }
                    }
                }
            }else {//直接报错，不能添加
            }
        }else {//由于子表都是null的，可以直接添加即可，无需判断
            iQc_zhubDao.save(qc_zhub);
        }
        return pageInfo;
    }

    @Override
    public Qc_zhub findZhubByZhuId(Long qc_zhub_id) throws Exception {
        Qc_zhub qc_zhub = iQc_zhubDao.findById(qc_zhub_id);
        return qc_zhub;
    }

    @Override
    public void updateZhubByZhubId(Qc_zhub qc_zhub) throws Exception {
        iQc_zhubDao.updateById(qc_zhub);
    }

    @Override
    public void deleteZhubByZhubId(Long qc_zhub_id) throws Exception {
        if(qc_zhub_id!=null){
            iQc_zhubDao.deleteById(qc_zhub_id);
        }
    }

    @Override
    public void deleteZhubsByZhubIds(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        if(IDS != null){
            for (Long zhubId:IDS) {
                if(zhubId!=null){
                    iQc_zhubDao.deleteById(zhubId);
                }
            }
        }
    }

    @Override
    public Qc_zib findZibByZibId(Long qc_zib_id) throws Exception {
        Qc_zib qc_zib = iQc_zibDao.findById(qc_zib_id);
        return qc_zib;
    }

    @Override
    public void updateZibByZibId(Qc_zib qc_zib) throws Exception {
        iQc_zibDao.updateById(qc_zib);
    }

    @Override
    public void deleteZibByZibId(Long qc_zib_id) throws Exception {
        if(qc_zib_id!=null){
            iQc_zibDao.deleteById(qc_zib_id);
        }
    }

    @Override
    public void deleteZibsByZibIds(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids,",");
        if(IDS!=null){
            for (Long id:IDS) {
                if(id!=null){
                    iQc_zibDao.deleteById(id);
                }
            }
        }
    }

    @Override
    public Integer getZibHhByZhubId(Long qc_zhub_id) throws Exception {
        Integer maxHh = iQc_zibDao.findMaxHhByZhbId(qc_zhub_id);
        if(maxHh==null){
            return 1;
        }
        return maxHh+1;
    }

    @Override
    public void saveZib(Qc_zib qc_zib) throws Exception {
        iQc_zibDao.save(qc_zib);
    }

    @Override
    public void spForbidden(String djh, String spr, Date sprq) throws Exception {
        Qc_zhub qc_zhub = iQc_zhubDao.findByDjh(djh);
        if(qc_zhub.getSfsp() == 1){
            throw new MyException("已经审批！");
        }else {
            qc_zhub.setSfsp(1);
            qc_zhub.setSpsftg(0);
            qc_zhub.setQzr(spr);
            qc_zhub.setQzrq(sprq);
            iQc_zhubDao.updateById(qc_zhub);
        }
    }

    @Override
    public void spAdopt(String djh, String spr, Date sprq) throws Exception {
        Qc_zhub qc_zhub = iQc_zhubDao.findByDjh(djh);
        if(qc_zhub.getSfsp() == 1){
            throw new MyException("已经审批！");
        }else {
            qc_zhub.setSfsp(1);
            qc_zhub.setSpsftg(1);
            qc_zhub.setQzr(spr);
            qc_zhub.setQzrq(sprq);
            iQc_zhubDao.updateById(qc_zhub);
        }
    }

    @Override
    public PageInfo checkProductInStore(String djh) throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setResFlag("0");//代表仓库中没有重复的存货
        List<String> msgList = pageInfo.getMsgList();
        Qc_zhub qc_zhub = iQc_zhubDao.findByDjh(djh);
        List<Qc_zib> qc_zibs = iQc_zibDao.findByZhubId(qc_zhub.getQc_zhub_id());//该订单的所有子表
        String ckbm = qc_zhub.getCkbm();//仓库编码
        Store store = iStoreDao.findByCkbm(ckbm);
        Integer storeId = store.getId();
        for (Qc_zib qc_zib:qc_zibs) {
            String chbm = qc_zib.getChbm();//存货编码
            Store_Product store_product= iStoreDao.findByStoreIdAndpNum(storeId,chbm);
            if(store_product != null){
                pageInfo.setResFlag("1");//代表仓库中已经有重复的存货
                msgList.add("编码为"+chbm+"的存货在仓库"+ckbm+"中已有存货数量："+store_product.getStockNumber());
            }
        }
        return pageInfo;
    }

    @Override
    public void sureToStore(String djh,String xgr,Date xgrq) throws Exception {
        Qc_zhub qc_zhub = iQc_zhubDao.findByDjh(djh);
        List<Qc_zib> qc_zibs = iQc_zibDao.findByZhubId(qc_zhub.getQc_zhub_id());//该订单的所有子表
        String ckbm = qc_zhub.getCkbm();//仓库编码
        Store store = iStoreDao.findByCkbm(ckbm);
        Integer storeId = store.getId();
        for (Qc_zib qc_zib:qc_zibs) {
            String chbm = qc_zib.getChbm();//存货编码
            Store_Product store_product= iStoreDao.findByStoreIdAndpNum(storeId,chbm);
            if(store_product == null){//没有记录，直接添加
                iStoreDao.addStore_Product(storeId,chbm,qc_zib.getCount());
            }else {//有记录，修改数据
                iStoreDao.updateStore_Product(storeId,chbm,qc_zib.getCount());
            }
        }
        //修改期初表状态
        qc_zhub.setXgr(xgr);
        qc_zhub.setXgrq(xgrq);
        qc_zhub.setStatus(1);//结束
        iQc_zhubDao.updateById(qc_zhub);
    }
}
