import java.util.*;

public class SimClass { // make attributes for objects
    private List<Customer> cList = new ArrayList<>();
    private Store store;
    private List<Tool> tList = new ArrayList<>();
    private List<Customer> customers;

    private void getCustomers(){
        Random random = new Random();

        //Customer[] possibleCustomers = new Customer[n];
        List<Customer> possibleCustomers = new ArrayList<>();
        for (Customer cr : cList) {
            if (cr.canRent(store,cr)) {
                possibleCustomers.add(cr);
            }
        }
        Collections.shuffle(possibleCustomers);
        int n = random.nextInt(possibleCustomers.size());
        customers = new ArrayList<>();       //list of customers for the day
        for (int p = 0; p < n; p++) {
            customers.add(possibleCustomers.get(p));
        }
    }
    private void updateRentals(){
        List<Rental> rentals = store.showRentals();
        Rental[] rents = new Rental[rentals.size()];
        rents = rentals.toArray(rents);
        for (Rental r : rents) {
            r.decrementDueDate();
            if (r.getDueIn() == 0) {
                store.ret(r);
            }
        }
    }
    private void printCustomers(){
        System.out.println("   Here is a list of today's customers: ");
        for (Customer p : customers) {
            System.out.println("   " + p.getName());
        }
    }
    public void init() {
        /*
            1) instantiate 1 Store
            2) instantiate 10 Customers of random type
            3) instantiate 20 Tools of random type
         */
        store = new Store();

        Customer a = new BusinessCust();
        a.setName("Adam");
        Customer b = new BusinessCust();
        b.setName("Bob");
        Customer c = new BusinessCust();
        c.setName("Carol");
        Customer d = new BusinessCust();
        d.setName("Dan");
        Customer e = new RegularCust();
        e.setName("Evan");
        Customer f = new RegularCust();
        f.setName("Frank");
        Customer g = new RegularCust();
        g.setName("George");
        Customer h = new CasualCust();
        h.setName("Hannah");
        Customer i = new CasualCust();
        i.setName("Ian");
        Customer j = new CasualCust();
        j.setName("John");

        cList = Arrays.asList(a, b, c, d, e, f, g, h, i, j);

        Tool t1 = new ConcreteTool( "Wheelbarrow"); //3
        Tool t2 = new ConcreteTool( "Trowel");
        Tool t3 = new ConcreteTool( "Concrete");
        Tool t4 = new WoodTool( "Goggles"); //4
        Tool t5 = new WoodTool( "Saw");
        Tool t6 = new WoodTool( "Gloves");
        Tool t7 = new WoodTool( "Sander");
        Tool t8 = new WoodTool("Hammer");
        Tool t9 = new WoodTool( "Screwdriver");
        Tool t10 = new PaintTool("Small Brush"); //2
        Tool t11 = new PaintTool( "Medium Brush");
        Tool t12 = new PaintTool( "Large Brush");
        Tool t13 = new PaintTool( "Roller");
        Tool t14 = new PlumbingTool( "Plunger"); //1
        Tool t15 = new PlumbingTool( "Snake");
        Tool t16 = new YardTool( "Shovel"); // 5
        Tool t17 = new YardTool( "Shears");
        Tool t18 = new YardTool( "Hoe");
        Tool t19 = new YardTool( "Mattock");
        Tool t20 = new YardTool( "Weeder");
        tList = Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20);
        store.setInventory(tList);
    }
    public void run() {

        for (int day = 1; day <= 35; day++) {
            if (day != 1) {
                updateRentals();
            }

            System.out.println("Today is day " + day + ":");
            if (store.showInventory().size() != 0) {
                getCustomers();
                printCustomers();

                for (Customer p : customers) {
                    if (store.showInventory().size() != 0) {
                        store.rent(p);
                    }
                }
            }
        }
    }
    private void printRental(Rental r){
        System.out.println("Name: " +r.getName());
        System.out.println("Tools: ");
        for(Tool t:r.getTools()){
            System.out.println("   "+ t.getName());
        }
        System.out.println("Price: "+ r.getPrice());
        System.out.println("Rental length: "+ r.getLength());
    }
    public void printReport(){
        List<Tool> inventory = store.showInventory();
        System.out.println("Current inventory: "+store.showInventory().size());
        for(Tool t:inventory){
            System.out.println(t);
        }
        System.out.println("Revenue: " + store.getRevenue());
        System.out.println("Here are the completed rentals: ");
        for(Rental r:store.getCompletedRentals()){
            printRental(r);
        }
        System.out.println("Here are the current rentals: ");
        for(Rental r:store.showRentals()){
            printRental(r);
        }
    }
}
