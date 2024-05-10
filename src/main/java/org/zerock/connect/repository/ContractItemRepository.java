package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.ContractItem;

@Repository
public interface ContractItemRepository extends JpaRepository <ContractItem, Long> {
}
