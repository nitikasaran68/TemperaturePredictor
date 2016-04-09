# Temperature Predictor
 
This is a multithreaded system following Observer pattern. It has the following subjects and observers:

* <b>TemperatureSensor</b> is a subject that logs temperature values every 5 seconds at 3 different
locations. We simply generate random temperature values every 5 seconds at these 3
locations and maintain in a TemperatureLog object.
	
	* TemperatureLog is a class that takes temperature and locations as it’s constructor
	arguments and implements getters and setters for the same. Eg. new
	TemperatureLog(36,”Delhi”);
	So the observer is updated with the TemperatureLog.

Since the data is being logged simultaneously at all three locations(say Delhi, Mumbai,
Srinagar) we make use of different threads handling the temperature generator for
each of the location.
At the start of the system we assume the initial values are 35 degrees for all the three locations.
For the given subject we have four types of observers:

* <b>SerializeTemperature</b> is an observer that on receiving the data i.e the TemperatureLog
object serializes it to a file.

* <b>TemperaturePredictor1</b> is the observer that receives the data from the TemperatureSensor
and predicts the likely temperature at all three locations in the next 5 seconds and displays.
	* We use a basic sliding window based prediction algorithm that takes the latest
	5 values returns the average of them as the predicted temperature.

* <b>TemperaturePredictor2</b> is another observer that receives the data from the
TemperatureSensor and predicts the likely temperature at all three locations in the next 5
seconds and displays. For this observer, we use a predictor that checks the differences between consecutive temperature logs for last 5 times, and adds average difference to last observed temperature.

* <b>GenerateStats</b> is the observer that on receiving the data returns/displays the following
statistics for every location for the last 100 records:

	* Mean Temperature
	* Median Temperature
	* Maximum Temperature
	* Minimum Temperature