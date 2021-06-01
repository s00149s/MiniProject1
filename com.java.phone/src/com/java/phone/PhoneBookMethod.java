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
		Scanner scanner2 = new Scanner(System.in);
		System.out.println(">이름: ");
		String name = scanner2.next();
		System.out.println(">휴대전화: ");
		String hp = scanner2.next();
		System.out.println(">집전화: ");
		String tel = scanner2.next();
	

		PhoneBookVO vo = new PhoneBookVO(null, name, hp, tel);
		PhoneBookDAO dao = new PhoneBookDAOImpl();
	
		boolean success = dao.insert(vo);
	
		System.out.println("[등록되었습니다.]");
	
		scanner2.close();
	
	
}

	public void deleteMethod() {
		
		System.out.println("<3.삭제>");
		Scanner scanner3 = new Scanner(System.in);
		System.out.println(">번호: ");
		int id = scanner3.nextInt();
	
		PhoneBookDAO dao = new PhoneBookDAOImpl();
		boolean success = dao.delete(Long.valueOf(id));
	
		System.out.println("[삭제되었습니다.]");
	
		scanner3.close();
}
	public void findMethod() {

		System.out.println("<4.검색>");
		Scanner scanner4 = new Scanner(System.in);
		System.out.println(">이름: ");
	
	
}
	
	
}



