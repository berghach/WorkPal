package entities;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import enums.EventType;

public class Event {

    // Instance variables
    private int id;
    private String title;
    private Date date;
    private String location;
    private EventType type;
    private List<Registration> registrations = new ArrayList<>();
    // Constructor
    public Event(String title, Date date, String location, EventType type) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    // No setter for ID to prevent manual modification

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
    // Method to add a registration to the event
    public void addRegistration(Registration registration) {
        registrations.add(registration);
        registration.setEvent(this);
    }
    public void removeRegistration(Registration registration) {
        registrations.remove(registration);
        registration.setEvent(null);
    }
    // Method to get the event registrations
    public List<Registration> getRegistrations() {
        return registrations;
    }

    // Method to get the event participants
    public List<User> getParticipants() {
        List<User> participants = new ArrayList<>();
        for (Registration registration : registrations) {
            participants.add(registration.getParticipant());
        }
        return participants;
    }

    // toString method
    @Override
    public String toString() {
        return "{" +
                "\tID=" + id +",\n"+
                "\tTitle= '" + title + "\'" +",\n"+
                "\tDate= " + date +",\n"+
                "\tLocation= '" + location + "\'" +",\n"+
                "\tType= " + type +",\n"+
                "}";
    }
}
