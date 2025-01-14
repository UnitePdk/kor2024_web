package day62.controller;

import day62.model.BoardEntity;
import day62.service.BoardService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/write.do")
    public boolean write(@RequestBody BoardEntity boardEntity) {
        return boardService.write(boardEntity);
    }

    @GetMapping("/printAll.do")
    public List<BoardEntity> printAll() {
        return boardService.printAll();
    }

    @GetMapping("/printOne.do")
    public BoardEntity printOne(@RequestParam int id) {
        return boardService.printOne(id);
    }

    @Transactional
    @PutMapping("/edit.do")
    public boolean edit(@RequestBody BoardEntity boardEntity) {
        return boardService.edit(boardEntity);
    }

    @DeleteMapping("/delete.do")
    public boolean delete(@RequestParam int id) {
        return boardService.delete(id);
    }
}
