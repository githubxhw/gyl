package cn.cuit.gyl.controller.database;


import cn.cuit.gyl.domain.database.Product;
import cn.cuit.gyl.domain.others.Store_Product;
import cn.cuit.gyl.service.database.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productServiceImpl")
    private IProductService service = null;

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<Product> products = service.findAll(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(products);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/basedata/product-list.jsp";
    }

    @RequestMapping("/save")
    public String save(Product product) throws Exception{
        service.save(product);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/deleteByPnums")
    public String deleteByPnums(@RequestParam(name = "pnums") String[] pnums) throws Exception{
        /*for (String pnum:pnums) {
            System.out.println(pnum);
        }*/
        service.deleteByPnums(pnums);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/deleteByPnum")
    public String deleteByPnum(@RequestParam(name = "pnum") String pnum) throws Exception{
        service.deleteByPnum(pnum);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/findProductByPnumToUI")
    public String findProductByPnumToUI(HttpServletRequest request,@RequestParam(name = "pnum") String pnum) throws Exception{
        Product product = service.findByPnum(pnum);
        request.setAttribute("product", product);
        return "forward:/pages/basedata/product-update.jsp";
    }

    @RequestMapping("/updateByPnum")
    public String updateByPnum(Product product) throws Exception{
        //System.out.println(product);
        service.updateByPnum(product);
        return "redirect:/product/findProductByPnumToUI?pnum="+product.getPnum();
    }

    //查询该商品在哪些仓库，以及存货数量
    @RequestMapping("/findStockNumberByPnum")
    public String findStockNumberByPnum(HttpServletRequest request,String pNum) throws Exception{
        List<Store_Product> store_products = service.findStockNumberByPnum(pNum);
        Product product = service.findByPnum(pNum);
        request.setAttribute("store_products", store_products);
        request.setAttribute("product", product);
        return "forward:/pages/basedata/product-StockNumber.jsp";
    }

    //根据商品编码查询信息
    @RequestMapping("/findByPnumAndPage")
    public String findByPnumAndPage(HttpServletRequest request,String pnum) throws Exception{
        List<Product> products = service.findByPnumAndPage(pnum);
        PageInfo pageInfo = new PageInfo(products);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/basedata/product-list.jsp";
    }

    //获取商品编码，并返回到添加页面
    @RequestMapping("/getPnumByPid")
    public String getPnumByPid(HttpServletRequest request) throws Exception{
        String pnum = service.getPnumByPid();
        request.setAttribute("pnum", pnum);
        return "forward:/pages/basedata/product-add.jsp";
    }
}
