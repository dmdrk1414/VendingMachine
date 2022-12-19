package ex_6;

public class Ex_6_6 {
	public static void main(String[] args) {
		int n = 10;

//		Integer intObject = Integer.valueOf(n);
		Integer intObject = n; // auto boxing
		System.out.println("intObject = " + intObject);

//		m = intObject.intValue() + 10;
		int m = intObject + 10; // auto unboxing
		System.out.println("m = " + m);
	}
}