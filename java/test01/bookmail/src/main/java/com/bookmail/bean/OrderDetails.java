package com.bookmail.bean;

/**
 * @author wxy
 * @title: OrderDetails
 * @description: TODO
 * @date 2021/7/2619:06
 */
public class OrderDetails {
    private Integer id;
    private String name;
    private Integer count;
    private Float price;
    private Float totalPrice;
    private String orderid;

    public OrderDetails() {
    }

    public OrderDetails(Integer id, String name, Integer count, Float price, Float totalPrice, String orderid) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderid = orderid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderid='" + orderid + '\'' +
                '}';
    }
}
