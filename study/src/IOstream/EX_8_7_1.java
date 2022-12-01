package IOstream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EX_8_7_1 {
	public static void main(String[] args) {
		String url = "test2.txt";

		FileReader fin = null;
		int c;

		try {
			fin = new FileReader(url);
			BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
			while ((c = fin.read()) != -1) {
				out.write(c);
			}

			new Scanner(System.in).nextLine();
			out.flush();
			fin.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
