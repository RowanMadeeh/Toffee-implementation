package model;

public class Order {

    private Cart cart;
    private int OrderNumber;
    private String OrderStatus;
    private String DestinationAddress;

    public Order(Cart _cart, int orderNumber, String orderStatus, String destinationAddress){
        cart = _cart;
        OrderNumber = orderNumber;
        OrderStatus = orderStatus;
        DestinationAddress = destinationAddress;
    }
}
