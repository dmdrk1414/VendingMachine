package model;

import java.util.Scanner;

public class Player {
//	게임 참가자의 이름 필드와
	String name;

	public Player() {

	}

	public Player(String name) {
		this.name = name;
	}

//	1.  getWordFromUser() :  사용자로부터 단어를 입력받는
	public String getWordFromUser() {
		Scanner sc = new Scanner(System.in);
		String strInput2User = "";
		while (true) {
			strInput2User = sc.next();
			if (this.strCheck(strInput2User)) {
				sc.close();
				return strInput2User;
			} else {
				continue;
			}
		}
	}

//	2.  checkSuccess() : 끝말잇기의 성공여부와 게임을 계속하는지를 판별하는 메서드
	public boolean checkSuccess(String preWord, String afterWord) {
		int preWordLastIndex = preWord.length() - 1;
		char preWordLastChar = preWord.charAt(preWordLastIndex);
		char afterWordFirstChar = afterWord.charAt(0);

		if (this.equalTwoChar(preWordLastChar, afterWordFirstChar)) {
			return true;
		} else {
			return false;
		}

	}

	private boolean equalTwoChar(char preWordLastChar, char afterWordFirstChar) {
		String parseStrPreWordLastChar = String.valueOf(preWordLastChar);
		String parseStrAfterWordLastChar = String.valueOf(afterWordFirstChar);
		if (parseStrPreWordLastChar.equals(parseStrAfterWordLastChar)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean strCheck(String inputStr) {
		try {
			double d = Double.parseDouble(inputStr);
			UI.ErrNotStr();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static void main(String[] args) {
		Player player = new Player();
		System.out.println(player.equalTwoChar('지', '가'));
	}
}
