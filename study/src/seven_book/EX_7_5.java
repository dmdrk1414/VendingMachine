package seven_book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class EX_7_5 {
	public static void main(String[] args) throws IOException {
//		HashMap<String, String> dic = new HashMap<>();
		var dic = new HashMap<String, String>();
		char[] test = new char[100];
		// 3개의 (key, value) 쌍을 dic에 저장
		File file = new File("src/seven_book/EX_7_5.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
//		System.out.println(br.read(test, 0, 10));
//		System.out.println(Arrays.toString(test));

		String line = "";
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			int index = line.indexOf(" ");
			String key = line.substring(0, index);
			String value = line.substring(index + 1, line.length());
			dic.put(key, value);
		}

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("찾고 싶은 단어는?");
			String eng = sc.next();
			if (eng.equals("exit")) {
				System.out.println("종료");
				break;
			}

			// 해시 맵에서 '키' eng의 '값' kor 검색
			String kor = dic.get(eng);
			if (kor == null) {
				System.out.println(eng + "는 없는 단어 입니다.");
			} else {
				System.out.println(kor);
			}
		}
		sc.close();
	}
}
