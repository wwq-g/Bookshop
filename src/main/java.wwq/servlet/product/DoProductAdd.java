package servlet.product;


import com.jspsmart.upload.*;
import entity.Product;
import service.ProductDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/manage/admin_doproductadd")
public class DoProductAdd extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建SmartUpload对象
        SmartUpload su= new SmartUpload();

        //初使化
        su.initialize(this.getServletConfig(), request, response);

        //上传过程
        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        //获取上传的文件对象
        Files fs= su.getFiles();
        File f = fs.getFile(0);
        //获取上传的文件名称
        String fname = f.getFileName();
//        System.out.println(fname);
//        String savePath=request.getServletContext().getRealPath("/images/product");
//        System.out.println(savePath);
        try {
            su.save("/");

        } catch (SmartUploadException e) {
            e.printStackTrace();
        }

        Request req1 = su.getRequest();

        String pname = req1.getParameter("productName");
        String id = req1.getParameter("parentId");
        String price = req1.getParameter("productPrice");
        String desc = req1.getParameter("productDesc");
        String stock = req1.getParameter("productStock");

        Product p = new Product(
            0,
            pname,
            desc,
            Integer.parseInt(price),
            Integer.parseInt(stock),
            Integer.parseInt(id.split("-")[0]),
                Integer.parseInt(id.split("-")[1]),
                fname
        );

        int count = ProductDao.insert(p);
//        System.out.println(p);
//        System.out.println(count);
        if(count >0 ) {

            response.sendRedirect("admin_productselect");
        } else {
            PrintWriter out = response.getWriter();

            out.write("<script>");
            out.write("alert('商品添加失败')");
            out.write("location.href='manage/admin_toproductadd'");
            out.write("</script>");

        }

    }
}
