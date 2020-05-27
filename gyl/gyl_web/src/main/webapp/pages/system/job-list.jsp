<%--
  Created by IntelliJ IDEA.
  User: XHW
  Date: 2020/2/17
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>任务列表设置</title>
    <meta name="description" content="AdminLTE2">
    <meta name="keywords" content="AdminLTE2">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <%--switch：css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/switch/css/switch.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">

</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="../../header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="../../aside.jsp"></jsp:include>

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                任务管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">任务管理</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">任务列表</h3>
                </div>


                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">
                        <!--工具栏-->
                        <%--<div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="部门名称 搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>--%>
                        <form method="get" action="${pageContext.request.contextPath}/job/findJobByJobName">
                            <div class="box-tools pull-right">
                                <div class="has-feedback form-group form-inline">
                                    <input type="text" name="jobName" class="form-control input-sm" placeholder="任务名称">
                                    <button type="submit" class="btn btn-group-sm">搜索</button>
                                </div>
                            </div>
                        </form>
                        <!--工具栏/-->
                        <!--数据列表-->
                        <table style="font-size: small;border-collapse:separate; border-spacing:0px 0px;" id="dataList"
                               class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right:0px;">
                                    <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="text-center sorting">ID</th>
                                <th class="text-center sorting">任务名</th>
                                <th class="text-center sorting">任务组</th>
                                <th class="text-center sorting">任务类</th>
                                <th class="text-center sorting">触发器</th>
                                <th class="text-center sorting">触发器组</th>
                                <th class="text-center sorting">cron表达式</th>
                                <th class="text-center sorting">创建时间</th>
                                <th class="text-center sorting">更新时间</th>
                                <th class="text-center sorting">服务状态</th>
                                <th class="text-center sorting">描述</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>

                            <%--内容--%>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="job" varStatus="status">
                                <tr>
                                    <td><input name="ids" type="checkbox" value="${job.jobId}"></td>
                                    <td>${job.jobId}</td>
                                    <td>${job.jobName}</td>
                                    <td>${job.jobGroupName}</td>
                                    <td>${job.jobClassName}</td>
                                    <td>${job.triggerName}</td>
                                    <td>${job.triggerGroupName}</td>
                                    <td>${job.cronExpression}</td>
                                    <td>${job.createTimeStr}</td>
                                    <td>${job.updateTimeStr}</td>
                                    <c:if test="${job.jobStatus == 1}">
                                        <td style="height: 50px">
                                            <input class="switch switch-anim" type="checkbox" checked="checked" onchange="isOpenThisServer(this);" jobId="${job.jobId}">
                                        </td>
                                    </c:if>
                                    <c:if test="${job.jobStatus == 0}">
                                        <td>
                                            <input class="switch switch-anim" type="checkbox" onchange="isOpenThisServer(this);" jobId="${job.jobId}">
                                        </td>
                                    </c:if>
                                    <td>${job.description}</td>
                                    <td class="text-center">
                                        <button jobId="${job.jobId}" index="${status.index}" type="button"
                                                class="btn bg-olive btn-xs"
                                                data-toggle="modal" data-target="#job_myModal_${status.index}"
                                                onclick="findJobByJobIdToUI(this);">
                                            修改
                                        </button>
                                        <!--模态窗口-->
                                        <div id="job_myModal_${status.index}" class="modal modal-primary" role="dialog">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">
                                                            <span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title">任务信息修改</h4>
                                                    </div>
                                                    <form id="xg_from_${status.index}" method="post">
                                                        <div class="modal-body">
                                                            <div class="box-body">
                                                                <div class="form-horizontal">
                                                                    <table style="font-weight: lighter;height:100%;width:100%;text-align: center;border-collapse:separate; border-spacing:0px 10px;">
                                                                        <tr>
                                                                            <td style="text-align: left">任务ID:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_jobId_${status.index}" name="jobId"
                                                                                       style="" readonly="readonly"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">任务名:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_jobName_${status.index}" name="jobName"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">任务组:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_jobGroupName_${status.index}" name="jobGroupName"
                                                                                       type="text">
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left">触发器:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_triggerName_${status.index}" name="triggerName"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">触发器组:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_triggerGroupName_${status.index}" name="triggerGroupName"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">cron表达式:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_cronExpression_${status.index}" name="cronExpression" <%--cronExpression--%>
                                                                                       type="text">
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left">创建时间:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_createTime_${status.index}" name="createTime"
                                                                                       style="" readonly="readonly"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">更新时间:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_updateTime_${status.index}" name="updateTime"
                                                                                       style="" readonly="readonly"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">服务状态:</td>
                                                                            <td style="text-align: left">
                                                                                <select name="jobStatus">
                                                                                    <option id="xg_jobStatus_option1_${status.index}"
                                                                                            value="1">开启
                                                                                    </option>
                                                                                    <option id="xg_jobStatus_option0_${status.index}"
                                                                                            value="0">关闭
                                                                                    </option>
                                                                                </select>
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left">任务类:</td>
                                                                            <td style="text-align: left;">
                                                                                <input width="30%"
                                                                                       id="xg_jobClassName_${status.index}" name="jobClassName"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">描述:</td>
                                                                            <td style="text-align: left">
                                                                                <textarea
                                                                                        id="xg_description_${status.index}" name="description"
                                                                                        style="font-weight: lighter"></textarea>
                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-outline"
                                                                    data-dismiss="modal">取消
                                                            </button>
                                                            <button type="button" class="btn btn-outline" index="${status.index}"
                                                                    onclick="sureUpdateJob(this);"
                                                                    data-dismiss="modal">修改
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>
                                                <!-- /.modal-content -->
                                            </div>

                                            <!-- /.modal-dialog -->
                                        </div>
                                        <!--模态窗口/-->
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <%--工具栏--%>
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="添加" data-toggle="modal" data-target="#jobAdd_myModal"
                                            onclick="getJobIdToAddModal();">
                                        <i
                                                class="fa fa-file-o"></i> +
                                    </button>
                                    <!--模态窗口-->
                                    <div id="jobAdd_myModal" class="modal modal-primary" role="dialog">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">任务信息添加</h4>
                                                </div>
                                                <form id="add_from" method="post">
                                                    <div class="modal-body">
                                                        <div class="box-body">
                                                            <div class="form-horizontal">
                                                                <table style="font-weight: lighter;height:100%;width:100%;text-align: center;border-collapse:separate; border-spacing:0px 10px;">
                                                                    <tr>
                                                                        <td style="text-align: left">任务ID:</td>
                                                                        <td style="text-align: left">
                                                                            <input id="addModal_input_jobId" name="jobId"
                                                                                   style="" readonly="readonly" value=""
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">任务名:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="jobName"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">任务组:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="jobGroupName"
                                                                                   type="text">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: left">触发器:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="triggerName"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">触发器组:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="triggerGroupName"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">cron表达式:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="cronExpression"
                                                                                   type="text">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: left">创建时间:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="createTime"
                                                                                   style="" readonly="readonly"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">更新时间:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="updateTime"
                                                                                   style="" readonly="readonly"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">服务状态:</td>
                                                                        <td style="text-align: left">
                                                                            <select name="jobStatus">
                                                                                <option selected="selected"
                                                                                        value="0">关闭
                                                                                </option>
                                                                            </select>
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: left">任务类:</td>
                                                                        <td style="text-align: left;">
                                                                            <input width="30%"
                                                                                   name="jobClassName"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">描述:</td>
                                                                        <td style="text-align: left">
                                                                                <textarea
                                                                                        name="description"
                                                                                        style="font-weight: lighter"></textarea>
                                                                        </td>
                                                                    </tr>
                                                                </table>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-outline"
                                                                data-dismiss="modal">取消
                                                        </button>
                                                        <button type="button" class="btn btn-outline"
                                                                onclick="sureAddJob();"
                                                                data-dismiss="modal">添加
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                            <!-- /.modal-content -->
                                        </div>

                                        <!-- /.modal-dialog -->
                                    </div>
                                    <!--模态窗口/-->
                                    <button onclick="sureDeleteJob();" type="button" class="btn btn-default" title="删除"><i
                                            class="fa fa-trash-o"></i> -
                                    </button>
                                </div>
                            </div>
                        </div>
                        <%--工具栏/--%>
                    </div>
                </div>
                <!-- /.box-body -->
                <c:if test="${not empty pageInfo.list}">
                    <!-- .box-footer-->
                    <div class="box-footer">
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                总共 ${pageInfo.pages} 页，共 ${pageInfo.total} 条数据。
                            </div>
                        </div>

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li><a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=1&pageSize=6"
                                       aria-label="Previous">首页</a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${pageInfo.pageNum-1}&pageSize=6">上一页</a>
                                </li>

                                <c:if test="${pageInfo.pages <= 5}">
                                    <c:forEach begin="1" end="${pageInfo.pages}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${index}&pageSize=6">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pageInfo.pages > 5 && pageInfo.pageNum+4 <= pageInfo.pages}">
                                    <c:forEach begin="${pageInfo.pageNum}" end="${pageInfo.pageNum+4}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${index}&pageSize=6">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pageInfo.pages > 5 && pageInfo.pageNum+4 > pageInfo.pages}">
                                    <c:forEach begin="${pageInfo.pages-4}" end="${pageInfo.pages}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${index}&pageSize=6">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <li>
                                    <a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${pageInfo.pageNum+1}&pageSize=6">下一页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${pageInfo.pages}&pageSize=6"
                                       aria-label="Next">尾页</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </c:if>
                <!-- /.box-footer-->
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->


    <!-- 底部导航 -->
    <jsp:include page="../../footer.jsp"/>

</div>
<%--自定义switch插件：js--%>
<script src="${pageContext.request.contextPath}/plugins/switch/js/switch.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script>

    //点击删除按钮，删除任务
    //若任务在运行中则提示不能删除，否则删除job信息
    function sureDeleteJob() {
        if(confirm("是否删除选中的任务？") == true){
            var ids = "";
            var inputs = document.getElementsByName("ids");
            for (var i = 0, j = 0; i < inputs.length; i++) {
                if (inputs[i].checked) {
                    if (j == 0) {
                        ids += inputs[i].value;
                        j++;
                    } else {
                        ids += "," + inputs[i].value;
                    }
                }
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/job/deleteJobs",
                type:"get",
                data:{"ids":ids},
                dataType:"json",
                async:true,
                success:function (data) {
                    var pageInfo = data;
                    if(pageInfo.resFlag == 1){//删除成功
                        alert("删除任务已完成。");
                        window.location.href = "${pageContext.request.contextPath}/job/findJobsByPage";
                    }else {//删除失败
                        var errors = pageInfo.msgList;
                        var msg = "删除任务信息失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg+=i+"、"+errors[i]+"\n";
                        }
                        alert(msg);
                    }
                },
                error:function () {
                    alert("系统异常！")
                }
            });
        }
    }

    //点击添加模态框的添加按钮触发
    function sureAddJob() {
        if(confirm("确认任务信息无误后，添加？") == true){
            var params = $("#add_from").serialize();
            $.ajax({
                url:"${pageContext.request.contextPath}/job/addJob",
                type:"post",
                data:params,
                dataType:"json",
                async:true,
                success:function (data) {
                    var pageInfo = data;
                    if(pageInfo.resFlag == 1){//添加成功
                        window.location.href = "${pageContext.request.contextPath}/job/findJobsByPage";
                    }else {//添加失败
                        var errors = pageInfo.msgList;
                        var msg = "添加任务信息失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg+=i+"、"+errors[i]+"\n";
                        }
                        alert(msg);
                    }
                },
                error:function () {
                    alert("系统异常！")
                }
            });
        }
    }

    //点击添加后触发,获取job的id
    function getJobIdToAddModal(){
        $.ajax({
            url:"${pageContext.request.contextPath}/job/getJobIdToAddModal",
            type:"get",
            data:{},
            dataType:"text",
            async:true,
            success:function (data) {
                $("#addModal_input_jobId").attr("value",data);
            },
            error:function () {
                console.log("jobId获取失败")
            }
        });
    }

    //是否打开当前的服务
    function isOpenThisServer(x){
        var $x = $(x);
        if($x.prop("checked") == true){
            if(confirm("是否开启服务?") == true){
                var jobId = $x.attr("jobId");
                // alert(jobId)
                $.ajax({
                    url: "${pageContext.request.contextPath}/job/openServerInJobId",
                    type: "get",
                    data: {"jobId":jobId},
                    dataType: "text",
                    async: true,
                    success:function (data) {
                    },
                    error:function () {
                        alert("系统异常！")
                        $x.prop("checked",false);
                    }
                });
            }else{
                $x.prop("checked",false);
            }
        }else {
            if(confirm("是否终止服务?") == true){
                var jobId = $x.attr("jobId");
                // alert(jobId)
                $.ajax({
                    url: "${pageContext.request.contextPath}/job/closeServerInJobId",
                    type: "get",
                    data: {"jobId":jobId},
                    dataType: "text",
                    async: true,
                    success:function (data) {
                    },
                    error:function () {
                        alert("系统异常！")
                        $x.prop("checked",true);
                    }
                });
            }else {
                $x.prop("checked",true);
            }
        }
    }

    //ajax根据id查询到该页面
    function findJobByJobIdToUI(x) {
        var $x = $(x);
        var jobId = $x.attr("jobId");
        $.ajax({
            url: "${pageContext.request.contextPath}/job/findJobByJobId",
            type: "get",
            data: {"jobId": jobId},
            dataType: "json",
            async: true,
            success: function (data) {
                var job = data;
                var index = $x.attr("index");
                $("#xg_jobId_" + index).attr("value", job.jobId);
                $("#xg_jobName_" + index).attr("value", job.jobName);
                $("#xg_jobGroupName_" + index).attr("value", job.jobGroupName);
                $("#xg_jobClassName_" + index).attr("value", job.jobClassName);
                $("#xg_triggerName_" + index).attr("value", job.triggerName);
                $("#xg_triggerGroupName_" + index).attr("value", job.triggerGroupName);
                $("#xg_cronExpression_" + index).attr("value", job.cronExpression);
                $("#xg_createTime_" + index).attr("value", job.createTimeStr);
                $("#xg_updateTime_" + index).attr("value", job.updateTimeStr);
                if (job.jobStatus == 1) {
                    $("#xg_jobStatus_option1_" + index).attr("selected", "selected")
                } else {
                    $("#xg_jobStatus_option0_" + index).attr("selected", "selected")
                }
                $("#xg_jobStatus_" + index).attr("value", job.jobStatus);
                $("#xg_description_" + index)[0].innerText = job.description;
            },
            error: function () {
                alert("查询出错!")
            }
        });
    }

    //确认是否更新任务信息
    function sureUpdateJob(x){
        var index = $(x).attr("index");
        if(confirm("警告：是否确认修改任务信息？") == true){
            var params = $("#xg_from_"+index).serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/job/updateJobByJobId",
                type: "post",
                data: params,
                dataType: "json",
                async: true,
                success:function (data) {
                    var pageInfo = data;
                    if(pageInfo.resFlag == 1){//修改成功
                        window.location.href = "${pageContext.request.contextPath}/job/findJobsByPage?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}";
                    }else {//修改失败
                        var errors = pageInfo.msgList;
                        var msg = "修改任务信息失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg+=i+"、"+errors[i]+"\n";
                        }
                        alert(msg);
                    }
                },
                error:function () {
                    alert("系统异常！")
                }
            });
        }
    }

    $(document).ready(function () {
        //switch插件 js 默认关闭
        /*$(".switch").attr("checked",false);*/
// 选择框
        $(".select2").select2();

// WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
        // datetime picker
        $('.dateTimePicker').datetimepicker({
            format: "yyyy-mm-dd hh:ii",
            autoclose: true,
            todayBtn: true,
            language: 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }

    $(document).ready(function () {

// 激活导航位置
        setSidebarActive("admin-datalist");

// 列表按钮
        $("#dataList td input[name='ids']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
// 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[name='ids']").iCheck("uncheck");
            } else {
                $("#dataList td input[name='ids']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>
