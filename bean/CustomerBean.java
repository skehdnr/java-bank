package bean;

public class CustomerBean extends MemberBean{
	
	private String credit;
	
	public void setCredit(String credit) {
		this.credit =credit;
	}public String getCredit() {
		return this.credit;
	}
	@Override
	public String toString() {
		return "[ 고객정보 ]"
				+ "id = "+getId() +""
						+ "pass = "+getPass()+""
								+ "이름 = "+getName()+""
										+ "주민번호 = "+getSsn()+""
												+ "신용도 = "+credit;
	}
		
}
