package servlet.home;

import entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/personal")
public class Personal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("name");

        String isLogin = (String) session.getAttribute("isLogin");

        if (user != null && isLogin.equals("1")) {
            response.sendRedirect("mygxin.jsp");

        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('请先登录!');");
            out.write("location.href='login.jsp'");
            out.write("</script>");


        }


    }


}
