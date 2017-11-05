package Training;

public class Datum {
	private int day;
	private int month;
	private int year;
	
	private String time;
	
	public Datum(int day , int month , int year , String time  ) {
		
		this.day = day;
		this.month = month;
		this.year = year;
		this.time = time;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Datum [day=" + day + ", month=" + month + ", year=" + year + ", time=" + time + "]";
	}
	
}
