package problem_8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 명품 자바 실습문제_1
public class problem_1 {
	public static void main(String[] args) throws IOException {
		String src = "src/problem_8/problem_1.txt";
		System.out.println("전화번호 입력 프로그램입니다.");
		Scanner sc = new Scanner(System.in);
//		FileWriter fw = new FileWriter(src);
		BufferedWriter bw = new BufferedWriter(new FileWriter(src));
		String input = "";

		while (true) {
			System.out.print("이름 전화번호 >> ");
			input = sc.nextLine();
			if (input.equals("그만")) {
				break;
			}
//			fw.write(input + "\n");
			bw.write(input + "\n");
		}

		System.out.println(src + "에 저장하였습니다.");
		sc.close();
//		fw.flush();
//		fw.close();

		bw.flush();
		bw.close();
	}
}
