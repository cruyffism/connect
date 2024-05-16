package org.zerock.connect.Controller.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.connect.Service.part3.ReceiveService;
import org.zerock.connect.Service.part3.ReleasesService;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.entity.Releases;

import java.util.List;

@Controller
@RequestMapping("/part3")
public class ReleaseController {

    @Autowired
    private ReceiveService receiveService;

    @Autowired
    private ReleasesService releasesService;

    //출고관리
    @GetMapping("/releaseList")
    public String getAllReleases(Model model) {
        System.out.println("출고관리");

        // 입고 완료 품목
/*        List<Receive> receiveList = receiveService.getAllReceive();
        model.addAttribute("receiveList", receiveList);*/

        List<Releases> releasesList = releasesService.getAllReleases();
        model.addAttribute("releasesList", releasesList);

        return "part3/releaseList";
    }


}
