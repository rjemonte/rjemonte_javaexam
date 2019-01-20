package src.weather.project.request;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import src.weather.weatherclasses.Location;
import src.weather.weater.response.weatherResponse;

public class weatherRequest {

	public static void WSWeatherRequest(Location location) {

		String city = location.getCity();
		String country = location.getCountry();
		String appID = "5fa7571c03889c663963c41593c4124d";

		try {

			URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country
					+ "&mode=json&APPID=" + appID);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			OutputStream os = conn.getOutputStream();
			os.close();
			// read the response
			weatherResponse.WSWeatherResponse(conn, city, country);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
