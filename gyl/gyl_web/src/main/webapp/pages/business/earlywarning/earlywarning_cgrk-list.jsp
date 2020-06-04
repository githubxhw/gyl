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
    <title>采购入库预警列表</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">

</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="../../../header.jsp"/>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="../../../aside.jsp"/>

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                采购入库预警管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">业务</a></li>
                <li class="active">采购入库预警</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">预警列表</h3>
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
                        <form id="findEWCform" action="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByDjhOrHH">
                            <div class="box-tools pull-right">
                                <div class="has-feedback form-group form-inline">
                                    <input type="text"   name="djh" class="form-control input-sm" placeholder="采购单据号">
                                    <input type="text" id="hh" name="hh" class="form-control input-sm" placeholder="行号">
                                    <button type="submit" onclick=""
                                            class="btn btn-group-sm">搜索
                                    </button>
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
                                <th class="text-center sorting">采购单据号</th>
                                <th class="text-center sorting">行号</th>
                                <th class="text-center sorting">商品编号</th>
                                <th class="text-center sorting">商品名称</th>
                                <th class="text-center sorting">要求到货日期</th>
                                <th class="text-center sorting">提前预警天数</th>
                                <th class="text-center sorting">到期预警天数</th>
                                <th class="text-center sorting">预警状态</th>
                                <th class="text-center">操作</th>
                            </tr>
                            </thead>

                            <%--内容--%>
                            <tbody>
                            <c:forEach items="${pageInfo.list}" var="earlyWarning_Cgrk" varStatus="status">
                                <tr>
                                    <td><input name="ids" type="checkbox" value="${earlyWarning_Cgrk.id}"></td>
                                    <td>${earlyWarning_Cgrk.id}</td>
                                    <td>${earlyWarning_Cgrk.djh}</td>
                                    <td>${earlyWarning_Cgrk.hh}</td>
                                    <td>${earlyWarning_Cgrk.productNum}</td>
                                    <td>${earlyWarning_Cgrk.productName}</td>
                                    <td>${earlyWarning_Cgrk.yqdhrqStr}</td>
                                    <td>${earlyWarning_Cgrk.checkDays}</td>
                                    <td>${earlyWarning_Cgrk.invalidDays}</td>
                                    <c:if test="${earlyWarning_Cgrk.status == 1}">
                                        <td style="text-align: center;color: green;font-weight: bold">
                                            预警
                                        </td>
                                    </c:if>
                                    <c:if test="${earlyWarning_Cgrk.status == 0}">
                                        <td style="text-align: center;color:red;font-weight: bold">
                                            未预警
                                        </td>
                                    </c:if>
                                    <td class="text-center">
                                        <button index="${status.index}" EWCid="${earlyWarning_Cgrk.id}" type="button"
                                                class="btn bg-olive btn-xs"
                                                data-toggle="modal"
                                                data-target="#earlyWarning_Cgrk_xg_myModal_${status.index}"
                                                onclick="findEWCByIdToXg_Modal(this);">
                                            修改
                                        </button>
                                        <!--模态窗口-->
                                        <div id="earlyWarning_Cgrk_xg_myModal_${status.index}"
                                             class="modal modal-primary" role="dialog">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal"
                                                                aria-label="Close">
                                                            <span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title">预警信息修改</h4>
                                                    </div>
                                                    <form id="xg_from_${status.index}">
                                                        <div class="modal-body">
                                                            <div class="box-body">
                                                                <div class="form-horizontal">
                                                                    <table style="font-weight: lighter;height:100%;width:100%;text-align: center;border-collapse:separate; border-spacing:0px 10px;">
                                                                        <tr>
                                                                            <td style="text-align: left">ID:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_id_${status.index}"
                                                                                       name="id"
                                                                                       style="" readonly="readonly"
                                                                                       type="text">
                                                                                <input hidden="hidden" value="${status.index}" id="put1">
                                                                            </td>

                                                                            <td style="text-align: left">采购单据号:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_djh_${status.index}"
                                                                                       name="djh"
                                                                                       type="text" onblur="CheckDjh(this)">
                                                                            </td>
                                                                            <td style="text-align: left">行号:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_hh_${status.index}"
                                                                                       name="hh"
                                                                                       type="text" onblur="CheckHh(this)">
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left">商品编号:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_productNum_${status.index}"
                                                                                       readonly = "readonly"
                                                                                       name="productNum"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">商品名称:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_productName_${status.index}"
                                                                                       readonly = "readonly"
                                                                                       name="productName"
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">要求到货日期:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_yqdhrq_${status.index}"
                                                                                       readonly = "readonly"
                                                                                       name="yqdhrq"
                                                                                       class="form-control pull-right dateTimePicker"
                                                                                       type="text">
                                                                            </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td style="text-align: left">提前预警天数:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_checkDays_${status.index}"
                                                                                       name="checkDays"
                                                                                       style=""
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">到期预警天数:</td>
                                                                            <td style="text-align: left">
                                                                                <input id="xg_invalidDays_${status.index}"
                                                                                       name="invalidDays"
                                                                                       style=""
                                                                                       type="text">
                                                                            </td>
                                                                            <td style="text-align: left">预警状态:</td>
                                                                            <td style="text-align: left">
                                                                                <select name="status">
                                                                                    <option id="xg_status_option1_${status.index}"
                                                                                            style="color: green"
                                                                                            value="1">预警
                                                                                    </option>
                                                                                    <option id="xg_status_option0_${status.index}"
                                                                                            style="color: red"
                                                                                            value="0">未预警
                                                                                    </option>
                                                                                </select>
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
                                                                    index="${status.index}"
                                                                    onclick="sureUpdate(this);"
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
                                    <button type="button" class="btn btn-default" title="添加" data-toggle="modal"
                                            data-target="#add_myModal"
                                            onclick="getEWCIdToUI();">
                                        <i
                                                class="fa fa-file-o"></i> +
                                    </button>
                                    <!--模态窗口-->
                                    <div id="add_myModal" class="modal modal-primary" role="dialog">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="close" data-dismiss="modal"
                                                            aria-label="Close">
                                                        <span aria-hidden="true">&times;</span></button>
                                                    <h4 class="modal-title">预警信息添加</h4>
                                                </div>
                                                <form id="add_from" method="post">
                                                    <div class="modal-body">
                                                        <div class="box-body">
                                                            <div class="form-horizontal">
                                                                <table style="font-weight: lighter;height:100%;width:100%;text-align: center;border-collapse:separate; border-spacing:0px 10px;">
                                                                    <tr>
                                                                        <td style="text-align: left">ID:</td>
                                                                        <td style="text-align: left">
                                                                            <input id="addModal_input_id" name="id"
                                                                                   style="" readonly="readonly"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">采购单据号:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="djh"
                                                                                   id="djh"
                                                                                   type="text"
                                                                            onblur="CheckDjh(this)">
                                                                        </td>
                                                                        <td style="text-align: left">行号:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="hh"
                                                                                   type="text"
                                                                            onblur="CheckHh2(this)">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: left">商品编号:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="productNum"
                                                                                   readonly = "readonly"
                                                                                   id="productNum"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">商品名称:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="productName"
                                                                                   readonly = "readonly"
                                                                                   id="productName"
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">要求发货日期:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="yqdhrq"
                                                                                   readonly = "readonly"
                                                                                   id="yqdhrq"
                                                                                   class="form-control pull-right dateTimePicker"
                                                                                   type="text">
                                                                        </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td style="text-align: left">提前预警天数:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="checkDays"
                                                                                   style=""
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">到期预警天数:</td>
                                                                        <td style="text-align: left">
                                                                            <input name="invalidDays"
                                                                                   style=""
                                                                                   type="text">
                                                                        </td>
                                                                        <td style="text-align: left">预警状态:</td>
                                                                        <td style="text-align: left">
                                                                            <select name="status">
                                                                                <option selected="selected"
                                                                                        style="color: green"
                                                                                        value="1">预警
                                                                                </option>
                                                                                <option style="color: red"
                                                                                        value="0">未预警
                                                                                </option>
                                                                            </select>
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
                                                                onclick="sureAdd();"
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
                                    <button onclick="sureDelete();" type="button" class="btn btn-default" title="删除"><i
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
                                <li><a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=1&pageSize=6"
                                       aria-label="Previous">首页</a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${pageInfo.pageNum-1}&pageSize=6">上一页</a>
                                </li>

                                <c:if test="${pageInfo.pages <= 5}">
                                    <c:forEach begin="1" end="${pageInfo.pages}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${index}&pageSize=6">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pageInfo.pages > 5 && pageInfo.pageNum+4 <= pageInfo.pages}">
                                    <c:forEach begin="${pageInfo.pageNum}" end="${pageInfo.pageNum+4}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${index}&pageSize=6">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${pageInfo.pages > 5 && pageInfo.pageNum+4 > pageInfo.pages}">
                                    <c:forEach begin="${pageInfo.pages-4}" end="${pageInfo.pages}" var="index">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${index}&pageSize=6">${index}</a>
                                        </li>
                                    </c:forEach>
                                </c:if>
                                <li>
                                    <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${pageInfo.pageNum+1}&pageSize=6">下一页</a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${pageInfo.pages}&pageSize=6"
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
    <jsp:include page="../../../footer.jsp"/>

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
<script src="${pageContext.request.contextPath}/js/myjs/datacheck.js"></script>
<script>


    //格式化Data
    function FormatTime(nowD) {
        if (!nowD) {
            return "";
        }
// 日期过滤
        if(typeof nowD === 'string'){
            nowD = DateFilter(nowD);
        }
        nowD = new Date(nowD);
        let YY = nowD.getFullYear(),
            MM = nowD.getMonth() + 1,
            DD = nowD.getDate(),
            hh = nowD.getHours(),
            mm = nowD.getMinutes(),
            ss = nowD.getSeconds();
        return YY+"-"+MM+"-"+DD+" "+hh+":"+mm;
        // return {
        //
        // YY: YY,
        // MM: ("00" + MM).substr(("" + MM).length),
        // DD: ("00" + DD).substr(("" + DD).length),
        // hh: ("00" + hh).substr(("" + hh).length),
        // mm: ("00" + mm).substr(("" + mm).length),
        // ss: ("00" + ss).substr(("" + ss).length)
        // };
    }

    function CheckDjh(x) {
        var djh = $(x).val();
        $.ajax({
            url:"${pageContext.request.contextPath}/earlyWarning_Cgrk/CheckDjh",
            type:"get",
            data:{"djh":djh},
            dataType:"json",
            async:true,
            success: function (data) {
                var pageInfo = data;
                if (pageInfo.resFlag == "1") {
                } else {
                    var errors = pageInfo.msgList;
                    var msg = "单据号出现失败:\n";
                    for (var i = 0; i < errors.length; i++) {
                        msg += i + "、" + errors[i] + "\n";
                    }
                    $(x).val("");
                    alert(msg);

                }
            }
        });

    }

    function CheckHh(x) {
        var i = $("#put1").val();
        var hh = $(x).val();
        var djh = $("#xg_djh_" + i).val();
        if (djh === " "){
            alert("请输入单据号");
        }else{
            $.ajax({
                url:"${pageContext.request.contextPath}/earlyWarning_Cgrk/CheckHh",
                type:"get",
                data:{"hh":hh,"djh":djh},
                dataType:"json",
                async:true,
                success: function (data) {
                    var pageInfo = data;
                    if (pageInfo.resFlag == "1") {
                        put1(djh,hh);
                    } else {
                        var errors = pageInfo.msgList;
                        var msg = "行号出现失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg += i + ": " + errors[i] + "\n";
                        }
                        $(x).val("");
                        alert(msg);

                    }
                }
            });
        }


    }

    function CheckHh2(x) {

        var hh = $(x).val();
        var djh = $("#djh").val();
        if (djh === " "){
            alert("请输入单据号");
        }else{
            $.ajax({
                url:"${pageContext.request.contextPath}/earlyWarning_Cgrk/CheckHh",
                type:"get",
                data:{"hh":hh,"djh":djh},
                dataType:"json",
                async:true,
                success: function (data) {
                    var pageInfo = data;
                    if (pageInfo.resFlag == "1") {
                        put2(djh,hh);
                    } else {
                        var errors = pageInfo.msgList;
                        var msg = "行号出现失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg += i + ": " + errors[i] + "\n";
                        }
                        $(x).val("");
                        alert(msg);

                    }
                }
            });
        }


    }
    function put1(x,y) {
        $.ajax({
            url:"${pageContext.request.contextPath}/earlyWarning_Cgrk/PutValue",
            type:"get",
            data:{"djh":x,"hh":y},
            dataType:"json",
            async:true,
            success: function (data) {
                var Cgdd = data;
                if (Cgdd != null){
                    var i = $("#put1").val();
                    $("#xg_productNum_" + i).attr("value", Cgdd.spbm);
                    $("#xg_productName_" + i).attr("value", Cgdd.spmc);
                    $("#xg_yqdhrq_" + i).attr("value", FormatTime(Cgdd.yqshrq));
                }
            }
        })
    }

    function put2(x,y) {
        $.ajax({
            url:"${pageContext.request.contextPath}/earlyWarning_Cgrk/PutValue",
            type:"get",
            data:{"djh":x,"hh":y},
            dataType:"json",
            async:true,
            success: function (data) {
                var Cgdd = data;
                if (Cgdd != null){
                    $("#productNum").attr("value", Cgdd.spbm);
                    $("#productName").attr("value", Cgdd.spmc);
                    $("#yqdhrq").attr("value", FormatTime(Cgdd.yqshrq));
                }
            }
        })
    }
    //点击列表中修改按钮触发，根据id查询预警信息到修改modal
    function findEWCByIdToXg_Modal(x) {
        var $x = $(x);
        var index = $x.attr("index");
        var id = $x.attr("EWCid");
        $.ajax({
            url: "${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgById",
            type: "get",
            data: {"id": id},
            dataType: "json",
            async: true,
            success: function (data) {
                var earlyWarning_Cgrk = data;
                $("#xg_id_" + index).attr("value", earlyWarning_Cgrk.id);
                $("#xg_djh_" + index).attr("value", earlyWarning_Cgrk.djh);
                $("#xg_hh_" + index).attr("value", earlyWarning_Cgrk.hh);
                $("#xg_productNum_" + index).attr("value", earlyWarning_Cgrk.productNum);
                $("#xg_productName_" + index).attr("value", earlyWarning_Cgrk.productName);
                $("#xg_yqdhrq_" + index).attr("value", earlyWarning_Cgrk.yqdhrqStr);
                $("#xg_checkDays_" + index).attr("value", earlyWarning_Cgrk.checkDays);
                $("#xg_invalidDays_" + index).attr("value", earlyWarning_Cgrk.invalidDays);
                if (earlyWarning_Cgrk.status == 1) {
                    $("#xg_status_option1_" + index).attr("selected", "selected");
                } else {
                    $("#xg_status_option0_" + index).attr("selected", "selected");
                }
            },
            error: function () {
            }
        });
    }

    //点击修改模态框中的修改按钮触发
    function sureUpdate(x) {
        var $x = $(x);
        var index = $x.attr("index");
        if (confirm("确认修改?") == true) {
            //验证数据后
            //ajax请求修改
            var params = $("#xg_from_" + index).serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/earlyWarning_Cgrk/UpdateEWCg",
                type: "post",
                data: params,
                dataType: "json",
                async: true,
                success: function (data) {
                    var pageInfo = data;
                    if (pageInfo.resFlag == "1") {//修改成功
                        window.location.href = "${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}";
                    } else {//修改失败
                        var errors = pageInfo.msgList;
                        var msg = "修改预警信息失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg += i + "、" + errors[i] + "\n";
                        }
                        alert(msg);
                    }
                },
                error: function () {
                    alert("系统异常！")
                }
            });
        }
    }

    //点击添加模态框触发，查询最大id+1
    function getEWCIdToUI() {
        $.ajax({
            url: "${pageContext.request.contextPath}/earlyWarning_Cgrk/getEWCIdToUI",
            type: "get",
            data: {},
            dataType: "text",
            async: true,
            success: function (data) {
                $("#addModal_input_id").attr("value", data);
            },
            error: function () {
            }
        });
    }

    //点击添加模态框中的添加按钮触发
    function sureAdd() {
        if (confirm("确认无误后添加？") == true) {
            //js验证操作后
            var params = $("#add_from").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/earlyWarning_Cgrk/SaveEWC",
                type: "post",
                data: params,
                dataType: "json",
                async: true,
                success: function (data) {
                    var pageInfo = data;
                    if (pageInfo.resFlag == "1") {//修改成功
                        window.location.href = "${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}";
                    } else {//修改失败
                        var errors = pageInfo.msgList;
                        var msg = "添加预警信息失败:\n";
                        for (var i = 0; i < errors.length; i++) {
                            msg += i + "、" + errors[i] + "\n";
                        }
                        alert(msg);
                    }
                },
                error: function () {
                    alert("系统错误!")
                }
            });
        }
    }

    //点击删除按钮触发，删除预警消息
    function sureDelete(){
        if(confirm("是否删除选中的预警消息？") == true){
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
            if(ids.length == 0){
                alert("无要删除的选项。")
            }else {
                $.ajax({
                    url:"${pageContext.request.contextPath}/earlyWarning_Cgrk/deleteEWCgByIds",
                    type:"get",
                    data:{"ids":ids},
                    dataType:"text",
                    async:true,
                    success:function (data) {
                        alert("删除预警消息已完成。");
                        window.location.href = "${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage?pageNum=${pageInfo.pageNum}&pageSize=${pageInfo.pageSize}";
                    },
                    error:function () {
                        alert("系统异常！")
                    }
                });
            }
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

