import java.util.Scanner;

// TODO: Menu - 메뉴 하나를 정의하는 클래스
class Menu {
//	Menu 클래스의 멤버필드는 메뉴번호, 메뉴명, 가격을 저장하는 id, name, price 3개로 선언합니다.
	private int id;
	private String name;
	private int price;

//	Menu 클래스의 멤버필드는 private 접근자로 정의되어야 하며 생성자 및 setter, getter 메소드들을 정의합니다.
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

//	Menu 클래스에 메뉴번호, 메뉴명, 가격을 출력하는 print() 메소드를 정의합니다.
//	Americano [4.1]
	public void print() {
		double dPrice = (double) this.price / 1000;
//		System.out.println(this.name + " [" + dPrice + "]");
		System.out.printf("%s [%.1f]\n", this.name, dPrice);
	}

}

// TODO: Menuboard -  메뉴 보드를 정의하는 클래스
class Menuboard {
	public static Menu[] menuManager = new Menu[1000];

//	Menuboard 클래스에 다음과 같이 메뉴명과 가격을 미리 저장해둔 배열 멤버필드를 선언합니다.
	public static String[] menus = new String[] { "Americano", "Latte", "Mocca", "Cappuccino", "Milk Tea", "Chi Tea",
			"Lemon Sweet", "Jamong Honey" };
	static int[] prices = new int[] { 4100, 4300, 4300, 4800, 5100, 5300, 5800, 6100 };

//	Menuboard 클래스의 기본생성자를 private 접근자로 정의하여 외부에서 new 연산자로 객체 생성을 하지 못하도록 합니다.
	private Menuboard() {
	}

//	Menuboard 클래스에 makeBoard 메소드를 정의하여 Menu 객체들을 생성하고 배열에 저장합니다.
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

//	Menuboard 클래스에 메뉴 보드를 출력하는 print() 메소드를 정의합니다.
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

// TODO: 1. Order 클래스에 음료 가지수만큼 메뉴번호와 주문수량을 저장할 수 있는 두 개의 정수 배열을 선언합니다.
class Order {
	public int[] numsMenuUserSeleck;
	public int[] numSizeUserOrder;
	public int addIndexMenu;

//	TODO: 2. Order 클래스 생성자를 정의합니다.
	public Order(int numAllOrder) {
		this.numsMenuUserSeleck = new int[numAllOrder];
		this.numSizeUserOrder = new int[numAllOrder];
		this.addIndexMenu = 0;
	}

//	TODO: 3. Order 클래스에 addMenu 메소드를 정의하여 주문하는 메뉴번호와 수량을 배열에 저장합니다.
	public void addMenu(int getNumsMenuUserSeleck, int getNumSizeUserOrder) {
		int addIndex = this.addIndexMenu;
		int nextOrderMenuIndex = 1;

		this.numsMenuUserSeleck[addIndex] = getNumsMenuUserSeleck;
		this.numSizeUserOrder[addIndex] = getNumSizeUserOrder;
		this.addIndexMenu = this.addIndexMenu + nextOrderMenuIndex;
	}

//	TODO: 4. Order 클래스에 print 메소드를 정의하여 주문 내역을 출력합니다.
	public void print() {
//		Menu: Americano Qty: 2 Price: 8200
//		Menu: Mocca Qty: 2 Price: 8600
//		Menu: Milk Tea Qty: 1 Price: 5100
//		Menu: Jamong Honey Qty: 3 Price: 18300

		System.out.println("** Order details **");

		int orderIndexLen = this.numsMenuUserSeleck.length;
		int orderNextIndex = 1;
		for (int index = 0; index < orderIndexLen; index += orderNextIndex) {
			int indexMenuUserSeleck = this.numsMenuUserSeleck[index];

			int valueNumSizeUserOrder = this.numSizeUserOrder[index];
			String nameMenuSeleck = Menuboard.menus[indexMenuUserSeleck];
			int priceMenuSeleck = Menuboard.prices[indexMenuUserSeleck];
			int realPrice = priceMenuSeleck * valueNumSizeUserOrder;

			System.out.println("Menu: " + nameMenuSeleck + " Qty: " + valueNumSizeUserOrder + " Price: " + realPrice);
		}
	}

}

//	TODO: 5. MenuOrder 클래스는 
//	Menuboard 객체를 생성하여 메뉴보드를 출력하고 
//  사용자로부터 입력을 받은 다음 
//  Order 객체를 생성하고 내역을 출력합니다.
class MenuOrder {
	public static void makeOrder() {
		Menuboard menuboard = Menuboard.makeBoard();
		menuboard.print();

		Scanner sc = new Scanner(System.in);
		System.out.print("How many kinds of drinks? ");

		int allNumOrder = sc.nextInt();
		Order order = new Order(allNumOrder);

		int boundSize = Menuboard.menus.length;
		for (int index = 0; index < allNumOrder; index++) {
			System.out.print("Menu no? ");
			int numMenu = sc.nextInt();
			System.out.print("Quantity? ");
			int QuantityMenu = sc.nextInt();

			if (numMenu <= boundSize) {
				order.addMenu(numMenu - 1, QuantityMenu);
				System.out.println("Your selected menu is added to the order");
			} else {
				index--;
				System.out.println("Menu id " + numMenu + " doesn't exist in our menuboard");
			}
		}
		order.print();
	}
}

//Main 클래스의 main 메소드는 다음과 같습니다.
public class Main {
	public static void main(String[] args) {
		MenuOrder.makeOrder();
	}
}