package day63task.service;

import day63task.model.dto.TodoDto;
import day63task.model.entity.TodoEntity;
import day63task.model.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public boolean add(TodoDto todoDto) {
        TodoEntity todoEntity = new TodoEntity();
        TodoEntity saveEntity=todoRepository.save(todoEntity);

        return saveEntity.getTodo_index()!=0;
    }

    public List<TodoDto> getAll() {
        List<TodoEntity> entityList=todoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();

        for (int i = 0; i < entityList.size(); i++) {
            TodoEntity entity = entityList.get(i);
            list.add(entity.toDto());
        }
        return list;
    }

//    public boolean edit(TodoDto todoDto) {
//
//    }
//
//    public boolean delete(int index) {
//    }
}
