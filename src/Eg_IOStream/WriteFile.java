package Eg_IOStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class WriteFile {
	public static void writeFile(String path) {
//		FileOutputStream fos = null;
//		String msg = "programming with IO Stream in java";
//		try {
//			fos = new FileOutputStream(path);
//			for (int i = 0; i < msg.length(); i++) {
//				fos.write((int) msg.charAt(i));
//				fos.flush();
//			}
//		} catch (IOException e) {
//			System.out.println("Loi IOException");
//		} finally {
//			try {
//				fos.close();
//			} catch (IOException e) {
//				System.out.println("Loi IOException");
//			}
//		}
//	}

		DataOutputStream bf = null;
		String msg = "programming with IO Stream in java";
		try {
			bf = new DataOutputStream(new FileOutputStream(path));
			bf.writeChars(msg);
			bf.flush();
		} catch (IOException e) {
			System.out.println("Loi IOException");
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				System.out.println("Loi IOException");
			}
		}
	}

	public static void main(String[] args) {
		writeFile("D:\\Test.txt");
	}
}
