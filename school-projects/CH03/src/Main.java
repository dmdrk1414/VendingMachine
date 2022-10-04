import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	// TODO: 1번
	public static void printArray(double arr[][]) {
		int len = arr.length;
		System.out.println("arr length: " + len);
		for (int index = 0; index < arr.length; index++) {
			System.out.print("arr[" + index + "]");
			for (int i = 0; i < arr[index].length; i++) {
				System.out.print(" " + arr[index][i]);
			}
			System.out.println("");
		}
	}

	// TODO: 2번
	public static double[][] run1(Scanner s) {
		System.out.print("The number of rows of non-square array of doubles to create? ");
		int input = s.nextInt();
		double[][] dArr = new double[input][];

		for (int first = 0; first < input; first++) {
			dArr[first] = new double[first + 1];
			System.out
					.print("Input continuously " + (first + 1) + " doubles to be stored in line " + (first + 1) + ": ");

			for (int second = 0; second < first + 1; second++) {
				dArr[first][second] = s.nextDouble();
			}
		}

		return dArr;
	}

	// TODO: 3, 4번
	public static double[][] run2(Scanner s) {
		// TODO: 4번 반복문 속 예외처리.
		while (true) {
			System.out.print("The number of rows of non-square array of doubles to create? ");
			int input = 0;

//			TODO: 3번 예외 처리
			try {
				input = s.nextInt();
				double[][] dArr = new double[input][];

				for (int first = 0; first < input; first++) {
					dArr[first] = new double[first + 1];
					System.out.print("Input continuously " + (first + 1) + " doubles to be stored in line "
							+ (first + 1) + ": ");

					for (int second = 0; second < first + 1; second++) {
						dArr[first][second] = s.nextDouble();
					}
				}

				return dArr;
			} catch (NegativeArraySizeException e) {
				System.out.println("Input an INTEGER. Try again.");
				s.nextLine();
				continue;
			} catch (InputMismatchException e) {
				System.out.println("Input an INTEGER. Try again.");
				s.nextLine();
				continue;
			}
		}
	}

	// TODO: 5번
	public static void run3(Scanner s) {
		final int USER = 0; // 상수 값 정의
		final int COMPUTER = 1;
		// 0, 1, 2 중 하나의 난수를 미리 발생하여 저장해 놓은 난수 배열
		// 이 배열에 저장된 값은 나중에 MJBarray[] 배열의 인덱스 값으로 사용됨
		int randArray[] = { 2, 1, 2, 2, 2, 1, 1, 0, 0, 2, 0, 2, 0, 2, 0, 1, 1, 2, 0, 0, 2, 0, 2, 2, 1, 2, 0, 0, 1, 2, };
		String MJBarray[] = { "m", "j", "b" }; // 묵(m)찌(j)빠(b) 문자열을 가진 배열

		System.out.println("Start the MUK-JJI-BBA game.");
		System.out.print("Select any index for random number[0~29]? ");
		int randIdx = s.nextInt();
		s.nextLine(); // 입력 버퍼에 있는 '\n' 제거

		int priority = USER; // 누가 우선권을 가졌는지 저장하고 있음, USER:사용자 우선권, COMPUTER:computer 우선권
		String priStr[] = { "USER", "COMPUTER" }; // 화면에 출력할 때 사용함

		while (true) {
			System.out.println();
//             화면에 (priStr[priority] + " has the higher priotiy.")를 출력
			System.out.println(priStr[priority] + " has the higher priotiy.");

//             화면에 "m(muk), j(jji), b(bba) or stop? " 출력
			System.out.print("m(muk), j(jji), b(bba) or stop? ");
//             사용자가 입력한 묵찌빠 문자열을 입력 받아 String user 변수에 저장
			String user = s.next();
//             "stop"을 입력했으면 게임 종료 
//                 // 사용자가 입력한 문자열을 비교할 때는 if (user.equals("stop")) 문장을 사용 

			if (user.equals("stop")) {
				// TODO: 여기를 확인하기.
				break;
			}

//             사용자가 m, j, b를 입력하지 않고 다른 문자열을 입력했다면 
//                 아래 실행결과를 참고하여 적절한 에러 메시지를 출력하고 while()의 처음부터 다시 시작
			if (!Arrays.asList(MJBarray).contains(user)) {
				System.out.println("Select one among m, j, b.");
				continue;
			}

			// 난수가 있는 randArray의 원소값 comIdx에 할당하기.
			int comIdx = randArray[randIdx];

//             컴퓨터가 사용하는 난수 배열 인덱스 값 randIdx를 1 증가시킨 후 29보다 큰 경우 다시 0부터 시작 
			if (++randIdx > 29) {
				randIdx = 0;
			}

//             MJBarray[comIdx](컴퓨터가 낸 묵찌빠 문자열)을 String computer 변수에 저장
			String computer = MJBarray[comIdx];

//             user와 computer 변수를 이용하여 화면에 사용자, 컴퓨터가 낸 묵찌빠 값을 출력 
//                 (예:User = m, Computer = b, )
			System.out.print("User = " + user + ", Computer = " + MJBarray[comIdx] + ", ");

//             이후 user와 computer 문자열을 비교하여 같으면 
//                 // user와 computer 두 문자열 비교하는 방법: if (user.equals(computer)) 
//                 우선권을 가진 자가 이겼다고 출력하고
			// 비겼을때
			if (user.equals(computer)) {
				if (priority == USER)
					System.out.println("USER WINs.");
				else {
					System.out.println("COMPUTER WINs.");
				}
			}

//             같지 않으면(비겼으면) 
//                 비겼다고 출력
//                 현 상황이 (가위바위보)라 가정하고 누가 이겼는지 판단하여 우선권을 가지게 함 
//                 (아주 긴 조건문이 될 것임)
//                 priority 값을 이긴 자(USER 또는 COMPUTER)로 변경함
			// 다를때.
			else {
				System.out.println("SAME.");
				String Strcomputer = MJBarray[comIdx];
				if (user.equals("m")) {
					if (Strcomputer.equals("j"))
						priority = USER;
					else if (Strcomputer.equals("b"))
						priority = COMPUTER;
				} else if (user.equals("j")) {
					if (Strcomputer.equals("m"))
						priority = COMPUTER;
					else if (Strcomputer.equals("b"))
						priority = USER;
				} else if (user.equals("b")) {
					if (Strcomputer.equals("m"))
						priority = USER;
					else if (Strcomputer.equals("j"))
						priority = COMPUTER;
				}

			}
		}
	}

	public static void main(String[] args) {
		// TODO: 1번
        double array[][] = { {0}, {1,2}, {3,4,5} };
        printArray(array);
        System.out.println();
        System.out.println("Exit.");

		System.out.println(); // 이상은 기존과 동일

		// TODO: 2번
//        scanner 변수 생성 및 초기화; // 필요한 파일 import시킬 것
//		S scanner = new Scanner(System.in);
//=======
		Scanner scanner = new Scanner(System.in);
//>>>>>>> test
        double dArr1[][] = run1(scanner);
        printArray(dArr1);
        System.out.println();
        
        scanner.

		// TODO: 3번
//		double dArr1[][] = run1(scanner);
//		printArray(dArr1);
//		System.out.println();

//		// TODO: 4번
		double dArr2[][] = run2(scanner);
		printArray(dArr2);
		System.out.println();

		// TODO: 5번
		run3(scanner);
		System.out.println();

//        scanner 닫기;
		scanner.close();
		System.out.println("Done."); // 기존과 동일
	}
}