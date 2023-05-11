package view;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/**
 * The MainSystem class represents the main system of the application.
 * It manages the login process and the catalog.
 */
public class MainSystem {

    private Vector<Customer> Registered = new Vector<>();
    public static Catalog catalog = new Catalog();
    public static int orderNumber;
    Scanner sc = new Scanner(System.in);

    /**
     * Constructs a MainSystem object and loads the data from files.
     *
     * @throws IOException if there is an error reading the files
     */
    public MainSystem() throws IOException {
        Load();
    }

    /**
     * Handles the login process.
     *
     * @return a Pair object containing an integer and a Customer object:
     *         - the integer value represents the login result (0 for failure, 1 for success)
     *         - the Customer object represents the logged in customer (empty if the login failed)
     */
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

    /**
     This method allows a customer to register by taking their personal information such as name, email, username, password,
     phone number, and address. The method checks if the username is not taken before, creates a customer object using the provided information,
     and adds the customer to the Registered list.
     @return void
     */

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

    /**
     The Load method reads the data from the Registered.txt file and loads the customers' information into the Registered vector.
     It also reads the data from the Catalog.txt file and loads the items into the catalog.
     Finally, it reads the data from the OrderNumber.txt file and loads the order number.
     @throws IOException when the file is not found or when there is an error reading from the file.
     */
    public void Load() throws IOException {

        File file = new File("Registered.txt");
        FileReader Reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(Reader);

        String line;

        while ((line = bufferedReader.readLine()) != null){
            ArrayList<String> data = new ArrayList<>(6);
            data.addAll(Arrays.asList(line.split(",")));
            Customer customer = new Customer(data.get(0),data.get(1),data.get(2),data.get(3),Integer.parseInt(data.get(4)),data.get(5));
            Registered.add(customer);
        }

        Reader.close();
        bufferedReader.close();

        file = new File("Catalog.txt");
        Reader = new FileReader(file);
        bufferedReader = new BufferedReader(Reader);

        while ((line = bufferedReader.readLine()) != null){
            ArrayList<String> data = new ArrayList<>(8);
            data.addAll(Arrays.asList(line.split(",")));
            Item item = new Item(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5),Float.parseFloat(data.get(6)),Integer.parseInt(data.get(7)));
            catalog.AddItem(item);
        }

        Reader.close();
        bufferedReader.close();

        file = new File("OrderNumber.txt");
        Reader = new FileReader(file);
        bufferedReader = new BufferedReader(Reader);

        line = bufferedReader.readLine();
        orderNumber = Integer.parseInt(line);

        Reader.close();
        bufferedReader.close();
    }

    /**

     Saves the customer information, catalog information, and order number to their respective files.

     @throws IOException If there is an error while writing to any of the files.
     */
    public void Save() throws IOException {
        File file = new File("Registered.txt");
        FileWriter Writer = new FileWriter(file);
        for (int i = 0; i < Registered.size(); i++) {
            Writer.write(Registered.get(i).GetName() + ",");
            Writer.write(Registered.get(i).GetEmail() + ",");
            Writer.write(Registered.get(i).GetUsername() + ",");
            Writer.write(Registered.get(i).GetPassword() + ",");
            Writer.write(Registered.get(i).GetPhoneNumber() + ",");
            Writer.write(Registered.get(i).GetAddress() + ",");
            Writer.write(Registered.get(i).GetStatus() + "\n");
        }
        Writer.close();

        file = new File("Catalog.txt");
        Writer = new FileWriter(file);
        Vector<Item>c = catalog.GetCatalogItems();
        for (int i = 0; i < c.size(); i++) {
            Writer.write(c.get(i).GetName() + ",");
            Writer.write(c.get(i).GetCategory() + ",");
            Writer.write(c.get(i).GetBrand() + ",");
            Writer.write(c.get(i).GetUnitType() + ",");
            Writer.write(c.get(i).GetStatus() + ",");
            Writer.write(c.get(i).GetDescription() + ",");
            Writer.write(c.get(i).GetPrice() + ",");
            Writer.write(c.get(i).GetQuantity() + "\n");
        }

        Writer.close();

        file = new File("OrderNumber.txt");
        Writer = new FileWriter(file);
        Writer.write(String.valueOf(orderNumber));

        Writer.close();
    }
}
