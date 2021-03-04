<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/wwqShop/manage/admin_userselect">首页</a><span class="crumb-step">&gt;</span>
            <span class="crumb-name"><a href="/wwqShop/manage/admin_productselect">图书管理</a></span></div>
    </div>

    <div class="result-wrap">

            <div class="result-title">
                <div class="result-list">
                    <a href="/wwqShop/manage/admin_toproductadd"><i class="icon-font"></i>新增图书</a>

                    <%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="60%">
                    <tr>

                        <th>ID</th>
                        <th>商品名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="p" items="${plist}">
                        <tr>
                            <td>${p.product_id }</td>
                            <td><img src="../${p.product_filename}" width="80" height="80">
                                    ${p.product_name }

                            </td>
                            <td>
                                <a href="admin_toproductupdate?id=${p.product_id}">修改</a>
                                <a href="javascript:catedel(${p.product_id})">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <script>

                        function catedel(id) {
                            if(confirm("你确定要删除这个分类吗？")) {
                                location.href="admin_doproductdel?id="+id;

                            }
                        }


                    </script>
                </table>
<%--                <div class="list-page">--%>
<%--                    共${tsum}条记录  ${cpage}/${tpage} 页--%>
<%--                    <a href="admin_douserselect?cp=1${searchParams}">首页</a>--%>
<%--                    <a href="admin_douserselect?cp=${cpage-1<1?1:cpage-1}${searchParams}">上一页</a>--%>
<%--                    <a href="admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>--%>
<%--                    <a href="admin_douserselect?cp=${tpage}${searchParams}">尾页</a>--%>
<%--                </div>--%>
            </div>

    </div>
</div>
<!--/main-->
</div>
</body>
</html>