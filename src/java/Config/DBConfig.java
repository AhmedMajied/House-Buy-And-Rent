package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
	    return DriverManager.getConnection("jdbc:mysql://localhost:3305/housebuyandrent?user=root&password=root");
	}
}
