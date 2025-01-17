package day65.controller;

import day65.model.dto.BoardDto;
import day65.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/info/board/findall")
    public List<BoardDto> writtenBoardList(@RequestParam int member_index) {
        return memberService.writtenBoardList(member_index);
    }

    @PostMapping("/info/board/write")
    public boolean writeBoard(@RequestBody BoardDto boardDto) {
        return memberService.writeBoard(boardDto);
    }
}
