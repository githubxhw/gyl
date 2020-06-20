<%--
  Created by IntelliJ IDEA.
  User: YT
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
    <title>客户添加</title>
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
                客户 <small>客户单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/kh/findByPage">客户</a></li>
                <li class="active">客户表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <form action="${pageContext.request.contextPath}/kh/Save"
              method="post" id="form">
            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">客户信息</div>
                    <div class="row data-type">

                        <%--1--%>
                            <div class="col-md-2 title">客户名称</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="name"
                                       placeholder="客户名称" value="">
                            </div>
                            <%--2--%>
                            <div class="col-md-2 title">客户全称</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="fullname"
                                       placeholder="客户全称" value="">
                            </div>
                            <div class="col-md-2 title">助记码</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="zjm"
                                       placeholder="助记码" value="">
                            </div>
                            <%--3--%>
                            <div class="col-md-2 title">简称</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="jc"
                                       placeholder="简称" value="">
                            </div>
                            <div class="col-md-2 title">地址</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="dz"
                                       placeholder="地址" value="">
                            </div>
                            <div class="col-md-2 title">状态（默认未使用）</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="status">
                                    <option value="1">使用</option>
                                    <option value="0" selected="selected">未使用</option>
                                </select>
                            </div>

                            <div class="col-md-2 title">区域</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="qy"
                                       placeholder="区域" value="">
                            </div>
                            <div class="col-md-2 title">行业</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="hy"
                                       placeholder="行业" value="">
                            </div>

                            <div class="col-md-2 title">联系人</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="lxr"
                                       placeholder="联系人" value="">
                            </div>
                            <%--4--%>
                            <div class="col-md-2 title">电话</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="dh"
                                       placeholder="电话" value="">
                            </div>

                            <%--5--%>
                            <div class="col-md-2 title">移动电话</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="mdh"
                                       placeholder="移动电话" value="">
                            </div>

                            <%--6--%>
                            <div class="col-md-2 title">传真</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="cz"
                                       placeholder="传真" value="">
                            </div>

                            <div class="col-md-2 title">邮编</div>
                            <div class="col-md-4 data">
                                <input  type="text" class="form-control" name="yb"
                                        placeholder="邮编" value="">
                            </div>
                            <div class="col-md-2 title">邮件地址</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="email"
                                       placeholder="邮件地址" value="">
                            </div>
                            <%--8--%>
                            <div class="col-md-2 title">开户银行</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="khyh"
                                       placeholder="开户银行" value="">
                            </div>
                            <div class="col-md-2 title">银行账号</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="yhzh"
                                       placeholder="银行账号" value="">
                            </div>
                            <div class="col-md-2 title">税务登记号</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="swdjh"
                                       placeholder="税务登记号" value="">
                            </div>
                            <%--9--%>
                            <div class="col-md-2 title">是否信用管理（默认未使用）</div>
                            <div class="col-md-4 data">
                                <select class="form-control" name="sfyygl">
                                    <option value="1">使用</option>
                                    <option value="0" selected="selected">未使用</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">销售模式</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="xsms"
                                       placeholder="销售模式" value="">
                            </div>
                            <%--9--%>
                            <div class="col-md-2 title">增值税率</div>
                            <div class="col-md-4 data">
                                <div class="input-group">
                                    <input type="text" class="form-control"
                                           name="zzsl">
                                    <span class="input-group-addon">%</span>
                                </div>
                            </div>
                            <div class="col-md-2 title">城市</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="city"
                                       placeholder="城市" value="">
                            </div>
                            <div class="col-md-2 title">省份</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="sf"
                                       placeholder="省份" value="">
                            </div>
                            <div class="col-md-2 title">国家</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="gj"
                                       placeholder="国家" value="">
                            </div>


                    </div>
                </div>
                <!--订单信息/-->
                <!--工具栏-->
                <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">保存</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回
                    </button>
                </div>
                <!--工具栏/--> </section>
            <!-- 正文区域 /-->
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
    $(function () {
        document.getElementsByName("name")[0].onblur = function () {
            var name = document.getElementsByName("name")[0].value;
            $.ajax({
                url: "${pageContext.request.contextPath}/kh/FindName",
                type: "POST",
                data: {"name":name},
                dataType: "json",
                async: false,
                success: function (data) {
                    //添加主表信息到页面
                    if (data.msg === "Ok"){
                        document.getElementsByName("name")[0].style.border = "";

                    }else {
                        alert(data.msg);
                        document.getElementsByName("name")[0].style.border = "1px solid red";
                        document.getElementsByName("name")[0].style.value = "";
                    }

                },
                error: function () {
                    alert("出现未知错误")
                }
            });
        }
        document.getElementsByName("fullname")[0].onblur = function () {
            var name = document.getElementsByName("fullname")[0].value;
            console
            $.ajax({
                url: "${pageContext.request.contextPath}/kh/FindFullName",
                type: "POST",
                data: {"name":name},
                dataType: "json",
                async: false,
                success: function (data) {
                    //添加主表信息到页面
                    if (data.msg === "Ok"){
                        document.getElementsByName("fullname")[0].style.border = "";

                    }else {
                        alert(data.msg);
                        document.getElementsByName("fullname")[0].style.border = "1px solid red";
                        document.getElementsByName("fullname")[0].value = "";
                    }

                },
                error: function () {
                    alert("出现未知错误")
                }
            });
        }
        document.getElementsByName("zjm")[0].onblur = function () {
            var name = document.getElementsByName("zjm")[0].value;
            $.ajax({
                url: "${pageContext.request.contextPath}/kh/FindZjm",
                type: "POST",
                data: {"zjm":name},
                dataType: "json",
                async: false,
                success: function (data) {
                    //添加主表信息到页面
                    if (data.msg === "Ok"){
                        document.getElementsByName("zjm")[0].style.border = "";

                    }else {
                        alert(data.msg);
                        document.getElementsByName("zjm")[0].style.border = "1px solid red";
                        document.getElementsByName("zjm")[0].value = "";
                    }

                },
                error: function () {
                    alert("出现未知错误")
                }
            });
        }
        $("#form").submit(function () {
            if (document.getElementsByName("name")[0].value !=""&&document.getElementsByName("dh")[0].value !=""&&document.getElementsByName("lxr")[0].value !=""){
                return true;
            }else {
                alert("名称或联系人或电话为空");
                return false;
            }
        })
    })
</script>


</body>

</html>

