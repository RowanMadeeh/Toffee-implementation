package model;

public class Person {
    private String Name;
    private String Email;
    private String UserName;
    private String Password;
    private int PhoneNumber;

    public Person(){

    }

    public Person(String name, String email, String username, String password, int phoneNumber){
        Name = name;
        Email = email;
        UserName = username;
        Password = password;
        PhoneNumber = phoneNumber;

    }
    public String GetName(){
        return Name;
    }
    public String GetUsername(){
        return UserName;
    }
    public String GetPassword(){
        return Password;
    }
}
