package com.hsframework.core.user;

import java.sql.*;

public class NUserRepository extends UserRepository {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hsframework", "root", "1234");
    }

}
