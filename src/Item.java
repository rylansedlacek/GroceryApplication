import java.util.Scanner;

class Item {

    private String name;
    private int stock;
    private double price;

    public Item(Scanner s) throws NoItemException {
        
        String test = s.nextLine();
        //System.out.println(test);
        if (test.equals("===")) {
            throw new NoItemException();
        }
        this.name = test;

        String st = s.nextLine();
        //System.out.println(st);
        this.stock = Integer.parseInt(st);

        String pr = s.nextLine();
        //System.out.println(pr);
        this.price = Double.parseDouble(pr);
        s.nextLine();
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

    public double getPrice() {
        return this.price;
    }

}
