# 🚀ch07_3과제를 하겠습니다.



```java
과제 기간: 2022/11/07 ~ 2022/11/22 23:59분으로 되어 있습니다.
과제 지각 : 2022/11/22 24 시 ~ 2022/11/24 23:59 분 입니다.

지각 제출 허용하나 점수에서 50% 감점하고 부여됩니다. 


[7장 과제-3]
*주의사항 
 7장 7-3 과제문제(ch7-3-problem-description.txt) 중 
제네릭 클래스 표현을 위해 <>를 많이 사용했는데(예: LinkedList)
이 < > 기호가 OJ시스템에 올릴 경우  HTML tag로 인식되어 화면에 표시가 되지 않습니다.
이 기호가 한두 개이면 < >으로 고치겠는데 
너무 많아 중간에 수정하다가 오류가 발생할까 염려되어 이것도 곤란할 것 같습니다.

사이버강의실의 [과제 7장란에 올려두겠습니다.
이 파일을 참조하라고 하시는 것이 좋을 듯 합니다.

학생들의 소스코드 제출은  OJ 시스템을 입니다. 

/******************************************************************************
 * 기존 코드 복사
 ******************************************************************************/
// 새로운 프로젝트를 만들어라.
// 새로운 클래스 Main를 만들어 Main.java 소스파일을 만든 후 [7장 과제-2]에서 만든
// Main.java 소스파일의 모든 내용를 복사해와 삽입하라. 

//******************************************************************************
 * 제네릭 클래스의 필요성
 ******************************************************************************/

// 지금까지 우리는 ShapeList에 저장하는 데이타 타입을 아래처럼 Shape형 벡터를 선언해 놓고
// Line, Rect, Circle 객체를 생성하여 업캐스팅한 후 ShapeList 내의 vector에
// 저장하였다. 따라서 다양한 종류의 객체들(Line, Rect, Circle)이 저장될 수 있었다.
// 그러나 때로는 한가지 종류의 객체만 고정시켜 저장하고 싶은 경우가 있을 수 있다. 
// 만약 ShapeList를 아래처럼 Vector으로 선언해 놓고 
// Rect 객체들만 저장하기 위해 사용하고자 할 경우 Rect 객체들만 생성해서 벡터에 추가해야 하는데
// 만약 사용자의 실수로 Line이나 Circle 객체를 업캐스팅해서 삽입해도 이를 막을 방법이 없다는 것이다.  

class ShapeList implements LinkedList {
	Vector vector; 
    ...
}

// 그러나 아래처럼 선언할 경우 ShapeList의 vector에는 Rect 객체들만 저장할 수 있다.

class ShapeList implements LinkedList { Vector   vector; ... }

// 마찬가지로 아래처럼 선언하면 vector에는 각각 Line과 Circle 객체들만 저장할 수 있다.

class ShapeList implements LinkedList { Vector   vector; ... }
class ShapeList implements LinkedList { Vector vector; ... }

// 문제는 위처럼 선언하고 나면 ShapeList 클래스를 오직 특정 객체(예, Rect)만을 위해 
// 전적으로 사용해야 하고 만약 Line 객체를 위한 별도의 ShapeList가 더 필요하면 
// Line을 위한 동일한 기능을 가진 ShapeList를 별도로 따로 하나 더 만들어야 한다. 
// 뿐만 아니라, 그 클래스 내의 모든 메소드들 역시 중복되어 하나씩 더 만들어져야 한다는 것이다. 

// 이러한 코드 중복을 피하기 위해 제네릭 클래스를 활용해 보도록 하자.
// 즉, 아래처럼 Shape 클래스를 상속한 Rect, Line, Circle 등과 같은 다양한 클래스에 대해 
// 재사용할 수 있는 제네릭 ShapeList 클래스를 만들어 보자.

    new ShapeList(rects);
    new ShapeList(circles);
    new ShapeList(lines);


===============================================================================
== 프로그램 실행 화면
-------------------------------------------------------------------------------
// 아래 프로그램은 우리가 구현하고자하는 새 프로그램의 실행화면이다.
// 맨 먼저 사용자로부터 어떤 그래픽을 관리할지 선택하게 하고(예, 사각형) 일단 한번 선택하면
// 선택된 그 그래픽(사각형)만 삽입, 삭제를 할 수 있다. (기존 GraphicEditor와 ShapeList를 통해)
// 세부 메뉴에서 빠져 나오면 다시 다른 그래픽(예, 원)을 선택할 수 있으며 
// 선택된 종류의 다른 그래픽을 삽입/삭제하면서 관리할 수 있다. 
=============================================================================== 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 1  // 사용자 입력: 사각형만 취급

GraphicEditor
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 1  // 사각형만 삽입할 수 있음
Enter point coordinates (enter two integers) >> 7 7
Enter point coordinates (enter two integers) >> 8 8
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 0  // 사각형 삽입
Enter point coordinates (enter two integers) >> 8 8
Enter point coordinates (enter two integers) >> 9 9
[Rectangle  (8, 8) (9, 9)]
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 2  // 사각형 삭제
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 3  // 사각형 삭제
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 7

***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 2  // 사용자 입력: 원만 취급

GraphicEditor
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 7

***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 3  // 사용자 입력: 선만 취급

GraphicEditor
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 

//******************************************************************************
 * 문제 2-1
 ******************************************************************************/
// 먼저 LinkedList 인터페이스를 아래와 같이 선언하라.
// 여기서 우리는 T로 Rect, Circle, Line 등을 지정할 것이다.

interface LinkedList {

// 그런 후 LinkedList의 모든 멤버 함수들의 매개변수 또는 리턴 데이타 타입들 중 Shape를 모두
// T로 변경하라. 기존에는 Rect, Circle, Line의 슈퍼클래스인 Shape을 사용하여 이를 상속한 어떤
// 객체든 허용이 되었는데, 이제는 T가 나중에 Rect, Circle, Line 중의 하나인 특정 클래스로 변경되어
// 해당 클래스의 객체들만 LinkedList 멤버 함수의 매개변수 또는 리턴 타입으로 사용할 수가 있게 된다.

//******************************************************************************
 * 문제 2-2
 ******************************************************************************/
// 먼저 ShapeList 클래스를 아래와 같이 선언하라.
// 여기서 우리는 T로 Rect, Circle, Line 등을 지정할 것이다.

class ShapeList implements LinkedList {

// 그런 후 ShapeList의 모든 멤버 변수, 또는 멤버 함수들의 매개변수 또는 리턴 데이타 또는
// 지역변수들 데이타 타입 중 Shape가 있으면 이를 모두 T로 변경하라.

//******************************************************************************
 * 문제 2-3
 ******************************************************************************/
// 먼저 Factory 클래스를 아래와 같이 선언하라.

interface Factory {

// 그런 후 Factory의 모든 멤버 함수들의 매개변수 또는 리턴 데이타 타입들 중 Shape를 모두 T로 변경하라.
// 마찬가지로 데이타 타입으로 사용된 기존 ShapeList도 
// 제네릭 타입 T를 사용하는 제네릭 클래스 즉, ShapeList으로 변경하라.

//******************************************************************************
 * 문제 2-4
 ******************************************************************************/
// 먼저 GraphicEditor 클래스를 아래와 같이 선언하라.

class GraphicEditor {

// 위에서 는 아무 클래스나 타입 매개변수 T로 지정하는 것이 아니라 
// Shape 또는 Shape을 상속한 클래스들만 타입 매개변수 T로 지정해 줄 수 있다는 의미이다.
// 따라서 우리는 T로 Rect, Circle, Line 등을 지정할 수 있다.

// 그런 후 GraphicEditor의 모든 멤버 변수 또는 함수들의 매개변수 또는 리턴 데이타 타입들 중 
// Shape를 모두 T로 변경하라. 마찬가지로 데이타 타입으로 사용된 기존 ShapeList, Factory도 
// 제네릭 타입 T를 사용하는 적절한 제네릭 클래스(인터페이스)로 모두 변경하라.

// 이제부터는 GraphicEditor도 Rect, Circle, Line 중에서 제네릭 타입 T로 지정된 그래픽 객체만을
// 관리하게 할 수 있다.

//******************************************************************************
 * 문제 2-5
 ******************************************************************************/
// 기존의 ShapeFactory 클래스를 모두 주석 처리하라.
// 대신 아래 세개의 Factory를 ShapeFactory 클래스의 아래 쪽(Main 위쪽)에 삽입하고
// CircleFactory와 LineFactory에 있는 두 멤버 즉, 
// generateShapeList()와 generateShape()를 각각 구현하라.

// 아래의 세 Factory는 해당 Factory의 객체만 생성하고 다른 객체는 생성할 수 없다.
// 따라서 "Graphic Management Menu"에서 하나의 객체를 선택하면
// 선택된 그래픽을 생성하는 아래 Factory중 하나를 사용하게 된다.

class RectFactory implements Factory  // 사각형 객체를 생성하는 클래스
{
    private Rect rects[] = { // ShapeList 생성시 자동 삽입될 객체들
        new Rect(new Point(1,1), new Point(2,2)), 
        new Rect(new Point(3,3), new Point(4,4)), 
        new Rect(new Point(5,5), new Point(6,6)), 
    };

    public ShapeList generateShapeList() { // ShapeList 생성
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

class CircleFactory implements Factory  // 원 객체를 생성하는 클래스
{
    private String msgradius = "Enter the radius (enter one integer) >> ";

    private Circle circles[] = { // ShapeList 생성시 자동 삽입될 객체들
        new Circle(1, new Point(2,2)), 
        new Circle(3, new Point(4,4)), 
        new Circle(5, new Point(6,6)), 
    };

    generateShapeList() 메소드 구현

    generateShape() 메소드 구현할 것
    // 위 generateShape()은 기존 ShapeFactory의 
    // generateShape()의 switch 코드들 중 원 객체 생성하는 코드만 발췌해서 삽입
}

class LineFactory implements Factory      // 선 객체를 생성하는 클래스
{
    private Line lines[] = { // ShapeList 생성시 자동 삽입될 객체들
        new Line(new Point(1,1), new Point(2,2)), 
        new Line(new Point(3,3), new Point(4,4)), 
        new Line(new Point(5,5), new Point(6,6)), 
    };

    generateShapeList() 메소드 구현

    generateShape() 메소드 구현할 것
    // 위 generateShape()은 기존 ShapeFactory의 
    // generateShape()의 switch 코드들 중 Line 객체 생성하는 코드만 발췌해서 삽입
}

// 위에서 는 아무 클래스나 타입 매개변수 T로 지정하는 것이 아니라 
// Shape 또는 Shape을 상속한 클래스들만 타입 매개변수 T로 지정해 줄 수 있다는 의미이다.
// 따라서 우리는 T로 Rect, Circle, Line 등을 지정할 수 있다.

// 그런 후 GraphicEditor의 모든 멤버 변수 또는 함수들의 매개변수 또는 리턴 데이타 타입들 중 
// Shape를 모두 T로 변경하라. 마찬가지로 데이타 타입으로 사용된 기존 ShapeList, Factory도 
// 제네릭 타입 T를 사용하는 적절한 제네릭 클래스(인터페이스)로 모두 변경하라.

//******************************************************************************
 * 문제 2-6
 ******************************************************************************/
// 이제 아래와 같은 메뉴를 보여주고 메뉴항목을 입력받는 코드를 작성하자.

***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 

// 이를 위해 enum SHAPE_TYPE 밑(아래)에 아래 코드를 추가하라.
// Graphic Management Menu의 메뉴 항목들이다.

enum GraphicMenu {
    EXIT(0), RECT(1), CIRCLE(2), LINE(3);

    GraphicMenu(int value) { this.value = value; }

    private final int value;
    public int value() { return value; }
}

// 그런 후 UI 클래스에 아래 메소드를 추가하라.
// 사용자에게 메뉴항목들을 보여주고 사용자가 선택한 메뉴항목을 입력받는 코드이다.

    static GraphicMenu getGraphicMenu(Scanner scanner) {
        System.out.println("***** Graphic Management Menu ******");
        System.out.println("* " + GraphicMenu.EXIT.value()+".Exit  "     + 
                                  GraphicMenu.RECT.value()+".Rect  "     +
                                  GraphicMenu.CIRCLE.value()+".Circle  " + 
                                  GraphicMenu.LINE.value()+".Line *");
        System.out.println("************************************");
        System.out.print("Menu item number? ");
        GraphicMenu menu[] = GraphicMenu.values();
        return menu[scanner.nextInt()];  
    }
	
//******************************************************************************
 * 문제 2-7
 ******************************************************************************/
// main()은 아래와 같다.

    public static void main(String[] args) {
        GraphicManager m = new GraphicManager();
        m.run();
        System.out.println("\nGood Bye");
    }

// GraphicManager 클래스는 아래와 같다.

class GraphicManager 
{
    private Scanner scanner;
    private GraphicEditor   rectEditor;
    private GraphicEditor circleEditor;
    private GraphicEditor   lineEditor;
    
    // 각각의 Rect, Circle 또는 Line을 전용으로 관리하는 GraphicEditor<>를 미리 생성해 놓는다.
    // 각 GraphicEditor는 해당 그래픽 객체를 생성하는 Factory 객체를 가지며,
    // 이 Factory 객체를 통해 ShapList<>와 해당 그래픽 객체만을 전적으로 생성한다.
    GraphicManager() {
        scanner = new Scanner(System.in);
        rectEditor   = new GraphicEditor  (new RectFactory(),   scanner);
        circleEditor = new GraphicEditor(new CircleFactory(), scanner);
        lineEditor   = new GraphicEditor  (new LineFactory(),   scanner);
    }
    
    // 사용자가 Rect, Circle, Line 중 하나를 선택하게 하고
    // 선택된 그래픽 객체들을 전용으로 관리하는 GraphicEditor<>의 run() 메소드를 호출한다.
    void run() {
        while (true)  {
            GraphicMenu menu = UI.getGraphicMenu(scanner);  // 메뉴 항목 읽어 오기
            if (menu == GraphicMenu.EXIT)
                break;
            switch (menu) {
            case RECT:   System.out.println("\nGraphicEditor");
                         rectEditor.run();
                         break;
            case CIRCLE: System.out.println("\nGraphicEditor");
                         circleEditor.run();
                         break;
            case LINE:   System.out.println("\nGraphicEditor");
                         lineEditor.run();
                         break;
            default:     System.out.println("WRONG menu item");
                         break;
            }
            System.out.println();
        }
        scanner.close();
    }
}


















===============================================================================
== 프로그램 실행 결과
=============================================================================== 
/******************************************************************************
 * 입력
 * 아래 숫자들을 순서적으로 입력해서 정상적으로 프로그램이 작동하는지 확인하라.
 * 사각형, 원, 선 등에 대해 각각 6개의 그래픽을 삽입한 후 (각 그래픽별로 총 9개의 객체)
 * 이들 모두를 다시 삭제하는 과정이다.
 * 정상적으로 실행되면 Ctrl+C 해서 Ctrl+V로 Console 창에 한번에 입력하라.
 ******************************************************************************/
1
1 11 11 12 12
1 13 13 14 14
1 15 15 16 16
1 17 17 18 18
1 19 19 20 20
1 21 21 22 22
7

2
1 11 11 12
1 13 13 14
1 15 15 16
1 17 17 18
1 19 19 20
1 21 21 22
7

3
1 11 11 12 12
1 13 13 14 14
1 15 15 16 16
1 17 17 18 18
1 19 19 20 20
1 21 21 22 22
7

1
7
2
7
3
7

1
2 2 2 2 2 2 2 2 2 
7

2
3 3 3 3 3 3 3 3 3
7

3
2 2 2 2 2 2 2 2 2
7

0
===============================================================================
== 프로그램 실행 결과
== 위 입력 데이터를 복사해서 한번에 입력한 후의 결과
=============================================================================== 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 1
1 11 11 12 12
1 13 13 14 14
1 15 15 16 16
1 17 17 18 18
1 19 19 20 20
1 21 21 22 22
7

2
1 11 11 12
1 13 13 14
1 15 15 16
1 17 17 18
1 19 19 20
1 21 21 22
7

3
1 11 11 12 12
1 13 13 14 14
1 15 15 16 16
1 17 17 18 18
1 19 19 20 20
1 21 21 22 22
7

1
7
2
7
3
7

1
2 2 2 2 2 2 2 2 2 
7

2
3 3 3 3 3 3 3 3 3
7

3
2 2 2 2 2 2 2 2 2
7

0

GraphicEditor
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
[Circle 20 (19, 19)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
[Circle 20 (19, 19)]
[Circle 22 (21, 21)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
[Circle 20 (19, 19)]
[Circle 22 (21, 21)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Rectangle  (1, 1) (2, 2)]
[Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (3, 3) (4, 4)]
[Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (5, 5) (6, 6)]
[Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (11, 11) (12, 12)]
[Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (13, 13) (14, 14)]
[Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (15, 15) (16, 16)]
[Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (17, 17) (18, 18)]
[Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (19, 19) (20, 20)]
[Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Rectangle  (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
[Circle 20 (19, 19)]
[Circle 22 (21, 21)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
[Circle 20 (19, 19)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
[Circle 18 (17, 17)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
[Circle 16 (15, 15)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
[Circle 14 (13, 13)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
[Circle 12 (11, 11)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
[Circle 5 (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
[Circle 3 (4, 4)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Circle 1 (2, 2)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
GraphicEditor
[Line (1, 1) (2, 2)]
[Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (3, 3) (4, 4)]
[Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (5, 5) (6, 6)]
[Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (11, 11) (12, 12)]
[Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (13, 13) (14, 14)]
[Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (15, 15) (16, 16)]
[Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (17, 17) (18, 18)]
[Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (19, 19) (20, 20)]
[Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> [Line (21, 21) (22, 22)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
***** Graphic Management Menu ******
* 0.Exit  1.Rect  2.Circle  3.Line *
************************************
Menu item number? 
Good Bye
```

