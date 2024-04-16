package Eg_IOStream;

public class Student implements Comparable {
	private String name;
	private String id;
	private float aver;
	
	public Student() {
		name = new String("");
		id = new String("");
		aver = 0;
	}
	
	public Student(String n, String i, float a) {
		name = n;
		id = i;
		aver = a;
	}

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public float getAver() {
		return aver;
	}
	
	public int compareTo(Object other) {
		Student otherRect = (Student)other;
		return (int)(this.aver-otherRect.aver);
	}	
}
