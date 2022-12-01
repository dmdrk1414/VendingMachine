package IOstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EX_8_9 {
	public static void main(String[] args) {
		File src = new File("test2.txt");
		File dest = new File("test123123dsfs.txt");

		int c;
		try {
			FileReader fr = new FileReader(src);
			FileWriter fw = new FileWriter(dest);
			while ((c = fr.read()) != -1) {
				fw.write((char) c);
			}
			fr.close();
			fw.close();
			System.out.println("복사 완료");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
