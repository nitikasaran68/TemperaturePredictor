//@authors Nitika Saran 2014068 Ishita Verma 2014051


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TemperaturePredictor1 implements Observer{
	
	String location;
	ArrayList<Double> latest = new ArrayList<Double>();
	
	TemperaturePredictor1(String l){
		location = l;
	}
	
	
	synchronized public void update(Observable o,Object arg){
		double d = ((TemparatueLog)arg).getTemp();
		if(latest.size()>=5){
			latest.remove(0);
			latest.add(d);
		}
		else{
			latest.add(d);
		}
		System.out.println("Weather Prediction for " +location+ " by first predictor is " + predict());
	}
	
	double predict(){
		double ans = 0;
		int l= latest.size();
		if(l>0){
			for (int i = 0; i < l; i++) {
				ans+= latest.get(i);
			}
			return ans/l;
		}
		return -1;
	}
	
	
}
