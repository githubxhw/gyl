package cn.cuit.gyl.controller.database;

import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.database.Store;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.service.database.IStoreService;
import cn.cuit.gyl.utils.UUIDUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    @Qualifier("storeServiceImpl")
    private IStoreService service = null;

    //分页查询所有的仓库信息
    @RequestMapping("/findAllByPage")
    public String findAllByPage(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<Store> stores = service.findAllByPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(stores);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/basedata/store-list.jsp";
    }

    //分页查询根据仓库id查询仓库信息
    @RequestMapping("/findStoreByStoreIdAndPage")
    public String findStoreByStoreIdAndPage(Integer id,HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<Store> stores = service.findStoreByStoreIdAndPage(id,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(stores);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/basedata/store-list.jsp";
    }

    //根据仓库id查询出该仓库信息，并把该仓库信息请求转发到update页面
    @RequestMapping("/findStoreByStoreIdToUI")
    public String findStoreByStoreIdToUI(Integer storeId,HttpServletRequest request) throws Exception{
        Store store = service.findStoreByStoreId(storeId);
        request.setAttribute("store", store);
        return "forward:/pages/basedata/store-update.jsp";
    }

    //根据仓库id删除该仓库信息
    @RequestMapping("/deleteStoreByStoreId")
    public String deleteStoreByStoreId(Integer storeId) throws Exception{
        service.deleteStoreByStoreId(storeId);
        return "redirect:/store/findAllByPage";
    }

    //根据仓库id查询所有的 商品库存和商品信息
    @RequestMapping("/findStore_ProductByStoreId")
    public String findStore_ProductByStoreId(Integer storeId,HttpServletRequest request) throws Exception{
        List<Store_Product> store_products = service.findStore_ProductByStoreId(storeId);
        /*if(store_products!=null){
            for (Store_Product store_product:store_products) {
                System.out.println(store_product);
            }
        }*/
        Store store = service.findStoreByStoreId(storeId);
        request.setAttribute("store_products",store_products);
        request.setAttribute("store", store);
        return "forward:/pages/basedata/store-productsAndStockNumber.jsp";
    }

    //根据仓库id修改仓库信息
    @RequestMapping("/updateStoreByStoreId")
    public String updateStoreByStoreId(Store store) throws Exception{
        service.updateStoreByStoreId(store);
        return "forward:/store/findStoreByStoreIdToUI?storeId="+store.getId();
    }

    //添加一条记录
    @RequestMapping("/save")
    public String save(Store store) throws Exception{
        service.save(store);
        return "forward:/store/findAllByPage";
    }

    //根据仓库id修改该商品的库存数量
    @RequestMapping("/updateStockNumberByStoreIdAndPnum")
    public String updateStockNumberByStoreIdAndPnum(Store_Product store_product) throws Exception{
        service.updateStockNumberByStoreIdAndPnum(store_product);
        return "forward:/store/findStore_ProductByStoreId?storeId="+store_product.getStoreId();
    }

    //删除该仓库下该商品的库存信息
    @RequestMapping("/deleteStore_ProductByStoreIdAndPnum")
    public String deleteStore_ProductByStoreIdAndPnum(Integer storeId,String pNum) throws Exception{
        service.deleteStore_ProductByStoreIdAndPnum(storeId,pNum);
        return "forward:/store/findStore_ProductByStoreId?storeId="+storeId;
    }

    //添加一条库存记录
    @RequestMapping("/saveStore_Product")
    public String saveStore_Product(Store_Product store_product) throws Exception{
        service.saveStore_Product(store_product);
        return "forward:/store/findStore_ProductByStoreId?storeId="+store_product.getStoreId();
    }

    //获取随机的仓库编码
    @RequestMapping("/getStoreNum")
    public String getStoreNum(HttpServletRequest request) throws Exception{
        String storeNum = UUIDUtils.getOrderNumber();
        request.setAttribute("storeNum", storeNum);
        return "forward:/pages/basedata/store-add.jsp";
    }
}
