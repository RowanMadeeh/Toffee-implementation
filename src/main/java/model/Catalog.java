package model;

import java.util.Vector;

/**

 The Catalog class represents a catalog of items.
 */
public class Catalog {
    private Vector<Item> CatalogItems = new Vector<>();

    public Vector<Item> GetCatalogItems(){
        return CatalogItems;
    }

    /**
     Checks if an item exists in the catalog.
     @param Name the name of the item to check.
     @return true if the item exists in the catalog, false otherwise.
     */
    public boolean CheckItem(String Name){
        //
        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(Name)){
                return true;
            }
        }
        return false;
    }

    /**
     Checks if an item exists in the catalog with the specified quantity available.
     @param Name the name of the item to check.
     @param Quantity the quantity of the item to check.
     @return true if the item exists in the catalog with the specified quantity available, false otherwise.
     */
    public boolean CheckItem(String Name, int Quantity){
        //

        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(Name)){
                return CatalogItems.get(i).GetQuantity() >= Quantity;
            }
        }

        return false;
    }

    /**
     Returns the item with the specified name.
     @param Name the name of the item to get.
     @return the item with the specified name, or a new Item object if the item is not found.
     */
    public Item GetItem(String Name){
        //

        for (int i = 0; i < CatalogItems.size(); i++) {
            if(CatalogItems.get(i).GetName().equals(Name)){
                return CatalogItems.get(i);
            }
        }

        return new Item();
    }

    /**
     Displays the items in the catalog.
     */
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

    /**
     Adds an item to the catalog.
     @param item the item to add
     */

    public void AddItem(Item item){
        //
        CatalogItems.add(item);
    }

    /**
     Removes the specified quantity of an item from the catalog and updates its quantity and status accordingly.
     @param name the name of the item to remove
     @param Quantity the quantity to remove
     */
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
}
