package org.zerock.connect.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Con")
public class MemberController {

    @GetMapping("/login")
    public String login(){
        System.out.println("로그인페이지 이동");
        return "/login";
    }

}
