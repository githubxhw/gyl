<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>采购发票制单</title>
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
                采购发票-制单
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
                            <div class="col-md-2 title">公司</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="gs"
                                       placeholder="公司" value="">
                            </div>
                            <div class="col-md-2 title">发票号</div>
                            <div class="col-md-4 data">
                                <input readonly="readonly" type="text" class="form-control" name="fph"
                                       placeholder="发票号" value="${fph}">
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
                                    <input type="text" class="form-control pull-right dateTimePicker" name="zdrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">审批人</div>
                            <div class="col-md-4 data">
                                <input readonly="readonly" type="text" class="form-control" name="spr"
                                       placeholder="审核人" value="">
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
                                    <option value="0">否</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">审批是否通过</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="spsftg">
                                    <option value="0">否</option>
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
                                    <input readonly="readonly" type="text" class="form-control pull-right" name="xgrq">
                                </div>
                            </div>
                            <div class="col-md-2 title">单据状态</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="status">
                                    <option value="0">未结束</option>
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
                        <th class="text-center sorting" width="200px">行号</th>
                        <th class="text-center sorting" width="200px">来源单据号</th>
                        <th class="text-center sorting" width="200px">来源行号</th>
                        <th class="text-center sorting" width="200px">源头单据号</th>
                        <th class="text-center sorting" width="200px">源头行号</th>
                        <th class="text-center sorting" width="200px">存货编码</th>
                        <th class="text-center sorting" width="200px">存货名称</th>
                        <th class="text-center sorting" width="200px">规格</th>
                        <th class="text-center sorting" width="200px">型号</th>
                        <th class="text-center sorting" width="200px">无税单价</th>
                        <th class="text-center sorting" width="200px">批次</th>
                        <th class="text-center sorting" width="200px">应开数量</th>
                        <th class="text-center sorting" width="200px">实开数量</th>
                        <th class="text-center sorting" width="200px">金额</th>
                        <th class="text-center sorting" width="200px">含税单价</th>
                        <th class="text-center sorting" width="200px">税率</th>
                        <th class="text-center sorting" width="200px">税额</th>
                        <th class="text-center sorting" width="200px">无税金额</th>
                        <th class="text-center sorting" width="200px">累计发票数量</th>
                        <th class="text-center sorting" width="200px">状态</th>
                        </thead>
                        <%--内容--%>
                        <tbody id="zib_tbody">

                        </tbody>
                    </table>
                </div>
                <%--zib /--%>
                <br><br>
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

    $(document).ready(function () {
        //功能：保存主表和子表信息,返回成功即跳转到新页面，失败提示
        $("#save_button").click(function () {
            //alert("ok")
            var params = $("#form").serialize();
            // console.log($("#form").serializeArray()[0].value);
            // alert($("#zib_tbody").);


                $.ajax({
                    url: "${pageContext.request.contextPath}/cgfp/saveZhubAndZib",
                    type: "post",
                    data: params,
                    dataType: "text",
                    async: false,
                    success: function () {
                        //添加主表信息到页面
                        alert("添加成功!");
                        window.location.href = "${pageContext.request.contextPath}/cgfp/getFphToAddUI";
                    },
                    error: function () {
                        alert("添加失败！")
                    }
                });


        });
        //spbm  dpzk
        //功能：点击跳转到query.jsp
        $("#toquery_button").click(function () {
            window.location.href = "${pageContext.request.contextPath}/pages/business/cgfp-query.jsp";
        });
    });

    //功能： 点击 按钮+号，在子表中添加一列
  function add_zib(x) {
        //获取hh
        var befCount = parseInt($("#zib_hh").attr("hh"));
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
            var text = $("#chbm-" + pos).val();
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
            var str = '<tr id="' + nowCount + '">' +
                '<td>                            <button pos="' + nowCount + '" onclick="delete_zib(this)" type="button" class="btn btn-default" title="添加">\n' +
                '                                    <i></i><span style="font-size: 15px">-</span>\n' +
                '                                </button>' +
                '</td>' +
                '<td>                            <input id="hh-' + nowCount + '"  class="form-control" name="cgfp_zibs[' + nowCount + '].hh"\n' +
                '                                   placeholder="行号" value="' + nowCount + '"></td>\n' +
                '<td>                            <input id="lydjh-' + nowCount + '" type="text" class="form-control"  name="cgfp_zibs[' + nowCount + '].lydjh" ' +
                '                                   placeholder="来源单据号" value=""></td>\n' +
                '<td>                            <input id="lyhh-' + nowCount + '" type="text" class="form-control" i = "'+nowCount+'" onblur = "BlanksByLy(this)" name="cgfp_zibs[' + nowCount + '].lyhh"\n' +
                '                                   placeholder="来源行号" value=""></td>\n' +
                '<td>                            <input id="ytdjd-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].ytdjd"\n' +
                '                                   placeholder="源头单据号" value=""></td>\n' +
                '<td>                            <input id="ythh-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].ythh"\n' +
                '                                   placeholder="源头行号" value=""></td>\n' +
                '<td>                            <input id="chbm-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].chbm"\n' +
                '                                   placeholder="存货编码" value=""></td>\n' +
                '<td>                            <input id="chmc-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].chmc"\n' +
                '                                   placeholder="存货名称"></td>\n' +
                '<td>                            <input id="gg-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].gg"\n' +
                '                                   placeholder="规格" value=""></td>\n' +
                '<td>                            <input id="xh-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].xh"\n' +
                '                                   placeholder="商品型号" value=""></td>\n' +
                '<td>                            <input id="wsdj-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].wsdj"\n' +
                '                                   placeholder="无税单价" value=""></td>\n' +
                '<td>                            <input id="pc-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].pc"\n' +
                '                                   placeholder="批次" value=""></td>\n' +
                '<td>                            <input id="ykpsl-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].ykpsl"\n' +
                '                                   placeholder="应开数量" value=""></td>\n' +
                '<td>                            <input id="fpsl-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].fpsl"\n' +
                '                                   placeholder="实开数量" value=""></td>\n' +
                '<td>                            <input id="je-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].je"\n' +
                '                                   placeholder="金额" value=""></td>\n' +
                '<td>                            <input id="hsdj-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].hsdj" ' +
                '                                   placeholder="含税单价" value=""></td>\n' +
                '<td>                            <input id="sl-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].sl" ' +
                '                                   placeholder="税率" value=""></td>\n' +
                '<td>                            <input id="se-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].se" ' +
                '                                   placeholder="税额" value=""></td>\n' +
                '<td>                            <input id="wsje-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].wsje" ' +
                '                                   placeholder="无税金额" value=""></td>\n' +
                '<td>                            <input id="ljfpsl-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].ljfpsl" ' +
                '                                   placeholder="累计开票数量" value=""></td>\n' +
                '<td>                            <select id="status-' + nowCount + '" type="text" class="form-control" name="cgfp_zibs[' + nowCount + '].status">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +
                '</tr>';
            $("#zib_tbody").append(str);
            $("#zib_hh").attr("hh", nowCount);
        }
    }


    function checkydsl(x,y,i) {

        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/BlanksByYt",
            type: "get",
            data: {"ytdjh":x,"ythh":y},
            dataType: "json",
            async: false,
            success:function (data) {
                var pageInfo = data;
                var msgs = pageInfo.msgList;
                let backResult = pageInfo.backResult;
                if (pageInfo.resFlag == "1") {//修改成功
                    $("#wsdj-"+i).attr("value",backResult.wsdj);
                    $("#hsdj-"+i).attr("value",backResult.hsdj);
                    $("#sl-"+i).attr("value",backResult.shuilv);
                    $("#wsje-"+i).attr("value",backResult.wsje);
                    $("#ljfpsl-"+i).attr("value",backResult.ljkpsl);
                    $("#se-"+i).attr("value",backResult.se);
                    $("#gg-"+i).attr("value",backResult.gg);
                    $("#xh-"+i).attr("value",backResult.xh);
                } else {//修改失败
                    var msg = "查询失败:\n";
                    for (var j = 0; j < msgs.length; j++) {
                        msg += j + "、" + msgs[j] + "\n";
                    }
                    alert(msg);
                }

            }
        });
    }


    function BlanksByLy(x) {
        var i = $(x).attr("i");
        var ythh = $("#lyhh-"+i).val();
        var ytdjh = $("#lydjh-"+i).val();
        $.ajax({
            url: "${pageContext.request.contextPath}/cgfp/BlanksByLy",
            type: "get",
            data: {"lydjh":ytdjh,"lyhh":ythh},
            dataType: "json",
            async: false,
            success:function (data) {
                var pageInfo = data;
                var msgs = pageInfo.msgList;
                var backResult = pageInfo.backResult;
                if (pageInfo.resFlag == "1") {//修改成功
                    $("#dj-"+i).attr("value",backResult.dj);
                    $("#je-"+i).attr("value",backResult.je);
                    $("#chbm-" + i).attr("value",backResult.spbm);
                    $("#chmc-"+i).attr("value",backResult.spmc);
                    $("#ythh-"+i).attr("value",backResult.ythh);
                    $("#ytdjd-"+i).attr("value",backResult.ytdjh);
                    $("#ykpsl-"+i).attr("value",backResult.dhwkpsl);
                    var ythh = $("#ythh-"+i).val();
                    var ytdjh = $("#ytdjd-"+i).val();
                    if (ythh != ""&&ytdjh !=""){
                        checkydsl(ytdjh,ythh,i);
                    }

                } else {//修改失败
                    var msg = "查询应到数量信息失败:\n";
                    for (var j = 0; j < msgs.length; j++) {
                        msg += j + "、" + msgs[j] + "\n";
                    }
                    alert(msg);
                }

            }
        });
    }
    //功能： 点击 按钮-号，在子表中删除当前列
    function delete_zib(x) {
        var pos = $(x).attr("pos");
        $("#" + pos).remove();
    }


</script>


</body>

</html>



