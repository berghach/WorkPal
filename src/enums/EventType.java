package enums;

public enum EventType {
    CONFERENCE("conference"),
    SEMINAR("seminar"),
    MEETING("meeting"),
    WORKSHOP("workshop");

    private final String eventType;
    EventType(String eventType){
        this.eventType = eventType;
    }
    public String getEventType(){
        return eventType;
    }
}
