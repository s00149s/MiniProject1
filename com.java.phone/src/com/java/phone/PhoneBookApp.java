package com.java.phone;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PhoneBookApp {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("***************************************");
			System.out.println("*           전화번호 관리 프로그램           *");
			System.out.println("***************************************");
			System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
			System.out.println(">메뉴번호: ");
			
			int num = scanner.nextInt();
			
			if (num == 1) {
				PhoneBookMethod select = new PhoneBookMethod();
				select.selectMethod();
			}
			else if (num == 2) {
				PhoneBookMethod insert = new PhoneBookMethod();
				insert.insertMethod();
			}
			else if (num == 3) {
				PhoneBookMethod delete = new PhoneBookMethod();
				delete.deleteMethod();
			}
			else if (num == 4) {
				PhoneBookMethod search = new PhoneBookMethod();
				search.searchMethod();
			}
			else if (num == 5) {
				scanner.close();
				System.out.println("***************************************");
				System.out.println("*               감사합니다                          *");
				System.out.println("***************************************");
				break;
			}
			else {
				System.out.println("다시 입력해 주세요");
			}
					

		}
	}
}


