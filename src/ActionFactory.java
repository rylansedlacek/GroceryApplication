class ActionFactory {


    private static ActionFactory theInstance;

    public static synchronized ActionFactory instance() {
        if (theInstance == null) {
            theInstance = new ActionFactory();
        }
        return theInstance;
    }

    private ActionFactory() {
        this.theInstance = theInstance;
    }

    Action doAction(String action) {
        Action a = null;
       if (action.startsWith("SEARCH")) {
          String tmp = action.substring("SEARCH".length());
          a = new SearchAction(tmp);
          return a;
       } else if (action.startsWith("COMPARE")) {
          String unsplit = action.substring("COMPARE".length());
          String[] split = unsplit.split(" ");
            if (split.length <= 1) {
                a = new BogusAction();
                return a;
            }
          a = new CompareAction(split[0], split[1]);
          return a;
       } else if (action.startsWith("FINDLOW")) {
           String h = action.substring("FINDLOW".length());
           a = new FindLowestAction(h);
           return a;
       } else if (action.startsWith("INVEN")) {
          String storeName = action.substring("INVEN".length());
          a = new InventoryAction(storeName);
          return a;
       } else if (action.equals("STORECART")) {
           a = new StoreCartAction();
           return a;
       }else if (action.startsWith("STORE")) {
          String theStore = action.substring("STORE".length());
          a = new SetStoreAction(theStore);
          return a; 
       } else if (action.startsWith("ADD")) {
         String unsplit2 = action.substring("ADD".length());  
         String[] splitter = unsplit2.split(" ");
            if (splitter.length <= 1) {
                a = new BogusAction();
                return a;
            }
        String purItem = splitter[0];
    /*
        if (splitter[1] instanceof String) {
            a = new BogusAction();
            return a;
        }
    */    
        int purQuant = Integer.parseInt(splitter[1]);
        a = new AddCartAction(purItem,purQuant);
        return a;
       } else if (action.equals("FULLCART")) {
            a = new FullCartAction();
            return a;
       } else {
          Action bogus = new BogusAction();
          return bogus;
       } 
    }
}
