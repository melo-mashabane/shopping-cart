package com.example.springmvc.springmvc.model;

import java.util.Date;
import java.util.List;

public class Receipt {

    private String date;
    private List<Product> itemsIbBasket;
    private Double cost;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Product> getItemsIbBasket() {
        return itemsIbBasket;
    }

    public void setItemsIbBasket(List<Product> itemsIbBasket) {
        this.itemsIbBasket = itemsIbBasket;
    }
}
