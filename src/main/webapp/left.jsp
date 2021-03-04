
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="zuo fl">
    <h3><a href="#"><img src="img/tx.png"/></a>
        <p class="clearfix"><span class="fl">${name.nickname}</span><span ><a href="logout">[退出登录]</a></span></p></h3>
    <div><h4>我的交易</h4>
        <ul>
            <li><a href="cart.html">我的购物车</a></li>

        </ul>
        <h4>个人中心</h4>
        <ul>
            <li><a href="mygxin.jsp">我的中心</a></li>
            <li><a href="address.html">地址管理</a></li>
        </ul>
        <h4>账户管理</h4>
        <ul>
            <li class="on"><a href="mygrxx.jsp">个人信息</a></li>
            <li><a href="remima.jsp">修改密码</a></li>
        </ul>
    </div>
</div>