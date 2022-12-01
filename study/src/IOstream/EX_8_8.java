package IOstream;

import java.io.File;

public class EX_8_8 {
	public static void main(String[] args) {
		File f = new File("test2.txt");
		System.out.println(f.length());
		System.out.println(f.getPath());
		System.out.println(f.getName());
		System.out.println(f.isFile());
		System.out.println(f.lastModified());
	}
}
