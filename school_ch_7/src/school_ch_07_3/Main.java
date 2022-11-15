package school_ch_07_3;

import java.util.Scanner;
import java.util.Vector;

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

enum GraphicMenu {
	EXIT(0), RECT(1), CIRCLE(2), LINE(3);

	GraphicMenu(int value) {
		this.value = value;
	}

	private final int value;

	public int value() {
		return value;
	}
}

class UI {
	static GraphicMenu getGraphicMenu(Scanner scanner) {
		System.out.println("***** Graphic Management Menu ******");
		System.out.println("* " + GraphicMenu.EXIT.value() + ".Exit  " + GraphicMenu.RECT.value() + ".Rect  "
				+ GraphicMenu.CIRCLE.value() + ".Circle  " + GraphicMenu.LINE.value() + ".Line *");
		System.out.println("************************************");
		System.out.print("Menu item number? ");
		GraphicMenu menu[] = GraphicMenu.values();
		return menu[scanner.nextInt()];
	}

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

interface LinkedList<T> {
	public abstract void add_front(T value);

	public abstract void add_rear(T value);

	public abstract boolean isEmpty();

	public abstract T remove_front();

	public abstract T remove_rear();
}

class ShapeList<T> implements LinkedList<T> {
	private Vector<T> vector;

	ShapeList() {
		vector = new Vector<T>();
	}

	ShapeList(T[] arr) {
		vector = new Vector<T>();
		for (int i = 0; i < arr.length; i++) {
			this.vector.add(arr[i]);
		}
	}

	public T get_frontValue() {
		if (isEmpty())
			return null;
		return vector.firstElement();
	}

	public T get_rearValue() {
		if (isEmpty())
			return null;
		return vector.lastElement();
	}

	public void add_front(T value) {
		vector.add(0, value);
	}

	public void add_rear(T value) {
		vector.add(value);
	}

	public boolean isEmpty() {
		if (vector.isEmpty())
			return true;
		else
			return false;
	}

	public T remove_front() {
		if (isEmpty())
			return null;
		else
			return vector.remove(0);
	}

	public T remove_rear() {
		if (isEmpty())
			return null;
		else
			return vector.remove(vector.size() - 1);
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

// ###############################################################################
// Factory class ##############################################################
interface Factory<T> {
	String msgpoint = "Enter point coordinates (enter two integers) >> ";

	ShapeList<T> generateShapeList();

	T generateShape(Scanner scanner);
}

// ###############################################################################
// ShapeFactory class ##############################################################
//class ShapeFactory implements Factory {
//	private Shape shapes[] = { new Rect(new Point(1, 1), new Point(2, 2)), new Rect(new Point(3, 3), new Point(4, 4)),
//			new Rect(new Point(5, 5), new Point(6, 6)), new Circle(1, new Point(2, 2)), new Circle(3, new Point(4, 4)),
//			new Circle(5, new Point(6, 6)), new Line(new Point(1, 1), new Point(2, 2)),
//			new Line(new Point(3, 3), new Point(4, 4)), new Line(new Point(5, 5), new Point(6, 6)), };
//
//	public ShapeList generateShapeList() {
//		return new ShapeList(shapes);
//	}
//
//	public Shape generateShape(Scanner scanner) {
//		SHAPE_TYPE shapeType;
//		Point p1, p2;
//		int radius;
//
//		int type = UI.getShape(scanner);
//		shapeType = SHAPE_TYPE.values()[type];
//		Shape shape = null;
//
//		String msgpoint = "Enter point coordinates (enter two integers) >> ";
//		String msgradius = "Enter the radius (enter one integer) >> ";
//
//		switch (shapeType) {
//		case Shape_Rect:
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Rect(p1, p2);
//			break;
//		case Shape_Circle:
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			radius = UI.getRadius(scanner, msgradius);
//			shape = new Circle(radius, p1);
//			break;
//		case Shape_Line:
//			p1 = UI.getWidthHeight(scanner, msgpoint);
//			p2 = UI.getWidthHeight(scanner, msgpoint);
//			shape = new Line(p1, p2);
//			break;
//		}
//		return shape;
//	}
//}

//###############################################################################
//ShapeFactory class #############################################################
class RectFactory implements Factory<Rect> // 사각형 객체를 생성하는 클래스
{
	private Rect rects[] = { // ShapeList 생성시 자동 삽입될 객체들
			new Rect(new Point(1, 1), new Point(2, 2)), new Rect(new Point(3, 3), new Point(4, 4)),
			new Rect(new Point(5, 5), new Point(6, 6)), };

	public ShapeList<Rect> generateShapeList() { // ShapeList 생성
		return new ShapeList<>(rects);
		// 이문장은 GraphicEditor 생성자에 의해 호출된다.
		// 리턴된 list는 위 rects[]의 3개의 Rect 객체들을 포함하고 있다.
	}

	// 사용자로부터 사각형 정보를 입력 받은 후 사각형 객체를 생생하여 반환함. 기존 ShapeFactory의
	// generateShape()의 switch 코드들 중 사각형 객체 생성하는 코드만 발췌해서 삽입
	public Rect generateShape(Scanner scanner) {
		Point p1 = UI.getWidthHeight(scanner, msgpoint);
		Point p2 = UI.getWidthHeight(scanner, msgpoint);
		return new Rect(p1, p2);
	}
}

class CircleFactory implements Factory<Circle> // 원 객체를 생성하는 클래스
{
	private String msgradius = "Enter the radius (enter one integer) >> ";

	private Circle circles[] = { // ShapeList 생성시 자동 삽입될 객체들
			new Circle(1, new Point(2, 2)), new Circle(3, new Point(4, 4)), new Circle(5, new Point(6, 6)), };

	@Override
	public ShapeList<Circle> generateShapeList() {
//    generateShapeList() 메소드 구현
		return new ShapeList<>(circles);
	}

	@Override
	public Circle generateShape(Scanner scanner) {
//    generateShape() 메소드 구현할 것
		Point p1 = UI.getWidthHeight(scanner, msgpoint);
		int radius = UI.getRadius(scanner, msgradius);
		return new Circle(radius, p1);
	}

}

class LineFactory implements Factory<Line> // 선 객체를 생성하는 클래스
{
	private Line lines[] = { // ShapeList 생성시 자동 삽입될 객체들
			new Line(new Point(1, 1), new Point(2, 2)), new Line(new Point(3, 3), new Point(4, 4)),
			new Line(new Point(5, 5), new Point(6, 6)), };

	@Override
	public ShapeList<Line> generateShapeList() {
		// generateShapeList() 메소드 구현
		return new ShapeList<>(lines);
	}

	@Override
	public Line generateShape(Scanner scanner) {
//    generateShape() 메소드 구현할 것
		Point p1 = UI.getWidthHeight(scanner, msgpoint);
		Point p2 = UI.getWidthHeight(scanner, msgpoint);
		return new Line(p1, p2);
	}
}

class GraphicEditor<T extends Shape> {
	private ShapeList<T> list;
	private Factory<T> factory;
	private Scanner scanner;

	GraphicEditor(Factory<T> factory, Scanner scanner) {
		this.list = factory.generateShapeList();
		this.factory = factory;
		this.scanner = scanner;
	}

	private T crateShape(Scanner scanner) {
		return factory.generateShape(scanner);
	}

	public void run() {
		T shape = null;
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
				shape = (T) list.remove_front();
				break;
			case Remove_rear:
				shape = (T) list.remove_rear();
				break;
			case Move_front:
				if (list.get_frontValue() != null) {
					shape = (T) list.get_frontValue();
					p1 = UI.getWidthHeight(scanner, msgpoint);
					shape.move(p1.x, p1.y);
				}
				break;
			case Move_rear:
				if (list.get_rearValue() != null) {
					shape = list.get_rearValue();
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

class GraphicManager {
	private Scanner scanner;
	private GraphicEditor<Rect> rectEditor;
	private GraphicEditor<Circle> circleEditor;
	private GraphicEditor<Line> lineEditor;

	// 각각의 Rect, Circle 또는 Line을 전용으로 관리하는 GraphicEditor< >를 미리 생성해 놓는다.
	// 각 GraphicEditor는 해당 그래픽 객체를 생성하는 Factory 객체를 가지며,
	// 이 Factory 객체를 통해 ShapList< >와 해당 그래픽 객체만을 전적으로 생성한다.
	GraphicManager() {
		scanner = new Scanner(System.in);
		rectEditor = new GraphicEditor<Rect>(new RectFactory(), scanner);
		circleEditor = new GraphicEditor<Circle>(new CircleFactory(), scanner);
		lineEditor = new GraphicEditor<Line>(new LineFactory(), scanner);
	}

	// 사용자가 Rect, Circle, Line 중 하나를 선택하게 하고
	// 선택된 그래픽 객체들을 전용으로 관리하는 GraphicEditor< >의 run() 메소드를 호출한다.
	void run() {
		while (true) {
			GraphicMenu menu = UI.getGraphicMenu(scanner); // 메뉴 항목 읽어 오기
			if (menu == GraphicMenu.EXIT)
				break;
			switch (menu) {
			case RECT:
				System.out.println("\nGraphicEditor<Rect>");
				rectEditor.run();
				break;
			case CIRCLE:
				System.out.println("\nGraphicEditor<Circle>");
				circleEditor.run();
				break;
			case LINE:
				System.out.println("\nGraphicEditor<Line>");
				lineEditor.run();
				break;
			default:
				System.out.println("WRONG menu item");
				break;
			}
			System.out.println();
		}
		scanner.close();
	}
}

// ###############################################################################
// Main class ##############################################################
public class Main {
	public static void main(String[] args) {
		GraphicManager m = new GraphicManager();
		m.run();
		System.out.println("\nGood Bye");
	}
}