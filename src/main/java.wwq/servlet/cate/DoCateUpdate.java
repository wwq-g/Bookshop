package servlet.cate;

import entity.Category;
import service.CateDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_docateupdate")
public class DoCateUpdate extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        int fid = Integer.parseInt(request.getParameter("parentId"));
        String name = request.getParameter("className");

        //创建用户实体
        Category category = new Category(id,name,fid);
        //加入到数据库的用户表中
//        System.out.println(category);
        int count = CateDao.update(category);
//        System.out.println(count);
        //成功或失败重定向到哪里

        if(count >0 ) {
            response.sendRedirect("admin_cateselect");
//            response.sendRedirect("admin_douserselect");
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('分类修改失败');");
            out.write("location.href='admin_tocateupdate.jsp'");
            out.write("</script>");

        }
    }
}
