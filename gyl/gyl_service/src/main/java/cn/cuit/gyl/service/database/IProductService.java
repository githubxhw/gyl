package cn.cuit.gyl.service.database;

import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.others.Store_Product;

import java.util.List;

public interface IProductService {

    //查询所有的商品档案
    List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception;

    //添加一个商品
    void save(Product product) throws Exception;

    //通过多个商品编码删除多个商品信息
    void deleteByPnums(String[] pnums) throws Exception;

    //通过一个商品编码删除一个商品信息
    void deleteByPnum(String pnum) throws Exception;

    //根据商品编码查询商品信息
    Product findByPnum(String pnum) throws Exception;

    //根据商品编码更新商品信息
    void updateByPnum(Product product) throws Exception;

    //查询该商品在哪些仓库，以及存货数量
    List<Store_Product> findStockNumberByPnum(String pNum) throws Exception;

    //通过分页和商品编号查询信息
    public List<Product> findByPnumAndPage(String pnum) throws Exception;

    //根据最大pid+1 处理后获取商品编码12位
    String getPnumByPid() throws Exception;
}
