package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Orders;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    //발주 리스트 아작스 구현
    @Query("select o,p,ci,i,c,r from Orders o " +
            "inner join ProcurementPlan p on o.procurementPlan.planNum = p.planNum " +
            "inner join ContractItem ci on p.contractItem.conitemNo = ci.conitemNo " +
            "inner join Item i on ci.item.itemIndex = i.itemIndex " +
            "inner join Company c on ci.company.businessId = c.businessId " +
            "left join Receive r on o.orderNum = r.orders.orderNum " +
            "where p.planNum =:planNum and o.orderDate between :startDate and :endDate and c.comName like concat('%', :comName, '%') and i.itemName like concat('%',:itemName,'%')")
    List<Orders> orderListAjax(@Param("comName") String comName, @Param("itemName") String itemName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("planNum") Long planNum);

    //발주 리스트 전체 조회
    @Query("select o,p,ci,i,c from Orders o " +
            "inner join ProcurementPlan p on o.procurementPlan.planNum = p.planNum " +
            "inner join ContractItem ci on p.contractItem.conitemNo = ci.conitemNo " +
            "inner join Item i on ci.item.itemIndex = i.itemIndex " +
            "inner join Company c on ci.company.businessId = c.businessId " +
            "left join Receive r on o.orderNum = r.orders.orderNum " +
            "where p.planNum =:planNum and c.comName like concat('%', :comName, '%') and i.itemName like concat('%',:itemName,'%')")
    List<Orders> findOrderList(@Param("planNum") Long planNum, @Param("comName") String comName, @Param("itemName") String itemName);

    //발주 마감 아작스 API
    @Modifying
    @Query("update Orders set orderYn = 'Y' where orderNum =:orderNum")
    Integer orderDeadlineAjax(@Param("orderNum")Long orderNum);

    //발주서 삭제 AJAX api
    @Modifying
    @Query("delete from Orders where orderNum =:orderNum")
    Integer deleteOrderAjax(@Param("orderNum")Long orderNum);

    @Query(value = "select count(o) from Orders o")
    int findAllorderscount();
}
