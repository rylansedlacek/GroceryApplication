class ActionFactory {


    private static ActionFactory theInstance;

    private static synchronized ActionFactory instance() {
        if (theInstance == null) {
            theInstance = new ActionFactory();
        }
        return theInstance;
    }

    private ActionFactory() {
        this.theInstance = theInstance;
    }

    Action doAction(String action) {




    }



}
