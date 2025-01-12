package day57task.model.dao;

import day57task.model.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
public class StudentDao {
    private Connection conn;
    private String dbUrl = "jdbc:mysql://localhost:3306/db0107";
    private String dbUser = "root";
    private String dbPassword = "1234";
    public StudentDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 점수 등록
    public boolean register(StudentDto studentDto) {
        String sql="insert into student (student_name, student_kor, student_math, student_eng) values (?,?,?,?)";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, studentDto.getName());
            ps.setInt(2, studentDto.getKor());
            ps.setInt(3, studentDto.getMath());
            ps.setInt(4, studentDto.getEng());
            int result=ps.executeUpdate();
            if (result==1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // 전체 점수 리스트 반환
    public ArrayList<StudentDto> list() {
        ArrayList<StudentDto> list=new ArrayList<>();
        String sql="select * from student";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                StudentDto studentDto=new StudentDto();
                studentDto.setIndex(rs.getInt("student_index"));
                studentDto.setName(rs.getString("student_name"));
                studentDto.setKor(rs.getInt("student_kor"));
                studentDto.setMath(rs.getInt("student_math"));
                studentDto.setEng(rs.getInt("student_eng"));
                list.add(studentDto);
            } // while end
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } // try end
        return list;
    } // func end

    // 특정 학생 점수 수정
    public boolean edit(StudentDto studentDto) {
        String sql="update student set student_kor=?, student_math=?, student_eng=? where student_name=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, studentDto.getKor());
            ps.setInt(2, studentDto.getMath());
            ps.setInt(3, studentDto.getEng());
            ps.setString(4, studentDto.getName());
            int result=ps.executeUpdate();
            if (result==1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // 특정 학생 정보 삭제
    public boolean delete(int index) {
        String sql="delete from student where student_index=?";
        try{
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, index);
            int result=ps.executeUpdate();
            if (result==1) return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
