package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
