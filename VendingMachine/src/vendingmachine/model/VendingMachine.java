package vendingmachine.model;

import java.util.HashMap;

public class VendingMachine {
	// 여기는 기계를 만드는 개념이다.
	private String nameDrink;
	private int priceDrink;
	private int stockDrink; // stock은 재고를 말한다.
	private HashMap<String, Integer> productManagement;

	public VendingMachine() {
		String[] nameDrinkArr = new String[] { "사이다", "콜라", "환타" };
		int[] priceDrinkArr = new int[] { 300, 500, 400 };
		this.productManagement = new HashMap<>();

		int sizeProductManagement = nameDrinkArr.length;
		for (int i = 0; i < sizeProductManagement; i++) {
			this.productManagement.put(nameDrinkArr[i], priceDrinkArr[i]);
		}
	}

	public void addStockOfDrink(int stockIncrease) {
		this.stockDrink = this.stockDrink + stockIncrease;
	}
	// test

	public void subtractStockOfDrink(int stockDecrease) {
		this.stockDrink = this.stockDrink + stockDecrease;
	}

	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();
	}
}
