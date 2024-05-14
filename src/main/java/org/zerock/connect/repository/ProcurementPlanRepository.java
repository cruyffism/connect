package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.ProcurementPlan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProcurementPlanRepository extends JpaRepository<ProcurementPlan, Long> {

    //발주 품목 선택 아작스 구현
    @Query("select p,i,ci,c from Item i inner join ProcurementPlan p on i.itemIndex = p.item.itemIndex " +
            "inner join ContractItem ci on i.itemIndex= ci.item.itemIndex " +
            "inner join Company c on ci.company.businessId = c.businessId " +
            "where p.planDate between :startDate and :endDate and c.comName like concat('%',:comName,'%') and i.itemName like concat('%',:itemName,'%')")
    List<ProcurementPlan> procurementPlanListAjax(@Param("comName") String comName, @Param("itemName") String itemName, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
