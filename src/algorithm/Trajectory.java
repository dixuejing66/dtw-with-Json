package algorithm;
public class Trajectory {
	public long  timestamp   ;
	public double longitude   ;
	public double latitude    ;
	public Trajectory() {
		
	}
	public Trajectory(long timestamp, double longitude, double latitude) {
		super();
		this.timestamp = timestamp;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	
	public Point[] getPoints() {
		return points;
	}
	public void setPoints(Point[] points) {
		this.points = points;
	}


	public Point[] points;
	
	public int length() {
		return points.length;
	}
	
	
}
