package ch05;

class Point {
	private int x, y;

	public Point() {
		this.x = this.y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void showPoint() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	}

}

class ColorPoint extends Point {
	private String color;

	public ColorPoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	public void showColorPoint() {
		System.out.print(color);
		super.showPoint();
	}
}

public class SuperEx_0503 {
	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 6, "blue");
		cp.showColorPoint();
	}
}