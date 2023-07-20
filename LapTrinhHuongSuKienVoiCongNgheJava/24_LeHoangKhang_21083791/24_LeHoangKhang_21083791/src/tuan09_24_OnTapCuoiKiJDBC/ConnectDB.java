package tuan09_24_OnTapCuoiKiJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
	public static Connection conn;
	
	public static void connect() {
		try {
			String path = "jdbc:sqlserver://localhost:1433;databasename=QLyVDV";
			String user = "sa";
			String pass = "sapassword";
			conn = DriverManager.getConnection(path, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnect() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}