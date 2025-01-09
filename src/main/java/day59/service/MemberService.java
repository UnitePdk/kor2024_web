package day59.service;

import day59.model.dao.MemberDao;
import day59.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 스프링 메모리에 서비스 빈 주입
public class MemberService {
    @Autowired private MemberDao memberDao; // dao의 빈 호출

    public boolean signup(MemberDto memberDto) {
        return memberDao.signup(memberDto);
    }

    public boolean login(String id, String password) {
        return memberDao.login(id, password);
    }
}
