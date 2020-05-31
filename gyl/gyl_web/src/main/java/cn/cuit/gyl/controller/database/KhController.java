package cn.cuit.gyl.controller.database;

import cn.cuit.gyl.domain.database.kh;
import cn.cuit.gyl.domain.database.pages.PageBean;
import cn.cuit.gyl.service.database.KhService;
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
@RequestMapping("kh")
public class KhController {
    @Autowired
    @Qualifier("KhService")
    KhService khService;

    @RequestMapping("/findByPage")
    public String findByPage(String currentPage, kh a, HttpServletRequest request)throws Exception{
        request.setCharacterEncoding("utf-8");

        if(a.getStatus()!=null){
            DomainAttrValueConverterUtils<kh> handler=new DomainAttrValueConverterUtils<>(a);
            a = handler.handler(null, "status");
        }
        if(a.getSfyygl()!=null){
            DomainAttrValueConverterUtils<kh> handler=new DomainAttrValueConverterUtils<>(a);
            a = handler.handler(null, "sfyygl");
        }


        if (currentPage == null||currentPage.equals("")){
            currentPage = "1";
        }

        PageBean<kh> byPage = khService.findByPage(currentPage, "5", a);
        request.setAttribute("pb",byPage);
        request.setAttribute("kh",a);
        return "database/kh-list";
    }

    @RequestMapping("/Delete")
    public void Delete(String name, HttpServletResponse response,HttpServletRequest request) throws Exception{
        khService.Delete(name);
        response.sendRedirect(request.getContextPath()+"/kh/findByPage");
    }

    @RequestMapping("/Deletes")
    public void Deletes(String[] names, HttpServletResponse response,HttpServletRequest request) throws Exception{
        for (String id:names){
            khService.Delete(id);
        }
        response.sendRedirect(request.getContextPath()+"/kh/findByPage");
    }

    @RequestMapping("/findByName")
    public String findByName(String name,HttpServletRequest request) throws Exception{
        kh kh = khService.FindByName(name);
        request.setAttribute("kh",kh);
        return "basedata/kh-update";
    }

    @RequestMapping("/Save")
    public void Save(kh a, HttpServletResponse response, HttpServletRequest request) throws Exception{
        khService.Save(a);
        response.sendRedirect(request.getContextPath()+"/kh/findByPage");
    }

    @RequestMapping("/Update")
    public void Update(kh a, HttpServletResponse response, HttpServletRequest request) throws Exception{
        khService.Update(a);
        response.sendRedirect(request.getContextPath()+"/kh/findByPage");
    }

    @RequestMapping("/FindName")
    public @ResponseBody
    Information FindName(String name) throws Exception{
        kh gys = khService.FindByName(name);
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
        kh gys = khService.FindByName(name);
        Information a = new Information();
        if (gys.getId()!=null&&gys.getId() == id){
            gys = null;
        }
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
        kh gys = khService.FindByFullName(name);
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
        kh gys = khService.FindByFullName(name);
        if (gys.getId()!=null&&gys.getId() == id){
            gys = null;
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
        kh gys = khService.FindByZjm(zjm);
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
        kh gys = khService.FindByZjm(zjm);
        if (gys.getId()!=null&&gys.getId() == id){
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
}
