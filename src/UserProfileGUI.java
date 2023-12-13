import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileGUI extends JFrame {
    private UserClss loggedInUser;
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public UserProfileGUI(UserClss loggedInUser) {
        this.loggedInUser = loggedInUser;

        // UI Components
        nameLabel = new JLabel("Account Name: " + loggedInUser.getUsername());
        emailLabel = new JLabel("Account Email: " + loggedInUser.getEmail());
        nameField = new JTextField(loggedInUser.getUsername(), 20);
        emailField = new JTextField(loggedInUser.getEmail(), 20);
        passwordField = new JPasswordField(20);
        JButton logoutButton = new JButton("Log Out");
        JButton backToMainButton = new JButton("Back to Main");
        JButton changeNameButton = new JButton("Change Account Name");
        JButton changeEmailButton = new JButton("Change Email");
        JButton changePasswordButton = new JButton("Change Password");

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
            new HomeGUI(loggedInUser);
        });

        // Change name action
        changeNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInUser.setUsername(nameField.getText());
                nameLabel.setText("Account Name: " + loggedInUser.getUsername());
                JOptionPane.showMessageDialog(UserProfileGUI.this, "Name updated successfully!");
                updateAndLogout();
            }
        });

        // Change email action
        changeEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInUser.setEmail(emailField.getText());
                emailLabel.setText("Account Email: " + loggedInUser.getEmail());
                JOptionPane.showMessageDialog(UserProfileGUI.this, "Email updated successfully!");
                updateAndLogout();
            }
        });

        // Change password action
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInUser.setPassword(new String(passwordField.getPassword()));
                JOptionPane.showMessageDialog(UserProfileGUI.this, "Password updated successfully!");
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
}
