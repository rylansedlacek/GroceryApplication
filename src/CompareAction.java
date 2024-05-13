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
      String retVal = " ";
        
     StoreManager theManager = Background.instance().getManager();
     ArrayList<Store> theStores = theManager.getStores();

     Store Store1 = theManager.getStoreNamed(store1);
     Store Store2 = theManager.getStoreNamed(store2);

     if (Store1 == null || Store2 == null) {
         return "Invalid store(s) provided.";
     }

     double storeOneTotal = 0.0;
     double storeTwoTotal = 0.0;

     ArrayList<Item> storeOneItems = Store1.getItems();
     ArrayList<Item> storeTwoItems = Store2.getItems();

     for (int i=0; i<storeOneItems.size(); ++i) {
         storeOneTotal += storeOneItems.get(i).getPrice();
     }

     for (int i=0; i<storeTwoItems.size(); ++i) {
         storeTwoTotal += storeOneItems.get(i).getPrice();
     }

     if (storeOneTotal > storeTwoTotal) { 
        System.out.println(); //finish tm
     } // else if blah blah



    return retVal;
}
}
