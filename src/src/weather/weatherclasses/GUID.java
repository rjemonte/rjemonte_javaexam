package src.weather.weatherclasses;

import java.util.UUID;

public class GUID {

	String GUID = UUID.randomUUID().toString();

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String gUID) {
		GUID = gUID;
	}
	
}
