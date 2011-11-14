/**
 * This class represents a certain date together with a certain time of day.
 * A date consists of day, month and year. A time is modeled by hour and minute. 
 * @author Karlsruhe Institute of Technology, IPD Pretschner/Snelting
 * @author Forever Alone Guy
 *
 */
public class Timestamp {
	
	/** the day of the represented date */
	private int day;
	
	/** the month of the represented date */
	private int month;
	
	/** the year of the represented date */
	private int year;
	
	/** the hour of the represented time of day */
	private int hour;
	
	/** the minute of the represented time of day */
	private int min;

	/**
	 * @return the day of the represented date
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @return the month of the represented date
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @return the year of the represented date
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @return the hour of the represented date
	 */
	public int getHour() {
		return hour;
	}

	/**
	 * @return the minute of the represented date
	 */
	public int getMinute() {
		return min;
	}

	/**
	 * Constructs a new timestamp instance with the given properties
	 * @param min the minute to set for the timestamp instance
	 * @param hour the hour to set for the timestamp instance
	 * @param day the day to set for the timestamp instance
	 * @param month the month to set for the timestamp instance
	 * @param year the year to set for the timestamp instance
	 */
	public Timestamp(int min, int hour, int day, int month, int year) {
		this.min = min;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * @return a short description of this timestamp instance
	 */
	public String toString() {
		return this.getYear() + "-" + this.getMonth() + "-" + this.getDay() + " "
				+ this.getHour() + ":" + this.getMinute();
	}


	
}
