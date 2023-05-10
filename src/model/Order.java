package model;

import controller.Cart;

public class Order {
    private Cart cart = new Cart();
    private int OrderNumber;
    private String OrderStatus;
    private Float TotalAmount;
    public Order(Cart _cart, int orderNumber, String orderStatus, Float totalAmount){
        cart = _cart;
        OrderNumber = orderNumber;
        OrderStatus = orderStatus;
        TotalAmount = totalAmount;
    }
}
