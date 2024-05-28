import java.util.ArrayList;
class SearchAction extends Action {

    private String itemName;

    public SearchAction(String tmp) {
        this.itemName = tmp;
    }

    String execute() {
     StoreManager theManager = Background.instance().getManager();
     ArrayList<Store> theStores = theManager.getStores();
     String ret = "";

    for (int i=0; i <theStores.size(); i++) {
       ArrayList<Item> temp = theStores.get(i).getItems();
       for (int j=0; j<temp.size(); j++) {
          if (temp.get(j).getName().equals(this.itemName)) {
             ret += 
                 "\n" +"Location: " + theStores.get(i).getName() + "\n" +
                    "NAME: " +  temp.get(j).getName() + "\n" + "PRICE: $" + temp.get(j).getPrice() + 
                    "\n" + "QUANTITY: " + temp.get(j).getStock() + "\n";
          }
       }
       temp = new ArrayList<Item>();
    }
         return ret;

     }    

 }







