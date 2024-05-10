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
        System.out.println("1 - search");
        System.out.println("2 - compare");
        System.out.println("3 - view store");
        System.out.println("4 - add to cart");
        System.out.println("5 - view cart");
        System.out.println("6 - exit");
        System.out.print("type a number: ");
        String input = stdin.nextLine();

        if (input.equals("1")) {
           System.out.println();
           System.out.print("Enter item name > ");
           String name = stdin.nextLine();
           theAction = ActionFactory.instance().doAction("SEARCH" + name);
           System.out.println(theAction.execute());

        } else if (input.equals("2")) {
            System.out.println();
            System.out.print("Enter item name > ");
            String item = stdin.nextLine();
            theAction = ActionFactory.instance().doAction("COMPARE" + item);
            System.out.println(theAction.execute());
        } else if (input.equals("6")) {
           complete = true;
        } else {
            System.out.println("Invalid input, try again.");
        }
       } // end loop

       } catch (FileNotFoundException | IllegalFileException e) {
           e.printStackTrace();
       } 
       


    } // end main
} // end class
