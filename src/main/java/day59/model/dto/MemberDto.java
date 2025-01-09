package day59.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MemberDto {
    private int number;
    private String id;
    private String password;
    private String name;
    private String phone;

    public MemberDto(int number, String password, String name, String phone) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
}
