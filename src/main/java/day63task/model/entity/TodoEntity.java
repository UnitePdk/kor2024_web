package day63task.model.entity;

import day63task.model.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int todo_index;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String content;

    @Column(columnDefinition = "boolean default false")
    private boolean status;

    public TodoDto toDto() {
        return TodoDto.builder()
                .index(todo_index)
                .content(content)
                .status(status)
                .build();
    }
}
