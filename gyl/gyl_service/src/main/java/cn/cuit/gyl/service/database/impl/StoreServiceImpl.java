package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.IProductDao;
import cn.cuit.gyl.dao.database.IStoreDao;
import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.database.Store;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.service.database.IStoreService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service("storeServiceImpl")
public class StoreServiceImpl implements IStoreService {

    @Autowired
    @Qualifier("iStoreDao")
    private IStoreDao iStoreDao = null;

    @Autowired
    @Qualifier("iProductDao")
    private IProductDao iProductDao = null;

    @Override
    public List<Store> findAllByPage(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Store> stores = iStoreDao.findAll();
        return stores;
    }

    @Override
    public List<Store> findStoreByStoreIdAndPage(Integer id,Integer pageNum, Integer pageSize) throws Exception {
        List<Store> stores = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        Store store = iStoreDao.findById(id);
        stores.add(store);
        return stores;
    }

    @Override
    public Store findStoreByStoreId(Integer storeId) throws Exception {
        Store store = iStoreDao.findById(storeId);
        return store;
    }

    @Override
    public void deleteStoreByStoreId(Integer storeId) throws Exception {
        iStoreDao.deleteById(storeId);
    }

    @Override
    public List<Store_Product> findStore_ProductByStoreId(Integer storeId) throws Exception {
        List<Store_Product> store_products = iStoreDao.findStore_ProductById(storeId);
        return store_products;
    }

    @Override
    public void updateStoreByStoreId(Store store) throws Exception {
        iStoreDao.updateById(store);
    }

    @Override
    public void save(Store store) throws Exception {
        iStoreDao.save(store);
    }

    @Override
    public void updateStockNumberByStoreIdAndPnum(Store_Product store_product) throws Exception {
        iStoreDao.updateStockNumberByStoreIdAndPnum(store_product);
    }

    @Override
    public void deleteStore_ProductByStoreIdAndPnum(Integer storeId, String pNum) throws Exception {
        iStoreDao.deleteStore_ProductByStoreIdAndPnum(storeId,pNum);
    }

    @Override
    public void saveStore_Product(Store_Product store_product) throws Exception {
        iStoreDao.saveStore_Product(store_product);
    }

}
