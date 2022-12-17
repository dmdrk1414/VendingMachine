package problem_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 명품 자바 실습문제_7
public class problem_7 {
	public static void main(String[] args) throws IOException {
		String src_1 = "src/problem_8/a.jfif";
		String src_2 = "src/problem_8/b.jfif";

		File src = new File(src_1);
		File dest = new File(src_2);

		FileInputStream fi = new FileInputStream(src_1);
		FileOutputStream fo = new FileOutputStream(src_2);

		System.out.println(src.getName() + "를 " + dest.getName() + "로 복사합니다.");
		System.out.println("10%마다 *를 출력합니다.");

		long f_size = ((src.length()) / 10);

		byte[] buf = new byte[(int) f_size];
		while (true) {
			int n = fi.read(buf);
			fo.write(buf, 0, n);
			if (n < buf.length)
				break;
			System.out.print('*');
		}
		fi.close();
		fo.close();

		System.out.println();

	}
}
