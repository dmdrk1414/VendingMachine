package model;

public class UI {
	public static void ErrNotStr() {
		System.out.println("문자만입력해주세요!");
	}

	public static void ErrNotPositiveInt() {
		System.out.println("양수만입력해주세요!");
	}

	public static void ErrNotRightInput() {
		System.out.println("올바른 값을 입력해주세요!");
	}

	public static boolean strCheck(String inputStr) {
		try {
			double d = Double.parseDouble(inputStr);
			UI.ErrNotStr();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
