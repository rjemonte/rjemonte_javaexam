package src.weather.project.dbscripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertWeatherData {

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

	public void insertIntoWeatherLog(Long id, String responseID, String location, String actualWeather,
			String temperature, String dttimeInserted) {
		String sql = "INSERT INTO weatherlog(id,response_id, location, actualweather, temperature, dtimeinserted) VALUES(?,?,?,?,?,?)";

		try (Connection conn = this.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, id);
			pstmt.setString(2, responseID);
			pstmt.setString(3, location);
			pstmt.setString(4, actualWeather);
			pstmt.setString(5, temperature);
			pstmt.setString(6, dttimeInserted);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
		}
	}

}
