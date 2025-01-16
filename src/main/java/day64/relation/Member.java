package day64.relation;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Member {
    private int index;
    private String id;
    private String name;

    @Builder.Default // 빌더 패턴 사용시 초기값이 대입되지 않는 멤버변수에 대해 초기값 자동 대입
    @ToString.Exclude
    List<Board> writtenBoards=new ArrayList<>();
    // 양방향 참조 주의할점: 순환참조 주의
    // 해결방안: ToString 없애기 또는 참조한 멤버변수만 ToString을 사용하지 않음

    @Builder.Default
    @ToString.Exclude
    List<Comment> writtenComments=new ArrayList<>();
}
