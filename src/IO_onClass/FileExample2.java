package IO_onClass;

import java.io.*;

public class FileExample2 {

	public static int countFile(String path) {
		int count = 0;
		File f = new File(path);
		String[] names = f.list();
		for (int i = 0; i < names.length; i++) {
			File fi = new File(path + "\\" + names[i]);
			if (fi.isDirectory())
				count += countFile(fi.getAbsolutePath());
			else
				count++;
		}
		return count;
	}
	public static long sizeFolder(String path) {
		long size = 0;
		File f = new File(path);
		if (f.exists()) {
			size = f.length();
		} else {
			System.out.println("This folder is not exist!");
		}
		return size;
	}
	public static void main(String[] args) {
		String path = "D:\\Users/DIEN MAY XANH/eclipse-workspace";
		System.out.println("The number of files in the folder (including all subfolders): " + countFile(path));
		System.out.println("Size of this folder: " + sizeFolder(path) + " bytes");
	}
}
