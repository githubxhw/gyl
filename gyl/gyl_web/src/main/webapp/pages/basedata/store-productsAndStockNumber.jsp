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
    <title>仓库存货详情</title>
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
                仓库存货详情
            </h1>
            <ol class="breadcrumb">
                <li>
                    <a href="${pageContext.request.contextPath}/index.jsp">
                        <i class="fa fa-dashboard"></i> 首页
                    </a>
                </li>
                <li>
                    <a href="#">基础数据</a>
                </li>
                <li>
                    <a href="#">仓库</a>
                </li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <%-- 1：主表--%>

        <div style="padding-left: 0px">
            <h4>仓库号:${store.id},仓库编号:${store.storeNum},该仓库下的所有存货数量情况:</h4>
        </div>
        <div style="padding-left:5px;overflow: scroll;overflow-y:scroll;height: 300px;width: 50%;">
            <table id="dataList_zhu" class="table table-bordered table-striped table-hover dataTable"
                   style="min-width:500px;border:solid grey 1px">
                <thead>
                <th class="text-center sorting" width="200px">仓库</th>
                <th class="text-center sorting" width="200px">仓库编码</th>
                <th class="text-center sorting" width="200px">商品编号</th>
                <th class="text-center sorting" width="200px">存货数量</th>
                <th class="text-center" width="200px">操作</th>
                </thead>
                <%--内容--%>
                <tbody id="zhub_tbody">
                <c:forEach items="${store_products}" var="store_product" varStatus="obj" >
                    <tr>
                        <td id="storeId-${obj.index}" class="text-center" style="width: 10%" storeId="${store_product.storeId}">${store_product.storeId}</td>
                        <td class="text-center" style="width: 20%">${store.storeNum}</td>
                        <td id="pNum-${obj.index}" class="text-center" style="width: 20%" pNum="${store_product.pNum}">${store_product.pNum}</td>
                        <td id="stockNumber-${obj.index}" class="text-center" style="width: 20%" stockNumber="${store_product.stockNumber}">${store_product.stockNumber}</td>
                        <td class="text-center" style="width: 30%">
                            <button index="${obj.index}" type="button" class="btn bg-olive btn-xs" data-target="#myModal_${obj.index}"
                                    data-toggle="modal" onclick="initParamsToDiv(this)">
                                修改存货数量
                            </button>
                            <%--模拟窗口--%>
                            <div style="height: 60%" id="myModal_${obj.index}" class="modal modal-primary" role="dialog">
                                <div class="modal-dialog modal-lg">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                            <h4 class="modal-title">修改库存数量</h4>
                                        </div>
                                        <div class="modal-body">
                                            <div class="box-body">
                                                <div class="form-horizontal">
                                                    <form id="xg_form-${obj.index}" action="${pageContext.request.contextPath}/store/updateStockNumberByStoreIdAndPnum" <%--onsubmit="return sureUpdate();"--%> method="post">
                                                        <!-- 正文区域 -->
                                                        <section class="content"> <!--产品信息-->
                                                            <div class="panel panel-default">
                                                                <div class="panel-heading"></div>
                                                                <div class="row data-type">
                                                                    <input id="xg_storeId-${obj.index}" type="text" hidden="hidden" name="storeId" value="">
                                                                    <div class="col-md-2 title">存货编码</div>
                                                                    <div class="col-md-4 data">
                                                                        <input readonly="readonly" id="xg_pNum-${obj.index}" type="text" class="form-control"
                                                                               name="pNum"
                                                                               placeholder="存货编码" value="">
                                                                    </div>
                                                                    <div class="col-md-2 title">存货数量</div>
                                                                    <div class="col-md-4 data">
                                                                        <input id="xg_stockNumber-${obj.index}" type="text" class="form-control"
                                                                               name="stockNumber"
                                                                               placeholder="存货数量" value="">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <!--订单信息/-->
                                                            <button index="${obj.index}" onclick="updateStore_ProductByStoreId(this)" type="button" class="btn btn-outline"
                                                                    data-dismiss="modal">修改
                                                            </button>
                                                            <button type="button" class="btn btn-outline"
                                                                    data-dismiss="modal">取消
                                                            </button>
                                                        </section>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <%--模拟窗口/--%>
                            <button index="${obj.index}" type="button" class="btn bg-olive btn-xs" onclick="deleteStore_ProductByStoreIdAndPnum(this)" >
                                删除存货信息
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--工具栏--%>
        <div class="pull-left">
            <div class="form-group form-inline">
                <span id="zhub_count" count="">共 ${store_products.size()} 条记录</span>
            </div>
        </div>
        <%--工具栏/--%>
        <br>
        <br>

        <form action="${pageContext.request.contextPath}/store/saveStore_Product" style="padding-left: 0px;width: 51%" id="form" method="post">
            <section class="content" style="padding-left: 0px">
                <!-- zhub -->
                <div class="panel panel-default">
                    <div class="panel-heading">添加其它商品库存到该仓库,说明：不能添加已经存在的存货记录</div>
                    <div class="row data-type">
                        <div class="col-md-2 title">仓库号</div>
                        <div class="col-md-4 data">
                            <input readonly="readonly" type="text" class="form-control" name="storeId"
                                   placeholder="仓库号" value="${store.id}">
                        </div>
                        <div class="col-md-2 title">商品编码</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="pNum"
                                   placeholder="商品编码" value="">
                        </div>
                        <div class="col-md-2 title">存货数量</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="stockNumber"
                                   placeholder="存货数量" value="">
                        </div>
                    </div>
                </div>
                <!--工具栏-->
                <div class="box-tools text-left">
                    <button type="submit" class="btn bg-green">添加</button>
                </div>
                <!--工具栏/-->
            </section>
        </form>
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

    //把数据填充到模态框中
    function initParamsToDiv(x){
        var index = $(x).attr("index");
        var storeId = $("#storeId-"+index).attr("storeId");
        var pNum = $("#pNum-"+index).attr("pNum");
        var stockNumber = $("#stockNumber-"+index).attr("stockNumber");
        $("#xg_storeId-"+index).attr("value",storeId);
        $("#xg_pNum-"+index).attr("value",pNum);
        $("#xg_stockNumber-"+index).attr("value",stockNumber);
    }

    //验证并提交修改表单
    function updateStore_ProductByStoreId(x) {
        // alert("ok")
        var msg = "是否确认修改信息?"
        if(confirm(msg) == true){
            var index = $(x).attr("index");
            var form = document.getElementById("xg_form-"+index);
            form.submit();
        }
    }

    //删除该仓库下该商品的库存信息
    function deleteStore_ProductByStoreIdAndPnum(x) {
        var msg = "是否确认删除库存信息?"
        if(confirm(msg) == true){
            var index = $(x).attr("index");
            var storeId = $("#storeId-"+index).attr("storeId");
            var pNum = $("#pNum-"+index).attr("pNum");
            window.location.href="${pageContext.request.contextPath}/store/deleteStore_ProductByStoreIdAndPnum?storeId="+storeId+"&pNum="+pNum;
        }
    }

</script>


</body>

</html>





