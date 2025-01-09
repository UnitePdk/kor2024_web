package day59.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 스프링 메모리에 컨트롤러 빈 주입
public class ViewController {
    @GetMapping("")
    public String index() {
        return "/day59/index.html";
    }

    @GetMapping("/signup")
    public String signup() {
        return "/day59/signup.html";
    }

    @GetMapping("/login")
    public String login() {
        return "/day59/login.html";
    }
}
