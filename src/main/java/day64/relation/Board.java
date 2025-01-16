package day64.relation;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Board {
    private int index;
    private String title;
    private String content;

    @ToString.Exclude
    private Member writer;
}
