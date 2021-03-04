<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@include file="admin_menu.jsp"%>
<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span>
            <a class="crumb-name" href="/wwqShop/manage/admin_douserselect">用户管理</a><span class="crumb-step">&gt;</span><span>修改用户</span></div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="/wwqShop/manage/admin_douserupdate" method="post" id="myform" name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>
                    <input type="hidden" name="userStatus" value="${user.status}">
                    <input type="hidden" name="cpage" value="${cpage}">
                    <tr>
                        <th><i class="require-red">*</i>ID：</th>
                        <td>
                            <input class="common-text required" id="title" name="username" size="50" value="${user.username}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>姓名：</th>
                        <td>
                            <input class="common-text required" id="title1" name="nickname" size="50" value="${user.nickname}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>密码：</th>
                        <td>
                            <input class="common-text required" id="password" name="password" size="50" value="${user.password}" type="text">
                        </td>
                    </tr>


                    <tr>
                        <th>性别：</th>
                        <td>
                            <input type="radio" name="sex" value="T" checked="checked">男
                            <input type="radio" name="sex" value="F" >女

                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>手机号码：</th>
                        <td>
                            <input class="common-text required" name="mobile" size="50" value="${user.mobile}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>出生日期：</th>
                        <td>
                            <input class="common-text required" name="birthday" size="50" value="${user.birthday}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>送货地址：</th>
                        <td>
                            <input class="common-text required" name="address" size="50" value="${user.address}" type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>电子邮箱：</th>
                        <td>
                            <input class="common-text required" name="email" size="50" value="${user.email}" type="text">
                        </td>
                    </tr>

                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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