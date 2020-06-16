<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>系统设置</title>
    <meta name="description" content="AdminLTE">
    <meta name="keywords" content="AdminLTE">
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%--switch：css--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/switch/css/switch.css">
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
    <style type="text/css">

    </style>
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="../../header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="../../aside.jsp"></jsp:include>

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                系统设置
                <small>设置</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">系统设置</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">
            <div class="box-body">
                <!--tab页-->
                <div class="nav-tabs-custom">
                    <!--tab头-->
                    <%--<ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#tab-form" data-toggle="tab">点评设置</a>
                        </li>
                    </ul>--%>
                    <!--tab头/-->
                    <!--tab内容-->
                    <div class="tab-content">
                        <!--基本设置-->
                        <div class="tab-pane active" id="tab-form">
                            <div class="row data-type">
                                <div class="col-md-1 title">任务调度器</div>
                                <div class="col-md-2 data">
                                    <div class="form-group form-inline" style="text-align: center;">
                                        <div style="float: left">关闭</div>
                                            <input id="quartzManagerInput" class="switch switch-anim" type="checkbox" onchange="quartzManager(this);" <%--checked="checked"--%>>
                                        <div style="float: right">开启</div>
                                        <%--<div class="radio"><label><input checked="checked" type="radio" name="optionsRadios" value="4">未启动</label></div>--%>
                                    </div>
                                </div>
                                <div class="col-md-1 title">销售出库预警周期</div>
                                <div class="col-md-2 data">
                                    <div class="form-group form-inline">
                                        <div>
                                            <label>
                                                <input type="text" class="form-control" name="desc"
                                                       placeholder="盘点周期" value="">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1 title">盘点周期</div>
                                <div class="col-md-2 data">
                                    <div class="form-group form-inline">
                                        <div>
                                            <label>
                                                <input type="text" class="form-control" name="desc"
                                                       placeholder="盘点周期" value="">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <%--<div class="col-md-2 title">游记评论</div>
                                <div class="col-md-10 data line-height36">
                                    <div class="form-group form-inline">
                                        <div class="checkbox"><label><input type="checkbox" value="1"> 自动审核</label></div>
                                        <div class="checkbox"><label><input type="checkbox" value="2"> 显示验证码</label></div>
                                    </div>
                                </div>--%>
                                <%--<div class="col-md-2 title">评论时限</div>
                                <div class="col-md-1 data">
                                    <input type="text" class="form-control" placeholder="秒" value="">
                                </div>
                                <div class="col-md-9 data text">
                                    秒内不能重复评论
                                </div>
                                <div class="col-md-2 title"></div>
                                <div class="col-md-10 data text-center">
                                    <button type="button" class="btn bg-maroon">保存</button>
                                    <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
                                </div>--%>
                            </div>
                        </div>
                        <!--基本设置/-->
                    </div>
                    <!--tab内容/-->
                </div>
                <!--tab页/-->

                <!-- .box-footer
    <div class="box-footer"></div>
    -->
                <!-- /.box-footer-->
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="../../footer.jsp"/>

</div>
<%--自定义switch插件：js--%>
<script src="${pageContext.request.contextPath}/plugins/switch/js/switch.js"></script>
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
<script>
    $(document).ready(function() {
        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
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

    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("admin-index");
    });

    //页面加载请求
    $(document).ready(function() {
        //1,加载任务调度器信息
        $.ajax({
            url:"${pageContext.request.contextPath}/quartz/isStart",
            type:"get",
            data:{},
            dataType:"text",
            async:true,
            success:function (data) {
                var isStart = data;
                if(isStart == "true"){//开启
                    $("#quartzManagerInput").prop("checked",true);
                }
            },
            error:function () {
                alert("任务调度器信息加载失败。")
            }
        });

        //其他请求...
    });

    //任务调度的验证方法
    function quartzManager(x){
        var $x = $(x);
        var isOpen = $x.prop("checked");
        // alert(isOpen)
        if(isOpen == true){
            if(confirm("是否开启服务?") == true){
                //启动任务调度器
                $.ajax({
                    url:"${pageContext.request.contextPath}/quartz/startScheduler",
                    type:"get",
                    data:{},
                    dataType:"text",
                    async:true,
                    success:function (data) {
                        /*alert("启动成功。");*/
                        $x.prop("checked",true);
                    },
                    error:function () {
                        alert("启动失败。");
                        $x.prop("checked",false);
                    }
                });
            }else {
                $x.attr("checked",false);
            }
        }else {
            if(confirm("是否关闭服务?") == true){
                //暂停任务调度器
                $.ajax({
                    url:"${pageContext.request.contextPath}/quartz/delayScheduler",
                    type:"get",
                    data:{},
                    dataType:"text",
                    async:true,
                    success:function (data) {
                        /*alert("已关闭服务。")*/
                        $x.prop("checked",false);
                    },
                    error:function () {
                        alert("关闭服务失败。")
                        $x.prop("checked",true);
                    }
                });
            }else {
                $x.prop("checked",true);
            }
        }
    }



</script>
</body>

</html>