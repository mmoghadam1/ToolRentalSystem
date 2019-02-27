public class BusinessCust extends Customer {
    private int[] daysToRent = {7};
    private int[] toolsToRent = {3};

    public int[] getDaysToRent(Customer c){
        return daysToRent;
    }
    public int[] getToolsToRent(Customer c){
        return toolsToRent;
    }
}


