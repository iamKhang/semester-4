package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class Phong_dao {
	public ArrayList<Phong> getAllPhong(){
		ArrayList<Phong> list = new ArrayList<>();
		Statement st;
		try {
			st = ConnectDB.conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from Phong");
			while(rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int  dienTich = rs.getInt(3);
				String maLoai = rs.getString(4);
				String ghiChu = rs.getString(5);
				
				list.add(new Phong(ma, ten, dienTich, new LoaiPhong(maLoai), ghiChu));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean themPhong(Phong phong) {
		int n = 0;
		
		try {
			PreparedStatement st = ConnectDB.conn.prepareStatement("insert Phong values(?,?,?,?,?)");
			st.setString(1, phong.getMaPhong());
			st.setString(2, phong.getTenPhong());
			st.setInt(3, phong.getDienTich());
			st.setString(4, phong.getLoaiPhong().getMaLoaiPhong());
			st.setString(5, phong.getGhiChu());
			
			n = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	
	public boolean xoaPhong(String maPhong) {
		int n = 0;
		
		try {
			PreparedStatement st = ConnectDB.conn.prepareStatement("delete Phong where maPhong = ?");
			st.setString(1, maPhong);
			
			
			n = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
	
	public boolean suaPhong(String maPhong, Phong phong) {
		int n = 0;
		
		try {
			PreparedStatement st = ConnectDB.conn.prepareStatement("update Phong set tenPhong = ?, dienTich = ?, maLoaiPhong = ?, ghiChu = ? where maPhong = ?");
			
			st.setString(1, phong.getTenPhong());
			st.setInt(2, phong.getDienTich());
			st.setString(3, phong.getLoaiPhong().getMaLoaiPhong());
			st.setString(4, phong.getGhiChu());
			st.setString(5, maPhong);
			
			n = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n>0;
	}
}
