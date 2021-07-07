package rovna.calender;

import java.util.Scanner;

public class Calender {
	
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
		else
			return false;
	}
	
	public int getMaxDaysOfMonth(int year, int Month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[Month -1];
		} else {
		return MAX_DAYS[Month - 1];
		}
	}
	
	public void printCalendar(int year, int Month) {
		System.out.printf("   <<%4d년%3d월>>",year, Month);
		System.out.println("\n SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		
		int maxDay = getMaxDaysOfMonth(year , Month);
		
		for(int i=1; i <= maxDay; i++) {
			System.out.printf("%3d",i);
			if (i % 7 == 0) 
				System.out.println();
		}
		
		
		System.out.println();
//		System.out.println(" 8  9 10 11 12 13 14");
//		System.out.println("15 16 17 18 19 20 21");
//		System.out.println("22 23 24 25 26 27 28");
	}
	
	public static void main(String[] args) {
		
		
		String PROMPT = ">";
		Scanner scanner = new Scanner ( System.in);
		Calender cal = new Calender();
		
		int Month = 1;
		int year = 2021;
		
		while(true) {
			System.out.println("월을 입력하세요");
			System.out.println(PROMPT);
			Month = scanner.nextInt();
			if (Month == -1) {
				break;
			}
//			if ( cal.getMaxDaysOfMonth(Month) == 31 ) {
//				cal.printCalendar(2021, Month);
//				System.out.println("29 30 31");
//			}
//			if ( cal.getMaxDaysOfMonth(Month) == 30 ) {
//				cal.printCalendar(0, Month);
//				System.out.println("29 30");
//			} if ( cal.getMaxDaysOfMonth(Month) == 28 ){
//				cal.printCalendar(0, Month);
//			}
			if (Month > 0 && Month < 13){
			System.out.printf("%d월은 %d일까지 있습니다.\n", Month, cal.getMaxDaysOfMonth(year,Month));
				
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("Bye~");
		scanner.close();
	}
}
