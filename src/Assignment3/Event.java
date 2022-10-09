package Assignment3;

import java.util.Date;

public class Event {
    private int eventID;
    private Date date;
    
    Event(int eventID, Date date) {
        this.eventID = eventID;
        this.date = date;
    }

    public int getEventID() {
        return eventID;
    }

    public Date getDate() {
        return date;
    }
}
