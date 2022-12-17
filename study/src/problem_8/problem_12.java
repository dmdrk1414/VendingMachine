package problem_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 명품 자바 실습문제_12
public class problem_12 {
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		String str = "problem_10.java";
		File file = new File(str);
		BufferedReader br = new BufferedReader(new FileReader(file));
		Scanner sc = new Scanner(System.in);

		String read = "";
		int index = 0;
		while ((read = br.readLine()) != null) {
			read = index++ + ": " + read;
			list.add(read);
		}

		String input = "";
		while (true) {
			System.out.print("검색할 단어나 문장>> ");
			input = sc.next();
			if (input.equals("그만")) {
				break;
			}

			for (String line : list) {
				if (line.contains(input)) {
					System.out.println(line);
				}
			}
		}

		System.out.println("프로그램을 종료합니다.");

		br.close();
		sc.close();
	}
}
