package servlet.user;

import entity.User;
import service.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/manage/admin_douserselect")
public class DoUserSelect extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cpage = 1;//当前页
        int count = 7; //每页显示条数

        //获取用户指定的页面
        String cp = request.getParameter("cp");

        if (cp!=null){
            cpage = Integer.parseInt(cp);
        }
//        System.out.println("cp"+cp);
        //获取用户搜索内容
        String keywords = request.getParameter("keywords");

        int arr[] = UserDao.totalPage(count,keywords);

        //获取所有用户记录
        ArrayList<User> list = UserDao.selectAll(cpage,count,keywords);

        //放到请求对象域中
        request.setAttribute("userlist",list);
        request.setAttribute("tsum",arr[0]);
        request.setAttribute("tpage", arr[1]);
        request.setAttribute("cpage", cpage);
//        System.out.println(list);

        if(keywords != null) {
            request.setAttribute("searchParams", "&keywords="+keywords);
        }

        request.getRequestDispatcher("admin_user.jsp").forward(request,response);
    }
}
