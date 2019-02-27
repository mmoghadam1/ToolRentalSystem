public class CasualCust extends Customer {
    private int[] daysToRent = {1,2};
    private int[] toolsToRent = {1,2};

    public int[] getDaysToRent(Customer c){
        return daysToRent;
    }
    public int[] getToolsToRent(Customer c){
        return toolsToRent;
    }
}
