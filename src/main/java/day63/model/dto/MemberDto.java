package day63.model.dto;

import day63.model.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private int member_index;
    private String id;
    private String password;
    private String name;
    private String phone;
    private String cdate;
    private String udate;

    // Dto - > entity
    public MemberEntity toEntity() {
        return MemberEntity.builder()
                .member_index(member_index)
                .id(id)
                .password(password)
                .name(name)
                .phone(phone)
                .build();
    }
}
