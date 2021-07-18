import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxy
 * @title: Response01
 * @description: TODO
 * @date 2021/7/1313:57
 */
public class Response01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key","response01");
        System.out.println("this is response01! the username is:" + req.getParameter("username"));
//        resp.setStatus(302);
//        resp.setHeader("location","http://localhost:8080/testtomcat/response02");
        resp.sendRedirect("http://localhost:8080/testtomcat/response02");
    }
}
