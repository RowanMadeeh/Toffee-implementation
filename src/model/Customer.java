package model;

import view.MainSystem;

import java.util.Scanner;

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

    public Customer() {

    }

    public Customer(String name, String email, String username, String password, int phoneNumber, String address) {
        Name = name;
        Email = email;
        UserName = username;
        Password = password;
        PhoneNumber = phoneNumber;
        Address = address;
    }

    public String GetName() {
        return Name;
    }

    public String GetEmail() {
        return Email;
    }

    public String GetUsername() {
        return UserName;
    }

    public String GetPassword() {
        return Password;
    }

    public int GetPhoneNumber(){
        return PhoneNumber;
    }

    public String GetAddress(){
        return Address;
    }

    public String GetStatus(){
        return Status;
    }

    public void SetStatus(String status) {
        Status = status;
    }

    public void ViewCatalog() {
        //
        MainSystem.catalog.View();
    }

    public void ViewCart() {
        CurrentCart.View();
    }

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

    public void Reorder() {
        //take the orderNumber from the user and search for it in Orders
        //if it exists make currentCart = order.Cart and call MakeOrder()
    }

}
