package seven_book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EX_7_3 {
	public static void main(String[] args) throws IOException {
		// 문자열만 삽입 가능한 ArrayList 생성
		ArrayList<String> a = new ArrayList<>();

		File file = new File("src/seven_book/EX_7_3.txt");

		// 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
		Scanner sc = new Scanner(file);
		String name = "";
		BufferedReader inFile = new BufferedReader(new FileReader(file));

		for (int i = 0; i < 4; i++) {
//			System.out.println("이름을 입력하세요>>");

			name = inFile.readLine();
			a.add(sc.nextLine());
		}

//		 ArrayList에 들어 있는 모든 이름 출력
//		for (int i = 0; i < a.size(); i++) {
//			String name_2 = a.get(i);
//			System.out.println(name_2 + " ");
//		}
		a.forEach((i) -> System.out.println(i));

		// 가장 긴 이름 출력
		int longestIndex = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(longestIndex).length() < a.get(i).length()) {
				longestIndex = i;
			}
		}
		System.out.println("가장 긴 이름은 : " + a.get(longestIndex));
		sc.close();
	}
}
