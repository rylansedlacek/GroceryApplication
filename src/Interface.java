import java.util.Scanner;

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
      //TODO
      // StoreManager sm = new StoreManager(filename);

       Scanner stdin = new Scanner(System.in);
       boolean complete = false;

       while (!complete) {
           System.out.println("For help type, \"help\"");
           String input = stdin.nextLine();
            if (input.equals("exit")) {
                complete = true;
            } else {
                //TODO
                System.out.println();
                //Action a = ActionFactory.instance().parse(input);
                //System.out.println(a.execute());
            }
       } 
    } // end main
} // end class
