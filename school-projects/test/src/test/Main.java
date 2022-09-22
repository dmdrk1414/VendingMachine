package test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int i = 0;
		try {
			i = scanner.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
