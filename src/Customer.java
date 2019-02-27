import java.util.ArrayList;
import java.util.List;
public abstract class Customer {
    private String name;
    private int maxTools;
    private List<Rental> rentals = new ArrayList<>();

    Customer(){
        this.maxTools = 3;
    }

    public abstract int[] getToolsToRent(Customer c);
    public abstract int[] getDaysToRent(Customer c);
    public String getName(){
        return name;
    }
    public void setName(String n){
        name=n;
    }
    public boolean canRent(Store store, Customer c)
    {
        List<Rental> rentals = store.showRentals();
        int n = 0;
        if (rentals != null) {
            for (int i = 0; i < rentals.size(); i++) {
                if (rentals.get(i).getName() == c.getName()) {
                    n = n + rentals.get(i).getSize();
                }
            }
        }
        if (n<maxTools){ return true; }
        else { return false; }
    }
    public List<Rental> getRentals(){
        return rentals;
    }
    public void addRental(Rental r){
        this.rentals.add(r);
    }
    public void removeRental(Rental r){
        this.rentals.remove(r);
    }
}

