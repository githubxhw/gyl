package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Xsydd_zhub;
import cn.cuit.gyl.domain.business.Xsydd_zib;
import cn.cuit.gyl.service.business.IXsyddService;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

//销售预订单的V
@Controller
@RequestMapping("/xsydd")
public class XsyddController {

    @Autowired
    @Qualifier("xsyddServiceImpl")
    private IXsyddService service = null;

    //根据主表id查询信息
    @RequestMapping("/findXsydd_zhubById")
    @ResponseBody
    public Xsydd_zhub findXsydd_zhubById(Integer xsydd_zhub_id) throws Exception{
        Xsydd_zhub xsydd_zhub = service.findXsydd_zhubById(xsydd_zhub_id);
        //System.out.println(xsydd_zhub);
        return xsydd_zhub;
    }

    //根据相关信息进行预订单主表（不包括子表）查询
    @PostMapping("/findByXsydd_zhub")
    @ResponseBody
    public List<Xsydd_zhub> findXsydd_zhub(Xsydd_zhub xsydd_zhub1) throws Exception {
        List<Xsydd_zhub> xsydd_zhubs = service.findXsydd_zhub(xsydd_zhub1);
        return xsydd_zhubs;
    }

    //根据主表的id查询所有的子表信息
    @RequestMapping("/findXsydd_zibByZhubId")
    @ResponseBody
    public List<Xsydd_zib> findXsydd_zibByZhubId(Integer xsydd_zhub_id) throws Exception{
        List<Xsydd_zib> xsydd_zibs = service.findXsydd_zibByZhubId(xsydd_zhub_id);
        return xsydd_zibs;
    }

    //获取主表ddh
    @RequestMapping("/getZhub_ddh")
    @ResponseBody
    public String getZhub_ddh() throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        //System.out.println(ddh);
        return ddh;
    }

    //添加一个主表信息
    @RequestMapping("/saveZhub")
    @ResponseBody
    public void saveZhub(Xsydd_zhub xsydd_zhub) throws Exception{
        service.saveZhub(xsydd_zhub);
        return;
    }

    //根据主表id删除该主表信息
    @RequestMapping("/deleteXsydd_ZhubById")
    @ResponseBody
    public void deleteXsydd_ZhubById(Integer xsydd_zhub_id) throws Exception{
        //System.out.println("来了一个请求..");
        service.deleteZhubById(xsydd_zhub_id);
        return;
    }

    //根据主表ids删除信息
    @RequestMapping("/deleteXsydd_ZhubByIds")
    @ResponseBody
    public void deleteXsydd_ZhubByIds(String ids) throws Exception{
        //System.out.println("ids :"+ids+"   length:"+ids.length());
        service.deleteZhubByIds(ids);
        return;
    }

    //点击模态框的修改按钮，发请求修改信息(通过id)
    @RequestMapping("/updateXsydd_zhubById")
    @ResponseBody
    public void updateXsydd_zhubById(Xsydd_zhub xsydd_zhub) throws Exception{
        //System.out.println(xsydd_zhub);
        //首先更新Xsydd_zhub
        service.updateXsydd_zhubById(xsydd_zhub);
        return;
    }

    //功能：子表：点击子表添加按钮触发，添加到模态框主表信息，查询出最大行号，行号添加是从1开始递增
    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Long getZib_hh(Integer zhub_id) throws Exception{
        //System.out.println("接受的zhubid="+zhub_id);
        Long hh = service.getZib_hhByZhub_id(zhub_id);
        return hh;
    }

    //功能：子表：点击子表添加模态框中的添加按钮，根据主表id添加一个子表信息
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Xsydd_zib xsydd_zib) throws Exception{
        //System.out.println(xsydd_zib);
        service.saveZib(xsydd_zib);
        return;
    }

    //功能：子表：点击子表右边的删除按钮触发，根据id删除子表信息
    @RequestMapping("/deleteXsydd_ZibById")
    @ResponseBody
    public void deleteXsydd_ZibById(Integer xsydd_zib_id) throws Exception{
        //System.out.println(xsydd_zib_id);
        service.deleteZibById(xsydd_zib_id);
        return;
    }

    //功能：子表：点击子表下面的删除按钮触发，根据多个ids删除多个子表
    @RequestMapping("/deleteXsydd_ZibByIds")
    @ResponseBody
    public void deleteXsydd_ZibByIds(String ids) throws Exception{
        //System.out.println(ids);
        service.deleteZibByIds(ids);
        return;
    }

    //功能：子表：点击子表右边的修改按钮触发，根据id查询该条信息
    @RequestMapping("/findXsydd_zibById")
    @ResponseBody
    public Xsydd_zib findXsydd_zibById(Integer xsydd_zib_id) throws Exception{
        //System.out.println(xsydd_zib_id);
        Xsydd_zib xsydd_zib = service.findXsydd_zibById(xsydd_zib_id);
        return xsydd_zib;
    }

    //功能：子表：点击子表模态框中的修改按钮触发，根据id修改信息
    @RequestMapping("/updateXsydd_zibById")
    @ResponseBody
    public void updateXsydd_zibById(Xsydd_zib xsydd_zib) throws Exception{
        service.updateXsydd_zibById(xsydd_zib);
        return;
    }

    //功能：获取ddh到xsydd-add.jsp
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "forward:/pages/business/xsydd-add.jsp";
    }

    //功能：在xsydd-add.jsp保存主表和子表信息
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public void saveZhubAndZib(Xsydd_zhub xsydd_zhub) throws Exception{
        service.saveZhubAndZib(xsydd_zhub);
        return;
    }

    //功能：点击xsdd-update.jsp中的 搜索按钮触发，查询没有经过 审批 即（sfsp = 0）的所有主表信息
    @RequestMapping("/findByAllAndSfspIsZero")
    @ResponseBody
    public List<Xsydd_zhub> findByAllAndSfspIsZero(Xsydd_zhub xsydd_zhub) throws Exception{
        List<Xsydd_zhub> xsydd_zhubs = service.findByAllAndSfspIsZero(xsydd_zhub);
        return xsydd_zhubs;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的预购单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String ddh, String spr, Date sprq) throws Exception{
        service.spForbidden(ddh,spr,sprq);
        return;
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该预购单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String ddh, String spr, Date sprq) throws Exception{
        service.spAdopt(ddh,spr,sprq);
        return;
    }
}
