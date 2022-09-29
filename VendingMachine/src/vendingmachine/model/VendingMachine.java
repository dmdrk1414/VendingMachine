package vendingmachine.model;

import java.util.ArrayList;

public class VendingMachine {
	// 여기는 기계를 만드는 개념이다.
	private ArrayList<Drink> productManagement;

	public VendingMachine() {
		this.productManagement = new ArrayList<>();
		this.productManagement.add(new Drink("사이다", 300, 10));
		this.productManagement.add(new Drink("콜라", 500, 10));
		this.productManagement.add(new Drink("환타", 400, 10));
	}
}
