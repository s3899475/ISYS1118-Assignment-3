package Assignment3;

import java.util.Date;

public class User {
    private EventStorage manager;
    protected String eventID;

    User(EventStorage eventStorage) {
        manager = eventStorage;
        eventID = "0";
    }

    public void bookEvent(Date date) {
        eventID = manager.createEvent(date);
    }

    public String getEventID() {
        return eventID;
    }
}
