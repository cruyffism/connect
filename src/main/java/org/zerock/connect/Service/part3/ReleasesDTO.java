package org.zerock.connect.Service.part3;


import org.zerock.connect.entity.*;


public class ReleasesDTO {

    private Long planNum;
    private Long totalOrderCount;

    private ProcurementPlan procurementPlan;

    private ContractItem contractItem;

    private Item item;

    private Product product;

    private Releases releases;

    public ReleasesDTO(Long planNum, Long totalOrderCount, ProcurementPlan procurementPlan, ContractItem contractItem, Item item, Product product, Releases releases) {
        this.planNum = planNum;
        this.totalOrderCount = totalOrderCount;
        this.procurementPlan = procurementPlan;
        this.contractItem = contractItem;
        this.item = item;
        this.product = product;
        this.releases = releases;
    }

    public Long getPlanNum() {
        return planNum;
    }

    public void setPlanNum(Long planNum) {
        this.planNum = planNum;
    }

    public Long getTotalOrderCount() {
        return totalOrderCount;
    }

    public void setTotalOrderCount(Long totalOrderCount) {
        this.totalOrderCount = totalOrderCount;
    }

    public ProcurementPlan getProcurementPlan() {
        return procurementPlan;
    }

    public void setProcurementPlan(ProcurementPlan procurementPlan) {
        this.procurementPlan = procurementPlan;
    }

    public ContractItem getContractItem() {
        return contractItem;
    }

    public void setContractItem(ContractItem contractItem) {
        this.contractItem = contractItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Releases getReleases() {
        return releases;
    }

    public void setReleases(Releases releases) {
        this.releases = releases;
    }
}
