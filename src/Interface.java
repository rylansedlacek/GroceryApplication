import java.util.Scanner;

public class Interface {

    public static void main (String args[]) {
       
        if (args.length == 0) {
            System.out.println("Usage: Interface storeName.store");
            System.exit(1);
        }

       String filename = args[0];
       Store s = new Store(filename);

       Scanner stdin = new Scanner(System.in);
       boolean complete = false;
       //TODO
       // System.out.println(s.getStores()); (for store names)

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
