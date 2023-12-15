import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileGUI extends JFrame {
    
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton logoutButton;
    private JButton backToMainButton;
    private JButton changeNameButton;
    private JButton changeEmailButton;
    private JButton changePasswordButton;

    private User loggedInUser;

    public UserProfileGUI(User loggedInUser) {
        this.loggedInUser = loggedInUser;

        // UI Components
        nameLabel = new JLabel("Account Name: " + loggedInUser.getUsername());
        emailLabel = new JLabel("Account Email: " + loggedInUser.getEmail());
        nameField = new JTextField(loggedInUser.getUsername(), 20);
        emailField = new JTextField(loggedInUser.getEmail(), 20);
        passwordField = new JPasswordField(20);
        logoutButton = new JButton("Log Out");
        backToMainButton = new JButton("Back to Main");
        changeNameButton = new JButton("Change Account Name");
        changeEmailButton = new JButton("Change Email");
        changePasswordButton = new JButton("Change Password");

        // Layout
        this.setLayout(new FlowLayout());
        this.add(nameLabel);
        this.add(emailLabel);
        this.add(new JLabel("New Name:"));
        this.add(nameField);
        this.add(changeNameButton);
        this.add(new JLabel("New Email:"));
        this.add(emailField);
        this.add(changeEmailButton);
        this.add(new JLabel("New Password:"));
        this.add(passwordField);
        this.add(changePasswordButton);
        this.add(logoutButton);
        this.add(backToMainButton);
        // Logout action
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI();
            }
        });

        backToMainButton.addActionListener(e -> {
            dispose();
        });

        // Change name action
        changeNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeName(loggedInUser);
                updateAndLogout();
            }
        });

        // Change email action
        changeEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeEmail(loggedInUser);
                updateAndLogout();
            }
        });

        // Change password action
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePassword(loggedInUser);
                updateAndLogout();
            }
        });

        // JFrame settings
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }
    private void updateAndLogout() {
        UserBook userBook = LoginGUI.userBook;
        userBook.updateUser(loggedInUser);
        logout();
    }
    private void logout() {
        dispose();
        new LoginGUI();
    }

    private void changeName(User loggedInUser){
        loggedInUser.setUsername(nameField.getText());
        nameLabel.setText("Account Name: " + loggedInUser.getUsername());
        JOptionPane.showMessageDialog(UserProfileGUI.this, "Name updated successfully!");
    }

    private void changeEmail(User loggedInUser){
        loggedInUser.setEmail(emailField.getText());
        emailLabel.setText("Account Email: " + loggedInUser.getEmail());
        JOptionPane.showMessageDialog(UserProfileGUI.this, "Email updated successfully!");
    }

    private void changePassword(User loggedInUser){
        loggedInUser.setPassword(new String(passwordField.getPassword()));
        JOptionPane.showMessageDialog(UserProfileGUI.this, "Password updated successfully!");
    }
}
