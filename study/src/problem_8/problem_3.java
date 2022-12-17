package problem_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 명품 자바 실습문제_3
public class problem_3 {
	public static void main(String[] args) throws IOException {
//		String src = "c:\windows\system.ini";

		// FileReader 으로 읽기
//		File file = new File("c:\\windows\\system.ini");
//		FileReader fr = new FileReader(file);
//
//		int c = 0;
//		while ((c = fr.read()) != -1) {
//			char charAt = Character.toUpperCase((char) c);
//			System.out.print(charAt);
//		}

		// BufferedReader 으로 읽기
		File file = new File("c:\\windows\\system.ini");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String read = "";

		while ((read = br.readLine()) != null) {
			read = read.toUpperCase();
			System.out.println(read);
		}
	}
}
