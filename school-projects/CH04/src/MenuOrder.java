import java.util.Scanner;

//* MenuOrder - 사용자로부터 값을 입력받고 주문을 생성하는 클래스 
public class MenuOrder {
	static public void print(Order order) {
		order.print();
	}

	static public void makeOrder() {
		System.out.println("***** Best Coffee ***** 부분 출력");
		Scanner sc = new Scanner(System.in);
		int allOrderSize = 0;

		// How many kinds of drinks? 4
		System.out.print("How many kinds of drinks? ");
		allOrderSize = sc.nextInt();

//		Menu no? 1
//		Quantity? 2
//		Your selected menu is added to the order
		int selecNum = 0;
		int selecQuan = 0;
		Order order = new Order(allOrderSize);
		for (int index = 0; index < allOrderSize; index++) {
			System.out.print("Menu no? ");
			selecNum = sc.nextInt();

			System.out.print("Quantity? ");
			selecQuan = sc.nextInt();
			if (!order.addMenu(--selecNum, selecQuan)) {
				allOrderSize = allOrderSize + 1;
			}

		}
		MenuOrder.print(order);
	}
}
