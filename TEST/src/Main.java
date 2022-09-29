import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String args[]) {
		HashMap<String, Integer> test = new HashMap<>();
		test.put("나랑드", 1234);
		test.put("오렌지", 41234);
		test.put("사이다", 123);

		Iterator<String> keys = test.keySet().iterator();
		while (keys.hasNext()) {
			System.out.println(keys.next());
		}
	}
}
