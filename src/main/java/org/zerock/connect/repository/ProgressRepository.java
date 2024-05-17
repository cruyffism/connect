package org.zerock.connect.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Progress;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

 /*   // 진척검수진행중인친구들
    @Query(value = "SELECT P FROM Progress P WHERE P.progressNum  != All (SELECT R.progress.progressNum FROM Receive R )")
    List<Progress> noReceiveList();*/

    @Query(value = "SELECT pr " +
            "FROM Progress pr " +
            "JOIN Orders o ON pr.orders.orderNum=o.orderNum " +
            "JOIN ProcurementPlan plan ON o.procurementPlan.planNum = plan.planNum " +
            "JOIN ContractItem con ON plan.contractItem.conitemNo = con.conitemNo " +
            "JOIN Company comp ON con.company.businessId = comp.businessId " +
            "JOIN Item I ON con.item.itemIndex = I.itemIndex " +
            "JOIN Product P ON I.product.productId = P.productId " +
            "where pr.progressNum != All (select R.progress.progressNum from Receive R)")
    List<Progress> noReceiveList();

}
