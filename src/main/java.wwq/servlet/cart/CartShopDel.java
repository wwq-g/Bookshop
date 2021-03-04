package servlet.cart;

import service.CartDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cartshopdel")
public class CartShopDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String esid = request.getParameter("esid");

        int count = CartDao.getDeleteDD(Integer.parseInt(esid));


        //成功或失败重定向到哪里

        if(count >0 ) {

            response.sendRedirect("showcart");
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('图书删除失败');");
            out.write("location.href='showcart");
            out.write("</script>");

        }

    }


}
