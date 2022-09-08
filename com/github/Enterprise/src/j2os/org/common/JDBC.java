package j2os.org.common;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC  {
    private static  final BasicDataSource BASIC_DATA_SOURCE= new BasicDataSource();


    static {
        BASIC_DATA_SOURCE.setUsername("parisa");
        BASIC_DATA_SOURCE.setPassword("java123");
        BASIC_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        BASIC_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        BASIC_DATA_SOURCE.setMaxTotal(30);
    }
public static Connection getConnection() throws  Exception{
Connection connection= BASIC_DATA_SOURCE.getConnection();
connection.setAutoCommit(false);
return connection;
}

}
