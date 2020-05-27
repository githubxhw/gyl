package cn.cuit.gyl.controller.system;

import cn.cuit.gyl.service.quartz.QuartzManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//用于访问和执行任务调度器
@Controller
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    @Qualifier("quartzManager")
    private QuartzManager quartzManager;

    //开启任务调度
    @RequestMapping("/startScheduler")
    @ResponseBody
    public void startScheduler() throws Exception{
        boolean inStandbyMode = quartzManager.isInStandbyMode();
        if(inStandbyMode == true){
            quartzManager.startJobs();
        }
        return;
    }

    //暂停任务调度
    @RequestMapping("/delayScheduler")
    @ResponseBody
    public void delayScheduler() throws Exception{
        boolean inStandbyMode = quartzManager.isInStandbyMode();
        if(inStandbyMode == false){
            quartzManager.standByJobs();
        }
        return;
    }

    //任务调度器是否启动
    @RequestMapping("/isStart")
    @ResponseBody
    public boolean isStart() throws Exception{
        return quartzManager.isInStandbyMode()==true?false:true;
    }
}
