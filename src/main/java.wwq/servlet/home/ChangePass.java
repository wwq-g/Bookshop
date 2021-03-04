package servlet.home;

import entity.User;
import service.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/changepass")
public class ChangePass extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        User user = null;
        String isLogin = null;
        String username = null;
        String oldpass = null;
        String newpass = null;
        HttpSession session = request.getSession();
        try {
            user = (User) session.getAttribute("name");

            isLogin = (String) session.getAttribute("isLogin");

            username = user.getUsername();
            oldpass = request.getParameter("oldpass");
            newpass = request.getParameter("newpass");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.println(oldpass);
//        System.out.println(user);
//        System.out.println(newpass);
//        System.out.println(isLogin);

        if (user != null && isLogin.equals("1")) {

            if (user.getPassword().equals(oldpass)) {
                int count = UserDao.ChangePass(username, newpass);
                System.out.println(count);
                if (count > 0) {
                    user.setPassword(newpass);
                    session.setAttribute("name",user);
                    response.sendRedirect("remima.jsp");
                } else {
                    PrintWriter out = response.getWriter();

                    out.write("<script>");
                    out.write("alert('修改失败');");
                    out.write("location.href='remima.jsp'");
                    out.write("</script>");
                }
            } else {
                PrintWriter out = response.getWriter();

                out.write("<script>");
                out.write("alert('旧密码错误');");
                out.write("location.href='remima.jsp'");
                out.write("</script>");
            }
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('请先登录!');");
            out.write("location.href='login.jsp'");
            out.write("</script>");


        }
    }
}
