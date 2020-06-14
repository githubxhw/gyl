package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.PanDian;
import cn.cuit.gyl.domain.business.PanDianZi;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.PanDianService;
import cn.cuit.gyl.utils.Information;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/pd")

public class PanDianController {
    @Autowired
    @Qualifier("PanDianService")
    PanDianService panDianService;

    @RequestMapping("/findByCondition")
    public @ResponseBody List<PanDian> findByCondition(PanDian panDian) throws Exception{
        List<PanDian> byCondition = panDianService.findByCondition(panDian);
        return byCondition;
    }
    @RequestMapping("/findBySpIsOne")
    public @ResponseBody List<PanDian> findBySpIsOne(PanDian panDian)throws Exception{
        panDian.setStatus(Integer.valueOf(1));
        List<PanDian> byCondition = panDianService.findByCondition(panDian);
        return byCondition;
    }

    @RequestMapping("/findZiByZid")
    public @ResponseBody List<PanDianZi> findZiByZid(Long zid) throws Exception{
        List<PanDianZi> ziByZid = panDianService.findZiByZid(zid);
        return ziByZid;
    }

    @RequestMapping("/SaveZHuAndZi")
    public @ResponseBody
    Information SaveZHuAndZi(PanDian panDian) throws Exception{
        Information message =new Information();
        try{
            panDianService.Save(panDian);
            message.setMsg("添加成功!");
            return message;
        }catch (MyException e){
            message.setMsg(e.getMsg());
            return message;
        }
    }

    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "business/pandian-add";
    }
    @RequestMapping("/getZib_hh")
    public @ResponseBody Long getHh(Long zid)throws Exception{
        Long hh = panDianService.getHh(zid);
        return hh;
    }

    @RequestMapping("/SaveZi")
    public @ResponseBody
    Information SaveZi(PanDianZi panDianZi)throws Exception{
        Information a = new Information();
        try {
            panDianService.SaveZi(panDianZi);
            a.setMsg("添加成功");
            return a;
        }catch (MyException e){
            a.setMsg(e.getMsg());
            return a;
        }
    }

    @RequestMapping("/findZhuById")
    public @ResponseBody
    PanDian findZhuById(Long id) throws Exception{
        PanDian zhuById = panDianService.findZhuById(id);
        return zhuById;
    }

    @RequestMapping("/findZiById")
    public @ResponseBody
    PanDianZi findZiById(Long id) throws Exception{
        PanDianZi zhuById = panDianService.findZiById(id);
        return zhuById;
    }

    @RequestMapping("/UpdateZhuB")
    public @ResponseBody
    Information UpdateZhuB(PanDian panDian) throws Exception{
        Information a = new Information();
        try {
            panDianService.UpdateZhuB(panDian);
            a.setMsg("更新成功");
            return a;
        }catch (MyException e){
            a.setMsg(e.getMsg());
            return a;
        }
    }
    @RequestMapping("/DeleteZhuB")
    public @ResponseBody void DeleteZhuB(Long id)throws Exception{
        panDianService.DeleteZhuB(id);
    }

    @RequestMapping("/DeleteZhuBs")
    public @ResponseBody void DeleteZhuBs(String ids)throws Exception{
        panDianService.DeleteZhuBs(ids);
    }

    @RequestMapping("/UpdateZiB")
    public @ResponseBody
    Information UpdateZiB(PanDianZi panDianZi, String xgr, Date xgrq) throws Exception{
        Information a = new Information();
        try {
            panDianService.UpdateZib(panDianZi, xgr, xgrq);
            a.setMsg("更新成功");
            return a;
        }catch (MyException e){
            a.setMsg(e.getMsg());
            return a;
        }
    }

    @RequestMapping("/DeleteZiB")
    public @ResponseBody void DeleteZiB(Long zibId)throws Exception{
        panDianService.DeleteZib(zibId);
    }

    @RequestMapping("/DeleteZiBs")
    public @ResponseBody void DeleteZiBs(String ids)throws Exception{
        panDianService.DeleteZiBs(ids);
    }

    @RequestMapping("/spNo")
    public @ResponseBody
    Information spNo(String djh, String spr, Date sprq) throws Exception{
        Information a = new Information();
        try {
            panDianService.spNo(djh, spr, sprq);
            a.setMsg("审批禁止成功");
            return a;
        }catch (MyException e){
            a.setMsg(e.getMsg());
            return a;
        }

    }

    @RequestMapping("/spOk")
    public @ResponseBody
    Information spOk(String djh, String spr, Date sprq) throws Exception{
        Information a = new Information();
        try {
            panDianService.spOk(djh, spr, sprq);
            a.setMsg("审批成功");
            return a;
        }catch (MyException e){
            a.setMsg(e.getMsg());
            return a;
        }

    }

    @RequestMapping("/PanD")
    public @ResponseBody void PanD(PanDianZi panDianZi, String pdr, Date pdrq)throws Exception{
        panDianService.PanD(panDianZi, pdr, pdrq);
    }

    @RequestMapping("/TiaoZ")
    public @ResponseBody
    Information TiaoZ(PanDianZi panDianZi, String tzr, Date tzrq)throws Exception{
        Information a = new Information();
        try {
            panDianService.TiaoZ(panDianZi, tzr, tzrq);
            a.setMsg("调整成功");
            return a;
        }catch (MyException e){
            a.setMsg(e.getMsg());
            return a;
        }
    }
}
