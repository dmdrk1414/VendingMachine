
public class MainMenu {
	public void run() {
		int menuCount = 2; // 상수 정의
		String menuStr = "******************************* Main Menu *********************************\n* 0.Exit 1.Class:Object(ch3_1)                                            *\n***************************************************************************\n";

		UI ui = new UI();
		while (true) {
			int menuItem = ui.selectMenu(menuStr, menuCount);
			if (menuItem == 0) {
				break;
			}
			switch (menuItem) {
				case 1:
					ClassAndObject classandobject = new ClassAndObject();
					classandobject.run();
					break;
			}
		}
		System.out.println("잘가세요~~");
	}
}
