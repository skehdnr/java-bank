package controller;

import javax.swing.JOptionPane;

import bean.MemberBean;
import service.AccountServiceImpl;
import service.MemberServiceImpl;

public class AdminController {
	public static void main(String[] args) {
		MemberServiceImpl service = new MemberServiceImpl();
		AccountServiceImpl account = new AccountServiceImpl();
		MemberBean member = null;
		String [] arr = null;
		
		while(true) {
			switch(JOptionPane.showInputDialog(""
					+ "0.종료\n"
					+ "1.계좌생성\n"
					+ "2.계좌정보\n"
					+ "3.계좌번호찾기\n"
					+ "4.계좌수\n"
					+ "5.계좌중복확인\n"
					+ "6.입금내역\n"
					+ "7.출금내역\n"
					+ "8.회원탈퇴")) {
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1" :
				JOptionPane.showInputDialog("이름,비밀번호");
				JOptionPane.showMessageDialog(null, account.createAccountNum());
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, account.findAll());
				break;
			case "3" :
				
				break;
			
			
			
			}
		}
		
		
	}
}
