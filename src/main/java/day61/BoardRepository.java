package day61;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    // 해당 인터페이스는 BoardEntity 클래스를 조작할 예정.
    // pk 필드인 board_index의 타입인 Integer 작성

}