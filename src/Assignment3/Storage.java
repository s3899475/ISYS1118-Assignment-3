package Assignment3;

import java.util.ArrayList;
import java.util.Date;

public class Storage {
    public ArrayList<Event> events;
    public ArrayList<Bill> bills;
    public ArrayList<Feedback> sent_feedback;


    Storage() {
        events = new ArrayList<>();
        bills = new ArrayList<>();
        sent_feedback = new ArrayList<>();
    }
    
    public int createEvent(Date date) {
        // make an event with a new eventID
        
        int id = events.size() + 1;
        events.add(new Event(id, date));

        return id;
    }

    public Event getEvent(int eventID) {
        for (Event event : events) {
            if (event.getEventID() == eventID) {
                return event;
            }
        }
        // return null if no event found
        return null;
    }
}
