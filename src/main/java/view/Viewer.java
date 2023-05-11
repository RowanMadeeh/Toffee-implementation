package view;

import model.Customer;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Scanner;

public class Viewer {
    private MainSystem mainSystem = new MainSystem();
    Scanner sc = new Scanner(System.in);

    public Viewer() throws IOException {
    }

    public void GuestView() throws IOException, MessagingException {

        System.out.println("\nWelcome to toffee ^_^");

        while (true){
            System.out.println("\nChoose what do you want to do:");
            System.out.println("1- Register\n2- Login\n3- View catalog\n4- Exit");
            int op = sc.nextInt();
            if(op == 1){
                mainSystem.Register();
            }
            else if(op == 2){
                Pair<Integer, Customer> ret = mainSystem.Login();
                if(ret.first == 1){
                    CustomerView(ret.second);
                }
            }
            else if(op == 3){
                MainSystem.catalog.View();
            }
            else{
                mainSystem.Save();
                System.out.println("nwrtna ^_^");
                System.exit(0);
            }
        }
        //register,login,ViewCatalog,exit
        //when logged in call CustomerView or AdminView
    }

    public void CustomerView(Customer customer) throws IOException {
        System.out.println("\nWelcome " + customer.GetName() + " ^_^");

        while (true){
            System.out.println("\nChoose what do you want to do:");
            System.out.println("1- View catalog\n2- View cart\n3- Exit");
            int op = sc.nextInt();
            sc.nextLine();
            if(op == 1){
                MainSystem.catalog.View();
                System.out.println("\nChoose what do you want to do:");
                System.out.println("1- AddToCart\n2- Exit");
                op = sc.nextInt();
                if(op == 1){
                    customer.AddToCart();
                }
                sc.nextLine();
            }
            else if(op == 2){
                customer.ViewCart();
                System.out.println("\nChoose what do you want to do:");
                System.out.println("1- Remove from cart\n2- Make order\n3- Exit");
                op = sc.nextInt();
                if(op == 1){
                    customer.RemoveFromCart();
                }
                else if(op == 2){
                    customer.MakeOrder();
                }
            }
            else{
                mainSystem.Save();
                System.out.println("nwrtna ^_^");
                System.exit(0);
            }
        }
        //ViewCatalog,AddToCart,RemoveFromCart,MakeOrder,Reorder,Exit
    }
}
