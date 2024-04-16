package Exercise_IOStream;

import java.io.File;

public class FileExample {
	public static int countFile(String path) {
		int count = 0;
		File file = new File(path);
		String[] names = file.list();
		for (int i=0; i<names.length; i++) {
			File f = new File(path + "\\" + names[i]);
			if (f.isDirectory()) count+=countFile(f.getAbsolutePath());
			else count++;
		}
		return count;
	}
	public static void sizeFolder (String path) {
		File fi = new File(path);
		if (fi.exists()) {
			double size = fi.length();
			System.out.println("The size of this folder: " + size);
		}
		else System.out.println("This folder is not exist");
	}
	public static void main(String[] args) {
		sizeFolder("D:\\Users/DIEN MAY XANH/eclipse-workspace/DACK/src/View");
		System.out.println("The number of files in this folder: " + countFile("D:\\Users/DIEN MAY XANH/eclipse-workspace/DACK/src/View"));
	}
}
