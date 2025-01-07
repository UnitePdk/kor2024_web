package day57;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Lombok {
    public static void main(String[] args) {
        MemberDto m=new MemberDto();
        // MemberDto m1=new MemberDto("qwe1"); // 빈 생성자, 풀 생성자만 만들어줌
        MemberDto m2=new MemberDto("qwe1", "qwer");

        m.setId("qwe1");
        System.out.println(m2.getName());

        System.out.println(m2.toString());

        // 빌더패턴을 사용
        MemberDto m3=MemberDto.builder()
                .id("qwe2")
                .name("qwer2")
                .build();

        System.out.println(m3.toString());
    }


}
