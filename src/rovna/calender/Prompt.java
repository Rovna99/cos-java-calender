package rovna.calender;

import java.util.Scanner;

public class Prompt {
	
	private final static String PROMPT="cal>";
	
	public void runPrompt() {
		
		Scanner scanner = new Scanner ( System.in);
		Calender cal = new Calender();
		
		int Month = 1;
		
		while(true) {
			System.out.println("월을 입력하세요");
			System.out.println(PROMPT);
			Month = scanner.nextInt();
			if (Month == -1) {
				break;
			}
			if (Month > 0 && Month < 13){
//			System.out.printf("%d월은 %d일까지 있습니다.\n", Month, cal.getMaxDaysOfMonth(Month));
			cal.printCalendar(2021, Month);
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