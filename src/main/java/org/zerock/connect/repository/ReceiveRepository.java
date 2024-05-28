package org.zerock.connect.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zerock.connect.Service.part3.ReleasesDTO;
import org.zerock.connect.entity.Receive;
import org.zerock.connect.entity.Releases;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Long> {

    List<Receive> findByReceiveYn(String receiveYn);

    // 입고 예정 품목 리스트 아작스
    @Query("select r,o,p,ci,c,i from Receive r " +
            "inner join Orders o on r.orders.orderNum = o.orderNum " +
            "inner join ProcurementPlan p on o.procurementPlan.planNum = p.planNum " +
            "inner join ContractItem ci on p.contractItem.conitemNo = ci.conitemNo " +
            "inner join Company c on ci.company.businessId = c.businessId " +
            "inner join Item i on ci.item.itemIndex = i.itemIndex " +
            "where r.receiveYn =:receiveYn and i.itemCode like concat('%', :itemCode, '%') and i.itemName like concat('%',:itemName,'%') ")
    List<Receive> getReceiveListAjax(@Param("itemCode") String itemCode, @Param("itemName") String itemName, @Param("receiveYn") String receiveYn);


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


    Receive findByReceiveNum(Long receiveNum);

    @Query(value = "select count(r) from Receive r where r.receiveYn = 'N'")
    int findByreceiveN();

    @Query(value = "select count(r) from Receive r where r.receiveYn = 'Y'")
    int findByreceiveY();


//    @Query(value = "SELECT r,re,o " +
//            "FROM Receive r JOIN Releases re ON r.receiveNum=re.receive.receiveNum " +
//            "JOIN Orders o ON re.receive.orders.orderNum=o.orderNum " +
//            "GROUP BY o.procurementPlan.planNum")

    @Query("select " +
            "new org.zerock.connect.Service.part3.ReleasesDTO" +
            "(r.receive.orders.procurementPlan.planNum, sum(r.receive.receiveCount),sum(r.releaseCount) , r.receive.orders.procurementPlan, r.receive.orders.procurementPlan.contractItem ,r.receive.orders.procurementPlan.contractItem.item, r.receive.orders.procurementPlan.contractItem.item.product , r.receive) " +
            "from Releases r " +
            "group by r.receive.orders.procurementPlan.planNum")
    List<ReleasesDTO> findReleaseSummaries();


    @Query("select " +
            "new org.zerock.connect.Service.part3.ReleasesDTO" +
            "(r.receive.orders.procurementPlan.planNum,sum(r.receive.receiveCount) ,sum(r.releaseCount) , r.receive.orders.procurementPlan, r.receive.orders.procurementPlan.contractItem ,r.receive.orders.procurementPlan.contractItem.item, r.receive.orders.procurementPlan.contractItem.item.product , r.receive) " +
            "from Releases r " +
            "where r.releaseDate between :startDate and :endDate " +
            "group by r.receive.orders.procurementPlan.planNum")
    List<ReleasesDTO> searchDateStockList(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT u.unitName, SUM(r.releaseCount * c.contractPrice) as totalAmount " +
            "FROM Releases r " +
            "JOIN Receive re ON r.receive.receiveNum = re.receiveNum " +
            "JOIN Orders o ON re.orders.orderNum = o.orderNum " +
            "JOIN ProcurementPlan p ON o.procurementPlan.planNum = p.planNum " +
            "JOIN ContractItem c ON p.contractItem.conitemNo = c.conitemNo " +
            "JOIN Item i ON c.item.itemIndex = i.itemIndex " +
            "JOIN Unit u ON i.unit.unitCode = u.unitCode " +
            "GROUP BY u.unitCode")

//    @Query(value = "select r from Releases r group by r.receive.orders.procurementPlan.planNum")
    List<Object[]> groupbyUnitcode();

    @Query(value = "SELECT a.assyName, SUM(r.releaseCount * c.contractPrice) as totalAmount " +
            "FROM Releases r " +
            "JOIN Receive re ON r.receive.receiveNum = re.receiveNum " +
            "JOIN Orders o ON re.orders.orderNum = o.orderNum " +
            "JOIN ProcurementPlan p ON o.procurementPlan.planNum = p.planNum " +
            "JOIN ContractItem c ON p.contractItem.conitemNo = c.conitemNo " +
            "JOIN Item i ON c.item.itemIndex = i.itemIndex " +
            "JOIN Assy a ON i.assy.assyCode = a.assyCode " +
            "GROUP BY a.assyCode")

//    @Query(value = "select r from Releases r group by r.receive.orders.procurementPlan.planNum")
    List<Object[]> groupbyAssycode();

    @Query(value = "SELECT part.partName, SUM(r.releaseCount * c.contractPrice) as totalAmount " +
            "FROM Releases r " +
            "JOIN Receive re ON r.receive.receiveNum = re.receiveNum " +
            "JOIN Orders o ON re.orders.orderNum = o.orderNum " +
            "JOIN ProcurementPlan p ON o.procurementPlan.planNum = p.planNum " +
            "JOIN ContractItem c ON p.contractItem.conitemNo = c.conitemNo " +
            "JOIN Item i ON c.item.itemIndex = i.itemIndex " +
            "JOIN Part part ON i.part.partCode = part.partCode " +
            "GROUP BY part.partCode")

//    @Query(value = "select r from Releases r group by r.receive.orders.procurementPlan.planNum")
    List<Object[]> groupbyPartcode();

    @Query("SELECT r FROM Receive r WHERE r.receiveNum NOT IN (SELECT p.receive.receiveNum FROM Publish p)")
    List<Receive> findReceiveNotInPublish();


    // 거래명세서 페이지 - 입고완료품목 - 검색
    @Query("select r,o,p,ci,c,i from Receive r " +
            "join Orders o on r.orders.orderNum = o.orderNum " +
            "join ProcurementPlan p on o.procurementPlan.planNum = p.planNum " +
            "join ContractItem ci on p.contractItem.conitemNo = ci.conitemNo " +
            "join Company c on ci.company.comName = c.comName " +
            "join Item i on ci.item.itemName = i.itemName AND ci.item.itemIndex = i.itemIndex " +
            "where r.receiveYn ='Y'")
    List<Receive> searchReceive();

    @Query("SELECT r FROM Receive r WHERE r.orders.procurementPlan.contractItem.company.comName LIKE %:keyword%")
    List<Receive> searchReceiveByCompanyName(String keyword);

    @Query("SELECT r FROM Receive r WHERE r.orders.procurementPlan.contractItem.item.itemName LIKE %:keyword%")
    List<Receive> searchReceiveByItemName(String keyword);



}


