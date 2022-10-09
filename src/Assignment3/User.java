package Assignment3;

import java.util.Date;

public class User {
    private EventStorage manager;
    protected int eventID;

    User(EventStorage eventStorage) {
        manager = eventStorage;
        eventID = 0;
    }

    public void bookEvent(Date date) {
        eventID = manager.createEvent(date);
    }

    public void giveFeedback(String type, String content){
        Feedback feedback = new Feedback(type, content);
    }

    public int getEventID() {
        return eventID;
    }
}
