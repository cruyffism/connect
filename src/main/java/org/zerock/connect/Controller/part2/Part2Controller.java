package org.zerock.connect.Controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Part2")
public class Part2Controller {

    @GetMapping("purchase_order")
    public String purchases_order(){
        return "/part2_purchase_order";
    }
}
