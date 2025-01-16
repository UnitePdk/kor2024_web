package day64.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name = "reply")
@DynamicInsert
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ReplyEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reply_id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String content;

    // 단방향 참조
    // 멤버의 양방향과 관계
    @JoinColumn(name="member_index")
    @ManyToOne // 다수가 하나에게
    private MemberEntity memberEntity;

    // 단방향 참조
    // 보드의 양방향과 관계
    @JoinColumn(name="board_index")
    @ManyToOne // 다수가 하나에게
    private BoardEntity boardEntity;
}
