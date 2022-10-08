package Assignment3;

import java.util.Date;

public class User {
    private EventStorage manager;
    private String eventID;

    User(EventStorage eventStorage) {
        manager = eventStorage;
        eventID = "0";
    }

    public void bookEvent(Date date) {
        eventID = manager.createEvent(date);
    }

    public void giveFeedback(String type, String content){
        Feedback feedback = new Feedback(type, content);
    }
}
