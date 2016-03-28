package garden;

public class VegetablePlants extends Plants{

	String name;
	
	public VegetablePlants(String name)
    {
    	super();
	
    	this.name=name;
    	
   }
	
	 public VegetablePlants(String name , String state)
	    {
	    	
		 super("Vegetable", state);
	    	
	    	this.name=name;
	    	
	   }
	
}
