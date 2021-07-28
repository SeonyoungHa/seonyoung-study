package com.eomcs.app_06.pms.handler;

import java.sql.Date;

import com.eomcs.app_06.pms.domain.Board;
import com.eomcs.app_06.util.Prompt;

public class BoardHandler {

	// 모든 게시판의 최대 배열 개수가 같기 때문에 다음 변수는 
	// 그냥 static 필드로 남겨둔다.
	static final int MAX_LENGTH = 5;

	// 게시판 마다 따로 관리해야 하기 때문에 인스턴스 필드로 전환한다.
	// => static 옵션을 뺀다.
	Board[] boards = new Board[MAX_LENGTH];
	int size = 0;

	public void add() {
		System.out.println("[새 게시글]");

		Board board = new Board();

		board.no = Prompt.inputInt("번호? ");
		board.title = Prompt.inputString("제목? ");
		board.content = Prompt.inputString("내용? ");
		board.writer = Prompt.inputString("작성자? ");
		board.registeredDate = new Date(System.currentTimeMillis());
		//    board.viewCount = 0; // 인스턴스 변수는 생성되는 순간 기본 값이 0으로 설정된다.

		boards[size] =board;
		size++;
		//boards[size++] = board;
	}

	public void list() {
		System.out.println("[게시글 목록]");
		for (int i = 0; i < this.size; i++) {
			System.out.printf("%d, %s, %s, %s, %d, %d\n", 
					this.boards[i].no, 
					this.boards[i].title, 
					this.boards[i].writer,
					this.boards[i].registeredDate,
					this.boards[i].viewCount, 
					this.boards[i].like);
		}
	}

	public void detail() {
		System.out.println("[게시글 상세보기]");
		int no = Prompt.inputInt("번호? ");

		Board board = null;

		for (int i = 0; i < this.size; i++) {
			if (this.boards[i].no == no) {
				board = this.boards[i];
				break;
			}
		}

		if(board == null) {
			System.out.println("해당 번호의 게시글이 없습니다.");
			return;
		}
		System.out.printf("제목: %s\n", board.title);
		System.out.printf("내용: %s\n", board.content);
		System.out.printf("작성자: %s\n", board.writer);
		System.out.printf("등록일: %s\n", board.registeredDate);
		System.out.printf("조회수: %d\n", ++board.viewCount);
	}

	public void update() {
		System.out.println("[게시글 변경]");
		int no = Prompt.inputInt("번호");

		Board board = null;

		for (int i = 0; i < this.size; i++) {
			if (this.boards[i].no == no) {
				board = this.boards[i];
				break;
			}
		}
		if(board == null) {
			System.out.println("해당 번호의 게시글이 없습니다.");
		}

		String title = Prompt.inputString(String.format(null, boards));
	}

	public void delete() {
		System.out.println("[게시글 삭제]");
		int no = Prompt.inputInt("번호? ");

		int Index = -1;

		for (int i = 0; i < this.size; i++ ) {
			if (this.boards[i].no == no) {
				Index = i;
				break;
			}
		}

		if (Index == -1) {
			System.out.println("해당 번호의 게시글이 없습니다.");
			return;
		}

		String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N");
		if (input.equalsIgnoreCase("n") || input.length() == 0) {
			System.out.println("게시글 삭제를 취소하였습니다.");
			return;
		}

		for (int i = Index+1; i < size ; i++) {
			boards[i-1] = boards[i];
		}

		//		for (int i = index ; i < size -1 ; i++) {
		//			boards[i] = boards[i+1];
		//		}

		size--;
		boards[size] = null;
		//boards[--size] = null;


		System.out.println("게시글을 삭제하였습니다.");
	}

}






