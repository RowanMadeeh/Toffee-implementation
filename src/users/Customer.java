package users;

import shopping.Cart;
import shopping.Catalog;
import shopping.Item;
import shopping.Order;

import java.util.Vector;

public class Customer extends Person{
    private String Address;
    private String Status;
    private int LoyaltyPoints;
    private Vector<Order> Orders;
    private Cart CurrentCart;
    public static Catalog DataBase;

    public Customer(String name, String email, String username, String password, int phoneNumber,String address){
        super(name,email,username,password,phoneNumber);
        Address = address;
    }
    public void SetStatus(String status){
        Status = status;
    }
    public void ViewCatalog(){
        //
    }
    public void AddToCart(){
        //take item name and quantity then call DataBase.CheckItem(Item,Quantity)
        //get item then call currentCart.addItem
    }
    public void RemoveFromCart(){
        //take item name and quantity then call currentCart.removeItem
    }
    public void MakeOrder(){

    }
    public void Reorder(){

    }

}
