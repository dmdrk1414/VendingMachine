package seven_book;

public class EX_7_10 {
	public static <T> GStack<T, T> reverse(GStack<T, T> a) {
		GStack<T, T> s = new GStack<T, T>();
		while (true) {
			T tmp;
			tmp = a.pop();
			if (tmp == null) {
				break;
			} else {
				s.push(tmp);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		GStack<Double, Double> gs = new GStack<Double, Double>();

		for (int i = 5; i > 0; i--) {
			gs.push(Double.valueOf(i));
		}
		gs = reverse(gs);
		for (int i = 0; i < 5; i++) {
			System.out.println(gs.pop());
		}

	}
}
