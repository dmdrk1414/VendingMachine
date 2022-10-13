package model;

import java.util.InputMismatchException;
import java.util.Scanner;

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

	public static int getInt(Scanner sc) {
		int inputInt = 0;
		while (true) {
			try {
				inputInt = sc.nextInt();
				if (UI.isPositive(inputInt)) {
					return inputInt;
				} else {
					sc.nextLine();
					UI.ErrNotPositiveInt();
					continue;
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				UI.ErrNotRightInput();
				continue;
			}
		}
	}

	private static boolean isPositive(int inputInt) {
		if (inputInt > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean equalTwoChar(char preWordLastChar, char afterWordFirstChar) {
		String parseStrPreWordLastChar = String.valueOf(preWordLastChar);
		String parseStrAfterWordLastChar = String.valueOf(afterWordFirstChar);
		if (parseStrPreWordLastChar.equals(parseStrAfterWordLastChar)) {
			return true;
		} else {
			return false;
		}
	}

}
