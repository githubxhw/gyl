package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Xsckd_zhub;
import cn.cuit.gyl.domain.business.Xsckd_zib;
import cn.cuit.gyl.service.business.IXsckdService;
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

//销售出库单的V
@RequestMapping("/xsckd")
@Controller
public class XsckdController {

    @Autowired
    @Qualifier("xsckdServiceImpl")
    private IXsckdService service = null;

    //根据主表的多个属性值查询满足条件的所有主表
    @RequestMapping("/findZhubByMany")
    @ResponseBody
    public List<Xsckd_zhub> findZhubByMany(Xsckd_zhub xsckd_zhub) throws Exception{
//        System.out.println(xsckd_zhub);
        List<Xsckd_zhub> xsckd_zhubs = service.findZhubByMany(xsckd_zhub);
        return xsckd_zhubs;
    }

    //根据主表的id查询对应所有子表
    @RequestMapping("/findZibsByZhubId")
    @ResponseBody
    public List<Xsckd_zib> findZibsByZhubId(Integer xsckd_zhub_id) throws Exception{
        //System.out.println(xsckd_zhub_id);
        List<Xsckd_zib> xsckd_zibs = service.findZibsByZhubId(xsckd_zhub_id);
        return xsckd_zibs;
    }

    //获取一个订单号并跳转到ADDUI
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("djh", ddh);
        return "forward:/pages/business/xsckd-add.jsp";
    }

    //获取一个订单号返回但不跳转
    @RequestMapping("/getDdh")
    @ResponseBody
    public String getDdh() throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        return ddh;
    }

    //验证是否可以添加，并添加主表和子表信息
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public PageInfo saveZhubAndZib(Xsckd_zhub xsckd_zhub) throws Exception{
        System.out.println(xsckd_zhub);
        PageInfo pageInfo = service.saveZhubAndZib(xsckd_zhub);
        return pageInfo;
    }

    //查询没有审批 和其它主表信息 的所有主表信息
    @RequestMapping("/findAllAndNotSh")
    @ResponseBody
    public List<Xsckd_zhub> findAllAndNotSh(Xsckd_zhub xsckd_zhub) throws Exception{
        //System.out.println(xsckd_zhub);
        List<Xsckd_zhub> xsckd_zhubs = service.findAllAndNotSh(xsckd_zhub);
        return xsckd_zhubs;
    }

    //根据主表id查询主表信息
    @RequestMapping("/findXsckd_zhubById")
    @ResponseBody
    public Xsckd_zhub findXsckd_zhubById(Integer xsckd_zhub_id) throws Exception{
        Xsckd_zhub xsckd_zhub = service.findXsckd_zhubById(xsckd_zhub_id);
        return xsckd_zhub;
    }

    //根据主表id修改主表信息
    @RequestMapping("/updateXsckd_zhubById")
    @ResponseBody
    public void updateXsckd_zhubById(Xsckd_zhub xsckd_zhub) throws Exception{
        service.updateXsckd_zhubById(xsckd_zhub);
        return;
    }

    //根据主表id删除主表信息
    @RequestMapping("/deleteXsckd_zhubById")
    @ResponseBody
    public void deleteXsckd_zhubById(Integer xsckd_zhub_id) throws Exception{
        service.deleteXsckd_zhubById(xsckd_zhub_id);
        return;
    }

    //根据多个id删除主表信息
    @RequestMapping("/deleteXsckd_ZhubByIds")
    @ResponseBody
    public void deleteXsckd_ZhubByIds(String ids) throws Exception{
        //System.out.println(ids);
        service.deleteXsckd_ZhubByIds(ids);
        return;
    }

    //根据子表id查询子表信息
    @RequestMapping("/findXsckd_zibById")
    @ResponseBody
    public Xsckd_zib findXsckd_zibById(Integer xsckd_zib_id) throws Exception{
        Xsckd_zib xsckd_zib = service.findXsckd_zibById(xsckd_zib_id);
        return xsckd_zib;
    }

    //根据子表id更新子表信息
    @RequestMapping("/updateXsckd_zibById")
    @ResponseBody
    public void updateXsckd_zibById(Xsckd_zib xsckd_zib) throws Exception{
        //System.out.println(xsckd_zib);
        service.updateXsckd_zibById(xsckd_zib);
        return;
    }

    //根据一个子表id删除一个子表
    @RequestMapping("/deleteXsckd_ZibById")
    @ResponseBody
    public void deleteXsckd_ZibById(Integer xsckd_zib_id) throws Exception{
        service.deleteXsckd_ZibById(xsckd_zib_id);
        return;
    }

    //根据多个子表id删除多个子表
    @RequestMapping("/deleteXsckd_ZibByIds")
    @ResponseBody
    public void deleteXsckd_ZibByIds(String ids) throws Exception{
        service.deleteXsckd_ZibByIds(ids);
        return;
    }

    //获取一个子表的行号hh
    @RequestMapping("/getZibHhByZhubId")
    @ResponseBody
    public Integer getZibHhByZhubId(Integer xsckd_zhub_id) throws Exception{
        Integer hh = service.getZibHhByZhubId(xsckd_zhub_id);
        return hh;
    }

    //添加一个子表信息
    @RequestMapping("/saveXsckd_zib")
    @ResponseBody
    public void saveXsckd_zib(Xsckd_zib xsckd_zib) throws Exception{
        System.out.println(xsckd_zib);
        service.saveXsckd_zib(xsckd_zib);
        return;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String djh, String spr, Date shrq) throws Exception{
        service.spForbidden(djh,spr,shrq);
        return;
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String djh, String spr, Date shrq) throws Exception{
        service.spAdopt(djh,spr,shrq);
        return;
    }

    //功能：确认出库，修改单据状态status为结束1，并回写信息到有关表中
    @RequestMapping("/updateZibStatusByIds")
    @ResponseBody
    public void updateZibStatusByIds(String ids, String xgr, Date xgrq) throws Exception{
        System.out.println("updateZibStatusByIds");
        service.updateZibStatusByIds(ids,xgr,xgrq);
        return;
    }
}
