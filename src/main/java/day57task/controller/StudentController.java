package day57task.controller;

import day57task.model.dto.StudentDto;
import day57task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register.do")
    public boolean register(@RequestBody StudentDto studentDto) {
        return studentService.register(studentDto);
    }

    @GetMapping("/list.do")
    public ArrayList<StudentDto> list() {
        return studentService.list();
    }

    @PutMapping("/edit.do")
    public boolean edit(@RequestBody StudentDto studentDto) {
        return studentService.edit(studentDto);
    }

    @DeleteMapping("/delete.do")
    public boolean delete(@RequestParam int index) {
        return studentService.delete(index);
    }
}
