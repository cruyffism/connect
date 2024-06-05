package org.zerock.connect.Controller.part2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.connect.Service.part1.ContractItemService;
import org.zerock.connect.Service.part1.ProcurementPlanService;
import org.zerock.connect.Service.part2.OrdersService;
import org.zerock.connect.Service.part3.ReceiveService;
import org.zerock.connect.entity.Orders;
import org.zerock.connect.entity.ProcurementPlan;
import org.zerock.connect.entity.Receive;

import java.util.List;


@Controller
@RequestMapping("/part2")
public class GraphController {

    @Autowired
    ProcurementPlanService procurementPlanService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ReceiveService receiveService;

    @Autowired
    ContractItemService contractItemService;


    @GetMapping("/graph")
    public String graph(ProcurementPlan procurementPlan, Orders orders, Receive receive, Model model) {
//수령입고수
        int receiveYcount = receiveService.findByreceiveY();
        System.out.println(receiveYcount);
        model.addAttribute("receiveYcount", receiveYcount);

//진척검수 진행중
        int progresscount = receiveService.progresscount()-receiveYcount;
        System.out.println(progresscount);
        model.addAttribute("receiveNcount", progresscount);


//발주가능품목수
        int ordersListCount = ordersService.findAllorderscount()-progresscount-receiveYcount;
        System.out.println(ordersListCount);
        model.addAttribute("ordersListCount", ordersListCount);


//계약완료된 품목수
        int procurementPlanListCount = contractItemService.countContractItemcount();
        System.out.println(procurementPlanListCount);
        model.addAttribute("procurementPlanListCount", procurementPlanListCount);

        return "/part2/GraphForm";
    }
}
