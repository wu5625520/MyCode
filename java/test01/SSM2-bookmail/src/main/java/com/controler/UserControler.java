package com.controler;

import com.bean.User;
import com.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;

/**
 * @author wxy
 * @title: UserControler
 * @description: TODO
 * @date 2021/8/914:56
 */

@Controller
@RequestMapping(value = "/userControl")
public class UserControler {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ModelAndView login(ModelAndView modelAndView,
                               User user,
                               HttpSession httpSession,
                               @RequestParam(value = "username") String userName,
                               @RequestParam(value = "password") String password){
        switch (userService.login(user)){
            case 0:
                modelAndView.addObject("msg", "用户名不存在，请注册");
                modelAndView.addObject("username", user.getUsername());
                modelAndView.setViewName("user/login");
                System.out.println("用户名不存在，请注册"); //怎么传到前端？  用请求转发
//                resp.sendRedirect("http://localhost:8080/bookmail/pages/user/login.jsp");
                return modelAndView;  //刷新是不是会重复提交？ 答：刷新确实会重复提交，解决方式：设置验证码
                                        //默认是不是请求转发？
            case 1:
                modelAndView.addObject("msg", "密码错误，请重新输入");
                modelAndView.addObject("username", user.getUsername());
                modelAndView.setViewName("forward:/WEB-INF/pages/user/login.jsp");
                System.out.println("密码错误，请重新输入"); //怎么传到前端？
//                resp.sendRedirect("http://localhost:8080/bookmail/pages/user/login.jsp");
                return modelAndView;  //刷新是不是会重复提交？
            case 2:
                if("wxy520".equals(user.getUsername())){
                    httpSession.setAttribute("isManager", true);
                }
                httpSession.setAttribute("username", user.getUsername());
                modelAndView.setViewName("user/login_success");
                return modelAndView;
        }
        return null; //我switch，case、里都有返回了，这个不会执行
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/client/listBookByPage";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/regist")
    public ModelAndView regist(User user,
                      ModelAndView modelAndView,
                      HttpSession httpSession,
                      @RequestParam(value = "code", required = true) String code){
        String kaptcha_session_key = (String) httpSession.getAttribute("KAPTCHA_SESSION_KEY");
        httpSession.removeAttribute("KAPTCHA_SESSION_KEY"); //收到验证码就删除session中的，防止重复提交
        if(kaptcha_session_key == null || !kaptcha_session_key.equalsIgnoreCase(code)){
            modelAndView.addObject("msg", "验证码错误");
            modelAndView.addObject("username", user.getUsername());
            modelAndView.addObject("password", user.getPassword());
            modelAndView.addObject("email", user.getEmail());
            modelAndView.addObject("code", code);
            modelAndView.setViewName("user/regist");
            System.out.println("验证码错误");  //需要发送到前端？ 答：用请求转发，msg放在request域中.
                                            // 验证码需要后端动态生成？ 答：是的。
            return modelAndView;
        }

        //判断用户是否已经存在
        if(userService.existUser(user.getUsername())){
            modelAndView.addObject("msg", "用户名已经存在，请重新注册");
            modelAndView.addObject("username", user.getUsername());
            modelAndView.setViewName("user/regist");
            System.out.println("用户名已经存在，请重新注册"); //怎么发送给前端？ 答：用请求转发
            return modelAndView;
        }
        userService.registUser(user);
//        modelAndView.setViewName("redirect:/WEB-INF/user/regist_success.jsp");//因为重定向相当于浏览器重新从服务器端请求页面，
                                                                                // 而/WEB-INF/下的文件是不允许直接浏览器请求访问的，所以，不可以使用重定向，
        modelAndView.setViewName("redirect:/user/regist_successPage");
        return modelAndView;
    }
}
