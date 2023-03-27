package com.example.lab_assignment3;

public class Product {
    private String productId;
    private String name;
    private int price;
    private int quantity;
    private int imagelink;

    public Product(String productId, String name, int price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imagelink = imagelink;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getImagelink() {
        return imagelink;
    }

    public void setImagelink(int imagelink) {
        this.imagelink = imagelink;
    }

}
