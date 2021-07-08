package rovna.calender;

import java.util.Date;
import java.util.HashMap;
import java.text.ParseException;






public class Calendar {
	
	private static final int[] MAX_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap <Date, PlanItem> planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
	}
	
	/**
	 * 
	 * @param date ex: "2021-07-08"
	 * @param plan
	 * @throws ParseException 
	 */
	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
	}
	
	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
		
	}
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public int getMaxDaysOfMonth(int year, int Month) {
		
			if (isLeapYear(year)) {
				return LEAP_MAX_DAYS[Month];
				
			} else {
			return MAX_DAYS[Month];
			}
	}
	
	public void printCalendar(int year, int Month) {
		System.out.printf("   <<%d년 %d월>>",year, Month);
		System.out.println("\n SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		int weekday= getWeekDay(year, Month, 1 );
		//print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth(year , Month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		
		//print first line 
		for(int i = 1; i <= count; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println();
		
		//print from second line to last
		count++;
		for(int i=count; i <= maxDay; i++) {
			System.out.printf("%3d",i);
			if (i % 7 == delim) 
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	private int getWeekDay(int year, int Month, int day) {
		int syear = 1970;
		final int STANDARD_WEEKDAY = 4; // 1970,Jan,1st = Thursday 
		
		int count = 0;
		
		for ( int i = syear; i < year; i++) {
			int delta =  isLeapYear(i) ? 366 : 365;
			count += delta;
		}
		
		for (int i = 0; i < Month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}
		
		count += day;
		
		int weekday = (count + STANDARD_WEEKDAY) % 7;
		return weekday;
	}
	
}
