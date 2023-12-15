import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventDetailsGUI extends JFrame {

    private JButton addToMyEventsButton;
    private JButton deleteFromMyEventsButton;
    private User loggeduser;
    private JLabel titleLabel;
    private JTextArea detailsArea;
    private JScrollPane scrollPane;
    private JButton backButton;
    private JPanel buttonPanel;

    public EventDetailsGUI(Event event, String sourcePage, User user) {
        this.loggeduser = user;
        // Initialize UI components
        titleLabel = new JLabel(event.getTitle());
        detailsArea = new JTextArea(event.getFullDetails());
        detailsArea.setEditable(false);
        scrollPane = new JScrollPane(detailsArea);

        addToMyEventsButton = new JButton("Add to My Events");
        addToMyEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                addToMyEvents(loggeduser, event);
                dispose();
            }
        });

        deleteFromMyEventsButton = new JButton("Delete From My Events");
        deleteFromMyEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                deleteFromMyEvents(loggeduser, event);
                dispose();
            }
        });

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if ("browsepage".equals(sourcePage)) {
                    new BrowseGUI(loggeduser); // Go back to BrowsePage
                }
            }
        });

        // Layout
        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        
        // for buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addToMyEventsButton);
        buttonPanel.add(deleteFromMyEventsButton);
        buttonPanel.add(backButton);
        this.add(buttonPanel, BorderLayout.SOUTH);

        // JFrame settings
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setVisible(true);
    }

    private void addToMyEvents(User loggeduser, Event event){
        if (loggeduser.searchSavedEvent(event)){ // if the event is already added
            JOptionPane.showMessageDialog(EventDetailsGUI.this, "Already Added to Your Events!");
        }else{
            loggeduser.addSavedEvent(event);
            JOptionPane.showMessageDialog(EventDetailsGUI.this, "Added to Your Events!");
        }
    }

    private void deleteFromMyEvents(User loggeduser, Event event){
        if (loggeduser.searchSavedEvent(event)){
            loggeduser.removeSavedEvent(event);
            JOptionPane.showMessageDialog(EventDetailsGUI.this, "Deleted from Your Events!");
        }else{
            JOptionPane.showMessageDialog(EventDetailsGUI.this, "Not in Your Events!");
        }
    }


}
