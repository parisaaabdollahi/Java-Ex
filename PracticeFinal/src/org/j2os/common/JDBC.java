package org.j2os.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    private static BasicDataSource BASIC_DATA_SOURCE = new BasicDataSource();

    static {
        BASIC_DATA_SOURCE.setUsername("hadi");
        BASIC_DATA_SOURCE.setPassword("java123");
        BASIC_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        BASIC_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        BASIC_DATA_SOURCE.setMaxTotal(10);
    }

    public static Connection getConnection() throws Exception {
        Connection connection = BASIC_DATA_SOURCE.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }
}
