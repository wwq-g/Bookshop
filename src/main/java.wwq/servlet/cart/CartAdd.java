package servlet.cart;

import entity.Cart;
import entity.Product;
import entity.User;
import service.CartDao;
import service.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartadd")
public class CartAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String pid = request.getParameter("id");
            String count = request.getParameter("count");
            String url = request.getParameter("url");

        HttpSession session = request.getSession();

        String isLogin = (String) session.getAttribute("isLogin");

        User user = (User) session.getAttribute("name");

        if (user!=null && isLogin.equals("1")){
             String uid = (String)user.getUsername();



                Product p = null;
            //通过用户ID和购物车中的商品ID 查看有没有这条记录

            Cart srcsp = CartDao.getCartShop(uid, pid);

            if(srcsp != null) {
                int srccount = srcsp.getCart_p_quantity();

                int newcount = srccount + Integer.parseInt(count);

                if(newcount >=5) {
                    newcount =5;
                }

                CartDao.updatenum(srcsp.getCart_id(), newcount);

            }else {

                if (pid != null) {
                    p = ProductDao.selectById(Integer.parseInt(pid));
                }
//                System.out.println("p:"+p);
                Cart cart = new Cart(
                        0,
                        p.getProduct_filename(),
                        p.getProduct_name(),
                        p.getProduct_price(),
                        Integer.parseInt(count),
                        p.getProduct_stock(),
                        p.getProduct_id(),
                        uid,
                        1

                );

                int coun = CartDao.insert(cart);
//            System.out.println(coun);
//            System.out.println(cart);

            }

        }else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('请先登录，再购买！');");
            out.write("location.href='login.jsp'");
            out.write("</script>");
        }

        if (url.equals("z")){
            response.sendRedirect("showcart");
        }else {
            response.sendRedirect("selectproductview?id="+pid);
        }

    }
}
