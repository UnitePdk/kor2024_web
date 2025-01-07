package day54homework.model;

import java.sql.*;
import java.util.ArrayList;

public class TodoDao {

    private Connection conn;

    private TodoDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tododb", "root", "1234");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } // try end
    } // init end

    private static TodoDao instance = new TodoDao();

    public static TodoDao getInstance() { return instance; }

    public boolean add(TodoDto todoDto) {
        System.out.println("dao add함수 실행");
        String sql = "insert into todolist (todo_content) values (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getContent());
            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } // try end
        return false;
    } // func end

    public ArrayList<TodoDto> getAll() {
        ArrayList<TodoDto> todoList = new ArrayList<>();
        String sql = "select * from todolist";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TodoDto todoDto = new TodoDto(rs.getInt("todo_index"), rs.getString("todo_content"), rs.getBoolean("todo_status"));
                todoList.add(todoDto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return todoList;
    } // func end

    public boolean edit(TodoDto todoDto) {
        String sql = "update todolist set todo_content=?, todo_status=? where todo_index=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, todoDto.getContent());
            ps.setBoolean(2, todoDto.getStatus());
            ps.setInt(3, todoDto.getIndex());
            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } // try end
        return false;
    } // func end

    public boolean delete(int index) {
        try {
            String sql = "delete from todolist where todo_index=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, index);
            if (ps.executeUpdate() == 1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } // try end
        return false;
    } // func end
} // class end
