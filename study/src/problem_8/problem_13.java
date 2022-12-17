package problem_8;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// 명품 자바 실습문제_13
public class problem_13 {
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		String str = "c:\\";
		File file = null;
		Scanner sc = new Scanner(System.in);

		System.out.println("***** 파일 탐색기입니다. *****");
		String temp = "";
		while (true) {
			System.out.println("[" + str + "]");
			file = new File(str);
			File[] fileArr = file.listFiles();

			for (int i = 0; i < fileArr.length; i++) {
				File fileAtNow = fileArr[i];
				if (fileAtNow.isDirectory()) {
					System.out.print("dir\t");
				} else {
					System.out.print("file\t");
				}

				System.out.print(fileAtNow.length() + "바이트\t");

				System.out.println(fileAtNow.getName());
			}

			System.out.print(">>");
			str = sc.next();
			if (str.equals("그만")) {
				break;
			} else if (str.equals("..")) {
//				str = temp.substring(0, temp.lastIndexOf(file.getName()) - 1);
				str = file.getParentFile().getPath();
				continue;
			}
			str = file.getPath() + "\\" + str;
//			temp = new String(str);
		}

		sc.close();
	}
}
