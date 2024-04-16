package ReviewOOP;

public class Student {
	private int stt;
	private String id;
	private String name;
	private int gender;
	private double num;
	private String status = "normal";
	
	public Student() {
		
	}

	public Student(int stt, String id, String name, int gender, double num, String status) {
		this.stt = stt;
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.num = num;
		this.status = status;
	}

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public double authorized() {
		return num += 0.5;
	}
	public double absent() {
		return num+= 1;
	}
}
