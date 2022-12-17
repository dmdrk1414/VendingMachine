package problem_8;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// 명품 자바 실습문제_14
public class problem_14 {
	public static void main(String[] args) throws IOException {
		String str = "C:\\Users\\seung\\Desktop";
		File file = new File(str);
		Scanner sc = new Scanner(System.in);

		while (true) {
			printDir(file.listFiles());
			System.out.print("원하는 명령어 입력>> ");
			String[] arr = sc.nextLine().split(" ");
			String first = arr[0];
			if (first.equals("그만")) {
				break;
			}

			// 폴더 생성
			if (first.equals("mkdir")) {
				mkdir(str, arr);
			}

			// 폴더 제거
			if (first.equals("remove")) {
				remove(str, arr);
			}

			// 이름 변경
			if (first.equals("rename")) {
				if (arr.length != 3) {
					System.out.println("변경을 원하는 이름을 적어주세요 ex) rename \"현재파일이름\" \"변경원하는파일이름\"");
					continue;
				}
				rename(str, arr);
			}
		}

		sc.close();
	}

	private static void rename(String str, String[] arr) {
		String name = arr[1];

		String nameChange = arr[2];
		File fileName = new File(str + "\\" + name);
		File fileChange = new File(str + "\\" + nameChange);
		if (fileName.exists()) {
			if (fileName.renameTo(fileChange)) {
				System.out.println(fileName.getName() + "이 " + fileChange.getName() + "으로 변경완료");
			}
		} else {
			System.out.println(fileName.getName() + "이 존재하지 않다.");
		}
	}

	private static void remove(String str, String[] arr) {
		String nameRemove = arr[1];
		File fileRemove = new File(str + "\\" + nameRemove);
		if (fileRemove.exists()) {
			if (fileRemove.delete()) {
				System.out.println(fileRemove.getName() + " 삭제완료");
			}
		} else {
			System.out.println(fileRemove.getName() + " 존제하지 않음");
		}
	}

	private static void mkdir(String str, String[] arr) {
		String name = arr[1];

		File mkdirFile = new File(str + "\\" + name);
		if (!mkdirFile.exists()) {
			if (mkdirFile.mkdir()) {
				System.out.println(mkdirFile.getName() + " 생성완료");
			}
		} else {
			System.out.println(mkdirFile.getName() + "은 존제합니다.");
		}
	}

	static void printDir(File[] files) {
		System.out.println("------- 폴더안 출력 -------");
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		System.out.println();
	}
}
