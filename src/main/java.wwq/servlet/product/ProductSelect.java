package servlet.product;

import entity.Product;
import service.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_productselect")
public class ProductSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> productlist = ProductDao.selectAll();

        request.setAttribute("plist",productlist);
//        System.out.println(catelist);
        request.getRequestDispatcher("admin_product.jsp").forward(request,response);
    }


}
