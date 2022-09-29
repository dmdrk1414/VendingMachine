package vendingmachine.model;

import vendingmachine.view.UI;

public class Drink {
	final String MSG_NOT_POSITIVE_INT = "Drink.updateInfoDrink";
	final String MSG_NOT_STRING = "Drink.updateInfoDrink";

	private String nameDrink;
	private int priceDrink;
	private int stockDrink; // stock은 재고를 말한다.

	public Drink() {
		System.out.println("Drink에 이름, 가격, 재고현황을 추가해줘");
	}

	public Drink(String nameDrink, int priceDrink, int stockDrink) {
		this.nameDrink = nameDrink;
		this.priceDrink = priceDrink;
		this.stockDrink = stockDrink;
	}

	public void addStockOfDrink(int stockIncrease) {
		if (isPositiveNum(stockIncrease)) {
			this.stockDrink = this.stockDrink + stockIncrease;
		}
	}

	public void subtractStockOfDrink(int stockDecrease) {
		if(isPositiveNum(stockDecrease)) {
		this.stockDrink = this.stockDrink + stockDecrease;
		}
	}

	public boolean isNameDrink(String suppositionName) {
		if (this.nameDrink.equals(suppositionName)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isStockEmpty() {
		if (this.stockDrink == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void showNameDrink() {
		System.out.print(this.nameDrink + " ");
	}

	public void updateInfoDrink(String nameChange, int priceChange) {
		if (strCheck(nameChange) && isPositiveNum(priceChange)) {
			this.nameDrink = nameChange;
			this.priceDrink = priceChange;
		}
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
			UI.ErrNotString(MSG_NOT_STRING);
			return false;
		} catch (Exception e) {
			return true;
		}
	}
}
