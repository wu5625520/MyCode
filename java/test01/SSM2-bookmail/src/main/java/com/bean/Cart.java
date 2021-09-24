package com.bean;

import java.util.ArrayList;

/**
 * @author wxy
 * @title: Cart
 * @description: TODO
 * @date 2021/7/2517:20
 */
public class Cart {
    private Integer sumCount;
    private Float sumPrice;
    private ArrayList<CartItem> items = new ArrayList<>();

    public Cart() {
        this.sumCount = 0;
        this.sumPrice = 0.0f;
    }

    public Cart(Integer sumCount, Float sumPrice, ArrayList<CartItem> items) {
        this.sumCount = sumCount;
        this.sumPrice = sumPrice;
        this.items = items;
    }

    public Integer getSumCount() {
        return sumCount;
    }


    public Float getSumPrice() {
        return sumPrice;
    }


    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "sumCount=" + sumCount +
                ", sumPrice=" + sumPrice +
                ", items=" + items +
                '}';
    }

    public void addItem(CartItem cartItem) {
        if(this.items != null){
            for (CartItem item : this.items) {
                if (item.getId().equals(cartItem.getId())) {
                    item.add(1);
                    this.sumCount++;
                    this.sumPrice += cartItem.getPrice();
                    return;
                }
            }
        }
        this.items.add(cartItem);
        this.sumCount++;
        this.sumPrice += cartItem.getPrice();
    }
    /**
    　　* @description:
    　　* @author wxy
    　　* @date 2021/7/25 20:52
    　　*/
    public void updatePriceAndCount(){
        this.sumCount = 0;
        this.sumPrice = 0.0f;
        for(CartItem cartItem : this.items){
            this.sumCount += cartItem.getCount();
            this.sumPrice += cartItem.getTotalPrice();
        }
    }

    public void deleteItemById(int id) {
        for(CartItem cartItem : this.items){
            if(cartItem.getId() == id){
                this.items.remove(cartItem);
                updatePriceAndCount();
                return;
            }
        }
    }

    public void changeCountByid(int count, int id) {
        for(CartItem cartItem : this.items){
            if(cartItem.getId() == id){
                cartItem.setCount(count);
                cartItem.setTotalPrice(count * cartItem.getPrice());
                updatePriceAndCount();
            }
        }
    }
}
