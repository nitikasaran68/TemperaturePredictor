//@authors Nitika Saran 2014068 Ishita Verma 2014051

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class GenerateStats implements Observer{
	
	String loc;
	ArrayList<Double> templist = new ArrayList<Double>();
	
	GenerateStats(String l){
		loc = l;
	}
	
	double mean(){
		double ans=0;
		int l = templist.size();
		for (int i = 0; i<l; i++) {
			ans+=templist.get(i);
		}
		return ans/l;
	}
	
	void stats(){
		//System.out.println("Statistics for weather in " + loc + " are:-");
		System.out.println("Mean temperature in "+loc+": " + mean());
		System.out.println("Min temperature in "+loc+": " + templist.get(0));
		System.out.println("Max temperature in "+loc+": " + templist.get(templist.size()-1));
		int i = templist.size();
		if(i%2==1){
			i =(i+1)/2;
			System.out.println("Median temperature in "+loc+": " + templist.get(i-1));
		}
		else{
			i=i/2;
			double t = (templist.get(i-1) + templist.get(i))/2;
			System.out.println("Median temperature in " +loc+": " +t );
		}
	}
	
	synchronized public void update(Observable o,Object obj){
		//System.out.println("stats called");
		double t = ((TemparatueLog)obj).getTemp();
		int l = templist.size();
		if(l==0){
			templist.add(t);
		}
		else{
			boolean f=false;
			for(int i=0;i<l;i++){
				if(templist.get(i)>=t){
					templist.add(i,t);
					f=true;
					break;
				}
			}
			if(!f)templist.add(t);
			if(templist.size()>100) templist.remove(0);
		}
		if(templist.size()>0)stats();
		
	}
	
	
}
