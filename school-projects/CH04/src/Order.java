// * Order - 주문 하나를 정의하는 클래스
public class Order {
	int menuNumbers[]; // 음료 가지수만큼 메뉴번호와
	int orderSizes[]; // 주문 수량을 저장할수있는
//	Menuboard menuboard;
	int cnt;

	public Order(int orderSize) {
		this.cnt = 0;
		this.menuNumbers = new int[orderSize];
		this.orderSizes = new int[orderSize];
//		this.menuboard = menuboard;
	}

	public boolean addMenu(int menuNumber, int orderSize) {
		// 만약 주문한 메뉴번호가 존재하지 않으면 에러를 출력하고 false 리턴한다.
		if (menuNumber > Menuboard.menus.length) {
			System.out.println("Menu id " + (menuNumber + 1) + " doesn't exist in our menuboard");
			return false;
		} else {
			this.menuNumbers[this.cnt] = menuNumber;
			this.orderSizes[this.cnt] = orderSize;
			cnt = cnt + 1;
			System.out.println("Your selected menu is added to the order");
			return true;
		}
	}

	public void print() {
		int menuNumber = 0;
		int price = 0;
		int orderSize = 0;
		String menu = "";
		System.out.println("** Order details **");
		for (int index = 0; index < this.cnt; index++) {
			menuNumber = this.menuNumbers[index]; // 선택한 메뉴의 번호를 할당
			orderSize = this.orderSizes[index]; // 선택한 메뉴의 사이즈 할당
			price = Menuboard.prices[menuNumber] * orderSize; // 선택한 메뉴 가격 * 사이즈
			menu = Menuboard.menus[menuNumber];

			System.out.println("Menu: " + menu + " Qty: " + orderSize + " Price: " + price);
		}
	}
}
