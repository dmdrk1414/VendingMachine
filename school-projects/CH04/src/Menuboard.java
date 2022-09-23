//* Menuboard -  메뉴 보드를 정의하는 클래스
public class Menuboard {
	static String[] menus = new String[] { "Americano", "Latte", "Mocca", "Cappuccino", "Milk Tea", "Chi Tea",
			"Lemon Sweet", "Jamong Honey" };
	static int[] prices = new int[] { 4100, 4300, 4300, 4800, 5100, 5300, 5800, 6100 };
	static Menu menuList[];
	static Menu makeInstenseMenu[];

	private Menuboard() {
	}

	static public Menuboard makeBoard() {
		Menuboard.makeInstenseMenu = new Menu[Menuboard.menus.length];

		for (int index = 0; index < Menuboard.menus.length; index++) {
			Menuboard.makeInstenseMenu[index] = new Menu(index + 1, Menuboard.menus[index], Menuboard.prices[index]);
		}
		return new Menuboard();
	}

	public void print() {
		System.out.println("***** Best Coffee *****");
		for (int index = 0; index < Menuboard.menus.length; index++) {
			Menuboard.makeInstenseMenu[index].print();
		}
		System.out.println("***********************");
	}
}
