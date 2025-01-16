package day64.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String id;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;

    // 양방향: 데이터베이스는 지원하지 않지만 ORM 에서 지원함
    // 보드의 단방향과 관계
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 자바에서만 양방향 사용하는 설정
    @ToString.Exclude
    @Builder.Default
    private List<BoardEntity> boardEntityList = new ArrayList<BoardEntity>();

    // 양방향 참조
    // 리플의 단방향과 관계
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // 자바에서만 양방향 사용하는 설정
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyEntityList = new ArrayList<ReplyEntity>();
}
