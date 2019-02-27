public class RegularCust extends Customer {
    private int[] daysToRent = {3,4,5};
    private int[] toolsToRent = {1,2,3};

    public int[] getDaysToRent(Customer c){
        return daysToRent;
    }
    public int[] getToolsToRent(Customer c){
        return toolsToRent;
    }
}
