package day52.boardService8mvc.model;

import java.util.ArrayList;

public class BoardDao {
    private BoardDao(){}
    private static BoardDao instance = new BoardDao();
    public static BoardDao getInstance() { return instance; }

    ArrayList<BoardDto> boardDB = new ArrayList<>();

    public boolean write(BoardDto boardDto) {
        boardDB.add(boardDto);
        return true;
    } // func end

    public ArrayList<BoardDto> findAll() {
        return boardDB;
    } // func end
}
