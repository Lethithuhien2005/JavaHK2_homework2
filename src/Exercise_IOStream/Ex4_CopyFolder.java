package Exercise_IOStream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Ex4_CopyFolder {
	public static void copyFile(File f1, File f2) {
		try {
			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (f1.isDirectory()) {
			File[] fileInF1 = f1.listFiles();
			for (File file : fileInF1) {
				File newFile = new File(f2.getAbsoluteFile() + "/" + file.getName());
				copyFile(file, newFile);
			}
		}
	}
	public static void main(String[] args) {
		File f1 = new File("D:\\File0");
		File f2 = new File("D:\\File1");
		copyFile(f1, f2);
	}
}
