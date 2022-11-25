```java
[운영체제 스케줄링 문제 1]

/******************************************************************************
 * 이번 과제에서는 운영체제 9장의 스케줄링 알고리즘을 구현하는 것이다.
 * 구현해야 할 알고리즘: FCFS, SPN, HRRN, SRT, RR
 * 이들 모두를 한번에 구현하기 전에 순서적으로 여러 문제로 나누어서 구현할 예정이다.
 *
 * 스케줄링 과제와 관련한 소스 코드는 기말고사에서 9장 문제로 출제될 예정이다.
 *
 ******************************************************************************/

/******************************************************************************
 * 먼저 아래 [문제 1 실행결과]를 먼저 확인하라.
 * 사용자는 메뉴항목을 입력하고 프로세스의 개수와 각 프로세스의 이름, 도착시간, 서비스시간 등을 입력해야 한다.
 * 프로그램에서는 이런한 데이터를 입력 받아 저장한 후에 입력이 끝난 후 화면에 전체를 다시 보여 준다.
 ******************************************************************************/
===============================================================================
== 문제 1 실행 결과
=============================================================================== 
************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 1 // 사용자 입력
The number of processes? 10 // 사용자 입력
input 10 process names: A  B  C  D  E   F   G   H   I   J // 사용자 입력
input 10 arrival times: 0  2  4  6  8  30  32  34  36  38 // 사용자 입력
input 10 service times: 3  6  4  5  2   6   3   4   5   2 // 사용자 입력

 A  B  C  D  E  F  G  H  I  J 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 0 // 사용자 입력
Good bye.

/******************************************************************************
 * 문제 1
 ******************************************************************************/
// 새로운 프로젝트를 만들어라.
// 새로운 클래스 Main를 만들어 Main.java 소스파일을 만든 후 아래 코드를 추가하라.

// 그런 후 위 [문제 1 실행결과]를 참조하여 Jobs 클래스의 생성자를 완성하라.
// 이 생성자는 프로세스의 개수와 각 프로세스의 이름, 도착시간, 서비스시간 등을 입력 받는다.
//-----------------------------------------------------------------------------

import java.util.*;

class Jobs 
{
    // 도착할 각 프로세스의 이름, 도착시간, 서비스시간 등을 배열로 관리함
    private String processNames[];
    private int    arrivalTimes[];
    private int    serviceTimes[];
    private int    index; // 다음 번에 도착할 프로세스의 위 배열 인덱스

    public void printJobs() {
        for (String n: processNames)
            System.out.printf("%2s ", n); 
        System.out.println();
        for (int t: arrivalTimes)
            System.out.printf("%2d ", t); 
        System.out.println();
        for (int s: serviceTimes)
            System.out.printf("%2d ", s); 
        System.out.println();
    }
    
    public Jobs(Scanner s) {  // 생성자
        // 실행할 총 프로세스의 개수를 입력 받음
        System.out.print("The number of processes? ");
        int num = s.nextInt();

        // num개의 원소를 가지는 문자열 processNames[] 배열을 생성
        // 적절한 입력용 메시지를 출력하고("input ? process names : ")
        // for 문을 이용하여 num개  프로세스들의 이름을 입력 받아 processNames[] 배열에 저장 

        // num개의 원소를 가지는 정수형 arrivalTimes[] 배열을 생성
        // 적절한 입력용 메시지를 출력하고
        // for 문을 이용하여 num개  프로세스들의 도착시간을 입력 받아 arrivalTimes[] 배열에 저장 

        // num개의 원소를 가지는 정수형 serviceTimes[] 배열을 생성
        // 적절한 입력용 메시지를 출력하고
        // for 문을 이용하여 num개  프로세스들의 서비스시간을 입력 받아 serviceTimes[] 배열에 저장 

        System.out.println();
        printJobs();
    }
    
    // 처음부터 다시 스케줄링을 시작하고자 하는 경우 호출
    public void    reset()          { index = 0; } 
        
    // 아직 도착하지 않은 프로세스가 더 있는지 조사
    public boolean hasNextProcess() { return index < arrivalTimes.length; } 

}

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Jobs jobs = null;

        while (true) {
            System.out.println("************************ Main Menu *******************");
            System.out.println("* 0.Exit  1.Jobs 2.Process                           *");
            System.out.println("* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *");
            System.out.println("******************************************************");
            System.out.print("Menu item number? ");

            int idx = scan.nextInt();
            if (idx == 0) 
                break;

            switch (idx) {
            case 1: jobs = new Jobs(scan); 
                    break;
            default: System.out.println("WRONG menu item\n");
                    break;
            }
            System.out.println();
        }
        System.out.println("Good bye.");
        scan.close();
    }
}

===============================================================================
== 프로그램 실행시 아래 내용을 한줄씩 복사해서 순서적으로 입력하거나 또는 전체를 복사해서 한번에 입력하시오.
=============================================================================== 
1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
0
===============================================================================
== 아래 데이타들도 입력용으로 테스트해 보라.
=============================================================================== 
1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2

0
===============================================================================
== 위 데이타들을 한번에 복사해서 입력하면 다음과 같이 출력된다.
=============================================================================== 
************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2

0
The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  2  4  6  8 23 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
10 12 14 16 18 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  0  0  0  0  0  0  0  0  0 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  1  2  3  4  5  6  7  8  9 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  3  6  9 12 15 18 21 24 27 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  4  7 15 15 23 24 24 37 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Good bye.
```

