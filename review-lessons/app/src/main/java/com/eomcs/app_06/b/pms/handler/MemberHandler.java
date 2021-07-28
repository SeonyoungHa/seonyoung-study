package com.eomcs.app_06.pms.handler;

import java.sql.Date;

import com.eomcs.app_06.pms.domain.Member;
import com.eomcs.app_06.util.Prompt;

public class MemberHandler {

	static final int MAX_LENGTH = 5;

	Member[] members = new Member[MAX_LENGTH];
	int size = 0;

	public void add() {
		System.out.println("[회원 등록]");

		Member member = new Member();

		member.no = Prompt.inputInt("번호? ");
		member.name = Prompt.inputString("이름? ");
		member.email = Prompt.inputString("이메일? ");
		member.password = Prompt.inputString("암호? ");
		member.photo = Prompt.inputString("사진? ");
		member.tel = Prompt.inputString("전화? ");
		member.registeredDate = new Date(System.currentTimeMillis());

		this.members[this.size++] = member;
		// boards[size] = board;
		// size++;
	}

	public void list() {
		System.out.println("[회원 목록]");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%d, %s, %s, %s, %s\n", 
					this.members[i].no, 
					this.members[i].name, 
					this.members[i].email, 
					this.members[i].tel, 
					this.members[i].registeredDate);
		}
	}

	public void detail() {
		System.out.println("[회원 상세보기]");
		int no = Prompt.inputInt("번호? ");

		Member member = null;

		for (int i = 0; i < this.size; i++) {
			if (this.members[i].no == no) {
				member = this.members[i];
				break;
			}
		}

		if (member == null) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		System.out.printf("이름: %s\n", member.name);
		System.out.printf("이메일: %s\n", member.email);
		System.out.printf("사진: %s\n", member.photo);
		System.out.printf("전화: %s\n", member.tel);
		System.out.printf("등록일: %s\n", member.registeredDate);
	}

	public void update() {
		System.out.println("[회원 변경]");
		int no = Prompt.inputInt("번호? ");

		Member member = null;

		for (int i = 0; i < this.size; i++) {
			if (this.members[i].no == no) {
				member = this.members[i];
				break;
			}
		}

		if (member == null) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		String name = Prompt.inputString("이름(" + member.name + ")? ");
		String email = Prompt.inputString("이메일(" + member.email + ")? ");
		String password = Prompt.inputString("암호(" + member.password + ")? ");
		String photo = Prompt.inputString("사진(" + member.photo + ")? ");
		String tel = Prompt.inputString("전화(" + member.tel + ")? ");

		String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
		if (input.equalsIgnoreCase("n") || input.length() == 0) {
			System.out.println("회원 변경을 취소하였습니다.");
			return;
		}

		member.name = name;
		member.email = email;
		member.password = password;
		member.photo = photo;
		member.tel = tel;

		System.out.println("회원을 변경하였습니다.");
	}

	public void delete() {
		System.out.println("[회원 삭제]");
		int no = Prompt.inputInt("번호?");

		int index = -1;

		for (int i = 0; i < this.size; i++) {
			if (this.members[i].no == no) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			System.out.println("해당 번호의 회원이 없습니다.");
			return;
		}

		String input = Prompt.inputString("정말 삭제하시겠습니까? (y/N)");
		if (input.equalsIgnoreCase("n") || input.length() == 0) {
			System.out.println("회원 삭제를 취소하였습니다.");
			return;
		}

		for (int i = index + 1; i < this.size; i ++) {
			this.members[i - 1] = this.members[i];
		}
		this.members[--this.size] = null;
		//for (int i = index; i < size - 1; i++) {
		//	boards[i] = boards[i+1];
		//}
		//size --;
		//boards[size] = null;

		System.out.println("회원을 삭제하였습니다.");
	}

	boolean exist(String name) {
		for (int i = 0; i < this.size; i++) {
			if (this.members[i].name.equals(name)) {
				return true;
			}
		}
		return false;
	}
}