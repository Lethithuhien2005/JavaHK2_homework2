package Eg_IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("./src/Eg_IOstream/CopyFile.java");
			fos = new FileOutputStream("./CopyFile1.java");
			int data;
			data = fis.read();
			while (data != -1) {
				fos.write(data);
				data = fis.read();
			}
			fos.flush();
		} catch (IOException e) {
			System.out.println("Loi IOException");
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				System.out.println("Loi IOException");
			}
		}
	}
}
