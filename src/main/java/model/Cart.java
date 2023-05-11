package model;

import view.MainSystem;

import java.util.Vector;

/**

 A class representing a shopping cart.
 */
public class Cart {
    private Vector<Item>CartItems = new Vector<>();
    private Float TotalAmount = 0F;
    /**

     Constructs an empty Cart object.
     */
    public Cart(){

    }
    /**

     Constructs a new Cart object that is a copy of another Cart object.
     @param other the Cart object to be copied
     */
    public Cart(Cart other){
        CartItems = other.CartItems;
        TotalAmount = other.TotalAmount;
    }
    /**

     Returns the total amount of the cart.
     @return the total amount
     */
    public Float GetTotalAmount(){
        return TotalAmount;
    }
    /**
     Returns the size of the cart.
     @return the size
     */
    public int GetSize(){
        return CartItems.size();
    }

    /**
     * Displays the items in the cart.
     */
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

    /**
     * Clears all items from the cart and updates the catalog and total amount.
     */
    public void Clear(){
        for (int i = 0; i < CartItems.size(); i++) {
            MainSystem.catalog.RemoveItem(CartItems.get(i).GetName(),CartItems.get(i).GetQuantity());
        }
        CartItems.clear();
        TotalAmount = 0F;
    }

    /**
     * Adds the specified item to the cart.
     *
     * @param item the item to be added to the cart
     */
    public void AddToCart(Item item){
        CartItems.add(item);
    }

    /**
     * Adds an item with the specified name and quantity to the cart.
     * If the item is already in the cart, updates its quantity.
     * Checks if the quantity is greater than the available quantity or greater than 50 units.
     *
     * @param Name the name of the item to be added to the cart
     * @param Quantity the quantity of the item to be added to the cart
     */
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

    /**
     Removes an item from the cart.
     @param Name the name of the item to remove from the cart.
     @param Quantity the quantity of the item to remove from the cart.
     */
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
