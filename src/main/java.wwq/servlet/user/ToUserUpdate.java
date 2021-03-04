package servlet.user;

import entity.User;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/manage/admin_touserupdate")
public class ToUserUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");

        //通过id到数据里查找
        User user = UserDao.selectById(username);

        req.setAttribute("user",user);

        req.setAttribute("cpage",req.getParameter("cpage"));
        req.getRequestDispatcher("admin_usermodify.jsp").forward(req,resp);

    }
}
