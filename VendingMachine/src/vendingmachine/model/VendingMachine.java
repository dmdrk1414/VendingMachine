package vendingmachine.model;

import java.util.ArrayList;

public class VendingMachine {
	private int amountCoin;
	private ArrayList<Drink> productManagement;

	public VendingMachine() {
		this.productManagement = new ArrayList<>();
		this.productManagement.add(new Drink("사이다", 300, 10));
		this.productManagement.add(new Drink("콜라", 500, 10));
		this.productManagement.add(new Drink("환타", 400, 10));
	}

	public boolean isCoinEmpty() {
		if (this.amountCoin == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void addCoin2VendingMachine(int coinInsert) {
		if (isPositiveNum(coinInsert)) {
			this.amountCoin = this.amountCoin + coinInsert;
		}
	}

	public int returnAllAmountCoin() {
		if (this.amountCoin != 0) {
			return this.amountCoin;
		} else {
			return 0;
		}
	}

	public void registerDrink(String nameDrink, int priceDrink, int stockDrink) {
		if (strCheck(nameDrink) && isPositiveNum(priceDrink) && isPositiveNum(stockDrink)) {
			this.productManagement.add(new Drink(nameDrink, priceDrink, stockDrink));
		}
	}

	private boolean isPositiveNum(int num) {
		if (num >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean strCheck(String inputString) {
		try {
			double a = Integer.parseInt(inputString);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

}
