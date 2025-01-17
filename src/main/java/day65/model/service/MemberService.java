package day65.model.service;

import day65.model.dto.BoardDto;
import day65.model.entity.BoardEntity;
import day65.model.entity.MemberEntity;
import day65.model.repository.BoardRepository;
import day65.model.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public List<BoardDto> writtenBoardList(int memberIndex) {

        // Optional 클래스: null 값을 포함할 수 있는 객체
        // get(): Optional 객체의 값을 반환
        // isPresent: 값 존재 여부를 판단
        // JPA의 findById() 함수는 Optional을 반환함

        Optional<MemberEntity> optionalMember = memberRepository.findById(memberIndex); // 지정된 회원을 찾고

        if (optionalMember.isPresent()) {
            MemberEntity member = optionalMember.get(); // null 아닌게 확인되면
            List<BoardEntity> boardEntityList = member.getBoardEntityList(); // 양방향으로 설정된 게시물 조회


/*
            // 고전 for 문
            List<BoardDto> list = new ArrayList<>();
            for (int i = 0; i < boardEntityList.size(); i++) {
                BoardEntity boardEntity = boardEntityList.get(i);
                BoardDto boardDto = boardEntity.toDto();
                list.add(boardDto);
            } // for end
*/
/*
            // forEach
            List<BoardDto> list = new ArrayList<>();
            boardEntityList.forEach(boardEntity -> {
                list.add(boardEntity.toDto());
            }); // forEach end
*/
            // map
            return boardEntityList.stream().map(BoardEntity::toDto).collect(Collectors.toList());
        } // if end
        return null;
    } // func end

    @Transactional
    public boolean writeBoard(BoardDto boardDto) {
        int loginIndex=1; // 임시 로그인 인덱스

        Optional<MemberEntity> optionalMember = memberRepository.findById(loginIndex); // 현재 회원 정보를 가져와서
        if (optionalMember.isEmpty()) { // 비어있으면 종료
            return false;
        }

        MemberEntity member = optionalMember.get(); // 꺼내고

        BoardEntity boardEntity = boardDto.toEntity(); // 게시물 dto -> entity

        boardEntity.setMemberEntity(member); // 게시물 엔티티에 회원 엔티티 넣기

        BoardEntity saveEntity = boardRepository.save(boardEntity); // 엔티티 저장

        return saveEntity.getBoard_index()!=0; // 성공하면 true, 실패하면 false
    }
}
