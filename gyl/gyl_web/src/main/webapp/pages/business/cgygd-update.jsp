<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Kxin
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
    <title>采购预购单修订</title>
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
                采购预购单-修订
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
                    <a href="#">采购管理</a>
                </li>
                <li>
                    <a href="#">预购单管理</a>
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
                    <div class="panel-heading">查询(未审批)</div>
                    <div class="row data-type">
                        <%--1--%>
                            <div class="col-md-2 title">预购单ID</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="cgqgdzhubid"
                                       placeholder="预购单ID" value="">
                            </div>
                            <div class="col-md-2 title">请购日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right dateTimePicker" name="qgrq">
                                </div>
                            </div>
                            <%--2--%>
                            <div class="col-md-2 title">公司</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="gs"
                                       placeholder="公司" value="">
                            </div>
                            <div class="col-md-2 title">单据号</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="djh"
                                       placeholder="单据号" value="">
                            </div>
                            <%--3--%>
                            <div class="col-md-2 title">请购供应商</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="qggys"
                                       placeholder="供应商" value="">
                            </div>
                            <div class="col-md-2 title">采购部门</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="cgbm"
                                       placeholder="采购部门" value="">
                            </div>
                            <div class="col-md-2 title">采购人</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="cgr"
                                       placeholder="采购人" value="">
                            </div>

                            <div class="col-md-2 title">状态</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="status">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">结束</option>
                                    <option value="0">没结束</option>
                                </select>
                            </div>

                            <div class="col-md-2 title">币种</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="bz"
                                       placeholder="币种" value="">
                            </div>

                            <div class="col-md-2 title">整单税率(%)</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="zdsl"
                                       placeholder="整单税率(%)" value="">
                            </div>

                            <%--4--%>

                            <div class="col-md-2 title">审批人</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="spr"
                                       placeholder="审批人" value="">
                            </div>
                            <div class="col-md-2 title">审批日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right dateTimePicker" name="sprq">
                                </div>
                            </div>
                            <div class="col-md-2 title">是否审批</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="issp">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">审批是否通过</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="spsftg">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
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
                                    <input type="text" class="form-control pull-right dateTimePicker" name="zdrq">
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
                                    <input type="text" class="form-control pull-right dateTimePicker" name="xgrq">
                                </div>
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
                <!--工具栏/--> </section>
        </form>

        <!--数据列表-->
        <%-- 1：主表--%>
        <from><%--提交ids--%>
            <div style="padding-left: 20px"><h4><%--主表--%></h4></div>
            <div style="overflow: scroll;overflow-y:scroll;height: 200px;width: 99%;">
                <table id="dataList_zhu" class="table table-bordered table-striped table-hover dataTable"
                       style="min-width:4000px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zhu" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" width="200px">单据号</th>
                    <th class="text-center sorting" width="200px">公司</th>
                    <th class="text-center sorting" width="200px">请购供应商</th>
                    <th class="text-center sorting" width="200px">采购部门</th>
                    <th class="text-center sorting" width="200px">采购人</th>
                    <th class="text-center sorting" width="200px">请购日期</th>
                    <th class="text-center sorting" width="200px">状态</th>
                    <th class="text-center sorting" width="200px">币种</th>
                    <th class="text-center sorting" width="200px">整单税率(%)</th>
                    <th class="text-center sorting" width="200px">审批人</th>
                    <th class="text-center sorting" width="200px">审批日期</th>
                    <th class="text-center sorting" width="200px">是否审批</th>
                    <th class="text-center sorting" width="200px">审批是否通过</th>
                    <th class="text-center sorting" width="200px">制单人</th>
                    <th class="text-center sorting" width="200px">制单日期</th>
                    <th class="text-center sorting" width="200px">修改人</th>
                    <th class="text-center sorting" width="200px">修改日期</th>
                    <th class="text-center" width="200px">操作</th>
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
        <from id="zib_form" zhub_id="-1">
            <div style="padding-left: 20px;"><h4><%--子表--%></h4></div>
            <div style="overflow: scroll;overflow-y:scroll;height: 300px;width: 99%;">
                <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                       style="min-width:4700px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zi" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" width="350px">行号</th>
                    <th class="text-center sorting" width="350px">商品编号</th>
                    <th class="text-center sorting" width="350px">商品名称</th>
                    <th class="text-center sorting" width="350px">商品型号</th>
                    <th class="text-center sorting" width="350px">计量单位</th>
                    <th class="text-center sorting" width="350px">数量</th>
                    <th class="text-center sorting" width="350px">税率(%)</th>
                    <th class="text-center sorting" width="350px">无税单价</th>
                    <th class="text-center sorting" width="350px">含税单价</th>
                    <th class="text-center sorting" width="350px">无税金额</th>
                    <th class="text-center sorting" width="350px">含税金额</th>
                    <th class="text-center sorting" width="350px">税额</th>
                    <th class="text-center sorting" width="350px">规格</th>
                    <th class="text-center" width="350px">操作</th>
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
                                        <h4 class="modal-title">添加销售订单子单</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="box-body">
                                            <div class="form-horizontal">
                                                <%--子表添加--%>
                                                <form id="zib_save_form" method="post">
                                                    <!-- 正文区域 -->
                                                    <section class="content"> <!--产品信息-->

                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">销售订单子单</div>
                                                            <div class="row data-type">
                                                                <div class="col-md-2 title">行号</div>
                                                                <div class="col-md-4 data">
                                                                    <input id="zibhh" type="text" readonly="readonly"
                                                                           class="form-control" name="hh"
                                                                           placeholder="行号" value="">
                                                                </div>
                                                                <div class="col-md-2 title">商品编码(不为空)</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="spbm"
                                                                           placeholder="商品编码" value="">
                                                                </div>
                                                                <div class="col-md-2 title">商品名称</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="spmc"
                                                                           placeholder="商品名称" value="">
                                                                </div>
                                                                <div class="col-md-2 title">商品型号</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="xh"
                                                                           placeholder="商品型号" value="">
                                                                </div>
                                                                <div class="col-md-2 title">计量单位</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="dw"
                                                                           placeholder="计量单位" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">数量</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="sl"
                                                                           placeholder="数量" value="0">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">税率(%)</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name=shuilv"
                                                                           placeholder="税率" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">规格</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="gg"
                                                                           placeholder="规格" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">无税单价</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="wsdj">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">含税单价</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="hsdj">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">无税金额</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="wsje">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">含税金额</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="hsje">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">税额</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="se">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>

                                                                <div class="col-md-2 title">修改人</div>
                                                                <div class="col-md-4 data">
                                                                    <input  id="zzxgr" type="text" class="form-control" name="xgr"
                                                                           placeholder="修改人" value="">
                                                                </div>
                                                                <div class="col-md-2 title">修改日期</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group date">
                                                                        <div class="input-group-addon">
                                                                            <i class="fa fa-calendar"></i>
                                                                        </div>
                                                                        <input  id="zzxgrq" type="text" class="form-control pull-right dateTimePicker" name="xgrq">
                                                                    </div>
                                                                </div>
                                                                <%--外键id--%>
                                                                <input id="zib_zhub_id_input" type="hidden"
                                                                       value="" name="zid">
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
    function NoNull(x){
        var k = "";
        if(x == null){
            return k;
        }else{
            return x;
        }
    }


    /*发表单查询*/
    $(document).ready(function () {

        /*start*/
        //功能：主表：点击查询按钮，根据主表一部分信息查询出所有满足的主表集合
        $("#query").click(function () {
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/cgyg/findByAllAndSfspIsZero",
                type: "post",
                data: params,
                dataType: "json",
                async: false,
                success: function (data) {
                    //清除$("#zhub_tbody")里面的内容
                    $("#zhub_tbody").innerHTML = '';
                    var xsdd_zhubs = data;
                    var html = '';
                    for (var i = 0; i < xsdd_zhubs.length; i++) {
                        var a = FormatTime(xsdd_zhubs[i].qgrq);
                        var k;
                        var q;
                        var  w;
                        var xgrq = FormatTime(xsdd_zhubs[i].xgrq);
                        var sprq = FormatTime(xsdd_zhubs[i].sprq);
                        var zdrq = FormatTime(xsdd_zhubs[i].zdrq);

                        if (xsdd_zhubs[i].isth == 0){
                            k = "否";
                        }else{
                            if (xsdd_zhubs[i].isth==1){
                                k="是";
                            }
                            else {
                                k="";
                            }
                        }
                        if (xsdd_zhubs[i].djzt == 0){
                            q = "否";
                        }else{
                            if (xsdd_zhubs[i].djzt==1){
                                q="是";
                            }
                            else {
                                q="";
                            }
                        }
                        if (xsdd_zhubs[i].issp == 0){
                            w = "否";
                        }else{
                            if (xsdd_zhubs[i].issp==1){
                                w="是";
                            }
                            else {
                                w="";
                            }
                        }
                        html += '<tr>\n' +
                            '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhub_ids" type="checkbox" value="' + xsdd_zhubs[i].cgqgdzhubid + '"></td>\n' +
                            '<td><button i="' + i + '" ddh="' + xsdd_zhubs[i].djh+ '" checked="" ondblclick="find_zib(this)" zhubId="' + xsdd_zhubs[i].cgqgdzhubid + '" style="width: 100%;height: 99%">' + xsdd_zhubs[i].djh + '</button></td>\n' +
                            '<td>' + xsdd_zhubs[i].gs + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].qggys + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].cgbm + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].cgr + '</td>\n' +
                            '<td>'+a+'</td>\n' +
                            '<td>' + k+ '</td>\n' +
                            '<td>' + xsdd_zhubs[i].bz + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].zdsl + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].spr) + '</td>\n' +
                            '<td>' + sprq + '</td>\n' +
                            '<td>' + w+ '</td>\n' +
                            '<td>' + q + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].zdr) + '</td>\n' +
                            '<td>' + zdrq + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].xgr) + '</td>\n' +
                            '<td>' + xgrq + '</td>\n' +
                            '<td class="text-center">\n' +
                            '<button id="zhub_xg_btn" i=' + i + ' onclick="zhub_xg_btn(this)" zhubId="' + xsdd_zhubs[i].cgqgdzhubid + '" type="button" data-toggle="modal" data-target="#myModal-zhub-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                            '                                                            <div class="panel-heading">修改销售采购单主单</div>\n' +
                            '                                                            <div class="row data-type">\n' +
                            '\n' +                                                           /* 此处是 标记一个主表的id属性，方便根据id更新主表zhub*/
                            '                                                                <input id="cgddzhub_id-' + i + '" type="hidden" name="cgqgdzhubid" value="">\n' +
                            '                                                                \n' +
                            '                                                                <div class="col-md-2 title">单据号</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_djh-' + i + '" readonly="readonly" type="text"\n' +
                            '                                                                           class="form-control" name="djh"\n' +
                            '                                                                           placeholder="单据号" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">请购日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input id="cgddzhub_ddrq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker"\n' +
                            '                                                                               name="qgrq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">公司</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_gs-' + i + '" type="text" class="form-control" name="gs"\n' +
                            '                                                                           placeholder="公司" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">请购供应商</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_gys-' + i + '" type="text" class="form-control" onblur="gysname(this)" name="qggys"\n' +
                            '                                                                           placeholder="请购供应商" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">采购部门</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_cgbm-' + i + '" type="text" class="form-control" name="cgbm"\n' +
                            '                                                                           placeholder="采购部门" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">采购人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_cgr-' + i + '" type="text" class="form-control" name="cgr"\n' +
                            '                                                                           placeholder="采购人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">制单人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_zdr-' + i + '" type="text" class="form-control" name="zdr"\n' +
                            '                                                                           placeholder="制单人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">制单日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input id="cgddzhub_zdrq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker"\n' +
                            '                                                                               name="zdrq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">审批人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input readonly="readonly" id="cgddzhub_spr-' + i + '" type="text" class="form-control" name="spr"\n' +
                            '                                                                           placeholder="审批人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">审批日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input readonly="readonly" id="cgddzhub_sprq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker"' +
                            '                                                                               name="sprq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">是否审批</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select class="form-control" name="issp">\n' +
                            '                                                                        <option id="cgddzhub_issp_option-' + i + '" value="0">否</option>\n' +
                            '                                                                    </select>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">审批是否通过</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select class="form-control" name="spsftg">\n' +
                            '                                                                        <option id="cgddzhub_spsftg_option-' + i + '" value="0">否</option>\n' +
                            '                                                                    </select>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">修改人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input  id="cgddzhub_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                            '                                                                           placeholder="修改人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">修改日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input  id="cgddzhub_xgrq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker"\n' +
                            '                                                                               name="xgrq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +

                            '                                                                <div class="col-md-2 title">整单税率(%)</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_zdsl-' + i + '" type="text" class="form-control" name="zdsl"\n' +
                            '                                                                           placeholder="整单税率(%)" value="">\n' +
                            '                                                                </div>\n' +


                            '                                                                <div class="col-md-2 title">币种</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="cgddzhub_bz-' + i + '" type="text" class="form-control" name="bz"\n' +
                            '                                                                           placeholder="币种" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">状态</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select class="form-control" name="status">\n' +
                            '                                                                        <option id="cgddzhub_status_option1-' + i + '" value="0">没结束</option>\n' +
                            '                                                                        <option id="cgddzhub_status_option2-' + i + '" value="1">结束</option>\n' +
                            '                                                                    </select>\n' +
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
                            '<button zhubId="' + xsdd_zhubs[i].cgqgdzhubid + '" data-toggle="modal" data-target="#myModal_2" type="button" class="btn bg-olive btn-xs"\n' +
                            '    onclick="delete_zhub(this)">\n' +
                            '    删除\n' +
                            '</button>\n' +
                            '</td>\n' +
                            '</tr>';
                    }
                    $("#zhub_tbody").html(html);
                    $("#zhub_count").html("共 " + xsdd_zhubs.length + " 条记录");
                    $("#zhub_count").attr("count", xsdd_zhubs.length);
                },
                error: function () {
                    alert("查询失败！")
                }
            });
        });

        /*11*/
        //功能：子表：点击主表添加按钮触发，添加到模态框主表信息，先查询出行号，行号添加是从1开始递增
        $("#get_zib_hh").click(function () {
            var zhub_id = $("#zib_form").attr("zhub_id");
            var i = $("#zhub_xg_btn").attr("i");
            if (zhub_id == -1) {
                alert("请指定一个主表：单击主表中的预订单号按钮即可");
            } else {

                    $("#zib_zhub_id_input").attr("value", zhub_id);
                    $.ajax({
                        url: "${pageContext.request.contextPath}/cgyg/getZib_hh",
                        type: "get",
                        data: {"zid": zhub_id},
                        dataType: "text",
                        async: false,
                        success: function (data) {
                            var hh = data;
                            //赋值

                            $("#zibhh").attr("value", hh);
                        },
                        error: function () {
                            alert("no");
                        }
                    });
                }
                //把zhubid外键赋值给子表模态框的input里面


        });


        /*12*/
        //功能：子表：点击模拟框中的添加按钮触发请求，保存一个子表信息
        $("#zib_save").click(function () {
            var params = $("#zib_save_form").serialize();
            if ($("#zzxgr").val() == ""||$("#zzxgrq").val() == ""){
                alert("请输入修改人和修改日期");
            }else {
                $.ajax({
                    url: "${pageContext.request.contextPath}/cgyg/SaveZib",
                    type: "post",
                    data: params,
                    dataType: "text",
                    //async: false,
                    success: function () {
                        //添加主表信息到页面
                        $("#zib_refresh_btn").trigger("click");
                        alert("添加成功!")
                    },
                    error: function () {
                        alert("添加失败！")
                    }
                });
            }

        });
    });
    //显示日期格式化
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

    function gysname(x) {

        var gys = $(x).val();
        if (gys!=""){
            $.ajax({
                url: "${pageContext.request.contextPath}/cgyg/FindG",
                type: "POST",
                data: {"name":gys},
                dataType: "json",
                async: false,
                success: function (data) {
                    //添加主表信息到页面
                    if (data.msg === "Ok"){
                        $(x).css("border","");

                    }else {
                        alert(data.msg);
                        $(x).css("border","1px solid red");
                        $(x).val("");
                    }

                },
                error: function () {
                    alert("出现未知错误")
                }
            });
        }

    }
    /*1*/
    //功能：单击 主表中的 修改按钮，把该行的信息填充到模拟div中
    function zhub_xg_btn(x) {
        //alert("ok")
        var cgddzhub_id = $(x).attr("zhubId");
        $.ajax({
            url: "${pageContext.request.contextPath}/cgyg/findZhuById",
            type: "get",
            data: {"id": cgddzhub_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //alert("ok");
                var xsdd_zhub = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");
                //2,给每一个按钮框添加值
                $("#cgddzhub_id-" + i).attr("value", xsdd_zhub.cgqgdzhubid);
                $("#cgddzhub_djh-"+ i).attr("value",xsdd_zhub.djh);
                $("#cgddzhub_gs-"+i).attr("value",xsdd_zhub.gs);
                $("#cgddzhub_gys-"+i).attr("value",xsdd_zhub.qggys);
                $("#cgddzhub_cgbm-"+i).attr("value",xsdd_zhub.cgbm);
                $("#cgddzhub_cgr-"+i).attr("value",xsdd_zhub.cgr);
                $("#cgddzhub_ddrq-"+i).attr("value",FormatTime(xsdd_zhub.qgrq));
                $("#cgddzhub_bz-"+i).attr("value",xsdd_zhub.bz);
                $("#cgddzhub_zdsl-"+i).attr("value",xsdd_zhub.zdsl);
                $("#cgddzhub_spr-"+i).attr("value",xsdd_zhub.spr);
                $("#cgddzhub_sprq-"+i).attr("value",);
                $("#cgddzhub_zdr-"+i).attr("value",xsdd_zhub.zdr);
                $("#cgddzhub_zdrq-"+i).attr("value",FormatTime(xsdd_zhub.zdrq));



                //添加disabled="disabled" 注意：在提交表单的时候，需要把disabled移除，不然提交不了数据
                //zhub_xg_select_status-'+i+'
                // $("#zhub_xg_select_thbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_fhbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_ckbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_kpbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_ysbz-" + i).attr("disabled", "disabled");
                // $("#zhub_xg_select_status-" + i).attr("disabled", "disabled");

                if (xsdd_zhub.status == 1) {
                    $("#cgddzhub_status_option2-" + i).attr("selected", "selected");
                } else {
                    $("#cgddzhub_status_option1-" + i).attr("selected", "selected");
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
        if($("#cgddzhub_xgr-"+i).val() == ""||$("#cgddzhub_xgrq-"+i).val() == ""){
            alert("请输入修改人和修改日期 ");
        }else {
            var params = $("#zhub_xg_form-" + i).serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/cgyg/UpdateZhuB",
                type: "post",
                data: params,
                dataType: "text",
                // async: false,
                success: function () {
                    $("#query").trigger("click");
                    alert("修改成功，请重新查询！");
                },
                error: function () {
                    alert("status状态已经关闭,不能修改!")
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
            var xsdd_zhub_id = $(x).attr("zhubId");
            $.ajax({
                url: "${pageContext.request.contextPath}/cgyg/DeleteZhuB",
                type: "GET",
                data: {"id": xsdd_zhub_id},
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
                        if (id == xsdd_zhub_id) {
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
            var inputs = document.getElementsByName("zhub_ids");
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
            if (ids = ""){
                alert("请选择要删除的表");
            }else{
                $.ajax({
                    url: "${pageContext.request.contextPath}/cgyg/DeleteZhuBs",
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
    }

    /*7*/
    //功能：双击主表总ddh按钮触发，根据主表的id查询所有的子表信息，并添加到子表
    function find_zib(x) {
        //移除属性checked
        $(".my-checkbox").removeAttr('checked');
        //把当前设置为true
        var i = $(x).attr("i");
        $("#checkbox-pos-" + i).prop("checked", true);
        //获取id
        var xsdd_zhub_id = $(x).attr("zhubId");
        //获取ddh:对应了子表上面的 单据号：input[xxx],将单据号添加到里面显示，方便查看
        var djh = $(x).attr("ddh");
        $.ajax({
            url: "${pageContext.request.contextPath}/cgyg/findZiByZhuId",
            type: "GET",
            data: {"zid": xsdd_zhub_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //先清除$("#zib_tbody")里面的内容
                $("#zib_tbody").innerHTML = '';
                //给子表form的zhub_id赋值
                $("#zib_form").attr("zhub_id", xsdd_zhub_id);
                /*单据号：<input id="djh"...*/
                $("#djh").attr("value", djh);
                //添加内容
                xsdd_zibs = data;
                var html = '';
                for (var i = 0; i < xsdd_zibs.length; i++) {

                    html += '<tr>\n' +
                        '<td><input name="zib_ids" type="checkbox" value="' + xsdd_zibs[i].cgqgdzhibid+ '"></td>\n' +
                        '<td>' + xsdd_zibs[i].hh + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].spbm) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].spmc) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].xh) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].xh) + '</td>\n' +
                        '<td>' + xsdd_zibs[i].sl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].shuilv + '</td>\n' +
                        '<td>' + xsdd_zibs[i].wsdj + '</td>\n' +
                        '<td>' + xsdd_zibs[i].hsdj + '</td>\n' +
                        '<td>' + xsdd_zibs[i].wsje + '</td>\n' +
                        '<td>' + xsdd_zibs[i].hsje + '</td>\n' +
                        '<td>' + xsdd_zibs[i].se + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].gg) + '</td>\n' +
                        '<td class="text-center">\n' +
                        '<button id="zib_xg_btn" i="' + i + '" zibId="' + xsdd_zibs[i].cgqgdzhibid+ '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                        '                                                            <div class="panel-heading">销售订单子单</div>\n' +
                        '                                                            <div class="row data-type">\n' +
                        '                        <input id="cgddzhib_zid-' + i + '" type="hidden" name="zid" value="">\n' + /*主表id--》外键*/
                        '                        <input id="cgddzhib_id-' + i + '" type="hidden" name="cgqgdzhibid" value="">\n' + /*子表id*/
                        '                        <div class="col-md-2 title">行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="cgddzhib_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                        '                                   placeholder="行号" value="">\n' +
                        '                        </div>\n' +

                        '                        <div class="col-md-2 title">规格</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="cgddzhib_gg-' + i + '" type="text"  class="form-control" name="gg"\n' +
                        '                                   placeholder="规格" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">商品编号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="cgddzhib_spbm-' + i + '" type="text" class="form-control" name="spbm"\n' +
                        '                                   placeholder="商品编号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">商品名称</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="cgddzhib_spmc-' + i + '" type="text" class="form-control" name="spmc"\n' +
                        '                                   placeholder="商品名称" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">型号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="cgddzhib_xh-' + i + '" type="text" class="form-control" name="xh"\n' +
                        '                                   placeholder="型号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">计量单位</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="cgddzhib_dw-' + i + '" type="text" class="form-control" name="dw"\n' +
                        '                                   placeholder="计量单位" value="">\n' +
                        '                        </div>\n' +
                        '                            <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">数量</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="cgddzhib_sl-' + i + '" type="text" class="form-control" name="sl"\n' +
                        '                                   placeholder="数量" value="">\n' +
                        '                        </div>\n' +
                        '                            <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">税率(%)</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="cgddzhib_shuilv-' + i + '" type="text" class="form-control" name="shuilv"\n' +
                        '                                   placeholder="税率" value="">\n' +
                        '                        </div>\n' +
                        '                            <div class="col-md-2 title"></div>\n' +

                        '                        <div class="col-md-2 title">无税单价</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="cgddzhib_wsdj-' + i + '" type="text" class="form-control" name="wsdj">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">含税单价</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="cgddzhib_hsdj-' + i + '" type="text" class="form-control" name="hsdj">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">无税金额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="cgddzhib_wsje-' + i + '" type="text" class="form-control" name="wsje">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">含税金额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="cgddzhib_hsje-' + i + '" type="text" class="form-control" name="hsje">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">税额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="cgddzhib_se-' + i + '" type="text" class="form-control" name="se">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +

                        '                          <div class="col-md-2 title">修改人</div>\n' +
                        '                              <div class="col-md-4 data">\n' +
                        '                                  <input  id="cgddzhib_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                        '                                        placeholder="修改人" value="">\n' +
                        '                               </div>\n' +
                        '                        <div class="col-md-2 title">修改日期</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                           <div class="input-group date">\n' +
                        '                                 <div class="input-group-addon">\n' +
                        '                                      <i class="fa fa-calendar"></i>\n' +
                        '                                  </div>\n' +
                        '                               <input  id="cgddzhib_xgrq-' + i + '" type="text"\n' +
                        '                                   class="form-control pull-right dateTimePicker"\n' +
                        '                                   name="xgrq">\n' +
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
                        '                                        <button zibId="' + xsdd_zibs[i].cgqgdzhibid + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                        '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                                <!-- /.modal-content -->\n' +
                        '                            </div>\n' +
                        '\n' +
                        '                            <!-- /.modal-dialog -->\n' +
                        '                        </div>' +
                        <%--模拟窗口/--%>
                        '<button zibId="' + xsdd_zibs[i].cgqgdzhibid + '" type="button" class="btn bg-olive btn-xs"\n' +
                        '    onclick="delete_zib(this)">\n' +
                        '    删除\n' +
                        '</button>\n' +
                        '</td>\n' +
                        '</tr>';
                }
                $("#zib_tbody").html(html);
                $("#zib_count").attr("count", xsdd_zibs.length);
                $("#zib_count").html("共 " + xsdd_zibs.length + " 条记录");
            },
            error: function () {
                alert("查询失败！")
            }
        });
    }

    /*8*/
    //功能：单击 子表中的 修改按钮，把该行的信息填充到模拟div中
    function zib_xg_btn(x) {
        var xsdd_zib_id = $(x).attr("zibId");
        $.ajax({
            url: "${pageContext.request.contextPath}/cgyg/findZiById",
            type: "get",
            data: {"id": xsdd_zib_id},
            dataType: "json",
            async: false,
            success: function (data) {
                var xsdd_zib = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");

                    //2,给每一个按钮框添加值
                    $("#cgddzhib_zid-" + i).attr("value", xsdd_zib.zid); /*主表d --》外键*/
                    $("#cgddzhib_id-" + i).attr("value", xsdd_zib.cgqgdzhibid);/*子表id*/
                    $("#cgddzhib_hh-" + i).attr("value", xsdd_zib.hh);
                    $("#cgddzhib_spbm-" + i).attr("value", xsdd_zib.spbm);
                    $("#cgddzhib_spmc-" + i).attr("value", xsdd_zib.spmc);
                    $("#cgddzhib_xh-" + i).attr("value", xsdd_zib.xh);
                    $("#cgddzhib_dw-" + i).attr("value", xsdd_zib.dw);
                    $("#cgddzhib_sl-" + i).attr("value", xsdd_zib.sl);
                    $("#cgddzhib_shuilv-" + i).attr("value", xsdd_zib.shuilv);
                    $("#cgddzhib_wsdj-" + i).attr("value", xsdd_zib.wsdj);
                    $("#cgddzhib_hsdj-" + i).attr("value", xsdd_zib.hsdj);
                    $("#cgddzhib_wsje-" + i).attr("value", xsdd_zib.wsje);
                    $("#cgddzhib_hsje-" + i).attr("value", xsdd_zib.hsje);
                    $("#cgddzhib_se-" + i).attr("value", xsdd_zib.se);
                    $("#cgddzhib_gg-" + i).attr("value", xsdd_zib.gg);



                    /*设置包括下面select的不可以选择*/
                    //zib_xg_select_sfskgb
                    // $("#zib_xg_select_sffhgb-" + i).attr("disabled", "disabled");
                    // $("#zib_xg_select_sfckgb-" + i).attr("disabled", "disabled");
                    // $("#zib_xg_select_sfkpgb-" + i).attr("disabled", "disabled");
                    // $("#zib_xg_select_sfskgb-" + i).attr("disabled", "disabled");
                    // $("#zib_xg_select_status-" + i).attr("disabled", "disabled");
                    /*设置值*/




            },
            error: function () {
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

        var  kk = 0;
        if($("#cgddzhib_xgr-"+i).val() == ""||$("#cgddzhib_xgrq-"+i).val() == ""){
            alert("请输入修改人和修改日期")
        }else {
            if (kk == 0){
                $.ajax({
                    url: "${pageContext.request.contextPath}/cgyg/UpdateZhiB",
                    type: "post",
                    data: params,
                    dataType: "text",
                    // async: false,
                    success: function () {
                        $("#zib_refresh_btn").trigger("click");
                        alert("修改成功！");
                    },
                    error: function () {
                        alert("修改失败！")
                    }
                });
            }else {
                alert("请输入关闭人和关闭日期");
            }

        }

    }

    /*10*/
    //功能：单击子表总右边的删除按钮，删除子表 by id
    function delete_zib(x) {
        var msg = "是否确认删除?";
        if (confirm(msg) == true) {
            var zibId = $(x).attr("zibId");
            $.ajax({
                url: "${pageContext.request.contextPath}/cgyg/DeleteZhiB",
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
                url: "${pageContext.request.contextPath}/cgyg/DeleteZhiBs",
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
        var zhub_id = $("#zib_form").attr("zhub_id");
        if (zhub_id != -1) {
            $.ajax({
                url: "${pageContext.request.contextPath}/cgyg/findZiByZhuId",
                type: "GET",
                data: {"zid": zhub_id},
                dataType: "json",
                async: false,
                success: function (data) {
                    //先清除$("#zib_tbody")里面的内容
                    $("#zib_tbody").innerHTML = '';
                    //添加内容
                    xsdd_zibs = data;
                    var html = '';
                    for (var i = 0; i < xsdd_zibs.length; i++) {
                        html += '<tr>\n' +
                            '<td><input name="zib_ids" type="checkbox" value="' + xsdd_zibs[i].cgqgdzhibid+ '"></td>\n' +
                            '<td>' + xsdd_zibs[i].hh + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].spbm) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].spmc) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].xh) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].xh) + '</td>\n' +
                            '<td>' + xsdd_zibs[i].sl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].shuilv + '</td>\n' +
                            '<td>' + xsdd_zibs[i].wsdj + '</td>\n' +
                            '<td>' + xsdd_zibs[i].hsdj + '</td>\n' +
                            '<td>' + xsdd_zibs[i].wsje + '</td>\n' +
                            '<td>' + xsdd_zibs[i].hsje + '</td>\n' +
                            '<td>' + xsdd_zibs[i].se + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].gg) + '</td>\n' +
                            '<td class="text-center">\n' +
                            '<button id="zib_xg_btn" i="' + i + '" zibId="' + xsdd_zibs[i].cgqgdzhibid+ '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                            '                                                            <div class="panel-heading">销售订单子单</div>\n' +
                            '                                                            <div class="row data-type">\n' +
                            '                        <input id="cgddzhib_zid-' + i + '" type="hidden" name="zid" value="">\n' + /*主表id--》外键*/
                            '                        <input id="cgddzhib_id-' + i + '" type="hidden" name="cgqgdzhibid" value="">\n' + /*子表id*/
                            '                        <div class="col-md-2 title">行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="cgddzhib_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                            '                                   placeholder="行号" value="">\n' +
                            '                        </div>\n' +

                            '                        <div class="col-md-2 title">规格</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="cgddzhib_gg-' + i + '" type="text" readonly="readonly"  class="form-control" name="gg"\n' +
                            '                                   placeholder="规格" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">商品编号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="cgddzhib_spbm-' + i + '" type="text" class="form-control" name="spbm"\n' +
                            '                                   placeholder="商品编号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">商品名称</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="cgddzhib_spmc-' + i + '" type="text" class="form-control" name="spmc"\n' +
                            '                                   placeholder="商品名称" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">型号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="cgddzhib_xh-' + i + '" type="text" class="form-control" name="xh"\n' +
                            '                                   placeholder="型号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">计量单位</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="cgddzhib_dw-' + i + '" type="text" class="form-control" name="dw"\n' +
                            '                                   placeholder="计量单位" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">数量</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="cgddzhib_sl-' + i + '" type="text" class="form-control" name="sl"\n' +
                            '                                   placeholder="数量" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">税率(%)</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="cgddzhib_shuilv-' + i + '" type="text" class="form-control" name="shuilv"\n' +
                            '                                   placeholder="税率" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +

                            '                        <div class="col-md-2 title">无税单价</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="cgddzhib_wsdj-' + i + '" type="text" class="form-control" name="wsdj">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">含税单价</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="cgddzhib_hsdj-' + i + '" type="text" class="form-control" name="hsdj">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">无税金额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="cgddzhib_wsje-' + i + '" type="text" class="form-control" name="wsje">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">含税金额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="cgddzhib_hsje-' + i + '" type="text" class="form-control" name="hsje">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">税额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="cgddzhib_se-' + i + '" type="text" class="form-control" name="se">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +

                            '                          <div class="col-md-2 title">修改人</div>\n' +
                            '                              <div class="col-md-4 data">\n' +
                            '                                  <input  id="cgddzhib_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                            '                                        placeholder="修改人" value="">\n' +
                            '                               </div>\n' +
                            '                        <div class="col-md-2 title">修改日期</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                           <div class="input-group date">\n' +
                            '                                 <div class="input-group-addon">\n' +
                            '                                      <i class="fa fa-calendar"></i>\n' +
                            '                                  </div>\n' +
                            '                               <input  id="cgddzhib_xgrq-' + i + '" type="text"\n' +
                            '                                   class="form-control pull-right dateTimePicker"\n' +
                            '                                   name="xgrq">\n' +
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
                            '                                        <button zibId="' + xsdd_zibs[i].cgqgdzhibid + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                            '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                                <!-- /.modal-content -->\n' +
                            '                            </div>\n' +
                            '\n' +
                            '                            <!-- /.modal-dialog -->\n' +
                            '                        </div>' +
                            <%--模拟窗口/--%>
                            '<button zibId="' + xsdd_zibs[i].cgqgdzhibid + '" type="button" class="btn bg-olive btn-xs"\n' +
                            '    onclick="delete_zib(this)">\n' +
                            '    删除\n' +
                            '</button>\n' +
                            '</td>\n' +
                            '</tr>';

                    }
                    $("#zib_tbody").html(html);
                    $("#zib_count").attr("count", xsdd_zibs.length);
                    $("#zib_count").html("共 " + xsdd_zibs.length + " 条记录");
                },
                error: function () {
                    alert("查询失败！")
                }
            });
        }
    }
</script>


</body>

</html>


