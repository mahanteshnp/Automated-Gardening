package database;

public class Log {

	String Typeofevent;
	String Timeofevent;
	int Dayofevent;
	String action;
	int grid;

	public Log(int dayofevent, String timeofevent, String typeofevent, String action, int grid) {

		this.Typeofevent = typeofevent;
		this.Timeofevent = timeofevent;
		this.Dayofevent = dayofevent;
		this.action = action;
		this.grid = grid;
	}

	public int getGrid() {
		return grid;
	}

	public void setGrid(int grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "Log [Typeofevent=" + Typeofevent + ", Timeofevent=" + Timeofevent + ", Dayofevent=" + Dayofevent
				+ ", action=" + action + "]";
	}

	public String getTypeofevent() {
		return Typeofevent;
	}

	public void setTypeofevent(String typeofevent) {
		Typeofevent = typeofevent;
	}

	public String getTimeofevent() {
		return Timeofevent;
	}

	public void setTimeofevent(String timeofevent) {
		Timeofevent = timeofevent;
	}

	public int getDayofevent() {
		return Dayofevent;
	}

	public void setDayofevent(int dayofevent) {
		Dayofevent = dayofevent;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
