import java.util.Hashtable;
import java.util.ArrayList;
class Background {

    private StoreManager theManager;
    private static Background theInstance;
    private Hashtable<Store,Item> userCart;
    private Hashtable<Item,Integer> itemQuantCart;
    private Store currentStore;

    public Background() {
        this.theInstance = theInstance;
        this.theManager = theManager;
        this.userCart = new Hashtable<Store,Item>();
        this.itemQuantCart = new Hashtable<Item,Integer>();
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

    public void addToStoreCart(Store currStore, Item item) { //refrence this for getting store for item in cart
        this.userCart.put(currStore,item);
    }

    public void addToItemQuant(Item item, int quant) { //refrence this to get quanity
        this.itemQuantCart.put(item,quant);
    }

    public Hashtable getFullCart() {
        return this.userCart;
    }

    public Hashtable getItemQuantCart() {
        return this.itemQuantCart;
    }

    public Store getCurrentStore() {
        return this.currentStore;
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

