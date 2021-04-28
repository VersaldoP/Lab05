package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	
	
	static private final String jdbcUrl="jdbc:mysql://localhost/dizionario?user=root&password=root";
	
	static private HikariDataSource ds = null;
	
	public static Connection getConnection() {
		if(ds==null) {
			ds= new HikariDataSource();
			
			ds.setJdbcUrl(jdbcUrl);
			//lo username e la password posso passarle anche con un setUsername e setPassword al posto di metterle nel jdbcUrl
		}
		
		try {
			Connection connection = ds.getConnection();
			return connection;

	} catch (SQLException e) {

		e.printStackTrace();
		throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
	}
	}
	

}
