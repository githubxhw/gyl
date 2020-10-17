<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: XHW
  Date: 2020/2/17
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>应付单修订</title>
    <meta name="description" content="AdminLTE">
    <meta name="keywords" content="AdminLTE">

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
          name="viewport">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">
<div class="wrapper">
    <!-- 页面头部 -->
    <jsp:include page="../../header.jsp"/>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="../../aside.jsp"/>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">
        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                应付单-修订
            </h1>
            <ol class="breadcrumb">
                <li>
                    <a href="${pageContext.request.contextPath}/index.jsp">
                        <i class="fa fa-dashboard"></i> 首页
                    </a>
                </li>
                <li>
                    <a href="#">业务</a>
                </li>
                <li>
                    <a href="#">应付应付管理</a>
                </li>
                <li>
                    <a href="#">应付单管理</a>
                </li>
                <li class="active">修订</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <%--查询部分--%>
        <%-- id = query 按钮查询--%>
        <form id="form" method="post">
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                        <%--1--%>
                            <div class="panel-heading">查询(所有)</div>
                            <div class="row data-type">
                                <%--1--%>
                                <div class="col-md-2 title">ID</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="cgyfd_zhu_id"
                                           placeholder="应付单ID" value="">
                                </div>
                                <%--2--%>
                                <div class="col-md-2 title">公司</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="gs"
                                           placeholder="公司" value="">
                                </div>
                                <div class="col-md-2 title">订单号</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="djh"
                                           placeholder="订单号" value="">
                                </div>
                                <%--3--%>
                                <div class="col-md-2 title">日期</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right dateTimePicker" name="rq">
                                    </div>
                                </div>
                                <div class="col-md-2 title">起算日期</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right dateTimePicker" name="qsrq">
                                    </div>
                                </div>
                                <div class="col-md-2 title">客商</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="ks"
                                           placeholder="客商" value="">
                                </div>

                                <div class="col-md-2 title">部门</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="bm"
                                           placeholder="部门" value="">
                                </div>
                                <div class="col-md-2 title">业务员</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="ywy"
                                           placeholder="业务员" value="">
                                </div>
                                <div class="col-md-2 title">生效标志</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="sxbz">
                                        <option selected="selected" value="-1">全部</option>
                                        <option value="1">生效</option>
                                        <option value="0">没生效</option>
                                    </select>
                                </div>

                                <%--4--%>

                                <div class="col-md-2 title">审核人</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="spr"
                                           placeholder="审核人" value="">
                                </div>
                                <div class="col-md-2 title">审核日期</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right dateTimePicker" name="spsj">
                                    </div>
                                </div>

                                <%--5--%>
                                <div class="col-md-2 title">制单人</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="zdr"
                                           placeholder="制单人" value="">
                                </div>
                                <div class="col-md-2 title">制单日期</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right dateTimePicker" name="zdsj">
                                    </div>
                                </div>
                                <%--6--%>
                                <div class="col-md-2 title">修改人</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="xgr"
                                           placeholder="修改人" value="">
                                </div>
                                <div class="col-md-2 title">修改日期</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right dateTimePicker" name="xgsj">
                                    </div>
                                </div>
                                <div class="col-md-2 title">签字人</div>
                                <div class="col-md-4 data">
                                    <input type="text" class="form-control" name="qzr"
                                           placeholder="签字人" value="">
                                </div>
                                <div class="col-md-2 title">签字日期</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right dateTimePicker" name="qzsj">
                                    </div>
                                </div>
                            </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools <%--text-center --%>text-right">
                    <button id="query" type="button" class="btn <%--bg-maroon--%> bg-red">索搜</button>
                    <button type="reset" class="btn bg-orange">重置</button>
                    <button type="button" class="btn bg-yellow"
                            onclick="history.back(-1);">返回
                    </button>
                </div>
             </section>
        </form>

        <!--数据列表-->
        <%-- 1：主表--%>
        <from><%--提交ids--%>
            <div style="padding-left: 20px"><h4><%--主表--%></h4></div>
            <div style="overflow: scroll;overflow-y:scroll;height: 200px;width: 99%;">
                <table id="dataList_zhu" class="table table-bordered table-striped table-hover dataTable"
                       style="min-width:2450px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zhu" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" style="width: 150px">订单号</th>
                    <th class="text-center sorting" style="width: 150px">公司</th>
                    <th class="text-center sorting" style="width: 150px">日期</th>
                    <th class="text-center sorting" style="width: 150px">起算日期</th>
                    <th class="text-center sorting" style="width: 150px">客商</th>
                    <th class="text-center sorting" style="width: 150px">部门</th>
                    <th class="text-center sorting" style="width: 150px">业务员</th>
                    <th class="text-center sorting" style="width: 150px">生效标志</th>
                    <th class="text-center sorting" style="width: 150px">制单人</th>
                    <th class="text-center sorting" style="width: 150px">制单日期</th>
                    <th class="text-center sorting" style="width: 150px">审核人</th>
                    <th class="text-center sorting" style="width: 150px">审核日期</th>
                    <th class="text-center sorting" style="width: 150px">修改人</th>
                    <th class="text-center sorting" style="width: 150px">修改日期</th>
                    <th class="text-center sorting" style="width: 150px">签字人</th>
                    <th class="text-center sorting" style="width: 150px">签字日期</th>
                    <th class="text-center" style="width: 150px">操作</th>
                    </thead>
                    <%--内容--%>
                    <tbody id="zhub_tbody">
                    </tbody>
                </table>
            </div>
            <%--工具栏--%>
            <div class="pull-left">
                <div class="form-group form-inline">
                    <div class="btn-group">
                        <button onclick="deleteZhubByIds(this)" type="button" class="btn btn-default" title="删除"><i
                                class="fa fa-trash-o"></i> 删除
                        </button>
                    </div>
                    <span id="zhub_count" count="">共 0 条记录</span>
                </div>
            </div>
            <%--工具栏/--%>
        </from>
        <br><br><br><br>
        <div class="form-group">
            <input id="djh" class="form-control" type="text" readonly="readonly" style="width: 17%;"
                   placeholder="双击已查询的单据号进行选择" value="">
        </div>
        <%--2：子表--%>
        <from id="zib_form" zhu_id="-1">
            <div style="padding-left: 20px;"><h4><%--子表--%></h4></div>
            <div style="overflow: scroll;overflow-y:scroll;height: 300px;width: 99%;">
                <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                       style="min-width:2150px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zi" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" width="150px">行号</th>
                    <th class="text-center sorting" width="150px">数量</th>
                    <th class="text-center sorting" width="150px">商品名称</th>
                    <th class="text-center sorting" width="150px">商品编码</th>
                    <th class="text-center sorting" width="150px">单位</th>
                    <th class="text-center sorting" width="150px">含税金额</th>
                    <th class="text-center sorting" width="150px">税额</th>
                    <th class="text-center sorting" width="150px">无税金额</th>
                    <th class="text-center sorting" width="150px">来源单据号</th>
                    <th class="text-center sorting" width="150px">来源行号</th>
                    <th class="text-center sorting" width="150px">源头单据号</th>
                    <th class="text-center sorting" width="150px">源头行号</th>
                    <th class="text-center sorting" width="150px">单价</th>
                    <th class="text-center sorting" width="150px">累计应付数量</th>
                    <th class="text-center sorting" width="150px">应付是否结束</th>
                    <th class="text-center" width="150px">操作</th>
                    </thead>
                    <%--内容--%>
                    <tbody id="zib_tbody">
                    </tbody>
                </table>
            </div>
            <%--工具栏--%>
            <div class="pull-left">
                <div class="form-group form-inline">
                    <div class="btn-group">
                        <button id="get_zib_hh" type="button" class="btn btn-default" data-toggle="modal"
                                data-target="#myModal_1"
                                title="添加">
                            <i class="fa fa-file-o"></i> 添加
                        </button>
                        <%--模拟窗口--%>
                        <div id="myModal_1" class="modal modal-primary" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title">添加应付单子单</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="box-body">
                                            <div class="form-horizontal">
                                                <%--子表添加--%>
                                                <form id="zib_save_form" method="post">
                                                    <!-- 正文区域 -->
                                                    <section class="content"> <!--产品信息-->

                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">盘点单子单</div>
                                                            <div class="row data-type">
                                                                <div class="col-md-2 title">行号</div>
                                                                <div class="col-md-4 data">
                                                                    <input id="zibhh" type="text" readonly="readonly"
                                                                           class="form-control" name="hh"
                                                                           placeholder="行号" value="">
                                                                </div>
                                                                <div class="col-md-2 title">数量</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="sl"
                                                                           placeholder="数量" value="">
                                                                </div>
                                                                <div class="col-md-2 title">商品名称</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="spmc"
                                                                           placeholder="商品名称" value="">
                                                                </div>
                                                                <div class="col-md-2 title">商品编码</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="spbm"
                                                                           placeholder="商品编码" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">单位</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="dw"
                                                                           placeholder="单位" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">含税价额</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="hsje"
                                                                           placeholder="含税价额" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">税额</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="se"
                                                                           placeholder="税额" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">无税价额</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <input type="text" class="form-control"
                                                                               placeholder="无税价额"
                                                                               name="wsje" value="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">来源单据号（发票号）</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <input type="text" class="form-control"
                                                                               name="lydjh" value="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">来源行号</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <input type="text" class="form-control"
                                                                               name="lyhh" value="">
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">源头单据号</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">

                                                                        <input type="text" class="form-control"
                                                                                name="ytdjh" value="">

                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">源头行号</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="ythh"
                                                                            value="">
                                                                </div>

                                                                <div class="col-md-2 title">单价</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="dj"
                                                                           value="">
                                                                </div>

                                                                <div class="col-md-2 title">累计应付数量</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" readonly="readonly"
                                                                           name="ljyfsl"
                                                                           value="">
                                                                </div>
                                                                <div class="col-md-2 title">是否应付结束</div>
                                                                <div class="col-md-4 data">
                                                                    <select class="form-control" name="status">
                                                                        <option selected="selected" value="-1">全部</option>
                                                                    </select>
                                                                </div>
                                                                <%--外键id--%>
                                                                <input id="zib_zhu_id_input" type="hidden"
                                                                       value="" name="zhu_id">
                                                            </div>
                                                        </div>
                                                        <!--订单信息/--> <!--工具栏-->
                                                        <div class="box-tools <%--text-center --%>text-right">
                                                            <button type="reset" class="btn bg-orange">重置</button>
                                                        </div>
                                                        <!--工具栏/-->

                                                    </section>
                                                    <!-- 正文区域 /-->
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <button id="zib_save" type="button" class="btn btn-outline"
                                                data-dismiss="modal">添加
                                        </button>
                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>

                            <!-- /.modal-dialog -->
                        </div>
                        <%--模拟窗口/--%>
                        <button onclick="deleteZibByIds(this)" type="button" class="btn btn-default"
                                title="删除"><i
                                class="fa fa-trash-o"></i> 删除
                        </button>
                        <button id="zib_refresh_btn" onclick="refresh(this)" type="button" class="btn btn-default"
                                title="刷新"><i
                                class="fa fa-refresh"></i> 刷新
                        </button>
                    </div>
                    <span id="zib_count" count="">共 0 条记录</span>
                </div>
            </div>
            <%--工具栏/--%>
        </from>
        <br><br><br><br><br>
    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="../../footer.jsp"/>
    <!-- 底部导航 /-->
</div>


<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script>
    $(document).ready(function () {

        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });

        //日期控件
        // datetime picker
        $('.dateTimePicker').datetimepicker({
            format: "yyyy-mm-dd hh:ii",
            autoclose: true,
            todayBtn: true,
            language: 'zh-CN'
        });

        // 列表按钮
        $("#dataList_zhu td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        $("#dataList_zi td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });

        // 全选操作:主表
        $("#selall_zhu").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList_zhu td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList_zhu td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });

        // 全选操作：子表
        $("#selall_zi").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList_zi td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList_zi td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
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
        $('#datepicker-a3').datetimepicker({
            format: "yyyy-mm-dd hh:ii",
            autoclose: true,
            todayBtn: true,
            language: "zh-CN"
        });
    });

    $(document).ready(function () {
        // 激活导航位置
        setSidebarActive("order-manage");
        $("#datepicker-a3").datetimepicker({
            format: "yyyy-mm-dd hh:ii",
        });

    });
    function statusbe(x){
        if (x == 1){
            return "结束";
        }
        if (x == 0){
            return "没结束";
        }
        return "";
    }
    function sxbe(x){
        if (x == 1){
            return "生效";
        }
        if (x == 0){
            return "没生效";
        }
        return "";
    }
    function NoNull(x){
        var k = "";
        if(x == null){
            return k;
        }else{
            return x;
        }
    }

    function findByCgyfZhub(){
        var params = $("#form").serialize();
        $.ajax({
            url: "${pageContext.request.contextPath}/yf/findByCgyfZhub",
            type: "post",
            data: params,
            dataType: "json",
            success: function (data) {
                //清除$("#zhub_tbody")里面的内容
                $("#zhub_tbody").innerHTML = '';
                var cgyf_zhubs = data;
                var html = '';
                for (var i = 0; i < cgyf_zhubs.length; i++) {

                    html += '<tr>\n' +
                        '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhu_ids" type="checkbox" value="' + cgyf_zhubs[i].cgyfd_zhu_id+ '"></td>\n' +
                        '<td><button i="' + i + '" djh="' + cgyf_zhubs[i].djh + '" checked="" ondblclick="find_zib(this)" zhubId="' + cgyf_zhubs[i].cgyfd_zhu_id + '" style="width: 100%;height: 99%">' + cgyf_zhubs[i].djh + '</button></td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].gs) + '</td>\n' +
                        '<td>' + FormatTime(cgyf_zhubs[i].rq)+ '</td>\n' +
                        '<td>' + FormatTime(cgyf_zhubs[i].qsrq) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].ks) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].bm) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].ywy) + '</td>\n' +
                        '<td>' + sxbe(cgyf_zhubs[i].sxbz) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].zdr) + '</td>\n' +
                        '<td>' + FormatTime(cgyf_zhubs[i].zdsj) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].spr) + '</td>\n' +
                        '<td>' + FormatTime(cgyf_zhubs[i].spsj) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].xgr) + '</td>\n' +
                        '<td>' + FormatTime(cgyf_zhubs[i].xgsj) + '</td>\n' +
                        '<td>' + NoNull(cgyf_zhubs[i].qzr) + '</td>\n' +
                        '<td>' + FormatTime(cgyf_zhubs[i].qzsj) + '</td>\n' +
                        '<td class="text-center">\n' +
                        '<button id="zhub_xg_btn" i=' + i + ' onclick="zhub_xg_btn(this)" zhubId="' + cgyf_zhubs[i].cgyfd_zhu_id + '" type="button" data-toggle="modal" data-target="#myModal-zhub-' + i + '" class="btn bg-olive btn-xs"\n' +
                        '">\n' +
                        '    修改\n' +
                        '</button>\n' +
                        <%--模拟窗口--%>
                        '\n' +
                        '                        <div id="myModal-zhub-' + i + '" class="modal modal-primary" role="dialog">\n' +
                        '                            <div class="modal-dialog modal-lg">\n' +
                        '                                <div class="modal-content">\n' +
                        '                                    <div class="modal-header">\n' +
                        '                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                        '                                            <span aria-hidden="true">&times;</span>\n' +
                        '                                        </button>\n' +
                        '                                        <h4 class="modal-title">修改主表信息</h4>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="modal-body">\n' +
                        '                                        <div class="box-body">\n' +
                        '                                            <div class="form-horizontal">\n' +
                        '                                                <%--主表修改--%>\n' +
                        '                                                <form id="zhub_xg_form-' + i + '" method="post">\n' +
                        '                                                    <!-- 正文区域 -->\n' +
                        '                                                    <section class="content"> <!--产品信息-->\n' +
                        '\n' +
                        '                                                        <div class="panel panel-default">\n' +
                        '                                                            <div class="panel-heading">修改销售订单主单</div>\n' +
                        '                                                            <div class="row data-type">\n' +
                        '\n' +                                                           /* 此处是 标记一个主表的id属性，方便根据id更新主表zhub*/
                        '                                                                <input id="ys_id-' + i + '" type="hidden" name="cgyfd_zhu_id" value="">\n' +
                        '                                                                \n' +
                        '                                                                <div class="col-md-2 title">订单号</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="ys_djh-' + i + '" readonly="readonly" type="text"\n' +
                        '                                                                           class="form-control" name="djh"\n' +
                        '                                                                           placeholder="订单号" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">公司</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="ys_gs-' + i + '" type="text" class="form-control" name="gs"\n' +
                        '                                                                           placeholder="公司" value="">\n' +
                        '                                                                </div>\n' +

                        '                                                                <div class="col-md-2 title">日期</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <div class="input-group date">\n' +
                        '                                                                        <div class="input-group-addon">\n' +
                        '                                                                            <i class="fa fa-calendar"></i>\n' +
                        '                                                                        </div>\n' +
                        '                                                                        <input id="ys_rq-' + i + '" type="text"\n' +
                        '                                                                               class="form-control pull-right dateTimePicker"\n' +
                        '                                                                               name="rq">\n' +
                        '                                                                    </div>\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">起算日期</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <div class="input-group date">\n' +
                        '                                                                        <div class="input-group-addon">\n' +
                        '                                                                            <i class="fa fa-calendar"></i>\n' +
                        '                                                                        </div>\n' +
                        '                                                                        <input id="ys_qsrq-' + i + '" type="text"\n' +
                        '                                                                               class="form-control pull-right dateTimePicker"\n' +
                        '                                                                               name="qsrq">\n' +
                        '                                                                    </div>\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">客商</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="ys_ks-' + i + '" type="text" class="form-control" onblur="" name="ks"\n' +
                        '                                                                           placeholder="客商" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">部门</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="ys_bm-' + i + '" type="text" class="form-control" name="bm"\n' +
                        '                                                                           placeholder="部门" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">业务员</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="ys_ywy-' + i + '" type="text" class="form-control" name="ywy"\n' +
                        '                                                                           placeholder="业务员" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">制单人</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="yf_zdr-' + i + '" type="text" class="form-control" name="zdr"\n' +
                        '                                                                           value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">制单日期</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <div class="input-group date">\n' +
                        '                                                                        <div class="input-group-addon">\n' +
                        '                                                                            <i class="fa fa-calendar"></i>\n' +
                        '                                                                        </div>\n' +
                        '                                                                        <input id="yf_zdsj-' + i + '" type="text"\n' +
                        '                                                                               class="form-control pull-right dateTimePicker"\n' +
                        '                                                                               name="zdsj">\n' +
                        '                                                                    </div>\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">审核人</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input  id="ys_spr-' + i + '" type="text"  class="form-control" name="spr"\n' +
                        '                                                                           placeholder="审核人" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">审核日期</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <div class="input-group date">\n' +
                        '                                                                        <div class="input-group-addon">\n' +
                        '                                                                            <i class="fa fa-calendar"></i>\n' +
                        '                                                                        </div>\n' +
                        '                                                                        <input  id="ys_spsj-' + i + '" type="text"\n' +
                        '                                                                               class="form-control pull-right dateTimePicker"' +
                        '                                                                               name="spsj">\n' +
                        '                                                                    </div>\n' +
                        '                                                                </div>\n' +

                        '                                                                <div class="col-md-2 title">修改人</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input  id="ys_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                        '                                                                           placeholder="修改人" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">修改日期</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <div class="input-group date">\n' +
                        '                                                                        <div class="input-group-addon">\n' +
                        '                                                                            <i class="fa fa-calendar"></i>\n' +
                        '                                                                        </div>\n' +
                        '                                                                        <input  id="ys_xgsj-' + i + '" type="text"\n' +
                        '                                                                               class="form-control pull-right dateTimePicker"\n' +
                        '                                                                               name="xgsj">\n' +
                        '                                                                    </div>\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">生效标志</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <select class="form-control" name="sxbz">\n' +
                        '                                                                        <option id="ys_sxbz_option0-' + i + '" value="0">没生效</option>\n' +
                        '                                                                        <option id="ys_sxbz_option1-' + i + '" value="1">生效</option>\n' +
                        '                                                                    </select>\n' +
                        '                                                                </div>\n' +

                        '                                                                <div class="col-md-2 title">签字人</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <input id="ys_qzr-' + i + '" type="text" class="form-control" name="qzr"\n' +
                        '                                                                           placeholder="调整人" value="">\n' +
                        '                                                                </div>\n' +
                        '                                                                <div class="col-md-2 title">签字日期</div>\n' +
                        '                                                                <div class="col-md-4 data">\n' +
                        '                                                                    <div class="input-group date">\n' +
                        '                                                                        <div class="input-group-addon">\n' +
                        '                                                                            <i class="fa fa-calendar"></i>\n' +
                        '                                                                        </div>\n' +
                        '                                                                        <input  id="ys_qzsj-' + i + '" type="text"\n' +
                        '                                                                               class="form-control pull-right dateTimePicker"\n' +
                        '                                                                               name="qzsj">\n' +
                        '                                                                    </div>\n' +
                        '                                                                </div>\n' +

                        '                                                            </div>\n' +
                        '                                                        </div>\n' +
                        '                                                    </section>\n' +
                        '                                                    <!-- 正文区域 /-->\n' +
                        '                                                </form>\n' +
                        '                                            </div>\n' +
                        '                                        </div>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="modal-footer">\n' +
                        '                                        <button i="' + i + '" onclick="updateXsdd_zhubById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                        '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                                <!-- /.modal-content -->\n' +
                        '                            </div>\n' +
                        '\n' +
                        '                            <!-- /.modal-dialog -->\n' +
                        '                        </div>' +
                        <%--模拟窗口/--%>
                        '<button zhubId="' + cgyf_zhubs[i].cgyfd_zhu_id + '" data-toggle="modal" data-target="#myModal_2" type="button" class="btn bg-olive btn-xs"\n' +
                        '    onclick="delete_zhub(this)">\n' +
                        '    删除\n' +
                        '</button>\n' +
                        '</td>\n' +
                        '</tr>';
                }
                $("#zhub_tbody").html(html);
                $("#zhub_count").html("共 " + cgyf_zhubs.length + " 条记录");
                $("#zhub_count").attr("count", cgyf_zhubs.length);
            },
            error: function () {
                alert("查询失败！")
            }
        });
    }

    /*发表单查询*/
    $(document).ready(function () {
        /*start*/
        //功能：主表：点击查询按钮，根据主表一部分信息查询出所有满足的主表集合
        $("#query").click(function () {
            findByCgyfZhub();
        });



        /*11*/
        //功能：子表：点击主表添加按钮触发，添加到模态框主表信息，先查询出行号，行号添加是从1开始递增
        $("#get_zib_hh").click(function () {
            var zhu_id = $("#zib_form").attr("zhu_id");
            var i = $("#zhub_xg_btn").attr("i");
            if (zhu_id == -1) {
                alert("请指定一个主表：单击主表中的预订单号按钮即可");
            } else {

                    $("#zib_zhu_id_input").attr("value", zhu_id);
                    $.ajax({
                        url: "${pageContext.request.contextPath}/yf/getZib_hh",
                        type: "get",
                        data: {"zhuId": zhu_id},
                        dataType: "json",
                        async: false,
                        success: function (data) {
                            var hh = data+1;
                            //赋值
                            $("#zibhh").attr("value", hh);
                        },
                        error: function () {
                            alert("获取行号失败");
                        }
                    });
                }
                //把zhubid外键赋值给子表模态框的input里面


        });

        /*12*/
        //功能：子表：点击模拟框中的添加按钮触发请求，保存一个子表信息
        $("#zib_save").click(function () {
            var params = $("#zib_save_form").serialize();
            console.log(params);
                $.ajax({
                    url: "${pageContext.request.contextPath}/yf/saveZib",
                    type: "post",
                    data: params,
                    dataType: "Text",
                    success: function () {
                        var zhu_id = $("#zib_form").attr("zhu_id");
                        refreshzib(zhu_id);
                    },
                    error: function () {
                        alert("添加失败！出现问题")
                    }
                });

        });
    });
    //显示日期格式化
    function FormatTime(nowD) {
        if (!nowD) {
            return "";
        }
// 日期过滤
        if (typeof nowD === 'string') {
            nowD = DateFilter(nowD);
        }
        nowD = new Date(nowD);
        var YY = nowD.getFullYear(),
            MM = nowD.getMonth() + 1,
            DD = nowD.getDate(),
            hh = nowD.getHours(),
            mm = nowD.getMinutes(),
            ss = nowD.getSeconds();
        return YY + "-" + MM + "-" + DD + " " + hh + ":" + mm;
    }

    //功能：单击 主表中的 修改按钮，把该行的信息填充到模拟div中
    function zhub_xg_btn(x) {
        //alert("ok")
        var zhuId = $(x).attr("zhubId");
        $.ajax({
            url: "${pageContext.request.contextPath}/yf/findZhuByid",
            type: "get",
            data: {"zhuId":zhuId},
            dataType: "json",
            success: function (data) {
                //alert("ok");
                var yf_zhub = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");


                //2,给每一个按钮框添加值
                $("#ys_id-" + i).attr("value", yf_zhub.cgyfd_zhu_id);
                $("#ys_djh-"+ i).attr("value",yf_zhub.djh);
                $("#ys_gs-"+i).attr("value",yf_zhub.gs);
                $("#ys_rq-"+i).attr("value",FormatTime(yf_zhub.rq));
                $("#ys_qsrq-"+i).attr("value",FormatTime(yf_zhub.qsrq));
                $("#ys_ks-"+i).attr("value",yf_zhub.ks);
                $("#ys_ywy-"+i).attr("value",yf_zhub.ywy);
                $("#ys_bm-"+i).attr("value",yf_zhub.bm);
                $("#ys_spr-"+i).attr("value",yf_zhub.spr);
                $("#ys_spsj-"+i).attr("value",FormatTime(yf_zhub.spsj));
                $("#yf_zdr-"+i).attr("value",yf_zhub.zdr);
                $("#yf_zdsj-"+i).attr("value",FormatTime(yf_zhub.zdsj));
                $("#ys_qzr-"+i).attr("value",yf_zhub.qzr);
                $("#ys_qzsj-"+i).attr("value",FormatTime(yf_zhub.qzsj));



                //添加disabled="disabled" 注意：在提交表单的时候，需要把disabled移除，不然提交不了数据
                //zhub_xg_select_status-'+i+'
                // $("#zhub_xg_select_thbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_fhbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_ckbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_kpbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_ysbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_status-" + i).attr("disabled", "disabled");

                if (yf_zhub.sxbz == 1) {
                    $("#ys_sxbz_option1-" + i).attr("selected", "selected");
                } else {
                    $("#ys_sxbz_option0-" + i).attr("selected", "selected");
                }

            },
            error: function () {
                alert("无响应!");
            }
        });
    }

    /*2*/
    //功能：单击 主表模态框中的 修改按钮，对修改的信息进行修改
    function updateXsdd_zhubById(x) {
        //获取点击了该修改按钮所在的行号i
        var i = $(x).attr("i");
        //alert(i);
        //一定要移除disabled属性 ???????
        // $("#zhub_xg_select_thbz-" + i).removeAttr("disabled");
        // $("#zhub_xg_select_fhbz-" + i).removeAttr("disabled");
        // $("#zhub_xg_select_ckbz-" + i).removeAttr("disabled");
        // $("#zhub_xg_select_kpbz-" + i).removeAttr("disabled");
        // $("#zhub_xg_select_ysbz-" + i).removeAttr("disabled");
        // $("#zhub_xg_select_status-" + i).removeAttr("disabled");
        //表单数据
        if($("#ys_xgr-"+i).val() == ""||$("#ys_xgsj-"+i).val() == ""){
            alert("请输入修改人和修改日期 ");
        }else {
            var params = $("#zhub_xg_form-" + i).serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/yf/updateZhub",
                type: "post",
                data: params,
                dataType: "json",
                // async: false,
                success: function (data) {
                    $("#query").trigger("click");
                    var pageInfo = data;
                    alert("修改成功");
                    findByCgyfZhub();

                },
                error: function (data) {
                    alert("出现未知问题，修改失败")
                }
            });
        }

    }

    /*3*/
    //功能：单击主表总右边的删除按钮，删除主表 by id
    function delete_zhub(x) {
        //判断是否删除
        var msg = "是否确认删除?";
        if (confirm(msg) == true) {
            var yf_zhu_id = $(x).attr("zhubId");
            $.ajax({
                url: "${pageContext.request.contextPath}/yf/DeleteZhub",
                type: "GET",
                data: {"zhuId": yf_zhu_id},
                dataType: "text",
                async: false,
                success: function (data) {
                    //遍历每一个tr
                    $("#zhub_tbody tr").each(function (i) {
                        //获取第一个节点
                        var firstTd = $(this).children('td')[0];
                        //第一个节点的input标签，即小框框
                        var firstInput = $(firstTd).children('input')[0];
                        var id = $(firstInput).attr("value")
                        if (id == yf_zhu_id) {
                            $(this).remove();
                            var befCount = $("#zhub_count").attr("count");
                            var realCount = befCount - 1;
                            $("#zhub_count").html("共 " + realCount + " 条记录");
                            $("#zhub_count").attr("count", realCount);
                        }
                    });
                    alert("删除成功!")
                },
                error: function (data) {
                    alert("删除失败!")
                }
            });
        }
    }

    /*6*/
    //功能：单机主表下面的删除按钮，删除主表by ids
    function deleteZhubByIds(x) {
        var msg = "是否确定删除?";
        if (confirm(msg) == true) {
            var ids = "";
            var inputs = document.getElementsByName("zhu_ids");
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
                url: "${pageContext.request.contextPath}/yf/DeleteZhubs",
                type: "GET",
                data: {"ids": ids},
                dataType: "text",
                async: false,
                success: function () {
                    var n = 0;
                    for (var i = inputs.length - 1; i >= 0; i--) {
                        if (inputs[i].checked) {
                            inputs[i].parentElement.parentElement.remove();
                            n++;
                        }
                    }
                    var befCount = $("#zhub_count").attr("count");
                    var realCount = befCount - n;
                    $("#zhub_count").html("共 " + realCount + " 条记录");
                    $("#zhub_count").attr("count", realCount);
                    alert("删除成功!")
                },
                error: function () {
                    alert("删除失败!")
                }
            });
        }
    }


    /*7*/
    //功能：双击主表总djh按钮触发，根据主表的id查询所有的子表信息，并添加到子表
    function find_zib(x) {
        //移除属性checked
        $(".my-checkbox").removeAttr('checked');
        //把当前设置为true
        var i = $(x).attr("i");
        $("#checkbox-pos-" + i).prop("checked", true);
        //获取id
        var yf_zhu_id = $(x).attr("zhubId");
        //获取djh:对应了子表上面的 单据号：input[xxx],将单据号添加到里面显示，方便查看
        var djh = $(x).attr("djh");
        $.ajax({
            url: "${pageContext.request.contextPath}/yf/findZiByZhuId",
            type: "GET",
            data: {"zhuId": yf_zhu_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //先清除$("#zib_tbody")里面的内容
                $("#zib_tbody").innerHTML = '';
                //给子表form的zhu_id赋值
                $("#zib_form").attr("zhu_id", yf_zhu_id);
                /*单据号：<input id="djh"...*/
                $("#djh").attr("value", djh);
                //添加内容
                yf_zibs = data;
                var html = '';
                for (var i = 0; i < yf_zibs.length; i++) {
                    html += '<tr>\n' +
                        '<td><input name="zib_ids" type="checkbox" value="' + yf_zibs[i].cgyfd_zib_id + '"></td>\n' +
                        '<td>' + NoNull(yf_zibs[i].hh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].sl) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].spmc) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].spbm) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].dw) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].hsje) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].se) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].wsje) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].lydjh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].lyhh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].ytdjh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].ythh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].dj) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].ljyfsl) + '</td>\n' +
                        '<td>' + statusbe(yf_zibs[i].status) + '</td>\n' +
                        '<td class="text-center">\n' +
                        '<button id="zib_xg_btn" i="' + i + '" zibId="' + yf_zibs[i].cgyfd_zib_id+ '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
                        '    >\n' +
                        '    修改\n' +
                        '</button>\n' +
                        <%--模拟窗口--%>
                        '\n' +
                        '                        <div id="myModal-zib-' + i + '" class="modal modal-primary" role="dialog">\n' +
                        '                            <div class="modal-dialog modal-lg">\n' +
                        '                                <div class="modal-content">\n' +
                        '                                    <div class="modal-header">\n' +
                        '                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                        '                                            <span aria-hidden="true">&times;</span>\n' +
                        '                                        </button>\n' +
                        '                                        <h4 class="modal-title">修改子表信息</h4>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="modal-body">\n' +
                        '                                        <div class="box-body">\n' +
                        '                                            <div class="form-horizontal">\n' +
                        '                                                <%--主表修改--%>\n' +
                        '                                                <form id="zib_xg_form-' + i + '" method="post">\n' +
                        '                                                    <!-- 正文区域 -->\n' +
                        '                                                    <section class="content"> <!--产品信息-->\n' +
                        '\n' +
                        '                                                        <div class="panel panel-default">\n' +
                        '                                                            <div class="panel-heading">应付单子单</div>\n' +
                        '                                                            <div class="row data-type">\n' +
                        '                        <input id="yfzhib_zid-' + i + '" type="hidden" name="zhu_id" value="">\n' + /*主表id--》外键*/
                        '                        <input id="yfzhib_id-' + i + '" type="hidden" name="cgyfd_zib_id" value="">\n' + /*子表id*/
                        '                        <div class="col-md-2 title">行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                        '                                   placeholder="行号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_sl-' + i + '" type="text" readonly="readonly"  class="form-control" name="sl"\n' +
                        '                                   placeholder="数量" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">商品名称</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_spmc-' + i + '" type="text" readonly="readonly"  class="form-control" name="spmc"\n' +
                        '                                   placeholder="商品名称" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">商品编码</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_spbm-' + i + '" type="text" class="form-control" name="spbm"\n' +
                        '                                   placeholder="商品编码" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">单位</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="yfzhib_dw-' + i + '" type="text" class="form-control" name="dw"\n' +
                        '                                   placeholder="单位" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">含税金额</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="yfzhib_hsje-' + i + '" type="text" class="form-control" name="hsje"\n' +
                        '                                   placeholder="含税金额" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">税额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="yfzhib_se-' + i + '" type="text" placeholder="税额" class="form-control" name="se">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">无税金额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="yfzhib_wsje-' + i + '" type="text" placeholder="无税金额" class="form-control" name="wsje">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">来源单据号（发票号）</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="yfzhib_lydjh-' + i + '" type="text" placeholder="来源单据号" class="form-control" name="lydjh">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">来源行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +

                        '                                <input id="yfzhib_lyhh-' + i + '" type="text" placeholder="来源行号" class="form-control" name="lyhh">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">源头单据号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_ytdjh-' + i + '" type="text" class="form-control" name="ytdjh"\n' +
                        '                                   placeholder="源头单据号" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">源头行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_ythh-' + i + '" type="text" class="form-control" name="ythh"\n' +
                        '                                   placeholder="源头行号" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">单价</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_dj-' + i + '" type="text" class="form-control" name="dj"\n' +
                        '                                   placeholder="单价" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">累计应付数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_ljyfsl-' + i + '" type="text" readonly class="form-control" name="ljyfsl"\n' +
                        '                                   placeholder="累计应付数量" value="">\n' +
                        '                        </div>' +
                        '                          <div class="col-md-2 title">修改人</div>\n' +
                        '                              <div class="col-md-4 data">\n' +
                        '                                  <input  id="yfzhib_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                        '                                        placeholder="修改人" value="">\n' +
                        '                               </div>\n' +
                        '                        <div class="col-md-2 title">修改日期</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                           <div class="input-group date">\n' +
                        '                                 <div class="input-group-addon">\n' +
                        '                                      <i class="fa fa-calendar"></i>\n' +
                        '                                  </div>\n' +
                        '                               <input  id="yfzhib_xgsj-' + i + '" type="text"\n' +
                        '                                   class="form-control pull-right dateTimePicker"\n' +
                        '                                   name="xgsj">\n' +
                        '                            </div>\n' +
                        '                         </div>\n' +

                        '                                                        </div>\n' +
                        '                                                        </div>\n' +
                        '                                                    </section>\n' +
                        '                                                    <!-- 正文区域 /-->\n' +
                        '                                                </form>\n' +
                        '                                            </div>\n' +
                        '                                        </div>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="modal-footer">\n' +
                        '                                        <button zibId="' + yf_zibs[i].cgyfd_zib_id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                        '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                                <!-- /.modal-content -->\n' +
                        '                            </div>\n' +
                        '\n' +
                        '                            <!-- /.modal-dialog -->\n' +
                        '                        </div>' +
                        <%--模拟窗口/--%>
                        '<button zibId="' + yf_zibs[i].cgyfd_zib_id + '" type="button" class="btn bg-olive btn-xs"\n' +
                        '    onclick="delete_zib(this)">\n' +
                        '    删除\n' +
                        '</button>\n' +
                        '</td>\n' +
                        '</tr>';
                }
                $("#zib_tbody").html(html);
                $("#zib_count").attr("count", yf_zibs.length);
                $("#zib_count").html("共 " + yf_zibs.length + " 条记录");
            },
            error: function () {
                alert("查询失败！")
            }
        });
    }

    /*8*/
    //功能：单击 子表中的 修改按钮，把该行的信息填充到模拟div中
    function zib_xg_btn(x) {
        var yf_zib_id = $(x).attr("zibId");
        $.ajax({
            url: "${pageContext.request.contextPath}/yf/findZiById",
            type: "get",
            data: {"id": yf_zib_id},
            dataType: "json",
            async: false,
            success: function (data) {
                var yf_zib = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");

                    //2,给每一个按钮框添加值
                $("#yfzhib_zid-" + i).attr("value", yf_zib.zhu_id); /*主表d --》外键*/
                $("#yfzhib_id-" + i).attr("value", yf_zib.cgyfd_zib_id);/*子表id*/
                $("#yfzhib_hh-" + i).attr("value", yf_zib.hh);
                $("#yfzhib_sl-" + i).attr("value", yf_zib.sl);
                $("#yfzhib_spmc-" + i).attr("value", yf_zib.spmc);
                $("#yfzhib_spbm-" + i).attr("value", yf_zib.spbm);
                $("#yfzhib_dw-" + i).attr("value", yf_zib.dw);
                $("#yfzhib_hsje-" + i).attr("value", yf_zib.hsje);
                $("#yfzhib_se-" + i).attr("value", yf_zib.se);
                $("#yfzhib_wsje-" + i).attr("value", yf_zib.wsje);
                $("#yfzhib_lydjh-" + i).attr("value", yf_zib.lydjh);
                $("#yfzhib_lyhh-" + i).attr("value", yf_zib.lyhh);
                $("#yfzhib_ytdjh-" + i).attr("value", yf_zib.ytdjh);
                $("#yfzhib_ythh-" + i).attr("value", yf_zib.ythh);
                $("#yfzhib_dj-" + i).attr("value", yf_zib.dj);
                $("#yfzhib_ljyfsl-" + i).attr("value", yf_zib.ljyfsl);



            },
            error: function (data) {
                alert("无响应!");
            }
        });
    }

    /*9*/
    //功能： 单击 子表模态框中的 修改按钮，对修改的信息进行修改
    function updateZibById(x) {
        //获取点击了该修改按钮所在的行号i
        var i = $(x).attr("i");
        //表单数据
        var params = $("#zib_xg_form-" + i).serialize();
        if($("#yfzhib_xgr-"+i).val() == ""||$("#yfzhib_xgsj-"+i).val() == ""){
            alert("请输入修改人和修改日期")
        }else {
                $.ajax({
                    url: "${pageContext.request.contextPath}/yf/updateZib",
                    type: "post",
                    data: params,
                    dataType: "Text",
                    // async: false,
                    success: function () {
                        var zhu_id = $("#zib_form").attr("zhu_id");
                        refreshzib(zhu_id);
                    },
                    error: function () {
                        alert("修改失败！出现未知问题")
                    }
                });
        }

    }

    /*10*/
    //功能：单击子表总右边的删除按钮，删除子表 by id
    function delete_zib(x) {
        var msg = "是否确认删除?";
        if (confirm(msg) == true) {
            var zibId = $(x).attr("zibId");
            $.ajax({
                url: "${pageContext.request.contextPath}/yf/DeleteZib",
                type: "GET",
                data: {"id": zibId},
                dataType: "text",
                async: false,
                success: function (data) {
                    alert("删除成功!")
                    //遍历每一个tr
                    $("#zib_tbody tr").each(function (i) {
                        //获取第一个节点
                        var firstTd = $(this).children('td')[0];
                        var firstInput = $(firstTd).children('input')[0];
                        var id = $(firstInput).attr("value")
                        if (id == zibId) {
                            $(this).remove();
                            var befCount = $("#zib_count").attr("count");
                            var realCount = befCount - 1;
                            $("#zib_count").html("共 " + realCount + " 条记录");
                            $("#zib_count").attr("count", realCount);
                        }
                    });
                },
                error: function () {
                    alert("删除失败!")
                }
            });
        }
    }

    /*13*/
    //功能：单机子表下面的删除按钮，删除子表by ids
    function deleteZibByIds(x) {
        var msg = "是否确定删除?";
        if (confirm(msg) == true) {
            var ids = "";
            var inputs = document.getElementsByName("zib_ids");
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
                url: "${pageContext.request.contextPath}/yf/DeleteZibs",
                type: "GET",
                data: {"ids": ids},
                dataType: "text",
                async: false,
                success: function () {
                    var n = 0;
                    for (var i = inputs.length - 1; i >= 0; i--) {
                        if (inputs[i].checked) {
                            inputs[i].parentElement.parentElement.remove();
                            n++;
                        }
                    }
                    var befCount = $("#zib_count").attr("count");
                    var realCount = befCount - n;
                    $("#zib_count").html("共 " + realCount + " 条记录");
                    $("#zib_count").attr("count", realCount);
                    alert("删除成功!")
                },
                error: function () {
                    alert("删除失败!")
                }
            });
        }
    }

    /*14*/
    //功能： 单击 子表下面的刷新按钮触发，对子表进行刷新
    function refresh(x) {
        var zhu_id = $("#zib_form").attr("zhu_id");
        if (zhu_id != -1) {
           refreshzib(zhu_id)
        }
    }

    function refreshzib(zhu_id) {
        $.ajax({
            url: "${pageContext.request.contextPath}/yf/findZiByZhuId",
            type: "GET",
            data: {"zhuId": zhu_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //先清除$("#zib_tbody")里面的内容
                $("#zib_tbody").innerHTML = '';
                //给子表form的zhu_id赋值
                $("#zib_form").attr("zhu_id", zhu_id);
                //添加内容
                yf_zibs = data;
                var html = '';
                for (var i = 0; i < yf_zibs.length; i++) {
                    html += '<tr>\n' +
                        '<td><input name="zib_ids" type="checkbox" value="' + yf_zibs[i].cgyfd_zib_id + '"></td>\n' +
                        '<td>' + NoNull(yf_zibs[i].hh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].sl) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].spmc) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].spbm) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].dw) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].hsje) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].se) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].wsje) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].lydjh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].lyhh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].ytdjh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].ythh) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].dj) + '</td>\n' +
                        '<td>' + NoNull(yf_zibs[i].ljyfsl) + '</td>\n' +
                        '<td>' + statusbe(yf_zibs[i].status) + '</td>\n' +
                        '<td class="text-center">\n' +
                        '<button id="zib_xg_btn" i="' + i + '" zibId="' + yf_zibs[i].cgyfd_zib_id+ '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
                        '    >\n' +
                        '    修改\n' +
                        '</button>\n' +
                        <%--模拟窗口--%>
                        '\n' +
                        '                        <div id="myModal-zib-' + i + '" class="modal modal-primary" role="dialog">\n' +
                        '                            <div class="modal-dialog modal-lg">\n' +
                        '                                <div class="modal-content">\n' +
                        '                                    <div class="modal-header">\n' +
                        '                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">\n' +
                        '                                            <span aria-hidden="true">&times;</span>\n' +
                        '                                        </button>\n' +
                        '                                        <h4 class="modal-title">修改子表信息</h4>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="modal-body">\n' +
                        '                                        <div class="box-body">\n' +
                        '                                            <div class="form-horizontal">\n' +
                        '                                                <%--主表修改--%>\n' +
                        '                                                <form id="zib_xg_form-' + i + '" method="post">\n' +
                        '                                                    <!-- 正文区域 -->\n' +
                        '                                                    <section class="content"> <!--产品信息-->\n' +
                        '\n' +
                        '                                                        <div class="panel panel-default">\n' +
                        '                                                            <div class="panel-heading">应付单子单</div>\n' +
                        '                                                            <div class="row data-type">\n' +
                        '                        <input id="yfzhib_zid-' + i + '" type="hidden" name="zhu_id" value="">\n' + /*主表id--》外键*/
                        '                        <input id="yfzhib_id-' + i + '" type="hidden" name="cgyfd_zib_id" value="">\n' + /*子表id*/
                        '                        <div class="col-md-2 title">行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                        '                                   placeholder="行号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_sl-' + i + '" type="text" readonly="readonly"  class="form-control" name="sl"\n' +
                        '                                   placeholder="数量" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">商品名称</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_spmc-' + i + '" type="text" readonly="readonly"  class="form-control" name="spmc"\n' +
                        '                                   placeholder="商品名称" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">商品编码</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_spbm-' + i + '" type="text" class="form-control" name="spbm"\n' +
                        '                                   placeholder="商品编码" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">单位</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="yfzhib_dw-' + i + '" type="text" class="form-control" name="dw"\n' +
                        '                                   placeholder="单位" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">含税金额</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="yfzhib_hsje-' + i + '" type="text" class="form-control" name="hsje"\n' +
                        '                                   placeholder="含税金额" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">税额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="yfzhib_se-' + i + '" type="text" placeholder="税额" class="form-control" name="se">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">无税金额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="yfzhib_wsje-' + i + '" type="text" placeholder="无税金额" class="form-control" name="wsje">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">来源单据号（发票号）</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="yfzhib_lydjh-' + i + '" type="text" placeholder="来源单据号" class="form-control" name="lydjh">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">来源行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +

                        '                                <input id="yfzhib_lyhh-' + i + '" type="text" placeholder="来源行号" class="form-control" name="lyhh">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">源头单据号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_ytdjh-' + i + '" type="text" class="form-control" name="ytdjh"\n' +
                        '                                   placeholder="源头单据号" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">源头行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_ythh-' + i + '" type="text" class="form-control" name="ythh"\n' +
                        '                                   placeholder="源头行号" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">单价</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_dj-' + i + '" type="text" class="form-control" name="dj"\n' +
                        '                                   placeholder="单价" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">累计应付数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="yfzhib_ljyfsl-' + i + '" type="text" readonly class="form-control" name="ljyfsl"\n' +
                        '                                   placeholder="累计应付数量" value="">\n' +
                        '                        </div>' +
                        '                          <div class="col-md-2 title">修改人</div>\n' +
                        '                              <div class="col-md-4 data">\n' +
                        '                                  <input  id="yfzhib_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                        '                                        placeholder="修改人" value="">\n' +
                        '                               </div>\n' +
                        '                        <div class="col-md-2 title">修改日期</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                           <div class="input-group date">\n' +
                        '                                 <div class="input-group-addon">\n' +
                        '                                      <i class="fa fa-calendar"></i>\n' +
                        '                                  </div>\n' +
                        '                               <input  id="yfzhib_xgsj-' + i + '" type="text"\n' +
                        '                                   class="form-control pull-right dateTimePicker"\n' +
                        '                                   name="xgsj">\n' +
                        '                            </div>\n' +
                        '                         </div>\n' +

                        '                                                        </div>\n' +
                        '                                                        </div>\n' +
                        '                                                    </section>\n' +
                        '                                                    <!-- 正文区域 /-->\n' +
                        '                                                </form>\n' +
                        '                                            </div>\n' +
                        '                                        </div>\n' +
                        '                                    </div>\n' +
                        '                                    <div class="modal-footer">\n' +
                        '                                        <button zibId="' + yf_zibs[i].cgyfd_zib_id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                        '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                                <!-- /.modal-content -->\n' +
                        '                            </div>\n' +
                        '\n' +
                        '                            <!-- /.modal-dialog -->\n' +
                        '                        </div>' +
                        <%--模拟窗口/--%>
                        '<button zibId="' + yf_zibs[i].cgyfd_zib_id + '" type="button" class="btn bg-olive btn-xs"\n' +
                        '    onclick="delete_zib(this)">\n' +
                        '    删除\n' +
                        '</button>\n' +
                        '</td>\n' +
                        '</tr>';
                }
                $("#zib_tbody").html(html);
                $("#zib_count").attr("count", yf_zibs.length);
                $("#zib_count").html("共 " + yf_zibs.length + " 条记录");
            },
            error: function () {
                alert("查询失败！")
            }
        });
    }


</script>


</body>

</html>


