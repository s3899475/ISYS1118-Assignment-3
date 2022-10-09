package Assignment3;

import java.util.ArrayList;
import java.util.Date;

public class User {
    protected Storage storage;
    protected int eventID;

    User(Storage storage) {
        this.storage = storage;
        this.eventID = 0;
    }

    public void bookEvent(Date date, String pkg, String menu, String[] options) {
        eventID = storage.createEvent(date, pkg, menu, options);
    }

    public int getEventID() {
        return eventID;
    }
}
