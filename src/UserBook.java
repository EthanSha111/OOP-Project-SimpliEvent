import java.util.ArrayList;
import java.util.List;

public class UserBook {
    private List<UserClss> users;

    public UserBook() {
        users = new ArrayList<>();
        // Sample users
        users.add(new UserClss("me", "sample@example.com", "123"));
        users.add(new UserClss("user2", "user2@example.com", "password"));
        // Add more users as needed
    }

    public boolean authenticate(String username, String password) {
        for (UserClss user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

    // Method to get User by username
    public UserClss getUser(String username) {
        for (UserClss user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public void updateUser(UserClss updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(updatedUser.getUsername())) {
                users.set(i, updatedUser);
                break;
            }
        }
    }
}
