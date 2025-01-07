package day57;

import lombok.*;

@NoArgsConstructor // 디폴트 생성자 코드 주입
@AllArgsConstructor // 모든 매개변수 생성자 코드 주입
@Getter // getter 코드 주입
@Setter // setter 코드 주입
@ToString // toString 코드 주입
@Builder // 빌더 패턴 메소드 지원
public class MemberDto {
    private String id;
    private String name;
}
