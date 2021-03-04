package servlet.cate;

import entity.Category;
import entity.User;
import service.CateDao;
import service.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_tocateupdate")
public class ToCateUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        int cate_id = Integer.parseInt(request.getParameter("id"));

        //通过id到数据里查找
        Category cate = CateDao.selectById(cate_id);

        //查找所有分类
        ArrayList<Category> catelist = CateDao.selectAll();


        request.setAttribute("catelist",catelist);
        request.setAttribute("cate",cate);

        request.getRequestDispatcher("admin_catemodify.jsp").forward(request,response);
    }


}
