import java.util.*;
public class Rental {
    private List<Tool> tools;
    private String name;
    private int length;
    private int dueIn;
    private int price;
    Rental(String name, List<Tool> tools, int dueIn, int price){
        this.name = name;
        this.tools = tools;
        this.length = dueIn;
        this.dueIn = dueIn;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getDueIn(){ return dueIn; }
    public List<Tool> getTools(){
        return tools;
    }
    public void decrementDueDate(){
        dueIn = dueIn-1;
    }
    public int getSize(){return tools.size(); }
    public int getPrice(){return this.price; }
    public int getLength(){return this.length; }
}
