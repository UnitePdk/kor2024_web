package day57task.service;

import day57task.model.dao.StudentDao;
import day57task.model.dto.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    // 점수 등록
    public boolean register(StudentDto studentDto) {
        return studentDao.register(studentDto);
    }

    // 전체 점수 리스트 반환
    public ArrayList<StudentDto> list() {
        return studentDao.list();
    }

    // 특정 학생 점수 수정
    public boolean edit(StudentDto studentDto) {
        return studentDao.edit(studentDto);
    }

    // 특정 학생 정보 삭제
    public boolean delete(int index) {
        return studentDao.delete(index);
    }
}
