//@authors Nitika Saran 2014068 Ishita Verma 2014051

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class SerializeTemperature implements Observer{
	String filename;
	private ArrayList<TemparatueLog> pending = new ArrayList<TemparatueLog>();
	int done=0;
	
	SerializeTemperature(String f){
		filename = f;
	}
	
	synchronized public void update(Observable o, Object obj){
		pending.add((TemparatueLog)obj);
		try {
			write_to_file();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void write_to_file() throws IOException{
		FileWriter fileWritter = new FileWriter(filename,true);
        BufferedWriter bu = new BufferedWriter(fileWritter);
        int l=pending.size();
        for (int i = 0; i < l; i++) {
        	bu.write(pending.get(i).getLocation());
        	bu.write(", ");        	
        	bu.write(Double.toString(pending.get(i).getTemp()));
        	bu.write("\n");
        	pending.remove(i);
        	done++;
        }
        bu.close();
	}
	
}
