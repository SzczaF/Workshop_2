package pl.coderlab;

import pl.coderlab.entity.UserDAO;

import java.util.ArrayList;

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


        UserDAO userDAO = new UserDAO();
        User userR1 = userDAO.read(1);
        User userR2 = userDAO.read(5);
        User userR3 = userDAO.read(3);

        System.out.println(userR1);
        System.out.println(userR2);
        System.out.println(userR3);

        UserDAO userDAOUpdate = new UserDAO();

        User userUpdate = userDAOUpdate.read(5);
        userUpdate.setUserName("Luke");
        userUpdate.setEmail("Luke@skywalker.galaxy");
        userUpdate.setPassword("1mY0urF@7h3r");
        userDAOUpdate.update(userUpdate);

        userDAOUpdate.delete(userUpdate.getId());

        UserDAO userDAOFindAll = new UserDAO();

        ArrayList<User> users = userDAOFindAll.findAll();

        System.out.println(users);


    }
}
