//@authors Nitika Saran 2014068 Ishita Verma 2014051

import java.util.Observable;

public class TemperatureSensor extends  Observable implements Runnable {
	String location;
	
	TemperatureSensor(String l){
		super();
		location = l;
	}
	
	TemparatueLog generate(){
		double temp = Math.random();
		temp = temp * 60;
		return new TemparatueLog(location,temp);
	}
	
	public void run(){
		while (true) {			
			setChanged();
			notifyObservers(generate());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
