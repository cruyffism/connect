package org.zerock.connect.Controller.part1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.connect.Service.part1.ContractItemService;
import org.zerock.connect.Service.part1.ItemService;
import org.zerock.connect.Service.part1.ProcurementPlanService;
import org.zerock.connect.entity.ContractItem;
import org.zerock.connect.entity.Item;
import org.zerock.connect.entity.ProcurementPlan;

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

    
//    조달 계획 등록폼
    @GetMapping("/procurementPlan")
    public String procurementPlan(Model model , ContractItem contractItem,@PageableDefault(size = 7, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
        List<ContractItem> ContractItemList = contractItemService.ContractItemList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), ContractItemList.size());


        List<ContractItem> pageContent = ContractItemList.subList(start, end);
        Page<ContractItem> ContractItemLists = new PageImpl<>(pageContent, pageable, ContractItemList.size());
        model.addAttribute("ContractItemLists", ContractItemLists);


//        List<ContractItem> AllContractItem = contractItemService.findAllContractItemList();
//        model.addAttribute("AllContractItem",AllContractItem);

        return "/part1/ProcurementplanForm";
    }

    @GetMapping("/selectProcurementItem")
    public String selectProcurementItem(@RequestParam("conitemNo") Long conitemNo , Model model ,@PageableDefault(size = 7, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
        List<ContractItem> ContractItemList = contractItemService.ContractItemList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), ContractItemList.size());


        List<ContractItem> pageContent = ContractItemList.subList(start, end);
        Page<ContractItem> ContractItemLists = new PageImpl<>(pageContent, pageable, ContractItemList.size());
        model.addAttribute("ContractItemLists", ContractItemLists);


        List<ContractItem> selectContractItem = contractItemService.selectByConitemNo(conitemNo);
        model.addAttribute("selectContractItem",selectContractItem);
        return "/part1/selectProcurementplanForm";
    }

    @PostMapping("/saveProcurementplan")
    public String saveProcurementplan(@RequestParam("contractitemNo") Long conitemNo , ProcurementPlan procurementPlan) {

        ContractItem selectContractitem = contractItemService.findByConitemNo(conitemNo);
        procurementPlan.setContractItem(selectContractitem);

        ProcurementPlan resultProcurementplan = procurementPlanService.save(procurementPlan);




        return "redirect:/part1/procurementPlan";
    }

}
