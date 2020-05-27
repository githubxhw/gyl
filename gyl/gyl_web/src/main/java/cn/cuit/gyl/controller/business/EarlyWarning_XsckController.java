package cn.cuit.gyl.controller.business;


import cn.cuit.gyl.domain.business.EarlyWarning_Xsck;
import cn.cuit.gyl.service.business.IEarlyWarning_XsckService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/earlyWarning_Xsck")
public class EarlyWarning_XsckController {

    @Autowired
    @Qualifier("earlyWarning_XsckServiceImpl")
    private IEarlyWarning_XsckService service = null;

    //分页查询销售出库预警
    @RequestMapping("/findEWXsByPage")
    public String findEWXsByPage(HttpServletRequest request, @RequestParam(required = true,name = "pageNum",defaultValue = "1") Integer pageNum,@RequestParam(required = true,name = "pageSize",defaultValue = "6") Integer pageSize) throws Exception{
        List<EarlyWarning_Xsck> earlyWarning_xscks = service.findEWXsByPage(pageNum,pageSize);
        PageInfo<EarlyWarning_Xsck> pageInfo = new PageInfo<>(earlyWarning_xscks);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/business/earlywarning/earlywarning_xsck-list.jsp";
    }
}
