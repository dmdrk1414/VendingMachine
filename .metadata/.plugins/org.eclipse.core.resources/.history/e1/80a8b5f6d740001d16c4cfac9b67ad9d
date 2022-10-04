package vendingmachine.view;

public class MainMenu {
	final private int MENU_COUNTER_NUMBER = 8;
	final private String MANU_SELCEK_STRING = "메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품등록 4.제품삭제 5.제품업데이트 6.제품보기 7.제품선택 |";

	public void run() {
		VendingActionView vendingActionView = new VendingActionView();
		int manuCounter = MENU_COUNTER_NUMBER;
		int selectMenuCount = UI.returnSelectMenuNum(manuCounter, MANU_SELCEK_STRING);
		while (true) {
			if (selectMenuCount == 0) { // menu 0.나가기
				return;
			}
			switch (selectMenuCount) {
			case 1: // menu 1.동전넣기 /
				vendingActionView.putInVendingMachineCoin();
				break;
			case 2: // menu 2.동전반환 /
				vendingActionView.returnCoin2VendingMachine();
				break;
			case 3: // menu 3.제품등록 /
				vendingActionView.registerNewDrink();
				break;
			case 4: // menu 4.제품삭제 /
				vendingActionView.deleteExistDrink2VendingMachine();
				break;
			case 5: // menu 5.제품업데이트 /
				vendingActionView.updateDrinkInfo2VendingMachine();
				break;
			case 6: // menu 6.제품보기 /
				vendingActionView.showDrinks2user();
				break;
			case 7: // menu 7.제품선택
				vendingActionView.chooseDrink2VendingMachine();
				break;
			}
		}
	}
}
