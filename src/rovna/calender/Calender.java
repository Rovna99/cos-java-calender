package rovna.calender;



public class Calender {
	
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public int getMaxDaysOfMonth(int year, int Month, int weekday) {
		
			if (isLeapYear(year)) {
				return LEAP_MAX_DAYS[Month -1];
				
			} else {
			return MAX_DAYS[Month - 1];
			}
	}
	
	public void printCalendar(int year, int Month, int weekday) {
		System.out.printf("   <<%4d년%3d월>>",year, Month);
		System.out.println("\n SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		//print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int maxDay = getMaxDaysOfMonth(year , Month, weekday);
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
}
