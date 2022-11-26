```java
[운영체제 스케줄링 문제 4]

/******************************************************************************
 * 기존에 작성했던 Main.java 소스파일에 아래 코드들을 추가하라.
 *-----------------------------------------------------------------------------
 * 스케줄링 과제와 관련한 소스 코드는 기말고사에서 9장 문제로 출제될 예정이다.
 ******************************************************************************/

/******************************************************************************
 * 먼저 아래 [프로그램 실행결과]를 먼저 확인하라.
 * FCFS의 스케줄링 결과를 확인할 수 있다. 매 시간 단위마다 실행되는 프로세스 이름을 순서적으로 출력하였다.
 * 첫번째 스케줄링 결과: 도착한 순서대로 ABCDE 순서로 차례대로 실행되었다.
 * 두번째 스케줄링 결과: 도착시간은 모두 동일하다. Ready queue에 들어간 순서대로 실행된 것임
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
Menu item number? 3 // 사용자 입력
Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEE          AAAAAABBBCCCCDDDDDEE


...
Menu item number? 1 // 사용자 입력: 프로세스 정보들을 새로 입력함
The number of processes? 10 // 사용자 입력
input 10 process names: A  B  C  D  E   F   G   H   I   J // 사용자 입력
input 10 arrival times: 0  0  0  0  0   0   0   0   0   0 // 사용자 입력: 모든 프로세스들의 도착시간이 0으로 동일함
input 10 service times: 3  6  4  5  2   6   3   4   5   2 // 사용자 입력

 A  B  C  D  E  F  G  H  I  J 
 0  0  0  0  0  0  0  0  0  0 
 3  6  4  5  2  6  3  4  5  2 

...
Menu item number? 3 // 사용자 입력
Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEEFFFFFFGGGHHHHIIIIIJJ


/******************************************************************************
 * 코드 추가 및 변경: 1-1
 ******************************************************************************/
// 기존 class Scheduler에 아래 멤버들을 추가하라.
//-----------------------------------------------------------------------------

    private String name;                       // 스케줄러 이름
    protected int currentTime;                 // 현재시간
    protected int numOfProcess;                // 현재 readyQueue에 있는 총 프로세스의 개수
    protected Process currentProcess;          // 현재 실행되고 있는 프로세스를 지칭하는 변수
    protected boolean isNewProcessArrived;     // 현재시간에 새로운 프로세스가 도착한 경우 true, 아니면 false 
    protected LinkedList<Process> readyQueue;  // ready 상태의 모든 프로세스들을 모아 놓은 ready queue
    private Jobs jobs;                         // 앞으로 도착할 프세세스들의 정보를 가지고 있음
	
/******************************************************************************
 * 코드 추가 및 변경: 1-2
 ******************************************************************************/
// 아래 Scheduler 클래스 생성자와 setJobs(), getName()을 Scheduler 클래스에 추가하라.
// 각 멤버들의 초기 값을 유심히 봐 두길 바란다.
//-----------------------------------------------------------------------------

    protected Scheduler(String name) {         // 스케줄러의 각 필드를 초기화함
        this.name = name;
        currentTime = -1;
        numOfProcess = 0;
        currentProcess = null;
        isNewProcessArrived = false;
        readyQueue = new LinkedList<Process>();
    }
	
    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
        jobs.reset();    // 처음부터 다시 스케줄링하기 위해 프로세스 정보도 처음부터 시작하도록 설정
    }

    public String getName() { return name; } // 스케줄러 이름 반환
	
/******************************************************************************
 * 코드 추가 및 변경: 1-3
 ******************************************************************************/
// 스케줄링을 종료해야할지 판단하기 위해 호출되는 아래 메소드를 Scheduler 클래스에 추가하라.
// 이 메소드는 ComputerSystem::run()에서 호출된다.
//-----------------------------------------------------------------------------

    public boolean hasMoreProcessesToExecute() { // 모든 프로세스들의 실행이 종료되었는지 체크
        // 새로 도착할 프로세스가 아직 남아 있거나 또는 레디 큐에 프로세스가 있는 경우 (true 반환)
        // 새로 도착할 프로세스가 더 이상 없고 레디 큐에도 프로세스가 없으면 종료해도 됨 (false 반환)
        return(jobs.hasNextProcess() || (numOfProcess != 0));
    }

/******************************************************************************
 * 코드 추가 및 변경: 1-4
 ******************************************************************************/
// 아래 메소드를 Scheduler 클래스에 추가하라. 이 메소드는 ComputerSystem::run()에서 호출된다.
//-----------------------------------------------------------------------------

    // 매 시간 단위마다 호출되는 함수. ComputerSystem::run()에서 100ms마다 한번씩 호출됨
    // 매 시간단위마다 clock interrupt가 들어와 실행된다고 생각하면 됨
    // 각 스케줄링 알고리즘별로 이 함수를 재정의하되, 
    // 각 스케줄링 알고리즘의 재정의 함수에서 super클래스의 이 함수를 제일 먼저 호출해야 함
    public void clockInterrupt() {
        currentTime++;                                  // 현재시간을 1 증가함
        if (currentProcess != null) {                   // 현재 실행되고 있는 프로세스가 있다면
            currentProcess.incExecTime();               // 현재 실행되는 프로세스의 실행시간을 1 증가함
            System.out.print(currentProcess.getName()); // 1 시간단위만큼 실행된 프로세스의 이름을 출력함
        }
        else
            System.out.print(" ");                      // 현재 실행되는 프로세스가 없을 경우 출력

        // 새로 도착한 프로세스가 있을 경우 ready queue의 맨 끝에 추가
        // getNewProcess()는 현재시간 currentTime과 도착시간이 동일한 프로세스를 찾고
        //    해당 프로세스 정보를 기반으로 Process 객체를 생성하여 반환해 줌; 
        //    이 시간에 도착한 프로세스가 없을 경우 null 반환함
        for (Process p; (p = jobs.getNewProcess(currentTime)) != null; ) {
            isNewProcessArrived = true; // p는 새로 도착한 프로세스 객체
            ++numOfProcess;             // 총 프로세스의 개수를 증가
            readyQueue.add(p);          // ready 큐의 맨 끝에 프로세스 p 삽입
        }
    }


/******************************************************************************
 * 코드 추가 및 변경: 1-5
 ******************************************************************************/
// 아래 메소드를 Scheduler 클래스에 추가하라. 이 메소드는 ComputerSystem::run()에서 호출된다.
//-----------------------------------------------------------------------------

    // 현재 시간이 1씩 증가할 때마다 새로 스케줄링 해야할지 말지를 결정하는 함수
    // 모든 스케줄링 알고리즘에서 공통으로 적용됨: 스케줄링 시점을 결정하는 함수
    // 각 스케줄링 알고리즘별로 필요한 경우 이 함수를 재정의하여야 함(오버라이딩)
    public boolean isSchedulable() {
        return ((currentProcess == null) && isNewProcessArrived) ||       // 현재 실행 프로세스가 없는 상태에서 새로운 프로세스가 도착했을 때
               ((currentProcess != null) && currentProcess.isFinished()); // 현재 실행 중인 프로세스가 실행을 종료했을 때
    }

/******************************************************************************
 * 코드 추가 및 변경: 1-6
 ******************************************************************************/
// 아래 메소드를 Scheduler 클래스에 추가하라. 이 메소드는 ComputerSystem::run()에서 호출된다.
//-----------------------------------------------------------------------------

    // 재정의 함수에서 super클래스의 이 함수를 제일 먼저 호출해야 한며, 그런 후 
    // 각 스케줄링 알고리즘별로 이 함수를 재정의해야 함(오버라이딩). 
    // 각 스케줄링 알고리즘별로 다음에 실행할 우선순위가 가장 높은 프로세스를 선택해야 함
    public void schedule() {
        // 현재 실행중인 프로세스의 실행이 완료된 경우
        if ((currentProcess != null) && currentProcess.isFinished()) { 
            readyQueue.remove(currentProcess); // 현재 프로세스(currentProcess)를 ready queue에서 제거함
            --numOfProcess;                   // 총 프로세스의 개수를 감소
            currentProcess = null;
        }
        // 이 메소드에선 실행이 종료된 프로세스를 위처럼 큐에서 제거하는 역할만하고 실제 스케줄링은 하지 않음
        // 이 함수에서 리턴된 후 각 스케줄링 알고리즘별로 재정의된 메소드에서 
        // 우선순위가 가장 높은 프로세스를 선택해야 함. 
        // FCFS클래스의 schedule() 함수 참조.
    }

/******************************************************************************
 * 코드 추가 및 변경: 2
 ******************************************************************************/
// 기존 Jobs 클래스에 아래 멤버들을 추가하라.
// 이 메소드는 위 clockInterrupt()에서 매 시간단위마다 호출한다
//-----------------------------------------------------------------------------

    // 매 시간단위마다 호출되며, 
    // 각 프로세스의 도착시간과 현재시간 cTime가 동일한 프로세스를 찾아
    // 해당 프로세스 정보를 인자로하여 Process 객체를 생성하여 반환함
    public Process getNewProcess(int cTime) {
        if (index < arrivalTimes.length &&     // 아직 도착할 프로세스(index)가 남아 있는 경우
            arrivalTimes[index] == cTime) {    // 현재시간이 다음 프로세스(index)의 도착시간과 동일한 경우
            int i = index++;                   // 인덱스 값을 증가시켜 그 다음 프로세스를 가르키게 함
            return new Process(processNames[i], arrivalTimes[i], serviceTimes[i]); 
        }   // 도착한 프로세스가 있을 경우 위처럼 새 프로세스를 생성하여 반환하고,
        return null; // 현재시간 cTime에 도착한 프로세스가 없을 경우
    } 


/******************************************************************************
 * 코드 설명: 1
 ******************************************************************************/
// 아래 메소드는 ComputerSystem 클래스의 run() 메소드이다. (메인에서 호출)
// 아래 코드는 매 시간단위(100ms)마다 한번씩 수행되면 이때마다 
// scheduler.clockInterrupt()을 호출하여 스케줄러의 현재시간(currentTime)을 1씩 증가시킨다. 
// 현 시점에서 scheduler.isSchedulable()를 호출하여 스케줄링할 시점인지 판단한다.
// 예) 현재 실행중인 프로세스가 종료했거나, SRT 스케줄링 알고리즘에선 새로운 프로세스가 도착했을 경우,
//     RR인 경우 현재 프로세스가 time slice를 모두 다 사용했을 경우 등등
// 그런 후 scheduler.schedule() 호출하여 스케줄링하여 우선순위가 가장 높은 프로세스를 선택한다.
//-----------------------------------------------------------------------------

    public void run(Scheduler scheduler) { // 각 스케줄링 알고리즘을 테스트 함

        printEpilog(scheduler); // 화면에 단위시간 눈금자를 출력함
        scheduler.setJobs(jobs);

        while (scheduler.hasMoreProcessesToExecute()) { // 아직 더 실행해야 할 프로세스가 있는지 체크

            scheduler.clockInterrupt();     // 매 시간단위마다 스케줄러의 clock interrupt handler를 호출함

            if (scheduler.isSchedulable())  // 새로 스케줄링 해야하는 시점인지 체크
                scheduler.schedule();       // 새로 스케줄링 함

            try { // 우리 스케줄러에서 사용할 시간단위는 100ms: 빠르게 실행하려면 이 값을 10 또는 1로 줄여도 됨
                  // 100ms마다 한번씩 위 scheduler.clockInterrupt()와 schedule()가 한번씩 호출됨
                Thread.sleep(100); // 100 millisecond 동안 정지했다가 리턴함
            }
            catch (InterruptedException e) { // sleep()하는 동안 다른 스레드에 의해 인터럽이 들어 온 경우, 여기서는 전혀 발생하지 않음 
                e.printStackTrace(); // InterruptedException이 발생했을 경우 지금껏 호출된 함수 리스트를 출력해 볼 수 있음
                return;
            }
        }
        System.out.println("\n");
    }

/******************************************************************************
 * 코드 설명: 2
 ******************************************************************************/
// 모든 스케줄러는 아래 FCFS 클래스처럼 추상 클래스 Scheduler를 상속받아야 한다.
// 각 스케줄러는 무조건 Scheduler 클래스의 schedule() 메소드를 재정의하여 override하여야 하며
// 이 때 아래처럼 맨 먼저 슈퍼 클래스의 schedule()를 먼저 호출해야 한다.
// 슈퍼 클래스의 schedule()는 주로 현재 실행 중인 프로세스가 실행 완료했으면 
// 이를 ready queue에서 제거하는 역할을 수행한다.
//
// 중요: 최우선순위로 선택된 currentProcess는 readyQueue에서 제거되지 않고 계속 큐에 남아 있다.
//     다른 스케줄링 알고리즘에서도 마찬가지로 최우선순위로 스케줄링된 프로세스를 큐에서 제거하지 말아야 한다.
// 
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


===============================================================================
== 아래 데이타들을 입력하여 프로그램을 테스트해 보라.
=============================================================================== 

3

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
3

0

===============================================================================
== 위 데이타들을 [한 셋트씩] 한번에 복사해서 입력하면 다음과 같이 출력된다.
=============================================================================== 
 A  B  C  D  E  A  B  C  D  E 
 0  2  4  6  8 30 32 34 36 38 
 3  6  4  5  2  6  3  4  5  2 

************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? 3

1
10
A  B  C  D  E   F   G   H   I   J
0  2  4  6  8  23  32  34  36  38
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
10  12  14  16  18  30  32  34  36  38
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  0  0  0  0   0   0   0   0   0
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  1  2  3  4   5   6   7   8   9
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  3  6  9 12  15  18  21  24  27
3  6  4  5  2   6   3   4   5   2
3

1
10
A  B  C  D  E   F   G   H   I   J
0  4  7 15 15  23  24  24  37  38
3  6  4  5  2   6   3   4   5   2
3

0
Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEE          AAAAAABBBCCCCDDDDDEE


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
Menu item number? Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEE   FFFFFF   GGGHHHHIIIIIJJ


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
Menu item number? Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
           AAABBBBBBCCCCDDDDDEEFFFFFFGGGHHHHIIIIIJJ


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
Menu item number? Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEEFFFFFFGGGHHHHIIIIIJJ


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
Menu item number? Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEEFFFFFFGGGHHHHIIIIIJJ


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
Menu item number? Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAABBBBBBCCCCDDDDDEEFFFFFFGGGHHHHIIIIIJJ


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
Menu item number? Scheduling Algorithm: FCFS
0         1         2         3         4         5    
0123456789012345678901234567890123456789012345678901234
 AAA BBBBBBCCCC DDDDDEE FFFFFFGGGHHHH IIIIIJJ


************************ Main Menu *******************
* 0.Exit  1.Jobs 2.Process                           *
* 3.FCFS  4.SPN  5.HRRN  6.SRT  7.RR(q=1)  8.RR(q=4) *
******************************************************
Menu item number? Good bye.
```

