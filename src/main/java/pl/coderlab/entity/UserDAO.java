package pl.coderlab.entity;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderlab.DbUtil;
import pl.coderlab.User;

import java.sql.*;

public class UserDAO {
    private static final String CREATE_USER_QUERY =
            "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    private static final String READ_USER_QUERY =
            "select * from users u where u.id = ?";
    private static final String UPDATE_USER_QUERY =
            "update users u " +
                    "set u.email = ?, u.username = ?, u.password = ? " +
                    "where id = ?";
    private static final String DELETE_USER_QUERY =
            "delete from users u where u.id = ?";

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read(int userId) {
        try(Connection conn = DbUtil.getConnection()) {
            PreparedStatement prepStatement = conn.prepareStatement(this.READ_USER_QUERY);
            prepStatement.setString(1, String.valueOf(userId));
            ResultSet resultSet = prepStatement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public String verifyHash(String password, String hashed) {
        return BCrypt.hashpw(password, hashed);
    }
}
