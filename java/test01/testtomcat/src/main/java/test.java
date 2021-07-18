import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wxy
 * @title: test
 * @description: TODO
 * @date 2021/7/1018:46
 */
public class test implements Servlet {
    public static void main(String[] args){

    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
    　　* @description: 专门处理请求和响应的
    　　* @author wxy
    　　* @date 2021/7/12 15:15
    　　*/
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("test 被访问了");
        servletResponse.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.write("我要传个中文");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
