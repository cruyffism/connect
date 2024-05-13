package org.zerock.connect.Controller.part2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/part2")
public class PurchaseOrderController {

    //빈곽 폼 조회
    @GetMapping("/purchaseOrderForm")
    public String purchaseOrderForm(){
        return "/part2/purchaseOrderForm";
    }

    
}
