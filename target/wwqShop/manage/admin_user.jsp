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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span class="crumb-step">&gt;</span>
                <span class="crumb-name">用户管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/wwqShop/manage/admin_douserselect" method="get">
                    <table class="search-tab">
                        <tr>
<%--                            <th width="120">选择分类:</th>--%>
<%--                            <td>--%>
<%--                                <select name="search-sort" >--%>
<%--                                    <option value="">全部</option>--%>
<%--                                    <option value="19">精品界面</option><option value="20">推荐界面</option>--%>
<%--                                </select>--%>
<%--                            </td>--%>
                            <th width="70">关键字:</th>
                            <td><input class="common-text" placeholder="关键字" name="keywords" value=""  type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form action="/wwqShop/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_useradd.jsp"><i class="icon-font"></i>新增用户</a>
                        <a id="batchDel" href="javascript:delmore('你确定删除这些用户吗？', 'myform')"><i class="icon-font"></i>批量删除</a>
<%--                        <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"><input class="allChoose" name=""  onclick="selall(this)" type="checkbox"></th>
                            <th>ID</th>
                            <th>姓名</th>
                            <th>性别</th>
                            <th>EMAIL</th>
                            <th>地址</th>
                            <th>手机</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach var="u" items="${userlist}">
                            <tr>
                                <td class="tc"><input name="id[]" value="${u.username}" type="checkbox"></td>
                                <td > ${u.username } </td>
                                <td> ${u.nickname} </td>
                                <td> ${u.sex=='T'?'男':'女'} </td>
                                <td> ${u.email} </td>
                                <td> ${u.address} </td>
                                <td> ${u.mobile} </td>
                                <td>
                                    <a class="link-update" href="/wwqShop/manage/admin_touserupdate?username=${u.username}&cpage=${cpage}">修改</a>

                                    <c:if test="${u.status==1}">

                                        <a class="link-del" href="javascript:Delete('你确定要删除用户【${u.nickname} }】吗？','/wwqShop/manage/admin_douserdel?username=${u.username}&cpage=${cpage }')">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                            </c:forEach>
                        <script>

                            function Delete(mess, url) {
                                if(confirm(mess)) {
                                    location.href=url;

                                }
                            }

                            function selall(o) {
                                var a = document.getElementsByName('id[]');



                                for(var i=0; i<a.length; i++) {
                                    a[i].checked = o.checked;
                                }
                            }

                            function delmore(mess, formname) {
                                if(confirm(mess)) {
                                    var form = document.getElementById(formname);
                                    form.submit();
                                }
                            }
                        </script>
                    </table>
                    <div class="list-page">
                       共${tsum}条记录  ${cpage}/${tpage} 页
                    <a href="admin_douserselect?cp=1${searchParams}">首页</a>
                    <a href="admin_douserselect?cp=${cpage-1<1?1:cpage-1}${searchParams}">上一页</a>
                    <a href="admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                    <a href="admin_douserselect?cp=${tpage}${searchParams}">尾页</a>
                </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>