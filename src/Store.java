import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

class Store {

    private String name;
    private String location;
    private int invenSize;

    private ArrayList<Item> justItems;
    private Hashtable<Item, Integer> ItemStock;
    private Hashtable<Item, Double> ItemPrice;

    public Store(Scanner s) throws NoStoreException {
        this.justItems = new ArrayList<Item>();
        this.ItemStock = new Hashtable<Item, Integer>();
        this.ItemPrice = new Hashtable<Item, Double>();

        String t = s.nextLine();
        if (t.equals("***")) {
            throw new NoStoreException();
        }

        this.name = s.nextLine();
      //  System.out.println(name);
        this.location = s.nextLine();
       // System.out.println(location);
        int size = Integer.parseInt(s.nextLine());
       // System.out.println(size);
        this.invenSize = size;

        s.nextLine(); // throw away ---
        int count = 0;
        try {
            //System.out.println(invenSize);
            while(count < invenSize) {
                Item i = new Item(s);
                this.justItems.add(i);
                this.ItemStock.put(i, i.getStock());
                this.ItemPrice.put(i, i.getPrice());
                count++;
               // s.nextLine();
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


}
