package garden;

import scheduler.GrowingPlan;

public class FruitPlants extends Plants{
	
	String name;
	
	private static GrowingPlan growingplan;
	
	public static GrowingPlan getGrowingplan() {
		return growingplan;
	}

	public static void setGrowingplan(GrowingPlan growingplan) {
		FruitPlants.growingplan = growingplan;
	}

	public FruitPlants(String name)
    {
    	super();
	
    	this.name=name;
    	
   }
	
	 public FruitPlants(String name, String state)
	    {
		 super("Fruit", state);
	    	this.name=name;
	    	this.name=name;
	    	
	    	
	    }

}
