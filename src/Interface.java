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

       while(!complete) {
        System.out.println("Grocery Application:");
        System.out.println("1 - test");
        System.out.println("2 - exit");
        System.out.print("type a number: ");
        String input = stdin.nextLine();

        if (input.equals("1")) {
           // System.out.println(sm.getStoreNames());
             System.out.println(sm.getAStoreAll("Test2"));

        } else if (input.equals("2")) {
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
