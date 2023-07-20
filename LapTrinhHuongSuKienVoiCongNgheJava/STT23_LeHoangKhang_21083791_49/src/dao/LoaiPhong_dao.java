package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.LoaiPhong;

public class LoaiPhong_dao {
	public ArrayList<LoaiPhong> getAllLoaiPhong(){
		ArrayList<LoaiPhong> list = new ArrayList<>();
		Statement st;
		try {
			st = ConnectDB.conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from LoaiPhong");
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				list.add(new LoaiPhong(ma, ten));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
