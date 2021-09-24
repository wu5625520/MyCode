import com.bookmail.bean.Book;
import com.bookmail.bean.User;
import com.bookmail.dao.UserDao;
import com.bookmail.dao.impl.UserDaoImpl;
import com.bookmail.service.BookService;
import com.bookmail.service.UserService;
import com.bookmail.service.impl.BookServiceImpl;
import com.bookmail.service.impl.UserServiceImpl;
import com.bookmail.utils.JdbcUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import sun.rmi.server.UnicastServerRef;

import java.sql.Connection;
import java.util.*;

/**
 * @author wxy
 * @title: Test
 * @description: TODO
 * @date 2021/7/1315:53
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test01(){
        Connection connection= JdbcUtils.getConnection();
        System.out.println(connection);
        JdbcUtils.closeConnection(connection);
    }

    /**
    　　* @description: 测试UserDao功能
    　　* @author wxy
    　　* @date 2021/7/13 20:51
    　　*/
    @org.junit.jupiter.api.Test
    public void test02(){
        //
        UserDao userDao = new UserDaoImpl();
        //System.out.println(userDao.queryByName("wxy"));
        //User zz = new User(2, "zz", "123", "zz@123.com");
        //userDao.saveUser(zz);
        //System.out.println(userDao.deleteByName("zz"));
//        System.out.println(userDao.queryAll());
        Map<Integer,User> map = new HashMap<>();
        map.put(1, new User("wxy","123456"));
        map.put(2, new User("zz","11111"));
        System.out.println(map);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        System.out.println(s);

        //转回去
        Map<Integer,User> map1 = gson.fromJson(s, new TypeToken<HashMap<Integer, User>>(){}.getType());
        System.out.println(map1);

    }

    /**
    　　* @description: 测试UserServiceg功能
    　　* @author wxy
    　　* @date 2021/7/13 20:53
    　　*/
    @org.junit.jupiter.api.Test
    public void test03(){
        UserService userService = new UserServiceImpl();
        //注册
        User xx = new User(4,"xx", "123", "xx@123.com");
//        userService.registUser(xx);
        //登陆and存在
        System.out.println(userService.existUser("xx"));
    }

    @org.junit.jupiter.api.Test
    public void test04(){
        BookService bookService = new BookServiceImpl();
        List<Book> allBook = bookService.getAllBook();
        System.out.println(allBook);

    }
    @org.junit.jupiter.api.Test
    public void testTime(){
        Date date = new Date();
        System.out.println(date.getTime());
    }
}
