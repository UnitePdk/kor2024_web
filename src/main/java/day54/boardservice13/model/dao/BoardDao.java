package day54.boardservice13.model.dao;

import day54.boardservice13.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {

    private Connection conn;

    private BoardDao() {
        // DB 연동
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0102", "root", "1234");
        }catch(Exception e){
            System.out.println(e.getMessage());
        } // try end
    } // init end

    private static BoardDao instance = new BoardDao();
    public static BoardDao getInstance() { return instance; }

    public boolean write(BoardDto boardDto) {
        try {
            String sql = "insert into board (board_title, board_content, board_writer, board_password) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getTitle());
            ps.setString(2, boardDto.getContent());
            ps.setString(3, boardDto.getWriter());
            ps.setString(4, boardDto.getPassword());
            int result = ps.executeUpdate();
            if(result == 1) return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } // try end
        return false;
    }

    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select * from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setIndex(rs.getInt("board_index"));
                boardDto.setTitle(rs.getString("board_title"));
                boardDto.setContent(rs.getString("board_content"));
                boardDto.setWriter(rs.getString("board_writer"));
                // 패스워드는 제외
                list.add(boardDto);
            } // while end
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } // try end
        return list;
    } // func end

    public BoardDto findOne(int id) {
        try {
            String sql = "select * from board where board_index =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BoardDto boardDto = new BoardDto();
                boardDto.setIndex(rs.getInt("board_index"));
                boardDto.setTitle(rs.getString("board_title"));
                boardDto.setContent(rs.getString("board_content"));
                boardDto.setWriter(rs.getString("board_writer"));
                // 패스워드는 제외
                return boardDto;
            } // while end
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } // try end
        return null;
    } // func end

    public boolean update(BoardDto boardDto) {
        try {
            String sql = "update board set board_title =?, board_content =? where board_index =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getTitle());
            ps.setString(2, boardDto.getContent());
            ps.setInt(3, boardDto.getIndex());
            int result = ps.executeUpdate();
            if(result == 1) return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } // try end
        return false;
    } // func end

    public boolean delete(int index) {
        try {
            String sql = "delete from board where board_index =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, index);
            int result = ps.executeUpdate();
            if(result == 1) return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } // try end
        return false;
    } // func end
}
