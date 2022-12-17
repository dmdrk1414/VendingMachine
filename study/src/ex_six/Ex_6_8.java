package ex_six;

public class Ex_6_8 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);

//		sb.append(true);
//		System.out.println(sb);

		sb.append(" is pencil");
		System.out.println(sb);

		sb.insert(7, " my");
		System.out.println(sb);

//		sb.replace(sb.indexOf("my"), sb.indexOf(" ", sb.indexOf("my")), "your");
		sb.replace(8, 10, "your");
		System.out.println(sb);

		sb.delete(8, 13);
		System.out.println(sb);

		sb.setLength(4);
		System.out.println(sb);
	}
}