<%@ page import="java.util.List" %>
<%@ page import="cn.cuit.gyl.domain.database.Message" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    window.onload = function (ev) {
        var webSocket = new WebSocket("ws://localhost:8080/gyl/builtSocket");
        /*建立连接后*/
        webSocket.onopen = function (ev1) {
            /*alert("建立连接...")*/
        }
        /*接收到的消息*/
        webSocket.onmessage = function (ev1) {
            var msg = ev1.data;
            var message = JSON.parse(msg);
            //发消息给客户端，请求添加message到session
            $.ajax({
                url:"${pageContext.request.contextPath}/message/saveMsgToSessionByMid",
                type:"get",
                data:{"mid":message.mid},
                dataType:"text",
                async:true,//异步请求
                success:function () {
                },
                error:function () {
                    alert("存取消息到会话中失败，系统异常!")
                }
            });
            var html = "";
            if(message.type == "1"){//普通消息
                var index = parseInt($("#tagSpan_normals_index").attr("index"))+1;
                $("#tagSpan_normals_index").attr("index",index);
                html+='<li>\n' +
                    '                                            <a style="width: 20%;float: right;" href="#" mid="'+message.mid+'" msgType="'+message.type+'"\n' +
                    '                                               onclick="deleteMsg(this);">删除</a>\n' +
                    '                                            <a style="width: 80%;" index="'+index+'" mid="'+message.mid+'"\n' +
                    '                                               sender="'+message.sender+'"\n' +
                    '                                               msg="'+message.msg+'" type="'+message.type+'" status="'+message.status+'" onclick="getMsg(this);">\n' +
                    '                                                <div class="pull-left">\n' +
                    '                                                    <img src="${pageContext.request.contextPath}/img/user1-128x128.jpg"\n' +
                    '                                                         class="img-circle"\n' +
                    '                                                         alt="User Image">\n' +
                    '                                                </div>\n' +
                    '                                                <h4>\n' +
                    '\n';
                if(message.status == 0){
                    html+='                                                   <i id="normals-circle-'+index+'" class="fa fa-circle"\n' +
                        '                                                       style="color: red"></i>\n';
                }else {
                    html+='                                                   <i id="normals-circle-'+index+'" class="fa fa-circle"\n' +
                        '                                                       style="color: green"></i>\n';
                }
                html+='                                                       <i>发送人: '+message.msg+'</i>\n' +
                    '                                                </h4>\n' +
                    '                                                <p><small><i\n' +
                    '                                                        class="fa fa-clock-o"></i>&nbsp;&nbsp;'+message.sendTimeStr+'\n' +
                    '                                                </small></p>\n' +
                    '                                            </a>\n' +
                    '                                        </li>';
                $("#tagUl-nomals").append(html);
                //修改数量
                var $normals_head_count = $("#normals_head_count");
                var $normals_foot_count = $("#normals_foot_count");
                var beforCount = parseInt($normals_head_count.attr("count"));
                var nowCount = beforCount+1;
                $normals_head_count.attr("count",nowCount);
                $normals_head_count[0].innerText = nowCount;
                $normals_foot_count[0].innerText = "All "+nowCount+" Messages";
            }else if(message.type == "2"){//预警消息
                var index = parseInt($("#tagSpan_earlyWarnings_index").attr("index"))+1;
                $("#tagSpan_normals_index").attr("index",index);
                html+='<li>\n' +
                    '                                            <a style="width: 10%;float: right;font-weight: bold" href="#" mid="'+message.mid+'" msgType="'+message.type+'"\n' +
                    '                                               onclick="deleteMsg(this);">x</a>\n' +
                    '                                            <a style="width: 90%;float: left;" index="'+index+'" mid="'+message.mid+'" sender="'+message.sender+'"\n' +
                    '                                               msg="'+message.msg+'" type="'+message.type+'" status="'+message.status+'" onclick="getMsg(this);">\n' +
                    '                                                <i class="fa fa-warning text-yellow"></i>\n' +
                    '                                                <span style="height: 15px">\n';
                if(message.status == 0){
                    html+='                                                        <i id="earlyWarnings-circle-'+index+'" class="fa fa-circle"\n' +
                        '                                                           style="color: red"></i>\n';
                }else{
                    html+='                                                        <i id="earlyWarnings-circle-'+index+'" class="fa fa-circle"\n' +
                        '                                                           style="color: green"></i>\n';
                }
                html+='                                                            <i>'+message.sender+'</i>\n' +
                    '                                                </span>\n' +
                    '                                                <small>\n' +
                    '                                                    <i class="fa fa-clock-o"></i>&nbsp;&nbsp;'+message.sendTimeStr+'\n' +
                    '                                                </small>\n' +
                    '                                            </a>\n' +
                    '                                        </li>';
                $("#tagUl-earlyWarnings").append(html);
                //修改数量
                var $earlyWarnings_head_count = $("#earlyWarnings_head_count");
                var $earlyWarnings_foot_count = $("#earlyWarnings_foot_count");
                var beforCount = parseInt($earlyWarnings_head_count.attr("count"));
                var nowCount = beforCount+1;
                $earlyWarnings_head_count.attr("count",nowCount);
                $earlyWarnings_head_count[0].innerText = nowCount;
                $earlyWarnings_foot_count[0].innerText = "All "+nowCount+" Messages";
            }else {
            }

        }
        /*关闭后*/
        webSocket.onclose = function (ev1) {
        }
        /*连接出错*/
        webSocket.onerror = function (ev1) {
            alert("error:与服务器连接出现错误，请联系管理员！")
        }
    }

    //获取message到模态框
    function getMsg(x) {
        var $x = $(x);
        var index = $x.attr("index");
        var mid = $x.attr("mid");
        var sender = $x.attr("sender");
        var msg = $x.attr("msg");
        var type = $x.attr("type");
        var status = $x.attr("status");

        $("#xxx").trigger("click");
        var $setMessageStatusBtn = $("#setMessageStatusBtn");
        $setMessageStatusBtn.attr("index", index);
        $setMessageStatusBtn.attr("mid", mid);
        $setMessageStatusBtn.attr("type", type);
        $setMessageStatusBtn.attr("status", status);
        document.getElementById("senderId").innerHTML = sender + "消息详情";
        document.getElementById("msgTbody").innerHTML = msg;
    }

    //点击已读按钮触发：设置对应的元素颜色为绿色，发送ajax，根据mid即修改message的状态为1；
    function setMessageStatus(x) {
        var $x = $(x);
        var index = $x.attr("index");
        var mid = $x.attr("mid");
        var type = $x.attr("type");
        var status = $x.attr("status");
        if (status == "0") {//状态为 0 的才修改
            $.ajax({
                url: "${pageContext.request.contextPath}/message/updateMessageStatusByMid",
                data: {"mid": mid, "status": 1},
                type: "post",
                dataType: "text",
                async: true,
                success: function () {
                    if(type == "1"){
                        document.getElementById("normals-circle-" + index).style.color = "green";
                    }else if(type == "2"){
                        document.getElementById("earlyWarnings-circle-" + index).style.color = "green";
                    }else {
                    }
                },
                error: function () {
                    alert("修改消息（数据库和session）为已读出现错误！")
                }
            });
        }
    }

    //测试发送消息到客户端
    function sendMsgBtn(x) {
        $.ajax({
            url:"${pageContext.request.contextPath}/message/sendMsg",
            type:"get",
            data:{},
            dataType:"text",
            async:true,
            success:function () {
                alert("服务器已发送消息到客户端.......")
            },
            error:function () {
                alert("发送消息失败......")
            }
        });
    }

    //点击删除按钮，删除该条记录
    function deleteMsg(x) {
        var $x = $(x);
        var mid = $x.attr("mid");
        $.ajax({
            url: "${pageContext.request.contextPath}/message/deleteMsgByMid",
            type: "get",
            data:{"mid":mid},
            dataType:"text",
            async:true,
            success:function () {
                var tagA = $x[0];//js对象
                tagA.parentElement.remove();
                var type = $x.attr("msgType");
                if(type == "1"){
                    var $normals_head_count = $("#normals_head_count");
                    var $normals_foot_count = $("#normals_foot_count");
                    var beforCount = $normals_head_count.attr("count");
                    var nowCount = parseInt(beforCount)-1;
                    $normals_head_count.attr("count",nowCount);
                    $normals_head_count[0].innerText = nowCount;
                    $normals_foot_count[0].innerText = "All "+nowCount+" Messages";
                }else if(type == "2"){
                    var $earlyWarnings_head_count = $("#earlyWarnings_head_count");
                    var $earlyWarnings_foot_count = $("#earlyWarnings_foot_count");
                    var beforCount = $earlyWarnings_head_count.attr("count");
                    var nowCount = parseInt(beforCount)-1;
                    $earlyWarnings_head_count.attr("count",nowCount);
                    $earlyWarnings_head_count[0].innerText = nowCount;
                    $earlyWarnings_foot_count[0].innerText = "All "+nowCount+" Messages";
                }else {//其他类型的消息
                }
            },
            error:function () {
                alert("删除消息（数据库和session）时系统出现问题，请及时联系管理员！")
            }
        });
    }

</script>
<!-- 页面头部 -->
<header class="main-header">
    <!-- Logo -->
    <a href="all-admin-index.html" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>供应链</b></span> <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>供应链</b>管理系统</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas"
           role="button"> <span class="sr-only">Toggle navigation</span>
        </a>
        <%--<button id="sendMsgBtn" type="button" onclick="sendMsgBtn(this)">发送消息到客户端</button>--%>
        <%
            List<Message> messages = (List<Message>) session.getAttribute("messages");
            List<Message> normals = new ArrayList<>();//普通消息
            List<Message> earlyWarnings = new ArrayList<>();//预警消息
            if (messages != null) {
                for (Message message : messages) {
                    if (message.getType() == 1) {
                        normals.add(message);
                    } else if (message.getType() == 2) {
                        earlyWarnings.add(message);
                    } else {
                    }
                }
            }
        %>
        <%--
        第一个记录原来：普通消息最后一个遍历的index
        第二个记录原来：预警消息最后一行遍历的index
        ...
        主要用于客户端接收消息后，追加元素用的
        --%>
        <span id="tagSpan_normals_index" index="<%=normals.size()-1%>" hidden="hidden"></span>
        <span id="tagSpan_earlyWarnings_index" index="<%=earlyWarnings.size()-1%>" hidden="hidden"></span>
        <%--....--%>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- 普通消息类型 -->
                <li class="dropdown messages-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-envelope-o"></i>
                        <span id="normals_head_count" count="<%=normals.size()%>" class="label label-success"><%=normals.size()%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">
                            <i class="fa fa-circle" style="color: green;"></i>已读
                            <i class="fa fa-circle" style="color: red;"></i>未读
                            <span>【普通消息】</span>
                        </li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul id="tagUl-nomals" class="menu">
                                <!-- start message -->
                                <c:if test="<%=normals.size() > 0%>">
                                    <c:forEach items="<%=normals%>" var="message" varStatus="status">
                                        <li>
                                            <a style="width: 20%;float: right;" href="#" mid="${message.mid}" msgType="${message.type}"
                                               onclick="deleteMsg(this);">删除</a>
                                            <a style="width: 80%;" index="${status.index}" mid="${message.mid}"
                                               sender="${message.sender}"
                                               msg="${message.msg}" type="${message.type}" status="${message.status}" onclick="getMsg(this);">
                                                <div class="pull-left">
                                                    <img src="${pageContext.request.contextPath}/img/user1-128x128.jpg"
                                                         class="img-circle"
                                                         alt="User Image">
                                                </div>
                                                <h4>
                                                    <c:if test="${message.status == 0}">
                                                        <i id="normals-circle-${status.index}" class="fa fa-circle"
                                                           style="color: red"></i>
                                                    </c:if>
                                                    <c:if test="${message.status == 1}">
                                                        <i id="normals-circle-${status.index}" class="fa fa-circle"
                                                           style="color: green"></i>
                                                    </c:if>
                                                    <i>发送人: ${message.sender}</i>
                                                </h4>
                                                <p><small><i
                                                        class="fa fa-clock-o"></i>&nbsp;&nbsp;${message.sendTimeStr}
                                                </small></p>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <!-- start message/ -->
                            </ul>
                        </li>
                        <hr>
                        <li class="footer"><a href="#"><span id="normals_foot_count" count="<%=normals.size()%>" style="color: black;font-weight: bold"
                                                             >All <%=normals.size()%> Messages</span></a>
                        </li>
                    </ul>
                </li>
                <!-- 预警消息类型 -->
                <li class="dropdown notifications-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-bell-o"></i>
                        <span id="earlyWarnings_head_count" count="<%=earlyWarnings.size()%>" class="label label-warning"><%=earlyWarnings.size()%></span>
                    </a>
                    <ul class="dropdown-menu">
                        <%--<li class="header">You have 10 notifications</li>--%>
                        <li class="header">
                            <i class="fa fa-circle" style="color: green;"></i>已读
                            <i class="fa fa-circle" style="color: red;"></i>未读
                            <span>【预警消息】</span>
                        </li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul id="tagUl-earlyWarnings" class="menu">
                                <%--<li>
                                    <a href="#">
                                        <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                    </a>
                                </li>--%>
                                <!-- start message -->
                                <c:if test="<%=earlyWarnings.size() > 0%>">
                                    <c:forEach items="<%=earlyWarnings%>" var="message" varStatus="status">
                                        <li>
                                            <a style="width: 10%;float: right;font-weight: bold" href="#" mid="${message.mid}" msgType="${message.type}"
                                               onclick="deleteMsg(this);">x</a>
                                            <a style="width: 90%;float: left;" index="${status.index}" mid="${message.mid}" sender="${message.sender}"
                                               msg="${message.msg}" type="${message.type}" status="${message.status}" onclick="getMsg(this);">
                                                <i class="fa fa-warning text-yellow"></i>
                                                <span style="height: 15px">
                                                    <c:if test="${message.status == 0}">
                                                        <i id="earlyWarnings-circle-${status.index}" class="fa fa-circle"
                                                           style="color: red"></i>
                                                    </c:if>
                                                    <c:if test="${message.status == 1}">
                                                        <i id="earlyWarnings-circle-${status.index}" class="fa fa-circle"
                                                           style="color: green"></i>
                                                    </c:if>
                                                    <i>${message.sender}</i>
                                                </span>
                                                <small>
                                                    <i class="fa fa-clock-o"></i>&nbsp;&nbsp;${message.sendTimeStr}
                                                </small>
                                            </a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <!-- start message/ -->
                                <%--<li>
                                    <a href="#">
                                        <i class="fa fa-warning text-yellow"></i> Very long description here that may
                                        not fit into the
                                        page and may cause design problems
                                    </a>
                                </li>--%>
                                <%--<li>
                                    <a href="#">
                                        <i class="fa fa-users text-red"></i> 5 new members joined
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fa fa-user text-red"></i> You changed your username
                                    </a>
                                </li>--%>
                            </ul>
                        </li>
                        <hr>
                        <li class="footer"><a href="#"><span id="earlyWarnings_foot_count"
                                                             style="color: black;font-weight: bold"
                                                             >All <%=earlyWarnings.size()%> Messages</span></a>
                        </li>
                    </ul>
                </li>
                <!-- Tasks: style can be found in dropdown.less -->
                <%--<li class="dropdown tasks-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-flag-o"></i>
                        <span class="label label-danger">9</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li class="header">You have 9 tasks</li>
                        <li>
                            <!-- inner menu: contains the actual data -->
                            <ul class="menu">
                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Design some buttons
                                            <small class="pull-right">20%</small>
                                        </h3>
                                        <div class="progress xs">
                                            <div class="progress-bar progress-bar-aqua" style="width: 20%"
                                                 role="progressbar"
                                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                <span class="sr-only">20% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->
                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Create a nice theme
                                            <small class="pull-right">40%</small>
                                        </h3>
                                        <div class="progress xs">
                                            <div class="progress-bar progress-bar-green" style="width: 40%"
                                                 role="progressbar"
                                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                <span class="sr-only">40% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->
                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Some task I need to do
                                            <small class="pull-right">60%</small>
                                        </h3>
                                        <div class="progress xs">
                                            <div class="progress-bar progress-bar-red" style="width: 60%"
                                                 role="progressbar"
                                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                <span class="sr-only">60% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->
                                <li><!-- Task item -->
                                    <a href="#">
                                        <h3>
                                            Make beautiful transitions
                                            <small class="pull-right">80%</small>
                                        </h3>
                                        <div class="progress xs">
                                            <div class="progress-bar progress-bar-yellow" style="width: 80%"
                                                 role="progressbar"
                                                 aria-valuenow="20" aria-valuemin="0" aria-valuemax="100">
                                                <span class="sr-only">80% Complete</span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                                <!-- end task item -->
                            </ul>
                        </li>
                        <li class="footer">
                            <a href="#">View all tasks</a>
                        </li>
                    </ul>
                </li>--%>
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#"
                       class="dropdown-toggle" data-toggle="dropdown"> <img
                            src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
                            class="user-image" alt="User Image">
                        <span class="hidden-xs">
						<security:authentication property="principal.username"></security:authentication>
						</span>
                    </a>


                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header"><img
                                src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
                                class="img-circle" alt="User Image">
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <%--<a href="#" class="btn btn-default btn-flat">修改密码</a>--%>
                            </div>
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/logout"
                                   class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
        <%--<div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#"
                       class="dropdown-toggle" data-toggle="dropdown"> <img
                            src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
                            class="user-image" alt="User Image">
                        <span class="hidden-xs">
						<security:authentication property="principal.username"></security:authentication>
						</span>
                    </a>


                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header"><img
                                src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
                                class="img-circle" alt="User Image">
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="#" class="btn btn-default btn-flat">修改密码</a>
                            </div>
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/logout"
                                   class="btn btn-default btn-flat">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>--%>
    </nav>
</header>
<!-- 页面头部 /-->
<button style="display: none" id="xxx" data-toggle="modal" data-target="#myModal"></button>
<%--模拟窗口--%>
<!--模态框-->
<div style="padding-left: 40%;padding-top: 15%;" class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 id="senderId" class="modal-title"></h4>
            </div>
            <div class="modal-body" style="padding-left:10%;padding-right: 10%">
                <table style="height: 100%;width: 100%;overflow-y:scroll;font-weight: bold">
                    <tbody id="msgTbody">

                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button id="setMessageStatusBtn" index="-1" mid="-1" type="-1" status="-1" onclick="setMessageStatus(this);"
                        style="font-weight: bold" type="button" class="btn btn-default" data-dismiss="modal">已读
                </button>
            </div>
        </div>
    </div>
</div>
<%--模拟窗口/--%>
