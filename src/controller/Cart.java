package controller;

import model.Item;

import java.util.Vector;

public class Cart {
    private Vector<Item>CartItems;
    private Float TotalAmount;

    public Float GetTotalAmount(){
        return TotalAmount;
    }
    public void AddToCart(Item item, int Quantity){
//        check if it is in the cart change the quantity
//        item.quantity += Quantity;
//        else CartItems.add(item) and TotalAmount += item.price;
//        check if the item quantity became greater than catalog item quantity or greater than 50
    }
    public void RemoveFromCart(String Name, int Quantity){
//        check if it is in the cart change the quantity
    }
}
