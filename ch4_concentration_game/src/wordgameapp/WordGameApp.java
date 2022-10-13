package wordgameapp;

import java.util.Scanner;

import model.Player;
import model.UI;

public class WordGameApp {
//	run() : 게임을 전체적으로 진행하는 run 메소드, 선수 숫자 만큼의 Player 객체를 배열로 생성한다. 
	public void run() {
		Scanner sc = new Scanner(System.in);
		System.out.print("게임에 참가하는 인원은 몇명입니까? ");
		int inputNumUser = UI.getInt(sc);
//		Player[] players = new Player[inputNumUser];
		Player[] players = getInstenceArrPlayesrs(sc, inputNumUser);

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
			afterWord = playerAtNow.getWordFromUser(sc);

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

	private Player[] getInstenceArrPlayesrs(Scanner sc, int inputNumUser) {
		Player[] players = new Player[inputNumUser];

		String namePlayer = "";
		int plusNextPlayerIndex = 1;
		for (int indexPlayer = 0; indexPlayer < players.length; indexPlayer += plusNextPlayerIndex) {
			System.out.print("참가자의 이름을 입력하세요>>");
			namePlayer = sc.next();
			players[indexPlayer] = new Player(namePlayer);
		}
		return players;
	}
}
