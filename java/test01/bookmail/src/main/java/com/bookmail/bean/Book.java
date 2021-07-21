package com.bookmail.bean;

/**
 * @author wxy
 * @title: Book
 * @description: TODO
 * @date 2021/7/1914:27
 */
public class Book {
    private Integer id;
    private String name;
    private Float price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String ima_path;

    public Book(Integer id, String name, Float price, String author, Integer sales, Integer stock, String ima_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        this.ima_path = ima_path;
    }

    public Book() {
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getIma_path() {
        return ima_path;
    }

    public void setIma_path(String ima_path) {
        this.ima_path = ima_path;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", ima_path='" + ima_path + '\'' +
                '}';
    }
}
