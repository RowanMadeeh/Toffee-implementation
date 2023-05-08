package system_management;

import shopping.Catalog;
import users.Customer;

import java.util.Vector;

public class System {
    private Vector<Customer>LoggedIn;
    private Vector<Customer>Registered;
    public static Catalog DataBase;

    public void Login(){
        //take username and password then check if it is in Registered and not in LoggedIn
        //then get the customer object by his username and add it into LoggedIn
        //check using IsLoggedIn and IsRegistered
    }
    public void Register(){
        //take all customer info and check the username isn't taken before
        //create customer object and add it to Registered
    }
    public boolean IsLoggedIn(String username){
        //check that customer in LoggedIn has that username



        return true;
    }
    public boolean IsRegistered(String username){
        //check that customer in LoggedIn has that username



        return true;
    }
}
