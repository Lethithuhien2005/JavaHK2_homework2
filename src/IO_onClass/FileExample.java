package IO_onClass;

import java.io.*;

public class FileExample {

	public static void main(String[] args) {
		String path = "D:\\Users";
		nameFile(path);
	}
	
	public static void nameFile(String path) {
		File names = new File(path);
		if (names.isDirectory()) {
			String[] folders = names.list();
			for (int i = 0; i < folders.length; i++) {
				File files = new File(path + "\\" + folders[i]);
				if (files.isDirectory()) {
					System.out.println(folders[i] + " <Dir>");
					nameFile(files.getAbsolutePath());
				}
				else System.out.println("\t" + folders[i]);
			}
		}
	}
}
	
