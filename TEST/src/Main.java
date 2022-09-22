import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner 클래스로
		Scanner sc = new Scanner(System.in);

		// grade: 출력
		System.out.print("grade: ");

		// Scanner 클래스의 객체로 부터 값을 받아 저장
		int input = sc.nextInt();

		// 조건문
		if (input >= 70) {
			// Congration.출력
			System.out.print("Congration.");
		}
		sc.close();
		// Scanner 클래스의 객체 닫기
	}
}
