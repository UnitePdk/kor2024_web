package day56homework;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int index;
    private String id;
    private String password;
    private String name;
    private String phone;
}
