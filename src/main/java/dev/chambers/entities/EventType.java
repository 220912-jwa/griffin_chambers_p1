package dev.chambers.entities;

public enum EventType {UNIVERSITY_COURSE (1,80),SEMINAR (2,60),CERTIFICATION_PREPARATION_CLASS (3,75),CERTIFICATION(4,100),TECHNICAL_TRAINING(5,90),OTHER(6,30);
    private int eventTypeId;
    private int eventPercent;
    private EventType(int eventID, int eventPercent){
    this.eventTypeId = eventID; this.eventPercent= eventPercent;
    }

    public int getEventTypeId() {
        return eventTypeId;
    }
    public int getEventPercent(){return eventPercent;}
}
