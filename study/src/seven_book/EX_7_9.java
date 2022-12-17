package seven_book;

class GStack<T, E> {
	int tos;
	Object[] stck;

	public GStack() {
		tos = 0;
		stck = new Object[10];
	}

	public E test(T str) {
		E test = (E) str;

		return test;
	}

	public void push(T item) {
		if (tos == 10) {
			return;
		}
		stck[tos++] = item;
	}

	public T pop() {
		if (tos == 0) {
			return null;
		}
		tos--;
		return (T) stck[tos];
	}

	static <Z> void toStack(Z[] a, GStack<Z, Z> gs) {
		for (int i = 0; i < a.length; i++) {
			gs.push(a[i]);
		}
	}
}

public class EX_7_9 {
	public static void main(String[] args) {
		GStack<String, String> stringStack = new GStack<String, String>();

		stringStack.push("seoul");
		stringStack.push("busan");
		stringStack.push("LA");

		for (int i = 0; i < 3; i++) {
			System.out.println(stringStack.pop());
		}
		System.out.println(stringStack.test("wer"));

		GStack<Integer, Integer> intStack = new GStack<Integer, Integer>();
		intStack.push(1);
		intStack.push(3);
		intStack.push(5);

		for (int i = 0; i < 3; i++) {
			System.out.println(intStack.pop());
		}

		String[] sArray = new String[100];
		GStack<String, String> sGS = new GStack<String, String>();
		GStack.toStack(sArray, sGS);
	}

}
