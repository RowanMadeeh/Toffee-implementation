package model;

import java.util.Vector;

public class Catalog {
    private Vector<Item> CatalogItems = new Vector<>();

    public Vector<Item> GetCatalogItems(){
        return CatalogItems;
    }

    public boolean CheckItem(String Name){
        //
        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(Name)){
                return true;
            }
        }
        return false;
    }

    public boolean CheckItem(String Name, int Quantity){
        //

        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(Name)){
                return CatalogItems.get(i).GetQuantity() >= Quantity;
            }
        }

        return false;
    }

    public Item GetItem(String Name){
        //

        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(Name)){
                return CatalogItems.get(i);
            }
        }

        return new Item();
    }

    public void View(){

        //view items in catalog

        System.out.printf("     %-25s","Category");
        System.out.printf("%-25s","Name");
        System.out.printf("%-25s","Brand");
        System.out.printf("%-25s","UnitType");
        System.out.printf("%-25s","Description");
        System.out.printf("%-20s","Quantity");
        System.out.printf("%-20s","Price");
        System.out.println("Status");

        for (int i = 0; i < CatalogItems.size(); i++) {
            System.out.printf("%-5s", i + 1 + "-");
            CatalogItems.get(i).View(false);
            System.out.println();
        }
        System.out.println();
    }

    public void AddItem(Item item){
        //
        CatalogItems.add(item);
    }

    public void RemoveItem(String name, int Quantity){
        //
        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(name)){
                int CurrentQuantity = CatalogItems.get(i).GetQuantity();
                int NewQuantity = CurrentQuantity - Quantity;
                CatalogItems.get(i).SetQuantity(NewQuantity);
                if(NewQuantity == 0){
                    CatalogItems.get(i).SetStatus("Sold");
                }
                return;
            }
        }
    }

    public void UpdateItem(String name,String detail,String change){
        //
    }


    public void AddDiscount(String name, Float percentage){
        //
    }
}
