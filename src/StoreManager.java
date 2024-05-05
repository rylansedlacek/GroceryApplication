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
           System.out.println("caught");
       } 
    }

    public String getStores() {
        String retVal = "";
        for (int i=0; i < stores.size(); i++) {
            retVal += stores.get(i).getName() + "\n" + stores.get(i).getLocation() + "\n";
        }
        return retVal;
    }
            
}
