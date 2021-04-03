package com.hsframework.core.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserRepository extends UserRepository {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hsframework", "root", "1234");
    }

}
