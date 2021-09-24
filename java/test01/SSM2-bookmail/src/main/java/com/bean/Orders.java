package com.bean;


import java.sql.Timestamp;

/**
 * @author wxy
 * @title: Orders
 * @description: TODO
 * @date 2021/7/2617:28
 */
public class Orders {
    private String orderid;
    private Timestamp creatdate;
    private Integer status;
    private String username;
    private Float price;

    public Orders() {
    }

    public Orders(String orderid, Timestamp creatdate, Integer status, String username, Float price) {
        this.orderid = orderid;
        this.creatdate = creatdate;
        this.status = status;
        this.username = username;
        this.price = price;
    }

    public Timestamp getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Timestamp creatdate) {
        this.creatdate = creatdate;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid='" + orderid + '\'' +
                ", creatdate=" + creatdate +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", price=" + price +
                '}';
    }
}
