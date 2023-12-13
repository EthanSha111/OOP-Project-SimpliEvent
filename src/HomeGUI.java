import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI extends JFrame {
    private JButton browseEventsButton;
    private JButton searchButton;
    private JButton myEventsButton;
    private JButton userProfileButton;
    public JPanel mainPanel; // Main container panel
    private User loggeduser;

    public static EventBook eventBook = new EventBook();

    public HomeGUI(User user) {
        // Initialize the main panel and set its layout
        this.loggeduser = user;
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Initialize buttons and add action listeners
        browseEventsButton = new JButton("Browse Events");
        searchButton = new JButton("Search");
        myEventsButton = new JButton("My Events");
        userProfileButton = new JButton("User Profile");

        // Add buttons to the main panel
        mainPanel.add(browseEventsButton);
        mainPanel.add(searchButton);
        mainPanel.add(myEventsButton);
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
                new BrowseGUI(loggeduser); // Open the BrowsePage
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchGUI(eventBook.getEvents(),loggeduser); // Open the BrowsePage
            }
        });
        myEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyEventsGUI(loggeduser.getSavedEvents(),loggeduser);
            }
        });
        userProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UserProfileGUI(loggeduser); // Open the BrowsePage
            }
        });
        // Similarly, add action listeners for other buttons
    }


}
