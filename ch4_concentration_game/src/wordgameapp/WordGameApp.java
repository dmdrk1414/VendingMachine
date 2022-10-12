package wordgameapp;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Player;
import model.UI;

public class WordGameApp {
//	run() : 게임을 전체적으로 진행하는 run 메소드, 선수 숫자 만큼의 Player 객체를 배열로 생성한다. 
	public void run() {
		System.out.print("게임에 참가하는 인원은 몇명입니까? ");
		int inputNumUser = this.getInt();
		Player[] players = new Player[inputNumUser];

		Scanner sc = new Scanner(System.in);
		String namePlayer = "";
		for (int i = 0; i < players.length; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			namePlayer = sc.next();
			players[i] = new Player(namePlayer);
		}

		System.out.println("시작하는 단어는 아버지입니다.");
		String preWord = "아버지";
		String afterWord = "";

		int indexPlayers = 0;
		int indexPlayersAround = 0;
		int plusIndexNextPlayer = 1;
		while (true) {
			indexPlayersAround = indexPlayers % players.length;
			Player playerAtNow = players[indexPlayersAround];
			System.out.print(playerAtNow.getName() + ">>");
			afterWord = playerAtNow.getWordFromUser();

			if (playerAtNow.checkSuccess(preWord, afterWord)) {
				preWord = afterWord;
				indexPlayers = indexPlayers + plusIndexNextPlayer;
				continue;
			} else {
				System.out.println(playerAtNow.getName() + "이 졌습니다.");
				sc.close();
				System.exit(0);
			}
		}
	}

	private int getInt() {
		Scanner sc = new Scanner(System.in);
		int inputInt = 0;
		while (true) {
			try {
				inputInt = sc.nextInt();
				if (this.isPositive(inputInt)) {
					return inputInt;
				} else {
					sc.nextLine();
					UI.ErrNotPositiveInt();
					continue;
				}
			} catch (InputMismatchException e) {
				sc.nextLine();
				UI.ErrNotRightInput();
				continue;
			}
		}
	}

	private boolean isPositive(int inputInt) {
		if (inputInt > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		WordGameApp app = new WordGameApp();
		app.run();
	}
}
