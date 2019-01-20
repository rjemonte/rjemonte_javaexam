package src.weather.weatherclasses;

import java.util.concurrent.atomic.AtomicLong;

public class UniqueID {
	  private static final AtomicLong count = new AtomicLong(0); 
	  private final long uniqueID;
	  private final String cityName;
	  
	  private boolean isFilled;
	  
	  public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public static AtomicLong getCount() {
		return count;
	}

	public long getUniqueID() {
		return uniqueID;
	}

	public String getCityName() {
		return cityName;
	}

	public UniqueID(String title) {
		  cityName = title;
		  isFilled = false;
		  uniqueID = count.incrementAndGet();
	  }
}
