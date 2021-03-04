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


@WebServlet("/manage/admin_douserdel")
public class DoUserDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");

        //删除该数据表
        int count = UserDao.del(username);


        //成功或失败重定向到哪里

        if(count >0 ) {

            resp.sendRedirect("admin_douserselect?cp="+req.getParameter("cpage"));
        } else {
            PrintWriter out = resp.getWriter();

            out.write("<script>");
            out.write("alert('用户删除失败');");
            out.write("location.href='manage/admin_douserselect?cp="+req.getParameter("cpage")+"'");
            out.write("</script>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String ids[]= req.getParameterValues("id[]");


        for(int i=0; i<ids.length; i++) {
            //加入到数据库的用户表中
            UserDao.del(ids[i]);

        }
        //成功或失败重定向到哪里



        resp.sendRedirect("/wwqShop/manage/admin_douserselect");
    }
}
