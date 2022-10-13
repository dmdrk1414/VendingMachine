package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
//	게임 참가자의 이름 필드와
	private String name;

	public Player() {
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 1. getWordFromUser() : 사용자로부터 단어를 입력받는
	public String getWordFromUser(Scanner sc) {
		String strInput2User = "";
		while (true) {
			try {
				strInput2User = sc.next();
				if (this.strCheck(strInput2User)) {
					return strInput2User;
				} else {
					continue;
				}
			} catch (InputMismatchException e) {
				UI.ErrNotRightInput();
			}
		}
	}

//	2.  checkSuccess() : 끝말잇기의 성공여부와 게임을 계속하는지를 판별하는 메서드
	public boolean checkSuccess(String preWord, String afterWord) {
		int preWordLastIndex = preWord.length() - 1;
		char preWordLastChar = preWord.charAt(preWordLastIndex);
		char afterWordFirstChar = afterWord.charAt(0);

		if (UI.equalTwoChar(preWordLastChar, afterWordFirstChar)) {
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
}
