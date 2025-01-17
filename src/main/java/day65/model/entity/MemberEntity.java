package day65.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_index;

    @Column(columnDefinition = "varchar(31)", nullable = false, unique = true)
    private String id;

    @Column(columnDefinition = "varchar(63)")
    private String password;

    // 양방향
    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL)
    @Builder.Default // 빌더 사용 시 초기값 설정
    @ToString.Exclude
    private List<BoardEntity> boardEntityList = new ArrayList<>();
}
