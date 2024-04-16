package Eg_IOStream;

import java.io.*;

public class FileReaderDemo {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("./src/Eg_IOStream/ReadFile.java");
		BufferedReader br = new BufferedReader(fr);
		String s;
		while ((s = br.readLine()) != null ) {
			System.out.println(s);
		}
		fr.close();
	}
}
