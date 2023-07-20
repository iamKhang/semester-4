package tuan09_24_OnTapCuoiKiJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class VanDongVien_dao {
	public ArrayList<VanDongVien> getAll() {
		ArrayList<VanDongVien> list = new ArrayList<>();

		try {
			Statement st = ConnectDB.conn.createStatement();
			ResultSet rs = st.executeQuery("select * from VanDongVien");

			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				int tuoi = rs.getInt(3);
				String maCLB = rs.getString(4);

				list.add(new VanDongVien(ma, ten, tuoi, new CauLacBo(maCLB)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean xoa(String maVDV) {
		int n = 0;

		try {
			PreparedStatement st = ConnectDB.conn.prepareStatement("delete from VanDongVien where MaVDV = ?");
			st.setString(1, maVDV);
			n = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean them(VanDongVien vdv) {
		int n = 0;

		try {
			PreparedStatement st = ConnectDB.conn.prepareStatement("insert VanDongVien values(?, ?, ?, ?)");
			st.setString(1, vdv.getMaVDV());
			st.setString(2, vdv.getTenVDV());
			st.setInt(3, vdv.getTuoi());
			st.setString(4, vdv.getClb().getMaCLB());

			n = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return n > 0;
	}

	public boolean sua(String maVDV, VanDongVien vdv) {
		int n = 0;

		try {
			PreparedStatement st = ConnectDB.conn
					.prepareStatement("update VanDongVien set TenVDV = ?, Tuoi = ?, MaCLB = ? where MaVDV = ?");
			st.setString(1, vdv.getTenVDV());
			st.setInt(2, vdv.getTuoi());
			st.setString(3, vdv.getClb().getMaCLB());
			st.setString(4, maVDV);

			n = st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return n > 0;
	}
}
