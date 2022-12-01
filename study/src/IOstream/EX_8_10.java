package IOstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EX_8_10 {
	public static void main(String[] args) {
		File src = new File("test2.txt");

		File dest = new File("test0.txt");

		int c;

		try {

			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);

			while ((c = fi.read()) != -1) {
				fo.write((byte) c);
			}
			fi.close();
			fo.close();
			System.out.println("복사");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}