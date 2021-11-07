package dblayer.UserService;

import dblayer.DB;
import dblayer.UserService.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UsersProvider extends DB {

    private static String USER_BY_NAME_QUERY = "SELECT USER_NAME FROM USERTBL WHERE USER_NAME = ?";
    private static String INSERT_USER = "INSERT INTO users (user_name) values(?)";

    private UsersProvider() {
        super();
    }

    public static User getUser(String userName) {

        Map<Integer, Object> parameters = new HashMap<>();
        parameters.put(1, userName);

        return getFirsUser( executeStatement(USER_BY_NAME_QUERY,parameters) );

    }



    private static User getFirsUser(ResultSet rs) {
        try {
            rs.first();
            return new User(rs.getString(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


}
