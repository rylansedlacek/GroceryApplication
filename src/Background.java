import java.util.Hashtable;
import java.util.ArrayList;
class Background {

    private StoreManager theManager;
    private static Background theInstance;
    private Hashtable<Store,Item> userCart;
    private Hashtable<Item,Integer> itemQuantCart;
    private Hashtable<Store,ArrayList<Item>> fullCart;
    private Store currentStore;
    private boolean storeCheck;

    public Background() {
        this.theInstance = theInstance;
        this.theManager = theManager;
        this.userCart = new Hashtable<Store,Item>();
        this.itemQuantCart = new Hashtable<Item,Integer>();
        this.fullCart = new Hashtable<Store,ArrayList<Item>>();
        this.currentStore = null;
        this.storeCheck = false;
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
        System.out.println("added item");
    }

    public void addToItemQuant(Item item, int quant) { //refrence this to get quanity
        this.itemQuantCart.put(item,quant);
    }

    public void addToFullCart(Store current, Item item) {
        ArrayList<Item> test = this.fullCart.get(current);

        if (test == null || test.isEmpty()) {
            ArrayList<Item> nueve = new ArrayList<Item>();
            nueve.add(item);
            this.fullCart.put(current, nueve);
        } else {
            test.add(item);
        }
    }

    public ArrayList getMainCart(Store s) {
        return this.fullCart.get(s);
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

    public boolean storeCheck() {
        if (this.currentStore == null) {
            return false;
        } else {
            return true;
        }
    }

} //end file

