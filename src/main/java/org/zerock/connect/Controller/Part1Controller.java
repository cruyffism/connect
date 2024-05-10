package org.zerock.connect.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.connect.Service.Part1Service;
import org.zerock.connect.entity.Product;

import java.util.List;

@Controller
@RequestMapping("/Part1")
public class Part1Controller {

    @Autowired
    Part1Service part1Service;

    @GetMapping("insert_Item")
    public String part1_insert(Product product){
//        List<Product> Alllist = part1Service.selectProduct();

        System.out.println("Part1 품목등록 페이지");
        return "/part1_Insert_item";
    }
}
