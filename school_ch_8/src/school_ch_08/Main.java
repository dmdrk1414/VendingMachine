package school_ch_08;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

class Menu {
	Scanner sc;
	private static final String[] voca = { "amazing,amaze, surprising, wonderful", "chat,chatter, pratter",
			"minimal,min, very small in quantity, value, or degree", "supermarket,mart, a large shop.",
			"wellbeing,happyiness, health and happiness" };
	LinkedHashMap<String, String> vocaBook;

	Menu(Scanner sc) {
		addHashMapKeyValue();
		this.sc = sc;
	}

	private void addHashMapKeyValue() {
		vocaBook = new LinkedHashMap<>();
		int endVocaIndex = Menu.voca.length;
		for (int first = 0; first < endVocaIndex; first++) {
			String vocaLine = Menu.voca[first];
			int indexFirstDot = vocaLine.indexOf(",");

			String key = vocaLine.substring(0, indexFirstDot);
			String value = vocaLine.substring(indexFirstDot + 1, vocaLine.length());
			vocaBook.put(key, value);
		}
	}

	public void menuPrint() { // show menu
		System.out.println("========= Vocabulary Menu =========");
		System.out.println(" 1. Print Vocabulary");
		System.out.println(" 2. Search a word");
		System.out.println(" 3. Add a new word");
		System.out.println(" 4. Delete a word");
		System.out.println(" 0. Exit");
		System.out.println("===================================");
	}

	public void printVocabulary() {
		System.out.println("=================== Vocabulary ===================");
		for (Map.Entry<String, String> entrySet : vocaBook.entrySet()) {
			System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
		}

		System.out.println("==================================================");
		System.out.println();
	}

	public void searchWord() {
		System.out.print("Enter a word to search : ");
		String searchWord = sc.next();
		boolean isSearch = false;

		for (Map.Entry<String, String> entrySet : vocaBook.entrySet()) {
			if (searchWord.equals(entrySet.getKey())) {
				isSearch = true;

			}
		}
		if (isSearch) {
			System.out.print(searchWord + " : ");
			System.out.println(vocaBook.get(searchWord));
		} else {
			System.out.println("Your entered word does not exist.");
		}

		sc.hasNextLine();
		System.out.println();
	}

	public void addWordMap() {
		System.out.print("Enter a word to append : ");
		String key = sc.next();
		System.out.print("Meaning : ");
		sc.nextLine();
		String value = sc.nextLine();

		vocaBook.put(key, value);
		System.out.println("Word is appended successfully.");
	}

	public void removeValue() {
		System.out.print("Enter a word to remove : ");
		String key = sc.next();
		sc.nextLine();
		vocaBook.remove(key);
		System.out.println("The word is removed successfully.");
	}

	public void run() {
		System.out.println("Vocabulary is loaded. (Total words : " + vocaBook.size() + ")");
		while (true) {
			System.out.println();

			menuPrint();
			System.out.print(" ==>> ");
			int numSelecMenu = sc.nextInt();
			switch (numSelecMenu) {
			case 0:
				System.out.println("Good bye.");
				return;
			case 1:
				printVocabulary();
				break;
			case 2:
				searchWord();
				break;
			case 3:
				addWordMap();
				break;
			case 4:
				removeValue();
				break;
			}
		}
	}
}

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu(sc);
		menu.run();

	}
}
