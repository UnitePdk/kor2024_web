package day56;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestController1 {

    @GetMapping("/day56/rest1")
    @ResponseBody
    public String getRest1() {
        return "rest1";
    } // func end

    @PostMapping("/day56/rest1")
    @ResponseBody
    public String postRest1() {
        return "postRest1";
    } // func end

    @PutMapping("/day56/rest1")
    @ResponseBody
    public String putRest1() {
        return "putRest1";
    } // func end

    @DeleteMapping("/day56/rest1")
    @ResponseBody
    public String deleteRest1() {
        return "deleteRest1";
    } // func end
} // class end
