package com.java.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookMethod {
	
	Scanner scanner = new Scanner(System.in);
	
	public void selectMethod(){
		
		System.out.println("<1.리스트>");
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookVO> list = dao.getList();
	
		Iterator<PhoneBookVO> it = list.iterator();
	
		while(it.hasNext()) {
			PhoneBookVO item = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n",
					item.getId(),
					item.getName(),
					item.getHp(),
					item.getTel());
			}
	}
	
	public void insertMethod() {
		
		System.out.println("<2.등록>");
		System.out.println(">이름: ");
		String name = scanner.next();
		System.out.println(">휴대전화: ");
		String hp = scanner.next();
		System.out.println(">집전화: ");
		String tel = scanner.next();
	

		PhoneBookVO vo = new PhoneBookVO(null, name, hp, tel);
		PhoneBookDAO dao = new PhoneBookDAOImpl();
	
		boolean success = dao.insert(vo);
	
		System.out.println("[등록되었습니다.]");
	
	
	}

	public void deleteMethod() {
		
		System.out.println("<3.삭제>");
		System.out.println(">번호: ");
		int id = scanner.nextInt();
	
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.delete(Long.valueOf(id));
	
		System.out.println("[삭제되었습니다.]");
		
	}
	
	public void searchMethod() {

		System.out.println("<4.검색>");
		System.out.println(">이름: ");
		String keyword = scanner.next();
		
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		List<PhoneBookVO> list = dao.search(keyword);
		
		Iterator<PhoneBookVO> it = list.iterator();
		
		while(it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.printf("%d\t%s\t%s\t%s",
					vo.getId(),
					vo.getName(),
					vo.getHp(),
					vo.getTel());
		}
		
}
	
	
}



