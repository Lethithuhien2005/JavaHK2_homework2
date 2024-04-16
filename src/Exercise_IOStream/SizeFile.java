package Exercise_IOStream;

import java.io.File;

public class SizeFile {
	public static void main(String[] args) {
		File f = new File("D:\\Users/DIEN MAY XANH/eclipse-workspace");
		if (f.exists()) {
			double size = f.length();
			System.out.println("the size of this file: " + size + " bytes");
		} else System.out.println("This file is not exist");
	}
}
