package JdbcTutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class People {
    
    public Connection getConnection() {
        Connection conn = null;
        Properties connectionProperties = new Properties();
        connectionProperties.setProperty("user", "root");
        connectionProperties.setProperty("password", "mysql");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://10.16.1.238:3306/bp_decorate_0?characterEncoding=UTF-8", connectionProperties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public void createTable() {
        Connection conn = getConnection();
        try{
            String createTableSql = "create Table `people`(`id` int(11), `name` varchar(20), `age` tinyint(3), primary key (`id`))";
            Statement state = conn.createStatement();
            state.execute(createTableSql);
        } catch (Exception e) {
        }finally {
            if (null != conn)
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }
    
    public static void main(String[] args) {
        People people = new People();
        people.createTable();
    }
}
