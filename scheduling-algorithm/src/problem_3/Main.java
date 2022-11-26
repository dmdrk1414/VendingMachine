package problem_3;

import java.util.LinkedList;
import java.util.Scanner;

// TODO: 문제 4번 변경
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

// TODO: 문제 4번 변경
// 아래 추상 클래스 Scheduler를 Process 클래스 아래(뒤)에 배치하라.
// 이 클래스는 스케줄러가 가져야 하는 메소드들을 가지고 있으며
// 이 클래스를 상속받는 일반 스케줄러 클래스들은 이들 메소드중 일부를 overrride해야 한다.
// Scheduler 클래스는 [스케줄링 문제 4]에서 상세히 다룰 예정이다.
//-----------------------------------------------------------------------------
//스케줄러의 기본 틀: 이 추상클래스를 상속받아 각 스케줄링 알고리즘을 구현해야 함
abstract class Scheduler {
	private String name; // 스케줄러 이름
	protected Process currentProcess; // 현재 실행되고 있는 프로세스의 레퍼런스 변수
	protected LinkedList<Process> readyQueue; // ready 상태의 모든 프로세스들을 모아 놓은 ready queue

	protected Scheduler(String name) {
		this.name = name;
	}

	public void setJobs(Jobs jobs) {
	}

	public boolean isSchedulable() {
		return false;
	}

	public void schedule() {
	}

	public boolean hasMoreProcessesToExecute() {
		return false;
	}

	public String getName() {
		return name;
	} // 스케줄러 이름 반환

	public int getCurrentTime() {
		return 0;
	}

	public void clockInterrupt() {
	}
}

// TODO: 문제 4번 변경
// 아래 FCFS 클래스를 Scheduler 클래스 아래(뒤)에 배치하라.
// FCFS 클래스는 추상 클래스 Scheduler를 상속받아 FCFS 스케줄러를 구현한 완성본이다.
// 하지만 추상 클래스가 완벽히 구현되지 않았기 때문에 정상적으로 작동하지는 않는다.
// 이 클래스는 [스케줄링 문제 4]에서 Scheduler 클래스가 완벽히 구현되고 나면 정상적으로 작동할 것이다.
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

// TODO: 문제 4번 변경
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

	public void run(Scheduler scheduler) { // 스케줄링 알고리즘을 테스트 함

		printEpilog(scheduler); // 화면에 단위시간 눈금자를 출력함
		scheduler.setJobs(jobs);

		while (scheduler.hasMoreProcessesToExecute()) { // 아직 더 실행해야 할 프로세스가 있는지 체크

			scheduler.clockInterrupt(); // 매 시간단위마다 스케줄러의 clock interrupt handler를 호출함

			if (scheduler.isSchedulable()) // 새로 스케줄링 해야하는 시점인지 체크
				scheduler.schedule(); // 새로 스케줄링 함

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