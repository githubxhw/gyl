package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Qc_zhub;
import cn.cuit.gyl.domain.business.Qc_zib;
import cn.cuit.gyl.service.business.IQcService;
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

//仓库期初v
@Controller
@RequestMapping("/qc")
public class QcController {

    @Autowired
    @Qualifier("qcServiceImpl")
    private IQcService service = null;

    //根据期初主表内容查询满足的所有主表s
    @RequestMapping("findZhubByMany")
    @ResponseBody
    public List<Qc_zhub> findZhubByMany(Qc_zhub qc_zhub) throws Exception{
        List<Qc_zhub> qc_zhubs = service.findZhubByMany(qc_zhub);
        return qc_zhubs;
    }

    //根据主表id查询所有的子表s
    @RequestMapping("findZibsByZhubId")
    @ResponseBody
    public List<Qc_zib> findZibsByZhubId(Long qc_zhub_id) throws Exception{
        //System.out.println(qc_zhub_id);
        List<Qc_zib> qc_zibs = service.findZibsByZhubId(qc_zhub_id);
        /*for (Qc_zib qc_zib:qc_zibs) {
            System.out.println(qc_zib);
        }*/
        return qc_zibs;
    }

    //获取订单号，并请求转发到添加页面
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception{
        String djh = UUIDUtils.getOrderNumber();
        request.setAttribute("djh", djh);
        return "forward:/pages/business/qc-add.jsp";
    }

    //保存主表和子表（添加数据）
    @RequestMapping("saveZhubAndZib")
    @ResponseBody
    public PageInfo saveZhubAndZib(Qc_zhub qc_zhub) throws Exception{
        PageInfo pageInfo = service.saveZhubAndZib(qc_zhub);
        return pageInfo;
    }

    //根据主表id查询主表信息
    @RequestMapping("findZhubByZhuId")
    @ResponseBody
    public Qc_zhub findQc_zhubByZhuId(Long qc_zhub_id) throws Exception{
        Qc_zhub qc_zhub = service.findZhubByZhuId(qc_zhub_id);
        return qc_zhub;
    }

    //根据主表id更新主表信息
    @RequestMapping("updateZhubByZhubId")
    @ResponseBody
    public void updateZhubByZhubId(Qc_zhub qc_zhub) throws Exception{
        service.updateZhubByZhubId(qc_zhub);
        return;
    }

    //根据主表id删除主表
    @RequestMapping("deleteZhubByZhubId")
    @ResponseBody
    public void deleteZhubByZhubId(Long qc_zhub_id) throws Exception{
        service.deleteZhubByZhubId(qc_zhub_id);
        return;
    }

    //根据主表ids删除主表s
    @RequestMapping("deleteZhubsByZhubIds")
    @ResponseBody
    public void deleteZhubsByZhubIds(String ids) throws Exception{
        service.deleteZhubsByZhubIds(ids);
        return;
    }

    //根据子表id查询子表信息
    @RequestMapping("findZibByZibId")
    @ResponseBody
    public Qc_zib findZibByZibId(Long qc_zib_id) throws Exception{
        Qc_zib  qc_zib = service.findZibByZibId(qc_zib_id);
        return qc_zib;
    }

    //根据子表id更新子表
    @RequestMapping("updateZibByZibId")
    @ResponseBody
    public void updateZibByZibId(Qc_zib qc_zib) throws Exception{
        service.updateZibByZibId(qc_zib);
        return;
    }

    //根据子表id删除子表信息
    @RequestMapping("deleteZibByZibId")
    @ResponseBody
    public void deleteZibByZibId(Long qc_zib_id) throws Exception{
        service.deleteZibByZibId(qc_zib_id);
        return;
    }

    //根据子表ids删除子表s信息
    @RequestMapping("deleteZibsByZibIds")
    @ResponseBody
    public void deleteZibsByZibIds(String ids) throws Exception{
        service.deleteZibsByZibIds(ids);
        return;
    }

    //根据主表id，查询子表下面最大的行号+1
    @RequestMapping("getZibHhByZhubId")
    @ResponseBody
    public Integer getZibHhByZhubId(Long qc_zhub_id) throws Exception{
        Integer hh = service.getZibHhByZhubId(qc_zhub_id);
        return hh;
    }

    //添加一条子表记录
    @RequestMapping("saveZib")
    @ResponseBody
    public void saveZib(Qc_zib qc_zib) throws Exception{
        service.saveZib(qc_zib);
        return;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("spForbidden")
    @ResponseBody
    public void spForbidden(String djh, String spr, Date sprq) throws Exception{
        service.spForbidden(djh,spr,sprq);
        return;
    }


    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("spAdopt")
    @ResponseBody
    public void spAdopt(String djh, String spr, Date sprq) throws Exception{
        service.spAdopt(djh,spr,sprq);
        return ;
    }

    //查询该单据中的商品在仓库中是否已经存在，返回 0 1
    @RequestMapping("checkProductInStore")
    @ResponseBody
    public PageInfo checkProductInStore(String djh) throws Exception{
        PageInfo pageInfo = service.checkProductInStore(djh);
        return pageInfo;
    }

    //确认入库
    @RequestMapping("sureToStore")
    @ResponseBody
    public void sureToStore(String djh,String xgr,Date xgrq) throws Exception{
        service.sureToStore(djh,xgr,xgrq);
        return ;
    }



}
