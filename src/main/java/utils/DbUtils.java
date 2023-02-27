package utils;

import java.sql.*;

public class DbUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection createConnection(String dbUrl, String dbUsername, String dbPassword){
        try{
            connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public static int getRowCount() throws SQLException {

        resultSet.last();
        return resultSet.getRow();

    }
}
