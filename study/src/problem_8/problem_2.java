package problem_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 명품 자바 실습문제_2
public class problem_2 {
	public static void main(String[] args) throws IOException {
		String src = "src/problem_8/problem_1.txt";
		File file = new File(src);
//		FileReader fr = new FileReader(file);
//
//		int c = 0;
//		System.out.println(src + "를 출력합니다.");
//		while ((c = fr.read()) != -1) {
//			System.out.print((char) c);
//		}

		BufferedReader br = new BufferedReader(new FileReader(file));
		System.out.println(src + "를 출력합니다.");
		String read = "";
		while ((read = br.readLine()) != null) {
			System.out.println(read);
		}

	}
}
