<%--
  Created by IntelliJ IDEA.
  User: XHW
  Date: 2020/4/24
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<script>

    /*window.onload = function () {
        var webSocket = new WebSocket("ws://localhost:8080/gyl/builtSocket");

        webSocket.onopen = function (evt) {
            /!*alert("与服务器建立连接后触发...");*!/
            /!*var message = {
                a: 1,
                b: "Hello world!",
                c: "2018-05-02 12:30"
            };
            webSocket.send(JSON.stringify(message));
            alert("数据发送中...");*!/
        };
        webSocket.onmessage = function (evt) {
            /!*alert("接收服务端数触发...");*!/
            var msg = evt.data;
            alert(msg);
        };
        webSocket.onerror = function (evt) {
            alert("连接错误触发...");
            alert(evt);
        };
        webSocket.onclose = function (evt) {
            alert("断开连接触发...");
            alert(evt);
        };
    }*/

</script>
<body>
    <a href="${pageContext.request.contextPath}/test/testSendMassage">testSendMassage测试服务器发消息到客户端</a><br>
    <a href="${pageContext.request.contextPath}/test/setSession"/>setSession设置session属性值<br>
    <a href="${pageContext.request.contextPath}/test/getSession"/>getSession获取session属性值<br>
    <a href="${pageContext.request.contextPath}/test/testGetSecurityUserDetails"/>testGetSecurityUserDetails获取验证的用户信息<br>
    <hr>
    <a href="${pageContext.request.contextPath}/test/testStartScheduler"/>testStartScheduler测试开启任务调度器<br>
    <a href="${pageContext.request.contextPath}/test/testStandByJobs"/>testStandByJobs测试暂停任务调度器<br>
    <a href="${pageContext.request.contextPath}/test/testStopScheduler"/>testStopScheduler测试关闭任务调度器<br>
    <hr>
    <a href="${pageContext.request.contextPath}/test/testAddJob1"/>testAddJob1测试添加job1到任务调度器<br>
    <a href="${pageContext.request.contextPath}/test/testAddJob2"/>testAddJob2测试添加job2到任务调度器<br>
    <hr>
    <a href="${pageContext.request.contextPath}/test/testUpdateJob1"/>testUpdateJo1测试修改job1<br>
    <a href="${pageContext.request.contextPath}/test/testUpdateJob2"/>testUpdateJob2测试修改job2<br>
    <hr>
    <a href="${pageContext.request.contextPath}/test/testRemoveJob1"/>testRemoveJob1测试移除job1<br>
    <a href="${pageContext.request.contextPath}/test/testRemoveJob2"/>testRemoveJob2测试移除job2<br>
</body>
</html>


