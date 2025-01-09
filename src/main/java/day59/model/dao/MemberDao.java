package day59.model.dao;

import day59.model.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component // 스프링 메모리에 dao 빈 주입
public class MemberDao {

    private Connection conn;
    private String dbUrl = "jdbc:mysql://localhost:3306/mydb0109";
    private String dbUser = "root";
    private String dbPassword = "1234";
    public MemberDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean signup(MemberDto memberDto) {
        String sql = "insert into member (member_id, member_password, member_name, member_phone) values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getId());
            ps.setString(2, memberDto.getPassword());
            ps.setString(3, memberDto.getName());
            ps.setString(4, memberDto.getPhone());
            int result = ps.executeUpdate();
            if(result == 1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean login(String id, String password) {
        String sql = "select * from member where member_id =? and member_password =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
