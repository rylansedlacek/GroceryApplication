import java.util.ArrayList;
import java.util.Hashtable;
class StoreCartAction extends Action {


   // public class StoreCartAction() { }

    String execute() {
        String retVal = "";
        StoreManager theManager = Background.instance().getManager();
        Store theStore = theManager.getStoreNamed(Background.instance().getCurrentStoreName());

        if (theStore == null) {
            return "Invalid Operation: No Store Selected";
        }

        retVal += "\n" + "CART FOR STORE: " + Background.instance().getCurrentStoreName() + "\n";

        Hashtable<Store,Item> userCart = Background.instance().getFullCart();
        Hashtable<Item,Integer> userQuant = Background.instance().getItemQuantCart();


        //TODO Total rewrite of this mess on friday please 5/24
        Item theItem = null;
        int theQuant = 0;
        for (int i=0; i<userCart.size(); i++) {
            theItem = userCart.get(theStore);
            if (theItem == null) {
                retVal += "";
            } else {
                for (int j=0; j<userQuant.size(); j++) {
                    theQuant = userQuant.get(theItem);
                    if (theQuant == 0) {
                       retVal += "";
                    } else {
                       retVal += "\n" + theItem.getName() + "\n" + theQuant + "\n";
                       theQuant = 0;
                    }
                } 
            }
        }

        return retVal;
    }


}
