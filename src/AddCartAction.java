import java.util.Hashtable;
import java.util.ArrayList;

class AddCartAction extends Action {

    private Store currentStore;
    private String itemName;
    private int purchaseQuant;


    public AddCartAction(String itemName, int purchaseQuant) {

        this.itemName = itemName;
        this.purchaseQuant = purchaseQuant;
        this.currentStore = Background.instance().getCurrentStore();

    }


    String execute() {

        String retVal = "";
        Hashtable<Store, Item> currentCart = Background.instance().getFullCart();
        
        Store current = Background.instance().getCurrentStore();

        if (current == null) {
            return  "\n" + "INVALID OPERATION: No Store Selected" + "\n";
        }

        ArrayList<Item> inventory = current.getItems();
        Item theItem = null; 

        for (int i=0; i<inventory.size(); ++i) {
            if (inventory.get(i).getName().equals(itemName)) {
                theItem = inventory.get(i);
            }
        }

        if (theItem == null) {
          return "\n" +  "No Item Named " + itemName + " At Location." + "\n";
        }

        int stock = theItem.getStock();

        if (stock < purchaseQuant) {
            return "\n" + "Not Enough Stock To Fufill Request." + "\n";
        } else {
            theItem.removeStock(purchaseQuant);
        }

       // Background.instance().addToStoreCart(current,theItem); //TODO FUNC nEEDS TO BE REMOVED
        Background.instance().addToFullCart(current, theItem);
        Background.instance().addToItemQuant(theItem,purchaseQuant);

        retVal += "\n" + "Succesfully added: " + purchaseQuant + " " + itemName + "(s)" + " To Store Cart: " + 
           Background.instance().getCurrentStoreName() +  "\n"; 

        return retVal;
    }



}
