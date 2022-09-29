package vendingmachine.model;

public class VendingMachine {
	private String nameDrink;
	private int priceDrink;
	private int stockDrink; // stock은 재고를 말한다.

	public void addStockOfDrink(int stockIncrease) {
		this.stockDrink = this.stockDrink + stockIncrease;
	}
	// test

	public void subtractStockOfDrink(int stockDecrease) {
		this.stockDrink = this.stockDrink + stockDecrease;
	}
}
