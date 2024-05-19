package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Progress;
import org.zerock.connect.entity.Receive;

import java.util.List;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Long> {


    // 입고 예정 품목 리스트 아작스
    @Query("select r,o,p,ci,c,i from Receive r " +
            "inner join Orders o on r.orders.orderNum = o.orderNum " +
            "inner join ProcurementPlan p on o.procurementPlan.planNum = p.planNum " +
            "inner join ContractItem ci on p.contractItem.conitemNo = ci.conitemNo " +
            "inner join Company c on ci.company.businessId = c.businessId " +
            "inner join Item i on ci.item.itemIndex = i.itemIndex " +
            "where r.receiveYn =:receiveYn and i.itemCode like concat('%', :itemCode, '%') and i.itemName like concat('%',:itemName,'%') ")
    List<Receive> getReceiveListAjax(@Param("itemCode") String itemCode, @Param("itemName") String itemName, @Param("receiveYn") String receiveYn);

    List<Receive> findByReceiveYn(String receiveYn);

    // 입고 버튼 api
    @Modifying
    @Query("update Receive set receiveYn = 'Y' where receiveNum =:receiveNum")
    Integer receive(@Param("receiveNum") Long receiveNum);

    //입고 예정 삭제
    @Modifying
    @Query("delete from Receive r where r.orders.orderNum =:orderNum")
    Integer deleteReceive(@Param("orderNum") Long orderNum);

    @Query("select r,o,p,ci,c,i from Receive r " +
            "inner join Orders o on r.orders.orderNum = o.orderNum " +
            "inner join ProcurementPlan p on o.procurementPlan.planNum = p.planNum " +
            "inner join ContractItem ci on p.contractItem.conitemNo = ci.conitemNo " +
            "inner join Company c on ci.company.businessId = c.businessId " +
            "inner join Item i on ci.item.itemIndex = i.itemIndex " +
            "where r.receiveYn ='Y'")
    List<Receive> getAllReceive();

}
