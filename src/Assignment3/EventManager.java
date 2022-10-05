// keely wants to look at this
package Assignment3;

import java.util.ArrayList;
import java.util.Date;

public class EventManager {
    private ArrayList<Event> events;

    EventManager() {
        events = new ArrayList<>();
    }
    
    public String createEvent(Date date) {
        // make an event with a new eventID
        
        String id = Integer.toString(events.size() + 1);
        events.add(new Event(id, date));

        return id;
    }

    public Event getEvent(String eventID) {
        for (Event event : events) {
            if (event.getEventID() == eventID) {
                return event;
            }
        }
        // return null if no event found
        return null;
    }


    public void printAllEvents() {
        for (Event event : events) {
            System.out.println("Event " + event.getEventID() + ":");
            System.out.println("\t" + event.getDate());
        }
    }
}
