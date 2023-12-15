import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

public class MyEventsGUI extends JFrame{

    private JPanel eventsPanel;
    private JScrollPane scrollPane;
    private User loggeduser;
    private JButton goBackButton;

    public MyEventsGUI(List<Event> events, User user){
        // UI Components
        this.loggeduser = user;
        goBackButton = new JButton("Go Back");
        eventsPanel = new JPanel();
        eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(eventsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        displayEvents(events);

        // Go back functionality
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window
            }
        });

        // Layout
        JPanel buttonPanel = new JPanel();

        buttonPanel.add(goBackButton);

        this.setLayout(new BorderLayout());
        this.add(buttonPanel, BorderLayout.SOUTH);
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
                dispose();
                new EventDetailsGUI(event, "SearchPage",loggeduser); // Open EventDetailsPage with the selected event
            }
        });

        return eventPanel;
    }


}