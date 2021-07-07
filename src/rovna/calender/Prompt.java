package rovna.calender;

import java.util.Scanner;

public class Prompt {
	
	/**
	 * 
	 * @param week 요일명
	 * @return 0~6 (0 = Sunday, 6 = Saturday
	 */
	public int parseDay(String week) {
	 if (week.equals("su"))return 0;
	else if (week.equals("mo"))return 1;
	else if (week.equals("tu"))return 2;
	else if (week.equals("we"))return 3;
	else if (week.equals("th"))return 4;
	else if (week.equals("fr"))return 5;
	else if (week.equals("sa"))return 6;
		else
			return 0;
	}
	
	public void runPrompt() {
		
		Scanner scanner = new Scanner ( System.in);
		Calender cal = new Calender();
		
		int Month = 1;
		int year = 0;
		int weekday = 0;
		
		while(true) {
			System.out.println("연도를 입력하세요. (exit: -1)");
			System.out.println("YEAR> ");
			year = scanner.nextInt();
			if ( year == -1) {
				break;
			}
			System.out.println("달을 입력하세요");
			System.out.println("MONTH> ");
			Month = scanner.nextInt();
			
			System.out.println("첫 번째 요일을 입력하세요(su, mo, tu, we, th, fr, sa).");
			System.out.println("WEEKDAY> ");
			String str_weekday = scanner.next();
			weekday = parseDay(str_weekday);
			if (Month == -1) {
				break;
			}
			if (Month > 0 && Month < 13){
//			System.out.printf("%d월은 %d일까지 있습니다.\n", Month, cal.getMaxDaysOfMonth(Month));
			cal.printCalendar(year, Month, weekday);
			} else {
				System.out.println("잘못된 입력입니다.");
			}
			
		}
		System.out.println("Bye~");
		scanner.close();
	}
	

	public static void main(String[] args) {
		//셀 실행
		Prompt p = new Prompt();
		p.runPrompt();
		
	}
}
