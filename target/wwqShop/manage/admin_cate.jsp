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
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <span class="crumb-name"><a href="/wwqShop/manage/admin_cateselect">分类管理</a></span></div>
    </div>

    <div class="result-wrap">
        <form action="/wwqShop/manage/admin_douserdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <a href="admin_tocateadd"><i class="icon-font"></i>新增分类</a>

                    <%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="40%">
                    <tr>

                        <th>ID</th>
                        <th>分类名</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="cate" items="${catelist}">
                        <c:if test="${cate.cate_parent_id == 0}">
                        <tr>

                            <td > ${cate.cate_id } </td>
                            <td> ${cate.cate_name} </td>
                            <td><a href="admin_tocateupdate?id=${cate.cate_id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:catedel(${cate.cate_id})">删除</a> </td>
                        </tr>
                            <c:forEach var="zcate" items="${catelist}">
                                <c:if test="${zcate.cate_parent_id == cate.cate_id}">
                                    <tr>

                                        <td>${zcate.cate_id}</td>
                                        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zcate.cate_name}</td>
                                        <td><a href="admin_tocateupdate?id=${zcate.cate_id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:catedel(${zcate.cate_id})">删除</a> </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                    <script>

                        function catedel(id) {
                            if(confirm("你确定要删除这个分类吗？")) {
                                location.href="admin_docatedel?id="+id;

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
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>