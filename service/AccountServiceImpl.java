package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import bean.AccountBean;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] accountBean;
	private int count;
	private String result = "";
	
	
	
	public AccountServiceImpl() {
		accountBean = new AccountBean[10];
		count = 0;
		
	}
	@Override
	public void createAccount(int money) {
		AccountBean acc = new AccountBean();
		acc.setAccountNum(createAccountNum());
		acc.setMoney(money);
		acc.setToday(findDate());
		accountBean[count] = acc;
		count++;
		
		
	}

	@Override
	public String createAccountNum() {
		String accountNum = "";
		Random ran = new Random();
		for(int i=0;i<9;i++) {
			accountNum += (i==4)?"-":ran.nextInt(10);
		}
		return accountNum;
	}

	@Override
	public AccountBean[] findAll() {
		return accountBean;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		AccountBean a = new AccountBean();
		for(int i = 0; i<count;i++) {
			if(accountNum.equals(accountBean[i].getAccountNum())) {
				a = accountBean[i];
				break;
			}
		}
		return a;
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean flag = false;
		for(int i =0;i<count;i++) {
		if(accountNum.equals(accountBean[i].getAccountNum())) {
			flag = true;
		}
	}
		return false;
}
	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public void depositMoney(AccountBean param) {
		int money = param.getMoney();
		for(int i=0; i<count; i++) {
			if(param.equals(accountBean[i].getAccountNum())) {
				money += param.getMoney();
				}
		}
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		int money = param.getMoney();
		for(int i = 0; i<count; i++) {
			if(param.equals(accountBean[i].getAccountNum())) {
				money -= param.getMoney();
			}
		}
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		if(existAccountNum(accountNum)) {
			int i = 0;
			for(;i<count;i++) {
			if(accountBean[i].getAccountNum().equals(accountNum)) {
				accountBean[i] = accountBean[count-1];
				count--;
				break;
	}
	
}
		}
	}
}

