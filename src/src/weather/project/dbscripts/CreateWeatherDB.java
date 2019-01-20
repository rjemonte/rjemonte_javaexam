package src.weather.project.dbscripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateWeatherDB {
	public static void createNewDatabase(String fileName) {

		String url = "jdbc:sqlite:C:/sqlite/db/" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				System.out.println("Database " + fileName + " has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
