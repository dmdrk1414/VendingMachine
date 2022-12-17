

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// 명품 자바 실습문제_10
public class problem_10 {
	static HashMap<String, String> hashMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		File file = new File("phone.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Scanner sc = new Scanner(System.in);

		String read = "";
		String name = "";
		String phonNum = "";
		String[] arr;
		while ((read = br.readLine()) != null) {
			arr = read.split(" ");
			name = arr[0];
			phonNum = arr[1];
			hashMap.put(name, phonNum);
		}
		System.out.println("총" + hashMap.size() + "개의 전화번호를 읽었습니다.");
		String num;

		while (true) {
			System.out.print("이름>> ");
			String input = sc.next();
			if (input.equals("그만")) {
				break;
			}
//			if ((num = hashMap.get(input)) != null) {
//				System.out.println(num);
//			} else {
//				System.out.println("찾는 이름이 없습니다.");
//			}
			if (hashMap.containsKey(input)) {
				System.out.println(hashMap.get(input));
			} else {
				System.out.println("찾는 이름이 없습니다.");
			}
		}

		br.close();
		sc.close();
	}

}
