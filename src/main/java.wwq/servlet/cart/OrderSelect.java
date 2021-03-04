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

@WebServlet("/orderselect")
public class OrderSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpSession session =  request.getSession();

        String isLogin = (String)session.getAttribute("isLogin");

        User user=(User)session.getAttribute("name");


        String eids = request.getParameter("eids");



        if(user!=null && isLogin.equals("1")) {
            int totalprice = 0;

            String ids[] = eids.split(",");

            ArrayList<Cart> list = new ArrayList<Cart>();

            for(int i=0; i<ids.length; i++) {
                Cart es = CartDao.getCartShop(ids[i]);
                System.out.println(es);
                int dprice = es.getCart_p_price() * es.getCart_p_quantity();

                totalprice += dprice;

                list.add(es);
            }

            request.setAttribute("shoplist", list);
            request.setAttribute("totalprice", totalprice);
            request.getRequestDispatcher("order.jsp").forward(request, response);

        }else{

            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('登录后，再购买');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
            out.close();
        }
    }


}
