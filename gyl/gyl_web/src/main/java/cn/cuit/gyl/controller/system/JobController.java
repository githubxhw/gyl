package cn.cuit.gyl.controller.system;

import cn.cuit.gyl.domain.others.Tip;
import cn.cuit.gyl.domain.system.Job;
import cn.cuit.gyl.service.quartz.QuartzManager;
import cn.cuit.gyl.service.system.IJobService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    @Qualifier("jobServiceImpl")
    private IJobService service = null;

    @Autowired
    @Qualifier("quartzManager")
    private QuartzManager manager = null;

    //分页查询任务s
    //若查询时候，任务调度器没有启动，则返回一个提示错误页面
    @RequestMapping("/findJobsByPage")
    public String findJobsByPage(HttpServletRequest request, @RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = true, defaultValue = "6") Integer pageSize) throws Exception {
        if(manager.isStarted() == false || manager.isInStandbyMode() == true){
            Tip tip = new Tip();
            tip.setMsg("由于任务调度设置没有打开（即未启动），无法查看任务进程服务状态，请启动任务调度器。");
            tip.setIsRedirect(true);
            tip.setUrl("pages/system/system-setting.jsp");
            request.setAttribute("tip",tip );
            return "forward:/tipInfo.jsp";
        }else {
            List<Job> jobs = service.findAllByPage(pageNum, pageSize);
            PageInfo pageInfo = new PageInfo(jobs);
            request.setAttribute("pageInfo", pageInfo);
            return "forward:/pages/system/job-list.jsp";
        }
    }

    //根据任务名称查询任务信息
    @RequestMapping("/findJobByJobName")
    public String findJobByJobName(HttpServletRequest request,String jobName) throws Exception {
        Integer pageNum = 1;
        Integer pageSize = 6;
        List<Job> jobs = service.findJobByJobName(pageNum,pageSize,jobName);
        PageInfo pageInfo = new PageInfo(jobs);
        request.setAttribute("pageInfo", pageInfo);
        return "forward:/pages/system/job-list.jsp";
    }

    //根据任务id查询信息
    @RequestMapping("/findJobByJobId")
    @ResponseBody
    public Job findJobByJobId(Long jobId) throws Exception {
        Job job = service.findJobByJobId(jobId);
        return job;
    }

    //根据任务id更新任务信息
    @RequestMapping("/updateJobByJobId")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo updateJobByJobId(Job job) throws Exception {
        cn.cuit.gyl.utils.PageInfo pageInfo = service.updateJobByJobId(job);
        return pageInfo;
    }

    //开启当前job（根据jobId查询）服务程序
    @RequestMapping("/openServerInJobId")
    @ResponseBody
    public void openServerInJobId(Long jobId) throws Exception {
        service.openServerInJobId(jobId);
        return ;
    }

    //关闭当前job（根据jobId查询）服务程序
    @RequestMapping("/closeServerInJobId")
    @ResponseBody
    public void closeServerInJobId(Long jobId) throws Exception {
        service.closeServerInJobId(jobId);
        return;
    }

    //获取job的id到页面:查询最大jobId+1
    @RequestMapping("/getJobIdToAddModal")
    @ResponseBody
    public Long getJobIdToAddModal() throws Exception {
        Long jobId = service.getJobIdToAddModal();
        return jobId;
    }

    //添加一条job信息，并返回添加情况信息
    @RequestMapping("/addJob")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo addJob(Job job) throws Exception {
        cn.cuit.gyl.utils.PageInfo pageInfo = service.addJob(job);
        return pageInfo;
    }

    //根据ids删除jobs
    @RequestMapping("/deleteJobs")
    @ResponseBody
    public cn.cuit.gyl.utils.PageInfo deleteJobs(String ids) throws Exception {
        cn.cuit.gyl.utils.PageInfo pageInfo = service.deleteJobs(ids);
        return pageInfo;
    }
}
