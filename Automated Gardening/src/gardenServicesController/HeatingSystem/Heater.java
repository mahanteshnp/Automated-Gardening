package gardenServicesController.HeatingSystem;

public class Heater {

	int grid;
	boolean turnedon;
	
	

	public Heater(int grid) {
		// TODO Auto-generated constructor stub
		this.grid=grid;
	}

	public void turnon() {
		turnedon = true;
		System.out.println("turning on heater");
	}

	public void turnoff() {
		turnedon = false;
	}

	public boolean isTurnedOn() {

		return turnedon;
	}

}
