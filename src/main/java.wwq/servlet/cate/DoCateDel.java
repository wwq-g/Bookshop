package servlet.cate;

import service.CateDao;
import service.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_docatedel")
public class DoCateDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int cate_id = Integer.parseInt(req.getParameter("id"));

        //删除该数据表
        int count = CateDao.del(cate_id);


        //成功或失败重定向到哪里

        if(count >0 ) {

            resp.sendRedirect("admin_cateselect");
        } else {
            PrintWriter out = resp.getWriter();

            out.write("<script>");
            out.write("alert('分类删除失败');");
            out.write("location.href='admin_cateselect");
            out.write("</script>");

        }
    }


}
