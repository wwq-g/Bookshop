package servlet.cate;

import entity.Category;
import service.CateDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_cateselect")
public class CateSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> catelist = CateDao.selectAll();

        request.setAttribute("catelist",catelist);
//        System.out.println(catelist);
        request.getRequestDispatcher("admin_cate.jsp").forward(request,response);
    }


}
