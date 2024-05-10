import java.util.ArrayList;
class CompareAction extends Action {

    private String item;

    public CompareAction(String item) {
        this.item = item;
    }

    String execute() {
       String theHighest = "";
       String theLowest = "";
       double highest = Double.MAX_VALUE;
       double lowest = Double.MIN_VALUE;

       Item h = null;
       Item l = null;

      String retVal = "";
        
     StoreManager theManager = Background.instance().getManager();
     ArrayList<Store> theStores = theManager.getStores();

    for (int i=0; i <theStores.size(); i++) {
       ArrayList<Item> temp = theStores.get(i).getItems();
       for (int j=0; j<temp.size(); j++) {
          if (temp.get(j).getName().equals(item)) {
            double price = temp.get(j).getPrice();

            if (price > highest) {
               highest = price;
               h = temp.get(j);
            }

            if (price < lowest) {
               lowest = price;
               l = temp.get(j);
            } 
          }
          
       } 

         for (int k=0; k<temp.size(); k++) {
            if (temp.get(k) == h) {
                retVal += "\n" + temp.get(k).getName() + "\n" +
                    "HIGHEST PRICE: " + temp.get(k).getPrice() + "\n";
            } else if (temp.get(k) == l) {
                retVal += "\n" + temp.get(k).getName() + "\n" + 
                    "LOWEST PRICE: " + temp.get(k).getPrice() + "\n";
            } else {
                if (temp.get(k).getName().equals(item)) {
                    retVal += "\n" + temp.get(k).getName() + "\n";
                }
            }
        }    

         
          
       temp = new ArrayList<Item>();
    }
    

   

    return retVal;
}
}
