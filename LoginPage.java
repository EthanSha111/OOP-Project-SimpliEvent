import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Array of sample users
    private UserClss[] users = {
            new UserClss("me", "sample@example.com", "123")
    };

    public LoginPage() {
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
                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(LoginPage.this, "Login Successful!");
                    // Navigate to HomePage
                    LoginPage.this.setVisible(false); // Hide the login page
                    new HomePage(); // Open the HomePage
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Invalid Credentials");
                }
            }
        });
    }

    // Method to authenticate user
    private boolean authenticate(String username, String password) {
        for (UserClss user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
