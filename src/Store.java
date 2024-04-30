import java.util.Scanner;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.FileReader;
class Store {

    private String name;
    private String location;
    private ArrayList<Item> items;
    private Hashtable<String, Double> inven;

    public Store (String filename) {
        this.name = "";
        this.location = "";
        this.items = new ArrayList<Item>();
        this.inven = new Hashtable<String, Integer>();

        Scanner s = new Scanner(new FileReader(filename);
        this.name = s.nextLine();
        this.location = s.nextLine();

        try  {
            while (true) {
            Item i = new Item(s);
            Store.addItem(i);
            Store.addInven(i.getName,i.getPrice);
            }
        } catch (NoItemException e) {
        }

    }

}
