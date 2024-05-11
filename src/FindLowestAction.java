import java.util.ArrayList;
class FindLowestAction extends Action {

    private String item;
    public FindLowestAction(String item) {
        this.item = item;
    }

    String execute() {
       double lowest = 50;

       Item l = null;
       Store theStore = null;

      String retVal = "";
        
     StoreManager theManager = Background.instance().getManager();
     ArrayList<Store> theStores = theManager.getStores();

    for (int i=0; i <theStores.size(); i++) {
       ArrayList<Item> temp = theStores.get(i).getItems();
       for (int j=0; j<temp.size(); j++) {
          if (temp.get(j).getName().equals(item)) {
           // double price = temp.get(j).getPrice();
           // System.out.println(price);

            if (temp.get(j).getPrice() < lowest) {
                lowest = temp.get(j).getPrice();
                //System.out.println(lowest);
                l = temp.get(j);
                theStore = theStores.get(i);
            }  
       } 
    }             
       temp = new ArrayList<Item>();
    }

    retVal += "\n" + "LOWEST $ FOR: " + item  + "\n" + "-----------" + "\n" +
        "LOCATION: " + theStore.getName() + "\n" + "PRICE: $" + l.getPrice() + "\n"; 
    return retVal; 
    }


}
