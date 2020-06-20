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
    <title>销售订单审批</title>
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

                采购订单-审批
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
                    <a href="#">订单管理</a>
                </li>
                <li class="active">审批</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <%--查询部分--%>
        <%-- id = query 按钮查询--%>
        <form id="form" method="post">
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">查询(未审批或者已审批)</div>
                    <div class="row data-type">
                        <%--1--%>
                            <div class="col-md-2 title">订单ID</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="cgddzhubid"
                                       placeholder="订单ID" value="">
                            </div>
                            <div class="col-md-2 title">订单日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right dateTimePicker" name="ddrq">
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
                            <div class="col-md-2 title">供应商</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="gys"
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

                            <div class="col-md-2 title">是否退货</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="isth">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>

                            <div class="col-md-2 title">解冻人</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="jdr"
                                       placeholder="解冻人" value="">
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

                            <div class="col-md-2 title">冻结状态</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="djzt">

                                    <option value="0">否</option>
                                </select>
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
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">审批是否通过</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="spsftg">
                                    <option selected="selected" value="-1">全部</option>
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
                            <div class="col-md-2 title">失效日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right"
                                           name="sxrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">业务员</div>
                            <div class="col-md-4 data">
                                <input  type="text" class="form-control" name="ywy"
                                        placeholder="业务员" value="">
                            </div>
                            <div class="col-md-2 title">开票单位</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="kpdw"
                                       placeholder="开票单位" value="">
                            </div>
                            <%--8--%>
                            <div class="col-md-2 title">到货地区</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="dhdq"
                                       placeholder="到货地区" value="">
                            </div>
                            <div class="col-md-2 title">到货地址</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="dhdz"
                                       placeholder="到货地址" value="">
                            </div>
                            <%--9--%>
                            <div class="col-md-2 title">整单价税合计</div>
                            <div class="col-md-4 data">
                                <div class="input-group">
                                    <span class="input-group-addon">¥</span>
                                    <input type="text" class="form-control"
                                           name="zdshj">
                                    <span class="input-group-addon">元</span>
                                </div>
                            </div>

                            <%--11--%>
                            <div class="col-md-2 title">是否到货结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="dhbz">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">是否入库结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="rkbz">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <%--12--%>
                            <div class="col-md-2 title">是否开票结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="kpbz">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">是否收款结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="ysbz">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
                    </div>
                </div>
                <!--订单信息/--> <!--工具栏-->
                <div class="box-tools <%--text-center --%>text-right">
                    <button id="query" type="button" class="btn <%--bg-maroon--%> bg-red">搜索</button>
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
                    <th class="text-center sorting" width="200px">供应商</th>
                    <th class="text-center sorting" width="200px">采购部门</th>
                    <th class="text-center sorting" width="200px">采购人</th>
                    <th class="text-center sorting" width="200px">是否退货</th>
                    <th class="text-center sorting" width="200px">解冻人</th>
                    <th class="text-center sorting" width="200px">订单日期</th>
                    <th class="text-center sorting" width="200px">状态</th>
                    <th class="text-center sorting" width="200px">币种</th>
                    <th class="text-center sorting" width="200px">整单税率(%)</th>
                    <th class="text-center sorting" width="200px">冻结状态</th>
                    <th class="text-center sorting" width="200px">审批人</th>
                    <th class="text-center sorting" width="200px">审批日期</th>
                    <th class="text-center sorting" width="200px">是否审批</th>
                    <th class="text-center sorting" width="200px">审批是否通过</th>
                    <th class="text-center sorting" width="200px">制单人</th>
                    <th class="text-center sorting" width="200px">制单日期</th>
                    <th class="text-center sorting" width="200px">修改人</th>
                    <th class="text-center sorting" width="200px">修改日期</th>
                    <th class="text-center sorting" width="200px">失效日期</th>
                    <th class="text-center sorting" width="200px">业务员</th>
                    <th class="text-center sorting" width="200px">整单价税合计</th>
                    <th class="text-center sorting" width="200px">到货是否结束</th>
                    <th class="text-center sorting" width="200px">入库是否结束</th>
                    <th class="text-center sorting" width="200px">开票是否结束</th>
                    <th class="text-center sorting" width="200px">收款是否结束</th>
                    <th class="text-center sorting" width="200px">开票单位</th>
                    <th class="text-center sorting" width="200px">到货地区</th>
                    <th class="text-center sorting" width="200px">到货地址</th>
                    </thead>
                    <%--内容--%>
                    <tbody id="zhub_tbody">
                    </tbody>
                </table>
            </div>
            <span id="zhub_count" count="">共 0 条记录</span>
        </from>
        <br>
        <br>
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
                    <th class="text-center sorting" width="350px">行关闭</th>
                    <th class="text-center sorting" width="350px">关闭人</th>
                    <th class="text-center sorting" width="350px">关闭日期</th>
                    <th class="text-center sorting" width="350px">规格</th>
                    <th class="text-center sorting" width="350px">赠品</th>
                    <th class="text-center sorting" width="350px">来源单据</th>
                    <th class="text-center sorting" width="350px">累计退货数量</th>
                    <th class="text-center sorting" width="350px">行状态</th>
                    <th class="text-center sorting" width="350px">收货仓库</th>
                    <th class="text-center sorting" width="350px">到货单位</th>
                    <th class="text-center sorting" width="350px">计划发货日期</th>
                    <th class="text-center sorting" width="350px">要求收货日期</th>
                    <th class="text-center sorting" width="350px">应发未出库数量</th>
                    <th class="text-center sorting" width="350px">累计到货数量</th>
                    <th class="text-center sorting" width="350px">累计入库数量</th>
                    <th class="text-center sorting" width="350px">累计开票数量</th>
                    <th class="text-center sorting" width="350px">累计应收数量</th>
                    <th class="text-center sorting" width="350px">是否到货关闭</th>
                    <th class="text-center sorting" width="350px">是否入库关闭</th>
                    <th class="text-center sorting" width="350px">是否开票关闭</th>
                    <th class="text-center sorting" width="350px">是否付款结束</th>
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
                        <button onclick="refresh(this)" type="button" class="btn btn-default"
                                title="刷新"><i
                                class="fa fa-refresh"></i> 刷新
                        </button>
                    </div>
                    <span id="zib_count" count="">共 0 条记录</span>
                </div>
            </div>
            <%--工具栏/--%>
        </from>
        <br>
        <br>
        <div class="panel panel-default">
            <div class="row data-type">
                <div class="col-md-2 title">审批人</div>
                <div class="col-md-4 data">
                    <input id="sp_spr" type="text" class="form-control"
                           placeholder="审批人" value="">
                </div>
                <div class="col-md-2 title">审批日期</div>
                <div class="col-md-4 data">
                    <div class="input-group date">
                        <div class="input-group-addon">
                            <i class="fa fa-calendar"></i>
                        </div>
                        <input id="sp_sprq" type="text" class="form-control pull-right dateTimePicker" value="">
                    </div>
                </div>
            </div>
        </div>
        <%--工具栏--%>
        <div class="pull-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <button id="sp_forbidden_btn" onclick="sp_forbidden(this)" type="button" class="btn bg-red">审批禁止</button>
                </div>
            </div>
        </div>
        <div class="pull-right">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <button id="sp_adopt_btn" onclick="sp_adopt(this)" type="button" class="btn bg-green">审批通过</button>
                </div>
            </div>
        </div>
        <%--工具栏/--%>
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

    function statusbe(x){
        if (x == 1){
            return "结束";
        }
        if (x == 0){
            return "没结束";
        }
        return "";
    }
    /*发表单查询*/
    $(document).ready(function () {

        /*start*/
        //功能：主表：点击查询按钮，根据主表一部分信息查询出所有满足的主表集合
        $("#query").click(function () {
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/cgdd/findByAllAndSfspIsZero",
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
                        var a = FormatTime(xsdd_zhubs[i].ddrq);
                        var k;
                        var q;
                        var  w;
                        var s;
                        var m;
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
                        if (xsdd_zhubs[i].spsftg == 0){
                            m = "否";
                        }else{
                            if (xsdd_zhubs[i].spsftg==1){
                                m="是";
                            }
                            else {
                                m="";
                            }
                        }
                        if (xsdd_zhubs[i].status == 0){
                            s = "没结束";
                        }else{
                            if (xsdd_zhubs[i].status==1){
                                s="结束";
                            }
                            else {
                                s="";
                            }
                        }
                        html += '<tr>\n' +
                            '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhub_ids" type="checkbox" value="' + xsdd_zhubs[i].cgddzhubid + '"></td>\n' +
                            '<td><button i="' + i + '" ddh="' + xsdd_zhubs[i].djh + '" checked="" ondblclick="find_zib(this)" zhubId="' + xsdd_zhubs[i].cgddzhubid + '" style="width: 100%;height: 99%">' + xsdd_zhubs[i].djh + '</button></td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].gs) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].gys )+ '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].cgbm ) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].cgr) + '</td>\n' +
                            '<td>' + k + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].jdr) + '</td>\n' +
                            '<td>'+a+'</td>\n' +
                            '<td>' + s+ '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].bz) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].zdsl) + '</td>\n' +
                            '<td>' + q + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].spr) + '</td>\n' +
                            '<td>' + sprq + '</td>\n' +
                            '<td>' + w+ '</td>\n' +
                            '<td>' + m+ '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].zdr) + '</td>\n' +
                            '<td>' + zdrq + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].xgr )+ '</td>\n' +
                            '<td>' + xgrq + '</td>\n' +
                            '<td>' + FormatTime(xsdd_zhubs[i].sxrq) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zhubs[i].ywy)+ '</td>\n' +
                            '<td>' +NoNull(xsdd_zhubs[i].zdshj)  + '</td>\n' +
                            '<td>' + statusbe(xsdd_zhubs[i].dhbz) + '</td>\n' +
                            '<td>' + statusbe(xsdd_zhubs[i].rkbz) + '</td>\n' +
                            '<td>' + statusbe(xsdd_zhubs[i].kpbz) + '</td>\n' +
                            '<td>' + statusbe(xsdd_zhubs[i].ysbz) + '</td>\n' +
                            '<td>' +NoNull(xsdd_zhubs[i].kpdw)  + '</td>\n' +
                            '<td>' +NoNull(xsdd_zhubs[i].dhdq)  + '</td>\n' +
                            '<td>' +NoNull(xsdd_zhubs[i].dhdz)  + '</td>\n' +
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

    });


    //格式化时间
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
            url: "${pageContext.request.contextPath}/cgdd/findZiByZhuId",
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
                    var hgb;
                    var hstatus;
                    if(xsdd_zibs[i].hgb==1){
                        hgb = "是"
                    }else {
                        if(xsdd_zibs[i].hgb == 0){
                            hgb="否"
                        }else{
                            hgb=""
                        }
                    }
                    if(xsdd_zibs[i].hstatus==1){
                        hstatus = "是"
                    }else {
                        if(xsdd_zibs[i].hstatus == 0){
                            hstatus="否"
                        }else{
                            hstatus=""
                        }
                    }
                    html += '<tr>\n' +
                        '<td><input name="zib_ids" type="checkbox" value="' + xsdd_zibs[i].cgddzhibid + '"></td>\n' +
                        '<td>' + xsdd_zibs[i].hh + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].spbm) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].spmc) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].xh) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].dw) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].sl) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].shuilv) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].wsdj) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].hsdj) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].wsje) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].hsje) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].se) + '</td>\n' +
                        '<td>' + hgb + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].gbr) + '</td>\n' +
                        '<td>'+FormatTime(xsdd_zibs[i].gbrq)+'</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].gg) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].zp) + '</td>\n' +
                        '<td>' + xsdd_zibs[i].lydj + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].ljthsl) + '</td>\n' +
                        '<td>' + hstatus + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].shck) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].fhdw) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].jhfhrq) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].yqshrq) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].yfwrksl) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].ljdhsl) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].ljrksl) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].ljkpsl) + '</td>\n' +
                        '<td>' + NoNull(xsdd_zibs[i].ljyssl) + '</td>\n' +
                        '<td>' + statusbe(xsdd_zibs[i].sfdhgb) + '</td>\n' +
                        '<td>' + statusbe(xsdd_zibs[i].sfrkgb) + '</td>\n' +
                        '<td>' + statusbe(xsdd_zibs[i].sfkpgb) + '</td>\n' +
                        '<td>' + statusbe(xsdd_zibs[i].sffkgb) + '</td>\n' +
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

    /*14*/
    //功能： 单击 子表下面的刷新按钮触发，对子表进行刷新
    function refresh(x) {
        var zhub_id = $("#zib_form").attr("zhub_id");

        if (zhub_id != -1) {
            //获取id
            //获取ddh:对应了子表上面的 单据号：input[xxx],将单据号添加到里面显示，方便查看
            var djh = $("#djh").attr("value");
            $.ajax({
                url: "${pageContext.request.contextPath}/cgdd/findZiByZhuId",
                type: "GET",
                data: {"zid": zhub_id},
                dataType: "json",
                async: false,
                success: function (data) {
                    //先清除$("#zib_tbody")里面的内容
                    $("#zib_tbody").innerHTML = '';
                    xsdd_zibs = data;
                    //添加内容

                    var html = '';

                    for (var i = 0; i < xsdd_zibs.length; i++) {
                        var hgb;
                        var hstatus;
                        if(xsdd_zibs[i].hgb==1){
                            hgb = "是"
                        }else {
                            if(xsdd_zibs[i].hgb == 0){
                                hgb="否"
                            }else{
                                hgb=""
                            }
                        }
                        if(xsdd_zibs[i].hstatus==1){
                            hstatus = "是"
                        }else {
                            if(xsdd_zibs[i].hstatus == 0){
                                hstatus="否"
                            }else{
                                hstatus=""
                            }
                        }
                        html += '<tr>\n' +
                            '<td><input name="zib_ids" type="checkbox" value="' + xsdd_zibs[i].cgddzhibid + '"></td>\n' +
                            '<td>' + xsdd_zibs[i].hh + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].spbm) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].spmc) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].xh) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].dw) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].sl) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].shuilv) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].wsdj) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].hsdj) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].wsje) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].hsje) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].se) + '</td>\n' +
                            '<td>' + hgb + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].gbr) + '</td>\n' +
                            '<td>'+FormatTime(xsdd_zibs[i].gbrq)+'</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].gg) + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].zp) + '</td>\n' +
                            '<td>' + xsdd_zibs[i].lydj + '</td>\n' +
                            '<td>' + NoNull(xsdd_zibs[i].ljthsl) + '</td>\n' +
                            '<td>' + hstatus + '</td>\n' +
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

    function zib_xg_btn(x) {
        var xsdd_zib_id = $(x).attr("zibId");
        $.ajax({
            url: "${pageContext.request.contextPath}/cgdd/findZiById",
            type: "get",
            data: {"zibid": xsdd_zib_id},
            dataType: "json",
            async: false,
            success: function (data) {
                var xsdd_zib = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");
                //2,给每一个按钮框添加值
                $("#cgddzhib_zid-" + i).attr("value", xsdd_zib.zid); /*主表d --》外键*/
                $("#cgddzhib_id-" + i).attr("value", xsdd_zib.cgddzhibid);/*子表id*/
                $("#cgddzhib_hh-" + i).attr("value", xsdd_zib.hh);
                $("#cgddzhib_lydj-" + i).attr("value", xsdd_zib.lydj);
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
                $("#cgddzhib_gbr-" + i).attr("value", xsdd_zib.gbr);
                $("#cgddzhib_gbrq-" + i).attr("value", FormatTime(xsdd_zib.gbrq));
                $("#cgddzhib_zp-" + i).attr("value", xsdd_zib.zp);
                $("#cgddzhib_ljthsl-" + i).attr("value", xsdd_zib.ljthsl);
                $("#cgddzhib_gg-" + i).attr("value", xsdd_zib.gg);
                /*zp*/
                if (xsdd_zib.hgb == 1) {
                    $("#cgddzhib_hgb_option1-" + i).attr("selected", "selected");
                } else {
                    $("#cgddzhib_hgb_option0-" + i).attr("selected", "selected");
                }

                /*设置包括下面select的不可以选择*/
                //zib_xg_select_sfskgb
                // $("#zib_xg_select_sffhgb-" + i).attr("disabled", "disabled");
                // $("#zib_xg_select_sfckgb-" + i).attr("disabled", "disabled");
                // $("#zib_xg_select_sfkpgb-" + i).attr("disabled", "disabled");
                // $("#zib_xg_select_sfskgb-" + i).attr("disabled", "disabled");
                // $("#zib_xg_select_status-" + i).attr("disabled", "disabled");
                /*设置值*/
                if (xsdd_zib.hstatus == 1) {
                    $("#cgddzhib_hstatus_option1-" + i).attr("selected", "selected");
                } else {
                    $("#cgddzhib_hstatus_option0-" + i).attr("selected", "selected");
                }

            },
            error: function (data) {
                alert("无响应!");
            }
        });
    }
    function updateZibById(x) {
        //获取点击了该修改按钮所在的行号i
        var i = $(x).attr("i");
        //表单数据
        var params = $("#zib_xg_form-" + i).serialize();
        $.ajax({
            url: "${pageContext.request.contextPath}/cgdd/UpdateZhiB",
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
    }

    /*10*/
    //功能：单击子表总右边的删除按钮，删除子表 by id
    function delete_zib(x) {
        var msg = "是否确认删除?";
        if (confirm(msg) == true) {
            var zibId = $(x).attr("zibId");
            $.ajax({
                url: "${pageContext.request.contextPath}/cgdd/DeleteZhiB",
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
    //功能：审批禁止功能 ： 单击子表下面的 审批禁止按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 0;
    function sp_forbidden(x) {
        var ddh = $("#djh").attr("value");
        if(ddh.length <= 0 || ddh == null || ddh == undefined){
            alert("请选择要审批单据号进行审批!");
        }else {
            var msg = "确认审批禁止此订单?";
            if(confirm(msg) == true){
                var spr = $("#sp_spr").val();
                var sprq = $("#sp_sprq").val();
                if(spr.length <= 0 || spr == null || spr == undefined){
                    alert("请填写审批人!")
                }else {
                    if(sprq.length <= 0 || sprq == null || sprq == undefined){
                        alert("请填写审批日期!")
                    }else {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/cgdd/spNo",
                            type: "GET",
                            data: {"djh":ddh,"spr":spr,"sprq":sprq},
                            dataType: "json",
                            //async: false,
                            success: function (data) {
                                $("#query").trigger("click");
                                alert(data.msg);
                            },
                            error: function () {
                                alert("审批禁止失败,出现未知问题请联系管理员");
                            }
                        });
                    }
                }
            }
        }
    }

    //功能：审批通过功能 ： 单击子表下面的 审批通过按钮 触发，给已经选择的订单修改信息
    //在服务器 判断是否该订单已经审批 若是，则抛出异常，否则 修改订单中 sfsp 和 设置 spsftg = 1;
    function sp_adopt(x) {
        var ddh = $("#djh").attr("value");
        if(ddh.length <= 0 || ddh == null || ddh == undefined){
            alert("请选择要审批单据号进行审批!");
        }else {
            var msg = "确认审批通过此订单?";
            if(confirm(msg) == true) {
                var spr = $("#sp_spr").val();
                var sprq = $("#sp_sprq").val();
                if(spr.length <= 0 || spr == null || spr == undefined){
                    alert("请填写审批人!")
                }else {
                    if(sprq.length <= 0 || sprq == null || sprq == undefined){
                        alert("请填写审批日期!")
                    }else {
                        $.ajax({
                            url: "${pageContext.request.contextPath}/cgdd/spOk",
                            type: "GET",
                            data: {"djh":ddh,"spr":spr,"sprq":sprq},
                            dataType: "json",
                            //async: false,
                            success: function (data) {
                                $("#query").trigger("click");
                                alert(data.msg);
                            },
                            error: function () {
                                alert("审批通过失败,出现未知问题请联系管理");
                            }
                        });
                    }
                }
            }
        }
    }
</script>


</body>

</html>


