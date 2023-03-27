package com.example.lab_assignment3;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> cartItems = new ArrayList<>();

    public void addItem(Product product) {
        cartItems.add(product);
    }

    public void updateItem(Product product, int quantity) {
        for (Product item : cartItems) {
            if (item.getProductId() == product.getProductId()) {
                item.setQuantity(quantity);
            }
        }
    }

    public void removeItem(Product product) {
        for (Product item : cartItems) {
            if (item.getProductId() == product.getProductId()) {
                cartItems.remove(item);
                break;
            }
        }
    }

    public ArrayList<Product> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<Product> cartItems) {
        this.cartItems = cartItems;
    }
}
