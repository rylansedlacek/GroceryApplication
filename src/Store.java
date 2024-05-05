import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

class Store {

    private String name;
    private String location;

    private ArrayList<Item> justItems;
    private Hashtable<Item, Integer> ItemStock;
    private Hashtable<Item, Double> ItemPrice;

    public Store(Scanner s) throws NoStoreException {
        this.justItems = new ArrayList<Item>();
        this.ItemStock = new Hashtable<Item, Integer>();
        this.ItemPrice = new Hashtable<Item, Double>();

        s.nextLine(); // read past ===
        this.name = s.nextLine();
        if (name.equals("***")) {
            throw new NoStoreException();
        }
        this.location = s.nextLine();
        s.nextLine(); // throw away ---

        try {
            while(true) {
                Item i = new Item(s);
                this.justItems.add(i);
                this.ItemStock.put(i, i.getStock());
                this.ItemPrice.put(i, i.getPrice());
            }
        } catch (NoItemException e) {
        }
    }


    public ArrayList getItems() {
        return this.justItems;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    public int getStock(Item i) {
        if (this.ItemStock.containsKey(i)) {
            int tmp = this.ItemStock.get(i);
            return tmp;
        } else {
            return 0;
        }
    }

    public String getPrice(Item i) {
        if (this.ItemPrice.containsKey(i)) {
            double tmp = this.ItemPrice.get(i);
            String ret = Double.toString(tmp);
            return ret;
        } else {
            return "This store does not have " + i.getName() + ".";
        }
    }

}
