package database.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlAccess {
    private static Connection conn = null;

    public static Connection setConnection(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "123";

        try{
            conn = DriverManager.getConnection(url, username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
