package org.zerock.connect.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.connect.Service.Part1Service;
import org.zerock.connect.Service.UploadFileService;
import org.zerock.connect.entity.*;

import java.util.List;

@Controller
@RequestMapping("/part1")
public class Part1Controller {

    @Autowired
    Part1Service part1Service;

    @Autowired
    UploadFileService uploadFileService;



//    Part1_insert_item 품목등록화면
    @GetMapping("/insert_Item")
    public String part1_insert(Model model, @RequestParam("productId")String productId , Product product){

        List<Unit> UnitList = part1Service.findUnitList();
        List<Part> PartList = part1Service.findPartList();
        List<Assy> AssyList = part1Service.findAssyList();

        model.addAttribute("UnitList",UnitList);
        model.addAttribute("PartList",PartList);
        model.addAttribute("AssyList",AssyList);

        List<Item> ItemList = part1Service.findItemList();
        model.addAttribute("ItemList",ItemList);

        System.out.println("선택된 productId : " + productId);

        Product product1 = part1Service.findByProductId(productId);

        model.addAttribute("selectproduct",product1);
        System.out.println(product1);

//        List<Product> AllProductList = part1Service.AllProductlist();
//        System.out.println(AllProductList);
//        model.addAttribute("AllProductList",AllProductList);


        return "/part1_insert_item";
    }



//  신규 품목 등록
//    @PostMapping("/insert_Item_Confirm")
//    public String insert_Item_Confirm(Item item , @RequestParam("file") MultipartFile file){
//
//        Item insertItem = part1Service.saveItem(item);
//
//        String savedFile = uploadFileService.upload(file);
//
//
//
//
//        return "redirect:/part1/insert_Item";
//    }

    @PostMapping("/insert_Item_Confirm")
    public String insert_Item_Confirm(Item item,@RequestParam("file")  MultipartFile file,@RequestParam("productId")String productId,
                                       Model model){


//        System.out.println("insertItem222 = " + insertItem);
//        String savedFile = uploadFileService.upload(file);
//        item.setItemFile(savedFile);
//        Product selectProduct = part1Service.findByProductId(productId);
//        item.setProductId(selectProduct);

        String savedFile = uploadFileService.upload(file);

        item.setItemFile(savedFile);
        Product selectProduct = part1Service.findByProductId(productId);
        item.setProduct(selectProduct);

        Item insertItem = part1Service.saveItem(item);
//
//        List<Item> itemList = part1Service.findItemList();
//        model.addAttribute("itemList",itemList);
        return "redirect:/part1/insert_Item";
    }


//    제품 등록 화면 (Par1_Insert_product)
    @GetMapping("/insert_Product")
    public String insert_Product( Model model){

//      등록된 제품 정보 뷰에서 등록된 제품 정보 리스트 출력
        List<Product> AllProductList = part1Service.AllProductlist();
//        System.out.println(AllProductList);
        model.addAttribute("AllProductList",AllProductList);
        return "part1_insert_product";
    }

    
//    신규 제품 등록
    @PostMapping("/insert_Product_Confirm")
    public String insert_Confirm(Product product ){
//      인서트
        Product InsertProduct = part1Service.saveProduct(product);
//        System.out.println(AllProductList);
        return "redirect:/part1/insert_Product";
    }

//    제품선택화면
    @GetMapping("/select_product")
    public String select_product(Model model){
        List<Product> AllProductList = part1Service.AllProductlist();

        model.addAttribute("AllProductList",AllProductList);

        return "/part1_select_product";
    }

//    @GetMapping("/select_product_confirm")
//    public String select_product_confirm(@RequestParam("productId")String productId , Product product){
//        System.out.println(productId);
//        return "redirect:/part1/insert_Item";
//    }





}
