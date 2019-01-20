package src.weather.project.main;

import src.weather.weatherclasses.Location;
import src.weather.project.dbscripts.CreateWeatherDB;
import src.weather.project.dbscripts.CreateWeatherTbl;
import src.weather.project.dbscripts.SelectWeatherData;
import src.weather.project.request.weatherRequest;

public class Main {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CreateWeatherDB.createNewDatabase("weather.db");
			CreateWeatherTbl.createNewTable();
			SelectWeatherData sel = new SelectWeatherData();
			Location SFO = new Location("San Francisco", "US");
			Location London = new Location("London", "UK");
			Location Prague = new Location("Prague", "CZ");

			weatherRequest.WSWeatherRequest(SFO);
			weatherRequest.WSWeatherRequest(London);
			weatherRequest.WSWeatherRequest(Prague);

			sel.selectWeatherData();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
