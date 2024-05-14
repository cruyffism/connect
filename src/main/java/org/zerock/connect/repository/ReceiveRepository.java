package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Receive;

@Repository
public interface ReceiveRepository extends JpaRepository<Receive, Long> {


}
