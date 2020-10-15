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
    <title>采购订单制单</title>
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
                采购订单-制单
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
                <li class="active">制单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form id="form" method="post">
            <section class="content">
                <!-- zhub -->
                <div class="panel panel-default">
                    <div class="panel-heading">添加</div>
                    <div class="row data-type">
                        <%--1--%>
                        <div class="col-md-2 title">单据号</div>
                        <div class="col-md-4 data">
                            <input readonly="readonly" type="text" class="form-control" name="djh"
                                   placeholder="单据号" value="${ddh}">
                        </div>
                        <%--2--%>
                        <div class="col-md-2 title">订单日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right dateTimePicker" name="ddrq">
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
                        <div class="col-md-2 title">公司</div>
                        <div class="col-md-4 data">
                             <input type="text" class="form-control" name="gs"
                                       placeholder="公司" value="">
                        </div>

                        <div class="col-md-2 title">采购人</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="cgr"
                                   placeholder="采购人" value="">
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
                                <input readonly="readonly" type="text" class="form-control pull-right"
                                       name="sprq">
                            </div>
                        </div>
                        <div class="col-md-2 title">是否审批</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="issp">
                                <option selected="selected" value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">审批是否通过</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="spsftg">
                                <option selected="selected" value="-1">无法填写</option>
                            </select>
                        </div>
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
                                <input readonly="readonly" type="text" class="form-control pull-right"
                                       name="xgrq">
                            </div>
                        </div>
                            <div class="col-md-2 title">失效日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input readonly="readonly" type="text" class="form-control pull-right"
                                           name="sxrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">业务员</div>
                            <div class="col-md-4 data">
                                <input  type="text" class="form-control" name="ywy"
                                       placeholder="业务员" value="">
                            </div>
                        <div class="col-md-2 title">整单税率(%)</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="zdsl"
                                   placeholder="整单税率(%)" value="">
                        </div>
                        <div class="col-md-2 title">解冻人</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="jdr" readonly="readonly"
                                   placeholder="解冻人" value="">
                        </div>
                        <div class="col-md-2 title">冻结状态</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="djzt">
                                <option value="0">否</option>
                            </select>
                        </div>
                        <%--9--%>


                        <%--10--%>
                        <div class="col-md-2 title">是否退货</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="isth">
                                <option value="1">是</option>
                                <option selected="selected" value="0">否</option>
                            </select>
                        </div>
                        <%--11--%>
                        <div class="col-md-2 title">币种</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="bz"
                                       placeholder="币种" value="">
                            </div>
                        <%--12--%>
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
                                    <option selected="selected" value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">是否入库结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="rkbz">
                                    <option selected="selected" value="0">否</option>
                                </select>
                            </div>
                            <%--12--%>
                            <div class="col-md-2 title">是否开票结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="kpbz">
                                    <option selected="selected" value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">是否收款结束</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="ysbz">
                                    <option selected="selected" value="0">否</option>
                                </select>
                            </div>

                        <div class="col-md-2 title">状态</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="status">
                                <option selected="selected" value="0">未结束</option>
                            </select>
                        </div>
                    </div>
                </div>
                <!-- zhub /-->
                <%--zib--%>
                <span hh="0" id="zib_hh"></span><%--记录子表的条数--%>
                <div style="overflow: scroll;overflow-y:scroll;height: 300px;width: 100%;">
                    <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                           style="min-width:5000px;border:solid grey 1px">
                        <thead>

                        <th class="text-center" width="10px">
                            <div class="btn-group">
                                <button onclick="add_zib(this)" type="button" class="btn btn-default" title="添加">
                                    <i></i><span style="font-size: 15px">+</span>
                                </button>
                            </div>
                        </th>
                        <th class="sorting_asc" width="350px">行号</th>
                        <th class="text-center sorting" width="350px">来源单据</th>
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
                        <th class="text-center sorting" width="350px">累计退货数量</th>
                        <th class="text-center sorting" width="350px">行状态</th>
                        <th class="text-center sorting" width="350px">收货仓库</th>
                        <th class="text-center sorting" width="350px">到货单位</th>
                        <th class="text-center sorting" width="350px">计划到货日期</th>
                        <th class="text-center sorting" width="350px">要求收货日期</th>
                        <th class="text-center sorting" width="350px">应发未出库数量</th>
                        <th class="text-center sorting" width="350px">累计到货数量</th>
                        <th class="text-center sorting" width="350px">累计入库数量</th>
                        <th class="text-center sorting" width="350px">累计开票数量</th>
                        <th class="text-center sorting" width="350px">累计应付数量</th>
                        <th class="text-center sorting" width="350px">是否到货关闭</th>
                        <th class="text-center sorting" width="350px">是否入库关闭</th>
                        <th class="text-center sorting" width="350px">是否开票关闭</th>
                        <th class="text-center sorting" width="350px">是否收款结束</th>
                        </thead>
                        <%--内容--%>
                        <tbody id="zib_tbody">

                        </tbody>
                    </table>
                </div>
                <%--zib /--%>
                <br><br>
                <%--制单人--%>
                <div class="panel panel-default">
                    <div class="row data-type">
                        <div class="col-md-2 title">制单人</div>
                        <div class="col-md-4 data">
                            <input  id="zdr" type="text" class="form-control" name="zdr"
                                   placeholder="制单人" value="" aa="制单人">
                        </div>
                        <div class="col-md-2 title">制单日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input  id="zdrq" type="text" class="form-control pull-right dateTimePicker" name="zdrq" aa="制单日期">
                            </div>
                        </div>
                    </div>
                </div>
                <br>

                <!--工具栏-->
                <div class="box-tools text-right">
                    <button id="save_button" type="button" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回
                    </button>
                    <button id="toquery_button" type="button" class="btn bg-yellow">搜索</button>
                </div>
                <!--工具栏/-->
        </form>
        <br>
        <br>
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
            format: "yyyy-mm-dd hh:ii:ss",
            showSeconds:true,
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
            showSeconds:true,
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

    function aa(x){
        if ($(x).val() == ""){
            $(x).css("border","1px solid red")
            var aa = $(x).attr("aa");
            alert(aa+"为空")
            return false;
        }else{
            $(x).css("border","")
            return true;
        }
    }
    $(function () {
        document.getElementsByName("gys")[0].onblur = function () {
            var gys = document.getElementsByName("gys")[0].value;
            if (gys!=""){
                $.ajax({
                    url: "${pageContext.request.contextPath}/cgdd/FindG",
                    type: "POST",
                    data: {"name":gys},
                    dataType: "json",
                    async: false,
                    success: function (data) {
                        //添加主表信息到页面
                        if (data.msg === "Ok"){
                            document.getElementsByName("gys")[0].style.border = "";

                        }else {
                            alert(data.msg);
                            document.getElementsByName("gys")[0].style.border = "1px solid red";
                            document.getElementsByName("gys")[0].style.value = "";
                        }

                    },
                    error: function () {
                        alert("出现未知错误")
                    }
                });
            }
        }
    })
    $(document).ready(function () {
        //功能：保存主表和子表信息,返回成功即跳转到新页面，失败提示
        $("#save_button").click(function () {
            //alert("ok")
            var params = $("#form").serialize();
            if(aa($("#zdr"))&& aa($("#zdrq"))){
                $.ajax({
                    url: "${pageContext.request.contextPath}/cgdd/saveZhubAndZib",
                    type: "POST",
                    data: params,
                    dataType: "json",
                    async: false,
                    success: function (data) {
                        //添加主表信息到页面
                        if (data.msg == "添加成功!"){
                            alert(data.msg);
                            location.href="${pageContext.request.contextPath}/cgdd/getDdhToAddUI";
                        }else {
                            alert(data.msg);
                        }

                    },
                    error: function () {
                        alert("添加失败！出现未知错误")
                    }
                });
            }

        });
        //spbm  dpzk
        //功能：点击跳转到query.jsp
        $("#toquery_button").click(function () {
            window.location.href = "${pageContext.request.contextPath}/pages/business/cgdd-query.jsp";
        });
    });

    //功能： 点击 按钮+号，在子表中添加一列
    function add_zib(x) {
        //获取hh
        var befCount = parseInt($("#zib_hh").attr("hh"));
        console.log(befCount)
        //判断是否 子表的内容不为空
        var childCount = document.getElementById("zib_tbody").childElementCount;
        var flag = "0";
        //没有元素
        if (childCount == 0) {
            flag = "1";
        } else {
            //有至少一个时候：获取最后一个
            var lastChildren = document.getElementById("zib_tbody").lastChild;
            var pos = $(lastChildren).attr("id");
            var text = $("#spbm-" + pos).val();
            var text1 = text.replace(/^\s+|\s+$/g, "");
            if (text1 == null || text1.length == 0) {
                flag = "0";
            } else {
                flag = "1";
            }
        }
        if (flag == "1") {
            //要添加第几条数据
            var nowCount = 1 + befCount;
            console.log(nowCount)
            var str = '<tr id="' + nowCount + '">' +
                '<td>                            <button pos="' + nowCount + '" onclick="delete_zib(this)" type="button" class="btn btn-default" title="添加">\n' +
                '                                    <i></i><span style="font-size: 15px">-</span>\n' +
                '                                </button>' +
                '</td>' +
                '<td>                            <input id="hh-' + nowCount + '" type="text" readonly="readonly"  class="form-control" name="cgddzhibs[' + nowCount + '].hh"\n' +
                '                                   placeholder="行号" value="' + nowCount + '"></td>\n' +
                '<td>                            <input id="lydjh-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].lydj"\n' +
                '                                   placeholder="来源单据号" value=""></td>\n' +
                '<td>                            <input id="spbm-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].spbm"\n' +
                '                                   placeholder="商品编号(不为空)"></td>\n' +
                '<td>                            <input id="spmc-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].spmc"\n' +
                '                                   placeholder="商品名称" value=""></td>\n' +
                '<td>                            <input id="type-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].xh"\n' +
                '                                   placeholder="商品型号" value=""></td>\n' +
                '<td>                            <input id="jldw-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].dw"\n' +
                '                                   placeholder="计量单位" value=""></td>\n' +
                '<td>                            <input id="count-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].sl"\n' +
                '                                   placeholder="数量" value=""></td>\n' +
                '<td>                            <input id="rate-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].shuilv"\n' +
                '                                   placeholder="税率" value=""></td>\n' +

                '<td>                            <input id="wsdj-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].wsdj" ' +
                '                                   placeholder="无税单价" value=""></td>\n' +
                '<td>                            <input id="hsdj-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].hsdj" ' +
                '                                   placeholder="含税单价" value=""></td>\n' +
                '<td>                            <input id="wsje-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].wsje" ' +
                '                                   placeholder="无税金额" value=""></td>\n' +
                '<td>                            <input id="hsje-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].hsje" ' +
                '                                   placeholder="含税金额" value=""></td>\n' +
                '<td>                            <input id="se-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].se" ' +
                '                                   placeholder="税额" value=""></td>\n' +
                '<td>                            <select id="hgb-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].hgb">\n' +

                '                                   <option selected="selected" value="0">否</option>' +
                '                                </select></td>\n' +
                '<td>                            <input id="gbr-' + nowCount + '" type="text" class="form-control" readonly="readonly" name="cgddzhibs[' + nowCount + '].gbr"\n' +
                '                                   placeholder="关闭人" value=""></td>\n' +

                '<td>                            <div class="input-group date">'+
                                                        '<div class="input-group-addon">'+
                                                            '<i class="fa fa-calendar"></i>'+
                                                        '</div>'+
                                                        '<input readonly="readonly" type="text" class="form-control pull-right"\n'+
                                                        'name="cgddzhibs[' + nowCount + '].gbrq">'+
                                                 '</div></td>\n' +
                '<td>                            <input id="gg-' + nowCount + '" type="text" class="form-control dateTimePicker" name="cgddzhibs[' + nowCount + '].gg"\n' +
                '                                   placeholder="规格" value=""></td>\n' +
                '<td>                            <input id="zp-' + nowCount + '" type="text" class="form-control dateTimePicker" name="cgddzhibs[' + nowCount + '].zp"\n' +
                '                                   placeholder="赠品" value=""></td>\n' +
                /*'<td>                            <input id="yfwcksl-' + nowCount + '" type="text" class="form-control" name="xsdd_zibs[' + nowCount + '].yfwcksl"\n' +
                '                                   placeholder="应发未出库数量" value="0"></td>\n' +*/
                '<td>                            <input id="ljthsl-' + nowCount + '" type="text" class="form-control"  name="cgddzhibs[' + nowCount + '].ljthsl"\n' +
                '                                   placeholder="累计退货数量" value="0"></td>\n' +

                '<td>                            <select id="hstatus-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].hstatus">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +
                '<td>                            <input id="fhck-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].shck"\n' +
                '                                   placeholder="收货仓库" value=""></td>\n' +
                '<td>                            <input id="shdw-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].fhdw"\n' +
                '                                   placeholder="发货单位" value=""></td>\n' +
                '<td>                            <input id="jhdhrq-' + nowCount + '" type="text" class="form-control dateTimePicker" name="cgddzhibs[' + nowCount + '].jhdhrq"\n' +
                '                                   placeholder="yyyy-MM-dd hh:mm" value=""></td>\n' +
                '<td>                            <input id="yqshrq-' + nowCount + '" type="text" class="form-control dateTimePicker" name="cgddzhibs[' + nowCount + '].yqshrq"\n' +
                '                                   placeholder="yyyy-MM-dd hh:mm" value=""></td>\n' +
                '<td>                            <input id="yfwcksl-' + nowCount + '" type="text" class="form-control" readonly="readonly" name="cgddzhibs[' + nowCount + '].yfwrksl"\n' +
 '                                   placeholder="应发未入库数量" value="0"></td>\n' +
                '<td>                            <input id="ljfhsl-' + nowCount + '" type="text" class="form-control" readonly="readonly" name="cgddzhibs[' + nowCount + '].ljdhsl"\n' +
                '                                   placeholder="累计到货数量" value="0"></td>\n' +
                '<td>                            <input id="ljcksl-' + nowCount + '" type="text" class="form-control" readonly="readonly" name="cgddzhibs[' + nowCount + '].ljrksl"\n' +
                '                                   placeholder="累计入库数量" value="0"></td>\n' +
                '<td>                            <input id="ljkpsl-' + nowCount + '" type="text" class="form-control" readonly="readonly"  name="cgddzhibs[' + nowCount + '].ljkpsl"\n' +
                '                                   placeholder="累计开票数量" value="0"></td>\n' +
                '<td>                            <input id="ljyfsl-' + nowCount + '" type="text" class="form-control"  readonly="readonly" name="cgddzhibs[' + nowCount + '].ljyfsl"\n' +
                '                                   placeholder="累计应付数量" value="0"></td>\n' +
                '<td>                            <select id="sffhgb-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].sfdhgb">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +
                '<td>                            <select id="sfckgb-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].sfrkgb">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +
                '<td>                            <select id="sfkpgb-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].sfkpgb">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +
                '<td>                            <select id="sfskgb-' + nowCount + '" type="text" class="form-control" name="cgddzhibs[' + nowCount + '].sffkgb">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +

                '</tr>';
            $("#zib_tbody").append(str);
            $("#zib_hh").attr("hh", nowCount);
        }
    }

    //功能： 点击 按钮-号，在子表中删除当前列
    function delete_zib(x) {
        var pos = $(x).attr("pos");
        $("#" + pos).remove();
    }


</script>


</body>

</html>



