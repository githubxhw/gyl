package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Cgyfd_zhub;
import cn.cuit.gyl.domain.business.Cgyfd_zib;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.CgyfdService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/yf")
public class CgyfdController {

    @Autowired
    CgyfdService cgyfdService;

    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request){
        String djh = UUIDUtils.getOrderNumber();
        request.setAttribute("djh", djh);
        return "forward:/pages/business/cgyf-add.jsp";
    }

    @RequestMapping("/SaveZhubAndZib")
    @ResponseBody
    public PageInfo SaveZhubAndZib(Cgyfd_zhub cgyfd_zhub) throws Exception {
        PageInfo pageInfo = null;
        cgyfd_zhub.setSpr("0");
        pageInfo = cgyfdService.saveZhubAndZib(cgyfd_zhub);
        return pageInfo;
    }

    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Cgyfd_zib cgyfd_zib){
        cgyfdService.saveZib(cgyfd_zib);
        return;
    }

    @RequestMapping("/findByCgyfZhub")
    @ResponseBody
    public ArrayList<Cgyfd_zhub> findByCgyfZhub(Cgyfd_zhub cgyfd_zhub) throws Exception {
        cgyfd_zhub.setSxbz(-1);
        cgyfd_zhub.setStatus(-1);
        ArrayList<Cgyfd_zhub> zhubs = cgyfdService.findByCgyfdZhub(cgyfd_zhub);
        return zhubs;
    }

    @RequestMapping("/findByNoSp")
    @ResponseBody
    public ArrayList<Cgyfd_zhub> findByNoSp(Cgyfd_zhub cgyfd_zhub) throws Exception {
        cgyfd_zhub.setSpr("0");
        cgyfd_zhub.setSxbz(-1);
        cgyfd_zhub.setStatus(-1);
        ArrayList<Cgyfd_zhub> zhubs = cgyfdService.findByCgyfdZhub(cgyfd_zhub);
        return zhubs;
    }

    @RequestMapping("/findBySxBzIsOne")
    @ResponseBody
    public ArrayList<Cgyfd_zhub> findBySxBzIsOne(Cgyfd_zhub cgyfd_zhub) throws Exception {

        cgyfd_zhub.setSxbz(1);
        cgyfd_zhub.setStatus(-1);
        ArrayList<Cgyfd_zhub> zhubs = cgyfdService.findByCgyfdZhub(cgyfd_zhub);
        return zhubs;
    }

    @RequestMapping("/findZhuByid")
    @ResponseBody
    public Cgyfd_zhub findZhuByid(Integer zhuId){
        Cgyfd_zhub cgyfd_zhub = cgyfdService.findZhuById(zhuId);
        return cgyfd_zhub;
    }

    @RequestMapping("/findZiByZhuId")
    @ResponseBody
    public List<Cgyfd_zib>findZiByZhuId(Integer zhuId){
        List<Cgyfd_zib> zibs = cgyfdService.findZibByZhuId(zhuId);
        return zibs;
    }

    @RequestMapping("/findZiById")
    @ResponseBody
    public Cgyfd_zib findZiById(Integer id){
        Cgyfd_zib cgyfd_zib = cgyfdService.findZibByZiId(id);
        return cgyfd_zib;
    }

    @RequestMapping("/qz")
    @ResponseBody
    public PageInfo qz(String djh, String qzr, Date qzsj) throws Exception {
        PageInfo pageInfo = cgyfdService.qzByZhub(djh,qzr,qzsj);
        return pageInfo;
    }

    @RequestMapping("/sp")
    @ResponseBody
    public PageInfo sp(String djh,String spr,Date spsj, Integer sxbz) throws Exception {
        PageInfo pageInfo = cgyfdService.spByZhub(djh, spr, spsj, sxbz);
        return pageInfo;
    }

    @RequestMapping("/updateZib")
    @ResponseBody
    public void updateZib(Cgyfd_zib cgyfd_zib) throws Exception {
        cgyfdService.UpdateZib(cgyfd_zib);
        return;
    }

    @RequestMapping("/updateZhub")
    @ResponseBody
    public void updateZhub(Cgyfd_zhub cgyfd_zhub) throws MyException {
        cgyfdService.UpdateZhub(cgyfd_zhub);
        return;
    }

    @RequestMapping("/DeleteZhub")
    @ResponseBody
    public void DeleteZhub(Integer zhuId){
        cgyfdService.DeleteZhubById(zhuId);
        return;
    }

    @RequestMapping("/DeleteZhubs")
    @ResponseBody
    public void DeleteZhubs(String ids){
        cgyfdService.DeleteZhubByIds(ids);
        return;
    }

    @RequestMapping("/DeleteZib")
    @ResponseBody
    public void DeleteZib(Integer id){
        cgyfdService.DeleteZibById(id);
        return;
    }

    @RequestMapping("/DeleteZibs")
    @ResponseBody
    public void DeleteZibs(String ids){
        cgyfdService.DeleteZibByIds(ids);
        return;
    }

    @RequestMapping("/findZiByZid")
    @ResponseBody
    public Cgyfd_zib findZiByZid(Integer ziId){
        Cgyfd_zib zib = cgyfdService.findZibByZiId(ziId);
        return zib;
    }

    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Integer getZib_hh(Integer zhuId){
        return cgyfdService.getZib_hh(zhuId);
    }
}
