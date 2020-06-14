<%@ page import="cn.cuit.gyl.domain.database.pages.PageBean" %>
<%@ page import="cn.cuit.gyl.domain.database.gys" %><%--
  Created by IntelliJ IDEA.
  User: XHW
  Date: 2020/2/17
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>客户列表</title>
    <meta name="description" content="AdminLTE2">
    <meta name="keywords" content="AdminLTE2">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="../../header.jsp"></jsp:include>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <jsp:include page="../../aside.jsp"></jsp:include>

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                数据管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="#">基础数据</a></li>
                <li class="active">客户</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">客户列表</h3>
                </div>

                <form id="form" method="post" action="${pageContext.request.contextPath}/kh/findByPage?currentPage=1&rows=5">
                    <section class="content"> <!--产品信息-->

                        <div class="panel panel-default">
                            <div class="panel-heading">查询(所有)</div>
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
                                <div class="col-md-2 title">状态</div>
                                <div class="col-md-4 data">
                                    <select class="form-control" name="status">
                                        <option selected="selected" value="-1">全部</option>
                                        <option value="1">使用</option>
                                        <option value="0">未使用</option>
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
                                    <div class="col-md-2 title">是否信用管理</div>
                                    <div class="col-md-4 data">
                                        <select class="form-control" name="sfyygl">
                                            <option selected="selected" value="-1">全部</option>
                                            <option value="1">使用</option>
                                            <option value="0">未使用</option>
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

                                <%--11--%>
                            </div>


                        </div>
                        <!--订单信息/--> <!--工具栏-->
                        <div class="box-tools <%--text-center --%>text-right">
                            <button id="query" type="submit" class="btn <%--bg-maroon--%> bg-red">搜索</button>
                            <button type="reset" class="btn bg-orange">重置</button>
                            <button type="button" class="btn bg-yellow"
                                    onclick="history.back(-1);">返回
                            </button>
                        </div>
                        <!--工具栏/--> </section>
                </form>
                <form action="${pageContext.request.contextPath}/kh/Deletes" method="post">
                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box" style="overflow: scroll;overflow-y:scroll;height: 200px;width: 99%;">
                            <!--工具栏-->
                            <%--<div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <input type="text" class="form-control input-sm" placeholder="部门名称 搜索">
                                    <span class="glyphicon glyphicon-search form-control-feedback"></span>
                                </div>
                            </div>--%>

                            <!--工具栏/-->

                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable"  style="min-width:4000px;border:solid grey 1px">
                                <thead>
                                <tr>
                                    <th class="" style="padding-right:0px;">
                                        <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                    </th>
                                    <th class="text-center sorting"width="150px">名称</th>
                                    <th class="text-center sorting"width="150px">全称</th>
                                    <th class="text-center sorting"width="150px">助记码</th>
                                    <th class="text-center sorting"width="150px">简称</th>
                                    <th class="text-center sorting"width="150px">地址</th>
                                    <th class="text-center sorting"width="150px">状态</th>
                                    <th class="text-center sorting"width="150px">区域</th>
                                    <th class="text-center sorting"width="150px">行业</th>
                                    <th class="text-center sorting"width="150px">联系人</th>
                                    <th class="text-center sorting"width="150px">电话</th>
                                    <th class="text-center sorting"width="150px">移动电话</th>
                                    <th class="text-center sorting"width="150px">传真</th>
                                    <th class="text-center sorting"width="150px">邮编</th>
                                    <th class="text-center sorting"width="150px">邮件地址</th>
                                    <th class="text-center sorting"width="150px">开户银行</th>
                                    <th class="text-center sorting"width="150px">银行账号</th>
                                    <th class="text-center sorting"width="150px">税务登记号</th>
                                    <th class="text-center sorting"width="150px">是否信用管理</th>
                                    <th class="text-center sorting"width="150px">销售模式</th>
                                    <th class="text-center sorting"width="150px">增值税率</th>
                                    <th class="text-center sorting"width="150px">城市</th>
                                    <th class="text-center sorting"width="150px">省份</th>
                                    <th class="text-center sorting"width="150px">国家</th>
                                    <th class="text-center"width="150px">操作</th>
                                </tr>
                                </thead>

                                <%--内容--%>
                                <tbody>
                                <c:forEach items="${pb.list}" var="kh">
                                    <tr>
                                        <td><input name="names" type="checkbox" value="${kh.name}"></td>
                                        <td>${kh.name}</td>
                                        <td>${kh.fullname}</td>
                                        <td>${kh.zjm}</td>
                                        <td>${kh.jc}</td>
                                        <td>${kh.dz}</td>
                                        <td>${kh.status == 1?"使用":"未使用"}</td>
                                        <td>${kh.qy}</td>
                                        <td>${kh.hy}</td>
                                        <td>${kh.lxr}</td>
                                        <td>${kh.dh}</td>
                                        <td>${kh.mdh}</td>
                                        <td>${kh.cz}</td>
                                        <td>${kh.yb}</td>
                                        <td>${kh.email}</td>
                                        <td>${kh.khyh}</td>
                                        <td>${kh.yhzh}</td>
                                        <td>${kh.swdjh}</td>
                                        <td>${kh.sfyygl == 1?"使用":"未使用"}</td>
                                        <td>${kh.xsms}</td>
                                        <td>${kh.zzsl}</td>
                                        <td>${kh.city}</td>
                                        <td>${kh.sf}</td>
                                        <td>${kh.gj}</td>
                                        <td class="text-center">
                                            <button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/kh/findByName?name=${kh.name}'">修改</button>
                                            <button type="button" class="btn bg-olive btn-xs" onclick="location.href='${pageContext.request.contextPath}/kh/Delete?name=${kh.name}'">删除</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>


                            <%--工具栏--%>

                            <%--工具栏/--%>
                        </div>
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建" onclick="location.href='${pageContext.request.contextPath}/pages/basedata/kh-add.jsp'"><i
                                            class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="submit" class="btn btn-default" title="删除"><i
                                            class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新" onclick="location.href='${pageContext.request.contextPath}/kh/findByPage?currentPage=${pb.currentPage}&rows=5 '"><i
                                            class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>

                    </div>

                    <!-- /.box-body -->
                </form>



                <c:if test="${not empty pb.list}">
                    <!-- .box-footer-->
                    <div class="box-footer">
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                总共 ${pb.totalPage} 页，共 ${pb.totalCount} 条数据。
                            </div>
                        </div>

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li>
                                    <a href="${pageContext.request.contextPath}/kh/findByPage?currentPage=1&name=${kh.name}&fullname=${kh.fullname}&zjm=${kh.zjm}&jc=${kh.jc}&dz=${kh.dz}&status=${kh.status}&qy=${kh.qy}&hy=${kh.hy}&lxr=${kh.lxr}&dh=${kh.dh}&mdh=${kh.mdh}&cz=${kh.cz}&yb=${kh.yb}&email=${kh.email}&khyh=${kh.khyh}&yhzh=${kh.yhzh}&swdjh=${kh.swdjh}&sfyygl=${kh.sfyygl}&xsms=${kh.xsms}&zzsl=${kh.zzsl}&city=${kh.city}&sf=${kh.sf}&gj=${kh.gj}" aria-label="Previous">首页</a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/kh/findByPage?currentPage=${pb.currentPage-1}&rows=5 ">上一页</a></li>
                                <c:forEach begin="1" end="${pb.totalPage}" var="i" >


                                    <c:if test="${pb.currentPage == i}">
                                        <li class="active"><a href="${pageContext.request.contextPath}/kh/findByPage?currentPage=${i}&rows=5&name=${kh.name}&fullname=${kh.fullname}&zjm=${kh.zjm}&jc=${kh.jc}&dz=${kh.dz}&status=${kh.status}&qy=${kh.qy}&hy=${kh.hy}&lxr=${kh.lxr}&dh=${kh.dh}&mdh=${kh.mdh}&cz=${kh.cz}&yb=${kh.yb}&email=${kh.email}&khyh=${kh.khyh}&yhzh=${kh.yhzh}&swdjh=${kh.swdjh}&sfyygl=${kh.sfyygl}&xsms=${kh.xsms}&zzsl=${kh.zzsl}&city=${kh.city}&sf=${kh.sf}&gj=${kh.gj}">${i}</a></li>
                                    </c:if>
                                    <c:if test="${pb.currentPage != i}">
                                        <li><a href="${pageContext.request.contextPath}/kh/findByPage?currentPage=${i}&rows=5&name=${kh.name}&fullname=${kh.fullname}&zjm=${kh.zjm}&jc=${kh.jc}&dz=${kh.dz}&status=${kh.status}&qy=${kh.qy}&hy=${kh.hy}&lxr=${kh.lxr}&dh=${kh.dh}&mdh=${kh.mdh}&cz=${kh.cz}&yb=${kh.yb}&email=${kh.email}&khyh=${kh.khyh}&yhzh=${kh.yhzh}&swdjh=${kh.swdjh}&sfyygl=${kh.sfyygl}&xsms=${kh.xsms}&zzsl=${kh.zzsl}&city=${kh.city}&sf=${kh.sf}&gj=${kh.gj}">${i}</a></li>
                                    </c:if>

                                </c:forEach>


                                <li><a href="${pageContext.request.contextPath}/kh/findByPage?currentPage=${pb.currentPage+1}&rows=5&name=${kh.name}&fullname=${kh.fullname}&zjm=${kh.zjm}&jc=${kh.jc}&dz=${kh.dz}&status=${kh.status}&qy=${kh.qy}&hy=${kh.hy}&lxr=${kh.lxr}&dh=${kh.dh}&mdh=${kh.mdh}&cz=${kh.cz}&yb=${kh.yb}&email=${kh.email}&khyh=${kh.khyh}&yhzh=${kh.yhzh}&swdjh=${kh.swdjh}&sfyygl=${kh.sfyygl}&xsms=${kh.xsms}&zzsl=${kh.zzsl}&city=${kh.city}&sf=${kh.sf}&gj=${kh.gj}">下一页</a></li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/kh/findByPage?currentPage=${pb.totalPage}&rows=5&name=${kh.name}&fullname=${kh.fullname}&zjm=${kh.zjm}&jc=${kh.jc}&dz=${kh.dz}&status=${kh.status}&qy=${kh.qy}&hy=${kh.hy}&lxr=${kh.lxr}&dh=${kh.dh}&mdh=${kh.mdh}&cz=${kh.cz}&yb=${kh.yb}&email=${kh.email}&khyh=${kh.khyh}&yhzh=${kh.yhzh}&swdjh=${kh.swdjh}&sfyygl=${kh.sfyygl}&xsms=${kh.xsms}&zzsl=${kh.zzsl}&city=${kh.city}&sf=${kh.sf}&gj=${kh.gj}" aria-label="Next">尾页</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                </c:if>
                <!-- /.box-footer-->
            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <jsp:include page="../../footer.jsp"/>

</div>


<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
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

// 激活导航位置
        setSidebarActive("admin-datalist");

// 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
// 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td input[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td input[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });
    });
</script>
</body>

</html>

