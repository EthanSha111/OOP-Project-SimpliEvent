import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public static UserBook userBook = new UserBook();

    public LoginGUI() {
        // Initialize components
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        // Set layout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        // Add panel to JFrame
        this.add(panel);
        // Set up JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        // Action listener for login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (userBook.authenticate(username, password)) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Login Successful!");
                    LoginGUI.this.setVisible(false); // Hide the login page
                    UserClss loggedInUser = userBook.getUser(username);
                    new HomeGUI(loggedInUser); // Open UserProfilePage with the logged-in user
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid Credentials");
                }
            }
        });

    }


    public static void main(String[] args) {
        new LoginGUI();
    }
}
