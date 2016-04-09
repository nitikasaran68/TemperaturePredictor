//@authors Nitika Saran 2014068 Ishita Verma 2014051

public class TemparatueLog {
	private String location;
	private double temp;
	
	TemparatueLog(String l,double t){
		temp = t;
		location = l;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
}
