package ex_six;

public class Ex_6_7 {
	public static void main(String[] args) {
		String a = new String(" C#");
		String b = new String(" ,C++");

		System.out.println(a + "의 길이는 " + a.length());
		System.out.println(a.contains("#"));

		a = a.concat(b);
		System.out.println(a);
		System.out.println();

		a = a.trim();
		System.out.println(a);
		System.out.println();

		a = a.replace("C#", "Java");
		System.out.println(a);
		System.out.println();

		String s[] = a.split(",");
		for (int i = 0; i < s.length; i++) {
			System.out.println("분리된 문자열" + i + ": " + s[i]);
		}
		System.out.println();

		a = a.substring(5);
		System.out.println(a);
		System.out.println();

		char c = a.charAt(2);
		System.out.println(c);

		System.out.println("자바" + 3.14 + false + 'a');

	}
}