```java
[운영체제 스케줄링 문제 3]

/******************************************************************************
 * 기존에 작성했던 Main.java 소스파일에 아래 코드들을 추가하라.
 *-----------------------------------------------------------------------------
 * 스케줄링 과제와 관련한 소스 코드는 기말고사에서 9장 문제로 출제될 예정이다.
 ******************************************************************************/

/******************************************************************************
 * 먼저 아래 [문제 3 실행결과]를 먼저 확인하라.
 * 프로그램이 시작하면 프로세스들의 정보를 입력하지 않은데도 사전에 등록된 프로세스들의 정보가 출력된다. 
 * 또한 바로 2번 메뉴항목을 실행하여 사전에 등록된 프로세스들의 정보를 확인할 수 있다.
 *
 * 그런 후 3번 메뉴항목을 선택하여 FCFS 스케줄러를 실행한다.
 * 물론 스케줄러가 완성되어 있지 않기 때문에 스케줄링 결과는 출력되지 않았으며,
 * 결과를 출력하기 위한 준비 단계인 시간 테이블만 출력된 것을 확인할 수 있다.
 ******************************************************************************/

===============================================================================
== 문제 3 실행 결과
=============================================================================== 
 A  B  C  D  E  A  B  C  D  E 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 2 // 사용자 입력
Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 2) s(6) e(0)
C: a( 4) s(4) e(0)
D: a( 6) s(5) e(0)
E: a( 8) s(2) e(0)
A: a(30) s(6) e(0)
B: a(32) s(3) e(0)
C: a(34) s(4) e(0)
D: a(36) s(5) e(0)
E: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(38) rr( 7.33) f(false)
C: s(4) e(2) r(2) w(36) rr(10.00) f(false)
D: s(5) e(3) r(2) w(34) rr( 7.80) f(false)
E: s(2) e(2) r(0) w(32) rr(17.00) f(true)
A: s(6) e(3) r(3) w(10) rr( 2.67) f(false)
B: s(3) e(3) r(0) w( 8) rr( 3.67) f(true)
C: s(4) e(2) r(2) w( 6) rr( 2.50) f(false)
D: s(5) e(3) r(2) w( 4) rr( 1.80) f(false)
E: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 3 // 사용자 입력
Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234



************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 

/******************************************************************************
 * 코드 추가 및 변경: 1
 ******************************************************************************/
// 먼저 main() 메소드를 아래 코드로 변경하라.
// 아래 코드는 프로그램 시작하자마자 무조건 jobs와 cs 객체를 먼저 생성한다.
// jobs 객체를 생성할 때 기존과는 다르게 인자가 없는 디폴트 생성자를 호출한다. 
//-----------------------------------------------------------------------------

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        Jobs jobs = new Jobs();
        System.out.println();
        ComputerSystem cs = new ComputerSystem(jobs);

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
                    cs.setJobs(jobs);
                    break;
            case 2: jobs.processTest(); 
                    break;
            // FCFS 객체를 생성한 후 이를 인자로 사용하여 cs.run()를 호출한다.
            // cs.run()에서 FCFS 스케줄러를 작동시킴; "FCFS"는 스케줄러 이름이다.
            case 3: cs.run(new FCFS("FCFS"));
                    break;
            default: System.out.println("WRONG menu item\n");
                    break;
            }
            System.out.println();
        }
        System.out.println("Good bye.");
        scan.close();
    }

/******************************************************************************
 * 코드 추가 및 변경: 2
 ******************************************************************************/
// 기존의 Jobs 클래스의 멤버 변수 선언을 아래와 같이 변경하고 
// 디폴트 생성자를 아래와 같이 Jobs 클래스에 추가하라.
//
// main() 내의 Jobs jobs = new Jobs();처럼 인자없이 Jobs 객체를 생성할 경우
// 프로세스 이름, 도착시간, 서비스 시간 등의 프로세스들의 정보가 아래처럼 초기화된다.
// 즉, 사용자로부터 입력 받지 않아도 아래 정보들이 자동으로 입력된다.
//-----------------------------------------------------------------------------

    // 도착할 각 프로세스의 이름, 도착시간, 서비스시간 등을 배열로 관리함
    private String processNames[] = { "A", "B", "C", "D", "E", "A", "B", "C", "D", "E" };
    private int    arrivalTimes[] = {   0,   2,   4,   6,   8, 30,   32,  34,  36,  38 };
    private int    serviceTimes[] = {   3,   6,   4,   5,   2,  6,    3,   4,   5,   2 };

    private int    index; // 다음 번에 도착할 프로세스의 위 배열 인덱스

    public Jobs() { printJobs(); } // 디폴트 생성자


/******************************************************************************
 * 코드 추가 및 변경: 3
 ******************************************************************************/
// 아래 추상 클래스 Scheduler를 Process 클래스 아래(뒤)에 배치하라.
// 이 클래스는 스케줄러가 가져야 하는 메소드들을 가지고 있으며
// 이 클래스를 상속받는 일반 스케줄러 클래스들은 이들 메소드중 일부를 overrride해야 한다.
// Scheduler 클래스는 [스케줄링 문제 4]에서 상세히 다룰 예정이다.
//-----------------------------------------------------------------------------

//스케줄러의 기본 틀: 이 추상클래스를 상속받아 각 스케줄링 알고리즘을 구현해야 함
abstract class Scheduler {
    private String name;                        // 스케줄러 이름
    protected Process currentProcess;           // 현재 실행되고 있는 프로세스의 레퍼런스 변수
    protected LinkedList<Process> readyQueue;   // ready 상태의 모든 프로세스들을 모아 놓은 ready queue
    
    protected Scheduler(String name) { this.name = name; }

    public void setJobs(Jobs jobs) {}
    public boolean isSchedulable() { return false; }
    public void schedule() {}
    public boolean hasMoreProcessesToExecute() { return false; }
    public String getName() { return name; } // 스케줄러 이름 반환
    public int getCurrentTime() { return 0; } 
    public void clockInterrupt() {}
}

/******************************************************************************
 * 코드 추가 및 변경: 3
 ******************************************************************************/
// 아래 FCFS 클래스를 Scheduler 클래스 아래(뒤)에 배치하라.
// FCFS 클래스는 추상 클래스 Scheduler를 상속받아 FCFS 스케줄러를 구현한 완성본이다.
// 하지만 추상 클래스가 완벽히 구현되지 않았기 때문에 정상적으로 작동하지는 않는다.
// 이 클래스는 [스케줄링 문제 4]에서 Scheduler 클래스가 완벽히 구현되고 나면 정상적으로 작동할 것이다.
//-----------------------------------------------------------------------------

class FCFS extends Scheduler 
{
    FCFS(String name) {    super(name); } // 스케줄러 이름

    @Override
    public void schedule() {
        super.schedule();
        // 다음에 실행할 프로세스 선택
        // 큐의 헤드에 있는 원소를 반환 (삭제하지는 않음) , or 없으면 null 리턴
        currentProcess = readyQueue.peek(); 
        // 실제 시스템에서는 여기서 currentProcess에게 CPU를 넘김.
    }
}

/******************************************************************************
 * 문제 3
 ******************************************************************************/
// 아래 ComputerSystem 클래스를 Main 클래스 위(앞)에 배치하라.
// 이 클래스의 run() 메소드는 먼저 printEpilog() 메소드를 호출하여 화면에 시간 테이블을 출력하고
// 스케줄러를 작동시킨다. [스케줄링 문제 4]에서 run() 메소드의 기능을 상세히 설명한다.
// 현재는 스케줄러가 정상 작동하지 않는다.
//
// 아래 printEpilog(Scheduler scheduler) 메소드를 완성하라.
//-----------------------------------------------------------------------------

class ComputerSystem 
{
    public Jobs jobs;

    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }
    
    public ComputerSystem(Jobs jobs) {
        setJobs(jobs);
    }
    
    // 문제 3:
    public void printEpilog(Scheduler scheduler) {
        /* 화면에 다음과 같이 시간 테이블을 출력함
        Scheduling Algorithm: 알고리즘이름
        0         1         2         3         4         5        // 시간 십단위
        0123456789012345678901234567890123456789012345678901234 // 시간 일단위
        */

        위 내용을 화면에 출력하라.

        System.out.println();
    }

    public void run(Scheduler scheduler) { // 스케줄링 알고리즘을 테스트 함

        printEpilog(scheduler); // 화면에 단위시간 눈금자를 출력함
        scheduler.setJobs(jobs);

        while (scheduler.hasMoreProcessesToExecute()) { // 아직 더 실행해야 할 프로세스가 있는지 체크

            scheduler.clockInterrupt();       // 매 시간단위마다 스케줄러의 clock interrupt handler를 호출함

            if (scheduler.isSchedulable())    // 새로 스케줄링 해야하는 시점인지 체크
                scheduler.schedule();         // 새로 스케줄링 함

            try { // 우리 스케줄러에서 사용할 시간단위는 100ms: 빠르게 실행하려면 이 값을 10 또는 1로 줄여도 됨
                  // 100ms마다 한번씩 위 scheduler.clockInterrupt()와 schedule()가 한번씩 호출됨
                Thread.sleep(100); // 100 millisecond 동안 정지했다가 리턴함
            }
            // sleep()하는 동안 다른 스레드에 의해 인터럽이 들어 온 경우, 여기서는 전혀 발생하지 않음
            catch (InterruptedException e) {  
                // InterruptedException이 발생했을 경우 지금껏 호출된 함수 리스트를 출력해 볼 수 있음
                e.printStackTrace(); 
                return;
            }
        }
        System.out.println("\n");
    }
}

===============================================================================
== 아래 데이타들을 입력하여 프로그램을 테스트해 보라.
=============================================================================== 
2
3
1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
2
3
0
===============================================================================
== 위 데이타들을 한 셋트씩 한번에 복사해서 입력하면 다음과 같이 출력된다.
=============================================================================== 
 A  B  C  D  E  A  B  C  D  E 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 2
Create processes and print their member data.
A: a( 0) s(3) e(0)
B: a( 2) s(6) e(0)
C: a( 4) s(4) e(0)
D: a( 6) s(5) e(0)
E: a( 8) s(2) e(0)
A: a(30) s(6) e(0)
B: a(32) s(3) e(0)
C: a(34) s(4) e(0)
D: a(36) s(5) e(0)
E: a(38) s(2) e(0)

Print returned values of member methods of each process.
A: s(3) e(3) r(0) w(40) rr(14.33) f(true)
B: s(6) e(3) r(3) w(38) rr( 7.33) f(false)
C: s(4) e(2) r(2) w(36) rr(10.00) f(false)
D: s(5) e(3) r(2) w(34) rr( 7.80) f(false)
E: s(2) e(2) r(0) w(32) rr(17.00) f(true)
A: s(6) e(3) r(3) w(10) rr( 2.67) f(false)
B: s(3) e(3) r(0) w( 8) rr( 3.67) f(true)
C: s(4) e(2) r(2) w( 6) rr( 2.50) f(false)
D: s(5) e(3) r(2) w( 4) rr( 1.80) f(false)
E: s(2) e(2) r(0) w( 2) rr( 2.00) f(true)

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 3
Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234



************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 1
The number of processes? 10
input 10 process names: A  B  C  D  E   F   G   H   I   J
input 10 arrival times: 0  4  7 15 15  23  24  24  37  38
input 10 service times: 3  6  4  5  2   6   3   4   5   2

 A  B  C  D  E  F  G  H  I  J 
 0  4  7 15 15 23 24 24 37 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 2
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

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 3
Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234



************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 0
Good bye.
```

