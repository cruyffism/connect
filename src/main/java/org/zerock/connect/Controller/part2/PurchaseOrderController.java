package org.zerock.connect.Controller.part2;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.connect.Controller.part1.CompanyController;
import org.zerock.connect.Service.part2.PurchaseOrderService;
import org.zerock.connect.entity.Company;
import org.zerock.connect.entity.ProcurementPlan;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/part2")
@Slf4j //로그찍기
public class PurchaseOrderController {

    Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    PurchaseOrderService purchaseOrderService;

    //빈곽 폼 조회
    @GetMapping("/purchaseOrderForm")
    public String purchaseOrderForm() {
        return "/part2/purchaseOrderForm";
    }

    //조달계획리스트 아작스 구현
    @GetMapping("/procurementPlanListAjax")
    public String procurementPlanListAjax(@RequestParam("searchText") String searchText,
                                          @RequestParam("searchType") String searchType,
                                          @RequestParam("startDate") LocalDate startDate,
                                          @RequestParam("endDate") LocalDate endDate,
                                          Model model,
                                          @PageableDefault(size = 5, sort = "comName", direction = Sort.Direction.ASC) Pageable pageable) {

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());

        //동적 쿼리 만들기 위해 서치타입이 comName 이면 comName에다가 넘어온 searchText 값을 넣어서 만들어주기
        String comName = "";
        String itemName = "";
        if(searchType.equals("comName")){
            comName = searchText;
        }
        if(searchType.equals("itemName")){
            itemName = searchText;
        }

        List<ProcurementPlan> procurementPlanList = purchaseOrderService.procurementPlanListAjax(comName, itemName, startDate, endDate);
        int start = (int) pageable.getOffset();//페이지러블 객체에서 알아서 나오는거 >> 사이즈 5으로 설정 싯 페이지를 1로 넘기면 1페이지에 1~10나옴(size가 10이니까) 2면(11~20)
        int end = Math.min((start + pageable.getPageSize()), procurementPlanList.size()); // 5을 계산한 구문

        logger.info("companyList : {}", procurementPlanList);

        List<ProcurementPlan> pageContent = procurementPlanList.subList(start, end); // 데이터가 30개 쌓여있으면  1~10, 11~20, 21~30 이렇게 짤라라
        Page<ProcurementPlan> procurementPlan = new PageImpl<>(pageContent, pageable, procurementPlanList.size()); //현재페이지의 보여줄 리스트, 페이지러블 객체, 전체 리스트 개수(예를 들면 글 30개)
        model.addAttribute("procurementPlanList", procurementPlan);//리스트 객체를 페이징 처리 후  보냄

        return "/part2/procurementPlanListAjax";
    }

}
