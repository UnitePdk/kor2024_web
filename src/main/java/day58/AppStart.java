package day58;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}
@Controller
// Rest는 자원을 전달, 안쓰면 화면을 전달 - 타임리프 템플릿을 렌더링해줌
class ViewController {
    @GetMapping("") // @ResponseBody 금지
    public String index() {
        return "/day58/index.html";
    } // func end

    @GetMapping("/layout")
    public String layout() {
        return "/day58/layout/index.html";
    } // func end

    // 학생관리 시스템 메인 페이지
    @GetMapping("/student")
    public String student() {
        return "/day58/student/index.html";
    } // func end

    // 학생 등록 페이지
    @GetMapping("/student/register")
    public String register() {
        return "/day58/student/register.html";
    } // func end

    // 전체 학생 점수 조회 페이지
    @GetMapping("/student/list")
    public String list() {
        return "/day58/student/list.html";
    } // func end
    
    // 개별 학생 점수 조회 페이지
    @GetMapping("/student/info")
    public String info() {
        return "/day58/student/info.html";
    } // func end
    
    // 학생 점수 수정 페이지
    @GetMapping("/student/edit")
    public String edit() {
        return "/day58/student/edit.html";
    } // func end
    
    // 학생 정보 삭제 페이지
    @GetMapping("/student/delete")
    public String delete() {
        return "/day58/student/delete.html";
    } // func end
} // class end