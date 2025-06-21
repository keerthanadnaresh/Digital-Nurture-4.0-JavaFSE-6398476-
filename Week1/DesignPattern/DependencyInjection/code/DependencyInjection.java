import java.util.HashMap;
import java.util.Map;


class User {
    private final String userId;
    private final String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() { return userId; }
    public String getUserName() { return userName; }

    @Override
    public String toString() {
        return "User [ID=" + userId + ", Name=" + userName + "]";
    }
}


interface UserDataSource {
    User fetchUserById(String userId);
}


class InMemoryUserRepository implements UserDataSource {
    private final Map<String, User> dataStore = new HashMap<>();

    public InMemoryUserRepository() {
        
        dataStore.put("U001", new User("U001", "Keerthana"));
        dataStore.put("U002", new User("U002", "Kavi"));
    }

    @Override
    public User fetchUserById(String userId) {
        return dataStore.getOrDefault(userId, new User(userId, "Not Found"));
    }
}


class UserService {
    private final UserDataSource dataSource;

    public UserService(UserDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void displayUser(String userId) {
        User user = dataSource.fetchUserById(userId);
        System.out.println("User Info: " + user);
    }
}


public class DependencyInjection {
    public static void main(String[] args) {
        
        UserDataSource repository = new InMemoryUserRepository();
        UserService service = new UserService(repository);

        service.displayUser("U002");
        service.displayUser("U923");  
    }
}
