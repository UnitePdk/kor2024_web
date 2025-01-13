package day61task.service;

import day61task.model.entity.MemberEntity;
import day61task.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public boolean signup(String id, String password) {
        // 엔티티 생성
        MemberEntity memberEntity=new MemberEntity();
        memberEntity.id=id;
        memberEntity.password=password;

        // 생성한 엔티티를 DB에 저장
        memberRepository.save(memberEntity);

        return true;
    }

    public List<MemberEntity> findAll() {
        List<MemberEntity> list = memberRepository.findAll();
        return list;
    }
}
