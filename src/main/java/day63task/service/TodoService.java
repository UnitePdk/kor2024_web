package day63task.service;

import day63task.model.dto.TodoDto;
import day63task.model.entity.TodoEntity;
import day63task.model.repository.TodoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public boolean add(TodoDto todoDto) {
        TodoEntity entity = todoDto.toEntity();
        TodoEntity saveEntity=todoRepository.save(entity);

        return saveEntity.getTodo_index()!=0;
    }

    @Transactional
    public List<TodoDto> getAll() {
        List<TodoEntity> entityList=todoRepository.findAll();
        List<TodoDto> list = new ArrayList<>();

        for (int i = 0; i < entityList.size(); i++) {
            TodoEntity entity = entityList.get(i);
            list.add(entity.toDto());
        }
        return list;
    }

    @Transactional
    public boolean edit(int index) {
        TodoEntity editEntity = todoRepository.findById(index).get();
        editEntity.setStatus(true);
        todoRepository.save(editEntity);

        return editEntity.getTodo_index()!=0;
    }

    @Transactional
    public boolean delete(int index) {
        todoRepository.deleteById(index);
        return true;
    }
}
