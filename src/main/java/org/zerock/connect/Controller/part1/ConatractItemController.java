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
import org.zerock.connect.Service.part1.CompanyService;
import org.zerock.connect.Service.part1.ContractItemService;
import org.zerock.connect.Service.part1.ItemService;
import org.zerock.connect.entity.Company;
import org.zerock.connect.entity.ContractItem;
import org.zerock.connect.entity.Item;

import java.util.List;

@Controller
@RequestMapping("/part1")
public class ConatractItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    CompanyService companyService;

    @Autowired
    ContractItemService contractItemService;

    @GetMapping("/contractItem")
    public String contractItem(Company company , Item item , Model model ){
//      모든 업체 리스트 출력
        List<Company> AllCompany = companyService.findAllCompany();
        model.addAttribute("AllCompany",AllCompany);

//      등록된 품목정보 출력(계약 여부) 계약 x
//        List<Item> AllItem = itemService.findItemList();
//        model.addAttribute("AllItem",AllItem);

//      등록된 품목정보 출력(계약 여부) 계약 o
//        List<ContractItem> AllContractItem = contractItemService.findContractItemList();
//        model.addAttribute("AllContractItem",AllContractItem);

//        List<ContractItem> AllContractItem = contractItemService.findAllContractItemList();
//        model.addAttribute("AllContractItem",AllContractItem);

        return "/part1/contractForm";
    }


//
@GetMapping("/contractitemListAjax")
public String contractitemListAjax(@RequestParam(value = "conitemNo", required=false) Long conitemNo, Model model,
                                   @PageableDefault(size = 10, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable) {

    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
    pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
    List<ContractItem> contractitemList = contractItemService.findAllContractItemList();
    int start = (int) pageable.getOffset();
    int end = Math.min((start + pageable.getPageSize()), contractitemList.size());

    List<ContractItem> pageContent = contractitemList.subList(start, end);
    Page<ContractItem> contractItems = new PageImpl<>(pageContent, pageable, contractitemList.size());
    model.addAttribute("contractitemList", contractItems);
    return "/part1/contractYes";
}

//    계약안된 품목 출력
    @GetMapping("/NocontractItemListAjax")
    public String NocontractItem(Item item , ContractItem contractItem,Model model,
                                 @PageableDefault(size = 10, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
        List<Item> NocontractItem = itemService.NocontractItem();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), NocontractItem.size());

        List<Item> pageContent = NocontractItem.subList(start, end);
        Page<Item> NocontractItems = new PageImpl<>(pageContent, pageable, NocontractItem.size());
        model.addAttribute("NocontractItems", NocontractItems);


        System.out.println(NocontractItem);
        return "/part1/contractNo";
    }


    @GetMapping("/NocontractItem")
    public String NocontractItem(Company company , Item item , Model model ){
//      모든 업체 리스트 출력
        List<Company> AllCompany = companyService.findAllCompany();
        model.addAttribute("AllCompany",AllCompany);

//      등록된 품목정보 출력(계약 여부) 계약 x
//        List<Item> AllItem = itemService.findItemList();
//        model.addAttribute("AllItem",AllItem);

//      등록된 품목정보 출력(계약 여부) 계약 o
//        List<ContractItem> AllContractItem = contractItemService.findContractItemList();
//        model.addAttribute("AllContractItem",AllContractItem);

//        List<ContractItem> AllContractItem = contractItemService.findAllContractItemList();
//        model.addAttribute("AllContractItem",AllContractItem);

        return "/part1/NocontractForm";
    }

//   제품선택하기
//    @PostMapping("selectContractItem")
//    public String selectContractItem(@RequestParam("")){
//        return "";
//    }
}
