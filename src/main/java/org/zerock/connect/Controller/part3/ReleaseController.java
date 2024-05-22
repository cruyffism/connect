package org.zerock.connect.Controller.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.connect.Service.part3.ReceiveService;
import org.zerock.connect.Service.part3.ReleasesService;
import org.zerock.connect.entity.Product;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.entity.Releases;
import org.zerock.connect.repository.ReceiveRepository;
import org.zerock.connect.repository.ReleasesRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/part3")
public class ReleaseController {

    @Autowired
    private ReceiveService receiveService;

    @Autowired
    private ReleasesService releasesService;

    @Autowired
    private ReleasesRepository releasesRepository;

    // 출고 리스트 뷰
    @GetMapping("/releaseList")
    public String getAllReleases(Model model) {
        System.out.println("출고관리");

        // 입고 완료 품목
        List<Receive> receiveList = receiveService.getAllReceive();
        model.addAttribute("receiveList", receiveList);

        return "part3/releaseList";
    }

    // 출고수량 저장
    @PostMapping("/saveReleases")
    public String saveRelease(@RequestParam("receiveNum") Long receiveNum, Releases releases,
                              @RequestParam("releaseCount") Integer releaseCount,
                              @RequestParam("releaseDate") String releaseDate,
                              Model model) {

        // 입고 조회
        Receive selectReceive = receiveService.findByReceiveNum(receiveNum);
        selectReceive.setReceiveCount(selectReceive.getReceiveCount() - releaseCount);
        // 출고 저장
        releases.setReceive(selectReceive);
        // 출고테이블 인서트
        Releases resultReleases = releasesService.save(releases);

        return "redirect:/part3/releaseList";
    }




}
