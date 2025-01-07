package day57task.controller;

import day57task.model.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 스프링이 알아서 관리할 인스턴스(Bean)을 생성해줌
// 이 클래스의 싱글톤 인스턴스의 제어권이 Spring에게 넘어가서 알아서 관리해줌.
public class StudentController {
    // Spring이 만든 Bean(객체/싱글톤 인스턴스)를 요청
    @Autowired private StudentDao studentDao;
}
