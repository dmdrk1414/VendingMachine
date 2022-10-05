
public enum DrinkType {
	사이다("사이다", 100), 콜라("콜라", 100), 환타("환타", 100);

	static int vale = 100;

//	사이다(100), 콜라(100), 환타(100);

	String name;
	int stuckDrink;

	DrinkType(String name, int stock) {
		this.stuckDrink = stock;
		this.name = name;
	}

	public void addSida(int add) {
		this.stuckDrink += add;
	}

}
