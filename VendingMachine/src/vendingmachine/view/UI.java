package vendingmachine.view;

import java.util.Scanner;

public class UI {
	final static String UI_IS_POSITIVE_NUM = "UI.isPositiveNum";

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

	public static int returnSelectMenuNum() {
		Scanner sc = new Scanner(System.in);
		int selectNum = 0;

		if (sc.hasNextInt()) {
			selectNum = sc.nextInt();
			if (isPositiveNum(selectNum)) {
				return selectNum;
			}
		}

		UI.ErrNotFormReturn(UI_IS_POSITIVE_NUM);
		return -1;
	}

	private static boolean isPositiveNum(int selectNum) {
		if (selectNum >= 0) {
			return true;
		} else {
			UI.ErrPositiveCall("");
			return false;
		}
	}
}
