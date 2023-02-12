package com.online.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;


//Using hikaricp configuration for connection pooling
public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
//	@SuppressWarnings("unused")	
//	private static Connection getJdbcConnection() throws SQLException, IOException {
//		HikariConfig config = new HikariConfig("C:\\Users\\soni8\\eclipse-workspace\\WEBCREDMySQLDB\\src\\main\\java\\com\\online\\property\\db.properties");
//		HikariDataSource dataSource = new HikariDataSource(config);
//		Connection connection = dataSource.getConnection();
//		return connection;
//	}

	
	 public static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		FileInputStream fis = new FileInputStream("C:\\Users\\soni8\\eclipse-workspace\\WEBCREDMySQLDB\\src\\main\\java\\com\\online\\property\\db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
