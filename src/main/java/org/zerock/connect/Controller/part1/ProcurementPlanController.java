package org.zerock.connect.Controller.part1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.connect.Service.part1.ContractItemService;
import org.zerock.connect.Service.part1.ItemService;
import org.zerock.connect.Service.part1.ProcurementPlanService;
import org.zerock.connect.entity.ContractItem;
import org.zerock.connect.entity.Item;

import java.util.List;

@Controller
@RequestMapping("/part1")
public class ProcurementPlanController {

    @Autowired
    ProcurementPlanService procurementPlanService;

    @Autowired
    ContractItemService contractItemService;

    @Autowired
    ItemService itemService;

    @GetMapping("procurementPlan")
    public String procurementPlan(Model model , ContractItem contractItem,@PageableDefault(size = 7, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());

        List<Item> NocontractItem = itemService.NocontractItem();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), NocontractItem.size());


        List<Item> pageContent = NocontractItem.subList(start, end);

        Page<Item> NocontractItems = new PageImpl<>(pageContent, pageable, NocontractItem.size());

        model.addAttribute("NocontractItems", NocontractItems);




        List<ContractItem> AllContractItem = contractItemService.findAllContractItemList();
        model.addAttribute("AllContractItem",AllContractItem);

        return "/part1/ProcurementplanForm";
    }

}
