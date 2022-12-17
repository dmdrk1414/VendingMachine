package problem_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 명품 자바 실습문제_4
public class problem_4 {
	public static void main(String[] args) throws IOException {
		// BufferedReader 으로 읽기
		File file = new File("c:\\windows\\system.ini");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String read = "";

		int i = 1;
		while ((read = br.readLine()) != null) {
			read = read.toUpperCase();
			System.out.println((i++) + ": " + read);
		}
	}
}
