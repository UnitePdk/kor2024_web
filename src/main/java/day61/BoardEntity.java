package day61;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class BoardEntity {
    @Id
    private int board_index;
    @Column
    private String board_title;
    @Column
    private String board_content;
}
