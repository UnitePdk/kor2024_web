package day64.relation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Comment {
    private int index;
    private String content;

    private Member writer;
}
