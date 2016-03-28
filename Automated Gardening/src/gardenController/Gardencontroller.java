package gardenController;

import java.util.Calendar;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import database.Log;
import database.LogDao;
import database.LogDaoImp;
import garden.Garden;
import gardenServicesController.GardenService;
import gardenServicesController.RandomEventGenerator;
import gardenServicesController.HeatingSystem.HeaterController;
import gardenServicesController.fertilizer.PHLevelController;
import gardenServicesController.pesticideControlSystem.PesticideSprinkler;
import gardenServicesController.wateringSystem.WaterSprinkler;
import scheduler.GrowingPlan;
import scheduler.GrowingPlan.DayHour;
import scheduler.timer.TimeTracker;

public class Gardencontroller {

	public static Calendar now;
	private GrowingPlan Fruit = new GrowingPlan(3);
	private GrowingPlan Flower = new GrowingPlan(1);
	private GrowingPlan Vegetable = new GrowingPlan(2);
	DayHour dhr;
	public static String username="";
	public static String Password="";
	
	public static void main(String[] args) {
		boolean set=false;
		Gardencontroller garden = new Gardencontroller();
		while(!set)
		{
			System.out.println("Enter the Username for MySQL server");
			Scanner scanning= new Scanner(System.in);
			 Gardencontroller.username= scanning.next();
			set=true;
		System.out.println("Enter the MySQL Password");
		
		 Gardencontroller.Password= scanning.next();
		set=true;
		}
				
		
		System.out.println("Choose if you want to delete existing logs");
		System.out.println("1: to delete");
		System.out.println("2 : to continue without deleting");
		
		Scanner scanner = new Scanner(System.in);
		
		int del= scanner.nextInt();
		
		switch (del)
		{
		case 1: LogDaoImp log= new LogDaoImp();
		log.deleteLogs();
		break;
		
		case 2: System.out.println("logs have not been deleted");
		        break;
		
		default: System.out.println("logs have not been deleted");
			break;
		}
				
		
		

		
		now = Calendar.getInstance();
		Garden.addPlants("Rose", 1);
		Garden.addPlants("Carrot", 2);
		Garden.addPlants("Mango", 3);
		
		garden.Fruit.new DayHour(1, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(1, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(2, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(2, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(3, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(3, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(4, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(4, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(5, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(5, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(6, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(6, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(7, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(7, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(8, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(8, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(9, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(9, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(10, 6, 0, 0, new WaterSprinkler(2, 1));
		garden.Fruit.new DayHour(10, 18, 0, 0, new WaterSprinkler(2, 1));
		garden.Vegetable.new DayHour(1, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(1, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(2, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(2, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(3, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(3, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(4, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(4, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(5, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(5, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(6, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(6, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(7, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(7, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(8, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(8, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(9, 7, 0, 0, new WaterSprinkler(1, 1));
		garden.Vegetable.new DayHour(9, 19, 0, 0, new WaterSprinkler(1, 1));
		garden.Flower.new DayHour(1, 9, 0, 0, new WaterSprinkler(1, 5));
		garden.Flower.new DayHour(1, 18, 0, 0, new WaterSprinkler(1, 5));
		garden.Flower.new DayHour(2, 9, 0, 0, new WaterSprinkler(1, 5));
		garden.Flower.new DayHour(2, 18, 0, 0, new WaterSprinkler(1, 5));
	
		
		
		new Thread(new Runnable() {

			public void run() {
				while (true) {
					TimeTracker.tickSeconds();
					now.add(Calendar.SECOND, 1);
					new Thread(new Runnable() {

						@Override
						public void run() {

							int hour = TimeTracker.getCurrentHour();
							int minute = TimeTracker.getCurrentMinute();
							int seconds = TimeTracker.getCurrentSecond();
							int day = TimeTracker.getDay();

							if (garden.Fruit.getMapServicesToHours()
									.containsKey(garden.Fruit.new DayHour(day, hour, minute, seconds))) {

								ExecutorService executor = Executors.newFixedThreadPool(4);

								for (GardenService gs : garden.Fruit.getMapServicesToHours()
										.get(garden.Fruit.new DayHour(day, hour, minute, seconds))) {

									executor.execute(gs);

								}
								executor.shutdown();

							}

							if (garden.Flower.getMapServicesToHours()
									.containsKey(garden.Flower.new DayHour(day, hour, minute, seconds))) {

								ExecutorService executor = Executors.newFixedThreadPool(4);

								for (GardenService gs : garden.Flower.getMapServicesToHours()
										.get(garden.Flower.new DayHour(day, hour, minute, seconds))) {

									executor.execute(gs);

								}
								executor.shutdown();

							}
							if (garden.Vegetable.getMapServicesToHours()
									.containsKey(garden.Vegetable.new DayHour(day, hour, minute, seconds))) {

								ExecutorService executor = Executors.newFixedThreadPool(6);

								for (GardenService gs : garden.Vegetable.getMapServicesToHours()
										.get(garden.Vegetable.new DayHour(day, hour, minute, seconds))) {

									executor.execute(gs);

								}
								executor.shutdown();

							}
						}

					}).start();

					try {

						Thread.sleep((long) (1000 / 60));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}).start();
    
//	new Thread(new Runnable(){ 
//			public void run()
//	       {
//		while (true) {
//			
//			new Thread(new HeaterController(0)).start();
//		      }
//	       }
//	}).start();
	
	new Thread(new RandomEventGenerator()).start();

		while (true) {

			System.out.println("Select one of the options below");
			System.out.println("1 : add a plant");
			System.out.println("2 : for queriying the log from database");
			System.out.println("3 : to Start a service");
			System.out.println("4 : for scheduling a service");
			System.out.println("5 : get current day and time");
			//System.out.println("5 : to check the growing plan");
		
			Scanner scan = new Scanner(System.in);
			int selection = scan.nextInt();

			switch (selection) {

			case 1:System.out.println("Choose the type of the plant");
			       System.out.println("1: for FlowerPlants");
			       System.out.println("2 : for VegetablePlants");
			       System.out.println("3 : for FruitPlants");
			       int plant = scan.nextInt();
			       
			       while(plant>3)
			       {System.out.println("Choose the type of the plant");
			       System.out.println("1: for FlowerPlants");
			       System.out.println("2 : for VegetablePlants");
			       System.out.println("3 : for FruitPlants");
			    	   plant=scan.nextInt();
			    	   
			       }
			       System.out.println("enter the name of plant to add");
			       String name=scan.next();
			       Garden.addPlants(name, plant);
			       
			       
				break;

			case 2:
				System.out.println("choose the date of logs");
				System.out.println("1: to select all the logs");
				System.out.println("2: to select based on the date");

				int query = scan.nextInt();
				switch (query) {
				case 1:
					System.out.println("enter the file name to save the logs in");

					String file = scan.next();
					LogDao log1 = new LogDaoImp();
					log1.getAllLogs(file+".csv");
					System.out.println("logs uploaded to text file" + file);
					break;

				case 2:
					System.out.println("enter the day ");
					int dayLog = scan.nextInt();
					System.out.println("enter the file name");
					String fileLog = scan.next();
					LogDao logs = new LogDaoImp();
					logs.getLogs(fileLog + ".csv", 1);
					break;
				}
				break;

			case 3: System.out.println("Chose the type of plants to service ");
			       System.out.println("1 : for FlowerPlants");
			       System.out.println("2 : for VegetablePlants");
			       System.out.println("3: for FruitPlants");
			         int grid = scan.nextInt();
				
				System.out.println("Choose the service you want to start");
				System.out.println("press 1 for waterSprinkler");
				System.out.println("press 2 for HeaterController");
				System.out.println("press 3 for PesticideSprinkler");
				System.out.println("press 4 for PHlevelController");
				int val= scan.nextInt();
				switch (val) {
				case 1:
					new Thread(new WaterSprinkler(grid, 20,1));
					System.out.println("started Sprinkler check logs for update");
					break;
				case 2:
					new Thread(new HeaterController(grid, 20,1));
					System.out.println("started Heater check logs for update");
					break;
				case 3:
					new Thread(new PesticideSprinkler(grid, 20,1));
					System.out.println("started PesticideSPrinkler check logs for update");
					break;
				case 4:
					new Thread(new PHLevelController(grid, 20,1));
					System.out.println("started PHlevelController check logs for update");
					break;

				}
				break;

			case 4: System.out.println("curent date and time is ");
			           System.out.println("day is  "+TimeTracker.getDay());
			        System.out.print("time is : "); TimeTracker.getCurrentTime();
			       System.out.println();
			       System.out.println("choose the day and time after that");
				System.out.println("enter the day you want schdule a service between 0 and 30");

				int day = scan.nextInt();

				if (day > 30) {
					System.out.println("enter a day less then or equal to 30");
					continue;
				}
				System.out.println("enter the hour to consume service in 24 hour format ");
				int hour = scan.nextInt();
				if (hour >= 24) {
					System.out.println("enter a hour less then 24");
					continue;
				}
				System.out.println("enter the minute to consume service ");
				int min = scan.nextInt();
				if (min > 59) {
					System.out.println("enter a minute less then 60");
					continue;
				}

				System.out.println("Choose the type of plants ");
				System.out.println("1 : for FlowerPlants");
				System.out.println("2 : for VegetablePlants");
				System.out.println("3: for FruitPlants");
				int type = scan.nextInt();

				switch (type) {
				case 1:
					
					System.out.println("Choose the service you want to add");
					System.out.println("press 1 for SPrinkler");
					System.out.println("press 2 for HeaterController");
					System.out.println("press 3 for PesticideSprinkler");
					System.out.println("press 4 for PHlevelController");

					int serviceId = scan.nextInt();

					switch (serviceId) {
					case 1:
						garden.Flower.new DayHour(day, hour, min, 0, new WaterSprinkler(type, 20));

						break;

					case 2:
						garden.Flower.new DayHour(day, hour, min, 0, new HeaterController(type, 20));
						break;

					case 3:
						garden.Flower.new DayHour(day, hour, min, 0, new PesticideSprinkler(type, 20));
						break;

					case 4:
						garden.Flower.new DayHour(day, hour, min, 0, new PHLevelController(type, 20));
						break;

					default:
						System.out.println("Chosen service is not available");
						continue;

					}
					break;

				case 2:
					System.out.println("Choose the service you want to add");
					System.out.println("press 1 for SPrinkler");
					System.out.println("press 2 for HeaterController");
					System.out.println("press 3 for PesticideSprinkler");
					System.out.println("press 4 for PHlevelController");

					int serviceId1 = scan.nextInt();

					switch (serviceId1) {
					case 1:
						garden.Vegetable.new DayHour(day, hour, min, 0, new WaterSprinkler(type, 20));

						break;

					case 2:
						garden.Vegetable.new DayHour(day, hour, min, 0, new HeaterController(type, 20));
						break;

					case 3:
						garden.Vegetable.new DayHour(day, hour, min, 0, new PesticideSprinkler(type, 20));
						break;

					case 4:
						garden.Vegetable.new DayHour(day, hour, min, 0, new PesticideSprinkler(type, 20));
						break;

					default:
						System.out.println("Chosen service is not available");
						continue;

					}
					break;

				case 3:
					System.out.println("Choose the service you want to add");
					System.out.println("press 1 for SPrinkler");
					System.out.println("press 2 for HeaterController");
					System.out.println("press 3 for PesticideSprinkler");
					System.out.println("press 4 for PHlevelController");

					int serviceId11 = scan.nextInt();

					switch (serviceId11) {
					case 1:
						garden.Fruit.new DayHour(day, hour, min, 0, new WaterSprinkler(type, 20));

						break;

					case 2:
						garden.Fruit.new DayHour(day, hour, min, 0, new HeaterController(type, 20));
						break;

					case 3:
						garden.Fruit.new DayHour(day, hour, min, 0, new PesticideSprinkler(type, 20));
						break;

					case 4:
						garden.Fruit.new DayHour(day, hour, min, 0, new PesticideSprinkler(type, 20));
						break;

					default:
						System.out.println("Chosen service is not available");
						continue;

					}
					break;

				}
			case 5: System.out.println("day is "+ TimeTracker.getDay());
			        System.out.print("Time  is  : ");
				TimeTracker.getCurrentTime();
				break;

			case 6:
				break;
			}

		}

		

	}
}
