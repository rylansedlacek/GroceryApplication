class CompareAction extends Action {

    private String itemOne;
    private String itemTwo;

    public CompareAction(String itemOne, String itemTwo) {
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
    }

    String execute() {
        //two different for loops comparing
       return "COMPARE in progress"; 
    }



}
