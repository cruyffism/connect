package org.zerock.connect.Service.part2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.connect.entity.Orders;
import org.zerock.connect.entity.ProcurementPlan;
import org.zerock.connect.repository.OrdersRepository;
import org.zerock.connect.repository.ProcurementPlanRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseOrderService {
    @Autowired
    ProcurementPlanRepository procurementPlanRepository;

    @Autowired
    OrdersRepository ordersRepository;

    //발주 품목 선택 아작스 구현
    public List<ProcurementPlan> procurementPlanListAjax(String comName, String itemName, LocalDate startDate, LocalDate endDate) {
        return procurementPlanRepository.procurementPlanListAjax(comName, itemName, startDate, endDate);
    }

    //발주 품목 선택 api
    public ProcurementPlan orderChoiceAjax(Long planNum) {
        return procurementPlanRepository.orderChoiceAjax(planNum);
    }

    public List<ProcurementPlan> findPlanList() {
        return procurementPlanRepository.findPlanList();
    }

    //발주 저장 api
    public Orders saveOrder(Orders orders) {
        return ordersRepository.save(orders);
    }
}
