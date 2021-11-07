
package dblayer;

import initialization.ReadConfigFiles;

import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class DB implements dbConfigProps {

    private static Connection DB_CONNECTION = null;

    public static Connection getConnection() {
        if (DB_CONNECTION == null) {
            Properties ConfigProps = ReadConfigFiles.getPropFileFromDefaultConfigFile();

            try {

                DB_CONNECTION = DriverManager.getConnection(ConfigProps.getProperty(DB_CONFIG_DRIVER), ConfigProps.getProperty(DB_USER),
                        ConfigProps.getProperty(DB_PASSWORD));

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            finally {
                return DB_CONNECTION;
            }

        } else return DB_CONNECTION;
    }

    public static PreparedStatement getStatement(String statement) {

        try {
            return getConnection().prepareStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet executeStatement(String query,Map<Integer,Object> parameters) {
        try {
            PreparedStatement st = getStatement(query);
            for(Map.Entry<Integer,Object>  entry :parameters.entrySet()){
                st.setObject(entry.getKey(),entry.getValue());
            }
            return st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected DB() {

    }

}
