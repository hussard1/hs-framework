package com.hsframework.core.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteRepository {

    private final ConnectionMaker connectionMaker;

    public UserDeleteRepository(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void deleteByUsername(String username) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeConnection();

        String sql = "delete from users where username = ?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, username);
        ps.executeUpdate();
        ps.close();
        c.close();
    }
}
