package com.hsframework.core.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateRepository {

    private final ConnectionMaker connectionMaker;

    public UserUpdateRepository(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void updatePassword(String username, String password) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        String sql = "update users set password = ? where username = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, password);
        ps.setString(2, username);

        ps.executeUpdate();

        ps.close();
        c.close();
    }
}
