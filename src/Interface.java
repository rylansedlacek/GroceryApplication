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
        System.out.println("Grocery Application:");
        System.out.println("1 - search item");
        System.out.println("2 - compare stores");
        System.out.println("3 - view store inventory");
        System.out.println("4 - find lowest price");
        /*
        System.out.println("5 - add to cart");
        System.out.println("6 - view cart");
        */
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
            System.out.println("Enter: |Store1| |Store2|");
            System.out.print("> ");
            /*
            String item = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("COMPARE" + item);
            System.out.println(theAction.execute());
            */
        } else if (input.equals("3")) {
            System.out.println();
            System.out.println("Enter store name:");
            System.out.print("> ");
            String store = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("INVEN" + store);
            System.out.println(theAction.execute());
        } else if (input.equals("4")) {
            System.out.println();
            System.out.println("Enter item name:");
            System.out.print("> ");
            String item = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("FINDLOW" + item);
            System.out.println(theAction.execute());
        }else if (input.equals("0")) {
           complete = true;
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
