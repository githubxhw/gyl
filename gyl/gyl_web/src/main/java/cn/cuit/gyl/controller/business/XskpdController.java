package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Xskpd_zhub;
import cn.cuit.gyl.domain.business.Xskpd_zib;
import cn.cuit.gyl.service.business.IXskpdService;
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

//销售开票单的V
@RequestMapping("/xskpd")
@Controller
public class XskpdController {

    @Autowired
    @Qualifier("xskpdServiceImpl")
    private IXskpdService service = null;

    //根据Xskpd_zhub 的信息查询所以满足的主表s
    @RequestMapping("/findZhubByMany")
    @ResponseBody
    public List<Xskpd_zhub> findZhubByMany(Xskpd_zhub xskpd_zhub) throws Exception{
        List<Xskpd_zhub> xskpd_zhubs = service.findZhubByMany(xskpd_zhub);
        return xskpd_zhubs;
    }

    //根据主表id查询所以的子表s
    @RequestMapping("/findZibsByZhubId")
    @ResponseBody
    public List<Xskpd_zib> findZibsByZhubId(Integer xskpd_zhub_id) throws Exception{
        List<Xskpd_zib> xskpd_zibs = service.findZibsByZhubId(xskpd_zhub_id);
        return xskpd_zibs;
    }

    //获取订单据号，并跳转到添加页面
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("djh", ddh);
        return "forward:/pages/business/xskpd-add.jsp";
    }

    //添加主表以及子表信息
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public PageInfo saveZhubAndZib(Xskpd_zhub xskpd_zhub) throws Exception{
        //System.out.println(xskpd_zhub);
        PageInfo pageInfo = service.saveZhubAndZib(xskpd_zhub);
        return pageInfo;
    }

    //根据主表id查询主表信息
    @RequestMapping("/findZhubById")
    @ResponseBody
    public Xskpd_zhub findZhubById(Integer xskpd_zhub_id) throws Exception{
        Xskpd_zhub xskpd_zhub = service.findZhubById(xskpd_zhub_id);
        return xskpd_zhub;
    }

    //根据主表id并修改主表信息
    @RequestMapping("/updateZhubById")
    @ResponseBody
    public void updateZhubById(Xskpd_zhub xskpd_zhub) throws Exception{
        //System.out.println(xskpd_zhub);
        service.updateZhubById(xskpd_zhub);
        return;
    }

    //根据id删除主表信息
    @RequestMapping("/deleteZhubById")
    @ResponseBody
    public void deleteZhubById(Integer xskpd_zhub_id) throws Exception{
        service.deleteZhubById(xskpd_zhub_id);
        return;
    }

    //根据多个id删除多个主表信息
    @RequestMapping("/deleteZhubsByIds")
    @ResponseBody
    public void deleteZhubsByIds(String ids) throws Exception{
        //System.out.println(ids);
        service.deleteZhubsByIds(ids);
        return;
    }

    //根据子表id查询子表信息
    @RequestMapping("/findZibById")
    @ResponseBody
    public Xskpd_zib findZibById(Integer xskpd_zib_id) throws Exception{
        Xskpd_zib xskpd_zib = service.findZibById(xskpd_zib_id);
        return xskpd_zib;
    }

    //根据子表id修改子表信息
    @RequestMapping("/updateZibById")
    @ResponseBody
    public void updateZibById(Xskpd_zib xskpd_zib) throws Exception{
        //System.out.println(xskpd_zib);
        service.updateZibById(xskpd_zib);
        return;
    }

    //根据主表id，查询出最大行号，并+1
    @RequestMapping("/getZibHhByZhubId")
    @ResponseBody
    public Integer getZibHhByZhubId(Integer xskpd_zhub_id) throws Exception{
        Integer hh = service.getZibHhByZhubId(xskpd_zhub_id);
        return hh;
    }

    //保存一个子表
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Xskpd_zib xskpd_zib) throws Exception{
        //System.out.println(xskpd_zib);
        service.saveZib(xskpd_zib);
        return;
    }

    //根据子表id删除子表信息
    @RequestMapping("/deleteZibById")
    @ResponseBody
    public void deleteZibById(Integer xskpd_zib_id) throws Exception{
        service.deleteZibById(xskpd_zib_id);
        return;
    }

    //根据多个子表id删除多个子表
    @RequestMapping("/deleteZibsByIds")
    @ResponseBody
    public void deleteZibsByIds(String ids) throws Exception{
        //System.out.println(ids);
        service.deleteZibsByIds(ids);
        return;
    }


    //审批禁止
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String fph, String spr, Date sprq) throws Exception{
        service.spForbidden(fph,spr,sprq);
        return;
    }

    //审批通过
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String fph, String spr, Date sprq) throws Exception{
        service.spAdopt(fph,spr,sprq);
        return;
    }

    //根据子表的ids来确认开票（行状态）
    @RequestMapping("/updateZibStatusByIds")
    @ResponseBody
    public void updateZibStatusByIds(String ids, String xgr, Date xgrq) throws Exception{
        service.updateZibStatusByIds(ids,xgr,xgrq);
        return;
    }
}
