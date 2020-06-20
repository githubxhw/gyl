<%--
  Created by IntelliJ IDEA.
  User: HR
  Date: 2020/4/17
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
    <title>销售开票单添加</title>
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
                销售出库单
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
                    <a href="#">销售开票单管理</a>
                </li>
                <li class="active">添加</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form id="form" method="post">
            <section class="content">
                <!-- zhub -->
                <div class="panel panel-default">
                    <div class="panel-heading">填写销售开票单信息进行添加</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">开票号</div>
                        <div class="col-md-4 data">
                            <input readonly="readonly" type="text" class="form-control" name="fph"
                                   placeholder="开票号" value="${djh}">
                        </div>
                        <div class="col-md-2 title">开票日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right dateTimePicker" name="kprq">
                            </div>
                        </div>
                        <div class="col-md-2 title">发票类型</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="fplx"
                                   placeholder="发票类型" value="">
                        </div>
                        <div class="col-md-2 title">会计年度</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right dateTimePicker" name="kjnd">
                            </div>
                        </div>
                        <div class="col-md-2 title">客户</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="kh"
                                   placeholder="客户" value="">
                        </div>
                        <div class="col-md-2 title">客户打印名称</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="khdymc"
                                   placeholder="客户打印名称" value="">
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
                        <div class="col-md-2 title">收货单位</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="shdw"
                                   placeholder="收货单位" value="">
                        </div>
                        <div class="col-md-2 title">收货地址</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="shdz"
                                   placeholder="收货地址" value="">
                        </div>
                        <div class="col-md-2 title">整单折扣</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="zdzk"
                                   placeholder="整单折扣" value="">
                        </div>
                        <div class="col-md-2 title">仓库</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="ck"
                                   placeholder="仓库" value="">
                        </div>
                        <div class="col-md-2 title">币种</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="bz"
                                   placeholder="币种" value="">
                        </div>
                        <div class="col-md-2 title">发票总金额</div>
                        <div class="col-md-4 data">
                            <div class="input-group">
                                <span class="input-group-addon">¥</span>
                                <input type="text" class="form-control"
                                       name="fpzje">
                                <span class="input-group-addon">元</span>
                            </div>
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
                        <div class="col-md-2 title">应收款是否结束</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="ysksfjs">
                                <option value="0">否</option>
                            </select>
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
                <br>
                <br>
                <%--zib--%>
                <span hh="0" id="zib_hh"></span><%--记录子表的条数--%>
                <div style="overflow: scroll;overflow-y:scroll;height: 300px;width: 100%;">
                    <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                           style="min-width:4000px;border:solid grey 1px">
                        <thead>

                        <th class="text-center" width="10px">
                            <div class="btn-group">
                                <button onclick="add_zib(this)" type="button" class="btn btn-default" title="添加">
                                    <i></i><span style="font-size: 15px">+</span>
                                </button>
                            </div>
                        </th>
                        <th class="sorting_asc" width="350px">行号</th>
                        <th class="text-center sorting" width="350px">商品编码</th>
                        <th class="text-center sorting" width="350px">商品名称</th>
                        <th class="text-center sorting" width="350px">规格</th>
                        <th class="text-center sorting" width="350px">计量单位</th>
                        <th class="text-center sorting" width="350px">型号</th>
                        <th class="text-center sorting" width="350px">数量</th>
                        <th class="text-center sorting" width="350px">税率</th>
                        <th class="text-center sorting" width="350px">单品折扣</th>
                        <th class="text-center sorting" width="350px">整单折扣</th>
                        <th class="text-center sorting" width="350px">发票折扣</th>
                        <th class="text-center sorting" width="350px">含税单价</th>
                        <th class="text-center sorting" width="350px">无税单价</th>
                        <th class="text-center sorting" width="350px">含税金额</th>
                        <th class="text-center sorting" width="350px">无税金额</th>
                        <th class="text-center sorting" width="350px">折扣额</th>
                        <th class="text-center sorting" width="350px">源头单据号</th>
                        <th class="text-center sorting" width="350px">源头行号</th>
                        <th class="text-center sorting" width="350px">来源单据号</th>
                        <th class="text-center sorting" width="350px">来源行号</th>
                        <th class="text-center sorting" width="350px">是否为赠品</th>
                        <th class="text-center sorting" width="350px">仓库</th>
                        <th class="text-center sorting" width="350px">收货单位</th>
                        <th class="text-center sorting" width="350px">累计开票数量</th>
                        <th class="text-center sorting" width="350px">累计应收款数量</th>
                        <th class="text-center sorting" width="350px">是否应收款结束</th>
                        <th class="text-center sorting" width="350px">单据状态</th>
                        </thead>
                        <%--内容--%>
                        <tbody id="zib_tbody">

                        </tbody>
                    </table>
                </div>
                <%--zib /--%>
                <br>
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
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/xskpd/saveZhubAndZib",
                type: "post",
                data: params,
                dataType: "json",
                async: false,
                type: "post",
                data: params,
                dataType: "json",
                async: false,
                success: function (data) {
                    var info = data;
                    var msgList = info.msgList;
                    var resFlag = info.resFlag;
                    alert(resFlag)
                    if(resFlag == "1"){ //成功
                        alert("添加成功!");
                        window.location.href = "${pageContext.request.contextPath}/xskpd/getDdhToAddUI";
                    }else { //失败
                        alert("添加失败:"+msgList);
                    }
                },
                error: function () {
                    alert("其他异常，添加失败！");
                }
            });
        });

        //功能：点击跳转到query.jsp
        $("#toquery_button").click(function () {
            window.location.href = "${pageContext.request.contextPath}/pages/business/xskpd-query.jsp";
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
            var str = '<tr id="' + nowCount + '">' +
                '<td>                            <button pos="' + nowCount + '" onclick="delete_zib(this)" type="button" class="btn btn-default" title="添加">\n' +
                '                                    <i></i><span style="font-size: 15px">-</span>\n' +
                '                                </button>' +
                '</td>' +
                '<td>                            <input id="hh-' + nowCount + '" type="text" readonly="readonly"  class="form-control" name="xskpd_zibs[' + nowCount + '].hh"\n' +
                '                                   placeholder="行号" value="' + nowCount + '"></td>\n' +
                '<td>                            <input id="spbm-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].spbm"\n' +
                '                                   placeholder="商品编码(不为空)"></td>\n' +
                '<td>                            <input id="spmc-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].spmc"\n' +
                '                                   placeholder="商品名称" value=""></td>\n' +
                '<td>                            <input id="gg-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].gg"\n' +
                '                                   placeholder="规格" value=""></td>\n' +
                '<td>                            <input id="dw-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].dw"\n' +
                '                                   placeholder="计量单位" value=""></td>\n' +
                '<td>                            <input id="type-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].type"\n' +
                '                                   placeholder="型号" value=""></td>\n' +
                '<td>                            <input id="count-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].count"\n' +
                '                                   placeholder="数量" value=""></td>\n' +
                '<td>                            <input id="rate-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].rate"\n' +
                '                                   placeholder="税率" value=""></td>\n' +
                '<td>                            <input id="dpzk-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].dpzk"\n' +
                '                                   placeholder="单品折扣" value=""></td>\n' +
                '<td>                            <input id="zdzk-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].zdzk"\n' +
                '                                   placeholder="整单折扣" value=""></td>\n' +
                '<td>                            <input id="fpzk-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].fpzk"\n' +
                '                                   placeholder="发票折扣" value=""></td>\n' +
                '<td>                            <input id="hsdj-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].hsdj"\n' +
                '                                   placeholder="含税单价" value=""></td >\n' +
                '<td>                            <input id="wsdj-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].wsdj"\n' +
                '                                   placeholder="无税单价" value=""></td >\n' +
                '<td>                            <input id="hsje-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].hsje"\n' +
                '                                   placeholder="含税金额" value=""></td>\n' +
                '<td>                            <input id="wsje-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].wsje"\n' +
                '                                   placeholder="无税金额" value=""></td>\n' +
                '<td>                            <input id="zke-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].zke"\n' +
                '                                   placeholder="折扣额" value=""></td>\n' +
                '<td>                            <input id="ytdjh-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].ytdjh" ' +
                '                                   placeholder="源头单据号" value=""></td>\n' +
                '<td>                            <input id="ythh-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].ythh"\n' +
                '                                   placeholder="源头行号" value=""></td>\n' +
                '<td>                            <input id="lydjh-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].lydjh"\n' +
                '                                   placeholder="来源单据号" value=""></td>\n' +
                '<td>                            <input id="lyhh-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].lyhh"\n' +
                '                                   placeholder="来源行号" value=""></td>\n' +
                '<td>                            <select id="zp-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].zp">\n' +
                '                                   <option selected="selected" value="0">否</option>' +
                '                                   <option value="1">是</option>' +
                '                                </select></td>\n' +
                '<td>                            <input id="ck-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].ck" ' +
                '                                   placeholder="仓库" value=""></td>\n' +
                '<td>                            <input id="shdw-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].shdw" ' +
                '                                   placeholder="收货单位" value=""></td>\n' +
                '<td>                            <input readonly="readonly" id="ljkpsl-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].ljkpsl" ' +
                '                                   placeholder="累计开票数量" value="0"></td>\n' +
                '<td>                            <input readonly="readonly" id="ljysksl-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].ljysksl" ' +
                '                                   placeholder="累计应收款数量" value="0"></td>\n' +
                '<td>                            <select id="sfyskjs-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].sfyskjs">\n' +
                '                                   <option selected="selected" value="0">否</option>' +
                '                                </select></td>\n' +
                '<td>                            <select id="status-' + nowCount + '" type="text" class="form-control" name="xskpd_zibs[' + nowCount + '].status">\n' +
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
