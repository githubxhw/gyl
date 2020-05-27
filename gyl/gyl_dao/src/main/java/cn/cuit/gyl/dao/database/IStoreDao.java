package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.Store;
import cn.cuit.gyl.domain.others.Store_Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iStoreDao")
public interface IStoreDao {

    //查询所有的仓库信息
    @Select("select * from store")
    List<Store> findAll() throws Exception;

    //根据仓库id查询仓库信息
    @Select("select * from store where id=#{id}")
    Store findById(Integer id) throws Exception;

    //根据仓库id删除仓库信息
    @Delete("delete from store where id=#{storeId}")
    void deleteById(Integer storeId) throws Exception;

    //根据id修改信息
    @Update("update store set storeNum=#{storeNum},storeName=#{storeName},storeType=#{storeType},storeAddr=#{storeAddr},storeSize=#{storeSize},uid=#{uid},uname=#{uname},uphone=#{uphone} where id=#{id}")
    void updateById(Store store) throws Exception;

    //添加一条记录
    @Insert("insert into store (storeNum,storeName,storeType,storeAddr,storeSize,uid,uname,uphone) values (#{storeNum},#{storeName},#{storeType},#{storeAddr},#{storeSize},#{uid},#{uname},#{uphone})")
    void save(Store store) throws Exception;

    //工具storeId查询所有的Store_Products:该product在该store的存货数量
    @Select("select * from store_product where storeId=#{storeId}")
    List<Store_Product> findStore_ProductById(Integer storeId) throws Exception;

    //根据仓库id修改该商品的库存数量
    @Update("update store_product set stockNumber=#{stockNumber} where storeId=#{storeId} and pNum=#{pNum}")
    void updateStockNumberByStoreIdAndPnum(Store_Product store_product) throws Exception;

    //删除该仓库下该商品的库存信息
    @Delete("delete from store_product where storeId=#{storeId} and pNum=#{pNum}")
    void deleteStore_ProductByStoreIdAndPnum(@Param("storeId") Integer storeId,@Param("pNum") String pNum) throws Exception;

    //添加一条库存记录
    @Insert("insert into store_product (storeId,pNum,stockNumber) values (#{storeId},#{pNum},#{stockNumber})")
    void saveStore_Product(Store_Product store_product) throws Exception;

    //根据仓库编码查询信息
    @Select("select * from store where storeNum=#{ckbm}")
    Store findByCkbm(String ckbm) throws Exception;

    //根据仓库id和存货编码查询store_product这张表信息
    @Select("select * from store_product where storeId=#{storeId} and pNum=#{chbm}")
    Store_Product findByStoreIdAndpNum(@Param("storeId") Integer storeId,@Param("chbm") String chbm) throws Exception;

    //添加一条数据：store_product表
    @Insert("insert into store_product (storeId,pNum,stockNumber) values (#{storeId},#{chbm},#{count})")
    void addStore_Product(@Param("storeId") Integer storeId,@Param("chbm") String chbm,@Param("count") Long count) throws Exception;

    //更新一条数据：store_product表
    @Update("update store_product set stockNumber=#{count} where storeId=#{storeId} and pNum=#{chbm}")
    void updateStore_Product(@Param("storeId") Integer storeId,@Param("chbm") String chbm,@Param("count") Long count) throws Exception;
}
