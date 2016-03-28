package gardenServicesController.fertilizer;

import database.Log;
import database.LogDao;
import database.LogDaoImp;
import gardenServicesController.GardenService;
import scheduler.timer.TimeTracker;

public class PHLevelController extends GardenService {

	private int minute;
	private int grid;
	private int manual;

	public PHLevelController(int grid, int min, int manual) {
		this.grid = grid;
		this.minute = 20;
		this.manual = manual;
	}

	public PHLevelController() {

		this.minute = 20;
	}

	public PHLevelController(int grid) {
		this.grid = grid;
		this.minute = 20;
	}

	public PHLevelController(int grid, int minutes) {
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

		if (manual == 1) {
			int min = TimeTracker.tickMinutes();
			System.out.println("Increasing the PHlevel of water");

			Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "manual",
					"Increasing the PHlevel of water", 1);
			LogDao logdaostart = new LogDaoImp();
			logdaostart.addLog(logstart);

			while (TimeTracker.tickMinutes() - min <= minute) {

			}
			Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "PH level increased",
					"Stopping the mineral addition ", 1);

			LogDao logdaoend = new LogDaoImp();
			logdaoend.addLog(logend);

		} else {
			int min = TimeTracker.tickMinutes();
			System.out.println("Increasing the PHlevel of water");

			Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "drop in Ph levelk",
					"Increasing the PHlevel of water", 1);
			LogDao logdaostart = new LogDaoImp();
			logdaostart.addLog(logstart);

			while (TimeTracker.tickMinutes() - min <= minute) {

			}
			Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "PH level increased",
					"Stopping the mineral addition ", 1);

			LogDao logdaoend = new LogDaoImp();
			logdaoend.addLog(logend);
		}

	}

}
