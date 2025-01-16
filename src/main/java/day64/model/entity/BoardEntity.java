package day64.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "board")
@DynamicInsert
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_id;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String content;

    @Column(columnDefinition = "int")
    @ColumnDefault("0")
    private int view;

    // 단방향 참조
    @JoinColumn(name="member_index")
    @ManyToOne // 다수가 하나에게
    private MemberEntity memberEntity;

    // 양방향 참조
    // 리플의 단방향과 관계
    @OneToMany(mappedBy = "boardEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // getReply 할 때 댓글 데이터를 가져온다.
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> commentEntities = new ArrayList<ReplyEntity>();
}

/*
부모에다가 넣는 cascade, fetch 옵션
cascade = cascadeType.ALL: 부모가 삭제/수정/저장되면 자식도 같이 삭제/수정/저장
cascade = cascadeType.REMOVE: 부모가 삭제되면 자식도 같이 삭제
cascade = cascadeType.MERGE: 부모가 수정되면 자식도 같이 수정
cascade = cascadeType.PERSIST: 부모가 저장되면 자식도 같이 저장
cascade = cascadeType.REFRESH: 부모가 수정되면 자식 값이 새로고침됨
cascade = cascadeType.DETACH: 영속성(연관관계) 제거

fetch = FetchType.EAGER: 즉시 로딩(기본값), find 함수 사용할때 참조되는 모든 객체를 불러온다
    - 불필요한 엔티티를 가져올 수 있음
fetch = FetchType.LAZY: 지연 로딩, get 할때 참조 객체를 불러옴. (메모리 효율적)
    - 초기 로딩 후에는 빠르다.
*/