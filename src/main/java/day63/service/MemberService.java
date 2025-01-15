package day63.service;

import day63.model.dto.MemberDto;
import day63.model.entity.MemberEntity;
import day63.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(MemberDto memberDto) {
        MemberEntity memberEntity = memberDto.toEntity();

        MemberEntity saveEntity=memberRepository.save(memberEntity);

        return saveEntity.getMember_index() != 0;
    }

    public List<MemberDto> list() {
        List<MemberEntity> entityList=memberRepository.findAll();

        List<MemberDto> list = new ArrayList<>();
        for (int i=0; i<entityList.size(); i++) {
            MemberEntity entity = entityList.get(i);
            list.add(entity.toDto());
        }
        return list;
    } // func end
}
