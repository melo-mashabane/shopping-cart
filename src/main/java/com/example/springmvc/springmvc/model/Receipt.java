package com.example.springmvc.springmvc.model;

import java.util.Date;
import java.util.List;

public class Receipt {

    private Date date;
    private List<Product> itemsIbBasket;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getItemsIbBasket() {
        return itemsIbBasket;
    }

    public void setItemsIbBasket(List<Product> itemsIbBasket) {
        this.itemsIbBasket = itemsIbBasket;
    }
}
