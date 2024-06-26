import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

class StoreManager {

    private ArrayList<Store> stores;
    private String filename;

    public StoreManager(String filename) throws FileNotFoundException, IllegalFileException {
        this.stores = new ArrayList<Store>();
        this.filename = filename;

        Scanner s = new Scanner(new FileReader(filename));
        String version = s.nextLine();
        if (!version.equals("1.0")) {
            throw new IllegalFileException("Wrong Version");
        }
        s.nextLine(); // throw away ***

       try {
          while (true) {

            Store store = new Store(s);
            this.stores.add(store);
          }
       } catch (NoStoreException e) {
       }
      Background.instance().create(this); 
    }

    public Store getStoreNamed(String n) {
        Store theStore = null;
        for (int i=0; i<stores.size(); i++) {
            if (stores.get(i).getName().equals(n)) {
                theStore = stores.get(i);
            } 
        }
        return theStore;
    }


    public ArrayList getStores() {
        return this.stores;
    }

    public String getAllStoreNames() {
        String retVal = "";
        for (int i=0; i < stores.size(); i++) {
            retVal += stores.get(i).getName() + "\n" + stores.get(i).getLocation() + "\n";
        }
        return retVal;
    }

    public String getEntireStore(String name) {
        String retVal = "";
        String theStore = "";
        Store tmp = null;
        boolean hey = true;
        for (int i=0; i < stores.size(); i++) {
            if (stores.get(i).getName().equals(name)) {
                theStore = stores.get(i).getName();
                tmp = stores.get(i);
                 hey = false;
            } 
        }
        
        if (hey) {
            return "No store found.";
        }

        
        retVal +=  "\n" + theStore + "\n" + "-----------" + "\n";
        retVal += "items:" + "\n";
        ArrayList<Item> storeItems = tmp.getItems();

        for (int i=0; i<storeItems.size(); i++) {
            retVal += storeItems.get(i).getName() + "\n";

            double p = storeItems.get(i).getPrice();
            String priceString = Double.toString(p);
            retVal += "price: $" + priceString + "\n";

            int s = storeItems.get(i).getStock();
            String stockString = Integer.toString(s);
            retVal += "stock: " + stockString + "\n";
            retVal += "\n";

        }

        return retVal;
    }
}
