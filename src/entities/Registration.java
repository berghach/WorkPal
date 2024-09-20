package entities;

import java.util.Date;

public class Registration {

    // Instance variables
    private int id;
    private Date date;
    private Event event;      // The event for which the participant is registering
    private Member participant;  // The participant who is registering

    // Constructor
    public Registration(Date date, Event event, Member participant) {
        this.date = date;
        this.event = event;
        this.participant = participant;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    // No setter for ID to prevent manual modification

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Member getParticipant() {
        return participant;
    }

    public void setParticipant(Member participant) {
        this.participant = participant;
    }

    // toString method
    @Override
    public String toString() {
        return "Registration{\n" +
                "\tid=" + id +",\n"+
                "\tdate=" + date +",\n"+
                "\tevent=" + event.toString() +",\n"+
                "\tparticipant=" + participant.toString() +",\n"+
                '}';
    }
}
