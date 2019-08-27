package controller;

import javax.swing.JOptionPane;

import bean.MemberBean;
import service.AccountService;
import service.AccountServiceImpl;
import service.MemberService;
import service.MemberServiceImpl;

public class UserController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		AccountService aservice = new AccountServiceImpl();
		MemberBean member = null;
		String [] arr = null;
		String temp = "";
		while(true) {
			switch(JOptionPane.showInputDialog(""
					+ "0.종료 \n"
					+ "1.회원가입\n"
					+ "2.로그인\n"
					+ "3.비민번호변경\n"
					+ "4.이름찾기\n"
					+ "5.ID찾기\n"
					+ "6.회원목록\n"
					+ "7.관리자목록\n"
					+ "8.고객인원수\n"
					+ "9.관리자 인원수\n"
					+ "10.ID중복체크\n"
					+ "11.회원탈퇴")) {
			case "0" : 
				JOptionPane.showMessageDialog(null, "종료");
			return;
			case "1" :
			String spec = JOptionPane.showInputDialog("이름,아이디,비민번호,주민번호 입력");
			arr = spec.split(",");
			member = new MemberBean();
			member.setName(arr[0]);
			member.setId(arr[1]);
			member.setPass(arr[2]);
			member.setSsn(arr[3]);
			JOptionPane.showMessageDialog(null, "회원가입성공");
			break;
			
			case "2" :
				String login = JOptionPane.showInputDialog("로그인 ID, 비밀번호");
				String[] loginValues = login.split(",");
				String loginId = loginValues[0];
				String loginPass = loginValues[1];;
				member = new MemberBean();
				member.setId(loginId);
				member.setPass(loginPass);
				boolean msg = service.login(member);
				JOptionPane.showInputDialog(null,msg);
				break;
				
			case "3" :
				temp = JOptionPane.showInputDialog("Id,Pass,새로 바꿀 비밀번호를 입력해 주세요.");
				arr = temp.split(",");
				member = new MemberBean();
				member.setId(arr[0]);
				member.setPass(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null, "비밀번호변경 완료");
				break;
				
			case "4" :
				String searchName = JOptionPane.showInputDialog("검색 이름");
				JOptionPane.showMessageDialog(null,service.findByName(searchName));
				break;
			case "5" :
				String searchId = JOptionPane.showInputDialog("검색ID");
				JOptionPane.showMessageDialog(null, service.findById(searchId));
				break;
			case "6" :
				JOptionPane.showMessageDialog(null, service.findAllCustomers());
				break;
			case "7" :
				JOptionPane.showMessageDialog(null, service.findAllAdmins());
				break;
			case "8" :
				JOptionPane.showMessageDialog(null, service.countMembers());
				break;
			case "9" :
				JOptionPane.showMessageDialog(null, service.countAdmins());
				break;
			case "10" :
				
			
			case "11" :
				String delete = JOptionPane.showInputDialog("탈퇴할 Id,Pass 입력");
				String [] del = delete.split(",");
				String deleteId = del[0];
				String delPass = del[1];
				member = new MemberBean();
				member.setId(deleteId);
				member.setPass(delPass);
				JOptionPane.showMessageDialog(null, "탈퇴완료");
				break;
				
				
			}
		}
	}
}
