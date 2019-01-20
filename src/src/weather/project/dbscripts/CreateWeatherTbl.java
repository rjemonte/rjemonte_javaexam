package src.weather.project.dbscripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateWeatherTbl {
	public static void createNewTable() {
		// SQLite connection string
		String url = "jdbc:sqlite:C://sqlite/db/weather.db";

		// SQL statement for creating a new table
		String sql = "CREATE TABLE IF NOT EXISTS weatherlog  (\n" + "	id integer PRIMARY KEY AUTOINCREMENT,\n"
				+ "	response_id text UNIQUE NOT NULL,\n" + "	location text,\n" + " actualweather text,\n"
				+ " temperature text,\n" + " dtimeinserted text \n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			// create a new table
			stmt.execute(sql);
			System.out.println("Table WeatherLog is Created\n");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
