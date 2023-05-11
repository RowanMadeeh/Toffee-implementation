package model;
/**
 The Item class represents a product item that can be added to a shopping cart and purchased in the system.
 */
public class Item {
    private String Name;
    private String Category;
    private String Brand;
    private String UnitType;
    private String Status;
    private String Description;
    private Float Price;
    private int Quantity;
    /**
     Constructs a new Item object with default values.
     */
    public Item(){

    }
    /**
     Constructs a new Item object with the specified parameters.
     @param name the name of the item
     @param category the category of the item
     @param brand the brand of the item
     @param unitType the unit type of the item
     @param status the status of the item
     @param description the description of the item
     @param price the price of the item
     @param quantity the quantity of the item
     */
    public Item(String name, String category, String brand, String unitType,
                String status, String description, Float price, int quantity) {
        Name = name;
        Category = category;
        Brand = brand;
        UnitType = unitType;
        Status = status;
        Description = description;
        Price = price;
        Quantity = quantity;
    }
    /**
     Constructs a new Item object as a copy of the given Item object.
     @param other the Item object to copy
     */
    public Item(Item other){
        Name = other.Name;
        Category = other.Category;
        Brand = other.Brand;
        UnitType = other.UnitType;
        Status = other.Status;
        Description = other.Description;
        Price = other.Price;
        Quantity = other.Quantity;
    }
    /**
     Prints the details of the item, including its category, name, brand, unit type, description, quantity, price, and status.
     @param total whether to print the total price (price * quantity) or just the price
     */
    public void View(boolean total) {

        //view item details

        System.out.printf("%-25s", Category);
        System.out.printf("%-25s", Name);
        System.out.printf("%-25s", Brand);
        System.out.printf("%-25s", UnitType);
        System.out.printf("%-25s", Description);
        System.out.printf("%-20s", Quantity);
        if(!total)
            System.out.printf("%-20s", Price + " $");
        else
            System.out.printf("%-20s", Price * Quantity + " $");
        System.out.print(Status);

    }
    /**
     Returns the name of the item.
     @return the name of the item
     */
    public String GetName() {
        return Name;
    }
    /**
     Returns the category of the item.
     @return the category of the item
     */
    public String GetCategory(){
        return Category;
    }
    /**
     Returns the brand of the item.
     @return the brand of the item
     */
    public String GetBrand(){
        return Brand;
    }
    /**
     Returns the unit type of the item.
     @return the unit type of the item
     */
    public String GetUnitType(){
        return UnitType;
    }
    /**
     Returns the status of the item.
     @return the status of the item
     */
    public String GetStatus(){
        return Status;
    }
    /**
     Returns the description of the item.
     @return the description of the item
     */
    public String GetDescription(){
        return Description;
    }
    /**
     Returns the price of the item.
     @return the price of the item
     */
    public Float GetPrice(){
        return Price;
    }
    /**
     Returns the quantity of the item.
     @return the quantity of the item
     */
    public int GetQuantity(){
        return Quantity;
    }
    /**
     Sets the name of the item.
     @param name the name of the item
     */
    public void SetName(String name) {
        Name = name;
    }
    /**
     Sets the category of the item.
     @param category the category of the item
     */
    public void SetCategory(String category) {
        Category = category;
    }
    /**
     Sets the brand of the item.
     @param brand the brand of the item
     */
    public void SetBrand(String brand) {
        Brand = brand;
    }
    /**
     Sets the unit type of the item.
     @param unitType the unit type of the item
     */
    public void SetUnitType(String unitType) {
        UnitType = unitType;
    }
    /**
     Sets the status of the item.
     @param status the status of the item
     */
    public void SetStatus(String status) {
        Status = status;
    }
    /**
     Sets the description of the item.
     @param description the description of the item
     */
    public void SetDescription(String description) {
        Description = description;
    }
    /**
     Sets the price of the item.
     @param price the price of the item
     */
    public void SetPrice(Float price) {
        Price = price;
    }
    /**
     Sets the quantity of the item.
     @param quantity the quantity of the item
     */
    public void SetQuantity(int quantity) {
        Quantity = quantity;
    }
}
