```java
[운영체제 스케줄링 문제 8]

수정: 11.15 19:20
     ComputerSystem 클래스의 run()에서 System.sleep(100)을 ---> 
     System.sleep(10)으로 수정하기 바랍니다.
     수정하지 않으면 OJ에서 time limit에 걸리게 됨 


/******************************************************************************
 * 기존에 작성했던 Main.java 소스파일에 아래 코드들을 추가하라.
 *-----------------------------------------------------------------------------
 * 스케줄링 과제와 관련한 소스 코드는 기말고사에서 9장 문제로 출제될 예정이다.
 ******************************************************************************/

/******************************************************************************
 * 먼저 아래 [프로그램 실행 결과]를 먼저 확인하라.
 * RR의 스케줄링 결과를 확인할 수 있다.
 ******************************************************************************/

===============================================================================
== 프로그램 실행 결과
=============================================================================== 
 A  B  C  D  E  A  B  C  D  E 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 7
Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AABABCBDCBEDCBEDCBDD          AABABCABDCAEDCAEDCDD


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 8
Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBCCCCDDDDBBEED          AAAABBBCCCCAADDDDEED

/******************************************************************************
 * 문제 8-1
 ******************************************************************************/
// 아래 RR 스케줄링 클래스를 SRT 클래스 다음에 배치한 후 구현하라.

class RR extends Scheduler {
    private int quantum;    // RR 알고리즘의 time quantum, time slice
    private int execTime;   // 현재 프로세스의 주어진 time quantum을 소진한 실행시간, 
    // time quantum 보다 작아야 하며, 만약 동일하면 time slice를 모두 소진한 것임
    // 이 값은 매 시간 단위마다 1씩 증가함
    
    RR(String name, int qauntum) {
        슈퍼 클래스의 생성자를 먼저 호출하고
        qauntum 멤버 초기화
        execTime = 0;
    }

    // 현재 실행중인 프로세스가 주어진 time quantum을 모두 소진한 경우 true
    private boolean timeQuantumExausted() { 
        현재 실행하는 프로세스가 존재하고(currentProcess 값을 체크할 것)
        현재 execTime이 quantum과 동일한 경우 true 반환;
    }
}

// 이 클래스의 구현 시
//    1) 추상 클래스 Scheduler를 상속받아야 한다. (FCFS 클래스 참조)
//    2) 생성자 메소드를 정의하라.   
//    3) 위 timeQuantumExausted() 메소드를 정의하라.   
//    4) Scheduler 클래스의 schedule() 메소드를 재정의하여 override하라. (FCFS 클래스 참조)
//       이 메소드 구현 시
//          먼저 슈퍼 클래스의 schedule()를 먼저 호출
//          현재 실행하는 프로세스가 주어진 time quantum을 모두 소진한 경우(timeQuantumExausted())
//              readyQueue의 맨 앞쪽 프로세스를 큐의 맨 끝으로 이동
//              (즉, 맨 앞쪽 프로세스를 제거해서 큐의 맨 마지막에 추가함)
//          readyQueue의 맨 앞쪽 프로세스를 currentProcess에 설정한다.
//          execTime을 다시 0으로 초기화
//    5) Scheduler 클래스의 isSchedulable() 메소드를 재정의하여 override하라.
//       이 메소드 구현 시 
//          (RR는 선점형 스케줄러이므로, 기존에 실행하던 프로세스가 종료했거나 또는 
//           주어진 time quantum을 모두 소진한 경우 다시 스케줄링해야 함)
//          먼저 슈퍼 클래스의 isSchedulable()를 먼저 호출하여 스케줄링 가능한 경우 또는
//          주어진 time quantum을 모두 소진한 경우(timeQuantumExausted())
//          true를 반환 (리턴문을 한 문장으로 코딩해 보라)
//    6) Scheduler 클래스의 clockInterrupt() 메소드를 재정의하여 override하라.
//       이 메소드는 매 시간단위마다 호출되는데, 이 메소드 구현 시 
//          먼저 슈퍼 클래스의 상응하는 메소드를 먼저 호출하고
//          execTime을 1 증가함
//
// 중요: 최우선순위로 선택된 currentProcess는 readyQueue에서 제거되지 않고 계속 큐에 남아 있다.
//     다른 스케줄링 알고리즘에서도 마찬가지로 최우선순위로 스케줄링된 프로세스를 큐에서 제거하지 말아야 한다.
// 
//-----------------------------------------------------------------------------

class RR { }

/******************************************************************************
 * 문제 8-2
 ******************************************************************************/
// main() 메소드에서 메인 메뉴에서
// 7번 항목을 실행하는 case 문장을 기존 switch 문장에 추가하라.
// 7번 항목이 선택된 경우 RR 클래스의 객체를 생성한 후 이를 인자로 사용하여 cs.run()을 호출하라.
// RR 스케줄러 객체 생성 시 스케줄러 이름은 "RR(q=1)"으로 하고, time quantum으로 1을 지정하라.

// 또한 8번 항목을 실행하는 case 문장을 기존 switch 문장에 추가하라.
// 8번 항목이 선택된 경우 RR 클래스의 객체를 생성한 후 이를 인자로 사용하여 cs.run()을 호출하라.
// RR 스케줄러 객체 생성 시 스케줄러 이름은 "RR(q=4)"로 하고, time quantum으로 4를 지정하라.
//-----------------------------------------------------------------------------

===============================================================================
== 아래 데이타들을 입력하여 프로그램을 테스트해 보라.
=============================================================================== 

7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
7
8

0

===============================================================================
== 위 데이타들 모두를 한번에 복사해서 입력하면 다음과 같이 출력된다.
=============================================================================== 
 A  B  C  D  E  A  B  C  D  E 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
7
8

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
7
8

0
Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AABABCBDCBEDCBEDCBDD          AABABCABDCAEDCAEDCDD


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBCCCCDDDDBBEED          AAAABBBCCCCAADDDDEED


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
Menu item number? Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AABABCBDCBEDCBEDCBDD   FFFFFF   GGHGHIHJIHJIII


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBCCCCDDDDBBEED   FFFFFF   GGGHHHHIIIIJJI


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
Menu item number? Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
           AABABCBDCBEDCBEDCBDDFFGFGHFGIHFJIHFJIHII


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
           AAABBBBCCCCDDDDBBEEDFFFFGGGHHHHFFIIIIJJI


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
Menu item number? Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 ABCDEFGHIJABCDEFGHIJABCDFGHIBCDFHIBDFIBF


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBCCCCDDDDEEFFFFGGGHHHHIIIIJJBBDFFI


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
Menu item number? Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 ABACBDAECFBGDHIEJCFBGDHIJCFBGDHIFBDHIFIF


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBCCCCDDDDEEFFFFGGGHHHHBBIIIIJJDFFI


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
Menu item number? Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBCBCBDCBDECDFEDGFDHGFIHGFJIHFJIHFII


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBCCCCBBDDDDEEFFFFDGGGHHHHFFIIIIJJI


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
Menu item number? Scheduling Algorithm: RR(q=1)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAA BBBCBCBCBC DEDEDDD FGHFGHFGHFHFF IJIJIII


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Scheduling Algorithm: RR(q=4)
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAA BBBBCCCCBB DDDDEED FFFFGGGHHHHFF IIIIJJI


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Good bye.
```

