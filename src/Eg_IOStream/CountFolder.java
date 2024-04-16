package Eg_IOStream;

import java.io.File;

public class CountFolder {
	public static int count(String path) {
		int c = 0;
		File f = new File(path);
		String[] filenames = f.list();
		for (int i=0; i<filenames.length; i++) {
			File fi = new File(path + "\\" + filenames[i]);
			if (fi.isFile()) c++;
			else
				c+=count(fi.getAbsolutePath());
		}
		return c;
	}
	public static void main(String[] args) {
		System.out.println(count("D:\\Users"));
	}
} 
