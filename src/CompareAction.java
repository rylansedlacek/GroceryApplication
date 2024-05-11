import java.util.ArrayList;
class CompareAction extends Action {

    private String store1;
    private String store2;

    public CompareAction(String store1, String store2) {
        this.store1 = store1;
        this.store2 = store2;
    }

    String execute() {
    //TODO
        // two vars one for each stores price
        // whichever bigger make that the MAX, and smaller LOW
      String retVal = "IN PROGESS COMPARE ACTION";
        
     StoreManager theManager = Background.instance().getManager();
     ArrayList<Store> theStores = theManager.getStores();

    return retVal;
}
}
