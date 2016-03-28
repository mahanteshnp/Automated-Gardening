package gardenServicesController.HeatingSystem;

/* This class is responsible for generating random temperatures throughout the day every minute
 * and it notifies the heater to turn on based on the limit set.
 */
public class TemperatureSensor {

	private int grid;
	private int temperature;
	private static int limit=15;
	HeaterController heater;

  
	
	public int getTemperature()
	{
		return (int) (10 + (int)(Math.random() * ((40 - 10) + 1)));
	}
	
	public void setLimit(int limit)
	{
		this.limit = limit;
	}

	public int getLimit()
	{
		// TODO Auto-generated method stub
		return limit;
	}

}
