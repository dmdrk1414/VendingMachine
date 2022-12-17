package problem_8;

import java.io.File;

// 명품 자바 실습문제_9
public class problem_9 {
	public static void main(String[] args) {
		File file = new File("study");
		File[] subFile = file.listFiles();

		System.out.println(file + "폴더의 .txt파일을 모두삭제합니다.");

		String suchFile = "";
		File fileAtNow;
		int cnt = 0;
		for (int i = 0; i < subFile.length; i++) {
			fileAtNow = subFile[i];
			suchFile = fileAtNow.getName();
			int index = suchFile.lastIndexOf(".txt");
			if (index != -1) {
				if (fileAtNow.delete()) {
					System.out.println(suchFile + " 삭제");
					cnt++;
				}
			}
		}
		System.out.println("총" + cnt + "개의 .txt 파일을 삭제하였습니다.");
	}
}
