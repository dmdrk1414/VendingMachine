package ex_six;

import java.util.StringTokenizer;

public class Ex_6_9 {
	public static void main(String[] args) {
		String str = "홍길동/장화/홍련/콩쥐/팥쥐";
		StringTokenizer st = new StringTokenizer(str, "/", true); //

		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
	}
}