//@authors Nitika Saran 2014068 Ishita Verma 2014051


import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TemperaturePredictor2 implements Observer{
	
	String location;
	ArrayList<Double> latest = new ArrayList<Double>();
	
	TemperaturePredictor2(String l){
		location = l;
	}
	
	
	synchronized public void update(Observable o,Object arg){
		double d = ((TemparatueLog)arg).getTemp();
		if(latest.size()>=6){
			latest.remove(0);
			latest.add(d);
		}
		else{
			latest.add(d);
		}
		double ans=predict();
		if(ans!=-1)System.out.println("Weather Prediction for " +location+ " by second predictor is " + ans);
	}
	
	double predict(){
		double ans = 0;
		int l= latest.size();
		if(l==1) return latest.get(0);
		if(l>1){
			for (int i = 1; i < l; i++) {
				ans+= latest.get(i)-latest.get(i-1);
			}
			ans = ans/(l-1);
			//System.out.println("Mean difference is "+ ans);
			return latest.get(l-1)+ans;
		}
		return -1;
	}
	
	
}
