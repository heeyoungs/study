package io.wisoft.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BadJdbcExample {
    public static void main(final String... args) {
        try {
            Connection conn = DriverManager.getConnection
                    ("jdbc:postgresql://localhost:5434/entertainment", "entertainment", "123");
            Statement stmt;
            stmt = conn.createStatement(); // PreparedStatement로 SQL을 작성할때 가독성과 유지보수성이 좋다고 설명하고 있습니다.
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM drama");
            if (stmt.execute("SELECT * FROM drama")) {
                rs = stmt.getResultSet();
            }
            while (rs.next()) {
                System.out.print("[드라마 코드] " + rs.getString(1) + " || ");
                System.out.println("[드라마 이름] " + rs.getString(2));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
    }
}