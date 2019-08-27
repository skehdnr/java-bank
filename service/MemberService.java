package service;

import bean.AdminBean;
import bean.CustomerBean;
import bean.MemberBean;

public interface MemberService {
	public void join(CustomerBean param);
	public CustomerBean[] findAllCustomers();
	public void register(MemberBean param);
	public AdminBean[] findAllAdmins();
	public MemberBean[] findByName(String name);
	public MemberBean findById(String id);
	public boolean login(MemberBean param);
	public int countMembers();
	public int countAdmins();
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
	
	
}
