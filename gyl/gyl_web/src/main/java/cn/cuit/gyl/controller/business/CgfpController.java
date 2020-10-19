package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.*;
import cn.cuit.gyl.service.business.ICgfpService;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RequestMapping("/cgfp")
@Controller
public class CgfpController {

    @Autowired
    @Qualifier("cgfpServiceImpl")
    private  ICgfpService service;

    //功能：点击cgfp-add.jsp中的添加按钮触发请求，保存主表和子表
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public void saveZhubAndZib(Cgfp_zhub cgfp_zhub) throws Exception {
        service.saveZhubAndZib(cgfp_zhub);
    }
    //功能: 点击aside.jsp中的采购发票管理按钮触发,获取一个订单号返回jsp页面并添加到订单号
    //同时获取其他表的特定字段传递到jsp页面
    @RequestMapping("/getFphToAddUI")
    public String getFphToAddUI(HttpServletRequest request) throws Exception{
        String fph = UUIDUtils.getOrderNumber();
        request.setAttribute("fph", fph);
        //获取cgdd主表
        List<Cgddzhub> cgdd_Zhubs = service.getAllOfCgddZhub();
        request.setAttribute("cgdd_Zhubs", cgdd_Zhubs);
        List<Cgddzhib> cgdd_Zibs=service.getAllOfCgddZib();//获取采购订单子表
        request.setAttribute("cgdd_Zibs",cgdd_Zibs);
        List<Cgdhd_zib> cgdhd_Zibs=service.getAllOfCgdhdZib();//获取采购到货单子表
        request.setAttribute("cgdhd_Zibs",cgdhd_Zibs);
        List<Cgygdzhib> cgygd_Zibs=service.getAllOfCgygdZib();
        request.setAttribute("cgygd_Zibs",cgygd_Zibs);

        return "forward:/pages/business/cgfp-add.jsp";
    }


    //功能：点击cgfp-query.jsp中查询部分的 “搜索” 按钮触发，模糊查询采购发票
    @RequestMapping("/findByCgfp_zhub")
    @ResponseBody
    public List<Cgfp_zhub> findByCgfp_zhub(Cgfp_zhub cgfp_zhub) throws Exception{
        List<Cgfp_zhub> cgfp_zhubs = service.findByCgfp_zhub(cgfp_zhub);
        for (Cgfp_zhub cgfpZhub : cgfp_zhubs) {
            System.out.println(cgfpZhub);
        }
        return cgfp_zhubs;
    }

    //功能：点击cgfp-query.jsp中主表中的查询按钮触发，根据id查询采购发票主表信息
    @RequestMapping("/findCgfp_zhubById")
    @ResponseBody
    public Cgfp_zhub findCgfp_zhubById(Integer cgfp_zhub_id) throws Exception{
        Cgfp_zhub cgfp_zhub = service.findCgfp_zhubById(cgfp_zhub_id);
        return cgfp_zhub;
    }

    //功能：点击cgfp-query.jsp中主表中模态框的修改按钮触发，根据id更新销售订单信息
    @RequestMapping("/updateCgfp_zhubById")
    @ResponseBody
    public void updateCgfp_zhubById(Cgfp_zhub cgfp_zhub) throws Exception{
        System.out.println(cgfp_zhub.toString());
        service.updateCgfp_zhubById(cgfp_zhub);
        return;
    }
    //功能：点击cgfp-query.jsp中主表中的删除按钮，提示是否删除，确认删除后触发，根据id删除采购发票主表的信息
    @RequestMapping("/deleteCgfp_ZhubById")
    @ResponseBody
    public void deleteCgfp_ZhubById(Integer cgfp_zhub_id) throws Exception{
//        System.out.println(cgfp_zhub_id);
        service.deleteCgfp_ZhubById(cgfp_zhub_id);
        return;
    }

    //功能：点击cgfp-query.jsp主表下面的删除按钮触发，根据多个id删除多个信息
    @RequestMapping("/deleteCgfp_ZhubByIds")
    @ResponseBody
    public void deleteCgfp_ZhubByIds(String ids) throws Exception{
        service.deleteCgfp_ZhubByIds(ids);
        return;
    }

//    //功能：点击cgfp-query.jsp主表下面的添加按钮触发，获取一个订单号fph，返回并添加到模态框的订单号中
//    @RequestMapping("/getZhub_fph")
//    @ResponseBody
//    private String getZhub_fph() throws Exception{
//        String fph = UUIDUtils.getOrderNumber();
//        return fph;
//    }


    //功能：点击cgfp-query.jsp主表模态框中的添加按钮触发，保存一个销售订单主表信息
    @RequestMapping("/saveCgfp_zhub")
    @ResponseBody
    public void saveCgfp_zhub(Cgfp_zhub cgfp_zhub) throws Exception{
//        System.out.println(cgfp_zhub);
        service.saveCgfp_zhub(cgfp_zhub);
        return;
    }

    //功能：双击cgfp-query.jsp主表中的公司gs按钮触发，根据主表的id查询对应的索引子表信息
    @RequestMapping("/findCgfp_zibByZhubId")
    @ResponseBody
    public List<Cgfp_zib> findCgfp_zibByZhubId(Integer cgfp_zhub_id) throws Exception{
        List<Cgfp_zib> cgfp_zibs = service.findCgfp_zibByZhubId(cgfp_zhub_id);
        /*for (Cgfp_zib cgfp_zib:cgfp_zibs) {
            System.out.println(cgfp_zib);
        }*/
        return cgfp_zibs;
    }
    //功能：双击cgfp-query.jsp子表中的按钮触发，根据子表的id的查询信息
    @RequestMapping("/findCgfp_zibById")
    @ResponseBody
    public Cgfp_zib findCgfp_zibById(Integer cgfp_zib_id) throws Exception{
        Cgfp_zib cgfp_zib = service.findCgfp_zibById(cgfp_zib_id);
//        System.out.println(cgfp_zib_id);
        return cgfp_zib;
    }

    //功能：点击子表模态框中的修改按钮触发，更新子表信息
    @RequestMapping("/updateCgfp_zibById")
    @ResponseBody
    public void updateCgfp_zibById(Cgfp_zib cgfp_zib) throws Exception{
        service.updateCgfp_zibById(cgfp_zib);
        return;
    }


    //功能：点击子表中删除按钮触发，根据id删除信息
    @RequestMapping("/deleteCgfp_ZibById")
    @ResponseBody
    public void deleteCgfp_ZibById(Integer cgfp_zib_id) throws Exception{
        service.deleteCgfp_ZibById(cgfp_zib_id);
        return;
    }

    //功能：点击子表下面的添加按钮触发查询hh
    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Long getZib_hh(Integer zhub_id) throws Exception{
        Long hh = service.getZib_hhByZhub_id(zhub_id);
        return hh;
    }
    //功能：点击子表添加模态框中的添加按钮触发，保存子表信息
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Cgfp_zib cgfp_zib) throws Exception{
        //System.out.println(cgfp_zib);
        service.saveCgfp_zib(cgfp_zib);
        return;
    }

    //功能：点击子表下面的删除按钮，删除子表信息
    @RequestMapping("/deleteCgfp_ZibByIds")
    @ResponseBody
    public void deleteCgfp_ZibByIds(String ids) throws Exception{
        service.deleteCgfp_ZibByIds(ids);
        return;
    }

//===================================================================
    //功能：单击cgrkd-update.jsp中搜索按钮，搜索 未审批的发货单
    @RequestMapping("/findAllAndSfshIsZero")
    @ResponseBody
    public List<Cgfp_zhub> findAllAndSfspIsZero(Cgfp_zhub cgfp_zhub) throws Exception {
        List<Cgfp_zhub> cgfp_zhubs = service.findAllAndSfshIsZero(cgfp_zhub);
        return cgfp_zhubs;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String fph, String spr, Date sprq) throws Exception {
        System.out.println(fph+":"+spr+":"+sprq);
        service.spForbidden(fph,spr,sprq);
        return;
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String fph, String spr, Date sprq) throws Exception {

        service.spAdopt(fph,spr,sprq);
        return;
    }

    //功能：单击表下面的 确认入库按钮，根据ids将选择的所有子表中的status修改为1
    @RequestMapping("/updateZibStatusByIds")
    @ResponseBody
    public void updateZibStatusByIds(String ids,String xgr,Date xgsj) throws Exception {
        service.updateZibStatusByIds(ids,xgr,xgsj);
        return;
    }





}
