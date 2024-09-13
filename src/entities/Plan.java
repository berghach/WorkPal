package entities;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Plan {
    private int id;
    private String title;
    private String description;
    private Period period;
    private Manager manager;
    private List<Subsrcription> subsrcriptions = new ArrayList<>();

    public Plan(String title, String description, Period period, Manager manager){
        this.title = title;
        this.description = description;
        this.period = period;
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
    public void setPeriod(Period period){
        this.period = period;
    }
    public Period getPeriod(){
        return period;
    }
    public void setManager(Manager manager){
        this.manager = manager;
    }
    public Manager getManager(){
        return manager;
    }
    public List<Subsrcription> geSubsrcriptions(){
        return subsrcriptions;
    }
    public void addSubscription(Subsrcription subsrcription){
        subsrcriptions.add(subsrcription);
        subsrcription.setPlan(this);
    }
    public void removeSubscription(Subsrcription subsrcription){
        subsrcriptions.remove(subsrcription);
        subsrcription.setPlan(null);
    }
}
