package day65.model.entity;

import day65.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_index;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @Column(columnDefinition = "longtext", nullable = false)
    private String content;

    // 단방향 (member -> board)
    @ManyToOne
    @JoinColumn(name = "member_index")
    private MemberEntity memberEntity;

    // entity -> dto
    public BoardDto toDto() {
        return BoardDto.builder()
                .index(board_index)
                .title(title)
                .content(content)
                .build();
    }
}
