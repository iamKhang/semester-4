package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection conn;
	
	public static void connect() {
		String user = "sa";
		String pass = "sapassword";
		String path = "jdbc:sqlserver://localhost:1433;databasename=QLPhong";
		
		try {
			conn = DriverManager.getConnection(path, user, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void disconnect() {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
