package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 20)
    private Long itemIndex;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productId" ,nullable = false)
    private Product productId;


    @ManyToOne
    @JoinColumn(name = "unitCode",nullable = false)
    private  Unit unitCode;

    @ManyToOne
    @JoinColumn(name = "assyCode" , nullable = false)
    private Assy assyCode;

    @ManyToOne
    @JoinColumn(name = "partCode" , nullable = false)
    private Part partCode;

    @Column(nullable = false , length = 30)
    private String itemCode;

    @Column(nullable = false ,length = 100)
    private String itemName;

    @Column(nullable = false , length = 50)
    private int itemLength;

    @Column(nullable = false , length = 50)
    private int itemWidth;

    @Column(nullable = false , length = 50)
    private int itemHeight;

    @Column(nullable = false , length = 50)
    private String itemMaterial;

    @Column(nullable = false , length = 200)
    private String itemFile;



//    @OneToMany(mappedBy = "con_item_no")
//    private List<Contract_item> contractItems;

    @OneToMany(mappedBy = "itemIndex")
    private List<ProcurementPlan> procurementPlans = new ArrayList<>();


    @OneToMany(mappedBy = "itemIndex")
    private List<ContractItem> contractItems = new ArrayList<>();

    public Long getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(Long itemIndex) {
        this.itemIndex = itemIndex;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Unit getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(Unit unitCode) {
        this.unitCode = unitCode;
    }

    public Assy getAssyCode() {
        return assyCode;
    }

    public void setAssyCode(Assy assyCode) {
        this.assyCode = assyCode;
    }

    public Part getPartCode() {
        return partCode;
    }

    public void setPartCode(Part partCode) {
        this.partCode = partCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemLength() {
        return itemLength;
    }

    public void setItemLength(int itemLength) {
        this.itemLength = itemLength;
    }

    public int getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(int itemWidth) {
        this.itemWidth = itemWidth;
    }

    public int getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
    }

    public String getItemMaterial() {
        return itemMaterial;
    }

    public void setItemMaterial(String itemMaterial) {
        this.itemMaterial = itemMaterial;
    }

    public String getItemFile() {
        return itemFile;
    }

    public void setItemFile(String itemFile) {
        this.itemFile = itemFile;
    }

    public List<ProcurementPlan> getProcurementPlans() {
        return procurementPlans;
    }

    public void setProcurementPlans(List<ProcurementPlan> procurementPlans) {
        this.procurementPlans = procurementPlans;
    }

    public List<ContractItem> getContractItems() {
        return contractItems;
    }

    public void setContractItems(List<ContractItem> contractItems) {
        this.contractItems = contractItems;
    }
}
