# 🚀ch07_1과제를 하겠습니다.



```java
과제 기간: 2022/11/07 ~ 2022/11/22 23:59분으로 되어 있습니다.
과제 지각 : 2022/11/22 24 시 ~ 2022/11/24 23:59 분 입니다.

지각 제출 허용하나 점수에서 50% 감점하고 부여됩니다. 


[7장 과제-1]

/******************************************************************************
 * 기존 코드 복사
 ******************************************************************************/
// 새로운 프로젝트를 만들어라.
// 새로운 클래스 Main를 만들어 Main.java 소스파일을 만든 후 [5장 과제]에서 만든
// Main.java 소스파일의 모든 내용를 복사해와 삽입하라. 
// 그리고 Main 클래스는 아래와 같이 수정하라.
//
// 기존 5장 과제에서는 다양한 그래픽 객체들을 Linked List로 관리하였다.
// 이번 과제에서는 이들 객체를 Vector로 관리해 보자.

/******************************************************************************
 * 문제 1-1
 ******************************************************************************/
// 1) 기존 class Node 전체를 주석처리 하라.
// 2) 기존 class ShapeList 내의 head, tail 멤버들을 주석처리 하고,
//    대신 아래의 새로운 멤버를 추가하라. 
//    향후 모든 그래픽 객체들을 아래 vector에 저장하고 관리할 것이다.

      private Vector vector;

// 3) interface LinkedList와 class ShapeList의 메소드들의 매개변수 선언에서
//    기존 Object형 타입을 Shape로 변경하라.
//    기존에는 모든 그래픽 객체를 Object 객체로 업캐스팅해서 사용하였으나
//    지금부터는 모든 그래픽 객체를 Shape 객체로 업캐스팅해서 사용할 것이다.

/******************************************************************************
 * 문제 1-2
 ******************************************************************************/
// ShapeList() 생성자에서 Vector 객체를 생성해서 초기화하라.
//-----------------------------------------------------------------------------

/******************************************************************************
 * 문제 1-3
 ******************************************************************************/
// ShapeList::get_frontValue()
// empty가 아닐 경우 Vector의 적절한 메소드 활용하여 vector의 첫번째 원소를 반환

/******************************************************************************
 * 문제 1-4
 ******************************************************************************/
// ShapeList::get_rearValue()
// empty가 아닐 경우 Vector의 적절한 메소드 활용하여 vector의 마지막 원소를 반환
//-----------------------------------------------------------------------------

/******************************************************************************
 * 문제 1-5
 ******************************************************************************/
// ShapeList::add_front()
// Vector의 적절한 add() 메소드 활용

/******************************************************************************
 * 문제 1-6
 ******************************************************************************/
// ShapeList::add_rear()
// Vector의 적절한 add() 메소드 활용

/******************************************************************************
 * 문제 1-7
 ******************************************************************************/
// ShapeList::isEmpty()
// Vector의 적절한 메소드 활용하여 비었는지의 여부를 반환
//-----------------------------------------------------------------------------

/******************************************************************************
 * 문제 1-8
 ******************************************************************************/
// ShapeList::remove_front()
// empty가 아닐 경우 Vector의 적절한 메소드 활용하여 
// vector의 첫번째 원소를 삭제하고 삭제된 그 원소를 반환

/******************************************************************************
 * 문제 1-9
 ******************************************************************************/
// ShapeList::remove_rear()
// empty가 아닐 경우 Vector의 적절한 메소드 활용하여 
// vector의 마지막 원소를 삭제하고 삭제된 그 원소를 반환
//-----------------------------------------------------------------------------

/******************************************************************************
 * 문제 1-10
 ******************************************************************************/
// ShapeList::toString()
// 기존의 result 객체를 활용하여 다음과 같이 문자열을 result에 추가한다.
// empty 조건은 필요없음
// 기존 while 대신 for 문을 이용하여 벡터의 각 i 인덱스의 원소에 대해
//    기존 node.getValue() 대신 vector의 i 인덱스를 가진 원소를 구해서 대체한다.
//    해당 원소가 vector의 마지막 원소인 경우와 아닌 경우에 기존처럼 "\r\n"와 ", " 추가

/******************************************************************************
 * 문제 1-11
 ******************************************************************************/
// 이제 편의를 위해 기존의 출력문을 조금 수정하자.
//
// 1) 메인 메뉴가 아래처럼 메뉴항목이 두 행에 걸쳐 출력되도록 
//    기존 UI 클래스의 getMainMenu(Scanner scanner)를 수정하라.

Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 

// 2) 기존 UI 클래스의 getRadius()에서 System.out.println(msg) 대신 
//    System.out.print(msg)으로 수정하라.
//
// 3) 6번 메뉴항목을 선택했을 때 아래와 같이 그래픽 객체들이 출력되도록 프로그램을 수정하라. 
//    즉, 한 행에 하나의 그래픽 객체가 출력되게 하라.  
 
...
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 6
[Rectangle  (1, 1) (2, 2)]
[Circle 1 (2, 2)]
[Circle 3 (4, 4)]
Line (5, 5) (6, 6)]

// 4) 기존의 GraphicEditor 클래의 run() 메소드 내의 case list_all: 에 있는 
//    print 문장을 아래처럼 주석으로 처리하라. 

                case list_all:    // 리스트 정보 출력
                    //System.out.print(list.toString());    

//    그리고 while 루프 맨처음에 아래처럼 리스트 정보를 출력하라. 그러면 메뉴항목을 하나 실행할 때마다
//    현재 ShapeList list에 저장되어 있는 모든 그래픽 객체들을 매번 보여 줄 것이다.
//
        while (bLoop) {
            System.out.print(list);    

===============================================================================
== 프로그램 실행 결과
=============================================================================== 
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 1  // 사용자 입력
Select one Shape  
Rectangle:0, Circle:1, Line:2 >> 1  // 사용자 입력
Enter point coordinates (enter two integers) >> 10 20  // 사용자 입력
Enter the radius (enter one integer) >> 5  // 사용자 입력
[Circle 5 (10, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 0  // 사용자 입력
Select one Shape  
Rectangle:0, Circle:1, Line:2 >> 0  // 사용자 입력
Enter point coordinates (enter two integers) >> 10 20  // 사용자 입력
Enter point coordinates (enter two integers) >> 30 40  // 사용자 입력
[Rectangle  (10, 20) (30, 40)]
[Circle 5 (10, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 1  // 사용자 입력
Select one Shape  
Rectangle:0, Circle:1, Line:2 >> 2  // 사용자 입력
Enter point coordinates (enter two integers) >> 40 50  // 사용자 입력
Enter point coordinates (enter two integers) >> 40 70  // 사용자 입력
[Rectangle  (10, 20) (30, 40)]
[Circle 5 (10, 20)]
[Line (40, 50) (40, 70)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 4  // 사용자 입력
The two integers to move along the X and Y axes (enter two integers) >> 5 10  // 사용자 입력
[Rectangle  (15, 30) (35, 50)]
[Circle 5 (10, 20)]
[Line (40, 50) (40, 70)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 5  // 사용자 입력
The two integers to move along the X and Y axes (enter two integers) >> 3 7  // 사용자 입력
[Rectangle  (15, 30) (35, 50)]
[Circle 5 (10, 20)]
[Line (43, 57) (43, 77)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 3  // 사용자 입력
[Rectangle  (15, 30) (35, 50)]
[Circle 5 (10, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 4  // 사용자 입력
The two integers to move along the X and Y axes (enter two integers) >> 6 5  // 사용자 입력
[Rectangle  (21, 35) (41, 55)]
[Circle 5 (10, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 2  // 사용자 입력
[Circle 5 (10, 20)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 2  // 사용자 입력
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 7  // 사용자 입력
Good Bye
===============================================================================
== 프로그램을 테스트할 때 매번 새로운 그래픽 객체를 입력하는 것이 번거로울 수 있다.
== 프로그램을 새로 실행한 후 아래 숫자들을 Ctrl+C 해서 Ctrl+V로 Console 창에 한번에 입력하라.
== 마지막 12 12 뒤의 [엔터]까지도 복사해야 한다.
== 6개의 그래픽 객체를 순서적으로 입력하는 데이타이다.
=============================================================================== 
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
== 위 데이터를 한번에 복사해서 입력한 후의 실행결과이다.
=============================================================================== 
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 1   // 사용자 입력
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
12 12   // 여기까지 사용자가 한꺼번에 입력한 데이타
Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter the radius (enter one integer) >> [Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
[Circle 10 (9, 9)]
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> Select one Shape  
Rectangle:0, Circle:1, Line:2 >> Enter point coordinates (enter two integers) >> Enter point coordinates (enter two integers) >> [Rectangle  (1, 1) (2, 2)]
[Circle 4 (3, 3)]
[Line (5, 5) (6, 6)]
[Rectangle  (7, 7) (8, 8)]
[Circle 10 (9, 9)]
[Line (11, 11) (12, 12)]     // 6개의 그래픽 객체가 한번에 생성되었다. 그런 후 다른 메뉴항목을 테스트하라.
Select one operation  
Insert(Front):0, Insert(Rear):1, Remove(Front):2, Remove(Rear):3
Move(Front):4, Move(Rear):5, Print List:6, Exit:7 >> 
```

