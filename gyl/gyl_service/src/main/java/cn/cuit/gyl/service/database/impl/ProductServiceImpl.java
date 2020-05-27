package cn.cuit.gyl.service.database.impl;

import cn.cuit.gyl.dao.database.IProductDao;
import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.service.database.IProductService;
import cn.cuit.gyl.utils.UUIDUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productServiceImpl")
public class ProductServiceImpl implements IProductService {

    @Autowired
    @Qualifier("iProductDao")
    IProductDao dao = null;

    @Override
    public List<Product> findAll(Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = dao.findAll();
        return products;
    }

    @Override
    public void save(Product product) throws Exception {
        dao.save(product);
    }

    @Override
    public void deleteByPnums(String[] pnums) throws Exception {
        for (String pnum:pnums) {
            if(pnum!=null){
                dao.deleteByPnum(pnum);
            }
        }
    }

    @Override
    public void deleteByPnum(String pnum) throws Exception {
        if(pnum!=null){
            dao.deleteByPnum(pnum);
        }
    }

    @Override
    public Product findByPnum(String pnum) throws Exception {
        Product product = dao.findByPnum(pnum);
        return product;
    }

    @Override
    public void updateByPnum(Product product) throws Exception {
        dao.updateByPnum(product);
    }

    @Override
    public List<Product> findByPnumAndPage(String pnum) throws Exception {
        List<Product> products = new ArrayList<>();
        PageHelper.startPage(1, 6);
        Product product = dao.findByPnum(pnum);
        products.add(product);
        return products;
    }

    @Override
    public String getPnumByPid() throws Exception {
        String res = "000000000000";
        Long maxPid = dao.findMaxPid();
        if(maxPid == null){
            res+="1";
            return res.substring(res.length()-12, res.length());
        }
        res+=maxPid+1;
        return res.substring(res.length()-12, res.length());
    }

    @Override
    public List<Store_Product> findStockNumberByPnum(String pNum) throws Exception {
        List<Store_Product> store_products = dao.findStore_ProductByPnum(pNum);
        return store_products;
    }
}
