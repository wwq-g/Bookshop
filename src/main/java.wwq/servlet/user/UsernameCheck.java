package servlet.user;

import entity.User;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");

        int count = UserDao.selectByName(username);
        System.out.println(count);

        PrintWriter out = resp.getWriter();
        if (count>0){
            out.print("false");
        }else {
            out.print("true");
        }
        out.close();


    }
}
