import java.util.ArrayList;
import java.util.Hashtable;

class FullCartAction extends Action {
    

    String execute() {
        String retVal = "";
        
        ArrayList<Store> visitedStores = Background.instance().getVisitedStores();
        Hashtable<Item, Integer> quant = Background.instance().getItemQuantCart();

        if (visitedStores == null || visitedStores.isEmpty()) {
            return "|YOU HAVE AN EMPTY CART|" + "\n";
        }

       for (int i=0; i<visitedStores.size(); i++) {
          Store tmp = visitedStores.get(i);
          ArrayList<Item> tmpItems = Background.instance().getMainCart(tmp);
          
          
          if (tmpItems == null || tmpItems.isEmpty()) {
              break;
            //  return "|YOU HAVE AN EMPTY CART|" + "\n";
          }
            
          retVal += "\n" + tmp.getName() + "\n";
          retVal += "-----------------------" + "\n";
             for (int j=0; j<tmpItems.size(); j++) {
                retVal +=  "NAME: " + tmpItems.get(j).getName() + "\n";
                retVal += "QUANTITY: " + quant.get(tmpItems.get(j)) + "\n";
                retVal += "\n";
             }
            tmp = null;
            tmpItems = new ArrayList<Item>();
       }
                
       return retVal;

    }

}
