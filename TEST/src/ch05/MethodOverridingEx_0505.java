package ch05;

// 부모 클래스
class Shape {
	public Shape next;

	public Shape() {
		this.next = null;
	}

	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}

class Rect extends Shape {
	public void draw() {
		System.out.println("Rect");
	}
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle");
	}
}

public class MethodOverridingEx_0505 {
	static void paint(Shape p) {
		p.draw();
	}

	public static void main(String[] args) {
		Line line = new Line();

		// 다음 호출들은 모두 paint() 메소드 내에서 shape에 대한 레퍼런스 p로 업캐스팅됨
		// 오버 라이딩을 사용함.
		MethodOverridingEx_0505.paint(new Shape());
		MethodOverridingEx_0505.paint(new Line());
		MethodOverridingEx_0505.paint(new Rect());
		MethodOverridingEx_0505.paint(new Circle());
	}
}
