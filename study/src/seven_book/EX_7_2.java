package seven_book;

import java.util.Iterator;
import java.util.Vector;

class Point {
	private int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}

public class EX_7_2 {
	public static void main(String[] args) {
		Vector<Point> v = new Vector<Point>();

		// 3개의 Point 객체 삽입
		v.add(new Point(2, 3));
		v.add(new Point(5, 20));
		v.add(new Point(20, 300));

//		v.remove(1);

		for (Iterator iterator = v.iterator(); iterator.hasNext();) {
			Point point = (Point) iterator.next();
			System.out.println(point);
		}

//		System.out.println(v);
	}
}
