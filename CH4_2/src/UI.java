import java.util.Scanner;

public class UI {
	// 입역한 라인을 받는 line변수 선언
	private static String line;

	// 객체 생성을 금지하기 위해서
	// 생성자에 private을 한다.
	private UI() {
	}

	// 문자다 -> parseInt에 에러 -> try-cahch 에서 true처리
	public static boolean strCheck(String inputString) {
		// inputString이 숫자면 false
		try {
			double a = Integer.parseInt(inputString);
			return false;
		}
		// inputString이 문자면 true
		catch (Exception e) {
			return true;
		}
	}

	// 입력장치에서 한 행을 입력 받음
	public static String getNextLine(final String msg) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print(msg);
			UI.line = sc.nextLine();
			if (UI.strCheck(UI.line)) {
				return UI.line;
			} else {
				System.out.println("다시!! 문자열 주세요.");
				sc.reset();
				continue;
			}
		}
	}

	public static String getNext(final String msg) {
		while (true) {
			UI.line = UI.getNextLine(msg);

			if (!UI.line.contains(" ")) {
				// 단어로 입력
				return UI.line;
			} else {
				// 띄어쓰기가 있으면
				System.out.println("다시!! 단어로 입력해주세요");
			}
		}

//		UI.line = UI.getNextLine(msg);
//		return UI.line;
	}

	// 한 사람의 정보 즉, 각 멤버 데이터를 순서적으로 입력 받아 p에 저장하고
	// 입력 중 입력 데이터에 오류가 있는지 확인하고 오류가 있을 시 에러 메시지를 출력한다.
	public static boolean inputPerson(Person p) {
		System.out.println("input person information:");
		Scanner scStr = new Scanner(System.in);
		p.input(scStr);
		return true;
	}

	// 입력을 받는 함수.
	public static int getInt(String msg) {
		Scanner sc = new Scanner(System.in);

		// 올바른 정수를 받을때 까지 for문을 돌린다.
		// for문안에 int value을 선언후 true을 이용해서 무한 while을 만든다.
		for (int value; true;) {
			System.out.print(msg);

			// 정수가 있다면
			if (sc.hasNextInt()) {
				// value에 정수 입력을 받는다
				value = sc.nextInt();
				// nextInt다음에 sc.nextLine을 넣어줘야 버터가 비워진다.
				sc.nextLine();
				return value;
			}
		}
	}

	// 하나의 양의 정수를 입력 받음?
	// 정수가 아닌 문자열 입력시 에러 메시지 출력 후 재입력 받기
	// 음수를 받으면 다시.
	public static int getPositiveInt(final String msg) {
		int value;
		while ((value = UI.getInt(msg)) < 0) { // 값을 얻으면서 체크
			System.out.println("Input a positive INTEGER.");
		}
		return value;
	}

	// 0-(size-1)사이의 선택된 메뉴 항목 또는 리스트의 항목의 인덱스 값을 리턴함
	// 존재하지 않는 메뉴항목을 선택한 경우 에러 출력
	public static int getIndex(final String msg, int size) {
		while (true) {
			// index의 값에는 무조건 양수가 나와야 되니
			// getPositiveInt()함수를 이용해서 양수를 받는다.
			int index = UI.getPositiveInt(msg);
			if (0 <= index && index < size) { // 사이즈 안에 잘들어갔는가
				return index;
			}
			System.out.println(index + ": OUT of selection range(0 ~ " + (size - 1) + ")");
		}
	}

	// selectMenu(메뉴선택) -> getIndex(인덱스 얻기) -> getPositiveInt(양수 얻기) -> getInt(정수
	// 얻기)
	// 메뉴선택을화면을 띄어주는 함수
	public static int selectMenu(final String menuStr, int menuItemCount) {// (menuStr 메뉴표시, 메뉴의 전체 정수)
		System.out.println("");
		System.out.print(menuStr);
		// getIndex을 이용해서 선택한 번호를 get한다.
		return getIndex("Menu item number? ", menuItemCount);
	}

	public static void main(String[] args) {
		String str = UI.getNext("문자열 입력 : ");

		System.out.println(str);
	}
}
