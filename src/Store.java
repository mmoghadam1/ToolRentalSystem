import java.util.*;

public class Store {
    private List<Tool> inventory = new ArrayList<>();
    private List<Rental> currentRentals = new ArrayList<>();
    private List<Rental> completedRentals = new ArrayList<>();
    private int revenue;

    public int getRevenue(){return revenue; }
    public void setInventory(List<Tool> i) {
        this.inventory = i;
    }
    public List<Tool> showInventory() {
        return inventory;
    }
    public List<Rental> showRentals() { return currentRentals; }
    public List<Rental> getCompletedRentals(){return completedRentals; }
    public void ret(Rental r){
        List<Tool> tools = r.getTools();
        for(Tool t:tools){
            updateInventory(t, true);
        }
        updateCurRentals(r, true);
        r.getCustomer().removeRental(r);
    }
    private List<Tool> getTools(int tool){
        List<Tool> sub = new ArrayList<>(inventory);
        Collections.shuffle(sub);
        List<Tool> tools = new ArrayList<>();
        for(int i=0; i<tool; i++){
            if (inventory.size() != 0){
                tools.add(sub.get(i));
                updateInventory(tools.get(i), false);
            }
        }
        return tools;
    }
    private int calculatePrice(List<Tool> tools, int day){
        int price = 0;
        for(Tool t:tools) {
            price = t.getPrice()+price;
        }
        price = price*day;
        return price;
    }
    private void updateCurRentals(Rental r, boolean returnItem) {
        if (returnItem){
            currentRentals.remove(r);
            completedRentals.add(r);
        }
        else {
            currentRentals.add(r);

        }
    }
    private void updateInventory(Tool t, boolean returnItem) {
        if(returnItem){
            inventory = new ArrayList<>(inventory);
            inventory.add(t);
        }
        else {
            inventory = new ArrayList<>(inventory);
            inventory.remove(t);
        }
    }
    private void updateRevenue(int price){
        revenue = revenue+price;
    }

    public void rent(Customer c) {
        int[] daysToRent = c.getDaysToRent(c);
        int[] toolsToRent = c.getToolsToRent(c);

        int day = daysToRent[new Random().nextInt(daysToRent.length)];
        int tool = toolsToRent[new Random().nextInt(toolsToRent.length)];

        List<Rental> rents = c.getRentals();
        if(rents.size()!=0){
            tool = rents.get(0).getDueIn();
            System.out.println(tool);
        }
        List<Tool> tools = getTools(tool);
        int price = calculatePrice(tools, day);
        Rental r = new Rental(c, tools, day, price);
        c.addRental(r);
        updateRevenue(price);
        updateCurRentals(r, false);
    }
}
