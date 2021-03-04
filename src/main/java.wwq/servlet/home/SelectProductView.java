package servlet.home;

import entity.Category;
import entity.Product;
import service.CateDao;
import service.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectproductview")
public class SelectProductView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Category> flist = CateDao.selectCat("father");
        request.setAttribute("flist",flist);
        ArrayList<Category> clist = CateDao.selectCat("child");
        request.setAttribute("clist",clist);

        String id =request.getParameter("id");

        Product p = null;

        if (id != null){
            p = ProductDao.selectById(Integer.parseInt(id));
            request.setAttribute("p",p);
//            System.out.println(p);
        }

//        System.out.println(p);

        if (p != null){
            int cid = p.getProduct_cid();
            ArrayList<Product> classlist = ProductDao.selectAllByCid(cid);
            request.setAttribute("classlist",classlist);
            Category cate =CateDao.selectById(cid);
            request.setAttribute("cate",cate);
//            System.out.println(cid);
//            System.out.println(classlist);
//            System.out.println(cate);
        }


        //获取最近访问
        HttpSession session = request.getSession();
        //从session获取ids
        ArrayList<Integer> ids = (ArrayList<Integer>)session.getAttribute("ids");

        if (ids == null){
            ids = new ArrayList<Integer>();
        }

        //最多访问5个，如果多于5个将第一个删除
        if (ids.size() >= 5){
            ids.remove(0);
        }

        //添加列表里，但只要一份
        if (ids != null && (!ids.contains(Integer.parseInt(id)))){
            ids.add(Integer.parseInt(id));

        }

        session.setAttribute("ids",ids);

        ids = (ArrayList<Integer>) session.getAttribute("ids");

        if (ids!= null){
            ArrayList<Product> lastlylist = ProductDao.selectAllById(ids);
            request.setAttribute("lastlylist",lastlylist);
        }




        request.getRequestDispatcher("productview.jsp").forward(request,response);
    }


}
