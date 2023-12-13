import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class EventDetailsGUI extends JFrame {
    private User loggeduser;
    public EventDetailsGUI(Event event, String sourcePage, User user) {
        // Initialize UI components
        JLabel titleLabel = new JLabel(event.getTitle());
        JTextArea detailsArea = new JTextArea(event.getFullDetails());
        detailsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsArea);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if ("SearchPage".equals(sourcePage)) {
                    new SearchGUI(BrowseGUI.createSampleEvents(),loggeduser); // Go back to SearchPage
                } else {
                    new BrowseGUI(loggeduser); // Go back to BrowsePage
                }
            }
        });

        // Layout
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(backButton, BorderLayout.SOUTH);

        // JFrame settings
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setVisible(true);
    }
}
