package Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegestrationDAO {

	public boolean register(Regestration r) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "cdacacts");

		String query = "insert into  Regestration values(?,?,?,?) ";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, r.getName());
		ps.setString(2, r.getEmail());
		ps.setString(3, r.getUname());
		ps.setString(4, r.getPwd());

		int num = ps.executeUpdate();

		return num > 0;
	}

	public boolean loginCheck(String user, String pss) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "cdacacts");
		String query = "SELECT uname, pwd FROM Regestration WHERE uname = ? AND pwd = ?";
		boolean isValidUser = false;
		try (PreparedStatement ps = conn.prepareStatement(query)) {
			ps.setString(1, user);
			ps.setString(2, pss);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					isValidUser = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isValidUser;

	}
}
