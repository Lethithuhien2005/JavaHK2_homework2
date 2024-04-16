package ExerciseXML;

public class Student {
	private String name;
	private String id;
	private String birth;
	private String gpa;
	
	public Student() {
		
	}

	public Student(String name, String id, String birth, String gpa) {
		this.name = name;
		this.id = id;
		this.birth = birth;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGpa() {
		return gpa;
	}

	public void setGpa(String gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student name=" + name + ", id=" + id + ", birth=" + birth + ", gpa=" + gpa ;
	}
	
}
