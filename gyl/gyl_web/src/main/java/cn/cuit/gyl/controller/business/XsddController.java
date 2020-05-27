package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Xsdd_zhub;
import cn.cuit.gyl.domain.business.Xsdd_zib;
import cn.cuit.gyl.service.business.IXsddService;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

//销售订单的V
@Controller
@RequestMapping("/xsdd")
public class XsddController {

    @Autowired
    @Qualifier("xsddServiceImpl")
    private IXsddService service = null;

    //功能：点击xsdd-add.jsp中的添加按钮触发请求，保存主表和子表
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public void saveZhubAndZib(Xsdd_zhub xsdd_zhub) throws Exception{
        //System.out.println(xsdd_zhub);
        service.saveZhubAndZib(xsdd_zhub);
        return;
    }

    //功能: 点击aside.jsp中的销售订单管理按钮触发,获取一个订单号返回jsp页面并添加到订单号
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "forward:/pages/business/xsdd-add.jsp";
    }

    //功能：点击xsdd-query.jsp中查询部分的 “搜索” 按钮触发，模糊查询销售订单
    @RequestMapping("/findByXsdd_zhub")
    @ResponseBody
    public List<Xsdd_zhub> findByXsdd_zhub(Xsdd_zhub xsdd_zhub) throws Exception{
        List<Xsdd_zhub> xsdd_zhubs = service.findByXsdd_zhub(xsdd_zhub);
        return xsdd_zhubs;
    }

    //功能：点击xsdd-query.jsp中主表中的修改按钮触发，根据id查询销售订单主表信息
    @RequestMapping("/findXsdd_zhubById")
    @ResponseBody
    public Xsdd_zhub findXsdd_zhubById(Integer xsdd_zhub_id) throws Exception{
        Xsdd_zhub xsdd_zhub = service.findXsdd_zhubById(xsdd_zhub_id);
        return xsdd_zhub;
    }

    //功能：点击xsdd-query.jsp中主表中模态框的修改按钮触发，根据id更新销售订单信息
    @RequestMapping("/updateXsdd_zhubById")
    @ResponseBody
    public void updateXsdd_zhubById(Xsdd_zhub xsdd_zhub) throws Exception{
        service.updateXsdd_zhubById(xsdd_zhub);
        return;
    }

    //功能：点击xsdd-query.jsp中主表中的删除按钮，提示是否删除，确认删除后触发，根据id删除销售订单主表的信息
    @RequestMapping("/deleteXsdd_ZhubById")
    @ResponseBody
    public void deleteXsdd_ZhubById(Integer xsdd_zhub_id) throws Exception{
        service.deleteXsdd_ZhubById(xsdd_zhub_id);
        return;
    }

    //功能：点击xsdd-query.jsp主表下面的删除按钮触发，根据多个id删除多个信息
    @RequestMapping("/deleteXsdd_ZhubByIds")
    @ResponseBody
    public void deleteXsdd_ZhubByIds(String ids) throws Exception{
        service.deleteXsdd_ZhubByIds(ids);
        return;
    }

    //功能：点击xsdd-query.jsp主表下面的添加按钮触发，获取一个订单号ddh，返回并添加到模态框的订单号中
    @RequestMapping("/getZhub_ddh")
    @ResponseBody
    public String getZhub_ddh() throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        return ddh;
    }

    //功能：点击xsdd-query.jsp主表模态框中的添加按钮触发，保存一个销售订单主表信息
    @RequestMapping("/saveXsdd_zhub")
    @ResponseBody
    public void saveXsdd_zhub(Xsdd_zhub xsdd_zhub) throws Exception{
        //System.out.println(xsdd_zhub);
        service.saveXsdd_zhub(xsdd_zhub);
        return;
    }

    //功能：双击xsdd-query.jsp主表中的订单号ddh按钮触发，根据主表的id查询对应的索引子表信息
    @RequestMapping("/findXsdd_zibByZhubId")
    @ResponseBody
    public List<Xsdd_zib> findXsdd_zibByZhubId(Integer xsdd_zhub_id) throws Exception{
        List<Xsdd_zib> xsdd_zibs = service.findXsdd_zibByZhubId(xsdd_zhub_id);
        /*for (Xsdd_zib xsdd_zib:xsdd_zibs) {
            System.out.println(xsdd_zib);
        }*/
        return xsdd_zibs;
    }

    //功能：双击xsdd-query.jsp子表中的修改按钮触发，根据子表的id的查询信息
    @RequestMapping("/findXsdd_zibById")
    @ResponseBody
    public Xsdd_zib findXsdd_zibById(Integer xsdd_zib_id) throws Exception{
        Xsdd_zib xsdd_zib = service.findXsdd_zibById(xsdd_zib_id);
        //System.out.println(xsdd_zib);
        return xsdd_zib;
    }

    //功能：点击子表模态框中的修改按钮触发，更新子表信息
    @RequestMapping("/updateXsdd_zibById")
    @ResponseBody
    public void updateXsdd_zibById(Xsdd_zib xsdd_zib) throws Exception{
        //System.out.println(xsdd_zib);
        service.updateXsdd_zibById(xsdd_zib);
        return;
    }

    //功能：点击子表中删除按钮触发，根据id删除信息
    @RequestMapping("/deleteXsdd_ZibById")
    @ResponseBody
    public void deleteXsdd_ZibById(Integer xsdd_zib_id) throws Exception{
        service.deleteXsdd_ZibById(xsdd_zib_id);
        return;
    }

    //功能：点击子表下面的添加按钮触发查询hh---》max hh
    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Long getZib_hh(Integer zhub_id) throws Exception{
        Long hh = service.getZib_hhByZhub_id(zhub_id);
        return hh;
    }

    //功能：点击子表添加模态框中的添加按钮触发，保存子表信息
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Xsdd_zib xsdd_zib) throws Exception{
        //System.out.println(xsdd_zib);
        service.saveXsdd_zib(xsdd_zib);
        return;
    }

    //功能：点击子表下面的删除按钮，删除子表信息
    @RequestMapping("/deleteXsdd_ZibByIds")
    @ResponseBody
    public void deleteXsdd_ZibByIds(String ids) throws Exception{
        service.deleteXsdd_ZibByIds(ids);
        return;
    }

    //功能：点击xsdd-update.jsp中的 搜索按钮触发，查询没有经过 审批 即（sfsp = 0）的所有主表信息
    @RequestMapping("/findByAllAndSfspIsZero")
    @ResponseBody
    public List<Xsdd_zhub> findByAllAndSfspIsZero(Xsdd_zhub xsdd_zhub) throws Exception{
        List<Xsdd_zhub> xsdd_zhubs = service.findByAllAndSfspIsZero(xsdd_zhub);
        return xsdd_zhubs;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception{
        service.spForbidden(ddh,spr,sprq);
        return;
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception{
        service.spAdopt(ddh,spr,sprq);
        return;
    }
}
