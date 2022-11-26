```java
[운영체제 스케줄링 문제 5]

/******************************************************************************
 * 기존에 작성했던 Main.java 소스파일에 아래 코드들을 추가하라.
 *-----------------------------------------------------------------------------
 * 스케줄링 과제와 관련한 소스 코드는 기말고사에서 9장 문제로 출제될 예정이다.
 ******************************************************************************/

/******************************************************************************
 * 먼저 아래 [프로그램 실행 결과]를 먼저 확인하라.
 * SPN의 스케줄링 결과를 확인할 수 있다.
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
Menu item number? 4
Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBEECCCCDDDDD          AAAAAABBBEECCCCDDDDD


/******************************************************************************
 * 문제 5-1
 ******************************************************************************/
// 아래 SPN 스케줄링 클래스를 FCFS 다음에 배치한 후 구현하라.
// 이 클래스의 구현 시
//    1) 추상 클래스 Scheduler를 상속받아야 한다. (FCFS 클래스 참조)
//    2) 생성자 메소드를 정의하라. (FCFS 클래스 참조)
//    3) Scheduler 클래스의 schedule() 메소드를 재정의하라. (FCFS 클래스 참조)
//       이 메소드 구현 시
//          먼저 슈퍼 클래스의 schedule()를 먼저 호출
//          for문을 이용하여 readyQueue에 있는 프로세스들 중 서비스 시간이 
//               가장 작은 프로세스를 찾는다.
//          찾은 프로세스를 currentProcess에 설정한다.
//
// 중요: 최우선순위로 선택된 currentProcess는 readyQueue에서 제거되지 않고 계속 큐에 남아 있다.
//     다른 스케줄링 알고리즘에서도 마찬가지로 최우선순위로 스케줄링된 프로세스를 큐에서 제거하지 말아야 한다.
// 
//-----------------------------------------------------------------------------

class SPN { }

/******************************************************************************
 * 문제 5-2
 ******************************************************************************/
// main() 메소드에서 메인 메뉴의 4번 항목을 실행하는 case 문장을 기존 switch 문장에 추가하라.
// 4번 항목이 선택된 경우 SPN 클래스의 객체를 생성한 후 이를 인자로 사용하여 cs.run()을 호출하라.
// SPN 스케줄러 객체 생성 시 스케줄러 이름은 "SPN"으로 하라.
// 3번 메뉴 항목을 실행하는 case 문장을 참조하라. 
//-----------------------------------------------------------------------------

===============================================================================
== 아래 데이타들을 입력하여 프로그램을 테스트해 보라.
=============================================================================== 

4

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
4

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
Menu item number? 4          // 여기서부터 한번에 복사해서 입력

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
4

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
4

0                           // 여기까지 한번에 복사해서 입력
Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBEECCCCDDDDD          AAAAAABBBEECCCCDDDDD


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
Menu item number? Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBEECCCCDDDDD   FFFFFF   GGGHHHHJJIIIII


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
Menu item number? Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
           AAABBBBBBEECCCCDDDDDFFFFFFGGGJJHHHHIIIII


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
Menu item number? Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 EEJJAAAGGGCCCCHHHHDDDDDIIIIIBBBBBBFFFFFF


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
Menu item number? Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAACCCCEEJJGGGHHHHDDDDDIIIIIBBBBBBFFFFFF


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
Menu item number? Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCEEDDDDDGGGHHHHJJIIIIIFFFFFF


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
Menu item number? Scheduling Algorithm: SPN
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAA BBBBBBCCCC EEDDDDD FFFFFFGGGHHHH IIIIIJJ


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Good bye.
```

