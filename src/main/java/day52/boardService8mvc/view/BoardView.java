package day52.boardService8mvc.view;

import day52.boardService8mvc.controller.BoardController;
import day52.boardService8mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    private BoardView(){}
    private static BoardView instance = new BoardView();
    public static BoardView getInstance() { return instance; }

    private Scanner scan = new Scanner(System.in);

    public void mainPage() {
        while (true) {
            System.out.println("1.게시물등록 2.게시물출력");
            int choose = scan.nextInt();
            scan.nextLine();
            if (choose == 1) {
                write();
            } else if (choose == 2) {
                findAll();
            }
        } // while end
    } // main end

    // 게시물 작성 함수
    public void write(){
        System.out.println("[게시물 작성 페이지]");

        System.out.println("제목: ");
        String title=scan.nextLine();
        System.out.println("내용: ");
        String content=scan.nextLine();
        System.out.println("비밀번호: ");
        String password=scan.nextLine();

        BoardDto boardDto = new BoardDto(title, content, password);
        boolean result= BoardController.getInstance().write(boardDto);
        if(result){
            System.out.println("게시물 등록 성공");
        } else{
            System.out.println("게시물 등록 실패");
        } // if end
    } // func end

    // 게시물 출력 함수
    public void findAll(){
        System.out.println("[게시물 출력 페이지]");

        ArrayList<BoardDto> result = BoardController.getInstance().findAll();

        for (int i = 0; i < result.size(); i++) {
            System.out.println("제목: "+ result.get(i).getTitle());
            System.out.println("내용: "+result.get(i).getContent());
            System.out.println();
        }
    } // func end
}
