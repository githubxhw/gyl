<%--
  Created by IntelliJ IDEA.
  User: Arbitrary
  Date: 2020/4/14
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>采购到货单添加</title>
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
                采购到货单
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
                    <a href="#">采购到货单管理</a>
                </li>
                <li class="active">添加</li>
            </ol>
        </section>
        <!-- 内容头部 /-->
        <form id="form" method="post">
            <section class="content">
                <!-- zhub -->
                <div class="panel panel-default">
                    <div class="panel-heading">填写采购到货单信息进行添加</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">到货号</div>
                        <div class="col-md-4 data">
                            <input id="zhub_ddh" readonly="readonly" type="text" class="form-control" name="ddh"
                                   placeholder="订单号" value="${ddh}">
                        </div>
                        <div class="col-md-2 title">到货日期</div>
                        <div class="col-md-4 data">
                            <div class="input-group date">
                                <div class="input-group-addon">
                                    <i class="fa fa-calendar"></i>
                                </div>
                                <input type="text" class="form-control pull-right dateTimePicker" name="dhrq">
                            </div>
                        </div>
                        <div class="col-md-2 title">仓库</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="ck"
                                   placeholder="仓库" value="">
                        </div>
                        <div class="col-md-2 title">库管员</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="kgy"
                                   placeholder="库管员" value="">
                        </div>
                        <div class="col-md-2 title">部门</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="bm"
                                   placeholder="部门" value="">
                        </div>
                        <div class="col-md-2 title">客户</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="kh"
                                   placeholder="客户" value="">
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
                                <input type="text" class="form-control pull-right dateTimePicker" name="zdsj">
                            </div>
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
                                <input readonly="readonly" type="text" class="form-control pull-right" name="spsj">
                            </div>
                        </div>
                        <div class="col-md-2 title">是否审批</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="sfsp">
                                <option selected="selected" value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">审批是否通过</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="spsftg">
                                <option value="0">未通过</option>
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
                                <input readonly="readonly" type="text" class="form-control pull-right" name="xgsj">
                            </div>
                        </div>
                        <div class="col-md-2 title">是否退货</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="sfth">
                                <option value="1">是</option>
                                <option selected="selected" value="0">否</option>
                            </select>
                        </div>
                        <div class="col-md-2 title">是否入库结束</div>
                        <div class="col-md-4 data">
                            <select class="form-control" name="sfrkjs">
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
                <br>
                <br>
                <%--zib--%>
                <span hh="0" id="zib_hh"></span><%--记录子表的条数--%>
                <div style="overflow: scroll;overflow-y:scroll;height: 300px;width: 100%;">
                    <table id="dataList_zi" class="table table-bordered table-striped table-hover dataTable"
                           style="min-width:3333px;border:solid grey 1px">
                        <thead>

                        <th class="text-center" width="10px">
                            <div class="btn-group">
                                <button onclick="add_zib(this)" type="button" class="btn btn-default" title="添加">
                                    <i></i><span style="font-size: 15px">+</span>
                                </button>
                            </div>
                        </th>
                        <th class="text-center sorting" width="350px">行号</th>
                        <th class="text-center sorting" width="350px">到货日期</th>
                        <th class="text-center sorting" width="350px">源头单据号</th>
                        <th class="text-center sorting" width="350px">源头行号</th>
                        <th class="text-center sorting" width="350px">来源单据号</th>
                        <th class="text-center sorting" width="350px">来源行号</th>
                        <th class="text-center sorting" width="350px">存货编码</th>
                        <th class="text-center sorting" width="350px">存货名称</th>
                        <th class="text-center sorting" width="350px">型号</th>
                        <th class="text-center sorting" width="350px">计量单位</th>
                        <th class="text-center sorting" width="350px">生产日期</th>
                        <th class="text-center sorting" width="350px">失效日期</th>
                        <th class="text-center sorting" width="350px">单价</th>
                        <th class="text-center sorting" width="350px">金额</th>
                        <th class="text-center sorting" width="350px">是否为赠品</th>
                        <th class="text-center sorting" width="350px">应到数量</th>
                        <th class="text-center sorting" width="350px">实到数量</th>
                        <th class="text-center sorting" width="350px">累计到货数量</th>
                        <th class="text-center sorting" width="350px">是否入库结束</th>
                        <th class="text-center sorting" width="350px">状态</th>
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
        /**/
        //功能：保存主表和子表信息,返回成功即跳转到新页面，失败提示
        $("#save_button").click(function () {
            //alert("ok")
            var params = $("#form").serialize();
            $.ajax({
                url: "${pageContext.request.contextPath}/cgdhd/saveZhubAndZib",
                type: "post",
                data: params,
                dataType: "json",
                async: false,
                success: function (data) {
                    var info = data;
                    var msgList = info.msgList;
                    var resFlag = info.resFlag;
                    if(resFlag == "1"){ //成功
                        alert("添加成功!");
                        window.location.href = "${pageContext.request.contextPath}/cgdhd/getDdhToAddUI";
                    }else { //失败
                        alert("添加失败:"+msgList);
                        $.ajax({
                            url: "${pageContext.request.contextPath}/cgdhd/getDdh",
                            type: "get",
                            data: {},
                            dataType: "text",
                            async: false,
                            success: function (data) {
                                var ddh = data;
                                $("#zhub_ddh").attr("value",ddh);
                            },
                            error: function () {
                                alert("请求新订单号失败！")
                            }
                        });
                    }
                },
                error: function () {
                    alert("其他异常，添加失败！")
                }
            });
        });
        /**/
        //spbm  dpzk
        //功能：点击跳转到query.jsp
        $("#toquery_button").click(function () {
            window.location.href = "${pageContext.request.contextPath}/pages/business/cgdhd-query.jsp";
        });
    });

    /*1*/
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
                '<td>                            <input id="hh-' + nowCount + '" type="text" readonly="readonly"  class="form-control" name="cgdhd_zibs[' + nowCount + '].hh"\n' +
                '                                   placeholder="行号" value="' + nowCount + '"></td>\n' +
                '<td>                            <input id="dhrq-' + nowCount + '" type="text" class="form-control dateTimePicker" name="cgdhd_zibs[' + nowCount + '].dhrq"\n' +
                '                                   placeholder="yyyy-MM-dd hh:mm" value=""></td>\n' +
                '<td>                            <input id="ytdjh-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].ytdjh" ' +
                '                                   placeholder="源头单据号" value=""></td>\n' +
                '<td>                            <input id="ythh-' + nowCount + '" type="text" class="form-control"  i = "'+nowCount+'" onblur = "checkydsl(this)" name="cgdhd_zibs[' + nowCount + '].ythh"\n' +
                '                                   placeholder="源头行号" value=""></td>\n' +
                '<td>                            <input id="lydjh-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].lydjh"\n' +
                '                                   placeholder="来源单据号" value=""></td>\n' +
                '<td>                            <input id="lyhh-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].lyhh"\n' +
                '                                   placeholder="来源行号" value=""></td>\n' +
                '<td>                            <input id="spbm-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].spbm"\n' +
                '                                   placeholder="存货编码(不为空)"></td>\n' +
                '<td>                            <input id="spmc-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].spmc"\n' +
                '                                   placeholder="存货名称" value=""></td>\n' +
                '<td>                            <input id="type-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].type"\n' +
                '                                   placeholder="型号" value=""></td>\n' +
                '<td>                            <input id="dw-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].dw"\n' +
                '                                   placeholder="计量单位" value=""></td>\n' +
                '<td>                            <input id="scrq-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].scrq"\n' +
                '                                   placeholder="生产日期" value=""></td >\n' +
                '<td>                            <input id="sxrq-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].sxrq"\n' +
                '                                   placeholder="失效日期" value=""></td >\n' +
                '<td>                            <input id="dj-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].dj"\n' +
                '                                   placeholder="单价" value=""></td>\n' +
                '<td>                            <input id="je-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].je"\n' +
                '                                   placeholder="金额" value=""></td>\n' +
                '<td>                            <select id="zp-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].zp">\n' +
                '                                   <option id="zp1'+nowCount+'"value="1">是</option>' +
                '                                   <option id = "zp0'+nowCount+'" value="0">否</option>' +
                '                                </select></td>\n' +
                '<td>                            <input readonly="readonly" id="ydsl-' + nowCount + '" type="text" class="form-control"  name="cgdhd_zibs[' + nowCount + '].ydsl"\n' +
                '                                   placeholder="应到数量" value=""></td>\n' +
                '<td>                            <input id="sdsl-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].sdsl"\n' +
                '                                   placeholder="实到数量" value=""></td>\n' +
                '<td>                            <input readonly="readonly" id="ljdhsl-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].ljdhsl" ' +
                '                                   placeholder="累计到货数量" value="0"></td>\n' +
                '<td>                            <select id="sfrkjs-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].sfrkjs">\n' +
                '                                   <option selected="selected" value="0">未结束</option>' +
                '                                </select></td>\n' +
                '<td>                            <select id="status-' + nowCount + '" type="text" class="form-control" name="cgdhd_zibs[' + nowCount + '].status">\n' +
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



    function checkydsl(x) {
        var i = $(x).attr("i");
        var ythh = $("#ythh-"+i).val();
        var ytdjh = $("#ytdjh-"+i).val();
        $.ajax({
            url: "${pageContext.request.contextPath}/cgdhd/getydsl",
            type: "get",
            data: {"ytdjh":ytdjh,"ythh":ythh},
            dataType: "json",
            async: false,
            success:function (data) {
                var pageInfo = data;
                var msgs = pageInfo.msgList;
                var backResult = pageInfo.backResult;
                if (pageInfo.resFlag == "1") {//修改成功
                    $("#ydsl-" + i).attr("value",backResult.sl);
                    $("#ljdhsl-"+i).attr("value",backResult.ljdhsl);
                    $("#spbm-"+i).attr("value",backResult.spbm);
                    $("#spmc-"+i).attr("value",backResult.spmc);
                    $("#type-"+i).attr("value",backResult.xh);
                    $("#dw-"+i).attr("value",backResult.dw);
                    if (backResult.zp == 1){
                        $("#zp1"+i).attr("selected","selected");
                    }else{
                        $("#zp0"+i).attr("selected","selected");
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

</script>


</body>

</html>

