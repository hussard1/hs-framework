package com.hsframework.core.user;

import java.sql.*;

public class UserRepository {

    public void save(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsframework", "root", "1234");

        String sql = "insert into users(username, password) values(?, ?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User findByUsername(String username) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hsframework", "root", "1234");

        String sql = "select * from users where username = ?";
        PreparedStatement ps = c.prepareStatement(sql);

        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        rs.next();
        User user = User.builder()
                .id(rs.getLong("id"))
                .username(rs.getString("username"))
                .password(rs.getString("password"))
                .build();

        rs.close();
        ps.close();
        c.close();

        return user;
    }

}
