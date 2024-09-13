package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Role;

public class Manager extends User {
    private String departement;
    private List<Service> services = new ArrayList<>();
    private List<Space> spaces = new ArrayList<>();
    private List<Plan> plans = new ArrayList<>();

    public Manager(String firstName, String lastName, Role role, String email, String password, String departement){
        super(firstName, lastName, role, email, password);
        this.departement = departement;
    }
    public void setDepartement(String depatement){
        this.departement = depatement;
    }
    public String getDepartement(){
        return departement;
    }
    public List<Service> getServices(){
        return services;
    }
    public void addService(Service service){
        services.add(service);
        service.setManager(this);
    }
    public void removeService(Service service){
        services.remove(service);
        service.setManager(null);
    }
    public List<Space> getSpaces(){
        return spaces;
    }
    public void addSpace(Space space){
        spaces.add(space);
        space.setManager(this);
    }
    public void removeSpace(Space space){
        spaces.remove(space);
        space.setManager(null);
    }
    public List<Plan> getPlans(){
        return plans;
    }
    public void addPlan(Plan plan){
        plans.add(plan);
        plan.setManager(this);
    }
    public void removePlan(Plan plan){
        plans.remove(plan);
        plan.setManager(null);
    }

}
