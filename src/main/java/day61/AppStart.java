package day61;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AppStart {

    @Autowired
    static BoardRepository boardRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);

        // 엔티티로 인스턴스 생성
        BoardEntity boardEntity1=new BoardEntity(1, "제목1", "내용1");
        BoardEntity boardEntity2=new BoardEntity(2, "제목2", "내용2");

        // 모든 엔티티 호출 함수
        boardRepository.findAll();

        // 엔티티를 테이블에 저장하는 함수
        boardRepository.save(boardEntity1);
        boardRepository.save(boardEntity2);

        List<BoardEntity> list=boardRepository.findAll();
    }
}
