import java.util.*;
public class UserClss {
    // User attributes
    private String username;
    private String email;
    // This could be a list of Event objects if you have an Event class
    private String password;
    private List<Event> savedEvents; // Storing Event objects

    // Constructor
    public UserClss(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.savedEvents = new ArrayList<>();
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getSavedEvents() {
        return savedEvents;
    }
    //for demo
    public void setSavedEvents(List<Event> savedEvents) {
        this.savedEvents = savedEvents;
    }
    public boolean checkPassword(String inputpassword) {return this.password.equals(inputpassword);}
    // Method to add an event to saved events in the app
    public void addSavedEvent(Event event) {
        this.savedEvents.add(event);
    }

    // Method to remove an event from saved events
    public void removeSavedEvent(String event) {
        this.savedEvents.remove(event);
    }

    // Optional: Override toString for easy printing of user info
    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", savedEvents=" + savedEvents +
                '}';
    }
}
