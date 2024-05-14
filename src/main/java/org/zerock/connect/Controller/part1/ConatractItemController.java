package org.zerock.connect.Controller.part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.connect.Service.UploadFileService;
import org.zerock.connect.Service.part1.CompanyService;
import org.zerock.connect.Service.part1.ContractItemService;
import org.zerock.connect.Service.part1.ItemService;
import org.zerock.connect.entity.Company;
import org.zerock.connect.entity.ContractItem;
import org.zerock.connect.entity.Item;

import java.time.LocalDateTime;
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

    @Autowired
    UploadFileService uploadFileService;

    @GetMapping("/contractItem")
    public String contractItem(Company company , Item item , Model model ,@PageableDefault(size = 10, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){
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

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
        List<ContractItem> contractitemList = contractItemService.findAllContractItemList();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), contractitemList.size());

        List<ContractItem> pageContent = contractitemList.subList(start, end);
        Page<ContractItem> contractItems = new PageImpl<>(pageContent, pageable, contractitemList.size());
        model.addAttribute("contractitemList", contractItems);

        return "/part1/contractForm";
    }


//
//@GetMapping("/contractitemListAjax")
//public String contractitemListAjax(@RequestParam(value = "conitemNo", required=false) Long conitemNo, Model model,
//                                   @PageableDefault(size = 10, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable) {
//
//    int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
//    pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
//    List<ContractItem> contractitemList = contractItemService.findAllContractItemList();
//    int start = (int) pageable.getOffset();
//    int end = Math.min((start + pageable.getPageSize()), contractitemList.size());
//
//    List<ContractItem> pageContent = contractitemList.subList(start, end);
//    Page<ContractItem> contractItems = new PageImpl<>(pageContent, pageable, contractitemList.size());
//    model.addAttribute("contractitemList", contractItems);
//    return "/part1/contractYes";
//}

//    계약안된 품목 출력
//    @GetMapping("/NocontractItemListAjax")
//    public String NocontractItem(Item item , ContractItem contractItem,Model model,
//                                 @PageableDefault(size = 10, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){
//
//        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
//        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
//        List<Item> NocontractItem = itemService.NocontractItem();
//        int start = (int) pageable.getOffset();
//        int end = Math.min((start + pageable.getPageSize()), NocontractItem.size());
//
//        List<Item> pageContent = NocontractItem.subList(start, end);
//        Page<Item> NocontractItems = new PageImpl<>(pageContent, pageable, NocontractItem.size());
//        model.addAttribute("NocontractItems", NocontractItems);
//
//
//        System.out.println(NocontractItem);
//        return "/part1/contractNo";
//    }


    @GetMapping("/NocontractItem")
    public String NocontractItem(Company company , Item item , Model model ,@PageableDefault(size = 7, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){
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

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
        List<Item> NocontractItem = itemService.NocontractItem();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), NocontractItem.size());

        List<Item> pageContent = NocontractItem.subList(start, end);
        Page<Item> NocontractItems = new PageImpl<>(pageContent, pageable, NocontractItem.size());
        model.addAttribute("NocontractItems", NocontractItems);

        return "/part1/NocontractForm";
    }

//   제품선택하기
    @GetMapping("selectContractItem")
    public String selectContractItem(@RequestParam("selectItemIndex")Long itemIndex , Model model ,@PageableDefault(size = 7, sort = "conitemNo", direction = Sort.Direction.ASC) Pageable pageable){
        System.out.println(itemIndex);

        Item selectItem = itemService.findByItemIndex(itemIndex);
        model.addAttribute("selectItem",selectItem);

        List<Company> AllCompany = companyService.findAllCompany();
        model.addAttribute("AllCompany",AllCompany);
        System.out.println(AllCompany);


        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, pageable.getPageSize(), pageable.getSort());
        List<Item> NocontractItem = itemService.NocontractItem();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), NocontractItem.size());

        List<Item> pageContent = NocontractItem.subList(start, end);
        Page<Item> NocontractItems = new PageImpl<>(pageContent, pageable, NocontractItem.size());
        model.addAttribute("NocontractItems", NocontractItems);
        return "/part1/selectcontractForm";
    }

    @PostMapping("/saveContractitem")
    public String saveContractitem(@RequestParam("itemIndex") Long itemIndex , @RequestParam(value = "CompanyId") String businessId , ContractItem contractItem , @RequestParam("file")MultipartFile file){

        Item selectItem = itemService.findByItemIndex(itemIndex);
        contractItem.setItem(selectItem);

//        Company selectCompany = companyService.findByBusinessId(businessId);
//        Company company = new Company();
//        company.setBusinessId(businessId);
//        contractItem.setCompany(company);

        Company selectCompany = companyService.findByBusinessId(businessId);
        contractItem.setCompany(selectCompany);

        String savedFile = uploadFileService.upload(file);
        contractItem.setContractFile(savedFile);

        contractItem.setContractDate(LocalDateTime.now());
        contractItem.setContractYn("1");



        ContractItem resultContract = contractItemService.saveContractItem(contractItem);


        return "redirect:/part1/contractItem";
    }

}
