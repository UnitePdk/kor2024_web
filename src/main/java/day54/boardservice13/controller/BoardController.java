package day54.boardservice13.controller;

import day54.boardservice13.model.dao.BoardDao;
import day54.boardservice13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController // 이 클래스에 rest api가 가능한 클래스임을 주입함
public class BoardController {
    // 싱글톤 필요 없음
    // http://localhost:8080/day55/boardview.html

    // 게시물 작성: CRUD-C, POST
    // POST: http://localhost:8080/write
    // HEADERS: Content-Type: application/json
    // BODY: {title: "", content: "", writer: "", password: ""}
    @PostMapping("/write")
    public boolean write(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.write");
        System.out.println("boardDto = " + boardDto);
        boolean result = BoardDao.getInstance().write(boardDto);
        return result;
    }

    // 게시물 전체 조회: CRUD-R, GET
    @GetMapping("/findall")
    public ArrayList<BoardDto> findAll(){
        System.out.println("findall함수");
        ArrayList<BoardDto> list = BoardDao.getInstance().findAll();
        return list;
    }

    // 게시물 개별 조회: CRUD-R, GET
    // GET: http://localhost:8080/findone?id=1
    @GetMapping("/findone")
    public BoardDto findOne(@RequestParam int id){
        System.out.println("BoardController.findOne");
        System.out.println("id = " + id);
        BoardDto result = BoardDao.getInstance().findOne(id);
        return result;
    }

    // 게시물 수정: CRUD-U, PUT, BODY
    // PUT: http://localhost:8080/update
    @PutMapping("/update")
    public boolean update(@RequestBody BoardDto boardDto){
        System.out.println("BoardController.update");
        System.out.println("boardDto = " + boardDto);
        boolean result = BoardDao.getInstance().update(boardDto);
        return result;
    }

    // 게시물 삭제: CRUD-D, DELETE
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int index){
        System.out.println("BoardController.delete");
        System.out.println("index = " + index);
        boolean result = BoardDao.getInstance().delete(index);
        return result;
    }
}
