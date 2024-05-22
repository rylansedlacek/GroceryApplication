import java.util.Hashtable;
import java.util.ArrayList;

class AddCartAction extends Action {

    private Store currentStore;
    private Item theItem;

    public AddCartAction(Store curr, Item item) {

        this.currentStore = curr;
        this.theItem = item;

    }


    String execute() {

        String retVal = "";
        Hashtable<Store, Item> currentCart = Background.instance().getFullCart();
        

        //TODO : ADD A STOCK DECREMENTQ


        //if DUPLICATE, check stock
        //add if able

        //basic easy stuff


        return "AddCART IN PROGRESS";
    }



}
