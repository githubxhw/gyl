package cn.cuit.gyl.dao.database;

import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.others.Store_Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("iProductDao")
public interface IProductDao {

    //查询所有的商品档案
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    //添加一个商品信息
    @Insert("insert into product (pnum,pname,type,unit,price,rate,mfd,exp,pdesc) values (#{pnum},#{pname},#{type},#{unit},#{price},#{rate},#{mfd},#{mfd},#{pdesc})")
    void save(Product product) throws Exception;

    //根据一个编码pnum删除商品信息
    @Delete("delete from product where pnum = #{pnum}")
    void deleteByPnum(String pnum) throws Exception;

    //根据编码pnum查询商品信息
    @Select("select * from product where pnum = #{pnum}")
    Product findByPnum(String pnum) throws Exception;

    //根据编码pnum更新商品信息
    @Update("update product set pname=#{pname},type=#{type},unit=#{unit},price=#{price},rate=#{rate},mfd=#{mfd},exp=#{exp},pdesc=#{pdesc} where pnum=#{pnum}")
    void updateByPnum(Product product) throws Exception;

    //根据pNum，查询store_product表里面的库存数量
    @Select("select * from store_product where pNum=#{pNum}")
    List<Store_Product> findStore_ProductByPnum(String pNum) throws Exception;

    //查询最大的pid
    @Select("select MAX(`pid`) from product")
    Long findMaxPid() throws Exception;
}
