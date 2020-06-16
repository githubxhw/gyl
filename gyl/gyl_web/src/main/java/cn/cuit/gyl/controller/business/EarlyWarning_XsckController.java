package cn.cuit.gyl.controller.business;


import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.service.business.IEarlyWarning_XsckService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/earlyWarning_Xsck")
public class EarlyWarning_XsckController {

    @Autowired
    @Qualifier("earlyWarning_XsckServiceImpl")
    private IEarlyWarning_XsckService service = null;

    //根据单据号和行号查询出库预警信息
    @RequestMapping("/findEWXByDjhAndHh")
    public String findEWXByDjhAndHh(HttpServletRequest request,String ddh,Integer hh) throws Exception{
        EarlyWarning_Xsck earlyWarning_xsck = service.findEWXByDjhAndHh(ddh,hh);
        List<EarlyWarning_Xsck> earlyWarning_xscks = new ArrayList<>();
        earlyWarning_xscks.add(earlyWarning_xsck);
        PageInfo<EarlyWarning_Xsck> pageInfo = new PageInfo<>(earlyWarning_xscks);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/business/earlywarning/earlywarning_xsck-list.jsp";
    }

    //分页查询销售出库预警信息
    @RequestMapping("/findEWXsByPage")
    public String findEWXsByPage(HttpServletRequest request, @RequestParam(required = true,name = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(required = true,name = "pageSize",defaultValue = "6") Integer pageSize) throws Exception{
        List<EarlyWarning_Xsck> earlyWarning_xscks = service.findEWXsByPage(pageNum,pageSize);
        PageInfo<EarlyWarning_Xsck> pageInfo = new PageInfo<>(earlyWarning_xscks);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/business/earlywarning/earlywarning_xsck-list.jsp";
    }

    //单据预警id查询预警消息，并将信息返回到页面填写到修改的模态框中
    @RequestMapping("/findEWXByIdToXg_Modal")
    @ResponseBody
    public EarlyWarning_Xsck findEWXByIdToXg_Modal(Long id) throws Exception{
        EarlyWarning_Xsck earlyWarning_xsck = service.findEWXById(id);
        return earlyWarning_xsck;
    }

    //更新预警消息
    @RequestMapping("/updateEWX")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo updateEWX(EarlyWarning_Xsck earlyWarning_xsck) throws Exception{
        cn.cuit.gyl.utils.PageInfo pageInfo = service.updateEWX(earlyWarning_xsck);
        return pageInfo;
    }

    //查询出最大的id号，并返回id+1，在页面的添加模态框中进行填写
    @RequestMapping("/getEWXIdToUI")
    @ResponseBody
    public Long getEWXIdToUI() throws Exception{
        Long id = service.getMaxId();
        return id == null ? 1l : id+1;
    }

    //保存一个预警消息
    @RequestMapping("/saveEWX")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo saveEWX(EarlyWarning_Xsck earlyWarning_xsck) throws Exception{
        cn.cuit.gyl.utils.PageInfo pageInfo = service.saveEWX(earlyWarning_xsck);
        return pageInfo;
    }

    //根据ids删除预警消息
    @RequestMapping("/deleteEWXsByIds")
    @ResponseBody
    public void deleteEWXsByIds(String ids) throws Exception{
        service.deleteEWXsByIds(ids);
        return;
    }
}
