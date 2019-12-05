package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

class Connection {
	private static String host     = "localhost";
	private static String username = "root";
	private static String password = "";
	private static String database = "bdfarmacia";
	private static int    port     = 3306;
	private static String address  = "jdbc:mysql://" + host + ":" + port + "/" + database+"";
	
	private static java.sql.Connection connection = null;
	
	static java.sql.Connection getConnection() throws SQLException {
		if(connection==null) {
			return connection = DriverManager.getConnection(address, username, password);  
		}
		return connection;
	}
	static void close() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
}
