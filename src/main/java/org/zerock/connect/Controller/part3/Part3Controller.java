package org.zerock.connect.Controller.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.connect.Service.part3.ReceiveService;
import org.zerock.connect.entity.Progress;
import org.zerock.connect.entity.Receive;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/part3")
public class Part3Controller {

    @Autowired
    ReceiveService receiveService;

    @GetMapping("/receiveList")
    public String getReceiveList(Model model, @RequestParam(value = "receiveYn", defaultValue = "0") String receiveYn) {
        System.out.println("(입고 관리) receiveYn = " + receiveYn);
        List<Receive> receiveList = receiveService.getReceiveListByReceiveYn(receiveYn);
        model.addAttribute("receiveList", receiveList);
        return "part3/receiveList"; // 해당 뷰로 이동
    }

    //출고관리
    @GetMapping("/releaseList")
    public String releaseList() {
        System.out.println("출고관리");
        return "part3/releaseList";
    }

    //거래명세서발행
    @GetMapping("/publishForm")
    public String publishForm() {
        System.out.println("거래명세서 발행");
        return "part3/publishForm";
    }

    //재고현황관리
    @GetMapping("/stockList")
    public String stockList() {
        System.out.println("재고현황관리");
        return "part3/stockList";
    }


}
