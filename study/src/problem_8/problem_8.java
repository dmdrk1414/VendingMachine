package problem_8;

import java.io.File;
import java.io.IOException;

// 명품 자바 실습문제_8
public class problem_8 {
	public static void main(String[] args) throws IOException {
		File file = new File("c:\\");
		listDirectory(file);
	}

	public static void listDirectory(File dir) {
		File[] subFiles = dir.listFiles();

		long Max = 0;
		int index = 0;
		for (int i = 0; i < subFiles.length; i++) {
			if (Max < subFiles[i].length()) {
				Max = subFiles[i].length();
				index = i;
			}
		}

		System.out.println("가장 큰 파일은 " + subFiles[index].toString() + " " + subFiles[index].length());
	}
}
