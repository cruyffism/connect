package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Receive;

import java.util.List;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Long> {

    List<Receive> findByReceiveYn(String receiveYn);

    @Query(value = "SELECT r " +
            "FROM Receive r join Progress pr on r.progress.progressNum = pr.progressNum " +
            "JOIN Orders o ON pr.orders.orderNum=o.orderNum " +
            "JOIN ProcurementPlan plan ON o.procurementPlan.planNum = plan.planNum " +
            "JOIN ContractItem con ON plan.contractItem.conitemNo = con.conitemNo " +
            "JOIN Company comp ON con.company.businessId = comp.businessId " +
            "JOIN Item I ON con.item.itemIndex = I.itemIndex " +
            "JOIN Product P ON I.product.productId = P.productId ")
    List<Receive> getAllReceive();


    Receive findByReceiveNum(Long receiveNum);
}
