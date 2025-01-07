package day54homework.controller;

import day54homework.model.TodoDao;
import day54homework.model.TodoDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TodoController {
    // http://localhost:8080/day55hw/todoview.html

    // 할일 작성
    @PostMapping("/add")
    public boolean add(@RequestBody TodoDto todoDto) {
        System.out.println("TodoController.add");
        System.out.println("todoDto = " + todoDto);
        return TodoDao.getInstance().add(todoDto);
    }

    // 할일 전체 조회
    @GetMapping("/getall")
    public ArrayList<TodoDto> getAll() {
        System.out.println("TodoController.getAll");
        return TodoDao.getInstance().getAll();
    }

    // 할일 수정
    @PutMapping("/edit")
    public boolean edit(@RequestBody TodoDto todoDto) {
        System.out.println("TodoController.edit");
        System.out.println("todoDto = " + todoDto);
        return TodoDao.getInstance().edit(todoDto);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int id) {
        System.out.println("TodoController.delete");
        System.out.println("id = " + id);
        return TodoDao.getInstance().delete(id);
    }
}
