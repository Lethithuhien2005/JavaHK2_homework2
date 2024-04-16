package Exercise_IOStream;

import java.io.File;
import java.nio.file.Files;

public class NameFile {
	public static void main(String[] args) {
		String path = "D:\\Users/DIEN MAY XANH/eclipse-workspace/DACK/src";
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
				else System.out.println(folders[i]);
			}
		}
	}
}
//	public static void displayF(File f) {
//		System.out.println(f.getAbsoluteFile());
//		if (f.isDirectory()) {
//			String[] subF = f.list();
//			for (String fileName : subF) {
//				displayF(new File(f, fileName));
//			}
//		}
//	}
//}
