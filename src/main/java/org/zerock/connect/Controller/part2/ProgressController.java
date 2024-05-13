package org.zerock.connect.Controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/part2")
public class ProgressController {

    @GetMapping("/progressForm")
    public String progressForm(){
        return "/part2/progressForm";
    }
}
