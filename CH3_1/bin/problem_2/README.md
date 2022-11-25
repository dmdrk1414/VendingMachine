```java
[운영체제 스케줄링 문제 2]

/******************************************************************************
 * 기존에 작성했던 Main.java 소스파일에 아래 코드들을 추가하라.
 *-----------------------------------------------------------------------------
 * 스케줄링 과제와 관련한 소스 코드는 기말고사에서 9장 문제로 출제될 예정이다.
 ******************************************************************************/

/******************************************************************************
 * 먼저 아래 [문제 2 실행결과]를 먼저 확인하라.
 * 사용자는 1번 메뉴항목을 입력하고 프로세스의 개수와 각 프로세스의 이름, 도착시간, 서비스시간 등을 입력해야 한다.
 * 그런 후 2번 메뉴항목을 선택하여 사용자가 입력한 프로세스 정보을 기반하여 해당 Process 객체들을 생성하고
 * 향후 스케줄링에 필요한 각 Process의 멤버 값과 멤버 메소드의 반환 값을 출력한다. 
 ******************************************************************************/

===============================================================================
== 문제 2 실행 결과
=============================================================================== 
************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 2 // 사용자 입력
Jobs is not initalized. Run menu item [1.Jobs] in advance.

...
Menu item number? 1 // 사용자 입력
The number of processes? 10 // 사용자 입력
input 10 process names: A  B  C  D  E   F   G   H   I   J // 사용자 입력
input 10 arrival times: 0  4  7 15 15  23  24  24  37  38 // 사용자 입력
input 10 service times: 3  6  4  5  2   6   3   4   5   2 // 사용자 입력

...
Menu item number? 2 // 사용자 입력
Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 4) s(6) e(0)
C: a( 7) s(4) e(0)
D: a(15) s(5) e(0)
E: a(15) s(2) e(0)
F: a(23) s(6) e(0)
G: a(24) s(3) e(0)
H: a(24) s(4) e(0)
I: a(37) s(5) e(0)
J: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(36) rr( 7.00) f(false)
C: s(4) e(2) r(2) w(33) rr( 9.25) f(false)
D: s(5) e(3) r(2) w(25) rr( 6.00) f(false)
E: s(2) e(2) r(0) w(25) rr(13.50) f(true)
F: s(6) e(3) r(3) w(17) rr( 3.83) f(false)
G: s(3) e(3) r(0) w(16) rr( 6.33) f(true)
H: s(4) e(2) r(2) w(16) rr( 5.00) f(false)
I: s(5) e(3) r(2) w( 3) rr( 1.60) f(false)
J: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

...

/******************************************************************************
 * 문제 2-1
 ******************************************************************************/
// 먼저 main() 메소드에 2번 메뉴항목을 처리하는 아래 코드를 추가하라.
//-----------------------------------------------------------------------------

            case 2: 
                    if (jobs == null)
                        System.out.println("Jobs is not initalized. "+
                                         "Run menu item [1.Jobs] in advance.");
                    else
                        jobs.processTest(); 
                    break;

/******************************************************************************
 * 문제 2-2
 ******************************************************************************/
// Jobs 클래스 내에 맨 마지막에 아래 메소드를 추가하라. 
// 이 메소드는 사용자가 입력한 프로세스 정보를 참조하여 상응하는 Process 객체를 생성하여 리스트에 보관한다.
// 그런 후 구현된 Process 클래스의 멤버 메소드를 테스트하기 위해 프로세스 정보를 화면에 출력한다.
//-----------------------------------------------------------------------------
    public void processTest() {
        reset();
        LinkedList<Process> rq = new LinkedList<>();

        System.out.println("Create processes and print their member data.");
        for (int i = 0; i < processNames.length; ++i) {
            Process p = new Process(processNames[i], arrivalTimes[i], serviceTimes[i]);
            rq.add(p);
            System.out.println(p); // 각 프로세스의 멤버 변수들을 출력한다.
        }
        for (Process p: rq) {
            int eTime = p.getServiceTime(); // 이 값이 실행시간이 되도록 할 것이다.
            if (eTime > 3) // 서비스시간이 3보다 큰 경우 실행시간을 반으로 설정하기 위함임
                eTime = (int)(eTime * 0.5 + 0.5); // 실행시간의 반을 반올림
            for (int i = 0; i < eTime; ++i) // 실행시간을 1씩 증가시킨다.
                p.incExecTime();
        }
        System.out.println("Print returned values of member methods of each process.");
        for (Process p: rq) // 각 프로세스의 멤버 메소드의 반환값들을 출력한다. 
            p.println(40);  // 40은 현재시간을 의미함
    }

/******************************************************************************
 * 문제 2-3
 ******************************************************************************/
// Jobs 클래스 앞(위)에 아래 Process 클래스를 추가하고, 
// [문제 2-3:]로 표기된 각각의 멤버 메소드를 구현하라.
//-----------------------------------------------------------------------------

class Process {
    private String name;        // 프로세스 이름
    private int arrivalTime;    // 프로세스 도착시간
    private int serviceTime;    // 프로세스 서비스시간, 실행해야 할 총 시간
    private int executionTime;    // 프로세스의 현재까지 실행된 시간

    // 문제 2-3: 프로세스의 각 필드를 초기화함
    Process(String name, int arrivalTime, int serviceTime) { 
        클래스의 해당 멤버들을 초기화하라.
        executionTime = 0;
    }

    // 문제 2-3: 프로세스의 현재까지 실행된 시간을 증가시킴
    public void    incExecTime()          {  } 

    // 문제 2-3: 프로세스의 서비스시간을 반환함
    public int  getServiceTime()          { return 0; }

    // 문제 2-3: cTime은 현재시간임. 시스템에 도착한 이후 ready queue에서 현재시간까지 대기한 대기시간을 반환함
    // cTime과 arrivalTime을 이용한 계산
    public int  getWaitingTime(int cTime) { return 0; } 

    // 문제 2-3: 앞으로 더 실행해야 하는 남은 실행시간을 반환함
    public int  getRemainingTime()        { return 0; } 

    // 문제 2-3: 프로세스의 실행이 종료되었는지 체크함: serviceTime과 executionTime의 상관관계
    public boolean isFinished()           { return true; }

    // 문제 2-3: cTime은 현재시간임. 프로세스의 응답비율(Response Ratio)를 계산해 반환함
    // 계산시 double로 변환 후 계산해야 함; 위 getWaitingTime(int cTime)을 활용할 것
    public double  getResponeRatioTime(int cTime)  { 
        return 0.0; 
    }
    
    // 프로세스의 이름을 반환함
    public String  getName()              { return name; }

    public void println(int cTime) {
        System.out.printf("%s: s(%d) e(%d) r(%d) w(%2d) rr(%5.2f) f(%s)\n",  
            name, getServiceTime(), executionTime, getRemainingTime(), 
            getWaitingTime(cTime), getResponeRatioTime(cTime), isFinished());
    }

    public String toString() {
        return String.format("%s: a(%2d) s(%d) e(%d)", 
                              name, arrivalTime, serviceTime, executionTime);
    }
}

===============================================================================
== 아래 데이타들을 입력하여 프로그램을 테스트해 보라.
=============================================================================== 
1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
2

0

===============================================================================
== 위 데이타들을 한 셋트씩 한번에 복사해서 입력하면 다음과 같이 출력된다.
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
2

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
2

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
2

0
The number of processes? input 10 process names: input 10 arrival times: input 10 service times: 
 A  B  C  D  E  F  G  H  I  J 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 2) s(6) e(0)
C: a( 4) s(4) e(0)
D: a( 6) s(5) e(0)
E: a( 8) s(2) e(0)
F: a(30) s(6) e(0)
G: a(32) s(3) e(0)
H: a(34) s(4) e(0)
I: a(36) s(5) e(0)
J: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(38) rr( 7.33) f(false)
C: s(4) e(2) r(2) w(36) rr(10.00) f(false)
D: s(5) e(3) r(2) w(34) rr( 7.80) f(false)
E: s(2) e(2) r(0) w(32) rr(17.00) f(true)
F: s(6) e(3) r(3) w(10) rr( 2.67) f(false)
G: s(3) e(3) r(0) w( 8) rr( 3.67) f(true)
H: s(4) e(2) r(2) w( 6) rr( 2.50) f(false)
I: s(5) e(3) r(2) w( 4) rr( 1.80) f(false)
J: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

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
Menu item number? Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 2) s(6) e(0)
C: a( 4) s(4) e(0)
D: a( 6) s(5) e(0)
E: a( 8) s(2) e(0)
F: a(23) s(6) e(0)
G: a(32) s(3) e(0)
H: a(34) s(4) e(0)
I: a(36) s(5) e(0)
J: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(38) rr( 7.33) f(false)
C: s(4) e(2) r(2) w(36) rr(10.00) f(false)
D: s(5) e(3) r(2) w(34) rr( 7.80) f(false)
E: s(2) e(2) r(0) w(32) rr(17.00) f(true)
F: s(6) e(3) r(3) w(17) rr( 3.83) f(false)
G: s(3) e(3) r(0) w( 8) rr( 3.67) f(true)
H: s(4) e(2) r(2) w( 6) rr( 2.50) f(false)
I: s(5) e(3) r(2) w( 4) rr( 1.80) f(false)
J: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

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
Menu item number? Create processes and print their member data.
A: a(10) s(3) e(0)
B: a(12) s(6) e(0)
C: a(14) s(4) e(0)
D: a(16) s(5) e(0)
E: a(18) s(2) e(0)
F: a(30) s(6) e(0)
G: a(32) s(3) e(0)
H: a(34) s(4) e(0)
I: a(36) s(5) e(0)
J: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(30) rr(11.00) f(true)
B: s(6) e(3) r(3) w(28) rr( 5.67) f(false)
C: s(4) e(2) r(2) w(26) rr( 7.50) f(false)
D: s(5) e(3) r(2) w(24) rr( 5.80) f(false)
E: s(2) e(2) r(0) w(22) rr(12.00) f(true)
F: s(6) e(3) r(3) w(10) rr( 2.67) f(false)
G: s(3) e(3) r(0) w( 8) rr( 3.67) f(true)
H: s(4) e(2) r(2) w( 6) rr( 2.50) f(false)
I: s(5) e(3) r(2) w( 4) rr( 1.80) f(false)
J: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

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
Menu item number? Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 0) s(6) e(0)
C: a( 0) s(4) e(0)
D: a( 0) s(5) e(0)
E: a( 0) s(2) e(0)
F: a( 0) s(6) e(0)
G: a( 0) s(3) e(0)
H: a( 0) s(4) e(0)
I: a( 0) s(5) e(0)
J: a( 0) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(40) rr( 7.67) f(false)
C: s(4) e(2) r(2) w(40) rr(11.00) f(false)
D: s(5) e(3) r(2) w(40) rr( 9.00) f(false)
E: s(2) e(2) r(0) w(40) rr(21.00) f(true)
F: s(6) e(3) r(3) w(40) rr( 7.67) f(false)
G: s(3) e(3) r(0) w(40) rr(14.33) f(true)
H: s(4) e(2) r(2) w(40) rr(11.00) f(false)
I: s(5) e(3) r(2) w(40) rr( 9.00) f(false)
J: s(2) e(2) r(0) w(40) rr(21.00) f(true)

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
Menu item number? Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 1) s(6) e(0)
C: a( 2) s(4) e(0)
D: a( 3) s(5) e(0)
E: a( 4) s(2) e(0)
F: a( 5) s(6) e(0)
G: a( 6) s(3) e(0)
H: a( 7) s(4) e(0)
I: a( 8) s(5) e(0)
J: a( 9) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(39) rr( 7.50) f(false)
C: s(4) e(2) r(2) w(38) rr(10.50) f(false)
D: s(5) e(3) r(2) w(37) rr( 8.40) f(false)
E: s(2) e(2) r(0) w(36) rr(19.00) f(true)
F: s(6) e(3) r(3) w(35) rr( 6.83) f(false)
G: s(3) e(3) r(0) w(34) rr(12.33) f(true)
H: s(4) e(2) r(2) w(33) rr( 9.25) f(false)
I: s(5) e(3) r(2) w(32) rr( 7.40) f(false)
J: s(2) e(2) r(0) w(31) rr(16.50) f(true)

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
Menu item number? Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 3) s(6) e(0)
C: a( 6) s(4) e(0)
D: a( 9) s(5) e(0)
E: a(12) s(2) e(0)
F: a(15) s(6) e(0)
G: a(18) s(3) e(0)
H: a(21) s(4) e(0)
I: a(24) s(5) e(0)
J: a(27) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(37) rr( 7.17) f(false)
C: s(4) e(2) r(2) w(34) rr( 9.50) f(false)
D: s(5) e(3) r(2) w(31) rr( 7.20) f(false)
E: s(2) e(2) r(0) w(28) rr(15.00) f(true)
F: s(6) e(3) r(3) w(25) rr( 5.17) f(false)
G: s(3) e(3) r(0) w(22) rr( 8.33) f(true)
H: s(4) e(2) r(2) w(19) rr( 5.75) f(false)
I: s(5) e(3) r(2) w(16) rr( 4.20) f(false)
J: s(2) e(2) r(0) w(13) rr( 7.50) f(true)

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
Menu item number? Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 4) s(6) e(0)
C: a( 7) s(4) e(0)
D: a(15) s(5) e(0)
E: a(15) s(2) e(0)
F: a(23) s(6) e(0)
G: a(24) s(3) e(0)
H: a(24) s(4) e(0)
I: a(37) s(5) e(0)
J: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(36) rr( 7.00) f(false)
C: s(4) e(2) r(2) w(33) rr( 9.25) f(false)
D: s(5) e(3) r(2) w(25) rr( 6.00) f(false)
E: s(2) e(2) r(0) w(25) rr(13.50) f(true)
F: s(6) e(3) r(3) w(17) rr( 3.83) f(false)
G: s(3) e(3) r(0) w(16) rr( 6.33) f(true)
H: s(4) e(2) r(2) w(16) rr( 5.00) f(false)
I: s(5) e(3) r(2) w( 3) rr( 1.60) f(false)
J: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Good bye.
```

