package rovna.calender;

import java.util.Scanner;

public class Calender {
	
	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	public int getMaxDaysOfMonth(int Month) {
		return MAX_DAYS[Month - 1];
	}
	
	public void printSampleCalendar() {
		System.out.println("일 월 화 수 목 금 토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	
	public static void main(String[] args) {
		
		
		String PROMPT = "cal>";
		Scanner scanner = new Scanner ( System.in);
		Calender cal = new Calender();
		
		System.out.println("반복횟수를 입력하세요 :");
		
		int Month = 1;
		
		while(true) {
			System.out.println("월을 입력하세요 :");
			System.out.println(PROMPT);
			Month = scanner.nextInt();
			if (Month == -1) {
				break;
			}
			if (Month > 0 && Month < 13){
				System.out.printf("%d월은 %d일까지 있습니다.\n", Month, cal.getMaxDaysOfMonth(Month));
				
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
		System.out.println("Bye~");
		scanner.close();
	}
}
