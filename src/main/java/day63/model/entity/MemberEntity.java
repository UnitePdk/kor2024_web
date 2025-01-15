package day63.model.entity;

import day63.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "member")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int member_index;

    @Column(columnDefinition = "varchar(31)", nullable = false, unique = true)
    private String id;

    @Column(columnDefinition = "varchar(31)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(15)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(13)", nullable = false, unique = true)
    private String phone;

    public MemberDto toDto() {
        return MemberDto.builder().member_index(member_index).id(id).name(name).phone(phone).build();
    }
}
