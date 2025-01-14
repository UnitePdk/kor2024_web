package day62.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_index;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String title;

    @Column(columnDefinition = "longtext", nullable = false)
    private String content;

    @Column(columnDefinition = "varchar(31)", nullable = false)
    private String writer;

    @Column(columnDefinition = "varchar(31)", nullable = false)
    private String password;
}
