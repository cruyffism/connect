package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
