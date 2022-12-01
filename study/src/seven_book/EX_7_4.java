package seven_book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

public class EX_7_4 {
	public static void main(String[] args) throws IOException {
		// 정수 값만 다루는 제네릭 벡터 생성
		Vector<Integer> v = new Vector<>();

		File file = new File("src/seven_book/EX_7_4.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String num = "";
		while ((num = br.readLine()) != null) {
			v.add(Integer.parseInt(num));
		}
		v.add(2, 100);

		System.out.println(v);

		// Iterator를 이용하여 모든 정수 출력
		Iterator<Integer> it = v.iterator();
		while (it.hasNext()) {
			int n = it.next();
			System.out.println(n);
		}

		// Iterator를 이용하여 모든 정수 더하기
		int sum = 0;
		it = v.iterator();
		while (it.hasNext()) {
			int n = it.next();
			sum += n;
		}

		sum = 0;
		for (it = v.iterator(); it.hasNext();) {
			sum += it.next();
		}
		System.out.println(sum);

		sum = 0;
		for (Iterator<Integer> iterator = v.iterator(); iterator.hasNext();) {
			sum += iterator.next();
		}
		System.out.println(sum);
	}
}
