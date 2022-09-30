package vendingmachine.model;

import java.util.ArrayList;

import vendingmachine.view.UI;

public class VendingMachine {
	final String MSG_NOT_Pick_Value = "VendingMachine.deletePickDrink";
	final String MSG_NOT_POSITIVE_INT = "VendingMachine.ErrPositiveCall";
	final String PRINT_MENU = "음료수 리스트: ";

	private int amountCoin;
	private ArrayList<Drink> productManagement;
	private String namePickDrink;

	public VendingMachine() {
		this.productManagement = new ArrayList<>();
		this.productManagement.add(new Drink("사이다", 300, 10));
		this.productManagement.add(new Drink("콜라", 500, 10));
		this.productManagement.add(new Drink("환타", 400, 10));

		this.amountCoin = 0;
		this.namePickDrink = "";
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

	public boolean isUpdateDrinkInfo(String pickNameDrink, String nameChange, int priceChange) {
		try {
			if (isPickDrinkEmpty(pickNameDrink) && isPositiveNum(priceChange)) {
				Drink drink = getPickDrink(pickNameDrink);
				drink.updateInfoDrink(nameChange, priceChange);
				return true;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return false;

	}

	public void showDrinkList() {
		System.out.print(PRINT_MENU);
		for (Drink drink : this.productManagement) {
			drink.showNameDrink();
		}
		System.out.println();
	}

	public void pickDrinkType(String pickNameDrink) {
		if (!isPickDrinkEmpty(pickNameDrink)) {
			this.namePickDrink = pickNameDrink;
		} else {
			UI.ErrNotPickStock(pickNameDrink);
		}
	}

	private Drink getPickDrink(String pickNameDrink) throws NullPointerException {
		int pickDrinkIndex = 0;
		if (isProductManagementValue(pickNameDrink, pickDrinkIndex)) {
			Drink drink = this.productManagement.get(pickDrinkIndex);
			return drink;
		}
		return null;
	}

	private boolean isPickDrinkEmpty(String pickNameDrink) {
		return isNameDrink(pickNameDrink);
	}

	private boolean isNameDrink(String pickNameDrink) {
		int pickDrinkIndex = 0;
		if (isProductManagementValue(pickNameDrink, pickDrinkIndex)) {
			Drink pickDrink = this.productManagement.get(pickDrinkIndex);
			return !pickDrink.isStockEmpty();
		} else {
			return false;
		}
	}

	private boolean isProductManagementValue(String nameDrink2search, int searchIndex) {
		int endPos = (int) this.productManagement.size();
		for (int i = 0; i < endPos; i = i + 1) {
			Drink drink = this.productManagement.get(i);
			if (drink.isNameDrink(nameDrink2search)) {
				searchIndex = i;
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
}
