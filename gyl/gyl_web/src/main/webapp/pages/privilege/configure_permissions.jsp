<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>权限详情</title>
    <meta name="description" content="AdminLTE">
    <meta name="keywords" content="AdminLTE">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- iCheck -->
    <!-- Morris chart -->
    <!-- jvectormap -->
    <!-- Date Picker -->
    <!-- Daterange picker -->
    <!-- Bootstrap time Picker -->
    <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--数据表格-->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- Bootstrap Color Picker -->
    <!-- bootstrap wysihtml5 - text editor -->
    <!--bootstrap-markdown-->
    <!-- Theme style -->
    <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
    <!-- Ion Slider -->
    <!-- ion slider Nice -->
    <!-- bootstrap slider -->
    <!-- bootstrap-datetimepicker -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!-- jQuery 2.2.3 -->
    <!-- jQuery UI 1.11.4 -->
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <!-- Bootstrap 3.3.6 -->
    <!-- Morris.js charts -->
    <!-- Sparkline -->
    <!-- jvectormap -->
    <!-- jQuery Knob Chart -->
    <!-- daterangepicker -->
    <!-- datepicker -->
    <!-- Bootstrap WYSIHTML5 -->
    <!-- Slimscroll -->
    <!-- FastClick -->
    <!-- iCheck -->
    <!-- AdminLTE App -->
    <!-- 表格树 -->
    <!-- select2 -->
    <!-- bootstrap color picker -->
    <!-- bootstrap time picker -->
    <!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
    <!-- Bootstrap WYSIHTML5 -->
    <!--bootstrap-markdown-->
    <!-- CK Editor -->
    <!-- InputMask -->
    <!-- DataTables -->
    <!-- ChartJS 1.0.1 -->
    <!-- FLOT CHARTS -->
    <!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
    <!-- FLOT PIE PLUGIN - also used to draw donut charts -->
    <!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
    <!-- jQuery Knob -->
    <!-- Sparkline -->
    <!-- Morris.js charts -->
    <!-- Ion Slider -->
    <!-- Bootstrap slider -->
    <!-- bootstrap-datetimepicker -->
    <!-- 页面meta /-->

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
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                权限管理
                <small>
                    角色名称为<span style="font-weight: bold">${role.role_name}</span>的权限设置
                </small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="${pageContext.request.contextPath}/user/findAll.do">权限管理</a></li>
                <li class="active">权限详情</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <div class="box-body">
                <form method="post" onsubmit="return sure(this)"
                      action="${pageContext.request.contextPath}/privilege/configPermission">
                    <input hidden="hidden" name="roleId" value="${role.id}">
                    <input hidden="hidden" name="ids" value="-1"><%--防止提交null数据而日志aop报错null--%>
                    <!--树表格-->
                    <div class="tab-pane" id="tab-treetable">
                        <table id="collapse-table" class="table table-bordered table-hover dataTable">
                            <thead>
                            <tr>
                                <th>
                                    <button type="submit" class="btn bg-gray">权限确认</button>
                                </th>
                            </tr>
                            </thead>

                            <tbody>
                            <%--首页登录权限--%><%--permissions--%>
                            <tr data-tt-id="login-0">
                                <td>首页</td>
                            </tr>
                            <tr data-tt-id="login-0-0" data-tt-parent-id="login-0">
                                <td>
                                    <input name="ids" type="checkbox" value="1"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 1}">checked="checked"</c:if>
                                    </c:forEach>>登录权限
                                </td>
                            </tr>

                            <%--基础数据模块--%>
                            <tr data-tt-id="1">
                                <td>基础数据</td>
                            </tr>
                            <tr data-tt-id="1-1" data-tt-parent-id="1">
                                <td>
                                    部门
                                </td>
                            </tr>
                            <tr data-tt-id="1-1-1" data-tt-parent-id="1-1">
                                <td>
                                    <input name="ids" type="checkbox" value="2"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 2}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-1-2" data-tt-parent-id="1-1">
                                <td>
                                    <input name="ids" type="checkbox" value="3"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 3}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-1-3" data-tt-parent-id="1-1">
                                <td>
                                    <input name="ids" type="checkbox" value="4"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 4}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-1-4" data-tt-parent-id="1-1">
                                <td>
                                    <input name="ids" type="checkbox" value="5"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 5}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-2" data-tt-parent-id="1">
                                <td>
                                    角色
                                </td>
                            </tr>
                            <tr data-tt-id="1-2-1" data-tt-parent-id="1-2">
                                <td>
                                    <input name="ids" type="checkbox" value="6"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 6}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-2-2" data-tt-parent-id="1-2">
                                <td>
                                    <input name="ids" type="checkbox" value="7"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 7}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-2-3" data-tt-parent-id="1-2">
                                <td>
                                    <input name="ids" type="checkbox" value="8"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 8}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-2-4" data-tt-parent-id="1-2">
                                <td>
                                    <input name="ids" type="checkbox" value="9"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 9}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-3" data-tt-parent-id="1">
                                <td>
                                    用户
                                </td>
                            </tr>
                            <tr data-tt-id="1-3-1" data-tt-parent-id="1-3">
                                <td>
                                    <input name="ids" type="checkbox" value="10"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 10}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-3-2" data-tt-parent-id="1-3">
                                <td>
                                    <input name="ids" type="checkbox" value="11"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 11}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-3-3" data-tt-parent-id="1-3">
                                <td>
                                    <input name="ids" type="checkbox" value="12"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 12}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-3-4" data-tt-parent-id="1-3">
                                <td>
                                    <input name="ids" type="checkbox" value="13"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 13}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-4" data-tt-parent-id="1">
                                <td>
                                    商品档案
                                </td>
                            </tr>
                            <tr data-tt-id="1-4-1" data-tt-parent-id="1-4">
                                <td>
                                    <input name="ids" type="checkbox" value="14"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 14}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-4-2" data-tt-parent-id="1-4">
                                <td>
                                    <input name="ids" type="checkbox" value="15"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 15}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-4-3" data-tt-parent-id="1-4">
                                <td>
                                    <input name="ids" type="checkbox" value="16"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 16}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-4-4" data-tt-parent-id="1-4">
                                <td>
                                    <input name="ids" type="checkbox" value="17"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 17}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-5" data-tt-parent-id="1">
                                <td>
                                    仓库
                                </td>
                            </tr>
                            <tr data-tt-id="1-5-1" data-tt-parent-id="1-5">
                                <td>
                                    <input name="ids" type="checkbox" value="18"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 18}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-5-2" data-tt-parent-id="1-5">
                                <td>
                                    <input name="ids" type="checkbox" value="19"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 19}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-5-3" data-tt-parent-id="1-5">
                                <td>
                                    <input name="ids" type="checkbox" value="20"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 20}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-5-4" data-tt-parent-id="1-5">
                                <td>
                                    <input name="ids" type="checkbox" value="21"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 21}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-6" data-tt-parent-id="1">
                                <td>
                                    供应商
                                </td>
                            </tr>
                            <tr data-tt-id="1-6-1" data-tt-parent-id="1-6">
                                <td>
                                    <input name="ids" type="checkbox" value="22"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 22}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-6-2" data-tt-parent-id="1-6">
                                <td>
                                    <input name="ids" type="checkbox" value="23"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 23}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-6-3" data-tt-parent-id="1-6">
                                <td>
                                    <input name="ids" type="checkbox" value="24"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 24}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-6-4" data-tt-parent-id="1-6">
                                <td>
                                    <input name="ids" type="checkbox" value="25"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 25}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-7" data-tt-parent-id="1">
                                <td>
                                    客户
                                </td>
                            </tr>
                            <tr data-tt-id="1-7-1" data-tt-parent-id="1-7">
                                <td>
                                    <input name="ids" type="checkbox" value="26"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 26}">checked="checked"</c:if>
                                    </c:forEach>>查询权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-7-2" data-tt-parent-id="1-7">
                                <td>
                                    <input name="ids" type="checkbox" value="27"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 27}">checked="checked"</c:if>
                                    </c:forEach>>修改权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-7-3" data-tt-parent-id="1-7">
                                <td>
                                    <input name="ids" type="checkbox" value="28"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 28}">checked="checked"</c:if>
                                    </c:forEach>>删除权限
                                </td>
                            </tr>
                            <tr data-tt-id="1-7-4" data-tt-parent-id="1-7">
                                <td>
                                    <input name="ids" type="checkbox" value="29"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 29}">checked="checked"</c:if>
                                    </c:forEach>>添加权限
                                </td>
                            </tr>

                            <%--业务模块--%>
                            <tr data-tt-id="2">
                                <td>业务</td>
                            </tr>
                            <%--start？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？--%>
                            <tr data-tt-id="2-1" data-tt-parent-id="2">
                                <td>采购管理</td>
                            </tr>
                            <tr data-tt-id="2-1-1" data-tt-parent-id="2-1">
                                <td>请购单管理</td>
                            </tr>
                            <tr data-tt-id="2-1-2" data-tt-parent-id="2-1">
                                <td>订单管理</td>
                            </tr>
                            <tr data-tt-id="2-1-3" data-tt-parent-id="2-1">
                                <td>到货单管理</td>
                            </tr>
                            <tr data-tt-id="2-1-4" data-tt-parent-id="2-1">
                                <td>入库单管理</td>
                            </tr>
                            <tr data-tt-id="2-1-5" data-tt-parent-id="2-1">
                                <td>发票单管理</td>
                            </tr>
                            <tr data-tt-id="2-2" data-tt-parent-id="2">
                                <td>库存管理</td>
                            </tr>
                            <tr data-tt-id="2-2-1" data-tt-parent-id="2-2">
                                <td>期初管理</td>
                            </tr>
                            <tr data-tt-id="2-2-2" data-tt-parent-id="2-2">
                                <td>盘点</td>
                            </tr>
                            <%--end？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？--%>
                            <tr data-tt-id="2-3" data-tt-parent-id="2">
                                <td>销售管理</td>
                            </tr>
                            <tr data-tt-id="2-3-1" data-tt-parent-id="2-3">
                                <td>预订单管理</td>
                            </tr>
                            <tr data-tt-id="2-3-1-1" data-tt-parent-id="2-3-1">
                                <td>
                                    <input name="ids" type="checkbox" value="30"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 30}">checked="checked"</c:if>
                                    </c:forEach>>查询
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-1-2" data-tt-parent-id="2-3-1">
                                <td>
                                    <input name="ids" type="checkbox" value="31"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 31}">checked="checked"</c:if>
                                    </c:forEach>>制单
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-1-3" data-tt-parent-id="2-3-1">
                                <td>
                                    <input name="ids" type="checkbox" value="32"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 32}">checked="checked"</c:if>
                                    </c:forEach>>修订
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-1-4" data-tt-parent-id="2-3-1">
                                <td>
                                    <input name="ids" type="checkbox" value="33"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 33}">checked="checked"</c:if>
                                    </c:forEach>>审批
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-2" data-tt-parent-id="2-3">
                                <td>订单管理</td>
                            </tr>
                            <tr data-tt-id="2-3-2-1" data-tt-parent-id="2-3-2">
                                <td>
                                    <input name="ids" type="checkbox" value="34"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 34}">checked="checked"</c:if>
                                    </c:forEach>>查询
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-2-2" data-tt-parent-id="2-3-2">
                                <td>
                                    <input name="ids" type="checkbox" value="35"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 35}">checked="checked"</c:if>
                                    </c:forEach>>制单
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-2-3" data-tt-parent-id="2-3-2">
                                <td>
                                    <input name="ids" type="checkbox" value="36"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 36}">checked="checked"</c:if>
                                    </c:forEach>>修订
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-2-4" data-tt-parent-id="2-3-2">
                                <td>
                                    <input name="ids" type="checkbox" value="37"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 37}">checked="checked"</c:if>
                                    </c:forEach>>审批
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-3" data-tt-parent-id="2-3">
                                <td>发货单管理</td>
                            </tr>
                            <tr data-tt-id="2-3-3-1" data-tt-parent-id="2-3-3">
                                <td>
                                    <input name="ids" type="checkbox" value="38"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 38}">checked="checked"</c:if>
                                    </c:forEach>>查询
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-3-2" data-tt-parent-id="2-3-3">
                                <td>
                                    <input name="ids" type="checkbox" value="39"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 39}">checked="checked"</c:if>
                                    </c:forEach>>制单
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-3-3" data-tt-parent-id="2-3-3">
                                <td>
                                    <input name="ids" type="checkbox" value="40"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 40}">checked="checked"</c:if>
                                    </c:forEach>>修订
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-3-4" data-tt-parent-id="2-3-3">
                                <td>
                                    <input name="ids" type="checkbox" value="41"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 41}">checked="checked"</c:if>
                                    </c:forEach>>审批
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-3-5" data-tt-parent-id="2-3-3">
                                <td>
                                    <input name="ids" type="checkbox" value="42"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 42}">checked="checked"</c:if>
                                    </c:forEach>>确认发货
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-4" data-tt-parent-id="2-3">
                                <td>出库单管理</td>
                            </tr>
                            <tr data-tt-id="2-3-4-1" data-tt-parent-id="2-3-4">
                                <td>
                                    <input name="ids" type="checkbox" value="43"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 43}">checked="checked"</c:if>
                                    </c:forEach>>查询
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-4-2" data-tt-parent-id="2-3-4">
                                <td>
                                    <input name="ids" type="checkbox" value="44"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 44}">checked="checked"</c:if>
                                    </c:forEach>>制单
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-4-3" data-tt-parent-id="2-3-4">
                                <td>
                                    <input name="ids" type="checkbox" value="45"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 45}">checked="checked"</c:if>
                                    </c:forEach>>修订
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-4-4" data-tt-parent-id="2-3-4">
                                <td>
                                    <input name="ids" type="checkbox" value="46"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 46}">checked="checked"</c:if>
                                    </c:forEach>>审批
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-4-5" data-tt-parent-id="2-3-4">
                                <td>
                                    <input name="ids" type="checkbox" value="47"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 47}">checked="checked"</c:if>
                                    </c:forEach>>确认出库
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-5" data-tt-parent-id="2-3">
                                <td>开票单管理</td>
                            </tr>
                            <tr data-tt-id="2-3-5-1" data-tt-parent-id="2-3-5">
                                <td>
                                    <input name="ids" type="checkbox" value="48"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 48}">checked="checked"</c:if>
                                    </c:forEach>>查询
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-5-2" data-tt-parent-id="2-3-5">
                                <td>
                                    <input name="ids" type="checkbox" value="49"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 49}">checked="checked"</c:if>
                                    </c:forEach>>制单
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-5-3" data-tt-parent-id="2-3-5">
                                <td>
                                    <input name="ids" type="checkbox" value="50"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 50}">checked="checked"</c:if>
                                    </c:forEach>>修订
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-5-4" data-tt-parent-id="2-3-5">
                                <td>
                                    <input name="ids" type="checkbox" value="51"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 51}">checked="checked"</c:if>
                                    </c:forEach>>审批
                                </td>
                            </tr>
                            <tr data-tt-id="2-3-5-5" data-tt-parent-id="2-3-5">
                                <td>
                                    <input name="ids" type="checkbox" value="52"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 52}">checked="checked"</c:if>
                                    </c:forEach>>确认开票
                                </td>
                            </tr>
                            <%--start？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？--%>
                            <tr data-tt-id="2-4" data-tt-parent-id="2">
                                <td>应收应付管理</td>
                            </tr>
                            <tr data-tt-id="2-4-1" data-tt-parent-id="2-4">
                                <td>采购应付单管理</td>
                            </tr>
                            <tr data-tt-id="2-4-1" data-tt-parent-id="2-4">
                                <td>销售应收单管理</td>
                            </tr>
                            <tr data-tt-id="2-5" data-tt-parent-id="2">
                                <td>预警管理</td>
                            </tr>
                            <tr data-tt-id="2-5-1" data-tt-parent-id="2-5">
                                <td>采购入库预警</td>
                            </tr>
                            <tr data-tt-id="2-5-1" data-tt-parent-id="2-5">
                                <td>销售发货预警</td>
                            </tr>
                            <tr data-tt-id="2-5-1" data-tt-parent-id="2-5">
                                <td>销售出库预警</td>
                            </tr>
                            <%--end？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？--%>


                            <%--权限管理模块--%>
                            <tr data-tt-id="3">
                                <td>权限管理</td>
                            </tr>
                            <tr data-tt-id="3-1" data-tt-parent-id="3">
                                <td>
                                    <input name="ids" type="checkbox" value="53"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 53}">checked="checked"</c:if>
                                    </c:forEach>>角色配置权限
                                </td>
                            </tr>
                            <tr data-tt-id="3-2" data-tt-parent-id="3">
                                <td>
                                    <input name="ids" type="checkbox" value="54"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 54}">checked="checked"</c:if>
                                    </c:forEach>>资源权限
                                </td>
                            </tr>

                            <%--系统管理模块--%>
                            <tr data-tt-id="4">
                                <td>系统管理</td>
                            </tr>
                            <tr data-tt-id="4-1" data-tt-parent-id="4">
                                <td>
                                    <input name="ids" type="checkbox" value="55"
                                    <c:forEach var="permission" items="${permissions}">
                                           <c:if test="${permission.id == 55}">checked="checked"</c:if>
                                    </c:forEach>>访问日志
                                </td>
                            </tr>

                            </tbody>
                            <%--<tr data-tt-id="0">
                                <td colspan="2">${user.username}</td>
                            </tr>
                            <tbody>
                            <c:forEach items="${user.roles}" var="role" varStatus="vs">
                                <tr data-tt-id="${vs.index+1}" data-tt-parent-id="0">
                                    <td>${role.roleName}</td>
                                    <td>${role.roleDesc}</td>
                                </tr>
                                <c:forEach items="${role.permissions}" var="p">
                                    <tr data-tt-id="1-1" data-tt-parent-id="${vs.index+1}">
                                        <td>${p.permissionName}</td>
                                        <td>${p.url}</td>
                                    </tr>
                                </c:forEach>
                            </c:forEach>
                            </tbody>--%>
                        </table>
                    </div>
                    <!--树表格/-->

                </form>
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

        // 颜色选取器
        $(".my-colorpicker1").colorpicker();
        $(".my-colorpicker2").colorpicker();

    });


    $(document).ready(function () {
        // 选择框
        $(".select2").select2();
    });


    $(document).ready(function () {

        //Date picker
        $('#datepicker').datepicker({
            autoclose: true,
            language: 'zh-CN'
        });

        // datetime picker
        $('#dateTimePicker').datetimepicker({
            format: "mm/dd/yyyy - hh:ii",
            autoclose: true,
            todayBtn: true,
            language: 'zh-CN'
        });

        //Date range picker
        $('#reservation').daterangepicker({
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel: '起始时间',
                toLabel: '结束时间',
                customRangeLabel: '自定义',
                firstDay: 1
            },
            opens: 'left', // 日期选择框的弹出位置
            separator: ' 至 '
            //showWeekNumbers : true,     // 是否显示第几周
        });

        //Date range picker with time picker
        $('#reservationtime').daterangepicker({
            timePicker: true,
            timePickerIncrement: 30,
            format: 'MM/DD/YYYY h:mm A',
            locale: {
                applyLabel: '确认',
                cancelLabel: '取消',
                fromLabel: '起始时间',
                toLabel: '结束时间',
                customRangeLabel: '自定义',
                firstDay: 1
            },
            opens: 'right', // 日期选择框的弹出位置
            separator: ' 至 '
        });

        //Date range as a button
        $('#daterange-btn').daterangepicker({
                locale: {
                    applyLabel: '确认',
                    cancelLabel: '取消',
                    fromLabel: '起始时间',
                    toLabel: '结束时间',
                    customRangeLabel: '自定义',
                    firstDay: 1
                },
                opens: 'right', // 日期选择框的弹出位置
                separator: ' 至 ',
                ranges: {
                    '今日': [moment(), moment()],
                    '昨日': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                    '最近7日': [moment().subtract(6, 'days'), moment()],
                    '最近30日': [moment().subtract(29, 'days'), moment()],
                    '本月': [moment().startOf('month'), moment().endOf('month')],
                    '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                },
                startDate: moment().subtract(29, 'days'),
                endDate: moment()
            },
            function (start, end) {
                $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
            }
        );

    });


    $(document).ready(function () {

        /*table tree*/
        $("#collapse-table").treetable({
            expandable: true
        });

    });


    $(document).ready(function () {

        CKEDITOR.replace('editor1');

        // $(".textarea").wysihtml5({
        //     locale:'zh-CN'
        // });

        $("#markdown-textarea").markdown({
            language: 'zh',
            autofocus: false,
            savable: false
        });

    });


    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("admin-dataform");

    });

    function sure(form) {
        var msg = "是否确认修改为当前所勾选的权限?";
        if (confirm(msg) == true) {
            return true;
        }
        return false;
    }
</script>
</body>
</html>
