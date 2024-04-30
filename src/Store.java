import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
class Store {

    private String name;
    private String location;
    private ArrayList<Item> items;
    private Hashtable<String, Integer> inven;

    public Store (String filename) {
        this.name = "tmp";
        this.location = "tmp";
        this.items = new ArrayList<Item>();
        this.inven = new Hashtable<String, Integer>();
    }

}
