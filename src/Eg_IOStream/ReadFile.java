package Eg_IOStream;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
	public static void readFile(String path) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			int data;
			data = fis.read();
			while (data!=-1) {
				System.out.print((char)data);
				data = fis.read();
			}
		} catch (IOException e) {
			System.out.println("Loi Exception");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("Loi IOException");
			}
		}
	}
	public static void main(String[] args) {
		readFile("./src/Eg_IOstream/ReadFile.java");
	}
}
