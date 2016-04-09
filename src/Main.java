//@authors Nitika Saran 2014068 Ishita Verma 2014051


public class Main {		
	
	public static void main(String [] args){
		TemperatureSensor delSub = new TemperatureSensor("Delhi");
		TemperatureSensor bomSub = new TemperatureSensor("Mumbai");
		TemperatureSensor calSub = new TemperatureSensor("Kolkata");
		TemperaturePredictor1 delPred1 = new TemperaturePredictor1("Delhi");
		TemperaturePredictor1 calPred1 = new TemperaturePredictor1("Kolkata");
		TemperaturePredictor1 bomPred1 = new TemperaturePredictor1("Mumbai");
		TemperaturePredictor2 delPred2 = new TemperaturePredictor2("Delhi");
		TemperaturePredictor2 calPred2 = new TemperaturePredictor2("Kolkata");
		TemperaturePredictor2 bomPred2 = new TemperaturePredictor2("Mumbai");
		GenerateStats dstats = new GenerateStats("Delhi");
		GenerateStats bstats = new GenerateStats("Mumbai");
		GenerateStats cstats = new GenerateStats("Kolkata");
		SerializeTemperature stemp = new SerializeTemperature("./src/logs.txt");
		delSub.addObserver(delPred1);
		delSub.addObserver(delPred2);
		delSub.addObserver(dstats);
		delSub.addObserver(stemp);
		calSub.addObserver(calPred1);
		calSub.addObserver(calPred2);
		calSub.addObserver(cstats);
		calSub.addObserver(stemp);
		bomSub.addObserver(bomPred1);
		bomSub.addObserver(bomPred2);
		bomSub.addObserver(bstats);
		bomSub.addObserver(stemp);
		(new Thread(delSub)).start();
		(new Thread(bomSub)).start();
		(new Thread(calSub)).start();
	}

}
