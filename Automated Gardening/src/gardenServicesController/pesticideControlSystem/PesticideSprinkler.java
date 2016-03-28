package gardenServicesController.pesticideControlSystem;

import database.Log;
import database.LogDao;
import database.LogDaoImp;
import gardenServicesController.GardenService;
import scheduler.timer.TimeTracker;

public class PesticideSprinkler extends GardenService {

	private int minute;
	private int grid;
	int manual;
	
	public PesticideSprinkler(int grid , int min , int manual)
	{
		this.grid=grid;
		this.minute=min;
		this.manual=manual;
		
	}
	
public PesticideSprinkler() {
		
		this.minute = 20;
	}

	public PesticideSprinkler(int grid) {
		this.grid = grid;
		this.minute = 20;
	}
	
	

	public PesticideSprinkler(int grid, int minutes) {
		this.grid = grid;
		this.minute = minutes;
	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		this.provideService();

	}

	@Override
	protected void provideService() {
		// TODO Auto-generated method stub
		
		
		if(manual==1)
		{
			int min = TimeTracker.tickMinutes();
			//System.out.println("turning on the PesticideSprinkler");

			Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "manual",
					" Turning on Pesticide Sprinkler", 1);
			LogDao logdaostart = new LogDaoImp();
			logdaostart.addLog(logstart);

			while (TimeTracker.tickMinutes() - min <= minute) {

			}
			Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Scheduled",
					"Turning off Pesticide Sprinkler", grid);

			LogDao logdaoend = new LogDaoImp();
			logdaoend.addLog(logend);
		}
		else
		{
		int min = TimeTracker.tickMinutes();
		//System.out.println("turning on the PesticideSprinkler");

		Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Reaction to Pest Attack",
				" Turning on Pesticide Sprinkler", 1);
		LogDao logdaostart = new LogDaoImp();
		logdaostart.addLog(logstart);

		while (TimeTracker.tickMinutes() - min <= minute) {

		}
		Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Scheduled",
				"Turning off Pesticide Sprinkler", grid);

		LogDao logdaoend = new LogDaoImp();
		logdaoend.addLog(logend);
		}

	}

}
