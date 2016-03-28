package scheduler.timer;

import java.util.Date;

/* This class keeps track of the time elapsed in a growing plan
 */

public class TimeTracker {

	private static int hour;
	private static int minute;
	private static int second;
	private static int day = 1;
	private static int minuteCount;
	private static TimeTracker timer = new TimeTracker();

	private TimeTracker() 
	{

		
	}

	
	public static void tickSeconds() {
		if (second == 59) {
			second = 0;
			tickMinutes();
		} else
			second++;

	}

	public static int tickMinutes() {
		if (minute == 59) {
			minute = 0;
			tickHour();
		} else
			minute++;
		
		return minuteCount++;
		
	}

	public static int getDay() {
		return day;
	}

	public static void setDay(int day) {
		TimeTracker.day = day;
	}

	public static void tickHour() {
		if (hour == 23) {
			hour = 0;
			incDay();
		}

		else
			hour++;

	}
	
	public void minutesElapsed()
	{
		
	}

	private static void incDay() {
		// TODO Auto-generated method stub
		day++;
	}

	public static void printTime() {
		if (hour < 10) {
			System.out.print("0");
		}
		System.out.print(hour + ":");

		if (minute < 10) {
			System.out.print("0");
		}
		System.out.print(minute + ":");

		if (second < 10) {
			System.out.print("0");
		}
		System.out.println(second);
	}

	public static void getCurrentTime() {
		if (hour < 10) {
			System.out.print("0");
		}
		System.out.print(hour + ":");

		if (minute < 10) {
			System.out.print("0");
		}
		System.out.print(minute + ":");

		if (second < 10) {
			System.out.print("0");
		}
		System.out.println(second);
	}

	public static TimeTracker getInstance() {
		// TODO Auto-generated method stub
		return timer;
	}

	public static int getCurrentHour() {

		return hour;

	}

	public static int getCurrentMinute() {
		return minute;
	}

	public static int getCurrentSecond() {
		return second;
	}

	public static String getTime() {
		return (Integer.toString(getCurrentHour()) + ":" + Integer.toString(getCurrentMinute()) + ":"
				+ Integer.toString(getCurrentSecond()));
	}
}
