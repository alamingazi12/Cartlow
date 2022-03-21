package com.example.cartflow.model;

import android.graphics.drawable.Drawable;

public class Product {


    public int getProduct_url() {
        return product_url;
    }

    public String getProduct_Tname() {
        return product_Tname;
    }

    public Product(int product_url, String product_Tname) {
        this.product_url = product_url;
        this.product_Tname = product_Tname;
    }

    int product_url;
    String product_Tname;
}
