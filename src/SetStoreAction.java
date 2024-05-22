class SetStoreAction extends Action {

    private String storeName;

    public SetStoreAction(String storeName) {
        this.storeName = storeName;
    }



String execute() {

        
    String retVal = "";
    StoreManager theManager = Background.instance().getManager();

    if (storeName.equals("NONE") || storeName.equals("none")) { //none here
        Store nullStore = null;
        Background.instance().setCurrentStore(nullStore);
        return "\n" + "Set Current Store To: NONE" + "\n";
    }

    Store setTo = theManager.getStoreNamed(storeName);

    if (setTo == null) {
        return "\n" + "No Store Named " + storeName + " In System." + "\n";
    }

    Background.instance().setCurrentStore(setTo);
    retVal += "\n" +  "Set Current Store To: " + storeName + "." + "\n";

    return retVal;
}



} 
