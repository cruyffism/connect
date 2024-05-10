package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.ProcurementPlan;

@Repository
public interface ProcurementPlanRepository extends JpaRepository<ProcurementPlan, Long> {
}
