package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();

        userService.saveUser("ИВАН", "ИВАНОВ", (byte) 10);
        userService.saveUser("СЕМЕН", "СЕМЕНОВ", (byte) 20);
        userService.saveUser("ДАНИЛ", "ДАНИЛОВ", (byte) 40);
        userService.saveUser("КИРИЛЛ", "ПЕТРОВ", (byte) 60);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
    }