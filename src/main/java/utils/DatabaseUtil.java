package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    /*
    Класс создающий подключение к базе данных, с помощью аккаунта пользователя,
    которому доступна только база данных semestr
     */

    private final static String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String CONNECTION_URI = "jdbc:sqlserver://localhost:1433;DatabaseName=semestr";
    private final static String LOGIN = "Semestr";
    private final static String PASSWORD = "123456";
    private static Connection conn;

    public static Connection getConn(){
        if(conn==null){
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(CONNECTION_URI, LOGIN, PASSWORD);
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    return conn;
    }
}
