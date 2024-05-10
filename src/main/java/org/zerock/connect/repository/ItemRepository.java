package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
