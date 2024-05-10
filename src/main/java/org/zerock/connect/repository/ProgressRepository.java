package org.zerock.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Progress;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
