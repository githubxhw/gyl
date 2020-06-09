<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user3-128x128.jpg"
                     class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>
                    <security:authentication property="principal.username"></security:authentication>
                </p>
                <a href="#"><i class="fa fa-circle text-success"></i>在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a
                    href="${pageContext.request.contextPath}/index.jsp"><i
                    class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <%--基础数据--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cube"></i>
                    <span>基础数据</span>
                    <span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
					</span>
                </a>

                <ul class="treeview-menu">
                    <security:authorize access="hasRole('ROLE_DEPARTMENT_QUERY')">
                        <li><a
                                href="${pageContext.request.contextPath}/department/findAll">
                            <i class="fa fa-circle-o"></i> 部门
                        </a></li>
                    </security:authorize>

                    <security:authorize access="hasRole('ROLE_ROLE_QUERY')">
                        <li><a
                                href="${pageContext.request.contextPath}/#"><i
                                class="fa fa-circle-o"></i> 角色
                        </a></li>
                    </security:authorize>

                    <security:authorize access="hasRole('ROLE_USER_QUERY')">
                        <li><a
                                href="${pageContext.request.contextPath}/user/findAll"><i
                                class="fa fa-circle-o"></i> 用户
                        </a></li>
                    </security:authorize>

                    <security:authorize access="hasRole('ROLE_PRODUCT_QUERY')">
                        <li><a
                                href="${pageContext.request.contextPath}/product/findAll"><i
                                class="fa fa-circle-o"></i> 商品档案
                        </a></li>
                    </security:authorize>

                    <security:authorize access="hasRole('ROLE_STORE_QUERY')">
                        <li><a
                                href="${pageContext.request.contextPath}/store/findAllByPage"><i
                                class="fa fa-circle-o"></i> 仓库
                        </a></li>
                    </security:authorize>

                    <security:authorize access="hasRole('ROLE_SUPPLIER_QUERY')">
                        <li><a href="${pageContext.request.contextPath}/#"><i
                                class="fa fa-circle-o"></i> 供应商
                        </a></li>
                    </security:authorize>

                    <security:authorize access="hasRole('ROLE_CUSTOMER_QUERY')">
                        <li><a href="${pageContext.request.contextPath}/#"><i
                                class="fa fa-circle-o"></i> 客户
                        </a></li>
                    </security:authorize>
                </ul>
            </li>

            <%--业务模块--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i>
                    <span>业务</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">

                    <%--采购管理--%>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-plus"></i>
                            <span>采购管理</span>
                            <span class="pull-right-container">
                        		<i class="fa fa-angle-left pull-right"></i>
                    		</span>
                        </a>
                        <ul class="treeview-menu">
                            <%--采购管理子项：采购预购单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>采购预定单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgygd-query.jsp">
                                            <i class="fa fa-circle-o"></i> 查询
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/cgyg/getDdhToAddUI">
                                            <i class="fa fa-circle-o"></i> 制单
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgygd-update.jsp" <%--href="all-form-general.html"--%>>
                                            <i class="fa fa-circle-o"></i> 修订
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgygd-sp.jsp" <%--href="all-form-general.html"--%>>
                                            <i class="fa fa-circle-o"></i> 审批
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <%--采购管理子项：采购顶购单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>采购定单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgdd-query.jsp">
                                            <i class="fa fa-circle-o"></i> 查询
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/cgdd/getDdhToAddUI">
                                            <i class="fa fa-circle-o"></i> 制单
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgdd-update.jsp" <%--href="all-form-general.html"--%>>
                                            <i class="fa fa-circle-o"></i> 修订
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgdd-sp.jsp" <%--href="all-form-general.html"--%>>
                                            <i class="fa fa-circle-o"></i> 审批
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgdd-dj.jsp" <%--href="all-form-general.html"--%>>
                                            <i class="fa fa-circle-o"></i> 冻结和解冻
                                        </a>
                                    </li>
                                </ul>
                            </li>
                                <%--采购管理子项：到货单管理--%>
                                <li class="treeview">
                                    <a href="#">
                                        <i class="fa fa-plus"></i>
                                        <span>采购到货单管理</span>
                                        <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                    </a>
                                    <ul class="treeview-menu">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgdhd-query.jsp">
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                            <a href="${pageContext.request.contextPath}/cgdhd/getDdhToAddUI">
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgdhd-update.jsp">
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgdhd-sp.jsp">
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgdhd-sure.jsp">
                                                <i class="fa fa-circle-o"></i> 确认到货
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <%--采购管理子项：采购入库管理--%>
                                <li class="treeview">
                                    <a href="#">
                                        <i class="fa fa-plus"></i>
                                        <span>采购入库管理</span>
                                        <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                    </a>
                                    <ul class="treeview-menu">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgrkd-query.jsp" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                            <a href="${pageContext.request.contextPath}/cgrkd/getDdhToAddUI" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgrkd-update.jsp" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgrkd-sp.jsp" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                            <a href="${pageContext.request.contextPath}/pages/business/cgrkd-sure.jsp" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 确认出库
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                            <%--采购管理子项：采购发票管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>采购发票管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgfp-query.jsp">
                                                    <i class="fa fa-circle-o"></i> 查询
                                        </a>
                                        <a href="${pageContext.request.contextPath}/pages/business/cgfp-update.jsp">
                                                    <i class="fa fa-circle-o"></i> 修订
                                        </a>
                                        <a href="${pageContext.request.contextPath}/cgfp/getFphToAddUI">
                                                    <i class="fa fa-circle-o"></i> 制单
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <%--库存管理--%>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-plus"></i>
                            <span>库存管理</span>
                            <span class="pull-right-container">
                        		<i class="fa fa-angle-left pull-right"></i>
                    		</span>
                        </a>
                        <ul class="treeview-menu">
                            <%--库存管理子项：期初管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>期初管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/qc-query.jsp">
                                            <i class="fa fa-circle-o"></i> 查询
                                        </a>
                                        <a href="${pageContext.request.contextPath}/qc/getDdhToAddUI">
                                            <i class="fa fa-circle-o"></i> 制单<%--/getDdhToAddUI--%>
                                        </a>
                                        <a href="${pageContext.request.contextPath}/pages/business/qc-update.jsp">
                                            <i class="fa fa-circle-o"></i> 修改
                                        </a>
                                        <a href="${pageContext.request.contextPath}/pages/business/qc-sp.jsp">
                                            <i class="fa fa-circle-o"></i> 审批
                                        </a>
                                        <a href="${pageContext.request.contextPath}/pages/business/qc-sure.jsp">
                                            <i class="fa fa-circle-o"></i> 确认入库
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <%--库存管理子项：盘点--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>盘点</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/pandian-query.jsp">
                                            <i class="fa fa-circle-o"></i> 查询
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pd/getDdhToAddUI">
                                            <i class="fa fa-circle-o"></i> 制表
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/pandian-sp.jsp">
                                            <i class="fa fa-circle-o"></i>  审批
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/pandian-update.jsp">
                                            <i class="fa fa-circle-o"></i>  修订
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/pandian-pd.jsp">
                                            <i class="fa fa-circle-o"></i>  盘点
                                        </a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/pages/business/pandian-tz.jsp">
                                            <i class="fa fa-circle-o"></i>  调整
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <%--销售管理--%>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-plus"></i>
                            <span>销售管理</span>
                            <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                        </a>
                        <ul class="treeview-menu">
                            <%--销售管理子项：销售预购单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>预购单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <security:authorize access="hasRole('ROLE_UI_XSYDD_QUERY')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xsydd/getDdhToAddUI" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSYDD_ADD')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xsydd/getDdhToAddUI" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSYDD_UPDATE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xsydd/getDdhToAddUI" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSYDD_SP')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsydd-query.jsp" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                        </li>
                                    </security:authorize>
                                </ul>
                            </li>

                            <%--销售管理子项：销售订单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>订单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <security:authorize access="hasRole('ROLE_UI_XSDD_QUERY')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsdd-query.jsp">
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSDD_ADD')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xsdd/getDdhToAddUI">
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSDD_UPDATE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsdd-update.jsp" <%--href="all-form-general.html"--%>>
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSDD_SP')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsdd-sp.jsp">
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                        </li>
                                    </security:authorize>
                                </ul>
                            </li>

                            <%--销售管理子项：发货单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>发货单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <security:authorize access="hasRole('ROLE_UI_XSFHD_QUERY')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsfhd-query.jsp">
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSFHD_ADD')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xsfhd/getDdhToAddUI">
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSFHD_UPDATE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsfhd-update.jsp">
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSFHD_SP')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsfhd-sp.jsp">
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSFHD_SURE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsfhd-sure.jsp">
                                                <i class="fa fa-circle-o"></i> 确认发货
                                            </a>
                                        </li>
                                    </security:authorize>
                                </ul>
                            </li>

                            <%--销售管理子项：出库单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>出库单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <security:authorize access="hasRole('ROLE_UI_XSCKD_QUERY')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsckd-query.jsp">
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSCKD_ADD')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xsckd/getDdhToAddUI">
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSCKD_UPDATE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsckd-update.jsp">
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSCKD_SP')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsckd-sp.jsp">
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSCKD_SURE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xsckd-sure.jsp">
                                                <i class="fa fa-circle-o"></i> 确认出库
                                            </a>
                                        </li>
                                    </security:authorize>
                                </ul>
                            </li>

                            <%--销售管理子项：开票管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>开票单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <security:authorize access="hasRole('ROLE_UI_XSKPD_QUERY')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xskpd-query.jsp">
                                                <i class="fa fa-circle-o"></i> 查询
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSKPD_ADD')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/xskpd/getDdhToAddUI">
                                                <i class="fa fa-circle-o"></i> 制单
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSKPD_UPDATE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xskpd-update.jsp">
                                                <i class="fa fa-circle-o"></i> 修订
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSKPD_SP')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xskpd-sp.jsp">
                                                <i class="fa fa-circle-o"></i> 审批
                                            </a>
                                        </li>
                                    </security:authorize>

                                    <security:authorize access="hasRole('ROLE_UI_XSKPD_SURE')">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/pages/business/xskpd-sure.jsp">
                                                <i class="fa fa-circle-o"></i> 确认开票
                                            </a>
                                        </li>
                                    </security:authorize>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <%--应收应付管理--%>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-plus"></i>
                            <span>应收应付管理</span>
                            <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                        </a>
                        <ul class="treeview-menu">
                            <%--应收应付管理子项：采购应付单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>采购应付单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="all-form-general.html">
                                            <i class="fa fa-circle-o"></i> 业务1
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <%--应收应付管理子项：销售应收单管理--%>
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-plus"></i>
                                    <span>销售应收单管理</span>
                                    <span class="pull-right-container">
                        				<i class="fa fa-angle-left pull-right"></i>
                   				 	</span>
                                </a>
                                <ul class="treeview-menu">
                                    <li>
                                        <a href="all-form-general.html">
                                            <i class="fa fa-circle-o"></i> 业务1
                                        </a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>

                    <%--预警管理--%>
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-plus"></i>
                            <span>预警管理</span>
                            <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                        </a>
                        <ul class="treeview-menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/earlyWarning_Cgrk/findEWCgByPage">
                                    <i class="fa fa-circle-o"></i> 采购入库预警
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/earlyWarning_Store/findEWSsByPage">
                                    <i class="fa fa-circle-o"></i> 仓库预警
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/earlyWarning_Xsck/findEWXsByPage">
                                    <i class="fa fa-circle-o"></i> 销售出库预警
                                </a>
                            </li>
                        </ul>
                    </li>
                    <%--<li>
                        <a href="all-form-general.html">
                            <i class="fa fa-circle-o"></i> 业务1
                        </a>
                    </li>--%>
                </ul>
            </li>

            <%--权限管理模块--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-unlock-alt"></i>
                    <span>权限管理</span>
                    <span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span></a>

                <ul class="treeview-menu">
                    <li><a
                            href="${pageContext.request.contextPath}/privilege/findAllRoles"> <i
                            class="fa fa-circle-o"></i> 角色配置权限
                    </a></li>
                    <li><a
                            href="${pageContext.request.contextPath}/privilege/findAllPrivileges"> <i
                            class="fa fa-circle-o"></i> 资源权限
                    </a></li>
                </ul>
            </li>


            <%--系统管理模块--%>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cogs <%--fa-expeditedssl--%>"></i>
                    <span>系统管理</span>
                    <span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span></a>

                <ul class="treeview-menu">
                    <li>
                        <a href="${pageContext.request.contextPath}/sysLog/findAllBySysLogOrTime?queryMethod=TimePeriodQuery">
                            <i class="fa fa-circle-o"></i> 访问日志
                        </a></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/job/findJobsByPage">
                            <i class="fa fa-circle-o"></i> 任务管理
                        </a></li>
                    <li>
                        <a href="${pageContext.request.contextPath}/pages/system/system-setting.jsp">
                            <i class="fa fa-circle-o"></i> 系统设置
                        </a></li>
                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
