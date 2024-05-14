package org.zerock.connect.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.connect.entity.Progress;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, Long> {

    // progressNum에 따라 입고 예정 또는 입고 완료 리스트를 가져오는 메서드
    List<Progress> findByProgressNum(Long progressNum);

}
