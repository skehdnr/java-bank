package controller;

import service.AccountService;
import service.AccountServiceImpl;

public class test {

	public static void main(String[] args) {

		AccountService s = new AccountServiceImpl();
		s.createAccountNum();
		
		
	}

}
