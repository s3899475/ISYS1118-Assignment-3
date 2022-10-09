package Assignment3;

import java.util.ArrayList;
import java.util.Date;

public class Event {
    private int eventID;
    private Date date;
    private String pkg;
    private String menu;
    private String[] options;
    
    Event(int eventID, Date date, String pkg, String menu, String[] options) {
        this.eventID = eventID;
        this.date = date;
        this.pkg = pkg;
        this.menu = menu;
        this.options = options;
    }

    public int getEventID() {
        return eventID;
    }

    public Date getDate() {
        return date;
    }

    public String getPkg() {
        return pkg;
    }

    public String getMenu() {
        return menu;
    }

    public String[] getOptions() {
        return options;
    }
}
