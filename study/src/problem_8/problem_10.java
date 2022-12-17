package problem_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// 명품 자바 실습문제_10
public class problem_10 {
	static HashMap<String, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		File file = new File("phone.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Scanner sc = new Scanner(System.in);

		String read = "";
		String name = "";
		String phon = "";
		String[] arr;
		while ((read = br.readLine()) != null) {
			arr = read.split(" ");
			name = arr[0];
			name = arr[1];
		}
		br.close();
		sc.close();
	}

}
