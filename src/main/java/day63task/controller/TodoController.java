package day63task.controller;

import day63task.model.dto.TodoDto;
import day63task.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/add")
    public boolean add(@RequestBody TodoDto todoDto) {
        System.out.println("todoDto = " + todoDto);
        return todoService.add(todoDto);
    }

    @GetMapping("/getall")
    public List<TodoDto> getAll() {
        return todoService.getAll();
    }

    @PutMapping("/edit")
    public boolean edit(@RequestParam int index) {
        return todoService.edit(index);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int index) {
        return todoService.delete(index);
    }
}
