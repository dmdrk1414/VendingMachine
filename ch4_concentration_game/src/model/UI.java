package model;

public class UI {
	public static void ErrNotStr() {
		System.out.println("문자만입력해주세요!");
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
