package entities;

import java.util.ArrayList;
import java.util.List;

import enums.Role;

public class Member extends User {
    private String job;
    private List<Registration> registrations = new ArrayList<>();

    public Member (String firstName, String lastName, Role role, String email, String password, String job){
        super(firstName, lastName, role, email, password);
        this.job = job;
    }
    public void setJob(String job){
        this.job = job;
    }
    public String getJob(){
        return job;
    }
    public List<Registration> getRegistrations(){
        return registrations;
    }
    public void addRegistration(Registration registration){
        registrations.add(registration);
        registration.setParticipant(this);
    }
    public void removeRegistration(Registration registration){
        registrations.remove(registration);
        registration.setParticipant(null);
    }
}
