package org.zerock.connect.Controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.connect.entity.Member;

@Controller
@RequestMapping("/Con")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String login(){
        System.out.println("로그인페이지 이동");
        return "/login";
    }

    @PostMapping("/login")
    // @RequestParam String memberDep,
    public String login(@RequestParam String memberId, @RequestParam String memberPw, Model model) {
        // 로그인 처리
        boolean loginResult = memberService.login(memberId, memberPw);
        String memberDep = memberService.getMemberDep(memberId); // memberId에 해당하는 member_dep 가져오기

        if(loginResult) {
            // 로그인 성공
            System.out.println("로그인 성공");
            if ("1".equals(memberDep)) {
                // member_dep가 1인 경우
                return "redirect:/Con/main_product";
            } else if ("2".equals(memberDep)) {
                // member_dep가 2인 경우
                return "redirect:/Con/main";
            } else {
                // member_dep가 다른 경우
                return "redirect:/Con/main";
            }
        } else {
            // 로그인 실패 시
            System.out.println("로그인 실패");
            model.addAttribute("error", true); // 에러 메시지 전달
            return "/login"; // 다시 로그인 페이지로 이동
        }
    }

    @GetMapping("/main")
    public String mainPage(){
        System.out.println("메인페이지");
        return "/main"; // main.html 페이지로 이동
    }
    @GetMapping("/main_product")
    public String mainProductPage(){
        System.out.println("part0페이지");
        return "/main_product"; // main.html 페이지로 이동
    }


}
