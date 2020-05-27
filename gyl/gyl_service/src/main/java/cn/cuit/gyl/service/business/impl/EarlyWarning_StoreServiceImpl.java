package cn.cuit.gyl.service.business.impl;

import cn.cuit.gyl.dao.business.IEarlyWarning_StoreDao;
import cn.cuit.gyl.dao.database.IStoreDao;
import cn.cuit.gyl.domain.business.EarlyWarning_Store;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.service.business.IEarlyWarning_StoreService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.StringConverterUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("earlyWarning_StoreServiceImpl")
public class EarlyWarning_StoreServiceImpl implements IEarlyWarning_StoreService {

    @Autowired
    @Qualifier("iEarlyWarning_StoreDao")
    private IEarlyWarning_StoreDao iEarlyWarning_StoreDao = null;

    @Autowired
    @Qualifier("iStoreDao")
    private IStoreDao iStoreDao = null;

    @Override
    public List<EarlyWarning_Store> findEWSsByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<EarlyWarning_Store> earlyWarning_stores = iEarlyWarning_StoreDao.findAll();
        return earlyWarning_stores;
    }

    @Override
    public List<EarlyWarning_Store> findEWSByStoreIdAndProductNum(Integer storeId, String productNum, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<EarlyWarning_Store> earlyWarning_stores = iEarlyWarning_StoreDao.findByStoreIdAndProductNum(storeId,productNum);
        return earlyWarning_stores;
    }

    @Override
    public EarlyWarning_Store findEWSByIdToXg_Modal(Long id) throws Exception {
        EarlyWarning_Store earlyWarning_store = iEarlyWarning_StoreDao.findById(id);
        return earlyWarning_store;
    }

    @Override
    public PageInfo updateEWSById(EarlyWarning_Store earlyWarning_store) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();

        Long id = earlyWarning_store.getId();
        EarlyWarning_Store byId = iEarlyWarning_StoreDao.findById(id);
        Integer storeId = earlyWarning_store.getStoreId();
        String productNum = earlyWarning_store.getProductNum();
        if(storeId == byId.getStoreId() && productNum.equals(byId.getProductNum())){
            iEarlyWarning_StoreDao.updateById(earlyWarning_store);
            pageInfo.setResFlag("1");
            return pageInfo;
        }else {
            //查询在仓库storeId中是否有存货productNum的存货:store_product表
            Store_Product s = iStoreDao.findByStoreIdAndpNum(storeId, productNum);
            if(s == null){
                pageInfo.setResFlag("0");
                msgList.add("ID为"+storeId+"的仓库没有编码为"+productNum+"的存货;");
                return pageInfo;
            }else {
                //查询表earlywarning_store，确认有无重复记录，即storeId和productNum一样,不用加！= ，不然效率低
                List<EarlyWarning_Store> byStoreIdAndProductNum = iEarlyWarning_StoreDao.findByStoreIdAndProductNum(storeId, productNum);
                if(byStoreIdAndProductNum.size() != 0){//有重复的
                    pageInfo.setResFlag("0");
                    msgList.add("ID为"+storeId+"的仓库和编码为"+productNum+"的存货已经有记录，不能重复添加;");
                    return pageInfo;
                }else {
                    iEarlyWarning_StoreDao.updateById(earlyWarning_store);
                    pageInfo.setResFlag("1");
                    return pageInfo;
                }
            }
        }
    }

    @Override
    public Long getEWSIdToUI() throws Exception {
        Long maxId = iEarlyWarning_StoreDao.findMaxId();
        if(maxId == null){
            return 1L;
        }
        return maxId+1;
    }

    @Override
    public PageInfo saveEWS(EarlyWarning_Store earlyWarning_store) throws Exception {
        PageInfo pageInfo = new PageInfo();
        List<String> msgList = pageInfo.getMsgList();

        //1，验证：仓库storeId中是否有存货productNum，查询表store_product
        Integer storeId = earlyWarning_store.getStoreId();
        String productNum = earlyWarning_store.getProductNum();
        Store_Product byStoreIdAndpNum = iStoreDao.findByStoreIdAndpNum(storeId, productNum);
        if(byStoreIdAndpNum == null){
            pageInfo.setResFlag("0");
            msgList.add("ID为"+storeId+"的仓库还没有编码为"+productNum+"的存货;");
        }else {
            //2，验证：验证有无重复记录,查询表earlywarning_store
            List<EarlyWarning_Store> byStoreIdAndProductNum = iEarlyWarning_StoreDao.findByStoreIdAndProductNum(storeId, productNum);
            if(byStoreIdAndProductNum.size() != 0){
                pageInfo.setResFlag("0");
                msgList.add("ID为"+storeId+"的仓库和编码为"+productNum+"的存货已经有记录，不能重复添加;");
            }else {
                iEarlyWarning_StoreDao.saveHasId(earlyWarning_store);//添加一条记录，包含id
                pageInfo.setResFlag("1");
            }
        }
        return pageInfo;
    }

    @Override
    public void deleteEWSsByIds(String ids) throws Exception {
        Long[] IDS = StringConverterUtils.convertToLong(ids, ",");
        if(IDS!=null){
            for (Long id:IDS) {
                System.out.println(id);
                iEarlyWarning_StoreDao.deleteById(id);
            }
        }
    }
}
