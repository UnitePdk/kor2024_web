package day56homework;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day56/member")
public class MemberController {
    // 회원가입
    @PostMapping("signup")
    public boolean signup(@RequestBody MemberDto memberDto) {
        System.out.println("memberDto = " + memberDto.toString());

        // dao에 회원가입 객체 전달 후 문제없이 생성되었다면 true를 가져옴
        boolean success = true;

        if(success) return true; // 회원가입 성공시 true를 뷰에 전달해 유저에게 가입성공을 알림
        else return false;
    }

    // 로그인
    @PostMapping("login")
    public boolean login(@RequestBody MemberDto memberDto) {
        System.out.println("memberDto = " + memberDto.toString());

        // dao에 로그인 객체 전달 후 목록에 있으면 true를 가져옴
        boolean success = true;

        if(success) return true; // 로그인 성공시 true를 뷰에 전달해 접속을 허용함
        else return false;
    }

    // 회원 수정
    @PutMapping("update")
    public boolean update(@RequestBody MemberDto memberDto) {
        System.out.println("memberDto = " + memberDto.toString());

        // dao에 회원정보 수정 객체를 전달해서 성공시 true를 가져옴
        boolean success = true;

        if(success) return true; // 수정 성공시 true를 뷰에 전달해 수정성공을 알림
        else return false;
    }

    // 내 정보 보기
    @GetMapping("info")
    public MemberDto info(@RequestParam int index) {
        System.out.println("index = " + index);

        // dao에 현재 로그인 멤버의 인덱스 전달 후 그 인덱스의 레코드를 객체로 만들어 받아옴
        MemberDto member = new MemberDto();

        return member; // 로그인 멤버의 객체를 뷰에 전달
    }

    // 회원 삭제
    @DeleteMapping("delete")
    public boolean delete(@RequestParam int index) {
        System.out.println("index = " + index);

        // dao에 현재 로그인 멤버의 인덱스 전달 후 삭제함. 성공 시 true를 가져옴
        boolean success = true;

        if(success) return true; // 삭제 성공시 true를 뷰에 전달해서 성공을 알림
        else return false;
    }
}
