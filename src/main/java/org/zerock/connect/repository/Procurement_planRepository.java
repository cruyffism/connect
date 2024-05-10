package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Procurement_plan;

@Repository
public interface Procurement_planRepository extends JpaRepository<Procurement_plan, Long> {
}
