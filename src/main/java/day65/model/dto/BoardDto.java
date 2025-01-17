package day65.model.dto;

import day65.model.entity.BoardEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private int index;
    private String title;
    private String content;

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .board_index(index)
                .title(title)
                .content(content)
                .build();
    }
}
