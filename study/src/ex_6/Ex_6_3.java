package ex_6;

class Point_3 {
	int x, y;

	public Point_3(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Point_3 p = (Point_3) obj;
		if (x == p.x && y == p.y) {
			return true;
		}
		return false;
	}
}

public class Ex_6_3 {
	public static void main(String[] args) {
		Point_3 p = new Point_3(2, 3);
		System.out.println(p.toString());
		System.out.println(p);
		System.out.println(p + "입니다.");
	}
}
