package cn.cuit.gyl.controller.business;


import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.Cgdhd_zib;
import cn.cuit.gyl.domain.business.Cgrkd_zhub;
import cn.cuit.gyl.domain.business.Cgrkd_zib;
import cn.cuit.gyl.service.business.ICgrkdService;
import cn.cuit.gyl.utils.PageInfo;
import cn.cuit.gyl.utils.Reback;
import cn.cuit.gyl.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/cgrkd")
public class CgrkdController {


    @Autowired
    @Qualifier("ICgrkdSerivceImpl")
    private ICgrkdService service;
    

    //功能：在cgrkd-add.jsp中单击保存按钮触发。保存子表和主表信息。
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public PageInfo saveZhubAndZib(Cgrkd_zhub cgrkd_zhub) throws Exception {
        PageInfo pageInfo = service.saveZhubAndZib(cgrkd_zhub);
        return pageInfo;
    }

    //功能:获取订单号，但不用跳转
    @RequestMapping("/getDdh")
    @ResponseBody
    public String getDdh() throws Exception {
        String djh = UUIDUtils.getOrderNumber();
        return djh;
    }

    //功能：点击aside.jsp中的采购到货单添加按钮触发,获取djh到cgrkd-add.jsp
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception {
        String djh = UUIDUtils.getOrderNumber();
        request.setAttribute("djh", djh);
        return "forward:/pages/business/cgrkd-add.jsp";
    }

    //功能：点击cgrkd-query.jsp中的查询按钮触发，根据信息查询满足所有的采购到货单
    @RequestMapping("/findByCgrkd_zhub")
    @ResponseBody
    public List<Cgrkd_zhub> findByCgrkd_zhub(Cgrkd_zhub cgrkd_zhub) throws Exception {
        List<Cgrkd_zhub> cgrkd_zhubs = service.findByCgrkd_zhub(cgrkd_zhub);
       /* for(Cgrkd_zhub cgrkd_zhub1:cgrkd_zhubs){
            System.out.println(cgrkd_zhub1);
        }*/
        return cgrkd_zhubs;
    }

    //功能：点击cgrkd-query.jsp主表中的修改按钮触发，根据主表id查询信息并返回
    @RequestMapping("/findCgrkd_zhubById")
    @ResponseBody
    public Cgrkd_zhub findCgrkd_zhubById(Integer cgrkd_zhub_id) throws Exception {
        Cgrkd_zhub cgrkd_zhub = service.findCgrkd_zhubById(cgrkd_zhub_id);
        return cgrkd_zhub;
    }

    //功能：点击cgrkd-query.jsp主表中的模态框修改按钮触发，根据id修改信息
    @RequestMapping("/updateCgrkd_zhubById")
    @ResponseBody
    public void updateCgrkd_zhubById(Cgrkd_zhub cgrkd_zhub) throws Exception {
        service.updateCgrkd_zhubById(cgrkd_zhub);
        return;
    }

    //功能：点击cgrkd-query.jsp主表中的删除按钮触发，根据主表id删除信息
    @RequestMapping("/deleteCgrkd_ZhubById")
    @ResponseBody
    public void deleteCgrkd_ZhubById(Integer cgrkd_zhub_id) throws Exception {
        service.deleteCgrkd_ZhubById(cgrkd_zhub_id);
        return;
    }

    //功能：主点击cgrkd-query.jsp主表下面的添加按钮触发，添加到模态框主表信息，先查询出djh
    @RequestMapping("/getZhub_djh")
    @ResponseBody
    public String getZhub_djh() throws Exception {
        String djh = UUIDUtils.getOrderNumber();
        return djh;
    }

    //功能：主点击cgrkd-query.jsp主表添加模态框的添加按钮触发，添加主表信息
    @RequestMapping("/saveCgrkd_zhub")
    @ResponseBody
    public void saveCgrkd_zhub(Cgrkd_zhub cgrkd_zhub) throws Exception {
        //System.out.println(cgrkd_zhub);
        service.saveCgrkd_zhub(cgrkd_zhub);
        return;
    }

    //功能：主点击cgrkd-query.jsp主表下面的删除按钮触发，根据ids删除信息
    @RequestMapping("/deleteCgrkd_ZhubByIds")
    @ResponseBody
    public void deleteCgrkd_ZhubByIds(String ids) throws Exception {
        service.deleteCgrkd_ZhubByIds(ids);
        return;
    }

    //功能：1, 双击 cgrkd-query.jsp主表中的djh按钮触发，根据在主表id（外键）查询所有的子表信息
    //     2, 点击 子表刷新按钮功能触发，根据主表id，查询更新子表信息
    @RequestMapping("/findCgrkd_zibByZhubId")
    @ResponseBody
    public List<Cgrkd_zib> findCgrkd_zibByZhubId(Integer cgrkd_zhub_id) throws Exception {
        List<Cgrkd_zib> cgrkd_zibs = service.findCgrkd_zibByZhubId(cgrkd_zhub_id);
        return cgrkd_zibs;
    }

    //功能：双击 cgrkd-query.jsp子表中的修改按钮触发，根据子表id进行查询信息
    @RequestMapping("/findCgrkd_zibById")
    @ResponseBody
    public Cgrkd_zib findCgrkd_zibById(Integer cgrkd_zib_id) throws Exception {
        Cgrkd_zib cgrkd_zib = service.findCgrkd_zibById(cgrkd_zib_id);
        return cgrkd_zib;
    }

    //功能：双击 cgrkd-query.jsp子表模态框中的修改按钮触发，根据子表id进行修改相关信息（如回写采购订单的数据等等步骤）
    @RequestMapping("/updateCgrkd_zibById")
    @ResponseBody
    public void updateCgrkd_zibById(Cgrkd_zib cgrkd_zib) throws Exception {
        //System.out.println(cgrkd_zib);
        service.updateCgrkd_zibById(cgrkd_zib);
        return;
    }

    //功能：单击 cgrkd-query.jsp子表中的删除按钮触发，根据子表id删除子表信息
    @RequestMapping("/deleteCgrkd_ZibById")
    @ResponseBody
    public void deleteCgrkd_ZibById(Integer cgrkd_zib_id) throws Exception {
        service.deleteCgrkd_ZibById(cgrkd_zib_id);
        return;
    }

    //功能：单击 cgrkd-query.jsp子表下面中的删除按钮触发，根据子表ids删除子表信息
    @RequestMapping("/deleteCgrkd_ZibByIds")
    @ResponseBody
    public void deleteCgrkd_ZibByIds(String ids) throws Exception {
        service.deleteCgrkd_ZibByIds(ids);
        return;
    }

    //功能：单击cgrkd-query.jsp中子表下面的添加按钮触发,根据主表查询出max行号+1
    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Integer getZib_hh(Integer cgrkd_zhub_id) throws Exception {
        //System.out.println(cgrkd_zhub_id);
        Integer hh = service.getZib_hh(cgrkd_zhub_id);
        return hh;
    }

    //功能：单击cgrkd-query.jsp中子表模态框中的添加按钮触发,保存一个子表
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Cgrkd_zib cgrkd_zib) throws Exception {
        service.saveCgrkd_zib(cgrkd_zib);
        return;
    }

    //功能：单击cgrkd-update.jsp中搜索按钮，搜索 未审批的发货单
    @RequestMapping("/findAllAndSfshIsZero")
    @ResponseBody
    public List<Cgrkd_zhub> findAllAndSfspIsZero(Cgrkd_zhub cgrkd_zhub) throws Exception {
        List<Cgrkd_zhub> cgrkd_zhubs = service.findAllAndSfshIsZero(cgrkd_zhub);
        return cgrkd_zhubs;
    }

    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    @RequestMapping("/spForbidden")
    @ResponseBody
    public void spForbidden(String djh, String spr, Date sprq) throws Exception {
        service.spForbidden(djh,spr,sprq);
        return;
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    @RequestMapping("/spAdopt")
    @ResponseBody
    public void spAdopt(String djh, String spr, Date shrq) throws Exception {
        service.spAdopt(djh,spr,shrq);
        return;
    }

    //功能：单击表下面的 确认入库按钮，根据ids将选择的所有子表中的status修改为1
    @RequestMapping("/updateZibStatusByIds")
    @ResponseBody
    public void updateZibStatusByIds(String ids,String xgr,Date xgsj) throws Exception {
        service.updateZibStatusByIds(ids,xgr,xgsj);
        return;
    }

    @RequestMapping("/GetYdslAndLjrksl")
    @ResponseBody
    public Reback<Cgddzhib> GetYdslAndLjrksl(@RequestParam("ytdjh")String ytdjh, @RequestParam("ythh")Integer ythh){
        Reback<Cgddzhib> pageInfo = service.getydsl(ytdjh,ythh);
        return pageInfo;
    }

    @RequestMapping("/BlanksByLy")
    @ResponseBody
    public Reback<Cgdhd_zib> BlanksByLy(@RequestParam("lydjh")String lydjh, @RequestParam("lyhh")Integer lyhh){
        Reback<Cgdhd_zib> pageInfo = service.BlanksByLy(lydjh,lyhh);
        return pageInfo;
    }
}
