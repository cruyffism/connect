package org.zerock.connect.Controller.part3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.connect.Service.part3.ReleasesService;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.entity.Releases;

import java.util.List;

@Controller
@RequestMapping("/part3")
public class StockListController {

    @Autowired
    ReleasesService releasesService;

    //재고현황관리
    @GetMapping("/stockList")
    public String getAllStockList(Model model) {
        System.out.println("재고현황관리");

        List<Releases> releasesList = releasesService.getAllReleases();
        model.addAttribute("releasesList", releasesList);

        return "part3/stockList";
    }




}
