package day62.service;

import day62.model.BoardEntity;
import day62.model.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    @Transactional
    public boolean write(BoardEntity boardEntity) {
        boardRepository.save(boardEntity);
        return true;
    }

    @Transactional
    public List<BoardEntity> printAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public BoardEntity printOne(int id) {
        return boardRepository.findById(id).get();
    }

    @Transactional
    public boolean edit(BoardEntity boardEntity) {
        BoardEntity editEntity=boardRepository.findById(boardEntity.getBoard_index()).get();
        editEntity.setTitle(boardEntity.getTitle());
        editEntity.setContent(boardEntity.getContent());
        return true;
    }

    @Transactional
    public boolean delete(int id) {
        boardRepository.deleteById(id);
        return true;
    }
}
