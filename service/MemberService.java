package service;

import bean.AdminBean;
import bean.CustomerBean;
import bean.MemberBean;

public interface MemberService {

	public void join(CustomerBean param);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public MemberBean[] findByName(String name); // 고객, 사원 공용메소드
	public MemberBean findById(String id); // 고객, 사원 공용메소드
	public boolean login(MemberBean param); // 고객, 사원 공용메소드
	public int countCustomers(); // 고객수
	public int countAdmins(); // 직원수
	public String existId(String id);
	public String updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
	
	
	
}
