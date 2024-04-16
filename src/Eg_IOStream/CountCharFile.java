package Eg_IOStream;
import java.io.FileInputStream;
import java.io.IOException;

public class CountCharFile {
	public static int count(String path, char ch) {
		int c = 0;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			int data;
			data = fis.read();
			while (data != -1) {
				if (data == ch)
					c++;
				data = fis.read();
			}
		} catch (IOException e) {
			System.out.println("Loi IOException");
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				System.out.println("Loi IOException");
			}
		}
		return c;
	}
	public static void main(String[] args) {
		System.out.println(count("./src/Eg_IOStream/CountCharFile.java", 'i'));
	}
}
