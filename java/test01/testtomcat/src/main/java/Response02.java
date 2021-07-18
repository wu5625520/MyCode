import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wxy
 * @title: Response02
 * @description: TODO
 * @date 2021/7/1313:58
 */
public class Response02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is response02 the key is :" + req.getAttribute("key"));
        System.out.println("this is response02！the username is: " + req.getParameter("username"));
    }
}
