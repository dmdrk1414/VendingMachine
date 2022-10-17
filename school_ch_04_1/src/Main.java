// Menu - 메뉴 하나를 정의하는 클래스
class Menu {
//	1. Menu 클래스의 멤버필드는 메뉴번호, 메뉴명, 가격을 저장하는 id, name, price 3개로 선언합니다.
	private int id;
	private String name;
	private int price;

//	2. Menu 클래스의 멤버필드는 private 접근자로 정의되어야 하며 생성자 및 setter, getter 메소드들을 정의합니다.
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

//	3. Menu 클래스에 메뉴번호, 메뉴명, 가격을 출력하는 print() 메소드를 정의합니다.
//	Americano [4.1]
	public void print() {
		double dPrice = (double) this.price / 1000;
//		System.out.println(this.name + " [" + dPrice + "]");
		System.out.printf("%s [%.1f]\n", this.name, dPrice);
	}

}

// Menuboard -  메뉴 보드를 정의하는 클래스
class Menuboard {
	static Menu[] menuManager = new Menu[1000];

//	4. Menuboard 클래스에 다음과 같이 메뉴명과 가격을 미리 저장해둔 배열 멤버필드를 선언합니다.
	static String[] menus = new String[] { "Americano", "Latte", "Mocca", "Cappuccino", "Milk Tea", "Chi Tea",
			"Lemon Sweet", "Jamong Honey" };
	static int[] prices = new int[] { 4100, 4300, 4300, 4800, 5100, 5300, 5800, 6100 };

//	5. Menuboard 클래스의 기본생성자를 private 접근자로 정의하여 외부에서 new 연산자로 객체 생성을 하지 못하도록 합니다.
	private Menuboard() {
	}

//	6. Menuboard 클래스에 makeBoard 메소드를 정의하여 Menu 객체들을 생성하고 배열에 저장합니다.
	public static Menuboard makeBoard() {
		int menusLen = menus.length;
		for (int index = 0; index < menusLen; index++) {
			Menu newMenu = new Menu();
			newMenu.setName(Menuboard.menus[index]);
			newMenu.setPrice(Menuboard.prices[index]);
			Menuboard.menuManager[index] = newMenu;
		}

		return (new Menuboard());
	}

//	7. Menuboard 클래스에 메뉴 보드를 출력하는 print() 메소드를 정의합니다.
	public void print() {
		System.out.println("***** Best Coffee *****");
		int indexNum = 0;
		int menusLen = menus.length;
		for (int index = 0; index < menusLen; index++) {
			indexNum = index + 1;
			System.out.print(indexNum + ": ");
			Menuboard.menuManager[index].print();
		}
		System.out.println("***********************");
	}
}

public class Main {
	public static void main(String[] args) {
		Menuboard mboard = Menuboard.makeBoard();
		mboard.print();
	}
}