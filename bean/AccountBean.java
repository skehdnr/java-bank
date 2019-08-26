package bean;

/*회원 : 아이디 비번 이름 주민번호
 * id,pass,name,ssn
 * 
 * 계좌 : 계좌번호 , 거래일 , 돈
 * AccountNum , today , money
 * 기능 
 * 회원 : 
 * void join(MemberBean param);
 * MemberBean [ ] findAll();
 * MemberBean[ ] findByName(String name);
 * MemberBean findByID (String id);
 * boolean login(MemberBean param);
 * int countMembers();
 * boolean existId ( String id);
 * void updatePass (MemberBean param);
 * void deleteMember(MemberBean param);
 * */
public class AccountBean {
	private String today;
	private int accountNum, money;

	public void setToday(String today) {
		this.today = today;
	}

	public String getToday() {
		return this.today;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public int getAccountNum() {
		return this.accountNum;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getMoney() {
		return this.money;
	}

	public String toString() {
		return String.format("[계좌정보]\n" + "거래일 : %s" + "계좌번호 : %d" + "잔액 : %d", today, accountNum, money);

	}
}
