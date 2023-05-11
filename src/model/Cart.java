package model;

import view.MainSystem;

import java.util.Vector;

public class Cart {
    private Vector<Item>CartItems = new Vector<>();
    private Float TotalAmount = 0F;

    public Cart(){

    }

    public Cart(Cart other){
        CartItems = other.CartItems;
        TotalAmount = other.TotalAmount;
    }

    public Float GetTotalAmount(){
        return TotalAmount;
    }
    public int GetSize(){
        return CartItems.size();
    }

    public void View(){

        if(CartItems.isEmpty()){
            System.out.println("The cart is empty");
            return;
        }

        System.out.printf("     %-25s","Category");
        System.out.printf("%-25s","Name");
        System.out.printf("%-25s","Brand");
        System.out.printf("%-25s","UnitType");
        System.out.printf("%-25s","Description");
        System.out.printf("%-20s","Quantity");
        System.out.printf("%-20s","TotalPrice");
        System.out.println("Status");

        for (int i = 0; i < CartItems.size(); i++) {
            System.out.printf("%-5s", i + 1 + "-");
            CartItems.get(i).View(true);
            System.out.println();
        }
        System.out.println();
    }

    public void Clear(){
        for (int i = 0; i < CartItems.size(); i++) {
            MainSystem.catalog.RemoveItem(CartItems.get(i).GetName(),CartItems.get(i).GetQuantity());
        }
        CartItems.clear();
        TotalAmount = 0F;
    }

    public void AddToCart(Item item){
        CartItems.add(item);
    }

    public void AddToCart(String Name, int Quantity){

//        check if it is in the cart change the quantity
//        item.quantity += Quantity;
//        else CartItems.add(item) and TotalAmount += item.price;
//        check if the item quantity became greater than catalog item quantity or greater than 50

        for (int i = 0; i < CartItems.size(); i++) {
            if(CartItems.get(i).GetName().equals(Name)){
                int CurrenQuantity = CartItems.get(i).GetQuantity();
                int NewQuantity = CurrenQuantity + Quantity;
                if(NewQuantity > 50){
                    System.out.println("Sorry you can't add more than 50 unit of any item!!");
                    return;
                }
                if(!MainSystem.catalog.CheckItem(Name,NewQuantity)){
                    System.out.println("Sorry you can't add more units than what is available!!");
                    return;
                }
                CartItems.get(i).SetQuantity(NewQuantity);
                TotalAmount += Quantity * CartItems.get(i).GetPrice();
                System.out.println("Item added to cart successfully");

            }
        }

        if(!MainSystem.catalog.CheckItem(Name,Quantity)){
            System.out.println("Sorry you can't add more units than what is available!!");
            return;
        }
        System.out.println("Item added to cart successfully");
        Item item = new Item(MainSystem.catalog.GetItem(Name));
        item.SetQuantity(Quantity);
        CartItems.add(item);
    }
    public void RemoveFromCart(String Name, int Quantity){

//        check if it is in the cart change the quantity

        for (int i = 0; i < CartItems.size(); i++) {
            if(CartItems.get(i).GetName().equals(Name)){
                int CurrenQuantity = CartItems.get(i).GetQuantity();
                int NewQuantity = CurrenQuantity - Quantity;
                if(Quantity > CartItems.get(i).GetQuantity()){
                    System.out.println("Sorry you can't remove units more than what is in the cart");
                    return;
                }
                CartItems.get(i).SetQuantity(NewQuantity);
                if(NewQuantity == 0){
                    CartItems.remove(i);
                }
                TotalAmount -= Quantity * CartItems.get(i).GetPrice();
                System.out.println("Quantity removed successfully");
                return;
            }
        }

        System.out.println("Sorry the item isn't in the cart");
    }
}
