package cn.cuit.gyl.controller.database;

import cn.cuit.gyl.domain.database.gys;
import cn.cuit.gyl.domain.database.pages.PageBean;
import cn.cuit.gyl.service.database.GysService;
import cn.cuit.gyl.utils.DomainAttrValueConverterUtils;
import cn.cuit.gyl.utils.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/gys")
public class GysController {
    @Autowired
    @Qualifier("GysService")
    GysService gysService;

    @RequestMapping("/findByPage")
    public String findByPage(String currentPage, gys a, HttpServletRequest request)throws Exception{
        if(a.getStatus()!=null){
            DomainAttrValueConverterUtils<gys> handler=new DomainAttrValueConverterUtils<>(a);
            a = handler.handler(null, "status");
        }
        System.out.println(currentPage);
        if (currentPage == null||currentPage.equals("")){
            currentPage = "1";
        }
        System.out.println(currentPage);
        PageBean<gys> byPage = gysService.findByPage(currentPage, "5", a);
        request.setAttribute("pb",byPage);
        request.setAttribute("Gys",a);
        return "basedata/gys-list";
    }

    @RequestMapping("/Delete")
    public void Delete(Long id, HttpServletResponse response,HttpServletRequest request) throws Exception{
        gysService.Delete(id);
        response.sendRedirect(request.getContextPath()+"/gys/findByPage?currentPage=1&rows=5");
    }
    @RequestMapping("/Deletes")
    public void Deletes(Long[] ids, HttpServletResponse response,HttpServletRequest request) throws Exception{
        for (long id:ids){
            gysService.Delete(id);
        }
        response.sendRedirect(request.getContextPath()+"/gys/findByPage?currentPage=1&rows=5");
    }

    @RequestMapping("/findById")
    public String findById(Long id,HttpServletRequest request) throws Exception{
        gys gys = gysService.FindById(id);
        request.setAttribute("gys",gys);
        return "basedata/gys-update";
    }

    @RequestMapping("/Save")
    public void Save(gys a, HttpServletResponse response, HttpServletRequest request) throws Exception{

        gysService.Save(a);
        response.sendRedirect(request.getContextPath()+"/gys/findByPage?currentPage=1&rows=5");
    }

    @RequestMapping("/FindName")
    public @ResponseBody
    Information FindName(String name) throws Exception{
        System.out.println("name"+name);
        gys gys = gysService.FindByName(name);
        Information a = new Information();
        if (gys == null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该名称的供应商已存在");

        }
        return a;

    }

    @RequestMapping("/FindNameU")
    public @ResponseBody
    Information FindNameU(String name, Long id) throws Exception{
        gys gys = gysService.FindByName(name);
        if (gys!=null&&gys.getId()!=null&&gys.getId().equals(id)){
            gys =null;
        }
        Information a = new Information();
        if (gys == null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该名称的供应商已存在");

        }
        return a;

    }

    @RequestMapping("/FindFullName")
    public @ResponseBody
    Information FindFullName(String name) throws Exception{
        gys gys = gysService.FindByFullName(name);
        Information a = new Information();
        if (gys == null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该全称的供应商已存在");

        }
        return a;

    }

    @RequestMapping("/FindFullNameU")
    public @ResponseBody
    Information FindFullNameU(String name, Long id) throws Exception{
        gys gys = gysService.FindByFullName(name);
        if (gys!=null&&gys.getId()!=null&&gys.getId().equals(id)){
            gys =null;
        }
        Information a = new Information();
        if (gys == null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该全称的供应商已存在");

        }
        return a;

    }

    @RequestMapping("/FindZjm")
    public @ResponseBody
    Information FindZjm(String zjm) throws Exception{
        System.out.println(zjm);
        gys gys = gysService.FindByZjm(zjm);
        Information a = new Information();
        if (gys == null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该助记码的供应商已存在");

        }
        return a;

    }

    @RequestMapping("/FindZjmU")
    public @ResponseBody
    Information FindZjmU(String zjm, Long id) throws Exception{
        gys gys = gysService.FindByZjm(zjm);
        if (gys!=null&&gys.getId()!=null&&gys.getId().equals(id)){
            gys =null;
        }
        Information a = new Information();
        if (gys == null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该助记码的供应商已存在");

        }
        return a;

    }

    @RequestMapping("/Update")
    public void Update(gys a, HttpServletResponse response, HttpServletRequest request) throws Exception{
        gysService.Update(a);
        response.sendRedirect(request.getContextPath()+"/gys/findByPage?currentPage=1&rows=5");
    }
}
