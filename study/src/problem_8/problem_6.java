package problem_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 명품 자바 실습문제_6
public class problem_6 {
	public static void main(String[] args) throws IOException {
		// BufferedReader 으로 읽기
		String src_1 = "src/problem_8/problem_1.txt";
		String src_2 = "src/problem_8/problem_2.txt";
		String src_3 = "src/problem_8/problem_3.txt";
		BufferedReader br_1 = new BufferedReader(new FileReader(src_1));
		BufferedReader br_2 = new BufferedReader(new FileReader(src_2));
		BufferedWriter bw = new BufferedWriter(new FileWriter(src_3));

		StringBuilder str_1 = new StringBuilder(br_1.readLine());
		StringBuilder str_2 = new StringBuilder(br_2.readLine());
		StringBuilder str_3 = str_1.append(str_2);

		bw.write(str_3.toString());
		bw.flush();
		bw.close();
		br_1.close();
		br_2.close();
	}
}
