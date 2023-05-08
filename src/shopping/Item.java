package shopping;

public class Item {
    private String Name;
    private String Category;
    private String Brand;
    private String UnitType;
    private String Status;
    private String Description;
    private Float Price;
    private int Quantity;

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
    public void SetName(String name){
        Name = name;
    }
    public void SetCategory(String category){
        Category = category;
    }
    public void SetBrand(String brand){
        Brand = brand;
    }
    public void SetUnitType(String unitType){
        UnitType = unitType;
    }
    public void setStatus(String status){
        Status = status;
    }
    public void setDescription(String description){
        Description = description;
    }
    public void setPrice(Float price){
        Price = price;
    }
    public void setQuantity(int quantity){
        Quantity = quantity;
    }
}
