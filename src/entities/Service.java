package entities;

public class Service {
    private int id;
    private String name;
    private String description;
    private float price;
    private Manager manager;

    public Service(String name, String description, float price, Manager manager){
        this.name = name;
        this.description = description;
        this.price = price;
        this.manager = manager;
    }

    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }
    public void setManager(Manager manager){
        this.manager = manager;
    }
    public Manager getManager(){
        return manager;
    }
    
}
