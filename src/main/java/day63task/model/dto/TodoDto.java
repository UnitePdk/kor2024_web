package day63task.model.dto;

import day63task.model.entity.TodoEntity;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
    private int index;
    private String content;
    private boolean status;

    public TodoEntity toEntity() {
        return TodoEntity.builder()
                .todo_index(index)
                .content(content)
                .status(status)
                .build();
    }
}
