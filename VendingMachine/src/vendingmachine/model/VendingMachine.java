package vendingmachine.model;

import java.util.ArrayList;

import vendingmachine.view.UI;

public class VendingMachine {
	final private String PRINT_MENU = "음료수 리스트: ";

	private static int index;
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
		if (UI.isPositiveNum(coinInsert)) {
			this.amountCoin = this.amountCoin + coinInsert;
		}
	}

	public int returnAllAmountCoin() {
		if (this.amountCoin != 0) {
			int getAmountCoin = this.amountCoin;
			this.amountCoin = 0;
			return getAmountCoin;
		} else {
			return 0;
		}
	}

	public void registerDrink(String nameDrink, int priceDrink, int stockDrink) {
		// TODO: registerDrink 같은 이름이 있는지 확인을 해야됨. 추가.
		if (UI.isStrCheck(nameDrink) && UI.isPositiveNum(priceDrink) && UI.isPositiveNum(stockDrink)) {
			this.productManagement.add(new Drink(nameDrink, priceDrink, stockDrink));
		}
	}

	public void deletePickDrink(String nameDrink2Delete) {
		if (isProductManagementValue(nameDrink2Delete)) {
			int deleteIndex = VendingMachine.index;
			this.productManagement.remove(deleteIndex);
		} else {
			UI.ErrNotPickValue("");
		}
	}

	public boolean isUpdateDrinkInfo(String pickNameDrink, String nameChange, int priceChange) {
		try {
			if (isPickDrinkEmpty(pickNameDrink) && UI.isPositiveNum(priceChange)) {
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
		if (isProductManagementValue(pickNameDrink)) {
			int pickDrinkIndex = VendingMachine.index;
			Drink drink = this.productManagement.get(pickDrinkIndex);
			return drink;
		}
		return null;
	}

	private boolean isPickDrinkEmpty(String pickNameDrink) {
		return isNameDrink(pickNameDrink);
	}

	private boolean isNameDrink(String pickNameDrink) {
		if (isProductManagementValue(pickNameDrink)) {
			int pickDrinkIndex = VendingMachine.index;
			Drink pickDrink = this.productManagement.get(pickDrinkIndex);
			return !pickDrink.isStockEmpty();
		} else {
			return false;
		}
	}

	private boolean isProductManagementValue(String nameDrink2search) {
		int endPos = (int) this.productManagement.size();
		for (int i = 0; i < endPos; i = i + 1) {
			Drink drink = this.productManagement.get(i);
			if (drink.isNameDrink(nameDrink2search)) {
				VendingMachine.index = i;
				return true;
			}
		}
		return false;
	}
}
