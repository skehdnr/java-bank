package bean;

public class AdminBean extends MemberBean{
	private String sabun;
	
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}public String getSabun() {
		return this.sabun;
	}
	@Override
	public String toString() {
		return " 관리자정보 [ id=" + getId() + ", pass=" + getPass() + ", name=" + getName() + ", ssn=" + getSsn() + "사번 ="+getSabun()+"]";
	}
}
