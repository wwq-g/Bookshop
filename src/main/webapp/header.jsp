<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/8
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top">
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <c:if test="${isLogin != 1}">
                    <a href="login.jsp" id="login">登录</a>
                    <a href="register.jsp" id="reg">注册</a>
                    </c:if>

                    <c:if test="${isLogin == 1}">
                        <b>你好：${name.nickname}</b>
                    </c:if>
                    <c:if test="${name.status == 2}">
                        <a href="/wwqShop/manage/admin_index.jsp" id="login1">进入后台</a>
                    </c:if>
                </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="personal"><img src="img/grzx.png"/></a><a href="showcart"><img src="img/gwc.png"/></a>
                </div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="indexselect">首页</a></li>
            <c:forEach var="f" items="${flist}">
                <li><a href="selectproductlist?fid=${f.cate_id}">${f.cate_name}</a>
                    <div class="sList2">
                        <div class="clearfix">
                            <c:forEach var="c" items="${clist}">
                                <c:if test="${f.cate_id == c.cate_parent_id}">
                                    <a href="selectproductlist?cid=${c.cate_id}">${c.cate_name}</a>
                                </c:if>
                            </c:forEach>
                        </div>
                    </div>
                </li>

            </c:forEach>
        </ul>
    </div>
</div>