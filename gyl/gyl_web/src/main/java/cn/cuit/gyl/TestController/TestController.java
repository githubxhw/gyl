package cn.cuit.gyl.TestController;

import org.quartz.CronExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {

    /*@Autowired
    @Qualifier("quartzManager")
    private QuartzManager quartzManager = null;*/

    /*@Autowired
    @Qualifier("myWebSocket")
    private MyWebSocket webSocketHandler = null;*/

    /*@Autowired
    private HttpSession session = null;*/

    //测试开启任务调度器
    /*@RequestMapping("/testStartScheduler")
    public void testStartScheduler() throws Exception{
        quartzManager.startJobs();
        return;
    }

    //测试暂停任务调度器
    @RequestMapping("/testStandByJobs")
    public void testStandByJobs() throws Exception{
        quartzManager.standByJobs();
        return;
    }

    //测试关闭任务调度器
    @RequestMapping("/testStopScheduler")
    public void testStopScheduler() throws Exception{
        quartzManager.shutdownJobs();
        return;
    }

    //测试添加job1到任务调度器
    @RequestMapping("/testAddJob1")
    public void testAddJob1() throws Exception{
        Class<?> job1Clazz = Class.forName("cn.cuit.gyl.service.quartz.job.Job1");
        quartzManager.addJob("job1","jobGroup",job1Clazz,"trigger1","triggerGroup", "0/10 * * * * ?");
        return;
    }

    //测试添加job2到任务调度器
    @RequestMapping("/testAddJob2")
    public void testAddJob2() throws Exception{
        Class<?> job2Clazz = Class.forName("cn.cuit.gyl.service.quartz.job.Job2");
        quartzManager.addJob("job2","jobGroup",job2Clazz,"trigger2","triggerGroup", "0/20 * * * * ?");
        return;
    }

    //测试修改job1
    @RequestMapping("/testUpdateJob1")
    public void testUpdateJob1() throws Exception{
        quartzManager.modifyJobTime("job1","jobGroup","trigger1","triggerGroup","0/5 * * * * ?");
        return;
    }

    //测试修改job2
    @RequestMapping("/testUpdateJob2")
    public void testUpdateJob2() throws Exception{
        quartzManager.modifyJobTime("job2","jobGroup","trigger2","triggerGroup","0/5 * * * * ?");
        return;
    }

    //测试移除job2
    @RequestMapping("/testRemoveJob1")
    public void testRemoveJob1() throws Exception{
        quartzManager.removeJob("job1","jobGroup","trigger1","triggerGroup");
        return;
    }

    //测试移除job2
    @RequestMapping("/testRemoveJob2")
    public void testRemoveJob2() throws Exception{
        quartzManager.removeJob("job2","jobGroup","trigger2","triggerGroup");
        return;
    }*/

    /*@RequestMapping("/testSendMassage")
    public void testSendMassage() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(new Vo());
        webSocketHandler.sendMessage("root", new TextMessage(string));
        return;
    }*/

    /*@RequestMapping("/setSession")
    public String setSession(){
        session.setAttribute("sessionValue", 1);
        System.out.println("sessionValue:"+session.getAttribute("sessionValue"));
        return "redirect:/Test.jsp";
    }*/

    /*@RequestMapping("/getSession")
    public String getSession(){
        System.out.println("sessionValue:"+session.getAttribute("sessionValue"));
        return "redirect:/Test.jsp";
    }*/

   /* @RequestMapping("/testGetSecurityUserDetails")
    public String setSession(SecurityContextHolderAwareRequestWrapper request){
        SecurityContext context_session = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
        Authentication authentication = context_session.getAuthentication();
        User user = (User)authentication.getPrincipal();
        System.out.println(user.getPassword());
        return "redirect:/Test.jsp";
    }*/

    /*@RequestMapping("/test")
    public String test(Date dateTime){
        System.out.println(ConverterUtils.dateToString(dateTime, "yyyy-MM-dd HH:mm:ss"));
        return "main";
    }*/

    /*@RequestMapping("/testAjax")
    @ResponseBody//加上这个注解，return 就不会再跳转页面，只是返回数据（json）
    public vo testAjax(vo v) throws Exception{
        System.out.println(v);
        v.setId("hsdisji");
        return v;
    }*/

    /*@RequestMapping("/testA_B")
    public String testA_B(A a) throws Exception{
        System.out.println(a.getA());
        List<B> bs = a.getbList();
        for (B b:bs) {
            System.out.println(b);
        }
        return "main";
    }*/
    public static void testAddr(Vo vo){
        vo.setB("改变了");
    }

    /**
     * 返回对应的距离 天、时、分
     * @param beginDate
     * @param endDate
     * @return
     * @throws Exception
     */
    private static String getTimeDifference(Date beginDate,Date endDate) throws Exception{
        if (beginDate.after(endDate)){
            return null;
        }
        long d = 1000*60*60*24;
        long h = d/24;
        long m = h/60;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        long beginDateMillis = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long endDateMillis = calendar.getTimeInMillis();
        long away = endDateMillis-beginDateMillis;
        long day = away/d;
        long hours = (away%d)/h;
        long minutes = ((away%d)%h)/m;
        return day+"天"+hours+"时"+minutes+"分";
    }

    public static void main(String[] args) throws Exception {
        boolean validExpression = CronExpression.isValidExpression("0 */1 * * * ?");
        System.out.println(validExpression);
        /*Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, -100);
        calendar.add(Calendar.HOUR, -10);
        calendar.add(Calendar.MINUTE, -10);
        Date newTime = calendar.getTime();
        String x = TestController.getTimeDifference(newTime, today);
        System.out.println(x);*/
        /*Vo vo = new Vo();
        vo.setB("未改变前");
        System.out.println(vo);
        TestController.testAddr(vo);
        System.out.println(vo);*/
        /*UserInfo userInfo1 = new UserInfo();
        userInfo1.setId(1);
        UserInfo userInfo2 = new UserInfo();
        userInfo2.setId(1);
        System.out.println(userInfo1.equals(userInfo2));*/
        /*StringBuffer buffer = new StringBuffer("");
        System.out.println(buffer.toString().equals(""));*/
//        buffer.append()
        /*Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DATE, -10);
        Date newTime = calendar.getTime();
        System.out.println(today.getTime());
        System.out.println(newTime.getTime());
        System.out.println((today.getTime()-newTime.getTime())/(1000*3600*24));*/
        /*Vo vo = new Vo();
        List<Vo> vos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            vo.setA(i);
            vos.add(vo);
        }
        for (Vo vo1:vos) {
            System.out.println(vo1);
        }
        System.out.println(vos.size());*/
        /*try {
            Class<?> xx = Class.forName("cn.cuit.gyl.service.quartz.job.Job1");
            Method execute = xx.getMethod("xx", JobExecutionContext.class);
        } catch (ClassNotFoundException e1) {
            System.out.println("xx1=null");
        }catch (NoSuchMethodException e2){
            System.out.println("xx");
        }
        System.out.println("xx");*/
        /*ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(new Vo());
        System.out.println(string);*/
        /*String res = "000000000000";
        res+=12;
        System.out.println(res.substring(res.length()-12, res.length()));*/
        /*for (int i = 0; i < 6; i++) {
            String orderNumber = UUIDUtils.getPrimaryKey();
            System.out.println(orderNumber);
        }*/
        /*List<String> strList = new ArrayList<>();
        strList.add("a");
        strList.add("b");
        strList.add("c");
        strList.add("d");
        Iterator<String> iterator = strList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("a")){
                iterator.remove();
            }
        }
        for (String str:strList){
            System.out.println(str);
        }*/
       /* A a = new A();
        a.setA(1);
        Class<? extends A> aClass = a.getClass();
        Method method = aClass.getDeclaredMethod("reflect",Integer.class);
        method.invoke(a,2);*/
        /*DepartmentController c = new DepartmentController();
        Class<? extends DepartmentController> aClass = c.getClass();
        Method findAll = aClass.getDeclaredMethod("findAll", HttpServletRequest.class, Integer.class, Integer.class);
        Class<?>[] parameterTypes = findAll.getParameterTypes();
        for (Class z:parameterTypes) {
            System.out.println(z);
        }
        System.out.println(findAll.toString());*/
        /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayStr = simpleDateFormat.format(new Date());
        todayStr = todayStr+" 00:00:00";
        System.out.println(todayStr);
        Date today = ConverterUtils.stringToDate(todayStr, "yyyy-MM-dd HH:mm:ss");
        System.out.println(today);*/
        /*System.out.println("".equals(null));*/
    }
}
