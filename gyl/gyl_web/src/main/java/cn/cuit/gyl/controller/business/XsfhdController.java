package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Xsfhd_zhub;
import cn.cuit.gyl.domain.business.Xsfhd_zib;
import cn.cuit.gyl.service.business.IXsfhdService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

//销售发货单的V
@Controller
@RequestMapping("/xsfhd")
public class XsfhdController {

    @Autowired
    @Qualifier("xsfhdServiceImpl")
    private IXsfhdService service = null;

    //功能：在xsfhd-add.jsp中单击保存按钮触发。保存子表和主表信息。
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public PageInfo saveZhubAndZib(Xsfhd_zhub xsfhd_zhub) throws Exception {
        PageInfo pageInfo = service.saveZhubAndZib(xsfhd_zhub);
        return pageInfo;
    }

    //功能:获取订单号，但不用跳转
    @RequestMapping("/getDdh")
    @ResponseBody
    public String getDdh() throws Exception {
        String ddh = UUIDUtils.getOrderNumber();
        return ddh;
    }

    //功能：点击aside.jsp中的销售发货单添加按钮触发,获取ddh到xsfhd-add.jsp
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception {
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "forward:/pages/business/xsfhd-add.jsp";
    }

    //功能：点击xsfhd-query.jsp中的查询按钮触发，根据信息查询满足所有的销售发货单
    @RequestMapping("/findByXsfhd_zhub")
    @ResponseBody
    public List<Xsfhd_zhub> findByXsfhd_zhub(Xsfhd_zhub xsfhd_zhub) throws Exception {
        List<Xsfhd_zhub> xsfhd_zhubs = service.findByXsfhd_zhub(xsfhd_zhub);
        return xsfhd_zhubs;
    }

    //功能：点击xsfhd-query.jsp主表中的修改按钮触发，根据主表id查询信息并返回
    @RequestMapping("/findXsfhd_zhubById")
    @ResponseBody
    public Xsfhd_zhub findXsfhd_zhubById(Integer xsfhd_zhub_id) throws Exception {
        Xsfhd_zhub xsfhd_zhub = service.findXsfhd_zhubById(xsfhd_zhub_id);
        return xsfhd_zhub;
    }

    //功能：点击xsfhd-query.jsp主表中的模态框修改按钮触发，根据id修改信息
    @RequestMapping("/updateXsfhd_zhubById")
    @ResponseBody
    public void updateXsfhd_zhubById(Xsfhd_zhub xsfhd_zhub) throws Exception {
        service.updateXsfhd_zhubById(xsfhd_zhub);
        return;
    }

    //功能：点击xsfhd-query.jsp主表中的删除按钮触发，根据主表id删除信息
    @RequestMapping("/deleteXsfhd_ZhubById")
    @ResponseBody
    public void deleteXsfhd_ZhubById(Integer xsfhd_zhub_id) throws Exception {
        service.deleteXsfhd_ZhubById(xsfhd_zhub_id);
        return;
    }

    //功能：主点击xsfhd-query.jsp主表下面的添加按钮触发，添加到模态框主表信息，先查询出ddh
    @RequestMapping("/getZhub_ddh")
    @ResponseBody
    public String getZhub_ddh() throws Exception {
        String ddh = UUIDUtils.getOrderNumber();
        return ddh;
    }

    //功能：主点击xsfhd-query.jsp主表添加模态框的添加按钮触发，添加主表信息
    @RequestMapping("/saveXsfhd_zhub")
    @ResponseBody
    public void saveXsfhd_zhub(Xsfhd_zhub xsfhd_zhub) throws Exception {
        //System.out.println(xsfhd_zhub);
        service.saveXsfhd_zhub(xsfhd_zhub);
        return;
    }

    //功能：主点击xsfhd-query.jsp主表下面的删除按钮触发，根据ids删除信息
    @RequestMapping("/deleteXsfhd_ZhubByIds")
    @ResponseBody
    public void deleteXsfhd_ZhubByIds(String ids) throws Exception {
        service.deleteXsfhd_ZhubByIds(ids);
        return;
    }

    //功能：1, 双击 xsfhd-query.jsp主表中的ddh按钮触发，根据在主表id（外键）查询所有的子表信息
    //     2, 点击 子表刷新按钮功能触发，根据主表id，查询更新子表信息
    @RequestMapping("/findXsfhd_zibByZhubId")
    @ResponseBody
    public List<Xsfhd_zib> findXsfhd_zibByZhubId(Integer xsfhd_zhub_id) throws Exception {
        List<Xsfhd_zib> xsfhd_zibs = service.findXsfhd_zibByZhubId(xsfhd_zhub_id);
        return xsfhd_zibs;
    }

    //功能：双击 xsfhd-query.jsp子表中的修改按钮触发，根据子表id进行查询信息
    @RequestMapping("/findXsfhd_zibById")
    @ResponseBody
    public Xsfhd_zib findXsfhd_zibById(Integer xsfhd_zib_id) throws Exception {
        Xsfhd_zib xsfhd_zib = service.findXsfhd_zibById(xsfhd_zib_id);
        return xsfhd_zib;
    }

    //功能：单击 xsfhd-query.jsp子表中的删除按钮触发，根据子表id删除子表信息
    @RequestMapping("/deleteXsfhd_ZibById")
    @ResponseBody
    public void deleteXsfhd_ZibById(Integer xsfhd_zib_id) throws Exception {
        service.deleteXsfhd_ZibById(xsfhd_zib_id);
        return;
    }

    //功能：单击 xsfhd-query.jsp子表下面中的删除按钮触发，根据子表ids删除子表信息
    @RequestMapping("/deleteXsfhd_ZibByIds")
    @ResponseBody
    public void deleteXsfhd_ZibByIds(String ids) throws Exception {
        service.deleteXsfhd_ZibByIds(ids);
        return;
    }

    //功能：单击xsfhd-query.jsp中子表下面的添加按钮触发,根据主表查询出max行号+1
    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Integer getZib_hh(Integer xsfhd_zhub_id) throws Exception {
        //System.out.println(xsfhd_zhub_id);
        Integer hh = service.getZib_hh(xsfhd_zhub_id);
        return hh;
    }

    //功能：单击xsfhd-query.jsp中子表模态框中的添加按钮触发,保存一个子表
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Xsfhd_zib xsfhd_zib) throws Exception {
        service.saveXsfhd_zib(xsfhd_zib);
        return;
    }

    //功能：单击xsfhd-update.jsp中搜索按钮，搜索 未审批的发货单
    @RequestMapping("/findAllAndSfspIsZero")
    @ResponseBody
    public List<Xsfhd_zhub> findAllAndSfspIsZero(Xsfhd_zhub xsfhd_zhub) throws Exception {
        List<Xsfhd_zhub> xsfhd_zhubs = service.findAllAndSfspIsZero(xsfhd_zhub);
        return xsfhd_zhubs;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception {
        service.spForbidden(ddh,spr,sprq);
        return;
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception {
        service.spAdopt(ddh,spr,sprq);
        return;
    }

    //功能：单机子表下面的 确认发货按钮，根据ids将选择的所有子表中的status修改为1
    @RequestMapping("/updateZibStatusByIds")
    @ResponseBody
    public void updateZibStatusByIds(String ids,String xgr,Date xgsj) throws Exception {
        service.updateZibStatusByIds(ids,xgr,xgsj);
        return;
    }
}
