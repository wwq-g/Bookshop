package servlet.cart;

import service.CartDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cartshopnumadd")
public class CartShopnumAdd extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String count = request.getParameter("count");
        String esid = request.getParameter("esid");

        CartDao.updatenum(Integer.parseInt(esid), Integer.parseInt(count));
    }


}
