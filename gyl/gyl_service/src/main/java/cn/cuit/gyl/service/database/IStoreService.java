package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.database.Store;
import cn.cuit.gyl.domain.others.Store_Product;

import java.util.HashMap;
import java.util.List;

public interface IStoreService {

    //分页查询所以的仓库信息
    List<Store> findAllByPage(Integer pageNum, Integer pageSize) throws Exception;

    //分页查询根据仓库id查询仓库信息
    List<Store> findStoreByStoreIdAndPage(Integer id,Integer pageNum, Integer pageSize) throws Exception;

    //根据仓库id查询出该仓库信息，并把该仓库信息请求转发到update页面
    Store findStoreByStoreId(Integer storeId) throws Exception;

    //根据仓库id删除该仓库信息
    void deleteStoreByStoreId(Integer storeId) throws Exception;

    //根据仓库id查询所有的 商品库存和商品信息
    List<Store_Product> findStore_ProductByStoreId(Integer storeId) throws Exception;

    //根据仓库id修改仓库信息
    void updateStoreByStoreId(Store store) throws Exception;

    //添加一条记录
    void save(Store store) throws Exception;

    //根据仓库id修改该商品的库存数量
    void updateStockNumberByStoreIdAndPnum(Store_Product store_product) throws Exception;

    //删除该仓库下该商品的库存信息
    void deleteStore_ProductByStoreIdAndPnum(Integer storeId, String pNum) throws Exception;

    //添加一条库存记录
    void saveStore_Product(Store_Product store_product) throws Exception;
}
