import java.util.Scanner;
import java.io.FileNotFoundException;

public class Interface {

    public static void main (String args[]) {
       
        if (args.length == 0) {
            System.out.println("Usage: Interface storeName.store");
            System.exit(1);
        }

        if (!args[0].endsWith(".store")) {
            System.out.println("Must end with .store");
            System.exit(1);
        }

       String filename = args[0];

       try {
       StoreManager sm = new StoreManager(filename);
       

       Scanner stdin = new Scanner(System.in);
       boolean complete = false;
       Action theAction = null;
       

       while(!complete) {
        System.out.println("|Grocery Application|");
        System.out.println("|Current Store: " + Background.instance().getCurrentStoreName() + "|");
        System.out.println();
        System.out.println("# - set store");
        System.out.println("1 - search item");
        System.out.println("2 - compare stores");
        System.out.println("3 - view store inventory");
        System.out.println("4 - find lowest price"); 
        System.out.println("5 - add to cart");
        System.out.println("6 - view store cart");
        System.out.println("7 - view full cart");
        System.out.println("0 - exit");
        System.out.print("enter number > ");
        String input = stdin.nextLine();
    
     

        if (input.equals("1")) {
           System.out.println();
           System.out.println("Enter item name");
           System.out.print("> ");
           String name = stdin.nextLine();
           theAction = ActionFactory.instance().doAction("SEARCH" + name);
           System.out.println(theAction.execute());

        } else if (input.equals("2")) {
            System.out.println();
            String stores = "";
            if (!Background.instance().storeCheck()) {
            System.out.println("Enter: |Store1| |Store2|");
            System.out.print("> ");
            stores = stdin.nextLine();
            } else {
            System.out.println("Current Store: " + Background.instance().getCurrentStoreName());
            System.out.println("Enter: |Store2Compare|");
            System.out.print("> ");
            stores = stdin.nextLine();
            stores += " ";
            stores += Background.instance().getCurrentStoreName();
            }
            theAction = ActionFactory.instance().doAction("COMPARE" + stores);
            System.out.println(theAction.execute());
        } else if (input.equals("3")) {
            System.out.println();
            String store = "";
            if (!Background.instance().storeCheck()) {
            System.out.println("Enter store name:");
            System.out.print("> ");
            store = stdin.nextLine();
            } else {
                store = Background.instance().getCurrentStoreName();
            }
            theAction = ActionFactory.instance().doAction("INVEN" + store);
            System.out.println(theAction.execute());
        } else if (input.equals("4")) {
            System.out.println();
            System.out.println("Enter item name:");
            System.out.print("> ");
            String item = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("FINDLOW" + item);
            System.out.println(theAction.execute());
        }else if (input.equals("0") || input.equals("clear")) { // TODO remove after dev
           complete = true;
        } else if (input.equals("#")) { //TODO move this to top for read.
            System.out.println();
            System.out.println("Enter name of Store (Or NONE):");
            System.out.print("> ");
            String store = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("STORE" + store);
            System.out.println(theAction.execute());
        } else if (input.equals("5")) {
            System.out.println();
            System.out.println("Enter: |ITEM| |QUANTITY|");
            System.out.print("> ");
            String purchase = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("ADD" + purchase);
            System.out.println(theAction.execute());
        } else if (input.equals("6")) {
            System.out.println();
            String storeCart = "STORECART";
            theAction = ActionFactory.instance().doAction("STORECART");
            System.out.println(theAction.execute());
        } else if (input.equals("7")) {
            System.out.println();
            String fullCart = "FULLCART";
            theAction = ActionFactory.instance().doAction(fullCart);
            System.out.println(theAction.execute());
        } else {
            System.out.println();
            System.out.println("Invalid input, try again.");
            System.out.println();
        }
       } // end loop

       } catch (FileNotFoundException | IllegalFileException e) {
           e.printStackTrace();
       } 
       


    } // end main
} // end class
