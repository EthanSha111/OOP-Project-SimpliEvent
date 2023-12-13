import java.util.ArrayList;
import java.util.List;

public class EventBook{

    private List<Event> events;

    public EventBook() {
        events = new ArrayList<>();
        // Sample events
        events.add(new Event("1", "Concert", "Music concert", "Great music bands performing live", "2023-12-12", "Venue A", 4.5));
        events.add(new Event("2", "Art Exhibition", "Contemporary art", "Exhibition of modern art pieces", "2023-12-15", "Venue B", 4.7));
        events.add(new Event("4", "Food Festival", "Gourmet Food", "A celebration of international cuisines and flavors", "2023-12-25", "Downtown D", 4.6));
        events.add(new Event("5", "Film Screening", "Indie Films", "Exclusive screening of award-winning indie films", "2023-12-28", "Cinema E", 4.1));
        events.add(new Event("6", "Theater Play", "Drama and Comedy", "A captivating play by renowned artists", "2023-12-30", "Theater F", 4.7));
        events.add(new Event("7", "Book Fair", "Books and Literature", "Explore the latest in literature and meet authors", "2024-01-05", "Library G", 4.3));
        events.add(new Event("8", "Marathon", "Outdoor Run", "City marathon for professional and amateur runners", "2024-01-10", "City Streets H", 4.4));
        events.add(new Event("9", "Live Comedy Show", "Stand-up Comedy", "Evening of laughter with top comedians", "2024-01-15", "Comedy Club I", 4.9));
        events.add(new Event("10", "Photography Workshop", "Learn Photography", "Workshop by a renowned photographer", "2024-01-20", "Studio J", 4.0));
        // Add more users as needed
    }

    public List<Event> getEvents() {
        return this.events;
    }

    


}