package com.controler;

import com.bean.Cart;
import com.bean.OrderDetails;
import com.bean.Orders;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author wxy
 * @title: OrderControl
 * @description: TODO
 * @date 2021/8/1920:48
 */

@Controller
@RequestMapping(value = "orderControl/")
public class OrderControl {
    @Autowired
    OrderService orderService;

    @RequestMapping(method = RequestMethod.GET, value = "creatOrder")
    public String creatOrder(HttpSession httpSession) throws Exception {
        String username = (String) httpSession.getAttribute("username");
        String orderid = username + new java.util.Date().getTime();
        Cart cart = (Cart) httpSession.getAttribute("cart");
        Orders order = new Orders(orderid, new Timestamp(System.currentTimeMillis()), 0, username, cart.getSumPrice());

        orderService.creatOrderAndOrderDetails(order, cart ,orderid);

        //清空购物车
        httpSession.removeAttribute("cart");
        httpSession.setAttribute("orderid", orderid);
        return "redirect:/client/checkoutPage";
    }

    @RequestMapping(method = RequestMethod.GET, value = "clientOrders")
    public ModelAndView clientOrders(HttpSession httpSession,
                                     ModelAndView modelAndView){
        String username = (String) httpSession.getAttribute("username");
        ArrayList<Orders> orders = orderService.getOrdersByUsername(username);
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("order/order");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "clientOrdersDetails")
    public String clientOrdersDetails(HttpServletRequest req,
                                      @RequestParam(value = "orderid", required = false) String orderid){
//        if(orderid == null){
//            return "/loginPage";
//        }//没有登陆不会显示"我的订单"
        ArrayList<OrderDetails> orderDetails = orderService.getOrderDetailsByOrderId(orderid);
        req.getSession().setAttribute("orderDetails", orderDetails);
        return "redirect:/order/order_details";
    }
}
