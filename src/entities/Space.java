package entities;

public class Space {
    private int id;
    private String title;
    private String description;
    private int capacity;
    private float price;
    private SpaceType spaceType;
    private Manager manager;

    public Space(String title, String description, int capacity, float price, SpaceType spaceType, Manager manager){
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.price = price;
        this.spaceType = spaceType;
        this.manager = manager;
    }

    public int getId(){
        return id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice(){
        return price;
    }
    public void setSpaceType(SpaceType spaceType){
        this.spaceType = spaceType;
    }
    public SpaceType getSpaceType(){
        return spaceType;
    }
    public void setManager(Manager manager){
        this.manager = manager;
    }
    public Manager getManager(){
        return manager;
    }
}
