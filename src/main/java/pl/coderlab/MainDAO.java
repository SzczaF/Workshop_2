package pl.coderlab;

import pl.coderlab.entity.UserDAO;

public class MainDAO {
    public static void main(String[] args) {

        User user1 = new User();
        user1.setUserName("Jan");
        user1.setEmail("jan.kowalski@gmail.com");
        user1.setPassword("TajneHaslo123");

        UserDAO userDAO1 = new UserDAO();
        userDAO1.create(user1);

        User user2 = new User();
        user2.setUserName("Stasio");
        user2.setEmail("stasio@gmail.com");
        user2.setPassword("TajneHaslo123");

        UserDAO userDAO2 = new UserDAO();
        userDAO2.create(user2);

    }
}
