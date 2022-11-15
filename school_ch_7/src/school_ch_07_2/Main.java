package school_ch_07_2;

import java.util.Scanner;
import java.util.Vector;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShapeFactory shapeFactory = new ShapeFactory();
		GraphicEditor g = new GraphicEditor(shapeFactory, sc);
		g.run();
		System.out.println("Good Bye");
		sc.close();
	}
}

enum MAIN_MENU {
	Insert_front(0), Insert_rear(1), Remove_front(2), Remove_rear(3), Move_front(4), Move_rear(5), list_all(6), Exit(7);

	MAIN_MENU(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

enum SHAPE_TYPE {
	Shape_Rect(0), Shape_Circle(1), Shape_Line(2);

	SHAPE_TYPE(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

class UI {
	static int getMainMenu(Scanner scanner) {
		System.out.println("Select one operation  ");
		System.out.print("Insert(Front):" + MAIN_MENU.Insert_front.value() + ", " + "Insert(Rear):"
				+ MAIN_MENU.Insert_rear.value() + ", " + "Remove(Front):" + MAIN_MENU.Remove_front.value() + ", "
				+ "Remove(Rear):" + MAIN_MENU.Remove_rear.value() + "\n" + "Move(Front):" + MAIN_MENU.Move_front.value()
				+ ", " + "Move(Rear):" + MAIN_MENU.Move_rear.value() + ", " + "Print List:" + MAIN_MENU.list_all.value()
				+ ", " + "Exit:" + MAIN_MENU.Exit.value() + " >> ");
		int nMenu = scanner.nextInt();
		return nMenu;
	}

	static int getShape(Scanner scanner) {
		System.out.println("Select one Shape  ");
		System.out.print("Rectangle:" + SHAPE_TYPE.Shape_Rect.value() + ", " + "Circle:"
				+ SHAPE_TYPE.Shape_Circle.value() + ", " + "Line:" + SHAPE_TYPE.Shape_Line.value() + " >> ");

		int sMenu = scanner.nextInt();
		return sMenu;
	}

	static public Point getWidthHeight(Scanner scanner, String msg) {
		System.out.print(msg);
		int width = scanner.nextInt();
		int height = scanner.nextInt();
		Point ptr = new Point(width, height);
		return ptr;
	}

	static public int getRadius(Scanner scanner, String msg) {
		System.out.print(msg);
		return scanner.nextInt();
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int width, int height) {
		this.x = this.x + width;
		this.y = this.y + height;
	}

	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}

abstract class Shape {
	public abstract String draw();

	public abstract void move(int width, int height);
}

class Line extends Shape {
	private Point p1;
	private Point p2;

	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String draw() {
		return toString();
	}

	@Override
	public String toString() {
		return ("Line " + this.p1 + " " + this.p2);
	}

	public void move(int width, int height) {
		p1.move(width, height);
		p2.move(width, height);
	}
}

class Rect extends Shape {
	private Point p1;
	private Point p2;

	public Rect(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String draw() {
		return toString();
	}

	@Override
	public String toString() {
		return ("Rectangle  " + this.p1 + " " + this.p2);
	}

	public void move(int width, int height) {
		p1.move(width, height);
		p2.move(width, height);
	}
}

class Circle extends Shape {
	private Point center;
	private int radius;

	public Circle(int radius, Point center) {
		this.center = center;
		this.radius = radius;
	}

	@Override
	public String draw() {
		return toString();
	}

	@Override
	public String toString() {
		return ("Circle " + this.radius + " " + this.center);
	}

	public void move(int width, int height) {
		center.move(width, height);
	}
}

interface LinkedList {
	public abstract void add_front(Shape value);

	public abstract void add_rear(Shape value);

	public abstract boolean isEmpty();

	public abstract Shape remove_front();

	public abstract Shape remove_rear();
}

class ShapeList implements LinkedList {
	private Vector vector;

	ShapeList() {
		vector = new Vector<Shape>();
	}

	ShapeList(Shape[] arr) {
		vector = new Vector<Shape>();
		for (int i = 0; i < arr.length; i++) {
			this.vector.add(arr[i]);
		}
	}

	public Shape get_frontValue() {
		if (isEmpty())
			return null;
		return (Shape) vector.firstElement();
	}

	public Object get_rearValue() {
		if (isEmpty())
			return null;
		return (Shape) vector.lastElement();
	}

	public void add_front(Shape value) {
		vector.add(0, value);
	}

	public void add_rear(Shape value) {
		vector.add(value);
	}

	public boolean isEmpty() {
		if (vector.isEmpty())
			return true;
		else
			return false;
	}

	public Shape remove_front() {
		if (isEmpty())
			return null;
		else
			return (Shape) vector.remove(0);
	}

	public Shape remove_rear() {
		if (isEmpty())
			return null;
		else
			return (Shape) vector.remove(vector.size() - 1);
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("");

		for (int i = 0; i < vector.size(); i++) {
			result.append("[");
			result.append(vector.get(i));
			result.append("]");
			if (i + 1 != vector.size())
				result.append("\r\n");
			else
				result.append("\n");
		}
		return result.toString();
	}

}

interface Factory {
	String msgpoint = "Enter point coordinates (enter two integers) >> ";

	ShapeList generateShapeList();

	Shape generateShape(Scanner scanner);
}

class ShapeFactory implements Factory {
	private Shape shapes[] = { new Rect(new Point(1, 1), new Point(2, 2)), new Rect(new Point(3, 3), new Point(4, 4)),
			new Rect(new Point(5, 5), new Point(6, 6)), new Circle(1, new Point(2, 2)), new Circle(3, new Point(4, 4)),
			new Circle(5, new Point(6, 6)), new Line(new Point(1, 1), new Point(2, 2)),
			new Line(new Point(3, 3), new Point(4, 4)), new Line(new Point(5, 5), new Point(6, 6)), };

	public ShapeList generateShapeList() {
		return new ShapeList(shapes);
	}

	public Shape generateShape(Scanner scanner) {
		SHAPE_TYPE shapeType;
		Point p1, p2;
		int radius;

		int type = UI.getShape(scanner);
		shapeType = SHAPE_TYPE.values()[type];
		Shape shape = null;

		String msgpoint = "Enter point coordinates (enter two integers) >> ";
		String msgradius = "Enter the radius (enter one integer) >> ";

		switch (shapeType) {
		case Shape_Rect:
			p1 = UI.getWidthHeight(scanner, msgpoint);
			p2 = UI.getWidthHeight(scanner, msgpoint);
			shape = new Rect(p1, p2);
			break;
		case Shape_Circle:
			p1 = UI.getWidthHeight(scanner, msgpoint);
			radius = UI.getRadius(scanner, msgradius);
			shape = new Circle(radius, p1);
			break;
		case Shape_Line:
			p1 = UI.getWidthHeight(scanner, msgpoint);
			p2 = UI.getWidthHeight(scanner, msgpoint);
			shape = new Line(p1, p2);
			break;
		}
		return shape;
	}
}

class GraphicEditor {
	private ShapeList list;
	private Factory factory;
	private Scanner scanner;

	GraphicEditor(Factory factory, Scanner scanner) {
		this.list = factory.generateShapeList();
		this.factory = factory;
		this.scanner = scanner;
	}

	private Shape crateShape(Scanner scanner) {
		return factory.generateShape(scanner);
	}

	public void run() {
		Shape shape = null;
		boolean bLoop = true;
		Point p1;
		String msgpoint = "The two integers to move along the X and Y axes (enter two integers) >> ";

		while (bLoop) {
			System.out.print(list);
			int n = UI.getMainMenu(scanner);
			MAIN_MENU menu = MAIN_MENU.values()[n];

			switch (menu) {
			case Insert_front:
				list.add_front(crateShape(scanner));
				break;
			case Insert_rear:
				list.add_rear(crateShape(scanner));
				break;
			case Remove_front:
				shape = (Shape) list.remove_front();
				break;
			case Remove_rear:
				shape = (Shape) list.remove_rear();
				break;
			case Move_front:
				if (list.get_frontValue() != null) {
					shape = (Shape) list.get_frontValue();
					p1 = UI.getWidthHeight(scanner, msgpoint);
					shape.move(p1.x, p1.y);
				}
				break;
			case Move_rear:
				if (list.get_rearValue() != null) {
					shape = (Shape) list.get_rearValue();
					p1 = UI.getWidthHeight(scanner, msgpoint);
					shape.move(p1.x, p1.y);
				}
				break;
			case list_all:
				// System.out.print(list.toString());
				break;
			case Exit:
				bLoop = false;
			}
		}
	}
}