package cn.cuit.gyl.controller.business;

import cn.cuit.gyl.domain.business.Cgddzhib;
import cn.cuit.gyl.domain.business.Cgdhd_zhub;
import cn.cuit.gyl.domain.business.Cgdhd_zib;
import cn.cuit.gyl.service.business.ICgdhdService;
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

//采购到货单的V
@Controller
@RequestMapping("/cgdhd")
public class CgdhdController {

    @Autowired
    @Qualifier("cgdhdServiceImpl")
    private ICgdhdService service = null;

    //功能：在cgdhd-add.jsp中单击保存按钮触发。保存子表和主表信息。
    @RequestMapping("/saveZhubAndZib")
    @ResponseBody
    public PageInfo saveZhubAndZib(Cgdhd_zhub cgdhd_zhub) throws Exception {
        PageInfo pageInfo = service.saveZhubAndZib(cgdhd_zhub);
        return pageInfo;
    }

    //功能:获取订单号，但不用跳转
    @RequestMapping("/getDdh")
    @ResponseBody
    public String getDdh() throws Exception {
        String ddh = UUIDUtils.getOrderNumber();
        return ddh;
    }

    //功能：点击aside.jsp中的采购到货单添加按钮触发,获取ddh到cgdhd-add.jsp
    @RequestMapping("/getDdhToAddUI")
    public String getDdhToAddUI(HttpServletRequest request) throws Exception {
        String ddh = UUIDUtils.getOrderNumber();
        request.setAttribute("ddh", ddh);
        return "forward:/pages/business/cgdhd-add.jsp";
    }

    //功能：点击cgdhd-query.jsp中的查询按钮触发，根据信息查询满足所有的采购到货单
    @RequestMapping("/findByCgdhd_zhub")
    @ResponseBody
    public List<Cgdhd_zhub> findByCgdhd_zhub(Cgdhd_zhub cgdhd_zhub) throws Exception {
        List<Cgdhd_zhub> cgdhd_zhubs = service.findByCgdhd_zhub(cgdhd_zhub);
        return cgdhd_zhubs;
    }

    //功能：点击cgdhd-query.jsp主表中的修改按钮触发，根据主表id查询信息并返回
    @RequestMapping("/findCgdhd_zhubById")
    @ResponseBody
    public Cgdhd_zhub findCgdhd_zhubById(Integer cgdhd_zhub_id) throws Exception {
        Cgdhd_zhub cgdhd_zhub = service.findCgdhd_zhubById(cgdhd_zhub_id);
        return cgdhd_zhub;
    }

    //功能：点击cgdhd-query.jsp主表中的模态框修改按钮触发，根据id修改信息
    @RequestMapping("/updateCgdhd_zhubById")
    @ResponseBody
    public void updateCgdhd_zhubById(Cgdhd_zhub cgdhd_zhub) throws Exception {
        service.updateCgdhd_zhubById(cgdhd_zhub);
        return;
    }

    //功能：点击cgdhd-query.jsp主表中的删除按钮触发，根据主表id删除信息
    @RequestMapping("/deleteCgdhd_ZhubById")
    @ResponseBody
    public void deleteCgdhd_ZhubById(Integer cgdhd_zhub_id) throws Exception {
        service.deleteCgdhd_ZhubById(cgdhd_zhub_id);
        return;
    }

    //功能：主点击cgdhd-query.jsp主表下面的添加按钮触发，添加到模态框主表信息，先查询出ddh
    @RequestMapping("/getZhub_ddh")
    @ResponseBody
    public String getZhub_ddh() throws Exception {
        String ddh = UUIDUtils.getOrderNumber();
        return ddh;
    }

    //功能：主点击cgdhd-query.jsp主表添加模态框的添加按钮触发，添加主表信息
    @RequestMapping("/saveCgdhd_zhub")
    @ResponseBody
    public void saveCgdhd_zhub(Cgdhd_zhub cgdhd_zhub) throws Exception {
        //System.out.println(cgdhd_zhub);
        service.saveCgdhd_zhub(cgdhd_zhub);
        return;
    }

    //功能：主点击cgdhd-query.jsp主表下面的删除按钮触发，根据ids删除信息
    @RequestMapping("/deleteCgdhd_ZhubByIds")
    @ResponseBody
    public void deleteCgdhd_ZhubByIds(String ids) throws Exception {
        service.deleteCgdhd_ZhubByIds(ids);
        return;
    }

    //功能：1, 双击 cgdhd-query.jsp主表中的ddh按钮触发，根据在主表id（外键）查询所有的子表信息
    //     2, 点击 子表刷新按钮功能触发，根据主表id，查询更新子表信息
    @RequestMapping("/findCgdhd_zibByZhubId")
    @ResponseBody
    public List<Cgdhd_zib> findCgdhd_zibByZhubId(Integer cgdhd_zhub_id) throws Exception {
        List<Cgdhd_zib> cgdhd_zibs = service.findCgdhd_zibByZhubId(cgdhd_zhub_id);
        return cgdhd_zibs;
    }

    //功能：双击 cgdhd-query.jsp子表中的修改按钮触发，根据子表id进行查询信息
    @RequestMapping("/findCgdhd_zibById")
    @ResponseBody
    public Cgdhd_zib findCgdhd_zibById(Integer cgdhd_zib_id) throws Exception {
        Cgdhd_zib cgdhd_zib = service.findCgdhd_zibById(cgdhd_zib_id);
        return cgdhd_zib;
    }

    //功能：双击 cgdhd-query.jsp子表模态框中的修改按钮触发，根据子表id进行修改相关信息（如回写采购订单的数据等等步骤）
    @RequestMapping("/updateCgdhd_zibById")
    @ResponseBody
    public void updateCgdhd_zibById(Cgdhd_zib cgdhd_zib) throws Exception {
        //System.out.println(cgdhd_zib);
        service.updateCgdhd_zibById(cgdhd_zib);
        return;
    }

    //功能：单击 cgdhd-query.jsp子表中的删除按钮触发，根据子表id删除子表信息
    @RequestMapping("/deleteCgdhd_ZibById")
    @ResponseBody
    public void deleteCgdhd_ZibById(Integer cgdhd_zib_id) throws Exception {
        service.deleteCgdhd_ZibById(cgdhd_zib_id);
        return;
    }

    //功能：单击 cgdhd-query.jsp子表下面中的删除按钮触发，根据子表ids删除子表信息
    @RequestMapping("/deleteCgdhd_ZibByIds")
    @ResponseBody
    public void deleteCgdhd_ZibByIds(String ids) throws Exception {
        service.deleteCgdhd_ZibByIds(ids);
        return;
    }

    //功能：单击cgdhd-query.jsp中子表下面的添加按钮触发,根据主表查询出max行号+1
    @RequestMapping("/getZib_hh")
    @ResponseBody
    public Integer getZib_hh(Integer cgdhd_zhub_id) throws Exception {
        //System.out.println(cgdhd_zhub_id);
        Integer hh = service.getZib_hh(cgdhd_zhub_id);
        return hh;
    }

    //功能：单击cgdhd-query.jsp中子表模态框中的添加按钮触发,保存一个子表
    @RequestMapping("/saveZib")
    @ResponseBody
    public void saveZib(Cgdhd_zib cgdhd_zib) throws Exception {
        service.saveCgdhd_zib(cgdhd_zib);
        return;
    }

    //功能：单击cgdhd-update.jsp中搜索按钮，搜索 未审批的发货单
    @RequestMapping("/findAllAndSfspIsZero")
    @ResponseBody
    public List<Cgdhd_zhub> findAllAndSfspIsZero(Cgdhd_zhub cgdhd_zhub) throws Exception {
        List<Cgdhd_zhub> cgdhd_zhubs = service.findAllAndSfspIsZero(cgdhd_zhub);
        return cgdhd_zhubs;
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

    /**
     * 根据源头单据号和源头行号来得到应到数量和累计到货数量
     * @param ytdjh
     * @param ythh
     * @return
     */
    @RequestMapping("/getydsl")
    @ResponseBody
    public Reback<Cgddzhib> getydsl(@RequestParam("ytdjh")String ytdjh,@RequestParam("ythh")Integer ythh){
        Reback<Cgddzhib> pageInfo = service.getydsl(ytdjh,ythh);
        return pageInfo;
    }
}
