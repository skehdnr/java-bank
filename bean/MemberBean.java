package bean;

public class MemberBean {
	private String id,pass,name;
	private int ssn;
	
	public void setId(String id) {
		this.id = id;
	}public String getId() {
		return this.id;
	}public void setPass(String pass) {
		this.pass = pass;
	}public String getPass() {
		return this.pass;
	}public void setName(String name) {
		this.name = name;
	}public String getName() {
		return this.name;
	}public void setSsn(int ssn) {
		this.ssn = ssn;
	}public int getSsn() {
		return this.ssn;
	}
	
	public String toString() {
		return String.format("[고객정보]\n"
				+ "이름 : %s"
				+ "아이디 : %s"
				+ "비밀번호 : %s"
				+ "주민번호 : %d",name,id,pass,ssn);
	}
	
	
	
}
