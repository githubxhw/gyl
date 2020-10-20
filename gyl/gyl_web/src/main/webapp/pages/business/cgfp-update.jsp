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
    <title>采购发票修订</title>
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
                采购发票-修订
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
                    <a href="#">采购发票管理</a>
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
                    <div class="panel-heading">修订</div>
                    <div class="row data-type">
                        <%--1--%>
                            <div class="col-md-2 title">公司</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="gs"
                                       placeholder="公司" value="">
                            </div>
                            <div class="col-md-2 title">发票号</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="fph"
                                       placeholder="发票号" value="">
                            </div>
                            <div class="col-md-2 title">发票日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right dateTimePicker" name="fprq">
                                </div>
                            </div>
                            <div class="col-md-2 title">票到日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right dateTimePicker" name="pdrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">供应商</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="gys"
                                       placeholder="供应商" value="">
                            </div>
                            <%--3--%>
                            <div class="col-md-2 title">采购部门</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="cgbm"
                                       placeholder="采购部门" value="">
                            </div>
                            <div class="col-md-2 title">发票类型</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="fplx"
                                       placeholder="发票类型" value="">
                            </div>
                            <%--4--%>
                            <div class="col-md-2 title">业务员</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="ywy"
                                       placeholder="业务员" value="">
                            </div>
                            <div class="col-md-2 title">币种</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="bz"
                                       placeholder="币种" value="">
                            </div>

                            <div class="col-md-2 title">整单税率</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="zdsl"
                                       placeholder="整单税率" value="">
                            </div>
                            <div class="col-md-2 title">是否已付应传</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="isycyf">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">是</option>
                                    <option value="0">否</option>
                                </select>
                            </div>
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
                                    <input type="text"  class="form-control pull-right dateTimePicker" name="zdrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">审批人</div>
                            <div class="col-md-4 data">
                                <input type="text"  readonly class="form-control" name="spr"
                                       placeholder="审核人" value="">
                            </div>
                            <div class="col-md-2 title">审批日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" readonly class="form-control pull-right dateTimePicker" name="sprq">
                                </div>
                            </div>
                            <div class="col-md-2 title">是否审批</div>
                            <div class="col-md-4 data">
                                <select class="form-control" readonly name="sfsp">
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">审批是否通过</div>
                            <div class="col-md-4 data">
                                <select class="form-control" readonly name="spsftg">
                                    <option value="0">未通过</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">修改人</div>
                            <div class="col-md-4 data">
                                <input type="text" readonly class="form-control" name="xgr"
                                       placeholder="修改人" value="">
                            </div>
                            <div class="col-md-2 title">修改日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" readonly class="form-control pull-right dateTimePicker" name="xgrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">单据状态</div>
                            <div class="col-md-4 data">
                                <select class="form-control" readonly name="status">
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
                       style="min-width:3125px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zhu" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" width="350px">公司</th>
                    <th class="text-center sorting" width="350px">发票号</th>
                    <th class="text-center sorting" width="350px">发票日期</th>
                    <th class="text-center sorting" width="350px">票到日期</th>
                    <th class="text-center sorting" width="350px">供应商</th>
                    <th class="text-center sorting" width="350px">采购部门</th>
                    <th class="text-center sorting" width="350px">发票类型</th>
                    <th class="text-center sorting" width="350px">业务员</th>
                    <th class="text-center sorting" width="350px">币种</th>
                    <th class="text-center sorting" width="350px">整单税率</th>
                    <th class="text-center sorting" width="350px">是否已传应付</th>
                    <th class="text-center sorting" width="350px">制单人</th>
                    <th class="text-center sorting" width="350px">制单日期</th>
                    <th class="text-center sorting" width="350px">审批人</th>
                    <th class="text-center sorting" width="350px">审批日期</th>
                    <th class="text-center sorting" width="350px">是否审批</th>
                    <th class="text-center sorting" width="350px">审批是否通过</th>
                    <th class="text-center sorting" width="350px">修改人</th>
                    <th class="text-center sorting" width="350px">修改日期</th>
                    <th class="text-center sorting" width="350px">单据状态</th>
                    <th class="text-center" width="350px">操作</th>
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
            <input id="gs" class="form-control" type="text" readonly="readonly" style="width: 17%;"
                   placeholder="双击已查询的公司名进行选择" value="">
        </div>
        <%--2：子表--%>
        <from id="zib_form" zhub_id="-1">
            <div style="padding-left: 20px;"><h4><%--子表--%></h4></div>
            <div style="overflow: scroll;overflow-y:scroll;height: 300px;width: 99%;">
                <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                       style="min-width:2500px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zi" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" width="200px">行号</th>
                    <th class="text-center sorting" width="200px">存货编码</th>
                    <th class="text-center sorting" width="200px">存货名称</th>
                    <th class="text-center sorting" width="200px">规格</th>
                    <th class="text-center sorting" width="200px">型号</th>
                    <th class="text-center sorting" width="200px">无税单价</th>
                    <th class="text-center sorting" width="200px">批次</th>
                    <th class="text-center sorting" width="200px">发票数量</th>
                    <th class="text-center sorting" width="200px">金额</th>
                    <th class="text-center sorting" width="200px">币种</th>
                    <th class="text-center sorting" width="200px">含税单价</th>
                    <th class="text-center sorting" width="200px">税率</th>
                    <th class="text-center sorting" width="200px">税额</th>
                    <th class="text-center sorting" width="200px">无税金额</th>
                    <th class="text-center sorting" width="200px">来源单据号</th>
                    <th class="text-center sorting" width="200px">来源行号</th>
                    <th class="text-center sorting" width="200px">源头单据号</th>
                    <th class="text-center sorting" width="200px">源头行号</th>
                    <th class="text-center sorting" width="200px">单据状态</th>
                    <th class="text-center" width="200px">操作</th>
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
                                        <h4 class="modal-title">添加采购发票子单</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="box-body">
                                            <div class="form-horizontal">
                                                <%--子表添加--%>
                                                <form id="zib_save_form" method="post">
                                                    <!-- 正文区域 -->
                                                    <section class="content"> <!--产品信息-->

                                                        <div class="panel panel-default">
                                                            <div class="panel-heading">采购发票子单</div>
                                                            <div class="row data-type">
                                                                <div class="col-md-2 title">行号</div>
                                                                <div class="col-md-4 data">
                                                                    <input id="zibhh" type="text" readonly="readonly"
                                                                           class="form-control" name="hh"
                                                                           placeholder="行号" value="">
                                                                </div>
                                                                <div class="col-md-2 title">存货编码</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="chbm"
                                                                           placeholder="存货编码" value="">
                                                                </div>
                                                                <div class="col-md-2 title">存货名称</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="chmc"
                                                                           placeholder="存货名称" value="">
                                                                </div>
                                                                <div class="col-md-2 title">规格</div>
                                                                <div class="col-md-4 data">
                                                                    <input type="text" class="form-control" name="gg"
                                                                           placeholder="规格" value="">
                                                                </div>
                                                                <div class="col-md-2 title">型号</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="xh"
                                                                           placeholder="型号" value="">
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
                                                                <div class="col-md-2 title">批次</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="pc"
                                                                           placeholder="批次" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">发票数量</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="fpsl"
                                                                           placeholder="发票数量" value="0">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">金额</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="je">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 title">币种</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="bz"
                                                                           placeholder="币种" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">含税单价</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="hsdj">
                                                                        <span class="input-group-addon">元</span>
                                                                    </div>
                                                                </div>

                                                                <div class="col-md-2 title">税率</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="sl"
                                                                           placeholder="税率" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">税额</div>
                                                                <div class="col-md-4 data">
                                                                    <div class="input-group">
                                                                        <span class="input-group-addon">¥</span>
                                                                        <input type="text" class="form-control"
                                                                               name="se">
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
                                                                <div class="col-md-2 title">来源单据号</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="lydjh"
                                                                           placeholder="来源单据号" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">来源行号</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="lyhh"
                                                                           placeholder="来源行号" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">源头单据号</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="ytdjd"
                                                                           placeholder="源头单据号" value="">
                                                                </div>
                                                                <div class="col-md-2 title"></div>
                                                                <div class="col-md-2 title">源头行号</div>
                                                                <div class="col-md-2 data">
                                                                    <input type="text" class="form-control" name="ythh"
                                                                           placeholder="源头行号" value="">
                                                                </div>
                                                                <div class="col-md-2 title">状态</div>
                                                                <div class="col-md-4 data">
                                                                    <select class="form-control" name="status">
                                                                        <option selected="selected" value="0">未结束
                                                                        </option>
                                                                    </select>
                                                                </div>
                                                                <%--外键id--%>
                                                                <input id="zib_zhub_id_input" type="hidden"
                                                                       value="" name="cgfp_zhub_id">
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
                url: "${pageContext.request.contextPath}/cgfp/findByCgfp_zhub",
                type: "post",
                data: params,
                dataType: "json",
                async: false,
                success: function (data) {
                    //清除$("#zhub_tbody")里面的内容
                    $("#zhub_tbody").innerHTML = '';
                    var cgfp_zhubs = data;
                    var html = '';
                    for (var i = 0; i < cgfp_zhubs.length; i++) {
                        html += '<tr>\n' +
                            '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhub_ids" type="checkbox" value="' + cgfp_zhubs[i].cgfp_zhub_id + '"></td>\n' +
                            '<td><button i="' + i + '" gs="' + cgfp_zhubs[i].gs + '" checked="" ondblclick="find_zib(this)" zhubId="' + cgfp_zhubs[i].cgfp_zhub_id + '" style="width: 100%;height: 99%">' + cgfp_zhubs[i].gs + '</button></td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].fph) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].fprqStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].pdrqStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].gys) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].cgbm) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].fplx) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].ywy) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].bz) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].zdsl) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].isycyfStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].zdr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].zdrqStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].spr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].sprqStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].sfspStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].spsftgStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].xgr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].xgrqStr) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zhubs[i].statusStr) + '</td>\n' +
                            '<td class="text-center">\n' +
                            '<button id="zhub_xg_btn" i=' + i + ' onclick="zhub_xg_btn(this)" zhubId="' + cgfp_zhubs[i].cgfp_zhub_id + '" type="button" data-toggle="modal" data-target="#myModal-zhub-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                            '                                                            <div class="panel-heading">修改采购发票主表</div>\n' +
                            '                                                            <div class="row data-type">\n' +
                            '\n' +                                                           /* 此处是 标记一个主表的id属性，方便根据id更新主表zhub*/
                            '                                                                <input id="zhub_xg_cgfp_zhub_id-' + i + '" type="hidden" name="cgfp_zhub_id" value="">\n' +
                            '                                                                \n' +
                            '                                                                <div class="col-md-2 title">公司</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_gs-' + i + '" readonly="readonly" type="text"\n' +
                            '                                                                           class="form-control" name="gs"\n' +
                            '                                                                           placeholder="公司" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">发票号</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_fph-' + i + '" readonly="readonly" type="text"\n' +
                            '                                                                           class="form-control" name="fph"\n' +
                            '                                                                           placeholder="发票号" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">发票日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input id="zhub_xg_fprq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker" name="fprq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">票到日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input id="zhub_xg_pdrq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker"\n' +
                            '                                                                               name="pdrq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">供应商</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_gys-' + i + '" readonly="readonly" type="text" class="form-control" name="gys"\n' +
                            '                                                                           placeholder="供应商" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">采购部门</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_cgbm-' + i + '" readonly="readonly" type="text" class="form-control" name="cgbm"\n' +
                            '                                                                           placeholder="采购部门" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">发票类型</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_fplx-' + i + '" type="text" class="form-control" name="fplx"\n' +
                            '                                                                           placeholder="发票类型" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">业务员</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_ywy-' + i + '" readonly="readonly" type="text" class="form-control" name="ywy"\n' +
                            '                                                                           placeholder="业务员" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">币种</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input readonly="readonly" id="zhub_xg_bz-' + i + '" type="text" class="form-control" name="bz"\n' +
                            '                                                                           placeholder="币种" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">整单税率</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input readonly="readonly" id="zhub_xg_zdsl-' + i + '" type="text" class="form-control" name="zdsl"\n' +
                            '                                                                           placeholder="整单税率" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">是否已传应付</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select class="form-control" name="isycyf">\n' +
                            '                                                                        <option id="zhub_xg_isycyf1_option-' + i + '" value="1">是</option>\n' +
                            '                                                                        <option id="zhub_xg_isycyf0_option-' + i + '" value="0">否</option>\n' +
                            '                                                                    </select>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">制单人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input id="zhub_xg_zdr-' + i + '" type="text" class="form-control" name="zdr"\n' +
                            '                                                                           placeholder="制单人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">制单日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input id="zhub_xg_zdrq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right dateTimePicker"\n' +
                            '                                                                               name="zdrq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">审批人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input readonly="readonly" id="zhub_xg_spr-' + i + '" type="text" class="form-control" name="spr"\n' +
                            '                                                                           placeholder="审批人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">审批日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input readonly="readonly" id="zhub_xg_sprq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right"\n' +
                            '                                                                               name="sprq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">是否审批</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select class="form-control" name="sfsp">\n' +
                            '                                                                        <option id="zhub_xg_sfsp0_option-' + i + '" value="0">否</option>\n' +
                            '                                                                    </select>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">审批是否通过</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select class="form-control" name="spsftg">\n' +
                            '                                                                        <option id="zhub_xg_spsftg0_option-' + i + '" value="0">未通过</option>\n' +
                            '                                                                    </select>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">修改人</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <input readonly="readonly" id="zhub_xg_xgr-' + i + '" type="text" class="form-control" name="xgr"\n' +
                            '                                                                           placeholder="修改人" value="">\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">修改日期</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <div class="input-group date">\n' +
                            '                                                                        <div class="input-group-addon">\n' +
                            '                                                                            <i class="fa fa-calendar"></i>\n' +
                            '                                                                        </div>\n' +
                            '                                                                        <input readonly="readonly" id="zhub_xg_xgrq-' + i + '" type="text"\n' +
                            '                                                                               class="form-control pull-right"\n' +
                            '                                                                               name="xgrq">\n' +
                            '                                                                    </div>\n' +
                            '                                                                </div>\n' +
                            '                                                                <div class="col-md-2 title">状态</div>\n' +
                            '                                                                <div class="col-md-4 data">\n' +
                            '                                                                    <select id="zhub_xg_select_status-' + i + '" class="form-control" name="status">\n' +
                            '                                                                        <option id="zhub_xg_status1_option-' + i + '" value="1">结束</option>\n' +
                            '                                                                        <option id="zhub_xg_status0_option-' + i + '" value="0">未结束</option>\n' +
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
                            '                                        <button i="' + i + '" onclick="updateCgfp_zhubById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                            '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                                <!-- /.modal-content -->\n' +
                            '                            </div>\n' +
                            '\n' +
                            '                            <!-- /.modal-dialog -->\n' +
                            '                        </div>' +
                            <%--模拟窗口/--%>
                            '<button zhubId="' + cgfp_zhubs[i].cgfp_zhub_id + '" data-toggle="modal" data-target="#myModal_2" type="button" class="btn bg-olive btn-xs"\n' +
                            '    onclick="delete_zhub(this)">\n' +
                            '    删除\n' +
                            '</button>\n' +
                            '</td>\n' +
                            '</tr>';
                    }
                    $("#zhub_tbody").html(html);
                    $("#zhub_count").html("共 " + cgfp_zhubs.length + " 条记录");
                    $("#zhub_count").attr("count", cgfp_zhubs.length);
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
            if (zhub_id == -1) {
                alert("请指定一个主表：单击主表中的预订单号按钮即可");
            } else {
                //把zhubid外键赋值给子表模态框的input里面
                $("#zib_zhub_id_input").attr("value", zhub_id);
                $.ajax({
                    url: "${pageContext.request.contextPath}/cgfp/getZib_hh",
                    type: "get",
                    data: {"zhub_id": zhub_id},
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
        });

        /*12*/
        //功能：子表：点击模拟框中的添加按钮触发请求，保存一个子表信息
        $("#zib_save").click(function () {
            var params = $("#zib_save_form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/cgfp/saveZib",
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
        });
    });

    /*1*/
    //功能：单击 主表中的 修改按钮，把该行的信息填充到模拟div中
    function zhub_xg_btn(x) {
        //alert("ok")
        var cgfp_zhub_id = $(x).attr("zhubId");
        // console.log(cgfp_zhub_id);
        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/findCgfp_zhubById",
            type: "get",
            data: {"cgfp_zhub_id": cgfp_zhub_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //alert("ok");
                var cgfp_zhub = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");
                //2,给每一个按钮框添加值
                $("#zhub_xg_cgfp_zhub_id-" + i).attr("value", NoNull(cgfp_zhub.cgfp_zhub_id));
                $("#zhub_xg_gs-" + i).attr("value", NoNull(cgfp_zhub.gs));
                $("#zhub_xg_fph-" + i).attr("value", NoNull(cgfp_zhub.fph));
                $("#zhub_xg_fprq-" + i).attr("value", NoNull(cgfp_zhub.fprqStr));
                $("#zhub_xg_pdrq-" + i).attr("value", NoNull(cgfp_zhub.pdrqStr));
                $("#zhub_xg_gys-" + i).attr("value", NoNull(cgfp_zhub.gys));
                $("#zhub_xg_cgbm-" + i).attr("value", NoNull(cgfp_zhub.cgbm));
                $("#zhub_xg_ywy-" + i).attr("value", NoNull(cgfp_zhub.ywy));
                $("#zhub_xg_fplx-" + i).attr("value", NoNull(cgfp_zhub.fplx));
                $("#zhub_xg_bz-" + i).attr("value", NoNull(cgfp_zhub.bz));
                $("#zhub_xg_zdsl-" + i).attr("value", NoNull(cgfp_zhub.zdsl));
                $("#zhub_xg_isycyf-" + i).attr("value", NoNull(cgfp_zhub.isycyfStr));
                $("#zhub_xg_zdr-" + i).attr("value", NoNull(cgfp_zhub.zdr));
                $("#zhub_xg_zdrq-" + i).attr("value", NoNull(cgfp_zhub.zdrqStr));
                $("#zhub_xg_spr-" + i).attr("value", NoNull(cgfp_zhub.spr));
                $("#zhub_xg_sprq-" + i).attr("value", NoNull(cgfp_zhub.sprqStr));
                $("#zhub_xg_xgr-" + i).attr("value", NoNull(cgfp_zhub.xgr));
                $("#zhub_xg_xgrq-" + i).attr("value", NoNull(cgfp_zhub.xgrqStr));


                //添加disabled="disabled" 注意：在提交表单的时候，需要把disabled移除，不然提交不了数据
                $("#zhub_xg_select_isycyf-" + i).attr("disabled", "disabled");

                if (cgfp_zhub.isycyf == 1) {
                    $("#zhub_xg_isycyf1_option-" + i).attr("selected", "selected");
                } else {
                    $("#zhub_xg_isycyf0_option-" + i).attr("selected", "selected");
                }
                if (cgfp_zhub.status == 1) {
                    $("#zhub_xg_status1_option-" + i).attr("selected", "selected");
                } else {
                    $("#zhub_xg_status0_option-" + i).attr("selected", "selected");
                }
            },
            error: function (data) {
                alert("无响应!");
            }
        });
    }

    /*2*/
    //功能：单击 主表模态框中的 修改按钮，对修改的信息进行修改
    function updateCgfp_zhubById(x) {
        //获取点击了该修改按钮所在的行号i
        var i = $(x).attr("i");
        //alert(i);
        $("#zhub_xg_select_isycyf-" + i).removeAttr("disabled");
        $("#zhub_xg_select_status-" + i).removeAttr("disabled");
        //表单数据
            var params = $("#zhub_xg_form-" + i).serialize();
        console.log(params);
        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/updateCgfp_zhubById",
            type: "post",
            data: params,
            dataType: "text",
            success: function () {
                $("#query").trigger("click");
                alert("修改成功，请重新查询！");
            },
            error: function () {
                alert("修改失败!")
            }
        });
    }

    /*3*/
    //功能：单击主表总右边的删除按钮，删除主表 by id
    function delete_zhub(x) {
        //判断是否删除
        var msg = "是否确认删除?";
        if (confirm(msg) == true) {
            var cgfp_zhub_id = $(x).attr("zhubId");
            $.ajax({
                url: "${pageContext.request.contextPath}/cgfp/deleteCgfp_ZhubById",
                type: "GET",
                data: {"cgfp_zhub_id": cgfp_zhub_id},
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
                        if (id == cgfp_zhub_id) {
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
            $.ajax({
                url: "${pageContext.request.contextPath}/cgfp/deleteCgfp_ZhubByIds",
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
    //功能：双击主表gs按钮触发，根据主表的id查询所有的子表信息，并添加到子表
    function find_zib(x) {
        //移除属性checked
        $(".my-checkbox").removeAttr('checked');
        //把当前设置为true
        var i = $(x).attr("i");
        $("#checkbox-pos-" + i).prop("checked", true);
        //获取id
        var cgfp_zhub_id = $(x).attr("zhubId");
        //获取ddh:对应了子表上面的 单据号：inputut[xxx],将单据号添加到里面显示，方便查看
        var gs = $(x).attr("gs");
        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/findCgfp_zibByZhubId",
            type: "GET",
            data: {"cgfp_zhub_id": cgfp_zhub_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //先清除$("#zib_tbody")里面的内容
                $("#zib_tbody").innerHTML = '';
                //给子表form的zhub_id赋值
                $("#zib_form").attr("zhub_id", cgfp_zhub_id);
                $("#gs").attr("value", gs);
                //添加内容
                cgfp_zibs = data;
                var html = '';
                for (var i = 0; i < cgfp_zibs.length; i++) {
                    html += '<tr>\n' +
                        '<td><input name="zib_ids" type="checkbox" value="' + cgfp_zibs[i].cgfp_zib_id + '"></td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].hh) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].chbm) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].chmc) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].gg) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].xh) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].wsdj) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].pc) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].fpsl) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].je) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].bz) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].hsdj) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].sl) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].se) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].wsje) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].lydjh) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].lyhh) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].ytdjd) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].ythh) + '</td>\n' +
                        '<td>' + NoNull(cgfp_zibs[i].statusStr) + '</td>\n' +
                        '<td class="text-center">\n' +
                        '<button id="zib_xg_btn" i="' + i + '" zibId="' + cgfp_zibs[i].cgfp_zib_id + '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                        '                                                            <div class="panel-heading">采购发票子表</div>\n' +
                        '                                                            <div class="row data-type">\n' +
                        '                        <input id="zib_xg_cgfp_zhub_id-' + i + '" type="hidden" name="cgfp_zhub_id" value="">\n' + /*主表id--》外键*/
                        '                        <input id="zib_xg_cgfp_zib_id-' + i + '" type="hidden" name="cgfp_zib_id" value="">\n' + /*子表id*/
                        '                        <div class="col-md-2 title">行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                        '                                   placeholder="行号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">存货编码</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_chbm-' + i + '" type="text" readonly="readonly"  class="form-control" name="chbm"\n' +
                        '                                   placeholder="存货编码" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">存货名称</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_chmc-' + i + '" type="text" readonly="readonly" class="form-control" name="chmc"\n' +
                        '                                   placeholder="存货名称" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">规格</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_gg-' + i + '" type="text" readonly="readonly" class="form-control" name="gg"\n' +
                        '                                   placeholder="规格" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">型号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_xh-' + i + '" type="text" readonly="readonly" class="form-control" name="xh"\n' +
                        '                                   placeholder="型号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">无税单价</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="zib_xg_wsdj-' + i + '" type="text" readonly="readonly" class="form-control" name="wsdj">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">批次</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="zib_xg_pc-' + i + '" type="text" class="form-control" name="pc"\n' +
                        '                                   placeholder="批次" value="">\n' +
                        '                        </div>\n' +
                        '                            <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">发票数量</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="zib_xg_fpsl-' + i + '" type="text" class="form-control" name="fpsl"\n' +
                        '                                   placeholder="发票数量" value="">\n' +
                        '                        </div>\n' +
                        '                            <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">金额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="zib_xg_je-' + i + '" type="text" readonly="readonly" class="form-control" name="je">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">币种</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_bz-' + i + '" type="text" readonly="readonly" class="form-control" name="bz"\n' +
                        '                                   placeholder="币种" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">含税单价</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="zib_xg_hsdj-' + i + '" type="text" readonly="readonly" class="form-control" name="hsdj">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">税率</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_sl-' + i + '" type="text" readonly="readonly" class="form-control" name="sl"\n' +
                        '                                   placeholder="税率" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">税额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="zib_xg_se-' + i + '" type="text" readonly="readonly" class="form-control" name="se">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">无税金额</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <span class="input-group-addon">¥</span>\n' +
                        '                                <input id="zib_xg_wsje-' + i + '" type="text" readonly="readonly" class="form-control" name="wsje">\n' +
                        '                                <span class="input-group-addon">元</span>\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">来源单据号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_lydjh-' + i + '" type="text" readonly="readonly" class="form-control" name="lydjh"\n' +
                        '                                   placeholder="来源单据号" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">来源行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="zib_xg_lyhh-' + i + '" type="text" readonly="readonly" class="form-control" name="lyhh"\n' +
                        '                                   placeholder="来源行号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">源头单据号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input readonly="readonly" id="zib_xg_ytdjd-' + i + '" type="text" readonly="readonly" class="form-control" name="ytdjd"\n' +
                        '                                   placeholder="源头单据号" value="">\n' +
                        '                        </div>' +
                        '                        <div class="col-md-2 title">累计发票数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input readonly="readonly" id="zib_xg_ljfpsl-' + i + '" type="text" class="form-control" name="ljfpsl"\n' +
                        '                                   placeholder="累计发票数量" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">应开票数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input readonly="readonly" id="zib_xg_ykpsl-' + i + '" type="text" class="form-control" name="ykpsl"\n' +
                        '                                   placeholder="应开票数量" value="">\n' +
                        '                        </div>\n' +
                        '                         <div class="col-md-2 title">状态</div>\n' +
                        '                         <div class="col-md-4 data">\n' +
                        '                             <select id="zib_xg_select_status-' + i + '" class="form-control" name="status">\n' +
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
                        '                                        <button zibId="' + cgfp_zibs[i].cgfp_zib_id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                        '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                                <!-- /.modal-content -->\n' +
                        '                            </div>\n' +
                        '\n' +
                        '                            <!-- /.modal-dialog -->\n' +
                        '                        </div>' +
                        <%--模拟窗口/--%>
                        '<button zibId="' + cgfp_zibs[i].cgfp_zib_id + '" type="button" class="btn bg-olive btn-xs"\n' +
                        '    onclick="delete_zib(this)">\n' +
                        '    删除\n' +
                        '</button>\n' +
                        '</td>\n' +
                        '</tr>';
                }
                $("#zib_tbody").html(html);
                $("#zib_count").attr("count", cgfp_zibs.length);
                $("#zib_count").html("共 " + cgfp_zibs.length + " 条记录");
            },
            error: function () {
                alert("查询失败！")
            }
        });
    }

    /*8*/
    //功能：单击 子表中的 修改按钮，把该行的信息填充到模拟div中
    function zib_xg_btn(x) {
        var cgfp_zib_id = $(x).attr("zibId");
        console.log(cgfp_zib_id);
        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/findCgfp_zibById",
            type: "get",
            data: {"cgfp_zib_id": cgfp_zib_id},
            dataType: "json",
            async: false,
            success: function (data) {
                var cgfp_zib = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");
                //2,给每一个按钮框添加值
                $("#zib_xg_cgfp_zhub_id-" + i).attr("value", NoNull(cgfp_zib.cgfp_zhub_id));
                $("#zib_xg_cgfp_zib_id-" + i).attr("value", NoNull(cgfp_zib.cgfp_zib_id));
                $("#zib_xg_hh-" + i).attr("value", NoNull(cgfp_zib.hh));
                $("#zib_xg_chbm-" + i).attr("value", NoNull(cgfp_zib.chbm));
                $("#zib_xg_chmc-" + i).attr("value", NoNull(cgfp_zib.chmc));
                $("#zib_xg_gg-" + i).attr("value", NoNull(cgfp_zib.gg));
                $("#zib_xg_xh-" + i).attr("value", NoNull(cgfp_zib.xh));
                $("#zib_xg_wsdj-" + i).attr("value", NoNull(cgfp_zib.wsdj));
                $("#zib_xg_pc-" + i).attr("value", NoNull(cgfp_zib.pc));
                $("#zib_xg_fpsl-" + i).attr("value", NoNull(cgfp_zib.fpsl));
                $("#zib_xg_je-" + i).attr("value", NoNull(cgfp_zib.je));
                $("#zib_xg_bz-" + i).attr("value", NoNull(cgfp_zib.bz));
                $("#zib_xg_hsdj-" + i).attr("value", NoNull(cgfp_zib.hsdj));
                $("#zib_xg_sl-" + i).attr("value", NoNull(cgfp_zib.sl));
                $("#zib_xg_se-" + i).attr("value", NoNull(cgfp_zib.se));
                $("#zib_xg_wsje-" + i).attr("value", NoNull(cgfp_zib.wsje));
                $("#zib_xg_lydjh-" + i).attr("value", NoNull(cgfp_zib.lydjh));
                $("#zib_xg_lyhh-" + i).attr("value", NoNull(cgfp_zib.lyhh));
                $("#zib_xg_ytdjd-" + i).attr("value", NoNull(cgfp_zib.ytdjd));
                $("#zib_xg_ythh-" + i).attr("value", NoNull(cgfp_zib.ythh));
                $("#zib_xg_ljfpsl-" + i).attr("value", NoNull(cgfp_zib.ljfpsl));
                $("#zib_xg_ykpsl-" + i).attr("value", NoNull(cgfp_zib.ykpsl));
                $("#zib_xg_status-" + i).attr("value", NoNull(cgfp_zib.statusStr));
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
        console.log(params);
        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/updateCgfp_zibById",
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
                url: "${pageContext.request.contextPath}/cgfp/deleteCgfp_ZibById",
                type: "GET",
                data: {"cgfp_zib_id": zibId},
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
                    alert("删除成功!")
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
                url: "${pageContext.request.contextPath}/cgfp/deleteCgfp_ZibByIds",
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
                url: "${pageContext.request.contextPath}/cgfp/findCgfp_zibByZhubId",
                type: "GET",
                data: {"cgfp_zhub_id": zhub_id},
                dataType: "json",
                async: false,
                success: function (data) {
                    //先清除$("#zib_tbody")里面的内容
                    $("#zib_tbody").innerHTML = '';
                    //添加内容
                    cgfp_zibs = data;
                    var html = '';
                    for (var i = 0; i < cgfp_zibs.length; i++) {
                        html += '<tr>\n' +
                            '<td><input name="zib_ids" type="checkbox" value="' + cgfp_zibs[i].cgfp_zib_id + '"></td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].hh) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].chbm) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].chmc) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].gg) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].xh) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].wsdj) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].pc) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].fpsl) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].je) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].bz) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].hsdj) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].sl) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].se) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].wsje) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].lydjh) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].lyhh) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].ytdjd) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].ythh) + '</td>\n' +
                            '<td>' + NoNull(cgfp_zibs[i].statusStr) + '</td>\n' +
                            '<td class="text-center">\n' +
                            '<button id="zib_xg_btn" i="' + i + '" zibId="' + cgfp_zibs[i].cgfp_zib_id + '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
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
                            '                                                <%--子表修改--%>\n' +
                            '                                                <form id="zib_xg_form-' + i + '" method="post">\n' +
                            '                                                    <!-- 正文区域 -->\n' +
                            '                                                    <section class="content"> <!--产品信息-->\n' +
                            '\n' +
                            '                                                        <div class="panel panel-default">\n' +
                            '                                                            <div class="panel-heading">采购发票子单</div>\n' +
                            '                                                            <div class="row data-type">\n' +
                            '                        <input id="zib_xg_cgfp_zhub_id-' + i + '" type="hidden" name="cgfp_zhub_id" value="">\n' + /*主表id--》外键*/
                            '                        <input id="zib_xg_cgfp_zib_id-' + i + '" type="hidden" name="cgfp_zib_id" value="">\n' + /*子表id*/
                            '                        <div class="col-md-2 title">行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                            '                                   placeholder="行号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">存货编码</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_chbm-' + i + '" type="text" readonly="readonly"  class="form-control" name="chbm"\n' +
                            '                                   placeholder="存货编码" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">存货名称</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_chmc-' + i + '" type="text" readonly="readonly" class="form-control" name="chmc"\n' +
                            '                                   placeholder="存货名称" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">规格</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_gg-' + i + '" type="text" readonly="readonly" class="form-control" name="gg"\n' +
                            '                                   placeholder="规格" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">型号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_xh-' + i + '" type="text" readonly="readonly" class="form-control" name="xh"\n' +
                            '                                   placeholder="型号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">无税单价</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_wsje-' + i + '" type="text" readonly="readonly" class="form-control" name="wsdj">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">批次</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="zib_xg_pc-' + i + '" type="text" class="form-control" name="pc"\n' +
                            '                                   placeholder="批次" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">发票数量</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="zib_xg_fpsl-' + i + '" type="text" class="form-control" name="fpsl"\n' +
                            '                                   placeholder="发票数量" value="">\n' +
                            '                        </div>\n' +
                            '                            <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">金额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_je-' + i + '" type="text" readonly="readonly" class="form-control" name="je">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">币种</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_bz-' + i + '" type="text" readonly="readonly" class="form-control" name="bz"\n' +
                            '                                   placeholder="币种" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">含税单价</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_hsdj-' + i + '" type="text" readonly="readonly" class="form-control" name="hsdj">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">税率</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_sl-' + i + '" type="text" readonly="readonly" class="form-control" name="sl"\n' +
                            '                                   placeholder="税率" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">税额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_se-' + i + '" type="text" readonly="readonly" class="form-control" name="se">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">无税金额</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <span class="input-group-addon">¥</span>\n' +
                            '                                <input id="zib_xg_wsje-' + i + '" type="text" readonly="readonly" class="form-control" name="wsje">\n' +
                            '                                <span class="input-group-addon">元</span>\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">累计发票数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input readonly="readonly" id="zib_xg_ljfpsl-' + i + '" type="text" class="form-control" name="ljfpsl"\n' +
                            '                                   placeholder="累计发票数量" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">应开票数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input readonly="readonly" id="zib_xg_ykpsl-' + i + '" type="text" class="form-control" name="ykpsl"\n' +
                            '                                   placeholder="应开票数量" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">来源单据号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_lydjh-' + i + '" type="text" readonly="readonly" class="form-control" name="lydjh"\n' +
                            '                                   placeholder="来源单据号" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">来源行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="zib_xg_lyhh-' + i + '" type="text" readonly="readonly" class="form-control" name="lyhh"\n' +
                            '                                   placeholder="来源行号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">源头单据号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input readonly="readonly" id="zib_xg_ytdjd-' + i + '" type="text" readonly="readonly" class="form-control" name="ytdjd"\n' +
                            '                                   placeholder="源头单据号" value="">\n' +
                            '                        </div>' +
                            '                        <div class="col-md-2 title">源头行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input readonly="readonly" id="zib_xg_ythh-' + i + '" type="text" class="form-control" name="ythh"\n' +
                            '                                   placeholder="源头行号" value="">\n' +
                            '                        </div>\n' +

                            '                                                        </div>\n' +
                            '                                                        </div>\n' +
                            '                                                    </section>\n' +
                            '                                                    <!-- 正文区域 /-->\n' +
                            '                                                </form>\n' +
                            '                                            </div>\n' +
                            '                                        </div>\n' +
                            '                                    </div>\n' +
                            '                                    <div class="modal-footer">\n' +
                            '                                        <button zibId="' + cgfp_zibs[i].cgfp_zib_id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                            '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                                <!-- /.modal-content -->\n' +
                            '                            </div>\n' +
                            '\n' +
                            '                            <!-- /.modal-dialog -->\n' +
                            '                        </div>' +
                            <%--模拟窗口/--%>
                            '<button zibId="' + cgfp_zibs[i].cgfp_zib_id + '" type="button" class="btn bg-olive btn-xs"\n' +
                            '    onclick="delete_zib(this)">\n' +
                            '    删除\n' +
                            '</button>\n' +
                            '</td>\n' +
                            '</tr>';
                    }
                    $("#zib_tbody").html(html);
                    $("#zib_count").attr("count", cgfp_zibs.length);
                    $("#zib_count").html("共 " + cgfp_zibs.length + " 条记录");
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


