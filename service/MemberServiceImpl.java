package service;

import bean.AdminBean;
import bean.CustomerBean;
import bean.MemberBean;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] members;
	private CustomerBean[] customers;
	private AdminBean[] admins;
	
	private int custCount,adminCount;

	public MemberServiceImpl() {
		customers = new CustomerBean[10];
		admins = new AdminBean[10];
		adminCount = 0;
		custCount = 0;
	}

	@Override
	public void join(CustomerBean param) {
		members[custCount] = param;
		custCount++;
	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return customers;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		return admins;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int count1 = 0, count2 = 0, count3 = 0;
		for(int i=0;i< custCount;i++) {
			if(name.equals(customers[i].getName())) {
				count1++;
				break;
			}
		}
		for(int i=0;i< adminCount;i++) {
			if(name.equals(admins[i].getName())) {
				count2++;
				break;
			}
		}
		count3 = count1 + count2;
		MemberBean[] members = new MemberBean[count3];
		int j = 0;
		for(int i=0;i< custCount;i++) {
			if(name.equals(customers[i].getName())) {
				members[j] = customers[i];
				j++;
				if(count1==j) {
					break;
				}
			}
		}
		int k = 0; 
		for(int i=0;i< adminCount;i++) {
			if(name.equals(admins[i].getName())) {
				members[j] = admins[i];
				k++;
				j++;
				if(count2==k) {
					break;
				}
				break;
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean c = new MemberBean();
		for (int i=0;i<custCount;i++) {
			if(id.equals(customers[i].getId())) {
				c=admins[i];
				break;
			}
		}
		for(int i=0;i<adminCount;i++) {
			if(id.equals(admins[i].getId())) {
				c=admins[i];
				break;
				}
		}
		return c;
	}

	@Override 
	public boolean login(MemberBean param) { 
//		return findById(param.getId()).equals(param.getPass()); 한줄로가능
		boolean flag = false;
		if(findById(param.getId()).equals(param.getPass())) {
			flag = true;
		}
		return flag;
	}

	@Override
	public int countMembers() {
		return custCount;
	}

	@Override
	public int countAdmins() {
		return adminCount;
	
	}

	@Override
	public boolean existId(String id) {
		boolean flag = false;
		for (int i=0;i<custCount;i++) {
			if(id.equals(customers[i].getId())) {
				flag= true;
				break;
				}
			}
		for(int i=0;i<adminCount;i++) {
			if(id.equals(admins[i].getId())) {
				flag= true;
				break;}
		}
		return flag ;
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();
		String [] newPass =param.getPass().split(",");
		String oldPass = newPass[0];
		String nP = newPass[1];
		param.setPass(oldPass);
		if(login(param)) {
			for(int i=0;i< custCount;i++) {
				if(id.equals(customers[i].getId())) {
					customers[i].setPass(nP);;
					break;
				}
			}
			for(int i=0;i< adminCount;i++) {
				if(id.equals(admins[i].getId())) {
					admins[i].setPass(nP);
					break;
				}
			}
		}
	}

	@Override
	public void deleteMember(MemberBean param) {
		if(login(param)) {
			int i = 0;
			for(;i<custCount;i++) {
			if(customers[i].getId().equals(param.getId())) {
				customers[i] = customers[custCount-1];
				custCount--;
				break;
			}
			}
			i=0;
			for(;i<adminCount;i++) {
				if(admins[i].getId().equals(param.getId())) {
					admins[i] = admins[adminCount-1];
					adminCount--;
					break;}
			}
			}
		}
		
		
	

	@Override
	public void register(MemberBean param) {

		
		
	}

}