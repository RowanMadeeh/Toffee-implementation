package model;

import controller.Cart;
import view.MainSystem;

import java.util.Vector;

public class Customer extends Person{
    private String Address;
    private String Status;
    private int LoyaltyPoints;
    private Vector<Order> Orders = new Vector<>();
    private Cart CurrentCart = new Cart();

    public Customer(){
        super();
    }

    public Customer(String name, String email, String username, String password, int phoneNumber,String address){
        super(name,email,username,password,phoneNumber);
        Address = address;
    }
    public void SetStatus(String status){
        Status = status;
    }
    public String GetName(){
        return super.GetName();
    }
    public void ViewCatalog(){
        //
        MainSystem.catalog.View();
    }
    public void AddToCart(){
        //take item name and quantity then call DataBase.CheckItem(Item,Quantity)
        //get item then call currentCart.addItem
    }
    public void RemoveFromCart(){
        //take item name and quantity then call currentCart.removeItem
    }
    public void MakeOrder(){
        //create order object with system.orderNumber and +1 on it
        //orders.add(order)
    }
    public void Reorder(){
        //take the orderNumber from the user and search for it in Orders
        //if it exists make currentCart = order.Cart and call MakeOrder()
    }

}
