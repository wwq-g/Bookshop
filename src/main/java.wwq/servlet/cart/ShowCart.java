package servlet.cart;

import entity.Cart;
import entity.User;
import service.CartDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session =  request.getSession();

        String isLogin = (String)session.getAttribute("isLogin");

        User user=(User) session.getAttribute("name");

        if(user!=null && isLogin.equals("1")) {
            String uid = (String)user.getUsername();

            ArrayList<Cart> list= CartDao.getCart(uid);

            request.setAttribute("shoplist", list);

            request.getRequestDispatcher("cart.jsp").forward(request, response);

        }else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('登录后，再购买');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
        }
    }


}
