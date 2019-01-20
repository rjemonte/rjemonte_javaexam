package src.weather.project.dbscripts;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectUniqueIDData {
	private Connection connect() {
		// SQLite connection string
		String url = "jdbc:sqlite:C://sqlite/db/weather.db";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public long selectUniqueID(Long UID) {
		String sql = "SELECT max(id) FROM weatherlog";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			// loop through the result set
			while (rs.next()) {
				UID = rs.getLong("max(id)");
			}
		} catch (SQLException e) {
			System.out.println("Select Error");
			System.out.println(e.getMessage());
		}
		return UID;
	}

}
