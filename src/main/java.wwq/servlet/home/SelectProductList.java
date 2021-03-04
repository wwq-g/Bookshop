package servlet.home;

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

@WebServlet("/selectproductlist")
public class SelectProductList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> flist = CateDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<Category> clist = CateDao.selectCat("child");
        request.setAttribute("clist",clist);

        String fid = request.getParameter("fid");
        String cid = request.getParameter("cid");

        int id = 0;
        ArrayList<Product> list = null;
        if (fid!=null){
            id = Integer.parseInt(fid);
            list = ProductDao.selectAllByFid(id);
        }
        if (cid!= null){
            id = Integer.parseInt(cid);
            list = ProductDao.selectAllByCid(id);
        }

        request.setAttribute("list",list);
        request.setAttribute("title",CateDao.selectById(id));
        request.getRequestDispatcher("proList.jsp").forward(request,response);

    }
}
