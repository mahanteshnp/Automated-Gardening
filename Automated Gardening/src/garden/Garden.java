package garden;

import java.util.ArrayList;
import java.util.List;

import database.Log;
import database.LogDao;
import database.LogDaoImp;
import scheduler.timer.TimeTracker;

public class Garden{
	
     private  static List<FlowerPlants> grid1= new ArrayList<FlowerPlants>();
     private  static List<FruitPlants> grid3= new ArrayList<FruitPlants>();
     private  static List<VegetablePlants> grid2= new ArrayList<VegetablePlants>();
     
     
	
	
	public static void addPlants(String name , int type)
	{
		
		
		switch(type)
		{
		case 1:  if(grid1.size()>10)
		               {
			             System.out.println(" Cannot add more plants of Flower not enogh place.");
			             Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "New"+name+" Flower Plant Addition", "Failed due yo no space", type);

			        		LogDao logdaoend = new LogDaoImp();
			        		logdaoend.addLog(logend);
			                break;
			           
		               }
			grid1.add(new FlowerPlants(name));
			Log logend = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "New "+name+  "  Flower Plant Addition", "Sucessful", type);

	  		LogDao logdaoend = new LogDaoImp();
	  		logdaoend.addLog(logend);
			               break;
			
		case 3:  if(grid1.size()>10)
        {
          System.out.println(" Cannot add more plants of Fruit not enogh place.");
          Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "New "+name+"  Fruit Plant Addition", "Failed due yo no space", type);

  		LogDao logdaoend1 = new LogDaoImp();
  		logdaoend1.addLog(logend1);
             break;
        }
			grid3.add(new FruitPlants(name));
			Log logend1 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "New "+name+" Fruit Plant Addition", "Successful", type);

	  		LogDao logdaoend1 = new LogDaoImp();
	  		logdaoend1.addLog(logend1);
			               break;
		
		case 2:  if(grid1.size()>10)
        {
	          System.out.println(" Cannot add more plants of Fruit not enogh place.");
	          Log logend11 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "New "+name+" Vegetable Plant Addition", "Failed due yo no space", type);

      		LogDao logdaoend11 = new LogDaoImp();
      		logdaoend11.addLog(logend11);
	             break;
	        }
			grid2.add(new VegetablePlants(name));
			Log logend11 = new Log(TimeTracker.getDay(), TimeTracker.getTime(), "New "+name+" Vegetable Plant Addition", "Successful", type);

	  		LogDao logdaoend11 = new LogDaoImp();
	  		logdaoend11.addLog(logend11);
			              break;
		
        default: System.out.println("choose the right plant");
		              break;
			
		
		
		
		}
		
		
	}
	
	
	

}
