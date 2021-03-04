package servlet.product;

import service.CateDao;
import service.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_doproductdel")
public class DoProductDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        int product_id = Integer.parseInt(req.getParameter("id"));

        //删除该数据表
        int count = ProductDao.del(product_id);


        //成功或失败重定向到哪里

        if(count >0 ) {

            resp.sendRedirect("admin_productselect");
        } else {
            PrintWriter out = resp.getWriter();

            out.write("<script>");
            out.write("alert('分类删除失败');");
            out.write("location.href='admin_productselect");
            out.write("</script>");

        }
    }


}
