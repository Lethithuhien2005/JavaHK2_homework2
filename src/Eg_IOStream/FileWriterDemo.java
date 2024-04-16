package Eg_IOStream;

import java.io.FileWriter;

public class FileWriterDemo {
	public static void main(String[] args) throws Exception{
		String source = "programming with IO Stream in java";
		FileWriter f = new FileWriter("D:\\Test_file.txt");
		f.write(source);
		f.flush();
		f.close();
	}
}
