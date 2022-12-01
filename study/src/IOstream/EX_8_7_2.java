package IOstream;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class EX_8_7_2 {
	public static void main(String[] args) {
		String url = "test2.txt";

		FileReader fin = null;
		int c;

		try {
			fin = new FileReader(url);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out), 5);
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
