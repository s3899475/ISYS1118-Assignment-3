package Assignment3;

public class Feedback {
    private String type;
    private String content;
    private int eventID;

    Feedback(String type, String content, int eventID){ //create feedback with type (complaint or regular) and content
        this.type = type;
        this.content = content;
        this.eventID = eventID;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public int getEventID() {
        return eventID;
    }
}
