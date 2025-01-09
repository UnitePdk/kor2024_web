package day59.controller;

import day59.model.dto.MemberDto;
import day59.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // 스프링 메모리에 RC 빈 주입
public class MemberController {
    // 객체를 반환하는 메소드를 모아둔 클래스 - @ResponseBody

    @Autowired
    private MemberService memberService;

    @PostMapping("/signup.do")
    public boolean signup(@RequestBody MemberDto memberDto) {

        return memberService.signup(memberDto);
    }

    @GetMapping("/login.do")
    public boolean login(@RequestParam String id, @RequestParam String password) {
        return memberService.login(id, password);
    }
}
