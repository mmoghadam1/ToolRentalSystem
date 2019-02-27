public abstract class Tool {
    private String name;
    Tool(String name){
        this.name = name;
    }
    public  String getName(){
        return name;
    }
    public abstract int getPrice();
}
