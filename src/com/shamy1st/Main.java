package com.shamy1st;

import com.shamy1st.objectPool.JDBCConnectionPool;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "jdbc:mysql://localhost:3306/database_name?serverTimezone=UTC",
                "user", "password");

        // Get a connection:
        Connection connection = (Connection) pool.checkOut();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM table_name");

            while (rs.next()) {
                String field = rs.getString("column_name");
                System.out.println(field);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Return the connection:
        pool.checkIn(connection);
    }
}
