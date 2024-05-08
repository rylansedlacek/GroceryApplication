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

       if (action.startsWith("SEARCH")) {
          String tmp = action.substring("SEARCH".length());
          Action a = new SearchAction(tmp);
          return a;
       } else {
          return;
       } 




    }



}
