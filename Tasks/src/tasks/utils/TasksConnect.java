package tasks.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TasksConnect {
	public static Connection con = null;

	public static Connection connect() {
		String url = "jdbc:postgresql://localhost:5432/JavaTasks"; 
		String user = "postgres"; 
		String password = "pokemon";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close() {
		
	}
}
