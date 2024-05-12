package org.zerock.connect.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@DynamicUpdate
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false , length = 20)
    private Long itemIndex;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "productId" ,nullable = false)
    private Product product;


    @ManyToOne
    @JoinColumn(name = "unitCode",nullable = false)
    private  Unit unit;

    @ManyToOne
    @JoinColumn(name = "assyCode" , nullable = false)
    private Assy assy;

    @ManyToOne
    @JoinColumn(name = "partCode" , nullable = false)
    private Part part;

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

    @OneToMany(mappedBy = "item")
    private List<ProcurementPlan> procurementPlans = new ArrayList<>();


    @OneToMany(mappedBy = "item")
    private List<ContractItem> contractItems = new ArrayList<>();

    public Long getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(Long itemIndex) {
        this.itemIndex = itemIndex;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Assy getAssy() {
        return assy;
    }

    public void setAssy(Assy assy) {
        this.assy = assy;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
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
