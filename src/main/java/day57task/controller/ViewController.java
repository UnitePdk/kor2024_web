package day57task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("")
    public String index() {
        return "/day58/student/index.html";
    }

    @GetMapping("/register")
    public String register() {
        return "/day58/student/register.html";
    }

    @GetMapping("/list")
    public String list() {
        return "/day58/student/list.html";
    }

    @GetMapping("/edit")
    public String edit() {
        return "/day58/student/edit.html";
    }
}
