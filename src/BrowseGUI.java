import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BrowseGUI extends JFrame {
    private List<Event> events;
    private JPanel eventsPanel;
    private JScrollPane scrollPane;

    private UserClss loggeduser;

    public BrowseGUI(UserClss user) {
        // Sample events for demonstration
        events = createSampleEvents();
        this.loggeduser = user;
        // Initialize UI components
        eventsPanel = new JPanel();
        eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(eventsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JButton backToMainButton = new JButton("Back to Main");
        JButton sortByRatingButton = new JButton("Sort by Rating");

        // Add events to the panel
        displayEvents(events);
        backToMainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
                new HomeGUI(loggeduser); // Open the HomePage
            }
        });
        sortByRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                events.sort((event1, event2) -> Double.compare(event2.getRating(), event1.getRating()));
                displayEvents(events);
            }
        });

        // Layout
        JPanel buttonPanel = new JPanel(); // Panel for buttons
        buttonPanel.add(backToMainButton);
        buttonPanel.add(sortByRatingButton);

        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        // JFrame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setVisible(true);
    }

    private void displayEvents(List<Event> events) {
        eventsPanel.removeAll();
        for (Event event : events) {
            JPanel eventPanel = new JPanel();
            eventPanel.setLayout(new GridBagLayout()); // Using GridBagLayout for more control

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(5, 5, 5, 5); // Padding

            eventPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            eventPanel.add(new JLabel(event.getTitle()), gbc);
            eventPanel.add(new JLabel("Date: " + event.getDate()), gbc);
            eventPanel.add(new JLabel("Venue: " + event.getVenue()), gbc);
            eventPanel.add(new JLabel("Rating: " + event.getRating()), gbc);

            // Set a preferred size for the event panel
            eventPanel.setPreferredSize(new Dimension(900, 100)); // Adjust the size as needed

            eventPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    dispose(); // Close BrowsePage
                    new EventDetailsGUI(event,"browsepage",loggeduser); // Open EventDetailsPage with the selected eve
                }
            });

            eventsPanel.add(eventPanel);
            eventsPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacing between events
        }
        eventsPanel.revalidate();
        eventsPanel.repaint();
    }


    public static List<Event> createSampleEvents() {
        List<Event> sampleEvents = new ArrayList<>();
        // Add sample events
        sampleEvents.add(new Event("1", "Concert", "Music concert", "Great music bands performing live", "2023-12-12", "Venue A", 4.5));
        sampleEvents.add(new Event("2", "Art Exhibition", "Contemporary art", "Exhibition of modern art pieces", "2023-12-15", "Venue B", 4.7));
        sampleEvents.add(new Event("4", "Food Festival", "Gourmet Food", "A celebration of international cuisines and flavors", "2023-12-25", "Downtown D", 4.6));
        sampleEvents.add(new Event("5", "Film Screening", "Indie Films", "Exclusive screening of award-winning indie films", "2023-12-28", "Cinema E", 4.1));
        sampleEvents.add(new Event("6", "Theater Play", "Drama and Comedy", "A captivating play by renowned artists", "2023-12-30", "Theater F", 4.7));
        sampleEvents.add(new Event("7", "Book Fair", "Books and Literature", "Explore the latest in literature and meet authors", "2024-01-05", "Library G", 4.3));
        sampleEvents.add(new Event("8", "Marathon", "Outdoor Run", "City marathon for professional and amateur runners", "2024-01-10", "City Streets H", 4.4));
        sampleEvents.add(new Event("9", "Live Comedy Show", "Stand-up Comedy", "Evening of laughter with top comedians", "2024-01-15", "Comedy Club I", 4.9));
        sampleEvents.add(new Event("10", "Photography Workshop", "Learn Photography", "Workshop by a renowned photographer", "2024-01-20", "Studio J", 4.0));
        return sampleEvents;
    }


}
