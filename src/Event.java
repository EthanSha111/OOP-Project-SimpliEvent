public class Event {
    private String id; // Unique identifier for the event
    private String title;
    private String shortDescription; // For summarized version
    private String detailedDescription; // For detailed view
    private String date;
    private String venue;
    private double rating;


    // Constructor
    public Event(String id, String title, String shortDescription, String detailedDescription, String date, String venue,double rating) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.detailedDescription = detailedDescription;
        this.date = date;
        this.venue = venue;
        this.rating = rating;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDetailedDescription() {
        return detailedDescription;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    // Method to get a summarized version of the event
    public String getSummary() {
        return title + " - " + shortDescription;
    }
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    // Method to get a detailed description of the event
    public String getFullDetails() {
        return "Event: " + title + "\nDate: " + date + "\nVenue: " + venue + "\nDetails: " + detailedDescription;
    }

    // Optional: Override toString for easy printing of event info
    @Override
    public String toString() {
        return getFullDetails();
    }
}
