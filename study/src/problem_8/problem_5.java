package problem_8;

import java.io.FileInputStream;
import java.io.IOException;

// 명품 자바 실습문제_5
public class problem_5 {
	public static void main(String[] args) throws IOException {
		String src = "src/problem_8/problem_1.txt";
		String srcCopy = "src/problem_8/problem_1_복사본.txt";

		FileInputStream fi_1 = new FileInputStream(src);
		FileInputStream fi_2 = new FileInputStream(srcCopy);

		int c_1 = 0;
		int c_2 = 0;
		boolean t = true;
		while ((c_1 = fi_1.read()) != -1 && (c_2 = fi_2.read()) != -1) {
			System.out.println((char) c_1 + " " + (char) c_2);
			if (c_1 != c_2) {
				t = false;
				break;
			}
		}
		if (t) {
			System.out.println("파일이 같습니다.");
			return;
		}
		System.out.println("파일이 다릅니다.");
	}
}
