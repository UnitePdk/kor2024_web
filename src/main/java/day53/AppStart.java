package day53;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }

}

@RestController
class day53Controller {
    @PostMapping("/day52")
    public String postMethod() {
        System.err.println("day53Controller.postMethod");
        return "Server Connect POST OK";
    }
    @GetMapping("/day52")
    public String getMethod() {
        System.err.println("day53Controller.getMethod");
        return "Server Connect GET OK";
    }
    @PutMapping("/day52")
    public String putMethod() {
        System.err.println("day53Controller.putMethod");
        return "Server Connect PUT OK";
    }
    @DeleteMapping("/day52")
    public String deleteMethod() {
        System.err.println("day53Controller.deleteMethod");
        return "Server Connect DELETE OK";
    }
}