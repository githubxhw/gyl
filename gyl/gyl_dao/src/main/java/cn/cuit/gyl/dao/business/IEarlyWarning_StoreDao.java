package cn.cuit.gyl.dao.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Store;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

//仓库预警表的dao
@Repository("iEarlyWarning_StoreDao")
public interface IEarlyWarning_StoreDao {

    //查询所有的预警信息
    @Select("select * from earlywarning_store")
    List<EarlyWarning_Store> findAll() throws Exception;

    //根据仓库id和商品编码查询预警
    @Select("select * from earlywarning_store where storeId=#{storeId} and productNum=#{productNum}")
    List<EarlyWarning_Store> findByStoreIdAndProductNum(@Param("storeId") Integer storeId,@Param("productNum") String productNum) throws Exception;

    //根据id查询信息
    @Select("select * from earlywarning_store where id=#{id}")
    EarlyWarning_Store findById(Long id) throws Exception;

    //根据id修改信息
    @Update("update earlywarning_store set " +
            "storeId=#{storeId},storeName=#{storeName},productNum=#{productNum}," +
            "productName=#{productName},checkExp=#{checkExp},upperLimit=#{upperLimit}," +
            "lowerLimit=#{lowerLimit},status=#{status} where id=#{id}")
    void updateById(EarlyWarning_Store earlyWarning_store) throws Exception;

    //查询最大的id
    @Select("select MAX(`id`) from earlywarning_store")
    Long findMaxId() throws Exception;

    //添加一条包含id的预警消息
    @Insert("insert into earlywarning_store " +
            "(id,storeId,storeName,productNum,productName,checkExp,upperLimit,lowerLimit,status) " +
            "values (#{id},#{storeId},#{storeName},#{productNum},#{productName},#{checkExp},#{upperLimit},#{lowerLimit},#{status})")
    void saveHasId(EarlyWarning_Store earlyWarning_store) throws Exception;

    //根据id删除信息
    @Delete("delete from earlywarning_store where id=#{id}")
    void deleteById(Long id) throws Exception;

    //查询所有status为1的预警
    @Select("select * from earlywarning_store where status = 1")
    List<EarlyWarning_Store> findAllWhereStatusIsTrue() throws Exception;
}
