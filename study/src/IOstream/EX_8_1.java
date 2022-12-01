package IOstream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EX_8_1 {
	public static void main(String[] args) {
		FileReader fin = null;
		try {
			fin = new FileReader("test2.txt");
			int c;
			while ((c = fin.read()) != -1) {
				System.out.println((char) c);
			}
			fin.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
