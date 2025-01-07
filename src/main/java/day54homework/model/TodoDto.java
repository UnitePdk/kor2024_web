package day54homework.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class TodoDto {
    private int index;
    private String content;
    private boolean status;
}
