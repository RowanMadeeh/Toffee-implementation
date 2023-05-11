package model;
/**

 Represents an order made by a customer.
 */

public class Order {

    private Cart cart;
    private int OrderNumber;
    private String OrderStatus;
    private String DestinationAddress;

    /**
     Creates a new Order object with the specified cart, order number, order status, and destination address.
     @param _cart The cart containing the items to be ordered.
     @param orderNumber The unique number assigned to the order.
     @param orderStatus The current status of the order.
     @param destinationAddress The address where the order will be delivered.
     */
    public Order(Cart _cart, int orderNumber, String orderStatus, String destinationAddress){
        cart = _cart;
        OrderNumber = orderNumber;
        OrderStatus = orderStatus;
        DestinationAddress = destinationAddress;
    }
}
