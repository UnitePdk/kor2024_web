package day56;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56/rest4")
public class RestController4 {

    @GetMapping("") // [GET] http://localhost:8080/day56/rest4?key1=v1&key2=v2
    public boolean getRest4(@RequestParam String key1, @RequestParam String key2) {
        System.out.println("RestController4.getRest4"); // soutm
        System.out.println("key1 = " + key1 + ", key2 = " + key2); // soutp
        return true; // 응답: Content-Type: application/json (@RestController(@ResponseBody)에서 자동으로 설정함)
    }
    @GetMapping("/dto") // [GET] http://localhost:8080/day56/rest4/dto?key1=v1&key2=v2
    public boolean getRest4_1(RestDto restDto) {
        // 쿼리스트링의 매개변수명과 DTO의 멤버변수명이 동일하면 자동으로 매개변수가 주입된다
        // 생성자를 꼭 필수로 만들어야 한다
        System.out.println("RestController4.getRest4_1");
        System.out.println("restDto = " + restDto);
        return true;
    }
    @PostMapping("") // [POST] http://localhost:8080/day56/rest4 [body: {"key1":"v1","key2":"v2"}]
    public String postRest4(RestDto restDto) {
        System.out.println("RestController4.postRest4");
        System.out.println("restDto = " + restDto);
        return "응답있음";
    }

}
