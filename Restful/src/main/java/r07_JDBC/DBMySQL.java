package r07_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBMySQL {
	private static String url = "jdbc:mysql://localhost:3306/Football";
	private static String username = "aligungor";
	private static String password = "1234";
	private static String driver = "com.mysql.jdbc.Driver";

	private Connection connection;
	
	private static DBMySQL dbMysql;

	public static DBMySQL getDBMySQL() {
		if (dbMysql == null) {
			dbMysql = new DBMySQL();
		}
		return dbMysql;
	}
	
	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed())
				Class.forName(driver);
				connection = DriverManager.getConnection(url, username,
						password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
