package servlet.product;

import entity.Category;
import entity.Product;
import service.CateDao;
import service.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_toproductupdate")
public class ToProductUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int product_id = Integer.parseInt(request.getParameter("id"));

        //通过id到数据里查找
        Product product = ProductDao.selectById(product_id);

        ArrayList<Category> flist = CateDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<Category> clist = CateDao.selectCat("child");
        request.setAttribute("clist",clist);

        request.setAttribute("product",product);

        request.getRequestDispatcher("admin_productmodify.jsp").forward(request,response);
    }


}
