package org.zerock.connect.Controller.part3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/part3")
public class StockListController {

    //재고현황관리
    @GetMapping("/stockList")
    public String stockList() {
        System.out.println("재고현황관리");
        return "part3/stockList";
    }
}
