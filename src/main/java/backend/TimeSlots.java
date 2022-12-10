package backend;

public class TimeSlots {

	private String startTime;
	private String endTime;
	private String centreId;
	private String date;
	
	public TimeSlots() {
		super();
	}

	public TimeSlots(String startTime, String endTime, String centreId, String date) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.centreId = centreId;
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

