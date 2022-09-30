package vendingmachine.model;

import vendingmachine.view.UI;

public class Person {
	private int coin;

	public Person() {
		this.coin = 2000;
	}

	public void addCoinCnt(int coin2Add) {
		if (UI.isPositiveNum(coin2Add)) {
			this.coin = this.coin + coin2Add;
		}
	}

	public void subtractCoinCnt(int coin2Add) {
		if (UI.isPositiveNum(coin2Add)) {
			this.coin = this.coin - coin2Add;
		}
	}
}
