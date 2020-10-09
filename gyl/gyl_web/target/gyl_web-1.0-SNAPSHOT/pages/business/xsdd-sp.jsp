<%--
  Created by IntelliJ IDEA.
  User: HR
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
                销售订单-审批
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
                    <a href="#">销售管理</a>
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
                        <div class="col-md-2 title">订单号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="ddh"
                                   placeholder="订单号" value="">
                        </div>
                        <div class="col-md-2 title">定货日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right dateTimePicker" name="dhrq">
                            </div>
                        </div>
                        <%--2--%>
                        <div class="col-md-2 title">失效日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right dateTimePicker" name="sxrq">
                            </div>
                        </div>
                        <div class="col-md-2 title">客户名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="khmc"
                                   placeholder="客户名称" value="">
                        </div>
                        <%--3--%>
                        <div class="col-md-2 title">销售部门</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="xsbm"
                                   placeholder="销售部门" value="">
                        </div>
                        <div class="col-md-2 title">业务员</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="ywy"
                                   placeholder="业务员" value="">
                        </div>
                        <div class="col-md-2 title">审批人</div>
                        <div class="col-md-4 data">
                            <input readonly="readonly" type="text" class="form-control" name="spr"
                                   placeholder="审批人" value="">
                        </div>
                        <div class="col-md-2 title">审批日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input readonly="readonly" type="text" class="form-control pull-right" name="sprq">
                            </div>
                        </div>
                        <div class="col-md-2 title">是否审批</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="sfsp">
                                <option value="-1">全部</option>
                                <option value="1">是</option>
                                <option selected="selected" value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">审批是否通过</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="spsftg">
                                <option value="-1">全部</option>
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
                            <input readonly="readonly" type="text" class="form-control" name="xgr"
                                   placeholder="修改人" value="">
                        </div>
                        <div class="col-md-2 title">修改日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input readonly="readonly" type="text" class="form-control pull-right" name="xgrq">
                            </div>
                        </div>
                        <div class="col-md-2 title">整单扣率</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="zdks"
                                   placeholder="整单扣率" value="">
                        </div>
                        <div class="col-md-2 title">开票单位</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="kpdw"
                                   placeholder="开票单位" value="">
                        </div>
                        <%--8--%>
                        <div class="col-md-2 title">收货地区</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="shdq"
                                   placeholder="收货地区" value="">
                        </div>
                        <div class="col-md-2 title">收货地址</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="shdz"
                                   placeholder="收货地址" value="">
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
                        <div class="col-md-2 title">收现款金额</div>
                        <div class="col-md-4 data">
                            <div class="input-group">
                                <span class="input-group-addon">¥</span>
                                <input type="text" class="form-control"
                                       name="sxkje">
                                <span class="input-group-addon">元</span>
                            </div>
                        </div>
                        <%--10--%>
                        <div class="col-md-2 title">来源单据号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="lydjh"
                                   placeholder="来源单据号" value="">
                        </div>
                        <div class="col-md-2 title">是否退货</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="thbz">
                                <option selected="selected" value="-1">全部</option>
                                <option value="1">是</option>
                                <option value="0">否</option>
                            </select>
                        </div>
                        <%--11--%>
                        <div class="col-md-2 title">是否发货结束</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="fhbz">
                                <option value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">是否出库结束</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="ckbz">
                                <option value="0">否</option>
                            </select>
                        </div>
                        <%--12--%>
                        <div class="col-md-2 title">是否开票结束</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="kpbz">
                                <option value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">是否收款结束</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="ysbz">
                                <option value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">状态</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="status">
                                <option value="0">未结束</option>
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
                    <th class="text-center sorting" width="200px">定货日期</th>
                    <th class="text-center sorting" width="200px">失效日期</th>
                    <th class="text-center sorting" width="200px">客户名称</th>
                    <th class="text-center sorting" width="200px">销售部门</th>
                    <th class="text-center sorting" width="200px">业务员</th>
                    <th class="text-center sorting" width="200px">审批人</th>
                    <th class="text-center sorting" width="200px">审批日期</th>
                    <th class="text-center sorting" width="200px">是否审批</th>
                    <th class="text-center sorting" width="200px">审批是否通过</th>
                    <th class="text-center sorting" width="200px">制单人</th>
                    <th class="text-center sorting" width="200px">制单日期</th>
                    <th class="text-center sorting" width="200px">修改人</th>
                    <th class="text-center sorting" width="200px">修改日期</th>
                    <th class="text-center sorting" width="200px">整单扣率</th>
                    <th class="text-center sorting" width="200px">开票单位</th>
                    <th class="text-center sorting" width="200px">收货地区</th>
                    <th class="text-center sorting" width="200px">收货地址</th>
                    <th class="text-center sorting" width="200px">整单价税合计</th>
                    <th class="text-center sorting" width="200px">收现款金额</th>
                    <th class="text-center sorting" width="200px">来源单据号</th>
                    <th class="text-center sorting" width="200px">是否退货</th>
                    <th class="text-center sorting" width="200px">发货是否结束</th>
                    <th class="text-center sorting" width="200px">出库是否结束</th>
                    <th class="text-center sorting" width="200px">开票是否结束</th>
                    <th class="text-center sorting" width="200px">收款是否结束</th>
                    <th class="text-center sorting" width="200px">状态</th>
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
                    <th class="text-center sorting" width="350px">来源行号</th>
                    <th class="text-center sorting" width="350px">商品编号</th>
                    <th class="text-center sorting" width="350px">商品名称</th>
                    <th class="text-center sorting" width="350px">商品型号</th>
                    <th class="text-center sorting" width="350px">计量单位</th>
                    <th class="text-center sorting" width="350px">数量</th>
                    <th class="text-center sorting" width="350px">税率(%)</th>
                    <th class="text-center sorting" width="350px">单品扣率(%)</th>
                    <th class="text-center sorting" width="350px">无税单价</th>
                    <th class="text-center sorting" width="350px">含税单价</th>
                    <th class="text-center sorting" width="350px">无税金额</th>
                    <th class="text-center sorting" width="350px">含税金额</th>
                    <th class="text-center sorting" width="350px">税额</th>
                    <th class="text-center sorting" width="350px">折扣额</th>
                    <th class="text-center sorting" width="350px">发货仓库</th>
                    <th class="text-center sorting" width="350px">收货单位</th>
                    <th class="text-center sorting" width="350px">计划发货日期</th>
                    <th class="text-center sorting" width="350px">要求收货日期</th>
                    <th class="text-center sorting" width="350px">是否赠品</th>
                    <th class="text-center sorting" width="350px">应发未出库数量</th>
                    <th class="text-center sorting" width="350px">累计发货数量</th>
                    <th class="text-center sorting" width="350px">累计出库数量</th>
                    <th class="text-center sorting" width="350px">累计开票数量</th>
                    <th class="text-center sorting" width="350px">累计应收数量</th>
                    <th class="text-center sorting" width="350px">是否发货结束</th>
                    <th class="text-center sorting" width="350px">是否出库结束</th>
                    <th class="text-center sorting" width="350px">是否开票结束</th>
                    <th class="text-center sorting" width="350px">是否收款结束</th>
                    <th class="text-center sorting" width="350px">状态</th>
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

    /*发表单查询*/
    $(document).ready(function () {

        /*start*/
        //功能：主表：点击查询按钮，根据主表一部分信息查询出所有满足的主表集合
        $("#query").click(function () {
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/xsdd/findByXsdd_zhub",
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
                        html += '<tr>\n' +
                            '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhub_ids" type="checkbox" value="' + xsdd_zhubs[i].xsdd_zhub_id + '"></td>\n' +
                            '<td><button i="' + i + '" ddh="' + xsdd_zhubs[i].ddh + '" checked="" ondblclick="find_zib(this)" zhubId="' + xsdd_zhubs[i].xsdd_zhub_id + '" style="width: 100%;height: 99%">' + xsdd_zhubs[i].ddh + '</button></td>\n' +
                            '<td>' + xsdd_zhubs[i].dhrqStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].sxrqStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].khmc + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].xsbm + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].ywy + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].spr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].sprqStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].sfspStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].spsftgStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].zdr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].zdrqStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].xgr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].xgrqStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].zdks + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].kpdw + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].shdq + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].shdz + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].zdshj + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].sxkje + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].lydjh + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].thbzStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].fhbzStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].ckbzStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].kpbzStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].ysbzStr + '</td>\n' +
                            '<td>' + xsdd_zhubs[i].statusStr + '</td>\n' +
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
            url: "${pageContext.request.contextPath}/xsdd/findXsdd_zibByZhubId",
            type: "GET",
            data: {"xsdd_zhub_id": xsdd_zhub_id},
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
                        '<td><input name="zib_ids" type="checkbox" value="' + xsdd_zibs[i].xsdd_zib_id + '"></td>\n' +
                        '<td>' + xsdd_zibs[i].hh + '</td>\n' +
                        '<td>' + xsdd_zibs[i].lyhh + '</td>\n' +
                        '<td>' + xsdd_zibs[i].spbm + '</td>\n' +
                        '<td>' + xsdd_zibs[i].spmc + '</td>\n' +
                        '<td>' + xsdd_zibs[i].type + '</td>\n' +
                        '<td>' + xsdd_zibs[i].jldw + '</td>\n' +
                        '<td>' + xsdd_zibs[i].count + '</td>\n' +
                        '<td>' + xsdd_zibs[i].rate + '</td>\n' +
                        '<td>' + xsdd_zibs[i].dpkl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].wsdj + '</td>\n' +
                        '<td>' + xsdd_zibs[i].hsdj + '</td>\n' +
                        '<td>' + xsdd_zibs[i].wsje + '</td>\n' +
                        '<td>' + xsdd_zibs[i].hsje + '</td>\n' +
                        '<td>' + xsdd_zibs[i].se + '</td>\n' +
                        '<td>' + xsdd_zibs[i].zke + '</td>\n' +
                        '<td>' + xsdd_zibs[i].fhck + '</td>\n' +
                        '<td>' + xsdd_zibs[i].shdw + '</td>\n' +
                        '<td>' + xsdd_zibs[i].jhfhrqStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].yqshrqStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].zpStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].yfwcksl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].ljfhsl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].ljcksl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].ljkpsl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].ljyssl + '</td>\n' +
                        '<td>' + xsdd_zibs[i].sffhgbStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].sfckgbStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].sfkpgbStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].sfskgbStr + '</td>\n' +
                        '<td>' + xsdd_zibs[i].statusStr + '</td>\n' +
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
            $.ajax({
                url: "${pageContext.request.contextPath}/xsdd/findXsdd_zibByZhubId",
                type: "GET",
                data: {"xsdd_zhub_id": zhub_id},
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
                            '<td><input name="zib_ids" type="checkbox" value="' + xsdd_zibs[i].xsdd_zib_id + '"></td>\n' +
                            '<td>' + xsdd_zibs[i].hh + '</td>\n' +
                            '<td>' + xsdd_zibs[i].lyhh + '</td>\n' +
                            '<td>' + xsdd_zibs[i].spbm + '</td>\n' +
                            '<td>' + xsdd_zibs[i].spmc + '</td>\n' +
                            '<td>' + xsdd_zibs[i].type + '</td>\n' +
                            '<td>' + xsdd_zibs[i].jldw + '</td>\n' +
                            '<td>' + xsdd_zibs[i].count + '</td>\n' +
                            '<td>' + xsdd_zibs[i].rate + '</td>\n' +
                            '<td>' + xsdd_zibs[i].dpkl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].wsdj + '</td>\n' +
                            '<td>' + xsdd_zibs[i].hsdj + '</td>\n' +
                            '<td>' + xsdd_zibs[i].wsje + '</td>\n' +
                            '<td>' + xsdd_zibs[i].hsje + '</td>\n' +
                            '<td>' + xsdd_zibs[i].se + '</td>\n' +
                            '<td>' + xsdd_zibs[i].zke + '</td>\n' +
                            '<td>' + xsdd_zibs[i].fhck + '</td>\n' +
                            '<td>' + xsdd_zibs[i].shdw + '</td>\n' +
                            '<td>' + xsdd_zibs[i].jhfhrqStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].yqshrqStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].zpStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].yfwcksl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].ljfhsl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].ljcksl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].ljkpsl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].ljyssl + '</td>\n' +
                            '<td>' + xsdd_zibs[i].sffhgbStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].sfckgbStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].sfkpgbStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].sfskgbStr + '</td>\n' +
                            '<td>' + xsdd_zibs[i].statusStr + '</td>\n' +
                            '<td class="text-center">\n' +
                            '<button id="zib_xg_btn" i="' + i + '" zibId="' + xsdd_zibs[i].xsdd_zib_id + '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                            '                                                            <div class="panel-heading">添加销售订单子单</div>\n' +
                            '                                                            <div class="row data-type">\n' +
                            '                        <input id="zib_xg_xsdd_zhub_id-' + i + '" type="hidden" name="xsdd_zhub_id" value="">\n' + /*主表id--》外键*/
                            '                        <input id="zib_xg_xsdd_zib_id-' + i + '" type="hidden" name="xsdd_zib_id" value="">\n' + /*子表id*/
                            '                        <div class="col-md-2 title">行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                            '                                   placeholder="行号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">来源行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_lyhh-' + i + '" type="text" readonly="readonly"  class="form-control" name="lyhh"\n' +
                            '                                   placeholder="来源行号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">商品编号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_spbm-' + i + '" type="text" class="form-control" name="spbm"\n' +
                            '                                   placeholder="商品编号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">商品名称</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_spmc-' + i + '" type="text" class="form-control" name="spmc"\n' +
                            '                                   placeholder="商品名称" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">型号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_type-' + i + '" type="text" class="form-control" name="type"\n' +
                            '                                   placeholder="型号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">计量单位</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="zib_xg_jldw-' + i + '" type="text" class="form-control" name="jldw"\n' +
                            '                                   placeholder="计量单位" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">数量</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="zib_xg_count-' + i + '" type="text" class="form-control" name="count"\n' +
                            '                                   placeholder="数量" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">税率(%)</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="zib_xg_rate-' + i + '" type="text" class="form-control" name="rate"\n' +
                            '                                   placeholder="税率" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">单品扣率(%)</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="zib_xg_dpkl-' + i + '" type="text" class="form-control" name="dpkl"\n' +
                            '                                   placeholder="单品扣率" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">无税单价</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_wsdj-' + i + '" type="text" class="form-control" name="wsdj">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">含税单价</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_hsdj-' + i + '" type="text" class="form-control" name="hsdj">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">无税金额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_wsje-' + i + '" type="text" class="form-control" name="wsje">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">含税金额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_hsje-' + i + '" type="text" class="form-control" name="hsje">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">税额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_se-' + i + '" type="text" class="form-control" name="se">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">折扣额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_zke-' + i + '" type="text" class="form-control" name="zke">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">发货仓库</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_fhck-' + i + '" type="text" class="form-control" name="fhck"\n' +
                            '                                   placeholder="发货仓库" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">收货单位</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_shdw-' + i + '" type="text" class="form-control" name="shdw"\n' +
                            '                                   placeholder="收货单位" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">计划发货日期</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group date">\n' +
                            '                                <div class="input-group-addon">\n' +
                            '                                            <i class="fa fa-calendar"></i>\n' +
                            '                                </div>\n' +
                            '                                <input id="zib_xg_jhfhrq-' + i + '" type="text"\n' +
                            '                                      class="form-control pull-right dateTimePicker" name="jhfhrq">\n' +
                            '                             </div>\n' +
                            '                         </div>\n' +
                            '                        <div class="col-md-2 title">要求收货日期</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group date">\n' +
                            '                                <div class="input-group-addon">\n' +
                            '                                            <i class="fa fa-calendar"></i>\n' +
                            '                                </div>\n' +
                            '                                <input id="zib_xg_yqshrq-' + i + '" type="text"\n' +
                            '                                      class="form-control pull-right dateTimePicker" name="yqshrq">\n' +
                            '                             </div>\n' +
                            '                         </div>\n' +
                            '                         <div class="col-md-2 title">是否为赠品</div>\n' +
                            '                         <div class="col-md-4 data">\n' +
                            '                             <select id="zib_xg_select_zp-' + i + '" class="form-control" name="zp">\n' +
                            '                                    <option id="zib_xg_zp1_option-' + i + '" value="1">是</option>\n' +
                            '                                    <option id="zib_xg_zp0_option-' + i + '" value="0">否</option>\n' +
                            '                             </select>\n' +
                            '                          </div>\n' +
                            '                        <div class="col-md-2 title">应发未出库数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_yfwcksl-' + i + '" type="text" class="form-control" name="yfwcksl"\n' +
                            '                                   placeholder="应发未出库数量" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">累计发货数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_ljfhsl-' + i + '" type="text" class="form-control" name="ljfhsl"\n' +
                            '                                   placeholder="累计发货数量" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">累计出库数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_ljcksl-' + i + '" type="text" class="form-control" name="ljcksl"\n' +
                            '                                   placeholder="累计出库数量" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">累计开票数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_ljkpsl-' + i + '" type="text" class="form-control" name="ljkpsl"\n' +
                            '                                   placeholder="累计开票数量" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">累计应收数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_ljyssl-' + i + '" type="text" class="form-control" name="ljyssl"\n' +
                            '                                   placeholder="累计应收数量" value="">\n' +
                            '                        </div>' +
                            '                         <div class="col-md-2 title">是否发货结束</div>\n' +
                            '                         <div class="col-md-4 data">\n' +
                            '                             <select id="zib_xg_select_sffhgb-' + i + '" class="form-control" name="sffhgb">\n' +
                            '                                    <option id="zib_xg_sffhgb1_option-' + i + '" value="1">结束</option>\n' +
                            '                                    <option id="zib_xg_sffhgb0_option-' + i + '" value="0">未结束</option>\n' +
                            '                             </select>\n' +
                            '                          </div>\n' +
                            '                         <div class="col-md-2 title">是否出库结束</div>\n' +
                            '                         <div class="col-md-4 data">\n' +
                            '                             <select id="zib_xg_select_sfckgb-' + i + '" class="form-control" name="sfckgb">\n' +
                            '                                    <option id="zib_xg_sfckgb1_option-' + i + '" value="1">结束</option>\n' +
                            '                                    <option id="zib_xg_sfckgb0_option-' + i + '" value="0">未结束</option>\n' +
                            '                             </select>\n' +
                            '                          </div>\n' +
                            '                         <div class="col-md-2 title">是否开票结束</div>\n' +
                            '                         <div class="col-md-4 data">\n' +
                            '                             <select id="zib_xg_select_sfkpgb-' + i + '" class="form-control" name="sfkpgb">\n' +
                            '                                    <option id="zib_xg_sfkpgb1_option-' + i + '" value="1">结束</option>\n' +
                            '                                    <option id="zib_xg_sfkpgb0_option-' + i + '" value="0">未结束</option>\n' +
                            '                             </select>\n' +
                            '                          </div>\n' +
                            '                         <div class="col-md-2 title">是否收款结束</div>\n' +
                            '                         <div class="col-md-4 data">\n' +
                            '                             <select id="zib_xg_select_sfskgb-' + i + '" class="form-control" name="sfskgb">\n' +
                            '                                    <option id="zib_xg_sfskgb1_option-' + i + '" value="1">结束</option>\n' +
                            '                                    <option id="zib_xg_sfskgb0_option-' + i + '" value="0">未结束</option>\n' +
                            '                             </select>\n' +
                            '                          </div>\n' +
                            '                         <div class="col-md-2 title">状态</div>\n' +
                            '                         <div class="col-md-4 data">\n' +
                            '                             <select id="zib_xg_select_status-' + i + '" class="form-control" name="status">\n' +
                            '                                    <option id="zib_xg_status1_option-' + i + '" value="1">结束</option>\n' +
                            '                                    <option id="zib_xg_status0_option-' + i + '" value="0">未结束</option>\n' +
                            '                             </select>\n' +
                            '                          </div>\n' +

                            '                                                        </div>\n' +
                            '                                                        </div>\n' +
                            '                                                    </section>\n' +
                            '                                                    <!-- 正文区域 /-->\n' +
                            '                                                </form>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="modal-footer">\n' +
                            '                                        <button zibId="' + xsdd_zibs[i].xsdd_zib_id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                            '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                                <!-- /.modal-content -->\n' +
                            '                            </div>\n' +
                            '\n' +
                            '                            <!-- /.modal-dialog -->\n' +
                            '                        </div>' +
                            <%--模拟窗口/--%>
                            '<button zibId="' + xsdd_zibs[i].xsdd_zib_id + '" type="button" class="btn bg-olive btn-xs"\n' +
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
                            url: "${pageContext.request.contextPath}/xsdd/spForbidden",
                            type: "GET",
                            data: {"ddh":ddh,"spr":spr,"sprq":sprq},
                            dataType: "text",
                            //async: false,
                            success: function (data) {
                                $("#query").trigger("click");
                                alert("审批禁止成功！");
                            },
                            error: function () {
                                alert("审批禁止失败,该订单已经审批！");
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
                            url: "${pageContext.request.contextPath}/xsdd/spAdopt",
                            type: "GET",
                            data: {"ddh":ddh,"spr":spr,"sprq":sprq},
                            dataType: "text",
                            //async: false,
                            success: function (data) {
                                $("#query").trigger("click");
                                alert("审批通过成功！");
                            },
                            error: function () {
                                alert("审批通过失败,该订单已经审批！");
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


