package Assignment3;

import java.util.Date;

public class Event {
    private String eventID;
    private Date date;
    
    Event(String eventID, Date date) {
        this.eventID = eventID;
        this.date = date;
    }

    public String getEventID() {
        return eventID;
    }

    public Date getDate() {
        return date;
    }
}
