package garden;

import scheduler.GrowingPlan;

public class FlowerPlants extends Plants {

	String name;
	static GrowingPlan growingplan;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static GrowingPlan getGrowingplan() {
		return growingplan;
	}

	public static void setGrowingplan(GrowingPlan growingplan) {
		FlowerPlants.growingplan = growingplan;
	}

	public FlowerPlants(String name) {
		super();

		this.name = name;

	}

	public FlowerPlants(String name, String state) {
		super("Flower", state);
		this.name = name;

	}

}
