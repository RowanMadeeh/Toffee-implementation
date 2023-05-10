package view;

import model.Catalog;
import model.Customer;

import java.util.Scanner;
import java.util.Vector;

public class MainSystem {

    private Vector<Customer> Registered = new Vector<>();
    public static Catalog catalog = new Catalog();
    public static int orderNumber = 0;
    Scanner sc = new Scanner(System.in);

    public Pair<Integer, Customer> Login() {

        //take username and password then check if it is in Registered and not in LoggedIn
        //then get the customer object by his username and add it into LoggedIn
        //check using IsLoggedIn and IsRegistered
        //check if the username matches the admin username
        //0 if failed, 1 if customer

        System.out.print("Please enter your username: ");
        String Username = sc.nextLine();

        System.out.print("Please enter your password: ");
        String Password = sc.nextLine();

        for (int i = 0; i < Registered.size(); i++) {
            if (Registered.get(i).GetUsername().equals(Username) && Registered.get(i).GetPassword().equals(Password)) {
                return new Pair<>(1, Registered.get(i));
            }
        }

        System.out.println("Invalid username or password, Please try again");
        return new Pair<>(0, new Customer());
    }

    public void Register() {

        //take all customer info and check the username isn't taken before
        //create customer object and add it to Registered

        System.out.print("Please enter your name: ");
        String Name = sc.nextLine();

        System.out.print("Please enter your email: ");
        String Email = sc.nextLine();

        System.out.print("Please enter your username: ");
        String UserName = sc.nextLine();

        System.out.print("Please enter your password: ");
        String Password = sc.nextLine();

        System.out.print("Please enter your phone number: ");
        int PhoneNumber = sc.nextInt();

        sc.nextLine();

        System.out.print("Please enter your Address: ");
        String Address = sc.nextLine();

        for (int i = 0; i < Registered.size(); i++) {
            if (Registered.get(i).GetUsername().equals(UserName)) {
                System.out.println("Sorry the username is taken before, Please try again");
                return;
            }
        }

        Customer customer = new Customer(Name, Email, UserName, Password, PhoneNumber, Address);
        Registered.add(customer);
        System.out.println("Registered successfully");
    }
}
