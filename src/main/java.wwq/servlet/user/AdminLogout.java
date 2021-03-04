package servlet.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/adminlogout")
public class AdminLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();

        session.removeAttribute("name");
        session.removeAttribute("isLogin");
        session.removeAttribute("isAdminLogin");

        PrintWriter out = response.getWriter();
        out.write("<script>");
        out.write("alert('退出成功！');");
        out.write("location.href='login.jsp'");
        out.write("</script>");
        out.close();

    }

}
