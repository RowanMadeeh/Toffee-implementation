package model;

import view.MainSystem;

import java.util.Scanner;

/**

 The Customer class represents a customer of the online shopping system.

 It contains the customer's name, email, username, password, phone number, address, status,

 loyalty points, and current cart.
 */
public class Customer {

    private String Name;
    private String Email;
    private String UserName;
    private String Password;
    private int PhoneNumber;
    private String Address;
    private String Status;
    private int LoyaltyPoints;
    private Cart CurrentCart = new Cart();
    Scanner sc = new Scanner(System.in);
    /**

     Default constructor
     */
    public Customer() {

    }
    /**
     Constructs a new customer object with the given name, email, username, password, phone number, and address.
     @param name The customer's name.
     @param email The customer's email.
     @param username The customer's username.
     @param password The customer's password.
     @param phoneNumber The customer's phone number.
     @param address The customer's address.
     */

    public Customer(String name, String email, String username, String password, int phoneNumber, String address) {
        Name = name;
        Email = email;
        UserName = username;
        Password = password;
        PhoneNumber = phoneNumber;
        Address = address;
    }
    /**
     Returns the customer's name.
     @return The customer's name.
     */
    public String GetName() {
        return Name;
    }
    /**
     Returns the customer's email.
     @return The customer's email.
     */
    public String GetEmail() {
        return Email;
    }
    /**
     Returns the customer's username.
     @return The customer's username.
     */
    public String GetUsername() {
        return UserName;
    }
    /**
     Returns the customer's password.
     @return The customer's password.
     */
    public String GetPassword() {
        return Password;
    }
    /**
     Returns the customer's phone number.
     @return The customer's phone number.
     */
    public int GetPhoneNumber(){
        return PhoneNumber;
    }
    /**
     Returns the customer's address.
     @return The customer's address.
     */
    public String GetAddress(){
        return Address;
    }
    /**
     Returns the customer's status.
     @return The customer's status.
     */
    public String GetStatus(){
        return Status;
    }
    /**

     Sets the customer's status.
     @param status The customer's status.
     */
    public void SetStatus(String status) {
        Status = status;
    }
    /**
     Displays the catalog of items available for purchase.
     */
    public void ViewCatalog() {
        //
        MainSystem.catalog.View();
    }
    /**
     Displays the catalog of items available for purchase.
     */
    public void ViewCart() {
        CurrentCart.View();
    }
    /**
     Adds an item to the customer's cart.
     */
    public void AddToCart() {

        //take item name and quantity then call DataBase.CheckItem(Item)
        //get item then call currentCart.addItem

        System.out.print("Please enter the name of the item you want to add to the cart: ");
        String Name = sc.nextLine();

        System.out.print("Please enter the quantity of the item you want to add to the cart ranges between 1 and 50: ");
        int Quantity = sc.nextInt();
        while (Quantity <= 0 || Quantity > 50) {
            sc.nextLine();
            System.out.println("Invalid!!\nPlease enter a valid quantity between 1 and 50");
            Quantity = sc.nextInt();
        }
        sc.nextLine();

        if (!MainSystem.catalog.CheckItem(Name)) {
            System.out.println("Sorry the item doesn't exist in the catalog, Please try again");
            return;
        }

        CurrentCart.AddToCart(Name, Quantity);

    }
    /**
     Removes an item from the customer's cart.
     */
    public void RemoveFromCart() {

        //take item name and quantity then call currentCart.removeItem

        System.out.print("Please enter the name of the item you want to remove from the cart: ");
        String Name = sc.nextLine();

        System.out.print("Please enter the quantity of the item you want to remove from the cart ranges between 1 and 50: ");
        int Quantity = sc.nextInt();
        while (Quantity <= 0 || Quantity > 50) {
            sc.nextLine();
            System.out.println("Invalid!!\nPlease enter a valid quantity between 1 and 50");
            Quantity = sc.nextInt();
        }
        sc.nextLine();

        CurrentCart.RemoveFromCart(Name, Quantity);
    }


    /**
     This method is used to create a new order and add it to the orders list. If the customer's cart is empty, the method
     will print an error message and return.
     <p>The method creates an order object using the current customer's cart, the system's current order number incremented
     by 1, the status "Not delivered" and the customer's address. It then increments the system's order number by 1 and clears
     the customer's cart. Finally, it prints a success message.</p>
     */
    public void MakeOrder() {

        //create order object with system.orderNumber and +1 on it
        //orders.add(order)
        if (CurrentCart.GetSize() == 0) {
            System.out.println("Sorry your cart is empty");
            return;
        }
        Order order = new Order(CurrentCart, MainSystem.orderNumber, "Not delivered", Address);
        MainSystem.orderNumber++;
        CurrentCart.Clear();

        System.out.println("Order made successfully");
    }

//    public void Reorder() {
//        //take the orderNumber from the user and search for it in Orders
//        //if it exists make currentCart = order.Cart and call MakeOrder()
//    }

}
