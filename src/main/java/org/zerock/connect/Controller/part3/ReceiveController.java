package org.zerock.connect.Controller.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.connect.Service.part3.ProgressService;
import org.zerock.connect.Service.part3.ReceiveService;
import org.zerock.connect.entity.Progress;
import org.zerock.connect.entity.Receive;

import java.util.List;

@Controller
@RequestMapping("/part3")
public class ReceiveController {

    @Autowired
    ReceiveService receiveService;

    @Autowired
    ProgressService progressService;

    @GetMapping("/receiveList")
    public String getReceiveList(Model model) {
        System.out.println("입고 관리");

        // 입고 완료 품목
        List<Receive> receiveList = receiveService.getAllReceive();
        model.addAttribute("receiveList", receiveList);

        // 입고 예정 품목
        List<Progress> progressList = progressService.noReceiveList();
        model.addAttribute("progressList",progressList);

        System.out.println(progressList);

        return "part3/receiveList"; // 해당 뷰로 이동
    }

}