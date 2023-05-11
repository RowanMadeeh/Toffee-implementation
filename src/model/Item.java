package model;

public class Item {
    private String Name;
    private String Category;
    private String Brand;
    private String UnitType;
    private String Status;
    private String Description;
    private Float Price;
    private int Quantity;

    public Item(){

    }

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

    public String GetName() {
        return Name;
    }

    public String GetCategory(){
        return Category;
    }

    public String GetBrand(){
        return Brand;
    }

    public String GetUnitType(){
        return UnitType;
    }

    public String GetStatus(){
        return Status;
    }

    public String GetDescription(){
        return Description;
    }

    public Float GetPrice(){
        return Price;
    }

    public int GetQuantity(){
        return Quantity;
    }


    public void SetName(String name) {
        Name = name;
    }

    public void SetCategory(String category) {
        Category = category;
    }

    public void SetBrand(String brand) {
        Brand = brand;
    }

    public void SetUnitType(String unitType) {
        UnitType = unitType;
    }

    public void SetStatus(String status) {
        Status = status;
    }

    public void SetDescription(String description) {
        Description = description;
    }

    public void SetPrice(Float price) {
        Price = price;
    }

    public void SetQuantity(int quantity) {
        Quantity = quantity;
    }
}
