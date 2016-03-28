package gardenServicesController;

import java.util.Random;

import database.Log;
import database.LogDao;
import database.LogDaoImp;
import gardenServicesController.HeatingSystem.HeaterController;
import gardenServicesController.pesticideControlSystem.PesticideSprinkler;
import gardenServicesController.wateringSystem.SprinklerController;
import scheduler.timer.TimeTracker;

public class RandomEventGenerator implements Runnable {

	
	   
	@Override
	public void run() {

		while (true) {
			Random obj1= new Random();
			int randomEvent = obj1.nextInt(4-1)+1;
			Random obj= new Random();
			int r=obj.nextInt(1016000- 500000) + 500000;
			//int r=obj.nextInt(10160000- 50000) + 50000;
			
			try {
				Thread.sleep(r);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (randomEvent) {

			case 1:
				//System.out.println("Pesticide attack");
				Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "System",
						"information about Pest Attack", 0);
				LogDao logdaostart = new LogDaoImp();
				logdaostart.addLog(logstart);
				new Thread(new PesticideSprinkler(0)).start();
				break;

			case 2:
				System.out.println("It started raining cancelling the schedule for 24 hours");
                new SprinklerController().setHasitrained(true);
				Log logstart1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "System", "information about rain",
						0);
				LogDao logdaostart1 = new LogDaoImp();
				logdaostart1.addLog(logstart1);
				break;

			case 3:
				//int random = (int) (Math.random() * 3);
				Random obj11= new Random();
				int randomEvent1 = obj11.nextInt(4-1)+1;
			
				new Thread(new HeaterController(randomEvent1)).start();
      			break;
      			
			default: break;

			}
			
		
			
		}
	}

}
