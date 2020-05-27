package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.EarlyWarning_Store;
import cn.cuit.gyl.service.business.IEarlyWarning_StoreService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/earlyWarning_Store")
public class EarlyWarning_StoreController {

    @Autowired
    @Qualifier("earlyWarning_StoreServiceImpl")
    private IEarlyWarning_StoreService service = null;

    //分页查询预警信息
    @RequestMapping("/findEWSsByPage")
    public String findEWSsByPage(HttpServletRequest req, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,@RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<EarlyWarning_Store> earlyWarning_stores = service.findEWSsByPage(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(earlyWarning_stores);
        req.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/business/earlywarning/earlywarning_store-list.jsp";
    }

    //根据仓库id和商品编码查询预警信息
    @RequestMapping("/findEWSByStoreIdAndProductNum")
    public String findEWSByStoreIdAndProductNum(HttpServletRequest req,Integer storeId,String productNum) throws Exception{
        Integer pageNum = 1;
        Integer pageSize = 1;
        List<EarlyWarning_Store> earlyWarning_stores = service.findEWSByStoreIdAndProductNum(storeId,productNum,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(earlyWarning_stores);
        req.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/business/earlywarning/earlywarning_store-list.jsp";
    }

    //根据id查询，并将信息填充到修改modal
    @RequestMapping("/findEWSByIdToXg_Modal")
    @ResponseBody
    public EarlyWarning_Store findEWSByIdToXg_Modal(Long id) throws Exception{
        return service.findEWSByIdToXg_Modal(id);
    }

    //根据id修改预警信息
    @RequestMapping("/updateEWSById")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo updateEWSById(EarlyWarning_Store earlyWarning_store) throws Exception{
        return service.updateEWSById(earlyWarning_store);
    }

    //获取最大的id+1，到添加模态框中
    @RequestMapping("/getEWSIdToUI")
    @ResponseBody
    public Long getEWSIdToUI() throws Exception{
        return service.getEWSIdToUI();
    }

    //添加一条预警信息
    @RequestMapping("/saveEWS")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo saveEWS(EarlyWarning_Store earlyWarning_store) throws Exception{
//        System.out.println(earlyWarning_store);
        return service.saveEWS(earlyWarning_store);
    }

    //根据ids删除预警信息
    @RequestMapping("/deleteEWSsByIds")
    @ResponseBody
    public void deleteEWSsByIds(String ids) throws Exception{
        service.deleteEWSsByIds(ids);
        return;
    }
}
