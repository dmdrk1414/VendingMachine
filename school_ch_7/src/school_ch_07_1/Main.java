package school_ch_07_1;

import java.util.Scanner;
import java.util.Vector;

//메뉴 선택에서 사용할 메뉴 이름에 대한 열거형 선언 MAIN_MENU:연산 정의:
//연산은 리스트에 대한 연산을 정의 삽입(앞),삽입(뒤),삭제(앞),삭제(뒤),이동(맨 앞 데이터),이동(맨 뒤 데이터),리스트 출력,종료
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

// SHAPE_TYPE:생성할 Shape Rect,Circel,Line
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

//*****************************************************************************

/******************************************************************************
 * UI 클래스 선언 및 구현 모든 멤버 함수들이 모두 정적(static) 함수임 입력과 출력을 담당하는 전역 함수들의 모음 static 함수
 * 호출은 예제 4-11 참조
 *******************************************************************************/
// TODO: UI class
class UI {

	// msg를 출력한 후 정수 값 하나를 입력 받아 리턴
	// MAIN_MENU 선택을 위한 메소드
	static int getMainMenu(Scanner scanner) {
		System.out.println("Select one operation  "); // 안내 문자 출력
		System.out.print("Insert(Front):" + MAIN_MENU.Insert_front.value() + ", " + "Insert(Rear):"
				+ MAIN_MENU.Insert_rear.value() + ", " + "Remove(Front):" + MAIN_MENU.Remove_front.value() + ", "
				+ "Remove(Rear):" + MAIN_MENU.Remove_rear.value() + "\n" + "Move(Front):" + MAIN_MENU.Move_front.value()
				+ ", " + "Move(Rear):" + MAIN_MENU.Move_rear.value() + ", " + "Print List:" + MAIN_MENU.list_all.value()
				+ ", " + "Exit:" + MAIN_MENU.Exit.value() + " >> "); // 연산 종류 출력

		int nMenu = scanner.nextInt(); // 사용자가 선택한 연산 입력

		return nMenu; // 사용자가 선택한 연산 리턴
	}

	// msg를 출력한 후 정수 값 하나를 입력 받아 리턴
	// SHAPE_TYPE 선택을 위한 메소드
	static int getShape(Scanner scanner) {
		// 안내 문자 출력
		System.out.println("Select one Shape  ");
		// Shape 종류 출력
		System.out.print("Rectangle:0, Circle:1, Line:2 >> ");

		// 사용자가 선택한 Shape 입력
		int numShapeSelck = scanner.nextInt();
		// 사용자가 선택한 Shape 리턴
		return numShapeSelck;
	}

	// 안내 msg를 매개 변수로 받아 출력하고
	// 삽입할 도형의 Point 정보 하나를 입력 받아 리턴
	static public Point getWidthHeight(Scanner scanner, String msg) {
		// msg 출력
		System.out.print(msg);
		// width, height 변수 선언
		int width, height = 0;

		// width 입력
		// height 입력
		width = scanner.nextInt();
		height = scanner.nextInt();

		scanner.nextLine();

		// 포인트 객체 생성
		Point point = new Point(width, height);
		// 포인트 객체 리턴
		return point;
	}

	// 안내 msg를 매개 변수로 받아 출력하고
	// Circle 객체의 반지름 하나를 입력 받아 리턴
	static public int getRadius(Scanner scanner, String msg) {
		// msg 출력
		System.out.print(msg);

		// radius 변수 선언
		int radius = 0;

		// radius 입력
		radius = scanner.nextInt();

		// radius 리턴
		return radius;
	}
}

//*****************************************************************************
//	Circle 객체의 중심점 Line 객체의 두 점 Rectangle 객체의 두 꼭지점의 정보를 저장할 자료형
//*****************************************************************************

class Point {

	int x; // 점의 x 좌표 값
	int y; // 점의 y 좌표 값

	// 객체 초기화: x, y 좌표 초기화
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// x, y 좌표를 각각 width, height만큼 이동시킨다.
	public void move(int width, int height) {
		this.x += width;
		this.y += height;
	}

	// (x,y) 좌표 문자열을 리턴, 예) "(10, 15)"
	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}

//*****************************************************************************
// TODO: Shape의 추상 클래스 선언
abstract class Shape {

	public abstract String draw(); // 정보 출력

	public abstract void move(int width, int height); // 좌표 이동
};

//*****************************************************************************
//	Line 클래스 선언 및 구현*****************************************************************************/

class Line extends Shape {

	private Point p1; // 사각형의 왼쪽 위쪽 좌표
	private Point p2; // 사각형의 오른쪽 아래쪽 좌표

	// 생성자 작성
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// Shape 의 draw 메소드 오버라이딩
	// 실질적인 자료를 리턴하는 함수는 toString
	// 함수 내부에서 toString() 메소드 호출
	@Override
	public String draw() {
		return toString();
	}

	// 화면에 라인의 좌표 값을 출력, 예) "Line (10,15) (20,30)"
	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		return ("Line " + p1 + " " + p2);
	}

	// 기존 객체의 위치를 width, height만큼 옮긴다.
	public void move(int width, int height) {
		// 기존 p1의 위치를 width, height만큼 옮긴다.
		p1.move(width, height);
		// 기존 p2의 위치를 width, height만큼 옮긴다.
		p2.move(width, height);
	}
}

//*****************************************************************************
//	Rect 클래스 선언 및 구현 Line 클래스를 참고하여 작성*****************************************************************************/

class Rect extends Shape {

	private Point p1; // 사각형의 왼쪽 위쪽 좌표
	private Point p2; // 사각형의 오른쪽 아래쪽 좌표

	// 생성자: 멤버 초기화
	public Rect(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	// Shape 의 draw 메소드 오버라이딩
	@Override
	public String draw() {
		// 실질적인 자료를 리턴하는 함수는 toString
		// 함수 내부에서 toString() 메소드 호출
		return toString();
	}

	@Override
	public String toString() {
		// 화면에 사각형의 좌표 값을 출력, 예) "Rectangle (10,15) (20,30)"
		return ("Rectangle " + p1 + " " + p2);
	}

	public void move(int width, int height) {
		// 기존 p1의 위치를 width, height만큼 옮긴다.
		p1.move(width, height);
		// 기존 p2의 위치를 width, height만큼 옮긴다.
		p2.move(width, height);
	}
}

//*****************************************************************************
//	Rect 클래스 선언 및 구현 Line 클래스를 참고하여 작성*****************************************************************************/
class Circle extends Shape {

	private Point center; // 원의 중심 좌표
	private int radius; // 반지름의 길이

	// 생성자: 멤버 초기화
	public Circle(int radius, Point center) {
		this.center = center;
		this.radius = radius;
	}

	// Shape 의 draw 메소드 오버라이딩
	@Override
	public String draw() {
		// 실질적인 자료를 리턴하는 함수는 toString
		// 함수 내부에서 toString() 메소드 호출
		return toString();
	}

	// 메소드 오버라이딩, Object 클래스의 public String toString()을 오버라이딩
	@Override
	public String toString() {
		// 화면에 반지름과 중심 좌표 값을 출력, 예) "Circle 5 (20,30)"
		return ("Circle " + radius + " " + center);
	}

	public void move(int width, int height) {
		// 기존 객체의 위치를 width, height만큼 옮긴다.
		center.move(width, height);
	}
}

//*****************************************************************************
//double linked list를 위한 인터페이스 선언
interface LinkedList {

	public abstract void add_front(Shape value); // 리스트 맨 앞에 삽입

	public abstract void add_rear(Shape value); // 리스트 맨 뒤에 삽입

	public abstract boolean isEmpty(); // 리스트가 empty인지 확인

	public abstract Object remove_front(); // 리스트 맨 앞에서 삭제

	public abstract Object remove_rear(); // 리스트 맨 뒤에서 삭제
}

//*****************************************************************************
// Shape을 이용한 double linked list 작성
// TODO: ShapeList
class ShapeList implements LinkedList {

	// private Node head; // double linked 리스트의 맨 처음 노드를 가리키는 포인터
//    private Node tail; // double linked 리스트의 맨 마지막 노드를 가리키는 포인터
	private Vector vector;

	ShapeList() {
		vector = new Vector<>();
	} // 생성자: 멤버 초기화

	// 리스트의 맨 앞의 노드를 리턴
	public Object get_frontValue() {
		// 리스트가 empty 이면
		if (this.isEmpty()) {
			// null 리턴
			return null;
		}
		return vector.get(0);
	}

	public Object get_rearValue() {
		// 리스트가 empty 이면
		if (this.isEmpty()) {
			// null 리턴
			return null;
		}
		// 리스트가 empty가 아니면
		// 맨 뒤의 데이터 리턴, tail을 이용하여 getValue 메소드 호출
		int indexLast = vector.size() - 1;
		return vector.get(indexLast);
	}

	public void add_front(Shape value) {
		vector.add(0, value);
	}

	public void add_rear(Shape value) {
		vector.add(value);
	}

	public boolean isEmpty() {
		// head 와 tail 이 모두 null 이면
		if (vector.isEmpty()) {
			// true 리턴
			return true;
		}
		return false;
	}

	public Object remove_front() {
		if (isEmpty()) {
			return null;
		}

		Object o = vector.get(0);
		vector.remove(0);
		return o;
	}

	public Object remove_rear() {
		if (isEmpty()) // list가 empty인지 확인
		{
			return null; // empty 이면 null 리턴
		}

		int indexLast = vector.size() - 1;
		Object o = vector.get(indexLast);
		vector.remove(indexLast);
		return o;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(""); // 가변형 String 변수 result 선언
		if (!isEmpty()) { // 리스가 empty가 아니면

			for (int i = 0; i < vector.size(); i++) { // node가 null 이 아닌 동안
				result.append("["); // result에 "[" 붙이기
				result.append(vector.get(i)); // result에 node.getValue() 호출해서 결과 붙이기
				result.append("]"); // result에 "]" 붙이기
				if (vector.size() == (i + 1)) // node.next 가 null 이면
				{
					result.append("\r\n"); // result에 "\r\n" 붙이기
				} else {
					result.append("\n"); // result에 ", " 붙이기
				}
			}
		}

		return result.toString();
	}
}

class GraphicEditor {

	private Shape createShape(Scanner scanner) {

		SHAPE_TYPE shapeType;
		Point p1, p2;
		int radius;

		int type = UI.getShape(scanner);

		shapeType = SHAPE_TYPE.values()[type];
		Shape shape = null;

		String msgpoint = "Enter point coordinates (enter two integers) >> ";
		String msgradius = "Enter the radius (enter one integer) >> ";

		switch (shapeType) {
		case Shape_Rect: // 사각형
			p1 = UI.getWidthHeight(scanner, msgpoint);
			p2 = UI.getWidthHeight(scanner, msgpoint);
			shape = new Rect(p1, p2);
			break;
		case Shape_Circle: // 원
			p1 = UI.getWidthHeight(scanner, msgpoint);
			radius = UI.getRadius(scanner, msgradius);
			shape = new Circle(radius, p1);
			break;
		case Shape_Line: // 라인
			p1 = UI.getWidthHeight(scanner, msgpoint);
			p2 = UI.getWidthHeight(scanner, msgpoint);
			shape = new Line(p1, p2);
			break;

		}
		return shape;
	}

	public void run() {
		ShapeList list = new ShapeList(); // shape 리스트를 관리할 객체 생성

		Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 스캐너 객체 생성

		Shape shape = null; // 임시로 사용할 Shape 레퍼런스 변수 선언
		boolean bLoop = true; // 반복문 관리용 부울린 변수
		Point p1;
		String msgpoint = "The two integers to move along the X and Y axes (enter two integers) >> ";

		while (bLoop) {
			System.out.print(list);
			int n = UI.getMainMenu(scanner); // 메뉴 정보 읽어 오기
			MAIN_MENU menu = MAIN_MENU.values()[n]; // 열겨형의 정보로 변환

			GraphicEditor editor = new GraphicEditor();
			switch (menu) {
			case Insert_front: // 리스트 앞에 삽입
				// 삽입을 위한 객체 생성
				shape = editor.createShape(scanner);

				// 리스트 앞에 삽입
				list.add_front(shape);
				break;
			case Insert_rear: // 리스트 뒤에 삽입
				// 삽입을 위한 객체 생성
				shape = editor.createShape(scanner);
				// 리스트 뒤에 삽입
				list.add_rear(shape);
				break;
			case Remove_front: // 리스트 앞에서 삭제
				// 리스트 앞에서 삭제 (리턴 값을 shape에 저장)
				shape = (Shape) list.remove_front();
				break;
			case Remove_rear: // 리스트 뒤에서 삭제
				// 리스트 뒤에서 삭제 (리턴 값을 shape에 저장)
				shape = (Shape) list.remove_rear();
				break;
			case Move_front: // 리스트 첫번째 객체 이동

				// get_frontValue 메소드를 이용해서 첫번째 shape 정보 가지고 오기
				shape = (Shape) list.get_frontValue();

				// shape 이 널이 아니면
				if (shape != null) {
					System.out.print(msgpoint);

					// 이동을 위한 정보 받기, UI.getWidthHeight 이용
					int width, height = 0;
					width = scanner.nextInt();
					height = scanner.nextInt();

					// 좌표이동
					shape.move(width, height);
				}
				break;
			case Move_rear: // 리스트 마지막 객체 이동
				// get_rearValue메소드를 이용해서 마지막 shape 정보 가지고 오기
				shape = (Shape) list.get_rearValue();

				// shape 이 널이 아니면
				if (shape != null) {
//					Point point = UI.getWidthHeight(scanner, msgpoint);
					System.out.print(msgpoint);

					// 이동을 위한 정보 받기, UI.getWidthHeight 이용
					int width, height = 0;
					width = scanner.nextInt();
					height = scanner.nextInt();

					// 좌표이동
					shape.move(width, height);
				}
				break;
			case list_all: // 리스트 정보 출력
//                    System.out.print(list.toString());
				break;
			case Exit:
				bLoop = false; // 끝내기
			}
		}
		scanner.close();
	}
}

public class Main {

	public static void main(String[] args) {
		GraphicEditor g = new GraphicEditor(); // GraphicEditor 생성
		g.run(); // 실행 함수 호출

		System.out.println("Good Bye");
	}
}