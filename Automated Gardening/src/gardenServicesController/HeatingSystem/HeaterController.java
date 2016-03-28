package gardenServicesController.HeatingSystem;

import java.util.Scanner;

import database.Log;
import database.LogDao;
import database.LogDaoImp;
import gardenServicesController.GardenService;
import scheduler.timer.TimeTracker;

public class HeaterController extends GardenService{
	
	int grid;

	Heater heater;
	
	int minutes;
	
	int manual;
	
	String type= "sensor";
	TemperatureSensor tempSensor;

	public HeaterController(int grid , int minutes)
	{
		this.heater = new Heater(grid);
		
		this.minutes=minutes;
		this.tempSensor = new TemperatureSensor();

	}
	
	public HeaterController(int grid , int minutes ,int  manual)
	{
		this.manual=1;
        this.heater = new Heater(grid);
        this.tempSensor = new TemperatureSensor();
		this.minutes=minutes;
	}
	
	public HeaterController(int grid)
	{
		this.heater = new Heater(grid);
		this.tempSensor = new TemperatureSensor();
		this.minutes=20;
	}

	@Override
	public void run() 
	{
		while(true)
		{
		this.provideService();
		
		try {
			Thread.sleep(1000000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	
//		
		
		
		
		
		
		
	}

	@Override
	protected void provideService() {
	
		
		if(manual==1)
		{
			 type="manual";
			 
			 int temp = tempSensor.getTemperature();
				
				
				Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, "Temperature Change Registered" , grid);

				LogDao logdaoend = new LogDaoImp();
				logdaoend.addLog(logend);
				if(tempSensor.getLimit() > temp)
				{       int min=TimeTracker.tickMinutes();
					if(!heater.isTurnedOn())
					{     
						
						Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, "turning on heater " , grid);

						LogDao logdaoend1 = new LogDaoImp();
						logdaoend1.addLog(logend1);

					}
					
					else
					{
						//System.out.println(" Heater is already turned on increasing the temperature of heater");
						Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, "increasing heater temperature" , grid);

						LogDao logdaoend1 = new LogDaoImp();
						logdaoend1.addLog(logend1);
					}
					
					while(TimeTracker.tickMinutes()-min<= minutes)
					{
						
					}
					//System.out.println("turning of heater  at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
						//	+ TimeTracker.getCurrentMinute() + ": minutes");
					Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Scheduled", "turning of heater", 1);

					LogDao logdaoend1 = new LogDaoImp();
					logdaoend1.addLog(logend1);
				  
				}
				else 
				{
					//System.out.println("temperature is good for growing condition");
					Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Sensor", "Temperature is good" , grid);

					LogDao logdaoend1 = new LogDaoImp();
					logdaoend1.addLog(logend1);
					
				}
		}
		
		else 
		{
		int temp = tempSensor.getTemperature();
		
		
		Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Sensor", "Temperature Change Registered" , grid);

		LogDao logdaoend = new LogDaoImp();
		logdaoend.addLog(logend);
		if(tempSensor.getLimit() > temp)
		{       int min=TimeTracker.tickMinutes();
			if(!heater.isTurnedOn())
			{     
				
				Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Sensed temperature drop", "turning on heater " , grid);

				LogDao logdaoend1 = new LogDaoImp();
				logdaoend1.addLog(logend1);

			}
			
			else
			{
				//System.out.println(" Heater is already turned on increasing the temperature of heater");
				Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Sensor", "increasing heater temperature" , grid);

				LogDao logdaoend1 = new LogDaoImp();
				logdaoend1.addLog(logend1);
			}
			
			while(TimeTracker.tickMinutes()-min<= minutes)
			{
				
			}
			//System.out.println("turning of heater  at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
				//	+ TimeTracker.getCurrentMinute() + ": minutes");
			Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Scheduled", "turning of heater", 1);

			LogDao logdaoend1 = new LogDaoImp();
			logdaoend1.addLog(logend1);
		  
		}
		else 
		{
			//System.out.println("temperature is good for growing condition");
			Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Sensor", "Temperature is good" , grid);

			LogDao logdaoend1 = new LogDaoImp();
			logdaoend1.addLog(logend1);
			
		}
		
		}
		
}
		
		

}
