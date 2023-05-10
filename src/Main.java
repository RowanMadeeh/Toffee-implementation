import model.Item;
import view.MainSystem;
import view.Viewer;

public class Main {
    public static void main(String[] args) {
        MainSystem.catalog.AddItem(new Item("toffee","sweets","msh 3arf","kelo","Available","gamd gdn", 50F,10));
        MainSystem.catalog.AddItem(new Item("jelly beans","sweets","msh 3arf","gram","Available","gamd gdn", 50F,10));
        MainSystem.catalog.AddItem(new Item("chocolate","sweets","3arf","kelo","Sold","gamd", 40F,0));
        Viewer GUI = new Viewer();
        GUI.GuestView();
    }
}