package org.zerock.connect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.*;
import org.zerock.connect.repository.*;

import java.util.List;

@Service
public class Part1Service {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UnitRepository unitRepository;

    @Autowired
    PartRepository partRepository;

    @Autowired
    AssyRepository assyRepository;

    @Autowired
    ItemRepository itemRepository;

    public Product findByProductId(String productId) {
        return productRepository.findByProductId(productId);
    }

    public Product findByProductCount(int productCount){
        return productRepository.findByProductCount(productCount);
    }

    public List<Product> AllProductlist(){
        return productRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Unit> findUnitList(){
        return unitRepository.findAll();
    }
    public List<Part> findPartList(){
        return partRepository.findAll();
    }
    public List<Assy> findAssyList(){
        return assyRepository.findAll();
    }

    public List<Item> findItemList(){
        return itemRepository.findAll();
    }

}
