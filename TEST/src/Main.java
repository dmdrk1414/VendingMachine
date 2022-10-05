public class Main {

	public static void main(String args[]) {
		for (DrinkType a : DrinkType.values()) {
			a.addSida(3);
			System.out.println(a.stuckDrink);
		}
	}
}