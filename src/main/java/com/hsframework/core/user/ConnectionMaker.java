package com.hsframework.core.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionMaker {

    Connection makeConnection() throws SQLException, ClassNotFoundException;
}
