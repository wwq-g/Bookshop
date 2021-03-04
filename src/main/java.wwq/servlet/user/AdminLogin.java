package servlet.user;

import entity.User;
import service.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/adminlogin")
public class AdminLogin extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username");
        String  password = request.getParameter("password");

        int count = UserDao.selectByNM(username,password);

        if (count>0){
            HttpSession session = request.getSession();

            User user = UserDao.selectAdmin(username,password);

            session.setAttribute("name",user);
            session.setAttribute("isLogin","1");
            if (user.getStatus() == 2){
                session.setAttribute("isAdminLogin","1");
                response.sendRedirect("/wwqShop/manage/admin_index.jsp");
            }else {
                response.sendRedirect("/wwqShop/index.jsp");
            }
//            System.out.println(user);

        }else {
            PrintWriter out = response.getWriter();
            out.write("<script>");
            out.write("alert('用户和密码错误！');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
        }
    }
}
