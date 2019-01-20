package src.weather.weater.response;

import java.io.BufferedInputStream;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import src.weather.project.dbscripts.InsertWeatherData;
import src.weather.project.dbscripts.SelectUniqueIDData;
import src.weather.weatherclasses.*;

public class weatherResponse {

	public static void WSWeatherResponse(HttpURLConnection conn, String city, String country) {
		String locRec = city + "," + country;
		String responseID = UUID.randomUUID().toString();
		UniqueID UID = new UniqueID(city);
		Date date = new Date();
		String strDateFormat = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		Long newIdValue;

		try {
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String result = IOUtils.toString(in, "UTF-8");
			System.out.println("JSON Response for Location:" + locRec + " After sending request");
			JSONObject WSResponse = new JSONObject(result);
			JSONObject WSResponseChildObj = (JSONObject) WSResponse.get("main");
			String actualWeatherVal = WSResponse.getJSONArray("weather").toString();
			String temperature = WSResponseChildObj.toString();
			InsertWeatherData insData = new InsertWeatherData();
			SelectUniqueIDData selectMaxID = new SelectUniqueIDData();
			System.out.println(result);

			newIdValue = selectMaxID.selectUniqueID(UID.getUniqueID());
			newIdValue++;
			insData.insertIntoWeatherLog(newIdValue, responseID, locRec, actualWeatherVal, temperature, formattedDate);

			in.close();
			conn.disconnect();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
