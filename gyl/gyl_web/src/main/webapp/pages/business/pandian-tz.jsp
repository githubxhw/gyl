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
    <title>盘点单调整</title>
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

                盘点单-调整
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
                    <a href="#">盘点管理</a>
                </li>
                <li class="active">调整</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <%--查询部分--%>
        <%-- id = query 按钮查询--%>
        <form id="form" method="post">
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">查询</div>
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
                                </select>
                            </div>

                            <%--4--%>

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
                    <thead>
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
                       style="min-width:2150px;border:solid grey 1px">
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
                    <th class="text-center sorting" width="150px">操作</th>
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

        <%--工具栏--%>

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
    /*发表单查询*/
    $(document).ready(function () {

        /*start*/
        //功能：主表：点击查询按钮，根据主表一部分信息查询出所有满足的主表集合
        $("#query").click(function () {
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/pd/findBySpIsOne",
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
                            '<td><input id="checkbox-pos-' + i + '" class="ids my-checkbox" name="zhub_ids" type="checkbox"  value="' + pd_zhubs[i].id+ '"></td>\n' +
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



    function statusbe(x){
        var k = "审批";
        if(x == 1){
            return k;
        }else{
            if(x == 0){
                return "不审批";
            }else{
                return "";
            }

        }
    }
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
            url: "${pageContext.request.contextPath}/pd/findZiByZid",
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
                        '<td class="text-center">\n' +
                        '<button id="zib_xg_btn" i="' + i + '" zibId="' + pd_zibs[i].id+ '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
                        '    >\n' +
                        '    调整\n' +
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
                        '                                                            <div class="panel-heading">盘点单子单</div>\n' +
                        '                                                            <div class="row data-type">\n' +
                        '                        <input id="pdzhib_zid-' + i + '" type="hidden" name="zid" value="">\n' + /*主表id--》外键*/
                        '                        <input id="pdzhib_id-' + i + '" type="hidden" name="id" value="">\n' + /*子表id*/
                        '                        <div class="col-md-2 title">行号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="pdzhib_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                        '                                   placeholder="行号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">存货编码</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="pdzhib_chbm-' + i + '" type="text" readonly="readonly"  class="form-control" name="chbm"\n' +
                        '                                   placeholder="存货编码" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">规格</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="pdzhib_gg-' + i + '" type="text" readonly="readonly"  class="form-control" name="gg"\n' +
                        '                                   placeholder="规格" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">型号</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="pdzhib_xh-' + i + '" type="text" class="form-control" name="xh" readonly="readonly"\n' +
                        '                                   placeholder="型号" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">计量单位</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="pdzhib_dw-' + i + '" type="text" class="form-control" name="dw" readonly="readonly"\n' +
                        '                                   placeholder="计量单位" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">批次</div>\n' +
                        '                        <div class="col-md-2 data">\n' +
                        '                            <input id="pdzhib_pc-' + i + '" type="text" class="form-control" name="pc" readonly="readonly"\n' +
                        '                                   placeholder="批次" value="">\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title"></div>\n' +
                        '                        <div class="col-md-2 title">生产日期</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                           <div class="input-group date">\n' +
                        '                                 <div class="input-group-addon">\n' +
                        '                                      <i class="fa fa-calendar"></i>\n' +
                        '                                  </div>\n' +
                        '                               <input  id="pdzhib_scrq-' + i + '" readonly="readonly" type="text"\n' +
                        '                                   class="form-control pull-right dateTimePicker"\n' +
                        '                                   name="scrq">\n' +
                        '                            </div>\n' +
                        '                         </div>\n' +
                        '                        <div class="col-md-2 title">失效日期</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                           <div class="input-group date">\n' +
                        '                                 <div class="input-group-addon">\n' +
                        '                                      <i class="fa fa-calendar"></i>\n' +
                        '                                  </div>\n' +
                        '                               <input  id="pdzhib_sxrq-' + i + '"readonly="readonly"  type="text"\n' +
                        '                                   class="form-control pull-right dateTimePicker"\n' +
                        '                                   name="sxrq">\n' +
                        '                            </div>\n' +
                        '                         </div>\n' +
                        '                        <div class="col-md-2 title">账面数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="pdzhib_zmsl-' + i + '" type="text" readonly="readonly" class="form-control" name="zmsl">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">盘点数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="pdzhib_pdsl-' + i + '" type="text"class="form-control" name="pdsl">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">差异数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +
                        '                                <input id="pdzhib_cysl-' + i + '" type="text" readonly="readonly" class="form-control" name="cysl">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">调整数量</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <div class="input-group">\n' +

                        '                                <input id="pdzhib_tzsl-' + i + '" type="text"  class="form-control" name="tzsl">\n' +
                        '                            </div>\n' +
                        '                        </div>\n' +
                        '                        <div class="col-md-2 title">损失率</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                            <input id="pdzhib_sslv-' + i + '" type="text" readonly="readonly"  class="form-control" name="sslv"\n' +
                        '                                   placeholder="损失率" value="">\n' +
                        '                        </div>' +

                        '                          <div class="col-md-2 title">调整人</div>\n' +
                        '                              <div class="col-md-4 data">\n' +
                        '                                  <input  id="pdzhib_tzr-' + i + '" type="text" class="form-control" name="tzr"\n' +
                        '                                        placeholder="调整人" value="">\n' +
                        '                               </div>\n' +
                        '                        <div class="col-md-2 title">调整日期</div>\n' +
                        '                        <div class="col-md-4 data">\n' +
                        '                           <div class="input-group date">\n' +
                        '                                 <div class="input-group-addon">\n' +
                        '                                      <i class="fa fa-calendar"></i>\n' +
                        '                                  </div>\n' +
                        '                               <input  id="pdzhib_tzrq-' + i + '" type="text"\n' +
                        '                                   class="form-control pull-right dateTimePicker"\n' +
                        '                                   name="tzrq">\n' +
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
                        '                                        <button zibId="' + pd_zibs[i].id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                        '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                        '                                    </div>\n' +
                        '                                </div>\n' +
                        '                                <!-- /.modal-content -->\n' +
                        '                            </div>\n' +
                        '\n' +
                        '                            <!-- /.modal-dialog -->\n' +
                        '                        </div>' +
                        '</td>\n' +
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

    function updateZibById(x) {
        //获取点击了该修改按钮所在的行号i
        var i = $(x).attr("i");
        //表单数据
        var params = $("#zib_xg_form-" + i).serialize();

        if($("#pdzhib_tzsl-"+i).val() !== ""){


            if($("#pdzhib_tzr-"+i).val() === ""||$("#pdzhib_tzrq-"+i).val() === ""){
                alert("请输入调整人和调整日期")
            }else {

                    $.ajax({
                        url: "${pageContext.request.contextPath}/pd/TiaoZ",
                        type: "post",
                        data: params,
                        dataType: "json",
                        // async: false,
                        success: function (data) {
                            $("#zib_refresh_btn").trigger("click");
                            alert(data.msg);


                        },
                        error: function () {
                            alert("调整失败！")
                        }
                    });


            }
        }else {
            alert("没写调整数量");
        }

    }
    /*8*/
    //功能：单击 子表中的 修改按钮，把该行的信息填充到模拟div中
    function zib_xg_btn(x) {
        var pd_zib_id = $(x).attr("zibId");
        $.ajax({
            url: "${pageContext.request.contextPath}/pd/findZiById",
            type: "get",
            data: {"id": pd_zib_id},
            dataType: "json",
            async: false,
            success: function (data) {
                var pd_zib = data;
                //添加数据到模态框中
                //1,获取点击了该修改按钮所在的行号i
                var i = $(x).attr("i");

                //2,给每一个按钮框添加值
                $("#pdzhib_zid-" + i).attr("value", pd_zib.zid); /*主表d --》外键*/
                $("#pdzhib_id-" + i).attr("value", pd_zib.id);/*子表id*/
                $("#pdzhib_hh-" + i).attr("value", pd_zib.hh);
                $("#pdzhib_chbm-" + i).attr("value", pd_zib.chbm);
                $("#pdzhib_gg-" + i).attr("value", pd_zib.gg);
                $("#pdzhib_xh-" + i).attr("value", pd_zib.xh);
                $("#pdzhib_dw-" + i).attr("value", pd_zib.dw);
                $("#pdzhib_pc-" + i).attr("value", pd_zib.pc);
                $("#pdzhib_scrq-" + i).attr("value", FormatTime(pd_zib.scrq));
                $("#pdzhib_sxrq-" + i).attr("value", FormatTime(pd_zib.sxrq));
                $("#pdzhib_zmsl-" + i).attr("value", pd_zib.zmsl);
                $("#pdzhib_pdsl-" + i).attr("value", pd_zib.pdsl);
                $("#pdzhib_cysl-" + i).attr("value", pd_zib.cysl);
                $("#pdzhib_sslv-" + i).attr("value", pd_zib.sslv);

            },
            error: function (data) {
                alert("无响应!");
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
                url: "${pageContext.request.contextPath}/pd/findZiByZid",
                type: "GET",
                data: {"zid": zhub_id},
                dataType: "json",
                async: false,
                success: function (data) {
                    //先清除$("#zib_tbody")里面的内容
                    $("#zib_tbody").innerHTML = '';
                    //给子表form的zhub_id赋值
                    $("#zib_form").attr("zhub_id", zhub_id);
                    /*单据号：<input id="djh"...*/
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
                            '<td class="text-center">\n' +
                            '<button id="zib_xg_btn" i="' + i + '" zibId="' + pd_zibs[i].id+ '" onclick="zib_xg_btn(this)" type="button" data-toggle="modal" data-target="#myModal-zib-' + i + '" class="btn bg-olive btn-xs"\n' +
                            '    >\n' +
                            '    调整\n' +
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
                            '                                                            <div class="panel-heading">盘点单子单</div>\n' +
                            '                                                            <div class="row data-type">\n' +
                            '                        <input id="pdzhib_zid-' + i + '" type="hidden" name="zid" value="">\n' + /*主表id--》外键*/
                            '                        <input id="pdzhib_id-' + i + '" type="hidden" name="id" value="">\n' + /*子表id*/
                            '                        <div class="col-md-2 title">行号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="pdzhib_hh-' + i + '" type="text" readonly="readonly"  class="form-control" name="hh"\n' +
                            '                                   placeholder="行号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">存货编码</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="pdzhib_chbm-' + i + '" type="text" readonly="readonly"  class="form-control" name="chbm"\n' +
                            '                                   placeholder="存货编码" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">规格</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="pdzhib_gg-' + i + '" type="text" readonly="readonly"  class="form-control" name="gg"\n' +
                            '                                   placeholder="规格" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">型号</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="pdzhib_xh-' + i + '" type="text" class="form-control" name="xh" readonly="readonly"\n' +
                            '                                   placeholder="型号" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">计量单位</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="pdzhib_dw-' + i + '" type="text" class="form-control" name="dw" readonly="readonly"\n' +
                            '                                   placeholder="计量单位" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">批次</div>\n' +
                            '                        <div class="col-md-2 data">\n' +
                            '                            <input id="pdzhib_pc-' + i + '" type="text" class="form-control" name="pc" readonly="readonly"\n' +
                            '                                   placeholder="批次" value="">\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title"></div>\n' +
                            '                        <div class="col-md-2 title">生产日期</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                           <div class="input-group date">\n' +
                            '                                 <div class="input-group-addon">\n' +
                            '                                      <i class="fa fa-calendar"></i>\n' +
                            '                                  </div>\n' +
                            '                               <input  id="pdzhib_scrq-' + i + '" readonly="readonly" type="text"\n' +
                            '                                   class="form-control pull-right dateTimePicker"\n' +
                            '                                   name="scrq">\n' +
                            '                            </div>\n' +
                            '                         </div>\n' +
                            '                        <div class="col-md-2 title">失效日期</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                           <div class="input-group date">\n' +
                            '                                 <div class="input-group-addon">\n' +
                            '                                      <i class="fa fa-calendar"></i>\n' +
                            '                                  </div>\n' +
                            '                               <input  id="pdzhib_sxrq-' + i + '"readonly="readonly"  type="text"\n' +
                            '                                   class="form-control pull-right dateTimePicker"\n' +
                            '                                   name="sxrq">\n' +
                            '                            </div>\n' +
                            '                         </div>\n' +
                            '                        <div class="col-md-2 title">账面数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <input id="pdzhib_zmsl-' + i + '" type="text" readonly="readonly" class="form-control" name="zmsl">\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">盘点数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <input id="pdzhib_pdsl-' + i + '" type="text"class="form-control" name="pdsl">\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">差异数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +
                            '                                <input id="pdzhib_cysl-' + i + '" type="text" readonly="readonly" class="form-control" name="cysl">\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">调整数量</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <div class="input-group">\n' +

                            '                                <input id="pdzhib_tzsl-' + i + '" type="text" readonly="readonly" class="form-control" name="tzsl">\n' +
                            '                            </div>\n' +
                            '                        </div>\n' +
                            '                        <div class="col-md-2 title">损失率</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                            <input id="pdzhib_sslv-' + i + '" type="text" readonly="readonly"  class="form-control" name="sslv"\n' +
                            '                                   placeholder="损失率" value="">\n' +
                            '                        </div>' +

                            '                          <div class="col-md-2 title">调整人</div>\n' +
                            '                              <div class="col-md-4 data">\n' +
                            '                                  <input  id="pdzhib_tzr-' + i + '" type="text" class="form-control" name="tzr"\n' +
                            '                                        placeholder="调整人" value="">\n' +
                            '                               </div>\n' +
                            '                        <div class="col-md-2 title">调整日期</div>\n' +
                            '                        <div class="col-md-4 data">\n' +
                            '                           <div class="input-group date">\n' +
                            '                                 <div class="input-group-addon">\n' +
                            '                                      <i class="fa fa-calendar"></i>\n' +
                            '                                  </div>\n' +
                            '                               <input  id="pdzhib_pdrq-' + i + '" type="text"\n' +
                            '                                   class="form-control pull-right dateTimePicker"\n' +
                            '                                   name="tzrq">\n' +
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
                            '                                        <button zibId="' + pd_zibs[i].id + '" i="' + i + '" onclick="updateZibById(this)" type="button" class="btn btn-outline" data-dismiss="modal">修改</button>\n' +
                            '                                        <button type="button" class="btn btn-outline" data-dismiss="modal">取消</button>\n' +
                            '                                    </div>\n' +
                            '                                </div>\n' +
                            '                                <!-- /.modal-content -->\n' +
                            '                            </div>\n' +
                            '\n' +
                            '                            <!-- /.modal-dialog -->\n' +
                            '                        </div>' +
                            '</td>\n' +
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
    }






</script>


</body>

</html>


