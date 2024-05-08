import java.util.ArrayList;
class SearchAction extends Action {

    private String itemName;

    public SearchAction(String tmp) {
        this.itemName = tmp;
    }

    String execute() {
     ArrayList steve = Background.instance().getManager().getStores();

     if (steve == null) {
         System.out.println("Im sad");
     }
     String ret = " ";

    for (int i=0; i <steve.size(); i++) {
        
        Item a = steve.get(i).getjustItems().getItemNamed(itemName);

        if (a!= null) {
            ret += "worked";
        }
    }
    return ret;

     }    

 }







