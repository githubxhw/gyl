package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Xsysdzhib;
import cn.cuit.gyl.domain.business.Xsysdzhub;
import cn.cuit.gyl.service.business.IXsysdService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/ys")
public class XsYsController {

    @Autowired
    private IXsysdService service;

    @RequestMapping("/findByCondition")
    public @ResponseBody List<Xsysdzhub> findByCondition(Xsysdzhub xsysdzhub) throws Exception{
        System.out.println("传入==="+xsysdzhub);
        List<Xsysdzhub> byCondition = service.findByCondition(xsysdzhub);
        System.out.println("传出===="+byCondition);
        return byCondition;
    }

    @RequestMapping("/findByNoSh")
    public @ResponseBody List<Xsysdzhub> findByNoSh(Xsysdzhub xsysdzhub) throws Exception{
        System.out.println("传入==="+xsysdzhub);
        List<Xsysdzhub> byCondition = service.findByNoSh(xsysdzhub);
        System.out.println("传出===="+byCondition);
        return byCondition;
    }

    @RequestMapping("/findBySxBzIsOne")
    public @ResponseBody List<Xsysdzhub> findBySxBzIsOne(Xsysdzhub xsysdzhub) throws Exception{
        xsysdzhub.setSxbz(1);
        System.out.println(xsysdzhub);
        List<Xsysdzhub> byCondition = service.findBySxBzIsOne(xsysdzhub);

        return byCondition;
    }

    @RequestMapping("/findZiByZid")
    public @ResponseBody List<Xsysdzhib> findZiByZid(Long zid) throws Exception{
        List<Xsysdzhib> ziByZid = service.findZiByZid(zid);
        return ziByZid;
    }

    @RequestMapping("/Save")
    public @ResponseBody
    PageInfo SaveZhuAndZi(Xsysdzhub xsysdzhub) throws Exception{
        System.out.println(xsysdzhub);
        PageInfo pageInfo = service.AddXsYsZhuB(xsysdzhub);
        return pageInfo;
    }
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "business/xsys-add";
    }

    @RequestMapping("/shNo")
    public @ResponseBody
    PageInfo shNo(String ddh, String shr, Date shrq) throws Exception{
        PageInfo pageInfo = service.shNo(shr, shrq, ddh);
        return pageInfo;
    }

    @RequestMapping("/shOk")
    public  @ResponseBody
    PageInfo shOK(String ddh, String shr, Date shrq) throws Exception{
        PageInfo pageInfo = service.shOK(shr, shrq, ddh);
        return pageInfo;
    }

    @RequestMapping("/getZib_hh")
    public @ResponseBody Long getZib_hh(Long zid) throws Exception{
        Long zib_hh = service.getZib_hh(zid);
        return zib_hh;
    }

    @RequestMapping("/SaveZi")
    public @ResponseBody
    PageInfo SaveZi(Xsysdzhib xsysdzhib, String xgr, Date xgrq) throws Exception{
        PageInfo pageInfo = service.AddXsYsZhiB(xsysdzhib, xgr, xgrq);
        return pageInfo;
    }

    @RequestMapping("/findZhuById")
    public @ResponseBody
    Xsysdzhub findZhuById(Long id) throws Exception{
        Xsysdzhub zhuById = service.findZhuById(id);
        return zhuById;
    }

    @RequestMapping("/findZiById")
    public @ResponseBody
    Xsysdzhib findZiById(Long id) throws Exception{
        Xsysdzhib ziById = service.findZiById(id);
        return ziById;
    }

    @RequestMapping("/UpdateZhuB")
    public @ResponseBody
    PageInfo UpdateZhuB(Xsysdzhub xsysdzhub) throws Exception{
        PageInfo pageInfo = service.UpdateXsYsZhuB(xsysdzhub);
        return pageInfo;
    }

    @RequestMapping("/DeleteZhuB")
    public @ResponseBody void DeleteZhuB(Long id) throws Exception{
        service.DeleteXsYsZhuBByID(id);
    }

    @RequestMapping("/DeleteZhuBs")
    public @ResponseBody void DeleteZhuBs(String ids) throws Exception{
        service.DeleteXsYsZhuBByIDs(ids);
    }

    @RequestMapping("/UpdateZiB")
    public @ResponseBody
    PageInfo UpdateZhiB(Xsysdzhib xsysdzhib, String xgr, Date xgrq) throws Exception{
        PageInfo pageInfo = service.UpdateXsYsZhiB(xgr,xgrq,xsysdzhib);
        return pageInfo;
    }

    @RequestMapping("/DeleteZiB")
    public @ResponseBody void DeleteZhiB(Long id) throws Exception{
        service.DeleteXsYsZhiBByID(id);
    }

    @RequestMapping("/DeleteZiBs")
    public @ResponseBody void DeleteZhiBs(String ids) throws Exception{
        service.DeleteXsYsZhiBByIDs(ids);
    }

    @RequestMapping("/qz")
    public @ResponseBody
    PageInfo qz(String ddh, String qzr, Date qzrq) throws Exception{
        PageInfo qz = service.qz(qzr, qzrq, ddh);
        return qz;
    }
}
