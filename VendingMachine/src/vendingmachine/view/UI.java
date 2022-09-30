package vendingmachine.view;

import java.util.Scanner;

public class UI {
	final static private String UI_IS_POSITIVE_NUM = "UI.isPositiveNum";

	private UI() {

	}

	public static void ErrPositiveCall(String msg) {
		System.out.println("msg: " + msg + ":: 양수를 입력해주세요.");
	}

	public static void ErrNotPickValue(String msg) {
		System.out.println("msg: " + msg + ":: 찾고자하는 것이 없습니다.");
	}

	public static void ErrNotPickStock(String msg) {
		System.out.println("msg: " + msg + ":: 재고가 없네요.");
	}

	public static void ErrNotString(String msg) {
		System.out.println("msg: " + msg + ":: 문자만넣어주세요.");
	}

	public static void ErrNotFormReturn(String msg) {
		System.out.println("msg: " + msg + ":: 올바른 리턴값이 아닙니다.");
	}

	private static void ErrOutOfBoundSize(int menuSize) {
		System.out.println("msg: ::0~" + (menuSize - 1) + " 범위의 값만 넣어주세요.");
	}

	public static int returnSelectMenuNum(int menuSize) {
		Scanner sc = new Scanner(System.in);
		int selectNum = 0;

		selectNum = sc.nextInt();
		if (UI.isPositiveNum(selectNum) && UI.isMenuSizeBoundary(selectNum, menuSize)) {
			return selectNum;
		} else {
			return -1;
		}
	}

	public static boolean isMenuSizeBoundary(int selectNum, int menuSize) {
		if (selectNum < menuSize) {
			return true;
		} else {
			UI.ErrOutOfBoundSize(menuSize);
			return false;
		}
	}

	public static boolean isPositiveNum(int numCheck) {
		if (numCheck >= 0) {
			return true;
		} else {
			UI.ErrPositiveCall("");
			return false;
		}
	}

	public static boolean isStrCheck(String inputString) {
		try {
			double a = Integer.parseInt(inputString);
			UI.ErrNotString("");
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
