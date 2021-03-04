package servlet.product;

import entity.Category;
import service.CateDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_toproductadd")
public class ToProductAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> flist = CateDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<Category> clist = CateDao.selectCat("child");
        request.setAttribute("clist",clist);

        request.getRequestDispatcher("admin_productadd.jsp").forward(request,response);
    }


}
