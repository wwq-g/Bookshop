package filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter( "/manage/*")
public class  AdminLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();

        String flag = (String) session.getAttribute("isAdminLogin");

        String reqiest_uri =req.getRequestURI();
        String ctxPath = req.getContextPath();
        String uri = reqiest_uri.substring(ctxPath.length());

        if (uri.contains("admin_")){
            if (flag != null && flag.equals("1")){
                chain.doFilter(req, resp);
            }else {
                PrintWriter out = resp.getWriter();
                out.write("<script>");
                out.write("alert('请先登录！');");
                out.write("location.href='login.jsp'");
                out.write("</script>");
                out.close();
                return;
            }
        }else {
            chain.doFilter(req, resp);
        }

        return;

    }
}
