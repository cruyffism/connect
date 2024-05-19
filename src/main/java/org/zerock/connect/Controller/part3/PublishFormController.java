package org.zerock.connect.Controller.part3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/part3")
public class PublishFormController {

    //거래명세서발행
    @GetMapping("/publishForm")
    public String publishForm() {
        System.out.println("거래명세서 발행");
        return "part3/publishForm";
    }
}
