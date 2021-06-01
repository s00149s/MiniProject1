package com.java.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) {
		
		// 4. 검색
		System.out.println("***************************************");
		System.out.println("*           전화번호 관리 프로그램                   *");
		System.out.println("***************************************");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		Scanner scanner = new Scanner(System.in);
		System.out.println(">메뉴번호: ");
		int num = scanner.nextInt();
		
		if (num == 1) {
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
			
		else if (num == 2) {
			System.out.println("<2.등록>");
			Scanner scanner2 = new Scanner(System.in);
			System.out.println(">이름: ");
			String str1 = scanner2.next();
			System.out.println(">휴대전화: ");
			String str2 = scanner2.next();
			System.out.println(">집전화: ");
			String str3 = scanner2.next();
			
		
			PhoneBookVO vo = new PhoneBookVO(null, str1, str2, str3);
			PhoneBookDAO dao = new PhoneBookDAOImpl();
			
			boolean success = dao.insert(vo);
			
			System.out.println("등록되었습니다.");
			
			scanner2.close();
			
		}
			
			
		}
		

	}


