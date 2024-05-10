package org.zerock.connect.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
