package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Contract_item;

@Repository
public interface Contract_itemRepository extends JpaRepository <Contract_item, Long> {
}
