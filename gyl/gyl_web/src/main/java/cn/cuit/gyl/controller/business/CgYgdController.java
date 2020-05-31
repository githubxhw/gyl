package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Cgygdzhib;
import cn.cuit.gyl.domain.business.Cgygdzhub;
import cn.cuit.gyl.domain.database.gys;
import cn.cuit.gyl.exception.MyException;
import cn.cuit.gyl.service.business.CgygdService;
import cn.cuit.gyl.utils.Information;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cgyg")
public class CgYgdController {
    @Autowired
     private CgygdService cgYgService;

    @RequestMapping("/findByCondition")
    public @ResponseBody List<Cgygdzhub> findCgYgByCondition(Cgygdzhub a) throws Exception{
        System.out.println("a=  "+a);
        List<Cgygdzhub> byCondition = cgYgService.findByCondition(a);
        System.out.println("ByCondition=  "+byCondition);
        return byCondition;
    }

    @RequestMapping("/findZiByZhuId")
    public @ResponseBody List<Cgygdzhib> findCgYgZibByZid(Long zid) throws Exception{
        List<Cgygdzhib> cgYgZibByZid = cgYgService.findCgYgZibByZid(zid);
        Cgygdzhub byId = cgYgService.findById(zid);
        if (cgYgZibByZid!=null){
            for (Cgygdzhib a:cgYgZibByZid){
                a.setCgqgdzhub(byId);
            }
        }
        return cgYgZibByZid;
    }

    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws  Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "business/cgygd-add";
    }

    @RequestMapping("/SaveZhuBAndZib")
    public @ResponseBody void saveCgygd(Cgygdzhub a) throws Exception{
        System.out.println("save=="+a);
        if(a.getCgqgdzhibs() != null){
            for (Cgygdzhib x:a.getCgqgdzhibs()){
                if (x.getShuilv()!=null){
                    Float h = x.getShuilv()/100;
                    x.setShuilv(h);
                }
            }
        }
        cgYgService.SaveCgYgZhuAndZiD(a);
    }

    @RequestMapping("/findByAllAndSfspIsZero")
    @ResponseBody
    public List<Cgygdzhub> findByAllAndSfspIsZero(Cgygdzhub a) throws Exception{
        a.setIssp(0);
        List<Cgygdzhub> byCondition = cgYgService.findByCondition(a);
        for (Cgygdzhub x:byCondition){
            System.out.println("x===="+x);
        }
        return byCondition;
    }

    @RequestMapping("/getZib_hh")
    public @ResponseBody Long getZibHH(Long zid) throws Exception{
        Long hh = cgYgService.getHh(zid);
        return hh;
    }

    @RequestMapping("/SaveZib")
    public @ResponseBody  void  SaveZib(Cgygdzhib a , String xgr, Date xgrq) throws  Exception{
        cgYgService.SaveZib(a);
        Long zid = a.getZid();
        Cgygdzhub byId = cgYgService.findById(zid);
        byId.setXgr(xgr);
        byId.setXgrq(xgrq);
        cgYgService.UpdateZhuB(byId);
    }

    @RequestMapping("/findZhuById")
    public @ResponseBody
    Cgygdzhub findById(Long id) throws Exception{
        Cgygdzhub byId = cgYgService.findById(id);
        return byId;
    }

    @RequestMapping("/UpdateZhuB")
    public @ResponseBody void UpdateZhuB(Cgygdzhub a) throws Exception{
        System.out.println("xiu=="+a);
        cgYgService.UpdateZhuB(a);
    }

    @RequestMapping("/DeleteZhuB")
    public @ResponseBody void DeleteZhuB(Long id) throws Exception{
        cgYgService.DeleteZhuB(id);
    }

    @RequestMapping("/DeleteZhuBs")
    public @ResponseBody void DeleteZhuBs(String ids) throws Exception{
        cgYgService.DeleteZhuBs(ids);
    }

    @RequestMapping("/findZiById")
    public @ResponseBody
    Cgygdzhib findZiById(Long id) throws  Exception{
        Cgygdzhib byId = cgYgService.findCgYgZibById(id);
        return byId;
    }

    @RequestMapping("/UpdateZhiB")
    public @ResponseBody void UpdateZhiB(Cgygdzhib a , String xgr, Date xgrq)throws Exception{
        cgYgService.UpdateZiB(a);
        Cgygdzhub byId = cgYgService.findById(a.getZid());
        byId.setXgr(xgr);
        byId.setXgrq(xgrq);
        cgYgService.UpdateZhuB(byId);
    }

    @RequestMapping("/DeleteZhiB")
    public @ResponseBody void DeleteZiB(Long id) throws Exception{
        cgYgService.DeleteZhiB(id);
    }

    @RequestMapping("/DeleteZhiBs")
    public @ResponseBody
    Information DeleteZhiB(String ids) throws Exception{
        Information message = new Information();
        try {
            cgYgService.DeleteZhiBs(ids);
            message.setMsg("删除成功");
            return message;
        }catch (MyException e){
            message.setMsg("错误原因："+e.getMsg());
            return message;
        }
    }

    @RequestMapping("/spOk")
    public @ResponseBody
    Information spOk(String djh, String spr, Date sprq) throws Exception{
            Information message = new Information();
            try {
                cgYgService.spOk(djh, spr, sprq);
                message.setMsg("审批成功");
                return message;
            }catch (MyException e){
                message.setMsg("错误原因："+e.getMsg());
                return message;
            }

    }

    @RequestMapping("/spNo")
    public @ResponseBody
    Information spNo(String djh, String spr, Date sprq) throws Exception{
        Information message = new Information();
        try {
            cgYgService.spNo(djh, spr, sprq);
            message.setMsg("审批禁止成功");
            return message;
        }catch (MyException e){
            message.setMsg("错误原因："+e.getMsg());
            return message;
        }
    }

    @RequestMapping("/FindG")
    public @ResponseBody
    Information fg(String name) throws Exception{
        System.out.println(name);
        gys gys = cgYgService.FindByGName(name);
        System.out.println(gys);
        Information a = new Information();
        if (gys != null){
            a.setMsg("Ok");
        }else {
            a.setMsg("该名称的供应商不存在");

        }
        return a;
    }
}
