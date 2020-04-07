package com.android.doitmission14;

public class Product {
    String name;
    String price;
    String info;
    int resid;

    public Product(String name, String price, String info) {
        this.name = name;
        this.price = price;
        this.info = info;
    }
    public Product(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }
}
