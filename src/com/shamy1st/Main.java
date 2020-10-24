package com.shamy1st;

import com.shamy1st.objectPool.JDBCConnectionPool;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        JDBCConnectionPool pool = new JDBCConnectionPool(
                "jdbc:mysql://localhost:3306/database_name?serverTimezone=UTC",
                "user", "password");

        // Get a connection:
        Connection connection = (Connection) pool.takeOut();

        //Do some queries

        // Return the connection:
        pool.takeIn(connection);
    }
}