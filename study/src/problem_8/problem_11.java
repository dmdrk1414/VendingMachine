package problem_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 명품 자바 실습문제_11
public class problem_11 {
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		File file = new File("word.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Scanner sc = new Scanner(System.in);

		String read = "";
		while ((read = br.readLine()) != null) {
			list.add(read);
		}

		String input = "";
		boolean t = false;
		while (true) {
			t = false;
			System.out.println("단어>>");
			input = sc.next();
			if (input.equals("그만")) {
				break;
			}

			for (String str : list) {
				if (str.contains(input)) {
					System.out.println(str);
					t = true;
				}
			}
			if (!t) {
				System.out.println("찾을수없습니다.");
			}
		}
		br.close();
		sc.close();
	}
}
