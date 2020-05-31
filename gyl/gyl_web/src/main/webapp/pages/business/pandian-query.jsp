<%--
  Created by IntelliJ IDEA.
  User: XHW
  Date: 2020/2/17
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>盘点单查询</title>
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
                盘点单-查询
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
                    <a href="#">库存管理</a>
                </li>
                <li>
                    <a href="#">盘点</a>
                </li>
                <li class="active">查询</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <%--查询部分--%>
        <%-- id = query 按钮查询--%>
        <form id="form" method="post">
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">查询(所有)</div>
                    <div class="row data-type">
                        <%--1--%>
                            <div class="col-md-2 title">ID</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="id"
                                       placeholder="盘点单ID" value="">
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
                            <div class="col-md-2 title">盘点日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right dateTimePicker" name="pdrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">仓库</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="ck"
                                       placeholder="仓库" value="">
                            </div>
                            <div class="col-md-2 title">库存员</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="kcy"
                                       placeholder="库存元" value="">
                            </div>

                            <div class="col-md-2 title">部门</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="bm"
                                       placeholder="部门" value="">
                            </div>
                            <div class="col-md-2 title">盘点人</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="pdr"
                                       placeholder="盘点人" value="">
                            </div>
                            <div class="col-md-2 title">状态</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="status">
                                    <option selected="selected" value="-1">全部</option>
                                    <option value="1">审批</option>
                                    <option value="0">不审批</option>
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
                            <div class="col-md-2 title">调整人</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="tzr"
                                       placeholder="调整人" value="">
                            </div>
                            <div class="col-md-2 title">调整日期</div>
                            <div class="col-md-4 data">
                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right"
                                           name="tzrq">
                                </div>
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
                       style="min-width:2300px;border:solid grey 1px">
                    <thead >
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zhu" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" style="width: 150px">单据号</th>
                    <th class="text-center sorting" style="width: 150px">公司</th>
                    <th class="text-center sorting" style="width: 150px">盘点日期</th>
                    <th class="text-center sorting" style="width: 150px">仓库</th>
                    <th class="text-center sorting" style="width: 150px">库存员</th>
                    <th class="text-center sorting" style="width: 150px">部门</th>
                    <th class="text-center sorting" style="width: 150px">盘点人</th>
                    <th class="text-center sorting" style="width: 150px">单据状态</th>
                    <th class="text-center sorting" style="width: 150px">制单日期</th>
                    <th class="text-center sorting" style="width: 150px">制单人</th>
                    <th class="text-center sorting" style="width: 150px">审批人</th>
                    <th class="text-center sorting" style="width: 150px">修改人</th>
                    <th class="text-center sorting" style="width: 150px">修改日期</th>
                    <th class="text-center sorting" style="width: 150px">调整人</th>
                    <th class="text-center sorting" style="width: 150px">调整日期</th>
                    </thead>
                    <%--内容--%>
                    <tbody id="zhub_tbody">

                    </tbody>
                </table>
            </div>
        </from>
        <span id="zhub_count" count="">共 0 条记录</span>
        <br><br>
        <div class="form-group">
            <input id="djh" class="form-control" type="text" readonly="readonly" style="width: 17%;"
                   placeholder="双击已查询的单据号进行选择" value="">
        </div>
        <%--2：子表--%>
        <from id="zib_form" zhub_id="-1">
            <div style="padding-left: 20px;"><h4><%--子表--%></h4></div>
            <div style="overflow: scroll;overflow-y:scroll;height: 200px;width: 99%;">
                <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                       style="min-width:2000px;border:solid grey 1px">
                    <thead>
                    <th class="" style="padding-right:0px;">
                        <input id="selall_zi" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc" width="150px">行号</th>
                    <th class="text-center sorting" width="150px">存货编号</th>
                    <th class="text-center sorting" width="150px">型号</th>
                    <th class="text-center sorting" width="150px">计量单位</th>
                    <th class="text-center sorting" width="150px">规格</th>
                    <th class="text-center sorting" width="150px">批次</th>
                    <th class="text-center sorting" width="150px">生产日期</th>
                    <th class="text-center sorting" width="150px">失效日期</th>
                    <th class="text-center sorting" width="150px">账面数量</th>
                    <th class="text-center sorting" width="150px">盘点数量</th>
                    <th class="text-center sorting" width="150px">差异数量</th>
                    <th class="text-center sorting" width="150px">调整数量</th>
                    <th class="text-center sorting" width="150px">损失率</th>
                    </thead>
                    <%--内容--%>
                    <tbody id="zib_tbody">
                    </tbody>
                </table>
            </div>
        </from>
        <span id="zib_count" count="">共 0 条记录</span>
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
            showSeconds:true,
        });

    });

    function statusbe(x){
        if (x == 1){
            return "审批";
        }
        if (x == 0){
            return "不审批";
        }
        return "";
    }

    /*发表单查询*/
    $(document).ready(function () {

        /*start*/
        //功能：主表：点击查询按钮，根据主表一部分信息查询出所有满足的主表集合 --->注意 sql: Spr IS NULL;
        $("#query").click(function () {
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/pd/findByCondition",
                type: "post",
                data: params,
                dataType: "json",
                async: false,
                success: function (data) {
                    //清除$("#zhub_tbody")里面的内容
                    $("#zhub_tbody").innerHTML = '';
                    var pd_zhubs = data;


                    var html = '';
                    for (var i = 0; i < pd_zhubs.length; i++) {

                        html += '<tr>\n' +
                            '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhub_ids" type="checkbox" value="' + pd_zhubs[i].id+ '"></td>\n' +
                            '<td><button i="' + i + '" ddh="' + pd_zhubs[i].djh + '" checked="" ondblclick="find_zib(this)" zhubId="' + pd_zhubs[i].id + '" style="width: 100%;height: 99%">' + pd_zhubs[i].djh + '</button></td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].gs) + '</td>\n' +
                            '<td>' + FormatTime(pd_zhubs[i].pdrq)+ '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].ck ) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].kcy) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].bm) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].pdr ) + '</td>\n' +
                            '<td>' + statusbe(pd_zhubs[i].status) + '</td>\n' +
                            '<td>' + FormatTime(pd_zhubs[i].zdrq) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].zdr) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].spr) + '</td>\n' +
                            '<td>' + FormatTime(pd_zhubs[i].sprq) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].xgr) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].xgrq) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].tzr) + '</td>\n' +
                            '<td>' + NoNull(pd_zhubs[i].tzrq) + '</td>\n' +
                            '</tr>';
                    }
                    $("#zhub_tbody").html(html);
                    $("#zhub_count").html("共 " + pd_zhubs.length + " 条记录");
                    $("#zhub_count").attr("count", pd_zhubs.length);
                },
                error: function () {
                    alert("查询失败！")
                }
            });
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
    /*7*/
    //功能：双击主表总ddh按钮触发，根据主表的id查询所有的子表信息，并添加到子表
    function find_zib(x) {
        //移除属性checked
        $(".my-checkbox").removeAttr('checked');
        //把当前设置为true
        var i = $(x).attr("i");
        $("#checkbox-pos-" + i).prop("checked", true);
        //获取id
        var pd_zhub_id = $(x).attr("zhubId");
        //获取ddh:对应了子表上面的 单据号：input[xxx],将单据号添加到里面显示，方便查看
        var djh = $(x).attr("ddh");
        $.ajax({
            url: "${pageContext.request.contextPath}/pd/findZiByZid",
            type: "GET",
            data: {"zid": pd_zhub_id},
            dataType: "json",
            async: false,
            success: function (data) {
                //先清除$("#zib_tbody")里面的内容
                $("#zib_tbody").innerHTML = '';

                //给子表form的zhub_id赋值
                $("#zib_form").attr("zhub_id", pd_zhub_id);
                /*单据号：<input id="djh"...*/
                $("#djh").attr("value", djh);
                //添加内容
                pd_zibs = data;
                var html = '';
                for (var i = 0; i < pd_zibs.length; i++) {
                    html += '<tr>\n' +
                        '<td><input name="zib_ids" type="checkbox" value="' + pd_zibs[i].id + '"></td>\n' +
                        '<td>' + NoNull(pd_zibs[i].hh) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].chbm) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].xh) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].dw) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].gg) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].pc) + '</td>\n' +
                        '<td>' + FormatTime(pd_zibs[i].scrq) + '</td>\n' +
                        '<td>' + FormatTime(pd_zibs[i].sxrq) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].zmsl) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].pdsl) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].cysl) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].tzsl) + '</td>\n' +
                        '<td>' + NoNull(pd_zibs[i].sslv) + '</td>\n' +
                        '</tr>';
                }
                $("#zib_tbody").html(html);
                $("#zib_count").attr("count", pd_zibs.length);
                $("#zib_count").html("共 " + pd_zibs.length + " 条记录");
            },
            error: function () {
                alert("查询失败！")
            }
        });
    }

</script>


</body>

</html>

