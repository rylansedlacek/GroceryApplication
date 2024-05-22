import java.util.Hashtable;
import java.util.ArrayList;
class Background {

    private StoreManager theManager;
    private static Background theInstance;
    private Hashtable<Store,Item> userCart;
    private ArrayList<Item> itemCart;
    private Store currentStore;

    public Background() {
        this.theInstance = theInstance;
        this.theManager = theManager;
        this.userCart = new Hashtable<Store,Item>();
        this.itemCart = new ArrayList<Item>();
        this.currentStore = null;
    }

    public static synchronized Background instance() {
        if (theInstance == null) {
            theInstance = new Background();
        }
        return theInstance;
    }

    public void create(StoreManager m) {
        this.theManager = m;
    }

    public StoreManager getManager() {
        return this.theManager;
    }

    public void addToCart(Store currStore, Item item) {
        this.userCart.put(currStore,item);
    }

    public void addToItem(Item item) {
        this.itemCart.add(item);
    }

    public Hashtable getFullCart() {
        return this.userCart;
    }

    public ArrayList getItemCart() {
        return this.itemCart;
    }

    public void setCurrentStore(Store s) {
        this.currentStore = s;
    }

    public String getCurrentStoreName() {
        if (this.currentStore == null) {
            return "NONE";
        } else {
            return this.currentStore.getName();
        }
    }

} //end file

