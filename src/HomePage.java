import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private JButton browseEventsButton;
    private JButton searchButton;
    private JButton notificationsButton;
    private JButton userProfileButton;
    public JPanel mainPanel; // Main container panel
    private UserClss loggeduser;

    public HomePage(UserClss user) {
        // Initialize the main panel and set its layout
        this.loggeduser = user;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Initialize buttons and add action listeners
        browseEventsButton = new JButton("Browse Events");
        searchButton = new JButton("Search");
        notificationsButton = new JButton("Notifications");
        userProfileButton = new JButton("User Profile");

        // Add buttons to the main panel
        mainPanel.add(browseEventsButton);
        mainPanel.add(searchButton);
        mainPanel.add(notificationsButton);
        mainPanel.add(userProfileButton);

        // Add the main panel to the JFrame
        this.add(mainPanel);

        // Set up JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);

        browseEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BrowsePage(loggeduser); // Open the BrowsePage
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchPage(BrowsePage.createSampleEvents(),loggeduser); // Open the BrowsePage
            }
        });
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserProfilePage(loggeduser); // Open the BrowsePage
            }
        });
        // Similarly, add action listeners for other buttons
    }


}
