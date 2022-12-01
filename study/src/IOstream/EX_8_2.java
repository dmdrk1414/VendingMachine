package IOstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class EX_8_2 {
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;

		try {
			fin = new FileInputStream("test.txt");
			in = new InputStreamReader(fin, "UTF-8");
			int c;

			System.out.println(in.getEncoding());
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			in.close();
			fin.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
