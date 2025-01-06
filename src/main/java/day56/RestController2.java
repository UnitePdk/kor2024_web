package day56;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestController2 {
    @GetMapping("/day56/rest2")
    public String[] getRest2() {
        return new String[]{"hello client","GET rest2"};
    }

    @PostMapping("day56/rest2")
    public String[] postRest2(){
        return new String[]{"hello client","POST rest2"};
    }

    @PutMapping("/day56/rest2")
    public String[] putRest2(){
        return new String[]{"hello client","PUT rest2"};
    }

    @DeleteMapping("/day56/rest2")
    public String[] deleteRest2(){
        return new String[]{"hello client","DELETE rest2"};
    }
}
