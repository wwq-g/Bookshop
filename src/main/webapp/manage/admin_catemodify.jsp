<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">分类管理</a><span class="crumb-step">&gt;</span><span>修改分类</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="/wwqShop/manage/admin_docateupdate" method="post" id="myform" name="myform">
                <input type="hidden" name="id" value="${cate.cate_id}">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <tr>
                        <th><i class="require-red">*</i>父级分类：</th>
                        <td>
                            <select class="common-text required" name="parentId" >
                                <option value="0" >根分类</option>
                                <c:forEach var="cate1" items="${catelist}">
                                    <c:if test="${cate1.cate_parent_id == 0}">
                                        <c:if test="${cate.cate_parent_id == cate1.cate_id}">
                                        <option value="${cate1.cate_id}" selected="selected" >${cate1.cate_name }</option>
                                        </c:if>
                                        <c:if test="${cate.cate_parent_id != cate1.cate_id}">
                                            <option value="${cate1.cate_id}">${cate1.cate_name}</option>
                                        </c:if>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>分类名称：</th>
                        <td>
                            <input class="common-text required" id="title1" name="className" size="50" value="${cate.cate_name}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody></table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>