package tuan09_24_OnTapCuoiKiJDBC;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CauLacBo_dao {
	public ArrayList<CauLacBo> getAll() {
		ArrayList<CauLacBo> list = new ArrayList<CauLacBo>();

		try {
			Statement st = ConnectDB.conn.createStatement();
			ResultSet rs = st.executeQuery("select * from CauLacBo");

			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);

				list.add(new CauLacBo(ma, ten));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
