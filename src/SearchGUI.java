import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class SearchGUI extends JFrame {
    private JPanel eventsPanel;
    private JScrollPane scrollPane;
    private User loggeduser;

    public SearchGUI(List<Event> events, User user) {
        // UI Components
        this.loggeduser = user;
        JTextField eventNameField = new JTextField(20);
        JTextField venueNameField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton goBackButton = new JButton("Go Back");
        eventsPanel = new JPanel();
        eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(eventsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Search functionality
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eventNameText = eventNameField.getText().toLowerCase();
                String venueNameText = venueNameField.getText().toLowerCase();
                List<Event> filteredEvents = events.stream()
                        .filter(event ->
                                (eventNameText.isEmpty() || event.getTitle().toLowerCase().contains(eventNameText)) &&
                                        (venueNameText.isEmpty() || event.getVenue().toLowerCase().contains(venueNameText)))
                        .collect(Collectors.toList());
                displayEvents(filteredEvents);
            }
        });

        // Go back functionality
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
                new HomeGUI(loggeduser); // Open the HomePage
            }
        });

        // Layout
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Event Name:"));
        topPanel.add(eventNameField);
        topPanel.add(new JLabel("Venue:"));
        topPanel.add(venueNameField);
        topPanel.add(searchButton);
        topPanel.add(goBackButton);

        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        // JFrame settings
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 800);
        this.setVisible(true);
    }

    private void displayEvents(List<Event> filteredEvents) {
        eventsPanel.removeAll();
        if (filteredEvents.isEmpty()) {
            eventsPanel.add(new JLabel("No events found"));
        } else {
            for (Event event : filteredEvents) {
                eventsPanel.add(createEventPanel(event));
            }
        }
        eventsPanel.revalidate();
        eventsPanel.repaint();
    }

    private JPanel createEventPanel(Event event) {
        JPanel eventPanel = new JPanel();
        eventPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        eventPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        eventPanel.add(new JLabel(event.getTitle()), gbc);
        eventPanel.add(new JLabel("Date: " + event.getDate()), gbc);
        eventPanel.add(new JLabel("Venue: " + event.getVenue()), gbc);
        eventPanel.add(new JLabel("Rating: " + event.getRating()), gbc);
        eventPanel.setPreferredSize(new Dimension(900, 100));

        eventPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                new EventDetailsGUI(event, "SearchPage",loggeduser); // Open EventDetailsPage with the selected event
            }
        });

        return eventPanel;
    }
}
