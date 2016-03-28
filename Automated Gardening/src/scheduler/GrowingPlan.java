package scheduler;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import gardenServicesController.GardenService;
import gardenServicesController.wateringSystem.WaterSprinkler;

public class GrowingPlan {
    int grid;
	private HashMap<DayHour, List<GardenService>> mapServicesToHours = new HashMap<DayHour, List<GardenService>>();

	public GrowingPlan(int grid)
	{
		this.grid=grid;
	}
	public HashMap<DayHour, List<GardenService>> getMapServicesToHours() {
		return mapServicesToHours;
	}
 
	public void setMapServicesToHours(HashMap<DayHour, List<GardenService>> mapServicesToHours) {
		this.mapServicesToHours = mapServicesToHours;
	}

	public class DayHour {

		int hour;
		int day;
		int minute;
		int seconds;
		GardenService gardenservice;
		List<GardenService> list;

		public DayHour(int hour, int day, int minute, int seconds) {
			this.hour = hour;
			this.day = day;
			this.minute = minute;
			this.seconds = seconds;

		}

		public DayHour(int hour, int day, int minute, int seconds, GardenService gs) {

			this.gardenservice = gs;
			if (!mapServicesToHours.containsKey(new DayHour(hour, day, minute, seconds))) {
				list = new ArrayList<GardenService>();
				list.add(gs);
			} else {
				list = mapServicesToHours.get(new DayHour(hour, day, minute, seconds));
				list.add(gs);
			}
			mapServicesToHours.put(new DayHour(hour, day, minute, seconds), list);

		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
		}

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public GardenService getGardenservice() {
			return gardenservice;
		}

		public void setGardenservice(GardenService gardenservice) {
			this.gardenservice = gardenservice;

		}

		public String toString() {
			return Integer.toString(this.day) + Integer.toString(this.hour) + Integer.toString(this.minute)
					+ Integer.toString(this.seconds);
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
		}

		private GrowingPlan getOuterType() {
			return GrowingPlan.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + day;
			result = prime * result + hour;
			result = prime * result + minute;
			result = prime * result + seconds;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DayHour other = (DayHour) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (day != other.day)
				return false;
			if (hour != other.hour)
				return false;
			if (minute != other.minute)
				return false;
			if (seconds != other.seconds)
				return false;
			return true;
		}

	}
}
