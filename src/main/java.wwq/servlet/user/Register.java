package servlet.user;

import entity.User;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String mobile = request.getParameter("mobile");
        String birthday = request.getParameter("birthday");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        //创建用户实体
        User u = new User(username, nickname, password, sex, mobile, birthday, address, null, email, 1);

        //加入到数据库的用户表中
        int count = UserDao.insert(u);


        //成功或失败重定向到哪里

        if (count > 0) {
            response.sendRedirect("login.jsp");
//            response.sendRedirect("admin_douserselect");
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('用户注册失败');");
            out.write("location.href='register.jsp'");
            out.write("</script>");

        }

    }
}

