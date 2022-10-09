package Assignment3;

import java.util.Date;

public class User {
    protected Storage storage;
    protected int eventID;

    User(Storage storage) {
        this.storage = storage;
        this.eventID = 0;
    }

    public void bookEvent(Date date) {
        eventID = storage.createEvent(date);
    }

    public int getEventID() {
        return eventID;
    }
}
