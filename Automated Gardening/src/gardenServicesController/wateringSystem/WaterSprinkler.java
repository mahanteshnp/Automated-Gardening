package gardenServicesController.wateringSystem;


import java.sql.*;
import java.io.*;
import java.util.*;

import database.Log;
import database.LogDao;

import database.LogDaoImp;
import gardenController.Gardencontroller;
import gardenServicesController.GardenService;
import gardenServicesController.HeatingSystem.Heater;
import scheduler.timer.TimeTracker;

public class WaterSprinkler extends GardenService {

	private int grid;
	private int minutes;
	private int manual;
	private String type;
	
	public WaterSprinkler()
	{
		
		this.minutes=20;
	}
	
	public WaterSprinkler(int grid) {
		this.grid = grid;
		this.minutes=20;
	}

	public WaterSprinkler(int grid , int minutes) {
		this.grid = grid;
		this.minutes=minutes;
	}
	public WaterSprinkler(int grid , int minutes ,int  manual)
	{
		this.manual=1;
 
		this.grid=grid;
		this.minutes=minutes;
	}
	
	@Override
	protected void provideService() {
		
		if(manual==1)
		{
			type="manual";
			
			if(SprinklerController.hasitrained)
			{
				System.out.println("It has rained in the last 24 do you still want to water");
				
				
				Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "sensor ", "warning" , grid);

				LogDao logdaostart = new LogDaoImp();
				logdaostart.addLog(logstart);
				
				System.out.println("enter 1: continue");
				System.out.println("enter 2: discontinue");
				
				Scanner scan = new Scanner(System.in);
				int val=scan.nextInt();
				
				switch (val)
				{
				case 1:String action = null;
				switch (grid) {
				case 1:
					action = "Sprinkling the Flower plants";
					break;

				case 2:
					action = "Sprinkling the vegetable plants";
					break;

				case 3:
					action = "Sprinkling the Fruit plants ";
					break;

				default:
					System.out.println(" please select one of the three 1,2,3");
					break;

				}
		          int min=TimeTracker.tickMinutes();
//				System.out.println(action + " at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
//						+ TimeTracker.getCurrentMinute() + ": minutes");

				Log logstart1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, action, grid);

				LogDao logdaostart1 = new LogDaoImp();
				logdaostart1.addLog(logstart1);
				
				while(TimeTracker.tickMinutes()-min<= minutes)
				{
					
				}
				String finish = null;
				switch (grid) {
				case 1:
					finish = "stopped the Sprinkler for Flower plants";
					break;

				case 2:
					finish= "stopped the Sprinkler for vegetable plants";
					break;

				case 3:
					finish= "Sstopped the Sprinkler for Fruit plants ";
					break;

				default:
					System.out.println(" please select one of the three 1,2,3");
					break;

				}
//				System.out.println(finish + " at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
//						+ TimeTracker.getCurrentMinute() + ": minutes");
				Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, finish, grid);

				LogDao logdaoend = new LogDaoImp();
				logdaoend.addLog(logend);
					
					
					
					
					
					break;
					
				case 2: 
				Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type,"User Decided against turning on Sprinkler", grid);

				LogDao logdaoend1 = new LogDaoImp();
				logdaoend1.addLog(logend1);
					
					break;
				}
				
			}
			
			else
			{

			String action = null;
			switch (grid) {
			case 1:
				action = "Sprinkling the Flower plants";
				break;

			case 2:
				action = "Sprinkling the vegetable plants";
				break;

			case 3:
				action = "Sprinkling the Fruit plants ";
				break;

			default:
				System.out.println(" please select one of the three 1,2,3");
				break;

			}
	          int min=TimeTracker.tickMinutes();
			System.out.println(action + " at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
					+ TimeTracker.getCurrentMinute() + ": minutes");

			Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, action, grid);

			LogDao logdaostart = new LogDaoImp();
			logdaostart.addLog(logstart);
			
			while(TimeTracker.tickMinutes()-min<= minutes)
			{
				
			}
			String finish = null;
			switch (grid) {
			case 1:
				finish = "stopped the Sprinkler for Flower plants";
				break;

			case 2:
				finish= "stopped the Sprinkler for vegetable plants";
				break;

			case 3:
				finish= "Sstopped the Sprinkler for Fruit plants ";
				break;

			default:
				System.out.println(" please select one of the three 1,2,3");
				break;

			}
//			System.out.println(finish + " at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
//					+ TimeTracker.getCurrentMinute() + ": minutes");
			Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), type, finish, grid);

			LogDao logdaoend = new LogDaoImp();
			logdaoend.addLog(logend);
			
			}
			
		}
		
		else if(SprinklerController.hasitrained)
		{
			System.out.println("It has rained in the last 24 hours so sprinkler schedule cancelled");
			
			Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "RandomEvent", "warning" , grid);

			LogDao logdaostart = new LogDaoImp();
			logdaostart.addLog(logstart);
			
			
		}
		
		else
		{

		String action = null;
		switch (grid) {
		case 1:
			action = "Sprinkling the Flower plants";
			break;

		case 2:
			action = "Sprinkling the vegetable plants";
			break;

		case 3:
			action = "Sprinkling the Fruit plants ";
			break;

		default:
			System.out.println(" please select one of the three 1,2,3");
			break;

		}
          int min=TimeTracker.tickMinutes();
//		System.out.println(action + " at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
//				+ TimeTracker.getCurrentMinute() + ": minutes");

		Log logstart = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Scheduled", action, grid);

		LogDao logdaostart = new LogDaoImp();
		logdaostart.addLog(logstart);
		
		while(TimeTracker.tickMinutes()-min<= minutes)
		{
			
		}
		String finish = null;
		switch (grid) {
		case 1:
			finish = "stopped the Sprinkler for Flower plants";
			break;

		case 2:
			finish= "stopped the Sprinkler for vegetable plants";
			break;

		case 3:
			finish= "Sstopped the Sprinkler for Fruit plants ";
			break;

		default:
			System.out.println(" please select one of the three 1,2,3");
			break;

		}
//		System.out.println(finish + " at   " + TimeTracker.getCurrentHour() + ": hour " + "  "
//				+ TimeTracker.getCurrentMinute() + ": minutes");
		Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "Scheduled", finish, grid);

		LogDao logdaoend = new LogDaoImp();
		logdaoend.addLog(logend);
		
		}



	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		provideService();
		
	}

}
