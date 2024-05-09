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
          String r = action.substring("COMPARE".length());
          String Items[] = r.split(" ");

          if (Items.length != 2) {
              Action nope = new BogusAction();
              return nope;
          }

          a = new CompareAction(Items[0], Items[1]);
          return a;
       } else {
          Action bogus = new BogusAction();
          return bogus;
       } 
    }



}
