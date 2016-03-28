package gardenServicesController.wateringSystem;

import gardenServicesController.GardenService;
import scheduler.timer.TimeTracker;

public class SprinklerController extends GardenService implements Runnable {

	WaterSprinkler watersprinkler;

	static boolean hasitrained = false;

	public static boolean isHasitrained() {
		return hasitrained;
	}

	public void setHasitrained(boolean hasitrained) {

		this.hasitrained = hasitrained;

		int min = TimeTracker.tickMinutes();

		while (TimeTracker.tickMinutes() - min <= 1440) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.hasitrained = false;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		setHasitrained(true);

	}

	@Override
	protected void provideService() {
		// TODO Auto-generated method stub

	}

}
