package problem_5;

import java.util.LinkedList;
import java.util.Scanner;

// 기존의 Jobs 클래스의 멤버 변수 선언을 아래와 같이 변경하고
// 디폴트 생성자를 아래와 같이 Jobs 클래스에 추가하라.

// main() 내의 Jobs jobs = new Jobs();처럼 인자없이 Jobs 객체를 생성할 경우
// 프로세스 이름, 도착시간, 서비스 시간 등의 프로세스들의 정보가 아래처럼 초기화된다.
// 즉, 사용자로부터 입력 받지 않아도 아래 정보들이 자동으로 입력된다.
class Jobs {

	// 도착할 각 프로세스의 이름, 도착시간, 서비스시간 등을 배열로 관리함
	private String processNames[] = { "A", "B", "C", "D", "E", "A", "B", "C", "D", "E" };
	private int arrivalTimes[] = { 0, 2, 4, 6, 8, 30, 32, 34, 36, 38 };
	private int serviceTimes[] = { 3, 6, 4, 5, 2, 6, 3, 4, 5, 2 };

	private int index; // 다음 번에 도착할 프로세스의 위 배열 인덱스

	public Jobs() {
		printJobs();
	} // 디폴트 생성자

	// Show print Jobs
	public void printJobs() {
		for (String n : processNames)
			System.out.printf("%2s ", n);
		System.out.println();
		for (int t : arrivalTimes)
			System.out.printf("%2d ", t);
		System.out.println();
		for (int s : serviceTimes)
			System.out.printf("%2d ", s);
		System.out.println();
	}

	public Jobs(Scanner s) { // 생성자
		// 실행할 총 프로세스의 개수를 입력 받음
		System.out.print("The number of processes? ");
		int num = s.nextInt();

		// num개의 원소를 가지는 문자열 processNames[] 배열을 생성
		processNames = new String[num];
		// 적절한 입력용 메시지를 출력하고("input ? process names : ")
		System.out.print("input 10 process names: ");

		// for 문을 이용하여 num개 프로세스들의 이름을 입력 받아 processNames[] 배열에 저장
		int endProsessIndex = processNames.length;
		for (int i = 0; i < endProsessIndex; i++) {
			processNames[i] = s.next();
		}

		// num개의 원소를 가지는 정수형 arrivalTimes[] 배열을 생성
		arrivalTimes = new int[num];

		// 적절한 입력용 메시지를 출력하고
		System.out.print("input 10 arrival times: ");

		// for 문을 이용하여 num개 프로세스들의 도착시간을 입력 받아 arrivalTimes[] 배열에 저장
		int endArrivalIndex = arrivalTimes.length;
		for (int i = 0; i < endArrivalIndex; i++) {
			arrivalTimes[i] = s.nextInt();
		}

		// num개의 원소를 가지는 정수형 serviceTimes[] 배열을 생성
		serviceTimes = new int[num];

		// 적절한 입력용 메시지를 출력하고
		System.out.print("input 10 service times: ");

		// for 문을 이용하여 num개 프로세스들의 서비스시간을 입력 받아 serviceTimes[] 배열에 저장
		int endServiceIndex = serviceTimes.length;
		for (int i = 0; i < endServiceIndex; i++) {
			serviceTimes[i] = s.nextInt();
		}

		System.out.println();
		printJobs();
	}

	// 처음부터 다시 스케줄링을 시작하고자 하는 경우 호출
	public void reset() {
		index = 0;
	}

	// 아직 도착하지 않은 프로세스가 더 있는지 조사
	public boolean hasNextProcess() {
		return index < arrivalTimes.length;
	}

	// ###################################################################
	// Process 클래스의 멤버 메소드를 테스트하기 위해 프로세스 정보를 화면에 출력한다.
	public void processTest() {
		reset();
		LinkedList<Process> rq = new LinkedList<>();

		System.out.println("Create processes and print their member data.");
		for (int i = 0; i < processNames.length; ++i) {
			Process p = new Process(processNames[i], arrivalTimes[i], serviceTimes[i]);
			rq.add(p);
			System.out.println(p); // 각 프로세스의 멤버 변수들을 출력한다.
		}

		System.out.println();

		for (Process p : rq) {
			int eTime = p.getServiceTime(); // 이 값이 실행시간이 되도록 할 것이다.
			if (eTime > 3) // 서비스시간이 3보다 큰 경우 실행시간을 반으로 설정하기 위함임
				eTime = (int) (eTime * 0.5 + 0.5); // 실행시간의 반을 반올림
			for (int i = 0; i < eTime; ++i) // 실행시간을 1씩 증가시킨다.
				p.incExecTime();
		}
		System.out.println("Print returned values of member methods of each process.");
		for (Process p : rq) // 각 프로세스의 멤버 메소드의 반환값들을 출력한다.
			p.println(40); // 40은 현재시간을 의미함
	}

	// 매 시간단위마다 호출되며,
	// 각 프로세스의 도착시간과 현재시간 cTime가 동일한 프로세스를 찾아
	// 해당 프로세스 정보를 인자로하여 Process 객체를 생성하여 반환함
	public Process getNewProcess(int cTime) {
		if (index < arrivalTimes.length && // 아직 도착할 프로세스(index)가 남아 있는 경우
				arrivalTimes[index] == cTime) { // 현재시간이 다음 프로세스(index)의 도착시간과 동일한 경우
			int i = index++; // 인덱스 값을 증가시켜 그 다음 프로세스를 가르키게 함
			return new Process(processNames[i], arrivalTimes[i], serviceTimes[i]);
		} // 도착한 프로세스가 있을 경우 위처럼 새 프로세스를 생성하여 반환하고,
		return null; // 현재시간 cTime에 도착한 프로세스가 없을 경우
	}
}

// #############################################
// Process Class
class Process {
	private String name; // 프로세스 이름
	private int arrivalTime; // 프로세스 도착시간
	private int serviceTime; // 프로세스 서비스시간, 실행해야 할 총 시간
	private int executionTime; // 프로세스의 현재까지 실행된 시간

	// 프로세스의 각 필드를 초기화함
	Process(String name, int arrivalTime, int serviceTime) {
//        클래스의 해당 멤버들을 초기화하라.
		this.name = name;
		this.arrivalTime = arrivalTime;
		this.serviceTime = serviceTime;
		this.executionTime = 0;
	}

	// 프로세스의 현재까지 실행된 시간을 증가시킴
	public void incExecTime() {
		int addTime = 1;
		executionTime = executionTime + addTime;
	}

	// 프로세스의 서비스시간을 반환함
	public int getServiceTime() {
		return serviceTime;
	}

	// cTime은 현재시간임. 시스템에 도착한 이후 ready queue에서 현재시간까지 대기한 대기시간을 반환함
	// cTime과 arrivalTime을 이용한 계산
	public int getWaitingTime(int cTime) {
		return cTime - arrivalTime;
	}

	// 앞으로 더 실행해야 하는 남은 실행시간을 반환함
	public int getRemainingTime() {
		return serviceTime - executionTime;
	}

	// 프로세스의 실행이 종료되었는지 체크함: serviceTime과 executionTime의 상관관계
	public boolean isFinished() {
		return (serviceTime == executionTime);
	}

	// cTime은 현재시간임. 프로세스의 응답비율(Response Ratio)를 계산해 반환함
	// 계산시 double로 변환 후 계산해야 함; 위 getWaitingTime(int cTime)을 활용할 것
	public double getResponeRatioTime(int cTime) {
		// 대기시간 + 예상실행 시간
		// -------------------
		// 예상 실행시간
		return ((double) getWaitingTime(cTime) / (double) serviceTime + 1);
	}

	// 프로세스의 이름을 반환함
	public String getName() {
		return name;
	}

	public void println(int cTime) {
		System.out.printf("%s: s(%d) e(%d) r(%d) w(%2d) rr(%5.2f) f(%s)\n", name, getServiceTime(), executionTime,
				getRemainingTime(), getWaitingTime(cTime), getResponeRatioTime(cTime), isFinished());
	}

	public String toString() {
		return String.format("%s: a(%2d) s(%d) e(%d)", name, arrivalTime, serviceTime, executionTime);
	}
}

// 아래 추상 클래스 Scheduler를 Process 클래스 아래(뒤)에 배치하라.
// 이 클래스는 스케줄러가 가져야 하는 메소드들을 가지고 있으며
// 이 클래스를 상속받는 일반 스케줄러 클래스들은 이들 메소드중 일부를 overrride해야 한다.
// Scheduler 클래스는 [스케줄링 문제 4]에서 상세히 다룰 예정이다.
//-----------------------------------------------------------------------------
//스케줄러의 기본 틀: 이 추상클래스를 상속받아 각 스케줄링 알고리즘을 구현해야 함
abstract class Scheduler {
	private String name; // 스케줄러 이름
	protected int currentTime; // 현재시간
	protected int numOfProcess; // 현재 readyQueue에 있는 총 프로세스의 개수
	protected Process currentProcess; // 현재 실행되고 있는 프로세스를 지칭하는 변수
	protected boolean isNewProcessArrived; // 현재시간에 새로운 프로세스가 도착한 경우 true, 아니면 false
	protected LinkedList<Process> readyQueue; // ready 상태의 모든 프로세스들을 모아 놓은 ready queue
	private Jobs jobs; // 앞으로 도착할 프세세스들의 정보를 가지고 있음

	protected Scheduler(String name) { // 스케줄러의 각 필드를 초기화함
		this.name = name;
		currentTime = -1;
		numOfProcess = 0;
		currentProcess = null;
		isNewProcessArrived = false;
		readyQueue = new LinkedList<Process>();
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
		jobs.reset(); // 처음부터 다시 스케줄링하기 위해 프로세스 정보도 처음부터 시작하도록 설정
	}

	// 현재 시간이 1씩 증가할 때마다 새로 스케줄링 해야할지 말지를 결정하는 함수
	// 모든 스케줄링 알고리즘에서 공통으로 적용됨: 스케줄링 시점을 결정하는 함수
	// 각 스케줄링 알고리즘별로 필요한 경우 이 함수를 재정의하여야 함(오버라이딩)
	public boolean isSchedulable() {
		return ((currentProcess == null) && isNewProcessArrived) || // 현재 실행 프로세스가 없는 상태에서 새로운 프로세스가 도착했을 때
				((currentProcess != null) && currentProcess.isFinished()); // 현재 실행 중인 프로세스가 실행을 종료했을 때
	}

	// 재정의 함수에서 super클래스의 이 함수를 제일 먼저 호출해야 한며, 그런 후
	// 각 스케줄링 알고리즘별로 이 함수를 재정의해야 함(오버라이딩).
	// 각 스케줄링 알고리즘별로 다음에 실행할 우선순위가 가장 높은 프로세스를 선택해야 함
	public void schedule() {
		// 현재 실행중인 프로세스의 실행이 완료된 경우
		if ((currentProcess != null) && currentProcess.isFinished()) {
			readyQueue.remove(currentProcess); // 현재 프로세스(currentProcess)를 ready queue에서 제거함
			--numOfProcess; // 총 프로세스의 개수를 감소
			currentProcess = null;
		}
		// 이 메소드에선 실행이 종료된 프로세스를 위처럼 큐에서 제거하는 역할만하고 실제 스케줄링은 하지 않음
		// 이 함수에서 리턴된 후 각 스케줄링 알고리즘별로 재정의된 메소드에서
		// 우선순위가 가장 높은 프로세스를 선택해야 함.
		// FCFS클래스의 schedule() 함수 참조.
	}

	public boolean hasMoreProcessesToExecute() { // 모든 프로세스들의 실행이 종료되었는지 체크
		// 새로 도착할 프로세스가 아직 남아 있거나 또는 레디 큐에 프로세스가 있는 경우 (true 반환)
		// 새로 도착할 프로세스가 더 이상 없고 레디 큐에도 프로세스가 없으면 종료해도 됨 (false 반환)
		return (jobs.hasNextProcess() || (numOfProcess != 0));
	}

	public String getName() {
		return name;
	} // 스케줄러 이름 반환

	public int getCurrentTime() {
		return 0;
	}

	// 매 시간 단위마다 호출되는 함수. ComputerSystem::run()에서 100ms마다 한번씩 호출됨
	// 매 시간단위마다 clock interrupt가 들어와 실행된다고 생각하면 됨
	// 각 스케줄링 알고리즘별로 이 함수를 재정의하되,
	// 각 스케줄링 알고리즘의 재정의 함수에서 super클래스의 이 함수를 제일 먼저 호출해야 함
	// 1초동안 프로세스 이름 출력
	public void clockInterrupt() {
		currentTime++; // 현재시간을 1 증가함
		if (currentProcess != null) { // 현재 실행되고 있는 프로세스가 있다면
			currentProcess.incExecTime(); // 현재 실행되는 프로세스의 실행시간을 1 증가함
			System.out.print(currentProcess.getName()); // 1 시간단위만큼 실행된 프로세스의 이름을 출력함
		} else
			System.out.print(" "); // 현재 실행되는 프로세스가 없을 경우 출력

		// 새로 도착한 프로세스가 있을 경우 ready queue의 맨 끝에 추가
		// getNewProcess()는 현재시간 currentTime과 도착시간이 동일한 프로세스를 찾고
		// 해당 프로세스 정보를 기반으로 Process 객체를 생성하여 반환해 줌;
		// 이 시간에 도착한 프로세스가 없을 경우 null 반환함
		for (Process p; (p = jobs.getNewProcess(currentTime)) != null;) {
			isNewProcessArrived = true; // p는 새로 도착한 프로세스 객체
			++numOfProcess; // 총 프로세스의 개수를 증가
			readyQueue.add(p); // ready 큐의 맨 끝에 프로세스 p 삽입
		}
	}
}

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
class FCFS extends Scheduler {
	FCFS(String name) {
		super(name);
	} // 스케줄러 이름

	@Override
	public void schedule() {
		super.schedule();
		// 다음에 실행할 프로세스 선택
		// 큐의 헤드에 있는 원소를 반환 (삭제하지는 않음) , or 없으면 null 리턴
		currentProcess = readyQueue.peek();
		// 실제 시스템에서는 여기서 currentProcess에게 CPU를 넘김.
	}
}

//    1) 추상 클래스 Scheduler를 상속받아야 한다. (FCFS 클래스 참조)
class SPN extends Scheduler {
	// 2) 생성자 메소드를 정의하라. (FCFS 클래스 참조)
	protected SPN(String name) {
		super(name);
	}

	@Override
//    3) Scheduler 클래스의 schedule() 메소드를 재정의하라. (FCFS 클래스 참조)
	public void schedule() {
//          먼저 슈퍼 클래스의 schedule()를 먼저 호출
		super.schedule();

//          for문을 이용하여 readyQueue에 있는 프로세스들 중 서비스 시간이
//               가장 작은 프로세스를 찾는다.
		int min = 999;
		int indexShortProcess = 0;
		for (int i = 0; i < readyQueue.size(); i++) {
			int timeProcessAtNow = readyQueue.get(i).getServiceTime();
			if (min > timeProcessAtNow) {
				min = timeProcessAtNow;
				indexShortProcess = i;
			}
		}
//          찾은 프로세스를 currentProcess에 설정한다.
		if (!readyQueue.isEmpty()) {
			super.currentProcess = readyQueue.get(indexShortProcess);
		}
	}

}

// 아래 ComputerSystem 클래스를 Main 클래스 위(앞)에 배치하라.
// 이 클래스의 run() 메소드는 먼저 printEpilog() 메소드를 호출하여 화면에 시간 테이블을 출력하고
// 스케줄러를 작동시킨다. [스케줄링 문제 4]에서 run() 메소드의 기능을 상세히 설명한다.
// 현재는 스케줄러가 정상 작동하지 않는다.
//
// 아래 printEpilog(Scheduler scheduler) 메소드를 완성하라.
//-----------------------------------------------------------------------------
class ComputerSystem {
	public Jobs jobs;

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public ComputerSystem(Jobs jobs) {
		setJobs(jobs);
	}

	// 문제 3:
	public void printEpilog(Scheduler scheduler) {
		/*
		 * 화면에 다음과 같이 시간 테이블을 출력함 Scheduling Algorithm: 알고리즘이름 0 1 2 3 4 5 // 시간 십단위
		 * 0123456789012345678901234567890123456789012345678901234 // 시간 일단위
		 */

//        위 내용을 화면에 출력하라.
		System.out.println("Scheduling Algorithm: " + scheduler.getName());
		System.out.println("0         1         2         3         4         5    ");
		System.out.println("0123456789012345678901234567890123456789012345678901234");
		System.out.println();
	}

	// 아래 메소드는 ComputerSystem 클래스의 run() 메소드이다. (메인에서 호출)
	// 아래 코드는 매 시간단위(100ms)마다 한번씩 수행되면 이때마다
	// scheduler.clockInterrupt()을 호출하여 스케줄러의 현재시간(currentTime)을 1씩 증가시킨다.
	// 현 시점에서 scheduler.isSchedulable()를 호출하여 스케줄링할 시점인지 판단한다.
	// 예) 현재 실행중인 프로세스가 종료했거나, SRT 스케줄링 알고리즘에선 새로운 프로세스가 도착했을 경우,
	// RR인 경우 현재 프로세스가 time slice를 모두 다 사용했을 경우 등등
	// 그런 후 scheduler.schedule() 호출하여 스케줄링하여 우선순위가 가장 높은 프로세스를 선택한다.
	// -----------------------------------------------------------------------------
	public void run(Scheduler scheduler) { // 각 스케줄링 알고리즘을 테스트 함

		printEpilog(scheduler); // 화면에 단위시간 눈금자를 출력함
		scheduler.setJobs(jobs);

		while (scheduler.hasMoreProcessesToExecute()) { // 아직 더 실행해야 할 프로세스가 있는지 체크

			scheduler.clockInterrupt(); // 매 시간단위마다 스케줄러의 clock interrupt handler를 호출함

			if (scheduler.isSchedulable()) // 새로 스케줄링 해야하는 시점인지 체크
				scheduler.schedule(); // 새로 스케줄링 함

			try { // 우리 스케줄러에서 사용할 시간단위는 100ms: 빠르게 실행하려면 이 값을 10 또는 1로 줄여도 됨
					// 100ms마다 한번씩 위 scheduler.clockInterrupt()와 schedule()가 한번씩 호출됨
				Thread.sleep(100); // 100 millisecond 동안 정지했다가 리턴함
			} catch (InterruptedException e) { // sleep()하는 동안 다른 스레드에 의해 인터럽이 들어 온 경우, 여기서는 전혀 발생하지 않음
				e.printStackTrace(); // InterruptedException이 발생했을 경우 지금껏 호출된 함수 리스트를 출력해 볼 수 있음
				return;
			}
		}
		System.out.println("\n");
	}
}

// 먼저 main() 메소드를 아래 코드로 변경하라.
// 아래 코드는 프로그램 시작하자마자 무조건 jobs와 cs 객체를 먼저 생성한다.
// jobs 객체를 생성할 때 기존과는 다르게 인자가 없는 디폴트 생성자를 호출한다.
public class Main {
	public static void main(String[] args) {
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
			case 1:
				jobs = new Jobs(scan);
				cs.setJobs(jobs);
				break;
			case 2:
				jobs.processTest();
				break;
			// FCFS 객체를 생성한 후 이를 인자로 사용하여 cs.run()를 호출한다.
			// cs.run()에서 FCFS 스케줄러를 작동시킴; "FCFS"는 스케줄러 이름이다.
			case 3:
				cs.run(new FCFS("FCFS"));
				break;
			case 4:
				cs.run(new SPN("SPN"));
				break;
			default:
				System.out.println("WRONG menu item\n");
				break;
			}
			System.out.println();
		}
		System.out.println("Good bye.");
		scan.close();
	}
}