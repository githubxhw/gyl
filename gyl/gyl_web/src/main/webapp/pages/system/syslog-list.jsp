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
    <title>日志列表</title>
    <meta name="description" content="AdminLTE2">
    <meta name="keywords" content="AdminLTE2">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

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
                系统管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">系统管理</a></li>
                <li class="active">访问日志</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">日志列表</h3>
                </div>

                <div class="box-body">
                    <!-- 数据表格 -->
                    <div class="table-box">
                        <%--日志信息查询--%>
                        <form id="form1" onsubmit="return checkForm1(this)"
                              action="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime" method="post">
                            <section class="content">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <div class="box-tools text-left">
                                            <button type="submit" class="btn bg-gray">内容搜索</button>
                                        </div>
                                    </div>
                                    <input hidden="hidden" type="text" value="ContectQuery" name="queryMethod"><%--指明查询方法:内容查询--%>
                                    <div class="row data-type">
                                        <div class="col-md-2 title">访问的用户名称</div>
                                        <div class="col-md-4 data">
                                            <input type="text" class="form-control" name="username"
                                                   placeholder="访问的用户名称" value="${log.username}">
                                        </div>
                                        <%--<div class="col-md-2 title">访问时间</div>
                                        <div class="col-md-4 data">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input type="text" class="form-control pull-right dateTimePicker" name="visit_time">
                                            </div>
                                        </div>--%>
                                        <div class="col-md-2 title">访问的用户设备的ip</div>
                                        <div class="col-md-4 data">
                                            <input type="text" class="form-control" name="ip"
                                                   placeholder="访问的用户设备的ip" value="${log.ip}">
                                        </div>
                                        <div class="col-md-2 title">访问的url</div>
                                        <div class="col-md-4 data">
                                            <input type="text" class="form-control" name="url"
                                                   placeholder="访问的url" value="${log.url}">
                                        </div>
                                        <div class="col-md-2 title">访问的方法</div>
                                        <div class="col-md-4 data">
                                            <input type="text" class="form-control" name="method"
                                                   placeholder="访问的方法" value="${log.method}">
                                        </div>
                                        <div class="col-md-2 title">访问该方法的执行时长</div>
                                        <div class="col-md-4 data">
                                            <input type="text" class="form-control" name="execution_time"
                                                   placeholder="客访问该方法的执行时长" value="${log.execution_time}">
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </form>
                        <%--指定时间段查询--%>
                        <form id="form2" onsubmit="return checkForm2(this)"
                              action="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime" method="post">
                            <section class="content">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <div class="box-tools text-left">
                                            <button id="query2" type="submit" class="btn bg-gray">时间段搜索</button>
                                        </div>
                                    </div>
                                    <input hidden="hidden" type="text" value="TimePeriodQuery" name="queryMethod"><%--指明查询方法:时间段搜索--%>
                                    <div class="row data-type">
                                        <div class="col-md-2 title">开始时间</div>
                                        <div class="col-md-4 data">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input value="${startTimeStr}" type="text"
                                                       class="form-control pull-right dateTimePicker"
                                                       name="startTime">
                                            </div>
                                        </div>
                                        <div class="col-md-2 title">结束时间</div>
                                        <div class="col-md-4 data">
                                            <div class="input-group date">
                                                <div class="input-group-addon">
                                                    <i class="fa fa-calendar"></i>
                                                </div>
                                                <input value="${endTimeStr}" type="text"
                                                       class="form-control pull-right dateTimePicker"
                                                       name="endTime">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </form>
                        <form id="form3" action="${pageContext.request.contextPath}/sysLog/deleteByIds" method="post">
                            <div style="overflow: scroll;overflow-y:scroll;height: 400px;width: 99%;">
                                <!--数据列表-->
                                <table id="dataList" class="table table-bordered table-striped table-hover dataTable"
                                       style="min-width:2100px;border:solid grey 1px">
                                    <thead>
                                    <tr>
                                        <th class="" style="padding-right:0px;">
                                            <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                        </th>
                                        <th class="sorting_asc">访问日志id</th>
                                        <th class="text-center sorting">访问的用户名称</th>
                                        <th class="text-center sorting">访问时间</th>
                                        <th class="text-center sorting">访问的用户设备的ip</th>
                                        <th class="text-center sorting">访问的url</th>
                                        <th class="text-center sorting">访问的方法</th>
                                        <th class="text-center sorting">访问该方法的执行时长</th>
                                        <th class="text-center">操作</th>
                                    </tr>
                                    </thead>

                                    <%--内容--%>
                                    <tbody>
                                    <c:forEach items="${pageInfo.list}" var="sysLog">
                                        <tr>
                                            <td><input name="ids" type="checkbox" value="${sysLog.id}"></td>
                                            <td>${sysLog.id}</td>
                                            <td>${sysLog.username}</td>
                                            <td>${sysLog.visit_timeStr}</td>
                                            <td>${sysLog.ip}</td>
                                            <td>${sysLog.url}</td>
                                            <td>${sysLog.method}</td>
                                            <td>${sysLog.execution_time}</td>
                                            <td class="text-center">
                                                <button type="button" class="btn bg-olive btn-xs"
                                                        onclick="location.href='${pageContext.request.contextPath}/sysLog/deleteById?id=${sysLog.id}'">
                                                    删除
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <%--工具栏--%>
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="submit" class="btn btn-default" title="删除"><i
                                                class="fa fa-trash-o"></i> 选中全部删除
                                        </button>
                                    </div>
                                </div>
                            </div>
                            <%--工具栏/--%>
                        </form>
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
                                <li>
                                    <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=1&pageSize=10"
                                       aria-label="Previous">首页</a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=${pageInfo.pageNum-1}&pageSize=10">上一页</a>
                                </li>

                                <c:if test="${pageInfo.pages <= 5}">
                                    <c:forEach begin="1" end="${pageInfo.pages}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=${index}&pageSize=10">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pageInfo.pages > 5 && pageInfo.pageNum+4 <= pageInfo.pages}">
                                    <c:forEach begin="${pageInfo.pageNum}" end="${pageInfo.pageNum+4}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=${index}&pageSize=10">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pageInfo.pages > 5 && pageInfo.pageNum+4 > pageInfo.pages}">
                                    <c:forEach begin="${pageInfo.pages-4}" end="${pageInfo.pages}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=${index}&pageSize=10">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>

                                <li>
                                    <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=${pageInfo.pageNum+1}&pageSize=10">下一页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=${queryMethod}&username=${log.username}&ip=${log.ip}&url=${log.url}&method=${log.method}&execution_Time=${log.execution_time}&startTime=${startTimeStr}&endTime=${endTimeStr}&pageNum=${pageInfo.pages}&pageSize=10"
                                       aria-label="Next">尾页</a></li>
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
    $(document).ready(function () {

// 选择框
        $(".select2").select2();

// WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
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
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
// 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });

    $(document).ready(function () {
        $('.dateTimePicker').datetimepicker({
            format: "yyyy-mm-dd hh:ii",
            autoclose: true,
            todayBtn: true,
            language: "zh-CN"
        });
    });

    //自定义函数
    function checkForm1(form1) {
        //验证form1是否可以提交:暂时省略 form1.name/.value == xx
        return true;
    }

    function checkForm2(form2) {
        //验证form2是否可以提交:暂时省略 form2.name/.value == xx
        return true;
    }

</script>
</body>

</html>
