package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.EarlyWarning_Cgrk;
import cn.cuit.gyl.service.business.IEarlyWarning_CgrkService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/earlyWarning_Cgrk")
public class EarlyWarning_CgrkController {
    @Autowired
    IEarlyWarning_CgrkService earlyWarning_cgrkService;

    @RequestMapping("/findEWCgByPage")
    public String findEWCgByPage(HttpServletRequest request, @RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize",required = true,defaultValue = "6") Integer pageSize) throws Exception{
        List<EarlyWarning_Cgrk> eWckByPage = earlyWarning_cgrkService.findEWckByPage(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(eWckByPage);
        request.setAttribute("pageInfo",pageInfo);
        return "business/earlywarning/earlywarning_cgrk-list";
    }

    @RequestMapping("/findEWCgByDjhOrHH")
    public String findEWCgByDjhOrHH(HttpServletRequest request, @RequestParam(name = "djh",required = true,defaultValue = "")String djh,@RequestParam(name = "hh",required = true,defaultValue = "null") String hh) throws Exception{
        Integer pageNum = 1;
        Integer pageSize = 6;
        Long Hh = null;
        if (hh.equals(null)){
            Hh = null;
        }else {
            Hh = Long.getLong(hh);
        }
        List<EarlyWarning_Cgrk> eWckByDjhOrHH = earlyWarning_cgrkService.findEWckByDjhOrHH(djh, Hh, pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(eWckByDjhOrHH);
        request.setAttribute("pageInfo",pageInfo);
        return "business/earlywarning/earlywarning_cgrk-list";
    }

    @RequestMapping("/findEWCgById")
    public @ResponseBody
    EarlyWarning_Cgrk findEWCgById(Long id)throws Exception{
        EarlyWarning_Cgrk eWckById = earlyWarning_cgrkService.findEWckById(id);
        return eWckById;
    }

    @RequestMapping("/UpdateEWCg")
    public @ResponseBody
    cn.cuit.gyl.utils.PageInfo UpdateEWCg(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception{
        return earlyWarning_cgrkService.updateEWck(earlyWarning_cgrk);
    }

    @RequestMapping("/getEWCIdToUI")
    public @ResponseBody
    Long getEWCIdToUI() throws Exception{
        return earlyWarning_cgrkService.getEWCIdToUI();
    }

    @RequestMapping("/SaveEWC")
    public @ResponseBody
    cn.cuit.gyl.utils.PageInfo SaveEWCg(EarlyWarning_Cgrk earlyWarning_cgrk) throws Exception{
        return earlyWarning_cgrkService.SaveEWc(earlyWarning_cgrk);
    }

    @RequestMapping("/deleteEWCgByIds")
    public @ResponseBody
    void deleteEWCgByIds(String ids) throws Exception{
        earlyWarning_cgrkService.deleteEWcsByIds(ids);
    }

    @RequestMapping("/CheckDjh")
    public @ResponseBody
    cn.cuit.gyl.utils.PageInfo CheckDjh(String djh) throws Exception{
        return earlyWarning_cgrkService.CheckDjh(djh);
    }

    @RequestMapping("/CheckHh")
    public @ResponseBody
    cn.cuit.gyl.utils.PageInfo CheckHh(String djh,Long hh) throws Exception{
        return earlyWarning_cgrkService.CheckHh(djh,hh);
    }

    @RequestMapping("/PutValue")
    public @ResponseBody
    Cgddzhib PutValue(String djh, Long hh) throws Exception{
        return earlyWarning_cgrkService.PutValue(djh,hh);
    }
}
