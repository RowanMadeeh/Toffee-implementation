package users;

public class Admin extends Person {
    private System system;

    public Admin(String name, String email, String username, String password, int phoneNumber) {
        super(name, email, username, password, phoneNumber);
    }
    public void AddItem(){
        //take all item information then create new item object, call system.DataBase.CheckItem(name) and call system.DataBase.AddItem(item)
    }
    public void UpdateItem(){
        //take item name and the detail you want to update and call system.DataBase.CheckItem(name)
        //take the change and then call system.DataBase.UpdateItem()
    }
    public void RemoveItem(){
        //take item name and then call system.DataBase.checkItem(name) and then call system.DataBase.RemoveItem(name)
    }
    public void AddDiscount(){
        //take item name and then call system.DataBase.checkItem(name)
        //take discount amount and then call system.DataBase.AddDiscount(name,discount)
    }
}
