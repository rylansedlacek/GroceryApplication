class InventoryAction extends Action {

    private String storeName;

    public InventoryAction (String storeName) {
        this.storeName = storeName;
    }


    //TODO MIGRATE THIS FROM STOREMANAGER to THIS CLASS
    String execute() {
       StoreManager theManager = Background.instance().getManager();
       String retVal = theManager.getEntireStore(storeName);
       return retVal;
    }

}
