package JDBD;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import java.sql.Connection;

public class  JDBC {
        private static final BasicDataSource DATA_SOURCE = new BasicDataSource();

        static {
            DATA_SOURCE.setUsername("parisa");
            DATA_SOURCE.setPassword("java123");
            DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
            DATA_SOURCE.setMaxTotal(10);
        }

        public static Connection getConnection() throws Exception {
            Connection connection = DATA_SOURCE.getConnection();
            connection.setAutoCommit(false);
            return connection;
        }
    }