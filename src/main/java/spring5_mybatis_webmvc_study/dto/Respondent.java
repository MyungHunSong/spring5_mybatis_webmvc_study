package spring5_mybatis_webmvc_study.dto;

public class Respondent {
	private int age;
	private String location;
	
	public Respondent() {}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return String.format("Respondent [age=%s, location=%s]", age, location);
	}
	
	
}
