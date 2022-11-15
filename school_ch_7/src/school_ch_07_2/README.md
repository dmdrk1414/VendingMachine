# 🚀ch07_2과제를 하겠습니다.



```java
과제 기간: 2022/11/07 ~ 2022/11/22 23:59분으로 되어 있습니다.
과제 지각 : 2022/11/22 24 시 ~ 2022/11/24 23:59 분 입니다.

지각 제출 허용하나 점수에서 50% 감점하고 부여됩니다. 

[7장 과제-2]

/******************************************************************************
 * 기존 코드 복사
 ******************************************************************************/
// 새로운 프로젝트를 만들어라.
// 새로운 클래스 Main를 만들어 Main.java 소스파일을 만든 후 [7장 과제-1]에서 만든
// Main.java 소스파일의 모든 내용를 복사해와 삽입하라. 
//
// 지난 과제에서는 매번 프로그램을 실행할 때마다 그래픽 객체를 생성하는 것이 번거로웠는데
// 이번 과제에서는 아래 실행 결과처럼 프로그램 시작 시 자동으로 그래픽 객체가 생성되게 해 보자.

===============================================================================
== 프로그램 초기 실행 화면
=============================================================================== 
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 

/******************************************************************************
 * 문제 1-1
 ******************************************************************************/
// 먼저 ShapeList 클래스에 아래 생성자를 추가하라.
// 이 생성자는 사전에 이미 생성되어 배열 arr을 통해 넘어온 그래픽 객체들을 vector에 추가한다.

    public ShapeList(Shape arr[]) {
        기존 ShapeList() 생성자를 호출하여 vector를 생성한다. [예제 4-5 참조]
        for문을 이용하여 
           배열 arr의 각 원소 arr[i]를 vector에 추가한다.
    }


/******************************************************************************
 * 문제 1-2
 ******************************************************************************/
// main() 메소드를 아래와 같이 수정하라.
// scanner를 main에서 생성하여 GraphicEditor 생성자 호출 시 인자로 넘겨 주었다.
// 또한 GraphicEditor 생성자의 인자가 두 개 추가되었다.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);     // 사용자 입력을 위한 스캐너 객체 생성
        ShapeFactory shapeFactory = new ShapeFactory();
        GraphicEditor g = new GraphicEditor(shapeFactory, scanner);
        g.run();
        System.out.println("Good Bye");
        scanner.close();
    }

// 이를 위해 먼저 GraphicEditor 클래스에 아래 세개의 멤버를 추가하고

	private ShapeList list;
	private Factory factory;
	private Scanner scanner;

// 이들 각각의 멤버를 초기화하는 GraphicEditor 생성자를 추가하라.

	public GraphicEditor(Factory factory, Scanner scanner) { }

// 이 생성자에서 매개변수들을 이용해 해당 멤버 변수를 초기화하고
// list 멤버의 경우 아래와 같이 초기화하라. 아래 문장은 사용자가 넘겨 준 factory의 
// generateShapeList() 메소드를 호출하여 list를 초기화 한다. 

	list = factory.generateShapeList();

// 그리고 GraphicEditor의 run() 메소드의 아래 문장들을 모두 찾아서 주석 처리하라. 
// scanner의 생성 및 닫기는 main()에서 처리했고, list 생성은 위 문장으로 대체 되었기 때문에
// 더 이상 아래 문장들은 필요없다.

	//ShapeList list = new ShapeList();             // shape 리스트를 관리할 객체 생성
	//Scanner scanner = new Scanner(System.in);     // 사용자 입력을 위한 스캐너 객체 생성
	//scanner.close();

/******************************************************************************
 * 문제 1-3
 ******************************************************************************/
// 이제 아래 인터페이스 Factory를 GraphicEditor 클래스 위쪽에 배치하라.

interface Factory
{
    String msgpoint = "Enter point coordinates (enter two integers) >> ";
    ShapeList generateShapeList();         // ShapeList 객체를 생성한 후 반환한다.
    Shape generateShape(Scanner scanner);  // 사용자로부터 그래픽 객체 정보를 입력 받은 후 
}                                          // 그래픽 객체를 생성하여 반환함 

// 그런 다음 위 Factory 인터페이스를 구현하는 아래 클래스 ShapeFactory를 Main 클래스 앞쪽에 배치하라.
// 그런 후 기존의 GraphicEditor의 createShape(Scanner scanner) 메소드 내에 있던 코드 전부를
// 아래 generateShape(Scanner scanner)로 옮겨라. (복사가 아니고)

class ShapeFactory implements Factory
{
    private Shape shapes[] = { // 프로그램 초기에 생성될 그래픽 객체들
            new Rect(new Point(1,1), new Point(2,2)), 
            new Rect(new Point(3,3), new Point(4,4)), 
            new Rect(new Point(5,5), new Point(6,6)), 
            new Circle(1, new Point(2,2)), 
            new Circle(3, new Point(4,4)), 
            new Circle(5, new Point(6,6)), 
            new Line(new Point(1,1), new Point(2,2)), 
            new Line(new Point(3,3), new Point(4,4)), 
            new Line(new Point(5,5), new Point(6,6)), 
    };

    public ShapeList generateShapeList() { // GraphicEditor의 생성자에서 호출함
        return new ShapeList(shapes); // 그래픽 객체들을 관리하는 ShapeList 객체 생성
        // 이문장은 GraphicEditor 생성자에 의해 호출된다.
        // 리턴된 list는 위 shapes[]의 9개의 객체들을 포함하고 있다.
    }

    public Shape generateShape(Scanner scanner) {
       GraphicEditor의 createShape(Scanner scanner) 메소드 내에 있던 코드 전부를
       이쪽으로 옮길 것
    }
}

/******************************************************************************
 * 문제 1-4
 ******************************************************************************/
// GraphicEditor의 기존 createShape(Scanner scanner) 메소드는 아래와 같이 수정하라.
// 아래의 factory는 main()에서 넘겨준 shapeFactory 객체를 업캐스팅한 것이다.
// 즉, 이제부터는 새로운 그래픽 객체는 위 ShapeFactory의 generateShape()에서 
// 사용자로부터 그래픽 정보를 입력 받아 적절한 그래픽 객체를 생성하여 반환해 준다.

    private Shape createShape(Scanner scanner) {
        return factory.generateShape(scanner);
    }

===============================================================================
== 프로그램 초기 실행 화면
== 이제 프로그램을 실행하면 이 과제 맨처음에 보여준 [프로그램 초기 실행 화면]이 출력되어야 한다.
== 그런 후 아래 입력 데이터를 한번에 입력하라.
=============================================================================== 
/******************************************************************************
 * 입력
 * 아래 숫자들을 Ctrl+C 해서 Ctrl+V로 Console 창에 한번에 입력하라.
 * 6개의 그래픽 객체를 순서적으로 입력하는 데이타이다.
 ******************************************************************************/
1
0
1 1
2 2

1
1
3 3
4

1
2
5 5
6 6

1
0
7 7
8 8

1
1
9 9
10

1
2
11 11
12 12

===============================================================================
== 프로그램 실행 결과
== 위 입력 데이터를 복사해서 한번에 입력한 후의 결과
=============================================================================== 
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 1  // 복사해서 한번에 입력
0
1 1
2 2

1
1
3 3
4

1
2
5 5
6 6

1
0
7 7
8 8

1
1
9 9
10

1
2
11 11
12 12    // 복사한 마지막 입력 데이타
Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> 
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> 
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
[Circle 10 (9, 9)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
[Circle 10 (9, 9)]
[Line (11, 11) (12, 12)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 6  // 사용자 입력
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Rectangle  (1, 1) (2, 2)]      // 여기서부터
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
[Circle 10 (9, 9)]
[Line (11, 11) (12, 12)]        // 여기까지가 새로 입력된 객체들
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 7  // 사용자 입력
Good Bye
```

