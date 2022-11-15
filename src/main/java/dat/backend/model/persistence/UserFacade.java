package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class UserFacade {
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.createUser(username, password, role, connectionPool);
    }

    public static void updateBalance(String username, int balance, ConnectionPool connectionPool) {
        UserMapper.updateBalance(username, balance, connectionPool);

    }

    public static List<String> getAllUsers(ConnectionPool connectionPool) {
        return UserMapper.getAllUsers(connectionPool);
    }

}
