import java.util.ArrayList;
import java.util.Hashtable;
class StoreCartAction extends Action {


   // public class StoreCartAction() { }

    String execute() {
        String retVal = "";
        StoreManager theManager = Background.instance().getManager();
        Store theStore = theManager.getStoreNamed(Background.instance().getCurrentStoreName());

        if (theStore == null) {
            return "Invalid Operation: No Store Selected" + "\n";
        }

        retVal += "\n" + "CART FOR STORE: " + Background.instance().getCurrentStoreName() + "\n";
        retVal += "--------------------------" + "\n";

      //  Hashtable<Store,Item> userCart = Background.instance().getFullCart();
        Hashtable<Item,Integer> userQuant = Background.instance().getItemQuantCart();
        Hashtable<Store, ArrayList<Item>> allCart = Background.instance().getTestCart();

        Item theItem = null;
        int theQuant = 0;

        if (allCart == null || allCart.isEmpty()) {
            retVal += "|YOU HAVE AN EMPTY CART|" + "\n";
            return retVal;
        }

        ArrayList<Item> allItems = Background.instance().getMainCart(theStore);

        if (allItems == null) {
            return "|YOU HAVE AN EMPTY CART|" + "\n";
        }

        for (int i=0; i<allItems.size(); ++i) {
            retVal += "\n" + "NAME: " +  allItems.get(i).getName() + "\n";
            retVal += "QUANTITY: " + userQuant.get(allItems.get(i)) + "\n";
        }

         return retVal;
    }


}
