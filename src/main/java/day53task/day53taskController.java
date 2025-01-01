package day53task;

import org.springframework.web.bind.annotation.*;

@RestController
public class day53taskController {
    @PostMapping("/day53task")
    public String postMethod() {
        System.out.println("day53Controller.postMethod");
        return "POST 메소드 통신 성공";
    }
    @GetMapping("/day53task")
    public String getMethod() {
        System.out.println("day53Controller.getMethod");
        return "GET 메소드 통신 성공";
    }
    @PutMapping("/day53task")
    public String putMethod() {
        System.out.println("day53Controller.putMethod");
        return "PUT 메소드 통신 성공";
    }
    @DeleteMapping("/day53task")
    public String deleteMethod() {
        System.out.println("day53Controller.deleteMethod");
        return "DELETE 메소드 통신 성공";
    }
}
