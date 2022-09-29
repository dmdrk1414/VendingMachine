package vendingmachine.model;

import java.util.ArrayList;

import vendingmachine.view.UI;

public class VendingMachine {
	final String MSG_NOT_Pick_Value = "VendingMachine.deletePickDrink";
	final String MSG_NOT_POSITIVE_INT = "VendingMachine.ErrPositiveCall";
	final String PRINT_MENU = "음료수 리스트: ";

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

	public void deletePickDrink(String nameDrink2Delete) {
		int deleteIndex = 0;
		if (isProductManagementValue(nameDrink2Delete, deleteIndex)) {
			this.productManagement.remove(deleteIndex);
		} else {
			UI.ErrNotPickValue(MSG_NOT_Pick_Value);
		}
	}

	private boolean isProductManagementValue(String nameDrink2Delete, int deleteIndex) {
		int endPos = (int) this.productManagement.size();
		for (int i = 0; i < endPos; i = i + 1) {
			Drink drink = this.productManagement.get(i);
			if (drink.isNameDrink(nameDrink2Delete)) {
				deleteIndex = i;
				return true;
			}
		}
		return false;
	}

	private boolean isPositiveNum(int num) {
		if (num >= 0) {
			return true;
		} else {
			UI.ErrPositiveCall(MSG_NOT_POSITIVE_INT);
			return false;
		}
	}

	public boolean strCheck(String inputString) {
		try {
			double a = Integer.parseInt(inputString);
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	// 테스트를 위한.
	public void showDrinkList() {
		System.out.print(PRINT_MENU);
		for (Drink drink : this.productManagement) {
			drink.showNameDrink();
		}
	}

	public static void main(String[] args) {
		VendingMachine machine = new VendingMachine();
		machine.showDrinkList();
	}

}
