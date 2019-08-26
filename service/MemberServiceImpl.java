package service;
import bean.AdminBean;
import bean.CustomerBean;
import bean.MemberBean;

public class MemberServiceImpl implements MemberService{
	private MemberBean [] members;
	private int count;
	private CustomerBean [] customers;
	private AdminBean [] admins;
	String result = "";
	
	public MemberServiceImpl() {
		members = new MemberBean[10];
		count = 0;
	}
	
	@Override
	public void join(CustomerBean param) {
		result = "회원가입성공";
		members[count] = param;
		count++;
		return;
	}
	@Override
	public CustomerBean[] findAllCustomers() {
		members = new MemberBean[10];
		for(int i =0; i<count;i++) {
			members[i] = customers[i];
		}
		return customers;
	}
	@Override
	public AdminBean[] findAllAdmins() {
		members = new MemberBean[10];
		for(int i =0; i<count;i++) {
			members[i] = admins[i];
		}
		return admins;
	}
	@Override
	public MemberBean[] findByName(String name) {
		int j = 0;
		for(int i = 0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				j++;
			}
		}
		MemberBean[] members = new MemberBean[j];
		j = 0 ;
		for(int i = 0; i<count; i++) {
			if(name.equals(this.members[i].getName())) {
				members[j] = this.members[i];
				j++;
				if(members.length==j) {
					break;
				}
			}members[i] = this.members[i];
		}
		return members;
	}
	public String countAll() {
		return String.valueOf(count+"명 입니다");
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		for (int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];
			}break;
		}
		return member;
	}

	@Override
	public boolean login(MemberBean param) {
		boolean msg = false;
		for(int i = 0; i<count; i++) {
			if(param.getId().equals(members[i].getId())
					&&(param.getPass().equals(members[i].getPass()))){
				msg=true;
			break;
			}		
		}
		return msg;
	}

	@Override
	public int countCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countAdmins() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String existId(String id) {
		result = "가입가능 ID 입니다";
		// 가입가능한 아이디 입니다.
		for(int i =0; i<count;i++) {
			if(id.equals(members[i].getId())) {
				result = "이미 존재하는 ID 입니다";
				break;
			}
		}
		return result;
	}

	@Override
	public String updatePass(MemberBean param) {
		result = "비밀번호가 변경 되었습니다";
		String id = param.getId();
		String pass = param.getPass();
		
		String [] newPass =pass.split(",");
		String oldPass = newPass[0];
		String nP = newPass[1];
		for(int i = 0; i<count;i++) {
			if(param.getId().equals(members[i].getId())
					&&(oldPass.equals(members[i].getPass()))){
				members[i].setPass(nP);
				break;
			}
	}return result;
	}

	@Override
	public void deleteMember(MemberBean param) {
		// TODO Auto-generated method stub
		
	}
	
}
