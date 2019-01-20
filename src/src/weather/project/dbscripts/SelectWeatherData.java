package src.weather.project.dbscripts;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectWeatherData {
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

	public void selectWeatherData() {
		String sql = "SELECT id, response_id, location, actualweather, temperature, dtimeinserted FROM weatherlog";

		try (Connection conn = this.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\nSuccessfully Selected Records from WeatherLog Table:");
			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getLong("id") + "\t" + rs.getString("response_id") + "\t"
						+ rs.getString("location") + "\t" + rs.getString("actualweather") + "\t"
						+ rs.getString("temperature") + "\t" + rs.getString("dtimeinserted"));
			}
		} catch (SQLException e) {
			System.out.println("Select Error");
			System.out.println(e.getMessage());
		}
	}
}
