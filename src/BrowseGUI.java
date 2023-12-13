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

    public static EventBook eventBook = new EventBook();

    private User loggeduser;

    public BrowseGUI(User user) {
        // Sample events for demonstration
        this.events = eventBook.getEvents();
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

}
