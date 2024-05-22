package org.zerock.connect.Controller.part3;


import jakarta.servlet.http.HttpSession;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.connect.Service.part3.PublishService;
import org.zerock.connect.Service.part3.ReceiveService;
import org.zerock.connect.entity.Member;
import org.zerock.connect.entity.Publish;
import org.zerock.connect.entity.Receive;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/part3")
public class PublishFormController {

    @Autowired
    ReceiveService receiveService;

    @Autowired
    PublishService publishService;


    // 거래명세서발행페이지
    @GetMapping("/publishForm")
    public String publishForm(Model model) {
        System.out.println("입고완료품목");

        // 입고 완료 품목
        List<Receive> receiveList = receiveService.getAllReceive();
        model.addAttribute("receiveList", receiveList);

        System.out.println("거래명세서 발행 완료 리스트");

        List<Publish> publishList = publishService.getAllPublish();
        model.addAttribute("publishList", publishList);

        return "part3/publishForm";
    }

//    @GetMapping("publishSuccess")
//    public String publishSuccess(Model model) {
//        System.out.println("거래명세서 발행 완료 리스트");
//
//        List<Publish> publishList = publishService.getAllPublish();
//        model.addAttribute("publishList", publishList);
//
//        return "part3/publishForm";
//    }


    // 거래명세서 저장 오예성공
    @PostMapping("/savePublish")
    public String savePublish(Publish publish , HttpSession session, @RequestParam("receiveNum") Long receiveNum, RedirectAttributes redirectAttributes) {

//        Receive selectReceive = receiveService.findByReceiveNum(receiveNum);

        // 세션에서 현재 로그인된 사용자 정보 가져오기
        Member loginedUser = (Member) session.getAttribute("loginedUser");

        // receiveNum을 사용하여 해당하는 Receive 객체 가져오기
        Receive receive = receiveService.findByReceiveNum(receiveNum);
        if (receive == null) {
            throw new IllegalArgumentException("Invalid receiveNum: " + receiveNum);
        }

//        // 디버그 로그 추가
//        System.out.println("publish receiveNum: " + publish.getReceive());
//        System.out.println("publish invoiceNumber: " + publish.getInvoiceNumber());
//        System.out.println("publish invoiceDate: " + publish.getInvoiceDate());
//        System.out.println("publish invoiceMemo: " + publish.getInvoiceMemo());
//        System.out.println("publish publisher: " + publish.getPublisher());

        // publish 객체의 receive 필드에 가져온 Receive 객체 설정
        publish.setReceive(receive);
        publish.setInvoiceDate(LocalDate.now());
        publish.setPublisher(loginedUser.getMemberId());

//        // 받아온 publish 객체를 데이터베이스에 저장
//        publishService.save(publish);

        try {
            // 중복 체크를 수행하여 이미 존재하는 receiveNum인지 확인
            publishService.save(publish);
            redirectAttributes.addFlashAttribute("successMessage", "거래명세서를 성공적으로 저장하였습니다.");
            System.out.println("저장성공");
        } catch (IllegalArgumentException e) {
            // 중복이 있을 경우 예외를 받아 처리
            redirectAttributes.addFlashAttribute("errorMessage", "이미 존재하는 receiveNum입니다. 저장을 거부하였습니다.");
            System.out.println("저장실패");
        }

        return "redirect:/part3/publishForm";
    }

//
//    // 완료된 거래명세서 보기
//    @GetMapping("/successModal")
//    public String successModal(Model model) {
//
//    }








}
