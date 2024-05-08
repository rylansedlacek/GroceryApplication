class Background {

    private StoreManager theManager;
    private static Background theInstance;

    public Background() {
        this.theInstance = theInstance;
        this.theManager = theManager;
    }

    public static synchronized Background instance() {
        if (theInstance == null) {
            theInstance = new Background();
        }
        return theInstance;
    }

    public void create(StoreManager m) {
        this.theManager = m;
    }

    public StoreManager getManager() {
        return this.theManager;
    }



}
