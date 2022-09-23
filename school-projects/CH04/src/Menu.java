//* Menu - 메뉴 하나를 정의하는 클래스
public class Menu {
	private int id;
	private double price;
	private String name;

	public Menu(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void print() {
		double pointGetPrice = this.getPrice() / 1000;
		System.out.println(this.getId() + ": " + this.getName() + " [" + pointGetPrice + "]");
	}

	public static void main(String[] args) {
		Menu menu = new Menu(1, "짱구", 3000);
		menu.print();
	}
}
