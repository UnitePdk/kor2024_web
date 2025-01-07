package day57task.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class StudentDto {
    private int index;
    private String name;
    private int kor;
    private int math;
    private int eng;
}
