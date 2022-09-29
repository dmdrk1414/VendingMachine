package vendingmachine.model;

public class Drink {
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
		this.stockDrink = this.stockDrink + stockIncrease;
	}
	// test

	public void subtractStockOfDrink(int stockDecrease) {
		this.stockDrink = this.stockDrink + stockDecrease;
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
}
