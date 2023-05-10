package view;

import model.Customer;

import java.util.Scanner;

public class Viewer {
    private MainSystem mainSystem = new MainSystem();
    Scanner sc = new Scanner(System.in);

    public void GuestView(){

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
                System.out.println("nwrtna ^_^");
                System.exit(0);
            }
        }
        //register,login,ViewCatalog,exit
        //when logged in call CustomerView or AdminView
    }

    public void CustomerView(Customer customer){
        System.out.println("\nWelcome " + customer.GetName() + " ^_^");

        while (true){
            System.out.println("\nChoose what do you want to do:");
            System.out.println("1- View catalog\n2- AddToCart\n3- RemoveFromCart\n4- MakeOrder\n5- Reorder\n6- Exit");
            int op = sc.nextInt();
            if(op == 1){
                MainSystem.catalog.View();
            }
            else if(op == 2){
                customer.AddToCart();
            }
            else if(op == 3){
                customer.RemoveFromCart();
            }
            else if(op == 4){
                customer.MakeOrder();
            }
            else if(op == 5){
                customer.Reorder();
            }
            else{
                System.out.println("nwrtna ^_^");
                System.exit(0);
            }
        }
        //ViewCatalog,AddToCart,RemoveFromCart,MakeOrder,Reorder,Exit
    }
}
